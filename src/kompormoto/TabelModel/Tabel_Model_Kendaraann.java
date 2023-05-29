/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompormoto.TabelModel;

import kompormoto.Model.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import kompormoto.Model.Model_Kendaraann;

/**
 *
 * @author ASUS
 */
public class Tabel_Model_Kendaraann extends AbstractTableModel{
    
    java.util.List<Model_Kendaraann> list_kendaraan;
    
    public Tabel_Model_Kendaraann(java.util.List<Model_Kendaraann> list_kendaraan){
        this.list_kendaraan = list_kendaraan;
    }
    

    @Override
    public int getRowCount() {
        return list_kendaraan.size(); 
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "KODE";
            case 1:
                return "NAMA";
            case 2:
                return "NO TELEPON";
            case 3:
                return "ALAMAT";
            case 4:
                return "JENIS";
            case 5:
                return "MERK";
            case 6:
                return "HARGA";
            case 7: 
                return "PAJAK";
            case 8:
                return "TOTAL";
            default:
                return null;
             
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return list_kendaraan.get(row).getKode();
            case 1:
                return list_kendaraan.get(row).getNama();
            case 2:
                return list_kendaraan.get(row).getNo_telepon();
            case 3:
                return list_kendaraan.get(row).getAlamat();
            case 4:
                return list_kendaraan.get(row).getJenis();
            case 5:
                return list_kendaraan.get(row).getMerk();
            case 6:
                return list_kendaraan.get(row).getHarga();
            case 7: 
                return list_kendaraan.get(row).getPajak();
            case 8:
                return list_kendaraan.get(row).getTotal();
            default:
                return null;
             
        }
    }

    
    
}
