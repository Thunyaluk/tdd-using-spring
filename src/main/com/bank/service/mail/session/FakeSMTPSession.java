package com.bank.service.mail.session;

import com.bank.domain.EmailAccount;

import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import java.util.Properties;

public class FakeSMTPSession extends GenericSession {
        public FakeSMTPSession() throws AddressException, NoSuchProviderException {
                super.account = new EmailAccount();
                super.host = "localhost";
                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.user", account.username);
                props.put("mail.smtp.password", account.password);
                props.setProperty("mail.smtp.port", "3025");
                props.put("mail.smtp.auth", "true");
                this.session = Session.getDefaultInstance(props);
                this.transport = session.getTransport("smtp");
                this.smtpPort = 3025;
        }
}
