/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Model.Dpp;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Model.Mahasiswa;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller.MyConnection;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.view.SbapFrame;

/**
 *
 * @author Syifa J 153040109
 */
public class Sbap {

//    private Mahasiswa mahasiswaModel;
//    private Dpp dppModel;
//    public Sbap(Mahasiswa mahasiswaModel, Dpp dppModel) {
//        this.mahasiswaModel = mahasiswaModel;
//        this.dppModel = dppModel;
//    }
    public int getIdMahasiswa(Mahasiswa mhsModel) {
        return mhsModel.getIdMhs();
    }

    public String getNamaMahasiswa(Mahasiswa mhsModel) {
        return mhsModel.getNama();
    }

    public String getNrp(Mahasiswa mhsModel) {
        return mhsModel.getNrp();
    }

    public int getIdDpp(Dpp dppModel) {
        return dppModel.getIdDpp();
    }

    public String getStatusDpp(Dpp dppModel) {
        return dppModel.getStatusDpp();
    }

//    public void setIdMahasiswa(int idMahasiswa) {
//        mahasiswaModel.setIdMhs(idMahasiswa);
//    }
//
//    public int getIdMahasiswa() {
//        return mahasiswaModel.getIdMhs();
//    }
//
//    public void setNamaMahasiswa(String nama) {
//        mahasiswaModel.setNama(nama);
//    }
//
//    public String getNamaMahasiswa() {
//        return mahasiswaModel.getNama();
//    }
//
//    public void setNrp(String nrp) {
//        mahasiswaModel.setNrp(nrp);
//    }
//
//    public String getNrp() {
//        return mahasiswaModel.getNrp();
//    }
//
//    public void setStatusDpp(String statusDpp) {
//        dppModel.setStatusDpp(statusDpp);
//    }
//
//    public String getStatusDpp() {
//        return dppModel.getStatusDpp();
//    }
    public void ubah(SbapFrame sbapView) throws SQLException {
//        if (validateInput(sbapFrame)) {
        Dpp dppModel = new Dpp();
        Mahasiswa mhsModel = new Mahasiswa();
        String statusDpp = "";
        Connection con = MyConnection.getConnection();
        try {

//            if (statusDpp.equalsIgnoreCase("Lunas")) {
//                dppModel.setIdDpp(1);
//            } else {
//                dppModel.setIdDpp(0);
//            }
//            PreparedStatement stat = con.prepareStatement(
//                    "UPDATE mahasiswa SET id_dpp=? WHERE id_mhs=?");
//            String query = "UPDATE mahasiswa SET id_dpp='"+ getStatusDpp(statusDpp) +"' WHERE id_mhs=?";
            String query = "UPDATE mahasiswa SET id_dpp=? WHERE id_mhs=?";
//           
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, mhsModel.getIdMhs());

            preparedStmt.setInt(2, dppModel.getIdDpp());
            preparedStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            tampil(sbapView);
            sbapView.setLebarKolom();
        }
    }
//    }

    private int getStatusDpp(String statusDpp) {
        if (statusDpp.equalsIgnoreCase("Lunas")) {
            return 1;
        }
        return 0;
    }

    public void tampil(SbapFrame sbapFrame) throws SQLException {
        sbapFrame.tblmodel.getDataVector().removeAllElements();
        sbapFrame.tblmodel.fireTableDataChanged();
        Dpp dppModel = new Dpp();
        try {
            Connection con = MyConnection.getConnection();
            Statement stt = con.createStatement();
            String sql = "select id_mhs, nrp, nama, id_dpp from mahasiswa";
            ResultSet res = stt.executeQuery(sql);
            String statusDpp = "";
            while (res.next()) {
                if (Integer.valueOf(res.getString(4)) == 1) {
                    statusDpp = "Lunas";
                } else {
                    statusDpp = "Belum Lunas";
                }
                Object[] ob = new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = statusDpp;
//                ob[3] = res.getString(4);

                sbapFrame.tblmodel.addRow(ob);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    private boolean validateInput(SbapFrame sbapFrame) {
//        // validasi radiobutton lunas & radiobutton belumLunas
//        if ((sbapFrame.lunasRb.isSelected()==false) && (sbapFrame.belumLunasRb.isSelected()==false)) {
//            JOptionPane.showMessageDialog(sbapFrame, "Pilih salah satu status DPP!");
//            return false;
//        }
//
//        return true;
//    }
}
