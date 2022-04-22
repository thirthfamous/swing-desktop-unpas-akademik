/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller;

/**
 *
 * @author Teguh
 */
public class Mahasiswa {

    private int nrp;
    private String nama;
    private String alamat;
    private String jenis_kelamin;
    private int id_dpp;
    private int id_dosen;

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public int getId_dpp() {
        return id_dpp;
    }

    public void setId_dpp(int id_dpp) {
        this.id_dpp = id_dpp;
    }

    public int getId_dosen() {
        return id_dosen;
    }

    public void setId_dosen(int id_dosen) {
        this.id_dosen = id_dosen;
    }

}
