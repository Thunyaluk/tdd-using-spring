package com.bank.service.internal;

import org.junit.Test;

public class EmailServiceTests {

    @Test
    public void testSendMail(){
        EmailSession gmailSession = new GmailSession();
        EmailSession hotmailSession = new HotmailSession();
        MailService gmailService = new GmailService();
        gmailService.setSession(gmailSession);
        String[] recipients = {"roofimon@gmail.com"};
        gmailService.sendMail(recipients);
    }
}
