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
public class Mahasiswa {

    private int idMhs;
    private String nrp;
    private String nama;
    private String alamat;
    private String jenisKelamin;

    public Mahasiswa() {

    }

    public Mahasiswa(int idMhs, String nrp, String nama, String alamat, String jenisKelamin) {
        this.idMhs = idMhs;
        this.nrp = nrp;
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
    }

    public int getIdMhs() {
        return idMhs;
    }

    public void setIdMhs(int idMhs) {
        this.idMhs = idMhs;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

}
