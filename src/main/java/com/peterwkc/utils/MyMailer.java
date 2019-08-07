package com.peterwkc.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;




public class MyMailer {
	/*
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.port", "587");	
	mail.protocol.proxy.host" and "mail.protocol.proxy.port
*/
	
	private static final Logger logger = LogManager.getLogger(MyMailer.class);
	
	public MyMailer() {
	}
	
	public synchronized void sendEmail() {
		try {
			// Create the attachment
			EmailAttachment attachment = new EmailAttachment();
		    attachment.setPath(".\\report\\Test-Report.html");
		    attachment.setDisposition(EmailAttachment.ATTACHMENT);
		    attachment.setDescription("AT Report");
		    attachment.setName("AT Report.html");
		    
		    // Create the email message
		    MultiPartEmail email = new MultiPartEmail();
		    email.setHostName("smtp.gmail.com");
		    email.setSmtpPort(587);
		    email.setAuthenticator(new DefaultAuthenticator("peterapiit@gmail.com", "giqqpudmcjjmpbcc"));
		    email.setFrom("peterapiit@gmail.com", "Nicholas Wong");
		    email.addTo("kwong@who.int", "Nicholas Wong");
		    email.addTo("gann@who.int", "Nicholas Gann");
		    email.setBounceAddress("peterwkc30@gmail.com");
		    email.setSubject("ePQS Automation Testing Report");
		    email.setMsg("Please find the ePQS Automation Testing Report from attachment");
		    email.setStartTLSEnabled(true);
		    email.setSSLCheckServerIdentity(true);	
		    email.setDebug(true); 
		   
		    email.getMailSession().getProperties().setProperty("mail.smtp.auth", "true");
		    email.getMailSession().getProperties().setProperty("mail.smtp.starttls.enable", "true");
		    email.getMailSession().getProperties().setProperty("mail.smtp.port", "587");
			email.getMailSession().getProperties().setProperty("mail.smtp.proxy.host", "http://10.64.150.9");
			email.getMailSession().getProperties().setProperty("mail.smtp.proxy.port", "8080");
			
		    // add the attachment
		    email.attach(attachment);

		    // send the email
		    email.send();
			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

	}
}
// ==============================================================================================
/*
 * https://jodd.org/email/
 * 
 * 
 * 
 */




