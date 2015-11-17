package com.bank.service.mail;

import com.bank.domain.GmailAccount;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by roofimon on 11/17/2015 AD.
 */
public interface EmailSession {
    Session getSession() throws AddressException;
    MimeMessage getMimeMessage(String subject, String body, InternetAddress[] toAddress) throws MessagingException;
    void send(MimeMessage message) throws MessagingException;
}
