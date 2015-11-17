package com.bank.service;

import com.bank.service.mail.EmailSession;

/**
 * Created by roofimon on 11/17/2015 AD.
 */
public interface MailService {
    void sendMail(String[] recipients);

    void setSession(EmailSession session);
}
