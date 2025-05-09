import { useEffect, useState } from "react";
import { Link, useParams, useSearchParams } from "react-router-dom";

function PostList(){
	let [list,setList] = useState([]);	//배열
	let [pm, setPm] = useState({});	//객체
	let [boards, setBoards] = useState([]);	//배열
	let {num} = useParams();	//객체
	let [searchParams] = useSearchParams();		//?뒤에 오는애들 가져오는 함수
	let page = searchParams.get("page") || 1;

	useEffect(()=>{
		getPostList();

	}, [num, page]);				//[num] 값이 바뀔 때마다 렌더링

	function getPostList(){
		fetch("/api/react/post/list?po_bo_num="+num+"&page=" + page)			//렌더링 될때마다 세번 딱딱딱 되니 불편... 이럴때 useEffect
		.then(res=>res.json())
		.then(res=>{
			//console.log(res);
			setList(res.list);
			setPm(res.pm);
			setBoards(res.boardList);		//컨트롤러에 이름 맞춰야
		});
	}
	return(
		<div className="container">
			<h1>게시글 목록</h1>
			<div className="mb-3">
				<Link className={"btn btn"+(num == 0 ? "" : "-outline")+"-danger me-2"} to={"/post/list/0"}>전체</Link>
				{
					boards.map(board=>{
						return <Link className={"btn btn" + ( num == board.bo_num ? "" : "-outline")+"-success me-2"} to={"/post/list/"+board.bo_num} key={board.bo_num}>{board.bo_name}</Link>
					})
				}
				<div>
					<table className="table table-striped table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
								<th>추천/비추천</th>
							</tr>
						</thead>
						<tbody>
							{
								list.length != 0 ? 

								list.map(post=>{
									return(
										<tr key={post.po_num}>
											<td>{post.po_num}</td>
											<td>
												<Link to={"/post/detail/" + post.po_num}>{post.po_title}</Link>
											</td>
											<td>{post.po_me_id}</td>
											<td>{new Date(post.po_date).toLocaleDateString()}</td>			{/* 날짜는 밀리초 형식으로 받기 때문에 재가공이 필요 */}
											<td>{post.po_view}</td>
											<td>{post.po_up}/{post.po_down}</td>
										</tr>
									)
								}) : (
									<tr>
										<th colSpan={6}>등록된 게시글이 없습니다.</th>
									</tr>
								)
							}
							
						</tbody>
					</table>

				</div>
				<div>
					<ul className="pagination justify-content-center">
						{
							pm.prev ? (
								<li className="page-item">
									<Link className="page-link" to={"/post/list/"+num+"?page="+(pm.startPage-1)}>이전</Link>
								</li>
							) : null
						}
						{
							Array.from({length : pm.endPage - pm.startPage + 1}, (_,i)=> pm.startPage+i).map(i =>{
								//page-item 뒤에 공백 있어야 색깔 제대로 들어감
								return (
									<li className={"page-item " + (i== pm.cri.page?"active" : "")} key={i}>		
									<Link className="page-link" to={"/post/list/"+num+"?page="+i}>{i}</Link>
									</li>
								)
							})
						}
						{
							pm.next ? (
								<li className="page-item">
									<Link className="page-link" to={"/post/list/"+num+"?page="+(pm.endPage+1)}>다음</Link>
								</li>
							) : null
						}
						


					</ul>
				</div>
			</div>
		</div>


	)



}

export default PostList;