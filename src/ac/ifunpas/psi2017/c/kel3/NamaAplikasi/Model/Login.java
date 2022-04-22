
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Model;

import crypt.Crypto;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller.User;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.view.DikjarFrame;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.view.DosenWaliFrame;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.view.LoginFrame;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.ApachePoi.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Syifa J 153040109
 */
public class Login {
    public void cekLogin(LoginFrame login) throws SQLException, Exception {
        Connection con = MyConnection.getConnection();
        User user = new User();
        boolean cekLogin = false;
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                if (rs.getString("username").equals(login.getUsernameText().getText()) && Crypto.convertToMD5(login.getPasswordText().getText()).equals(rs.getString("password"))) {                    
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setAccessibility(rs.getString("hak_akses"));
                    cekLogin = true;
                    login.setVisible(false);
                    break;
                } else {
                   
                }
            }
            if (cekLogin == false) {
                JOptionPane.showMessageDialog(login, "Username atau Password salah");
            } else {
                if (user.getAccessibility().equals("dosenwali")) {
                    JOptionPane.showMessageDialog(login, "Login Berhasil");
                    DosenWaliFrame dosenWali = new DosenWaliFrame(user.getUsername());
                    dosenWali.setVisible(true);
                } else if (user.getAccessibility().equals("dikjar")) {
                    DikjarFrame dikjar = new DikjarFrame();
                    dikjar.setVisible(true);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}