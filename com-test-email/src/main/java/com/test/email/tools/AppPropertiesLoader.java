package com.test.email.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class AppPropertiesLoader {

	// Email config
	@Value("${email.smtp.host}")
	private String smtpHost;
	@Value("${email.smtp.port}")
	private Integer smtpPort;
	@Value("${email.smtp.user}")
	private String smtpUser;
	@Value("${email.smtp.password}")
	private String smtpPass;
	@Value("${mail.transport.protocol}")
	private String smtpProtocol;
	@Value("${mail.smtp.starttls.enable}")
	private boolean smtpTls;
	@Value("${mail.smtp.auth}")
	private boolean smtpAuth;
	@Value("${email.from}")
	private String from;
	@Value("${email.cc.list}")
	private String ccList;
	@Value("${email.subject.template}")
	private String emailSubjectTemplate;

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public Integer getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getSmtpUser() {
		return smtpUser;
	}

	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}

	public String getSmtpPass() {
		return smtpPass;
	}

	public void setSmtpPass(String smtpPass) {
		this.smtpPass = smtpPass;
	}

	public String getSmtpProtocol() {
		return smtpProtocol;
	}

	public void setSmtpProtocol(String smtpProtocol) {
		this.smtpProtocol = smtpProtocol;
	}

	public boolean isSmtpTls() {
		return smtpTls;
	}

	public void setSmtpTls(boolean smtpTls) {
		this.smtpTls = smtpTls;
	}

	public boolean isSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(boolean smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getCcList() {
		return ccList;
	}



	public String getEmailSubjectTemplate() {
		return emailSubjectTemplate;
	}


}
