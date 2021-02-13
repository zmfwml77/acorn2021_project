package com.my.insta.notice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.my.insta.notice.dto.NoticeDto;

public interface NoticeService {
	//새 글을 저장하는 메소드
	public void saveContent(NoticeDto dto);
	//글목록을 얻어오고 페이진 처리에 필요한 값들을 ModelAndView 객체에 담아주는 메소드 
	public void getList(ModelAndView mView, HttpServletRequest request);
	//글하나의 정보를 ModelAndView 객체에 담아주는 메소드
	public void getDetail(int num, ModelAndView mView);
}
