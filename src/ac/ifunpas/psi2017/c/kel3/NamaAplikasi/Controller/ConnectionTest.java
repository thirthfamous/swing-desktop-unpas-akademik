/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Teguh
 */
public class ConnectionTest {
    public static void main(String[] args) {
        Connection con = MyConnection.getConnection();
        if (con != null){
            JOptionPane.showMessageDialog(null, "Connection Succesfull");
        } else {
            JOptionPane.showMessageDialog(null, "Connection Failed");
        }
    }
}
