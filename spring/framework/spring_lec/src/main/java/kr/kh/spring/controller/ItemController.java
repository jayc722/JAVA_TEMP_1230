package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.dao.ItemDao;

//상품 등록 컨트롤러
@Controller	
@RequestMapping("/item")
public class ItemController {

//상품 데이터베이스 모듈
@Autowired
private ItemDao itemDao;

//상품 목록

/* 
@ResponseBody
@CrossOrigin("/*")
@PostMapping("/list")
public List<ItemDto> list() { /* 내용 생략} */ 
//이하 생략

}