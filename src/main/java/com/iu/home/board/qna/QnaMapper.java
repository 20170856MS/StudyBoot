package com.iu.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository 생략가능
@Mapper
public interface QnaMapper {
	
	public List<QnaVO> getList() throws Exception;
	public int addList() throws Exception;
}
