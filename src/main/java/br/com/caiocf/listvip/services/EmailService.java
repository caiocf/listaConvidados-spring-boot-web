package br.com.caiocf.listvip.services;

import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Value("${servidor.smtp}")
	String servidorSmtp;
	
	@Value("${porta.smtp}")
	int setSmtpPort;
	
	@Value("${usuario.email}")
	String usuarioEmail;

	@Value("${senha.email}")
	String usuarioSenha;
	
	@Value("${assunto.email}")
	String assuntoEmail;
	
	@Value("${corpo.email}")
	String corpoEmail;
	
	@Value("${tls.enable}")
	boolean tlsEnable;
	
	public void enviar(String nome, String emailConvidado){
		 try {
	            Email email = new SimpleEmail();
	            email.setHostName(servidorSmtp);
	            email.setSmtpPort(setSmtpPort);
	            email.setStartTLSEnabled(tlsEnable);
	            email.setAuthenticator(new DefaultAuthenticator(usuarioEmail, usuarioSenha));
	            email.setFrom(usuarioEmail);
	            email.setSubject(assuntoEmail);
	            email.setMsg(corpoEmail.replace("[nome]", nome));
	            email.addTo(emailConvidado);
	            email.setSentDate(new Date());
	            email.send();

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
    }
	
}
