package com.bank.service.mail.session;

import com.bank.domain.GmailAccount;

import javax.mail.*;
import java.util.Properties;

public class GmailSession extends GenericSession {
    public GmailSession() throws NoSuchProviderException {
        super.account = new GmailAccount();
        super.host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", account.username);
        props.put("mail.smtp.password", account.password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        this.session = Session.getDefaultInstance(props);
        this.transport = session.getTransport("smtp");
    }
}
