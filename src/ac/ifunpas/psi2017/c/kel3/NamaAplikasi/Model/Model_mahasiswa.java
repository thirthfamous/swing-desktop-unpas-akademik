
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Model;

import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller.MyConnection;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Utilities.MessageError;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.view.Form_Mahasiswa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.Controller.MahasiswaInterface;
import ac.ifunpas.psi2017.c.kel3.NamaAplikasi.view.DosenWaliFrame;

/**
 *
 * @author Teguh
 */
public class Model_mahasiswa implements MahasiswaInterface {

    String jk;

    @Override
    public void simpan(Form_Mahasiswa mhs) throws SQLException {
        if (validateInput(mhs)) {
            if (mhs.rbLaki.isSelected()) {
                jk = "L";
            } else {
                jk = "P";
            }

            try {
                Connection con = MyConnection.getConnection();
                String sql = "insert into mahasiswa (nrp, nama, alamat, jenis_kelamin, id_dosen) values(?,?,?,?,?)";
                PreparedStatement prepare = con.prepareStatement(sql);
                prepare.setString(1, mhs.txtNrp.getText());
                prepare.setString(2, mhs.txtNama.getText());
                prepare.setString(3, mhs.textAreaAlamat.getText());
                prepare.setString(4, jk);
                prepare.setString(5, String.valueOf(getDosenObj(mhs)));
                prepare.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
                prepare.close();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                tampil(mhs);
                mhs.setLebarKolom();
            }
        }

    }

    public void ubah(Form_Mahasiswa mhs) throws SQLException {
        if (validateInput(mhs)) {
            if (mhs.rbLaki.isSelected()) {
                jk = "L";
            } else {
                jk = "P";
            }
            try {
                Connection con = MyConnection.getConnection();
                //String sql = "update mahasiswa set nrp= ?, nama= ?, alamat= ?, jenis_kelamin= ?, id_dpp= ?, id_dosen= ?, where id_mhs= ?";
                String sql = "update mahasiswa SET nrp='" + mhs.txtNrp.getText() + "',nama='" + mhs.txtNama.getText() + "',alamat='" + mhs.textAreaAlamat.getText() + "',jenis_kelamin='" + jk + "',id_dosen='" + getDosenObj(mhs) + "' where id_mhs='" + mhs.txtID.getText() + "'";
                PreparedStatement prepare = con.prepareStatement(sql);

//            prepare.setString(1, mhs.txtNrp.getText());
//            prepare.setString(2, mhs.txtNama.getText());
//            prepare.setString(3, mhs.textAreaAlamat.getText());
//            prepare.setString(4, jk);
//            prepare.setString(5, (String) mhs.cbDpp.getSelectedItem());
//            prepare.setString(6, (String) mhs.cbDosen.getSelectedItem());
//            prepare.setString(7, mhs.txtID.getText());
                prepare.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
                prepare.close();

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                tampil(mhs);
                mhs.setLebarKolom();
                baru(mhs);
            }
        }
    }

    public void hapus(Form_Mahasiswa mhs) throws SQLException {
        try {
            Connection con = MyConnection.getConnection();
            String sql = "delete from mahasiswa where id_mhs= ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, mhs.txtID.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            tampil(mhs);
            mhs.setLebarKolom();
            baru(mhs);
        }
    }


    public void tampil(Form_Mahasiswa mhs) throws SQLException {
        mhs.tblmodel.getDataVector().removeAllElements();
        mhs.tblmodel.fireTableDataChanged();
        try {
            Connection con = MyConnection.getConnection();
            Statement stt = con.createStatement();
            String sql = "select * from mahasiswa";
            ResultSet res = stt.executeQuery(sql);
            String namaDosen = null;
            while (res.next()) {
                if (Integer.valueOf(res.getString(6)) == 1) {
                    namaDosen = "Handoko Supeno";
                } else {
                    namaDosen = "Sandhika Galih";
                }
                Object[] ob = new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = res.getString(4);
                ob[4] = res.getString(5);
                ob[5] = namaDosen;
                mhs.tblmodel.addRow(ob);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tampilDosen(DosenWaliFrame mhs, String username) throws SQLException {
        mhs.tblmodel.getDataVector().removeAllElements();
        mhs.tblmodel.fireTableDataChanged();
        String idDosen = "";
        try {
            Connection con = MyConnection.getConnection();
            Statement stt = con.createStatement();
            if (username.equals("handoko")) {
                idDosen = "1";
            } else if (username.equals("sandhika")) {
                idDosen = "2";
            }
            String sql = "select * from mahasiswa where id_dosen = " + idDosen;
            ResultSet res = stt.executeQuery(sql);
            String namaDosen = null;
            while (res.next()) {
                if (Integer.valueOf(res.getString(6)) == 1) {
                    namaDosen = "Handoko Supeno";
                } else {
                    namaDosen = "Sandhika Galih";
                }
                Object[] ob = new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = res.getString(4);
                ob[4] = res.getString(5);
                ob[5] = namaDosen;
                mhs.tblmodel.addRow(ob);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void baru(Form_Mahasiswa mhs) {
        mhs.txtID.setText("");
        mhs.txtNrp.setText("");
        mhs.txtNama.setText("");
        mhs.textAreaAlamat.setText("");
        mhs.rbLaki.setSelected(true);
        mhs.cbDosen.setSelectedIndex(0);

    }

    @Override
    public void klikTabel(Form_Mahasiswa mhs) throws SQLException {
        try {
            int pilih = mhs.tabel.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            mhs.txtID.setText(mhs.tblmodel.getValueAt(pilih, 0).toString());
            mhs.txtNrp.setText(mhs.tblmodel.getValueAt(pilih, 1).toString());
            mhs.txtNama.setText(mhs.tblmodel.getValueAt(pilih, 2).toString());
            mhs.textAreaAlamat.setText(mhs.tblmodel.getValueAt(pilih, 3).toString());
            jk = String.valueOf(mhs.tblmodel.getValueAt(pilih, 4));
            mhs.cbDosen.setSelectedItem(mhs.tblmodel.getValueAt(pilih, 5).toString());

        } catch (Exception e) {
        }

        if (mhs.rbLaki.getText().equals(jk)) {
            mhs.rbLaki.setSelected(true);
        } else {
            mhs.rbPerempuan.setSelected(true);
        }
    }

    private int getDosenObj(Form_Mahasiswa mhs) {

        if (mhs.cbDosen.getSelectedItem().equals("Handoko Supeno")) {
            return 1;
        }
        return 2;

    }

    private boolean validateInput(Form_Mahasiswa form) {
        //Validasi TextField NRP

        if (form.txtNrp.getText().equals("")) {
            JOptionPane.showMessageDialog(form, MessageError.ERROR_MESSAGE_EMPTY_NRP);
            return false;
        }

        for (int i = 0; i < form.txtNrp.getText().length(); i++) {
            if (Character.isLetter(form.txtNrp.getText().charAt(i))) {
                JOptionPane.showMessageDialog(form, MessageError.ERROR_MESSAGE_FORMAT_NRP);
                return false;
            }
        }

        if (form.txtNrp.getText().length() != 9) {
            JOptionPane.showMessageDialog(form, MessageError.ERROR_MESSAGE_FORMAT_NRP_CHARACTER);

            return false;
        }

        //Validasi TextField Nama
        if (form.txtNama.getText().equals("")) {
            JOptionPane.showMessageDialog(form, MessageError.ERROR_MESSAGE_EMPTY_NAME);
            return false;
        }

        for (int i = 0; i < form.txtNama.getText().length(); i++) {
            if (Character.isDigit(form.txtNama.getText().charAt(i))) {
                JOptionPane.showMessageDialog(form, MessageError.ERROR_MESSAGE_FORMAT_NAME);
                return false;
            }
        }

        //Validasi TextField Alamat
        if (form.textAreaAlamat.getText().equals("")) {
            JOptionPane.showMessageDialog(form, MessageError.ERROR_MESSAGE_EMPTY_ADDRESS);
            return false;
        }

        //Validasi RadioButton Jenis Kelamin
        if (!form.rbLaki.isSelected() && !form.rbPerempuan.isSelected()) {
            JOptionPane.showMessageDialog(form, MessageError.ERROR_MESSAGE_EMPTY_GENDER);
            return false;
        }

        //Validasi ComboBox Dosen
        if (form.cbDosen.getSelectedItem().equals("--Pilih--")) {
            JOptionPane.showMessageDialog(form, MessageError.ERROR_MESSAGE_EMPTY_LECTURE);
            return false;
        }

        return true;
    }

    public void eksporFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Files", ".xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Save the dictionary file");
        String fileDictName = "mahasiswa.xlsx";
        fileChooser.setSelectedFile(new File(fileDictName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }

    public boolean insertFromXlsx() throws FileNotFoundException, IOException, SQLException, SQLException, IOException {
        XSSFRow row;
        ArrayList listmhs = new ArrayList();
        Form_Mahasiswa form = new Form_Mahasiswa();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open the file"); //name for chooser
        FileFilter filter = new FileNameExtensionFilter("Excel Documents", "xlsx"); //filter to show only that
        fileChooser.setAcceptAllFileFilterUsed(false); //to show or not all other files
        fileChooser.addChoosableFileFilter(filter);
        String fileDictName = "";
        fileChooser.setSelectedFile(new File(fileDictName)); //when you want to show the name of file into the chooser
        fileChooser.setVisible(true);
        int result = fileChooser.showOpenDialog(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
        }

        FileInputStream fis = new FileInputStream(new File(fileDictName));

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator< Row> rowIterator = spreadsheet.iterator();
        row = (XSSFRow) rowIterator.next();
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();

            Iterator< Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " \t\t ");
                        listmhs.add(cell.getNumericCellValue());
                        break;

                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + " \t\t ");
                        listmhs.add(cell.getStringCellValue());

                        break;
                }

            }
            //Query Insert
            Connection con = ac.ifunpas.psi2017.c.kel3.NamaAplikasi.ApachePoi.MyConnection.getConnection();
            try {
                Statement stat = con.createStatement();
                String query = " insert into mahasiswa (nrp, nama, alamat, jenis_kelamin, id_dosen)"
                        + " values (?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, (String) listmhs.get(0));
                preparedStmt.setString(2, (String) listmhs.get(1));
                preparedStmt.setString(3, (String) listmhs.get(2));
                preparedStmt.setString(4, "L");
                preparedStmt.setString(5, "1");
                // execute the preparedstatement
                preparedStmt.execute();

                con.close();
            } finally {
                if (con != null) {
                    con.close();
                }
            }
            System.out.println();
        }
        fis.close();
        return true;
    }

}