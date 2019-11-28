package com.tyss.library.management.librarymanagement.mailservice;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.tyss.library.management.librarymanagement.dto.UserInfoDto;
@Component
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendMail(UserInfoDto user) throws MailException, MessagingException{
		//Sned Mail.
		String mailText="Welcome Mr/Mrs "+user.getUserName()+ "To LibraryManagement System Your EmailId is "+user.getUserEmail()+" and password is="+user.getUserPassword()+"  Please don't reply of this mail";
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(user.getUserEmail());
		mail.setSubject("Test Mail..");
		mail.setText(mailText);
		
		javaMailSender.send(mail);
	}
}
