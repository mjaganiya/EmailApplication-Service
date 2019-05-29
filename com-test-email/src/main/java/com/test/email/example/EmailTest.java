package com.test.email.example;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.email.tools.AppPropertiesLoader;

@Service
public class EmailTest {

	@Autowired
	private AppPropertiesLoader appPropertiesLoader;

	private Session session = null;

	@PostConstruct
	public void init() {
		Properties pops = new Properties();
		pops.put("mail.smtp.host", appPropertiesLoader.getSmtpHost());
		pops.put("mail.transport.protocol", appPropertiesLoader.getSmtpProtocol());
		pops.put("mail.smtp.starttls.enable", appPropertiesLoader.isSmtpTls());
		pops.put("mail.smtp.auth", appPropertiesLoader.isSmtpAuth());
		pops.put("mail.smtp.port", appPropertiesLoader.getSmtpPort());
		if (appPropertiesLoader.isSmtpAuth()) {
			session = Session.getDefaultInstance(pops, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(appPropertiesLoader.getSmtpUser(),
							appPropertiesLoader.getSmtpPass());
				}
			});
		} else {
			session = Session.getDefaultInstance(pops);
		}
	}

	public void sendEmail(String toEmail) throws AddressException, MessagingException {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(appPropertiesLoader.getFrom()));
		message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("jaganiyamaulik2@gmail.com"));
		message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(appPropertiesLoader.getCcList()));
		message.setSubject(appPropertiesLoader.getEmailSubjectTemplate());
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText("Thanbk You .. Test User!");
		Multipart multipart = new MimeMultipart();

		// Set text message part
		multipart.addBodyPart(messageBodyPart);

		// Send the complete message parts
		message.setContent(multipart);

		// Send message
		Transport.send(message);

	}
}
