package com.bank.service.mail.session;

import com.bank.domain.HotmailAccount;

import javax.mail.*;
import java.util.Properties;

/**
 * Created by roofimon on 11/17/2015 AD.
 */
public class HotmailSession extends GenericSession {
    public HotmailSession() throws NoSuchProviderException {
        super.host = "smtp.live.com";
        super.account = new HotmailAccount();
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", account.username);
        props.put("mail.smtp.password", account.password);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        this.session = Session.getDefaultInstance(props);
        this.transport = session.getTransport("smtp");
    }

}
