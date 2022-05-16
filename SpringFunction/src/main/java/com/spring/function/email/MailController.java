package com.spring.function.email;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;

	@RequestMapping(value="/sendMail.do",method=RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		 StringBuffer sb = new StringBuffer();
	 	   sb.append("<html><body>");
	 		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
	 		sb.append("<h1>"+"제품소개"+"<h1><br>");
	 		sb.append("신간 도서를 소개합니다.<br><br>");
	 		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>");
	 		sb.append("<img  src='http://image.kyobobook.co.kr/images/book/xlarge/425/x9788956746425.jpg' /> </a><br>");
	 		sb.append("</a>");
	 		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>상품보기</a>");
	 		sb.append("</body></html>");
	 		
	 		
	 		String str=sb.toString();
	 		//mailService.sendMail("보낼 사람", "제목", "내용");
	 		mailService.sendMail("보낼 사람의 이메일@naver.com","신상품을 소개합니다.",str); // body의 파라미터자리에 문자열로 html태그를 보냄
		
		
		mailService.sendMail("보낼 사람의 이메일@naver.com","테스트메일","안녕하세요 테스트메일입니다."); //보낼 주소, 제목 ,내용을 매개변수로 보냄
		mailService.sendPreConfiguredMail("미리 정보를 설정해서 내용만 보냅니다.(preConfiguredMessage Bean)"); //mail-context.xml에서 미리 설정한 방식을 이용
		out.print("메일을 보냄");//브라우저로 보냄

	}
}
