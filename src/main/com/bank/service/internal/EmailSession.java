package com.bank.service.internal;

import com.bank.domain.GmailAccount;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by roofimon on 11/17/2015 AD.
 */
public interface EmailSession {
    Session getSession();
    MimeMessage getMimeMessage(String subject, String body, InternetAddress[] toAddress) throws MessagingException;
    void send(MimeMessage message) throws MessagingException;
}
