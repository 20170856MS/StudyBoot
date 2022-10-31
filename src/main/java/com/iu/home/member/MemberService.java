package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public Integer getIdCheck(MemberVO memberVO)throws Exception{
		return memberMapper.getIdCheck(memberVO);
	}
	
	//사용자 정의 검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean check = false;
		//check=false : 검증성공(에러 X => pw 같음)
		//check=true : 검증실패(에러 O => pw 불일치)
		
		//1. annotation 검증
		check = bindingResult.hasErrors();
		
		
		
		//2. password가 일치하는지를 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
			check = true;
			//에러메세지
			//bindingResult.rejectValue("멤버변수명(path)", "properties의 key(코드)");
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
			
		}
		
		//3. id가 중복인지 검증
		int result = memberMapper.getIdCheck(memberVO);
		if(result > 0) {
			check = true;
			bindingResult.rejectValue("idCheck", "member.id.notEqual");
		}
		
		return check;
	}
	
	public int setAdd(MemberVO memberVO)throws Exception{
		int result = memberMapper.setAdd(memberVO);
		
		if(result<1) {
			throw new Exception();
		}
		
		result = memberMapper.setMemberRole(memberVO);
		
		if(result<1) {
			throw new Exception();
		}
		
		return result;
	}
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}

}
