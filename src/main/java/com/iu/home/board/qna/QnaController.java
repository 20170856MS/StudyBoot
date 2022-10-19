package com.iu.home.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class QnaController {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@GetMapping("*/list")
	@ResponseBody
	public void showList() throws Exception{
		
	}
}
