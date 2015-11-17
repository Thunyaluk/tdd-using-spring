package com.bank.service.internal;

/**
 * Created by roofimon on 11/17/2015 AD.
 */
public interface MailService {
    void sendMail(String[] recipients);

    void setSession(EmailSession session);
}
