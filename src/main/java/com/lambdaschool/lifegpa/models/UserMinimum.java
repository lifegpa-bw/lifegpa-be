package com.lambdaschool.lifegpa.models;

import com.lambdaschool.lifegpa.logging.Loggable;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Loggable
//@Table(name = "usermins")
public class UserMinimum {
    private String username;
    private String password;
    private String email;



    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String Email)
    {
        this.email = email;
    }
}
