package com.myapp.springawssmtp.model;

public class Email {

	private String to;
	private String subject;

	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Email(String to, String subject) {
		super();
		this.to = to;
		this.subject = subject;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
