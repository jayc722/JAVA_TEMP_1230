package kr.kh.spring2.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring2.dao.PostDao;
import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.FileVO;
import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;
import kr.kh.spring2.pagination.PageMaker;
import kr.kh.spring2.utils.UploadFileUtils;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	private PostDao postDao;

	@Override
	public List<BoardVO> getBoardList() {
		// 매개변수 없으니 매개변수 체크할 필요 x
		return postDao.selectBoardList();
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		
		if(cri == null) return null;
		
		return postDao.selectPostList(cri);
	}
	

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		int count = postDao.selectCountPostList(cri);
		return new PageMaker(1, cri, count);
	}

	@Override
	public PostVO getPost(int po_num) {
		//if(po_num<0)return null;
		
		return postDao.selectPost(po_num);
	}

	@Override
	public List<FileVO> getFileList(int po_num) {
		

		
		return postDao.selectFileList(po_num);
		
	}

	@Override
	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		
		if(post==null||user==null) return false;
		
		post.setPo_me_id(user.getMe_id());
		//이미지게시판식으로(이미지 무조건 1개이상)
		
		//첨부파일이 없으면
		if(fileList==null || fileList.length == 0) return false; //첨부파일 무조건 등록하게 하고 싶으면 postDao.insertpost 위로 올려서 return false로

		//첨부파일 무조건 등록하게 하고 싶으면 얘도 postDao.insertpost 위로 올려
		int count=0;
		//첨부파일 목록에 실제 파일이 없을 수 있음
		for(MultipartFile file : fileList) {if(file.getOriginalFilename().length()!=0)count++;}
		
		
		if(count == 0) return false;
		 
		
		boolean res = postDao.insertPost(post);
		
		//if(!res) return false;	//실패했으면 false
		
		if(!res) return false;
		
		count = 1;
		for(MultipartFile file : fileList) {
			if(file.getOriginalFilename().length() == 0) continue; 
			insertFile(post.getPo_num(), count++, file);
			}
		
		return true;
	}

	@Value("${file.location}")
	String uploadPath; 
	//업로드경로
	
	private void insertFile(int po_num, int order, MultipartFile file) {

		if(file==null) return;	//사실 앞에서 다 널체크 하고 왔지만 그래도
		
		String fi_ori_name = file.getOriginalFilename();
		
		if(fi_ori_name.length()==0) return;
		
		int index = fi_ori_name.lastIndexOf("."); 
		String suffix = fi_ori_name.substring(index);
		
		try {
			String fi_name = UploadFileUtils.uploadFileToFolder(uploadPath,""+ po_num, order + suffix, file.getBytes());
			FileVO fileVo = new FileVO(fi_ori_name, fi_name, po_num);
			postDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	
}
