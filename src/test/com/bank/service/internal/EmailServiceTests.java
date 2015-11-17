package com.bank.service.internal;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.mail.NoSuchProviderException;
import javax.mail.internet.AddressException;

import static junit.framework.Assert.assertEquals;

public class EmailServiceTests {
    private static final int SMTP_TEST_PORT = 3025;
    public GreenMail greenMail;

    @Before
    public void setUp() throws Exception {
        greenMail = new GreenMail(new ServerSetup(SMTP_TEST_PORT, null, "smtp"));
        greenMail.start();
    }
    @After
    public void tearDown() throws Exception {
        greenMail.stop();
    }

    //@Test
    public void testSendMailUsingHotmail() throws AddressException, NoSuchProviderException {
        EmailSession session = new HotmailSession();
        MailService gmailService = new GenericMailService();
        gmailService.setSession(session);
        String[] recipients = {"roofimon@gmail.com"};
        gmailService.sendMail(recipients);
        //assertEquals("Done", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));
    }
    @Test
    public void testSendMail() throws AddressException, NoSuchProviderException {
        GenericSession session = new FakeSMTPSession();
        MailService gmailService = new GenericMailService();
        gmailService.setSession(session);
        String[] recipients = {"roofimon@gmail.com"};
        gmailService.sendMail(recipients);
        assertEquals("Done", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));
    }
}
