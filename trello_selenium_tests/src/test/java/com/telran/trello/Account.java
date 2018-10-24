package com.telran.trello;

public class Account {
    String eMail;
    String password;

    public String geteMail() {
        return eMail;
    }

    public Account seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }
}
