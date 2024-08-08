/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cruz;

import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Donna
 */


@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {
    
    private String name;
    private String email;
    private String password;
    private String message;
    private static Map<String, String> users = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public String register() {
        if (users.containsKey(name)) {
            FacesMessage msg = new FacesMessage("Username already exists.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

        users.put(name, password);
        return "signin?faces-redirect=true";
    }
    
    public String login() {
        if (users.containsKey(name) && users.get(name).equals(password)) {
            return "welcome?faces-redirect=true";
        } else {
            FacesMessage msg = new FacesMessage("Invalid username or password.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
    }
}

