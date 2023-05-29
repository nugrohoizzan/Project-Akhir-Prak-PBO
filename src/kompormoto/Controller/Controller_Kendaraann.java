/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompormoto.Controller;
import javax.swing.JOptionPane;
import kompormoto.DAO.DAO_Kendaraann;
import kompormoto.Model.Model_Kendaraann;
import kompormoto.TabelModel.Tabel_Model_Kendaraann;
import kompormoto.View.View_Kendaraann;
import java.util.List;
import kompormoto.DAOImplement.Implement_Kendaraann;
/**
 *
 * @author ASUS
 */
public class Controller_Kendaraann {
    View_Kendaraann frame_kendaraann;
    Implement_Kendaraann implemet_kendaraann;
    List<Model_Kendaraann> list_kendaraann;
    
    public Controller_Kendaraann(View_Kendaraann frame_kendaraan){
        this.frame_kendaraann = frame_kendaraan;
        implemet_kendaraann = new DAO_Kendaraann();
        list_kendaraann = implemet_kendaraann.getALL();
        Tabel_Model_Kendaraann tmb = new Tabel_Model_Kendaraann(list_kendaraann);
        
    }
    
    //Tombol Reset
    public void reset(){
        frame_kendaraann.getTxtkode1().setText("");
        frame_kendaraann.getTxtnama1().setText("");
        frame_kendaraann.getTxttelepon1().setText("");
        frame_kendaraann.getTxtnalamat1().setText("");
        frame_kendaraann.getCbjenis1().setSelectedItem("--Silahkan Pilih--");
        frame_kendaraann.getTxtharga1().setText("");
        frame_kendaraann.getTxtpajak1().setText("");
        frame_kendaraann.getTxttotal1().setText("");
        frame_kendaraann.getTxtcari().setText("");
    }
    
    //Tampil Data Ke Tabel
    public void isiTable(){
        list_kendaraann = implemet_kendaraann.getALL();
        Tabel_Model_Kendaraann tmb = new Tabel_Model_Kendaraann(list_kendaraann);
        frame_kendaraann.getTbdata().setModel(tmb);
    }
    
     public void isiField(int row){
        frame_kendaraann.getTxtkode().setText(list_kendaraann.get(row).getKode());
        frame_kendaraann.getTxtnama().setText(list_kendaraann.get(row).getNama());
        frame_kendaraann.getTxttelepon().setText(list_kendaraann.get(row).getNo_telepon().toString());
        frame_kendaraann.getTxtalamat().setText(list_kendaraann.get(row).getAlamat());
        frame_kendaraann.getCbjenis().setSelectedItem(list_kendaraann.get(row).getJenis());
        frame_kendaraann.getTxtmerk().setText(list_kendaraann.get(row).getMerk());
        frame_kendaraann.getTxtharga().setText(list_kendaraann.get(row).getHarga());
        frame_kendaraann.getTxtpajak().setText(list_kendaraann.get(row).getPajak());
        frame_kendaraann.getTxttotal().setText(list_kendaraann.get(row).getTotal());
        
    }
     
     public void isiLabel(int row){
         frame_kendaraann.getLbkode().setText(list_kendaraann.get(row).getKode());
         frame_kendaraann.getLbnama().setText(list_kendaraann.get(row).getNama());
         frame_kendaraann.getLbnotelp().setText(list_kendaraann.get(row).getNo_telepon().toString());
         frame_kendaraann.getLbalamat().setText(list_kendaraann.get(row).getAlamat());
         frame_kendaraann.getLbjenis().setText(list_kendaraann.get(row).getJenis());
         frame_kendaraann.getLbmerk().setText(list_kendaraann.get(row).getMerk());
         frame_kendaraann.getLbharga().setText(list_kendaraann.get(row).getHarga());
         frame_kendaraann.getLbpajak().setText(list_kendaraann.get(row).getPajak());
         frame_kendaraann.getLbtotal().setText(list_kendaraann.get(row).getTotal());
     }
     
    public void insert(){
        if(!frame_kendaraann.getTxtkode1().getText().trim().isEmpty()& !frame_kendaraann.getTxtnama1().getText().trim().isEmpty()& !frame_kendaraann.getTxttelepon1().getText().trim().isEmpty()& !frame_kendaraann.getTxtnalamat1().getText().trim().isEmpty()& !frame_kendaraann.getTxtmerk1().getText().trim().isEmpty()& !frame_kendaraann.getTxtharga1().getText().trim().isEmpty()& !frame_kendaraann.getTxtpajak1().getText().trim().isEmpty()& !frame_kendaraann.getTxttotal1().getText().trim().isEmpty()){
            Model_Kendaraann b = new Model_Kendaraann();
            
            b.setKode(frame_kendaraann.getTxtkode1().getText());
            b.setNama(frame_kendaraann.getTxtnama1().getText());
            b.setNo_telepon(Integer.parseInt(frame_kendaraann.getTxttelepon1().getText()));
            b.setAlamat(frame_kendaraann.getTxtnalamat1().getText());
            b.setJenis(frame_kendaraann.getCbjenis1().getSelectedItem().toString()); 
            b.setMerk(frame_kendaraann.getTxtmerk1().getText());
            b.setMerk(frame_kendaraann.getTxtmerk1().getText());
            b.setHarga(frame_kendaraann.getTxtharga1().getText());
            b.setPajak(frame_kendaraann.getTxtpajak1().getText());
            b.setTotal(frame_kendaraann.getTxttotal1().getText());
            
            implemet_kendaraann.insert(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        } else {
            JOptionPane.showMessageDialog(frame_kendaraann, "Data Tidak Boleh Kosong");
        }
    }
    
    //Update Data Dari Tabel Ke Database
    public void update(){
        if(!frame_kendaraann.getTxtkode().getText().trim().isEmpty()){
            Model_Kendaraann b = new Model_Kendaraann();
            b.setNama(frame_kendaraann.getTxtnama().getText());
            b.setNo_telepon(Integer.parseInt(frame_kendaraann.getTxttelepon().getText()));
            b.setAlamat(frame_kendaraann.getTxtalamat().getText());
            b.setJenis(frame_kendaraann.getCbjenis().getSelectedItem().toString());
            b.setMerk(frame_kendaraann.getTxtmerk().getText());
            b.setHarga(frame_kendaraann.getTxtharga().getText());
            b.setPajak(frame_kendaraann.getTxtpajak().getText());
            b.setTotal(frame_kendaraann.getTxttotal().getText());
            b.setKode(frame_kendaraann.getTxtkode().getText());
            
            implemet_kendaraann.update(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_kendaraann, "Silahkan Pilih Data Yang Akan Di Update");
        }
    }
    
    //Hapus Data Pada Tabel
    public void delete(){
        if(!frame_kendaraann.getTxtkode().getText().trim().isEmpty()){
            String kode = frame_kendaraann.getTxtkode().getText();
            implemet_kendaraann.delete(kode);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_kendaraann, "Silahkan Pilih Data Yang Akan Di Hapus");
        }
    }
    
     //Cari Data
    public void isiTableCariNama(){
        list_kendaraann = implemet_kendaraann.getCariNama(frame_kendaraann.getTxtcari().getText());
        Tabel_Model_Kendaraann tmb = new Tabel_Model_Kendaraann(list_kendaraann);
        frame_kendaraann.getTbdata().setModel(tmb);
    }
    
    public void carinama(){
        if(!frame_kendaraann.getTxtcari().getText().trim().isEmpty()){
            implemet_kendaraann.getCariNama(frame_kendaraann.getTxtcari().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_kendaraann, "Silahkan Pilih Data !!!");
        }
    }
    
}
