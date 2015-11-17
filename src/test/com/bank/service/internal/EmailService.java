package com.bank.service.internal;

import org.junit.Test;

public class EmailService {

    @Test
    public void testSendMail(){
        EmailSession session = new GmailSession();
        HotmailSession hotmailSession = new HotmailSession();
        MailService gmailService = new GmailService();
        gmailService.setSession(hotmailSession);
        String[] recipients = {"roofimon@gmail.com"};
        gmailService.sendMail(recipients);
    }
}
