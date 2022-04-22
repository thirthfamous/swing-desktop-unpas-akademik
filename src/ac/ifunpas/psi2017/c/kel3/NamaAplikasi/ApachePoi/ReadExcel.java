/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ifunpas.psi2017.c.kel3.NamaAplikasi.ApachePoi;

/**
 *
 * @author thirthfamous
 */
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    static XSSFRow row;

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("mahasiswa.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator< Row> rowIterator = spreadsheet.iterator();
        row = (XSSFRow) rowIterator.next();
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();

            Iterator< Cell> cellIterator = row.cellIterator();
            ArrayList listmhs = new ArrayList();
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
            Connection con = MyConnection.getConnection();
            try {
                Statement stat = con.createStatement();
                String query = " insert into mahasiswa (nrp, nama, alamat, jenis_kelamin, id_dpp, id_dosen)"
                        + " values (?, ?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, (String) listmhs.get(0));
                preparedStmt.setString(2, (String) listmhs.get(1));
                preparedStmt.setString(3, (String) listmhs.get(2));
                preparedStmt.setString(4, (String) listmhs.get(3));
                preparedStmt.setString(5, "1");
                preparedStmt.setString(6, "1");
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
    }
}
