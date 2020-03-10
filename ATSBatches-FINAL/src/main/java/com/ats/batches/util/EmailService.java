package com.ats.batches.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired(required=true)
	private JavaMailSender javaMailSender;
	
	@Value("${mail.subject}")
	private String mailSubject;
	
	public void sendEmail(String textMsg) throws Exception {

		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo("pavankumarone1@gmail.com", "pavankumarone1@gmail.com");
		msg.setSubject(mailSubject);		
		msg.setText(textMsg);

		javaMailSender.send(msg);

//or here we can use mime message also
//MimeMessage mime=new MimeMessage();
//MimeMessageHelper mh=new MimeMessageHelper(mime);
//mh.setTo(),mh.setSubject(),mh.setText()
		
	}
}
