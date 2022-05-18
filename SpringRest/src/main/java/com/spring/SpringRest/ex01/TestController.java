package com.spring.SpringRest.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/test/*")
public class TestController {
	static Logger logger = LoggerFactory.getLogger(TestController.class);
@RequestMapping("/hello")
public String hello() {
	return "Hello Rest";
}

@RequestMapping("/member") //VO객체 전달
public MemberVO member() {
	MemberVO vo = new MemberVO();
	vo.setId("인성");
	vo.setPwd("1234");
	vo.setName("윤인성");
	vo.setEmail("example@naver.com");
	
	
	return vo;
}

//컬렉션 객체 전달
@RequestMapping(value="/memberList", method=RequestMethod.GET) 
public List<MemberVO> memberList() {
	List<MemberVO> list = new ArrayList<MemberVO>();
	for(int i=0;i<10;i++) {
	MemberVO vo = new MemberVO();
	vo.setId("ex"+i);
	vo.setPwd("1234"+i);
	vo.setName("사용자"+i);
	vo.setEmail("example"+i+"@naver.com");
	list.add(vo);
	}
	return list;
}

@RequestMapping("/memberMap") //Map 전달
public Map<Integer,MemberVO> memberMap(){
	Map<Integer,MemberVO> map = new HashMap<Integer,MemberVO>();
	
	for(int i=0;i<10;i++) {
		MemberVO vo = new MemberVO();
		vo.setId("ex"+i);
		vo.setPwd("1234"+i);
		vo.setName("사용자"+i);
		vo.setEmail("example"+i+"@naver.com");
		map.put(i,vo);
		}
	
	return map;
}

//URL로 전달된 매개변수 가져오기
@RequestMapping(value="notice/{num}", method=RequestMethod.GET) 
public int notice(@PathVariable("num") int num)throws Exception{
	return num;
}

@RequestMapping(value="/info", method=RequestMethod.POST) 
public void modify(@RequestBody MemberVO vo) { //@RequestBody => 브라우저에서 받아온 json데이터를 MemberVO객체의 속성에 자동으로 설정
	logger.info(vo.toString());
}

@RequestMapping("memberList2")
public ResponseEntity<List<MemberVO>> listMember(){ //ResponseEntity로 응답한다.
	List<MemberVO> list = new ArrayList<MemberVO>();
	for(int i=0 ; i<10 ;i++) {
		MemberVO vo = new MemberVO();
		vo.setId("ex"+i);
		vo.setPwd("1234"+i);
		vo.setName("사용자"+i);
		vo.setEmail("example"+i+"@naver.com");
		list.add(vo);
	}
	return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);
	//HttpStatus.INTERNAL_SERVER_ERROR 상태코드 : 처리할수없는 내부 오류가 발생했다고 알려준다
}

@RequestMapping("/entity")
public ResponseEntity entity() {
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	String message = "<script>";
	message += "alert('회원등록');";
	message += "location.href='/SpringRest/test/memberList2';";
	message +="</script>";
	return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED); //ResponseEntity를 이용햐 html형식으로 전송한다.
	
}

}
