package com.bank.domain;

/**
 * Created by roofimon on 11/17/2015 AD.
 */
public class Email {
    public String[] to;
    public String subject;
    public String body;

    public Email(String[] recipients) {
        this.to = recipients;
        this.subject = "Your transaction is completed";
        this.body = "Done";
    }
}
