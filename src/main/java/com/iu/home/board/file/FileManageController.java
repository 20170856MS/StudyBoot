package com.iu.home.board.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {
	
	@GetMapping("/fileDown/{p}") //RestFul, RestAPI
	public ModelAndView fileDown(@PathVariable(name = "p") String path,QnaFileVO qnaFileVO) throws Exception{
		log.info("Path : {}", path);
		ModelAndView mv = new ModelAndView();
		
		//DB에서 정보 조회
		qnaFileVO.setFileName("501db7b7-186a-4c0d-9042-cf91c909436e_backimg");
		qnaFileVO.setOriName("backimg.jpg");
		
		mv.addObject("fileVO",qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		
		return mv;
	}
}
