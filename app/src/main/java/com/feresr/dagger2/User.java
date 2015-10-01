package com.feresr.dagger2;

/**
 * Created by fernando.raviola on 01/10/2015.
 */
public class User {

    private int id;
    private String login;


    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
