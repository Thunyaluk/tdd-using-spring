package com.bank.service.mail;

import com.bank.domain.Email;
import com.bank.service.MailService;

import javax.mail.*;
import javax.mail.internet.*;

public class GenericMailService implements MailService {
    private EmailSession session;

    @Override
    public void sendMail(String[] recipients) {
        Email email = new Email(recipients);
        try {
            InternetAddress[] recipientInternetAddress = createRecipientInternetAddress(email.to);
            MimeMessage message = session.getMimeMessage(email.subject, email.body, recipientInternetAddress);
            session.send(message);
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    @Override
    public void setSession(EmailSession session) {
        this.session = session;
    }

    private InternetAddress[] createRecipientInternetAddress(String[] to) throws AddressException {
        InternetAddress[] toAddress = new InternetAddress[to.length];
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }
        return toAddress;
    }

}
