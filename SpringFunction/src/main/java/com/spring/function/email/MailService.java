package com.spring.function.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
	@Autowired
	 private JavaMailSender mailSender;
   @Autowired
   private SimpleMailMessage preConfiguredMessage;
   
   @Async
	public void sendMail(String to, String subject, String body) {
      MimeMessage message = mailSender.createMimeMessage();
      try {
		MimeMessageHelper messageHelper = 
		new MimeMessageHelper(message, true, "UTF-8");

		messageHelper.setFrom("보내는 이@gmail.com", "보이고 싶은 이름");//수신자가 보는 송신자의 이름 설정
		messageHelper.setSubject(subject);
		messageHelper.setTo(to); 
		messageHelper.setText(body,true );
		mailSender.send(message);  
      }catch(Exception e){
		e.printStackTrace();
	  }
	}
 
	@Async
	public void sendPreConfiguredMail(String message) {
	  SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
	  mailMessage.setText(message);
	  mailSender.send(mailMessage);
	}

}
