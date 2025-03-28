package kr.kh.spring.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.utils.UploadFileUtils;

@Service					//없으면  Unsatisfied dependency 에러 뜸			
public class PostServiceImp implements PostService {

	@Autowired
	private PostDAO postDao;	// root-container에 마이바티스-스프링 스캔에 의해 어노테이션 따로 등록 안해도 자동으로 들어가짐

	@Resource		//얘가 servlet-context에서 uploadpath 경로 가져와서 자동으로 추가해줌
	private String uploadPath;
	
	
	@Override
	public List<PostVO> getPostList(Criteria cri) {
		// TODO Auto-generated method stub
		return postDao.selectPostList(cri);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return postDao.selectBoardList();
	}

	@Override
	public boolean insertBoard(String bo_name) {
		// TODO Auto-generated method stub
		if(bo_name == null || bo_name.trim().length() == 0) {
			return false;
		}
		try {
			return postDao.insertBoard(bo_name);			//bo_name unique 걸려있어서 무작정 넣으면 예외 발생
		}catch(Exception e) {
			//e.printStackTrace();				//추가 실패	-> return false 로 넘어감.
		}
		return false;
	}
	
	

	@Override
	public boolean deleteBoard(int bo_num) {
		return postDao.deleteBoard(bo_num);
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		if(board == null || board.getBo_name() == null || board.getBo_name().trim().length() == 0) {
			return false;
		}
		return postDao.updateBoard(board);
	}

	@Override
	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		if(post == null || post.getPo_title().trim().length() == 0 || post.getPo_content().length() == 0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		post.setPo_me_id(user.getMe_id());
		boolean res = postDao.insertPost(post);
		
		//첨부파일 있을때 필요
		if(!res) return false; //실패하면 첨부파일 등록 필요x(사실 여기까지와서 실패할일 별로 없지만...)
		if(fileList == null || fileList.length == 0) return true;	//받은 첨부파일이 없으면 등록해줄 필요가 없음
		
		for(MultipartFile file : fileList) {
			uploadFile(file, post.getPo_num());
		}
		
			
		return true;
	}
	
	private void uploadFile(MultipartFile file, int po_num) {//수정에서 사용하기 위해 메소드로 빼기
		String fi_ori_name = file.getOriginalFilename();
		if(fi_ori_name == null || fi_ori_name.length() == 00) return;		//이름 없으면 건너뜀
		try {
			String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
			FileVO fileVo = new FileVO(fi_ori_name, fi_name, po_num);
			postDao.insertFile(fileVo);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public PostVO getPost(int po_num) {
		//int라 null처리 불요
				
		return postDao.selectPost(po_num);
	}

	@Override
	public boolean deletePost(int po_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//게시글 정보를 가져옴
		PostVO post = postDao.selectPost(po_num);
		//게시글의 작성자와 회원이 다르면 false 리턴
		if(post == null || !post.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//게시글 수정
		boolean res = postDao.deletePost(po_num);			//첨부파일 추가되면 첨부파일 삭제하기 위해....
		
		
		if(!res) return false;	//실패시 여기서 반환
		//첨부파일 삭제->첨부파일은 삭제 시 실제 파일 삭제(용량 차지할 필요 없으니...)
		//기존 첨부파일을 가져옴
		List<FileVO> fileList = postDao.selectFileList(po_num);
		
		if(fileList == null || fileList.size() == 0) return true;	//없으면 반환
		
		//실제 첨부파일을 삭제. 
		for(FileVO fileVo : fileList) {
			deleteFile(fileVo);
		}
		
		//db에서도 해당 첨부파일을 삭제.
		
		
		return true;
	}

	private void deleteFile(FileVO fileVo) {
		if(fileVo == null) return;
		
		// 실제 첨부파일을 삭제
		UploadFileUtils.deleteFile(uploadPath, fileVo.getFi_name());
		
		
		// db에서 해당 첨부파일 삭제
		postDao.deleteFile(fileVo.getFi_num());
		
		
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user, MultipartFile[] fileList, int[] delNums) {
		if(post == null || post.getPo_title().trim().length() == 0 || post.getPo_content().length() == 0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		//게시글 정보를 가져옴
		PostVO dbPost = postDao.selectPost(post.getPo_num());
		//작성자인지 확인
		if(dbPost == null || !dbPost.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		
		boolean res = postDao.updatePost(post);

		//insert 코드 가져옴
		if(!res) return false; 
		if(fileList == null || fileList.length == 0) return true;	
		for(MultipartFile file : fileList) {
			uploadFile(file, post.getPo_num());
		}
		if(delNums == null || delNums.length == 0) return true;
		//x버튼 눌렸을 시 첨부파일 제거
		for(int fi_num : delNums) {
			FileVO fileVo = postDao.selectFile(fi_num);
			deleteFile(fileVo);
		}
		
		return res;
	}

	@Override
	public void updateView(int po_num) {
		postDao.updateView(po_num);
		
	}

	@Override
	public List<FileVO> getFileList(int po_num) {
		// 널처리 할게 x
		return postDao.selectFileList(po_num);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		int totalCount = postDao.selectCountPostList(cri);
		return new PageMaker(3, cri, totalCount);
	}

		
}
