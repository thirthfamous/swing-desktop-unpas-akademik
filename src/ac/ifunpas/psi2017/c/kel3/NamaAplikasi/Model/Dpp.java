/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Model;

/**
 *
 * @author Syifa J 153040109
 */
public class Dpp {

    private int idDpp;
    private String statusDpp;

    public Dpp() {

    }

    public Dpp(int idDpp, String statusDpp) {
        this.idDpp = idDpp;
        this.statusDpp = statusDpp;
    }

    public int getIdDpp() {
        return idDpp;
    }

    public void setIdDpp(int idDpp) {
        this.idDpp = idDpp;
    }

    public String getStatusDpp() {
        return statusDpp;
    }

    public void setStatusDpp(String statusDpp) {
        this.statusDpp = statusDpp;
    }

}
