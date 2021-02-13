package com.my.insta.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.insta.notice.dto.NoticeDto;
import com.my.insta.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService service;
	
	@RequestMapping("/notice/detail")
	public ModelAndView detail(@RequestParam int num, ModelAndView mView) {
		//자세히 보여줄 글번호가 파라미터로 넘어온다.
		service.getDetail(num, mView);
		//view page 로 forward 이동해서 응답
		mView.setViewName("notice/detail");
		return mView;
	}
	
	//글 목록 요청처리
	@RequestMapping("/notice/list")
	public ModelAndView list(ModelAndView mView, 
			HttpServletRequest request) {
		
		service.getList(mView, request);
		
		mView.setViewName("notice/list");
		return mView;
	}
	
	//카페 새글 저장 요청 처리
	@RequestMapping(value = "/notice/private/insert", 
			method = RequestMethod.POST)
	public String insert(NoticeDto dto, HttpSession session) {
		//글작성자는 세션에서 얻어내서
		String id=(String)session.getAttribute("id");
		//dto 에 담는다 
		dto.setWriter(id);
		//서비스를 통해서 새글을 DB 에저장
		service.saveContent(dto);
		
		return "notice/private/insert";
	}
		
	//공지사항 새 글쓰기 요청 처리
	@RequestMapping("/notice/private/insertform")
	public String insertform() {
		
		// /WEB-INF/views/    notice/private/insertform      .jsp 
		return "notice/private/insertform";
	}
}
