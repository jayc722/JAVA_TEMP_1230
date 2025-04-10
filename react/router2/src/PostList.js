import { useState } from "react";
import { Link, useParams } from "react-router-dom";

function PostList(){
	let [list,setList] = useState([]);	//배열
	let [pm, setPm] = useState({});	//객체
	let [boards, setBoards] = useState([]);	//배열
	let {num} = useParams();	//객체

	fetch("api/react/post/list?po_bo_num="+num)
	.then(res=>res.json())
	.then(res=>{
		//console.log(res);
		setList(res.list);
		setPm(res.pm);
		setBoards(res.boardList);		//컨트롤러에 이름 맞춰야
	});
	return(
		<div>
			<h1>게시글 목록</h1>
			<div>
				{
					boards.map(board=>{
						return <Link to={"/post/list/"+board.bo_num} key={board.bo_num}>{board.bo_name}</Link>
					})
				}
				<div>
					<table>
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
								list.map(post=>{
									return(
										<tr key={post.po_num}>
											<td>{post.po_num}</td>
											<td>{post.po_title}</td>
											<td>{post.po_me_id}</td>
											<td>{post.po_date}</td>
											<td>{post.po_view}</td>
											<td>{post.po_up}/{post.po_down}</td>
										</tr>
									)
								})
							}
							
						</tbody>
					</table>

				</div>

				<Link></Link>
			</div>
		</div>


	)



}

export default PostList;