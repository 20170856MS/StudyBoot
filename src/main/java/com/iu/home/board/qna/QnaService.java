package com.iu.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getList(Pager pager)throws Exception{
		pager.makeRow();
		return qnaMapper.getList(pager);
	}
	
	public int setAdd(QnaVO qnaVO, HttpSession session)throws Exception{
		
		String realPath = session.getServletContext().getRealPath("/static/upload/qna2");
		log.info("RealPath : {}",realPath );
		File file = new File(realPath);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
			log.info("Check : {}", check);
		}
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("FileName : {}", f.getOriginalFilename());
			}
		}
		
		return 1;//qnaMapper.setAdd(qnaVO);
	}

}
