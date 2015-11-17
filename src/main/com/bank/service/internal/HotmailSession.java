package com.bank.service.internal;

import com.bank.domain.EmailAccount;
import com.bank.domain.GmailAccount;
import com.bank.domain.HotmailAccount;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by roofimon on 11/17/2015 AD.
 */
public class HotmailSession extends GenericSession {
    public HotmailSession() {
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
    }

}
