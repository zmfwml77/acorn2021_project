package com.my.insta.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.insta.notice.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	//핵심 의존객체 DI
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(NoticeDto dto) {
		session.insert("notice.insert", dto);
	}

	@Override
	public void update(NoticeDto dto) {
		
	}

	@Override
	public void delete(int num) {
		
	}

	@Override
	public NoticeDto getData(int num) {
		NoticeDto dto=session.selectOne("notice.getData", num);
		return dto;
	}

	@Override
	public List<NoticeDto> getList(NoticeDto dto) {
		/*
		 * parameterType => NoticeDto
		 * 
		 * parameterType  에는 페이징 처리를 위한 startRowNum 과 endRowNum 이 들어 있고
		 *  
		 *  title  검색이면 title  필드에 검색 키워드가 들어있다.
		 *  writer 검색이면 writer 필드에 검색 키워드가 들어있다.
		 *  title+content 검색이면 title and content 필드에 검색 키워드가 들어 있다.
		 *  검색 키워드가 없으면 title,writer,content 필드는 모두 null 이다.
		 */
		List<NoticeDto> list=session.selectList("notice.getList", dto); 
		return list;
	}

	@Override
	public int getCount(NoticeDto dto) {
		/*
		 *  parameterType => NoticeDto
		 *  parameterType  에는 검색키워드가 존재한다면 들어 있다.
		 *  
		 *  resultType => int
		 */
		int count=session.selectOne("notice.getCount", dto);
		return count;
	}

	@Override
	public void addViewCount(int num) {
		session.update("notice.addViewCount", num);
	}

}
