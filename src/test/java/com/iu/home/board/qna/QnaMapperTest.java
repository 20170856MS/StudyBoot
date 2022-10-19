package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class QnaMapperTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaMapper qnaMapper;
	
	private QnaVO qnaVO;
//	@Test
//	void test() throws Exception {
//		List<QnaVO> ar = qnaMapper.getList();
//		log.info("List {}", ar);
//		assertNotEquals(0, ar.size());
//	}
	

	
	@BeforeAll
	static void beforeAll() {
		System.out.println("전체 TEST실행전");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("전체 TEST실행후");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Test 메서드 실행 전");
		qnaVO = new QnaVO();
		qnaVO.setNum(1L);
		qnaVO.setContents("contents");
		
	}
	//@Test
	void addTest() throws Exception {
		for(int i=0; i<100; i++) {
			qnaVO = new QnaVO();
			qnaVO.setTitle("Title"+i);
			qnaVO.setWriter("Writer"+i);
			qnaVO.setContents("Contents"+i);
			int result = qnaMapper.addList();			
		}
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("Test 메서드 실행 후");
	}
	
	//@Test
	void test2() {
		log.info("Test Case2");
	}

}
