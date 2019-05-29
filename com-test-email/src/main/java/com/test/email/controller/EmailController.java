package com.test.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.email.example.EmailTest;

@Controller
@RequestMapping(path = "/sendEmail", produces = "application/json")
public class EmailController {
	@Autowired
	private EmailTest emailTest;

	@RequestMapping(value = "/{emailId}", method = RequestMethod.POST)
	public void sendEmail(@PathVariable(value = "emailId") String emailId) throws Exception {
		emailTest.sendEmail(emailId);
	}
}
