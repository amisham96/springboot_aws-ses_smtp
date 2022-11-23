package com.myapp.springawssmtp.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.springawssmtp.model.Email;
import com.myapp.springawssmtp.service.EmailService;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@PostMapping("/send")
	public String send(@ModelAttribute("email") Email email) {
		try {
			emailService.sendEmail(email.getTo(), email.getSubject());
		} catch (UnsupportedEncodingException | MessagingException e) {
			System.out.println(e.getStackTrace());
		}
		return "success";
	}

}
