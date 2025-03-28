<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
</head>

<body>

		<div class="comment-list">
		
			<c:forEach items="${list}" var="comment">
			<div class="<c:if test="${comment.co_num != comment.co_ori_num }">pl-5</c:if>">
				<div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
					<c:choose>
						<c:when test="${comment.co_del eq 'N' }">
							<div class="comment-wrap">
								<div class="comment-writer">${comment.co_me_id}</div>
								<div class="comment-content">${comment.co_content }</div>
							</div>
							<div class="comment-func mt-2">
								<c:if test="${comment.co_num == comment.co_ori_num }">
									<button class="btn btn-outline-success btn-reply" data-num="${comment.co_num}">답글</button>
								</c:if>
								<c:if test="${comment.co_me_id == user.me_id }">
									<button class="btn btn-outline-warning btn-update" data-num="${comment.co_num}">수정</button>
									<button class="btn btn-outline-danger btn-delete" data-num="${comment.co_num}">삭제</button>
								</c:if>
							</div>
						</c:when>
						<c:otherwise>
							<div>작성자에 의해 삭제된 댓글입니다.</div>
						</c:otherwise>
					</c:choose>
				</div> 
			</div>
		</c:forEach>	
			
		<c:if test="${list.size() == 0}">
			<div class="text-center">등록된 댓글이 없습니다</div>
		</c:if>
		</div>
		<div class="comment-pagination">
			<ul class="pagination justify-content-center">
				<c:if test="${pm.prev}">
					
					<li class="page-item">
						<a class="page-link" href="javaScript:void(0);" data-page="${pm.startPage-1}" >이전</a>
					</li>
					
				</c:if>
				<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
					<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
						<a class="page-link" href="javaScript:void(0);" data-page="${i}" >${i}</a>
					</li>
				</c:forEach>	
				<c:if test="${pm.next}">	
					<li class="page-item">
						<a class="page-link" href="javaScript:void(0);" data-page="${pm.endPage+1}" >다음</a>
					</li>
				</c:if>
			</ul>
		</div>
		
		<div class="comment-pagination"></div>
		<div class="comment-insert-box">
			<form class="input-group mb-3 insert-form" action="<c:url value="/comment/insert"/>" method="post">
				<input type="hidden" name="co_po_num" value="${pm.cri.search}">
			    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
				<button class="btn btn-outline-success">댓글 등록</button>				    
			</form>
		</div>

	<!-- 댓글 목록 조회 -->
	<!-- 
	<script type="text/javascript">
	/*겹치는 애들 접어놓기 위해 여기에 다 넣어놓으려고 따로 뺌*/
		function getCommentList(cri){		//cri는 나중에 쓸거라 호출할때 지금은 일단 넣지는 않을 예정
			//ajax로 댓글 리스트를 가져와 화면에 출력
			$.ajax({
				async : true, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/comment/list"/>', 
				type : 'post', 
				data : JSON.stringify({
					search : '${post.po_num}'	//검색어로 대체
					
				}),			//여기에 객체 들어갈 거기 때문에일단 빈 객체로 
				contentType : "application/json; charset=utf-8",
				dataType : "json", 
				success : function (data){
					//console.log(data);
					let list = data.list;//리스트로 보임
					/*for(comment of list){
						console.log(comment);//댓글 하나하나 꺼내서 보여줌
					}*/
					drawCommentList(list);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			
			
		}
		function drawCommentList(list){
			
			if(list.length == 0){
				$(".comment-list").html(`<div class="text-center mb-3" >등록된 댓글이 없습니다.</div>`);
				return;
			}
			
			let str = '';
			for(comment of list){
				let btns = '';
				let replyBtn = '';
				let padding = '';
				
				//  회원이 댓글or답글 작성자이면 수정&삭제버튼 추가
				if(comment.co_me_id == '${user.me_id}'){
					btns = `
						<button class="btn btn-outline-warning">수정</button>
						<button class="btn btn-outline-danger">삭제</button>
					`;
					
				}

				// 댓글이면 답글 버튼 추가
				if(comment.co_num == comment.co_ori_num){
					replyBtn = `<button class="btn btn-outline-success btn-reply" data-num="\${comment.co_num}">답글</button>`
					// 밑에 있던 답글 버튼 그대로 잘라옴
					
				}
				// 답글이면 왼쪽 패딩 추가
				else{
					padding = 'pl-5';	// 패딩 left 5
				}
				
				str += `
					<div class="\${padding}">	
						<div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
							<div class="comment-wrap">
								<div class="comment-writer">\${comment.co_me_id}</div>
								<div class="comment-content">\${comment.co_content}</div>
							</div>
							<div class="comment-func mt-2">
								\${replyBtn}
								\${btns}
							</div>
						</div>
					</div>
				`
			}
			$(".comment-list").html(str);
			
		}
	
	
		getCommentList();
	
	</script>
	
	-->

	<!-- 댓글 등록 (클릭이벤트 등록) -->
	<script type="text/javascript">
		//$(".insert-form").submit(function(e){
		$(document).off("submit", ".insert-form")
		$(document).on("submit", ".insert-form", function(e){
			e.preventDefault();		//서버로 전송하지 말라고 ->비동기통신할거기때문에
			
			if('${user.me_id}' == ''){		//로그인 안했으면(빈문자열)
				if(confirm("로그인이 필요한 서비스입니다. \n로그인 페이지로 이동하시겠습니까?")){
					location.href = "<c:url value="/login"/>";
				}
				return false;
			}
			//let content = $("[name=co_content]").val().trim();
			let $obj = $(this).find("[name=co_content]");		//	focus 하기위해 분리. 객체변수라 $obj로 표시($안붙여도 문제 없지만 알아보기 편하라고)
			let content = $obj.val().trim();		//
			
			if(content == ''){
				alert("댓글 내용을 입력해 주세요.");
				$obj.focus();				//이거 위해 분리
				return false;
			}
			/*
			let formData =$(this).serialize();		// serialize : form태그 안에 있는 input들을 직렬화
			console.log(formData);	//(안에 있는 내용들이 and연산자로 묶임)
			*/
			
			let co_ori_num = $(this).find("[name=co_ori_num]").val();
			let co_po_num = $(this).find("[name=co_po_num]").val();
			let co_content = $(this).find("[name=co_content]").val();
			/*
			let obj = {						//vo로 한꺼번에 못 받으니 묶어서 보내려고
					co_po_num : $("[name=co_po_num]").val(),
					co_content : $("[name=co_content]").val()
			}*/
			let obj = {
					co_po_num : co_po_num,
					co_content : co_content,
					co_ori_num : co_ori_num	== 'undefined' ? 0 : co_ori_num	//일반 댓글 때문에
			}
			//console.log(obj);
			let url = ($(this).attr("action"));
			$.ajax({
				async : false, //비동기 : true(비동기), false(동기)
				url : url, 
				type : 'post', 
				data : JSON.stringify(obj), 
				contentType : "application/json; charset=utf-8",
				//dataType : "json", 
				success : function (data){					//boolean으로 받으려고.. 대부분 여기까지오면 성공하지만 로그인 한지 오래돼서 세션 만료된 상태로 글 작성 하려 하면 실패하게
					//console.log(data);
					if(data){
						alert("댓글을 등록했습니다.");
						getCommentList(cri); //댓글등록 한 뒤 입력한 댓글 가져오려고
					}else{
						alert("댓글을 등록하지 못했습니다.");
					}
					$obj.val("");			//댓글 등록 후 기존 입력 내용 지우기
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
				
			
			console.log(obj);
			console.log(JSON.stringify(obj));
			return false;
		});
	
	</script>
	
	<!-- 답글 등록 (클릭이벤트 등록) -->
	<script type="text/javascript">
	/*
		$(".btn-reply").click(function(e){
			alert(1);//얘가 btn-reply 등록 이벤트보다 먼저 실행(비동기실행으로 등록되기때문에) -> 이벤트 등록 안됨
		});*/
		$(document).off("click", ".btn-reply")
		$(document).on("click", ".btn-reply", function(e){	//요소가 아니라 문서에 이벤트 등록
			//alert(1);
			let co_num = $(this).data("num");		
			
			if($(this).parent().next().length != 0) return; //답글 입력창 하나 나와있으면 더이상 추가 x
			let str = `
				<form class="input-group mb-3 insert-form reply mt-2" action="<c:url value="/comment/insert"/>" method="post">
					<input type="hidden" name="co_ori_num" value="\${co_num}">
					<input type="hidden" name="co_po_num" value="${pm.cri.search}"><!-- search에 게시글 번호 있음--> 	
				    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
					<button class="btn btn-outline-primary">답글 등록</button>				    
				</form>
			`
			$(this).parent().after(str);
		});
		
	
	
	</script>
	
	<!-- 삭제 등록 -->
	<script type="text/javascript">
		$(".btn-delete").click(function(e){
			//alert(1);	
			// 어제는 이벤트는 고정인데 요소를 ajax로 계속 지웠다가 덮어쓰기 해서 이벤트를 document에 등록해야 했지만 
			// 이번 코드는 이벤트랑 요소랑 묶어서 list.jsp로 만들어서 지울때도 같이 지우고 추가할때도 같이 추가해서 그냥 이벤트추가로도 잘 작동함
			// 사실 답글등록 클릭이벤트 같은거도 이제는 그냥 .click 만 해도 되는데 그냥 귀찮으니 내버려둠
			let co_num = $(this).data("num");
			//alert(co_num);
			
			$.ajax({
				async : true, //true(비동기)
				url : "<c:url value="/comment/delete"/>", 
				type : 'post', 
				data : {co_num : co_num},	//댓글 번호 하나만 보낼거라 json 아니라 그냥 댓글번호 객체로 
				//contentType : "application/json; charset=utf-8",	//co_num 하나만 넘기니까 obj로 보내고 requestParam으로 각각 받으면 됨
				//dataType : "json", 
				success : function (data){					//boolean으로 받으려고.. 대부분 여기까지오면 성공하지만 로그인 한지 오래돼서 세션 만료된 상태로 글 작성 하려 하면 실패하게
					//console.log(data);
					if(data){
						alert("댓글을 삭제했습니다.");
						getCommentList(cri); 
					}else{
						alert("댓글을 삭제하지 못했습니다.");
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
				
			
			return false;
			
			
		});	
		
	</script>
	
	<!-- 페이지 클릭 이벤트 등록 -->
	<script type="text/javascript">

		$(".comment-pagination .page-link").click(function(e){
			let page = $(this).data("page");
			cri.page = page;
			getCommentList(cri);		// -> 전역변수 cri의 페이지를 누른 번호 페이지로 변경
		});
		
	</script>
	
	
	
	<!-- 수정 버튼 클릭 이벤트 등록 -->
	<script type="text/javascript">
	
	$(".btn-update").click(function(e){
		//alert(1);
		var $content = $(this).parents(".comment-item").find(".comment-content");
		$content.hide();
		
		var co_content = $content.text();
		//alert(content);
		var co_num = $(this).data("num");
		
		if($content.next().length != 0) return; // 수정 입력창 하나 나와있으면 더이상 추가 x
		
		var str = `
			<form class="input-group mb-3 update-form reply mt-2" action="<c:url value="/comment/update"/>" method="post">
				<input type="hidden" name="co_num" value="\${co_num}">
			    <textarea class="form-control" name="co_content">\${co_content}</textarea>
				<button class="btn btn-outline-primary">답글 수정</button>				    
			</form>
		`
		$content.after(str);
	});
	</script>
	
	<!-- 수정 완료 버튼을 눌러서 댓글 수정 (댓글 등록에서 그대로 가져옴) -->
	<script type="text/javascript">
		$(document).off("submit", ".update-form")
		$(document).on("submit", ".update-form", function(e){				//수정버튼 클릭 시 생성되는 애라 document
			e.preventDefault();		
			
			if('${user.me_id}' == ''){
				if(confirm("로그인이 필요한 서비스입니다. \n로그인 페이지로 이동하시겠습니까?")){
					location.href = "<c:url value="/login"/>";
				}
				return false;
			}
			let $obj = $(this).find("[name=co_content]");
			let content = $obj.val().trim();		
			
			if(content == ''){
				alert("댓글 내용을 입력해 주세요.");
				$obj.focus();		
				return;
			}
			let co_num = $(this).find("[name=co_num]").val();
			let co_content = $(this).find("[name=co_content]").val();
			let obj = {
					co_content : co_content,
					co_num : co_num
			}
			//console.log(obj);
			//return;
			let url = ($(this).attr("action"));
			$.ajax({
				async : true,
				url : url, 
				type : 'post', 
				data : JSON.stringify(obj), 
				contentType : "application/json; charset=utf-8",
				//dataType : "json", 
				success : function (data){					
					
					if(data){
						alert("댓글을 수정했습니다.");
						getCommentList(cri);
					}else{
						alert("댓글을 수정하지 못했습니다.");
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	
	</script>
	

</body>
</html>
