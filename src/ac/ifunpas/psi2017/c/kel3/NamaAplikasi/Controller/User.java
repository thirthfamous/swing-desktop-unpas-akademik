/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller;

/**
 *
 * @author Syifa J 153040109
 */
public class User {
    private byte userId;
    private String username;
    private String password;
    private String accessibility;

    public User() {
        
    }

    public User(byte userId, String username, String password, String accessibility) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.accessibility = accessibility;
    }

    public void seUsertId(byte userId) {
        this.userId = userId;
    }
    
    public byte getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public String getAccessibility() {
        return accessibility;
    }
}
