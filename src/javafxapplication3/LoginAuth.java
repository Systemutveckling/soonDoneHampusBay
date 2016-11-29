/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

/**
 *
 * @author skate
 */
public class LoginAuth {
    private boolean loggedIn;
    private String username;
    private String email;
    private String password;
    
    private static LoginAuth instance = null;

    
    private LoginAuth() {
        // Exists only to defeat instantiation.
    }

    public static LoginAuth getInstance() {
        if (instance == null) {
            instance = new LoginAuth();
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    
 

}
