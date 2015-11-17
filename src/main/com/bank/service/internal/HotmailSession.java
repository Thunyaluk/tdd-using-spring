package com.bank.service.internal;

import com.bank.domain.GmailAccount;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by roofimon on 11/17/2015 AD.
 */
public class HotmailSession implements EmailSession{
    GmailAccount account = new GmailAccount();
    private Session session;
    String host = "smtp.live.com";

    public HotmailSession() {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "roofimon@live.com");
        props.put("mail.smtp.password", "N0mif00rA");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        this.session = Session.getDefaultInstance(props);
    }
    @Override
    public Session getSession() {
        return this.session;
    }

    @Override
    public MimeMessage getMimeMessage(String subject, String body, InternetAddress[] toAddress) throws MessagingException {
        MimeMessage message = new MimeMessage(this.getSession());
        message.setFrom(new InternetAddress(account.username));
        messageSetTos(message, toAddress);
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

    private void messageSetTos(MimeMessage message, InternetAddress[] toAddress) throws MessagingException {
        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }
    }

    @Override
    public void send(MimeMessage message) throws MessagingException {
        Transport transport = session.getTransport("smtp");
        session.setDebug(true);
        transport.connect(host, "roofimon@live.com", "N0mif00rA");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
