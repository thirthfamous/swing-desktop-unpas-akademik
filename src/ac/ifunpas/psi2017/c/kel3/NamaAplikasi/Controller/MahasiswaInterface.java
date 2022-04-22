/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller;

import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.view.Form_Mahasiswa;
import java.sql.SQLException;

/**
 *
 * @author Teguh
 */
public interface MahasiswaInterface {

    public void simpan(Form_Mahasiswa mhs) throws SQLException;        

    public void ubah(Form_Mahasiswa mhs) throws SQLException;

    public void hapus(Form_Mahasiswa mhs) throws SQLException;

    public void tampil(Form_Mahasiswa mhs) throws SQLException;

    public void baru(Form_Mahasiswa mhs);                           

    public void klikTabel(Form_Mahasiswa mhs) throws SQLException;
}
