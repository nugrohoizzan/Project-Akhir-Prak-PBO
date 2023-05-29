/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompormoto.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import kompormoto.Koneksi.Koneksi;
import kompormoto.Model.Model_Kendaraann;
import kompormoto.DAOImplement.Implement_Kendaraann;
import kompormoto.Model.Model_Kendaraann;



/**
 *
 * @author ASUS
 */
public class DAO_Kendaraann implements Implement_Kendaraann{
   Connection connection;
   
   final String select = "SELECT * FROM kendaraann;";
   final String insert = "INSERT INTO kendaraann (kode, nama, no_telepon, alamat, jenis, merk, harga, pajak, total) VALUES (?,?,?,?,?,?,?,?,?);";
   final String delete = "DELETE FROM kendaraann WHERE kode=?;";
   final String update = "UPDATE kendaraann set nama=?, no_telepon=?, alamat=?, jenis=?, merk=?, harga=?, pajak=?, total=? WHERE kode=?;";
   public DAO_Kendaraann(){
       connection = Koneksi.connection();
       
   }

    @Override
    public void insert(Model_Kendaraann b){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getKode());
            statement.setString(2, b.getNama());
            statement.setInt(3, b.getNo_telepon());
            statement.setString(4, b.getAlamat());
            statement.setString(5, b.getJenis());
            statement.setString(6, b.getMerk());
            statement.setString(7, b.getHarga());
            statement.setString(8, b.getPajak());
            statement.setString(9, b.getTotal());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setKode(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
     @Override
    public void update(Model_Kendaraann b){
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNama());
            statement.setInt(2, b.getNo_telepon());
            statement.setString(3, b.getAlamat());
            statement.setString(4, b.getJenis());
            statement.setString(5, b.getMerk());
            statement.setString(6, b.getHarga());
            statement.setString(7, b.getPajak());
            statement.setString(8, b.getTotal());
            statement.setString(9, b.getKode());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(String Kode){
        PreparedStatement statement = null;
       
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, Kode);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        
        String sql = "SELECT RIGHT(kode, 3) AS Nomor FROM kendaraan ORDER BY Nomor LIMIT 1";

        try{
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = String.format("TR%03d", nomor);
            }else {
                urutan = "TR001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Kendaraann.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(st !=null){
                try{
                    st.close();
                } catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Kendaraann.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return urutan; 
    }


    @Override
    public java.util.List<Model_Kendaraann> getCariNama(String nama){
        java.util.List<Model_Kendaraann> lb = null;
        String sql = "SELECT * FROM kendaraann WHERE kode LIKE '%"+nama+"%' OR nama LIKE '%"+nama+"%'";
         lb = new ArrayList<Model_Kendaraann>();
         
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Model_Kendaraann b = new Model_Kendaraann();
                b.setKode(rs.getString("kode"));
                b.setNama(rs.getString("nama"));
                b.setNo_telepon(rs.getInt("no_telepon"));
                b.setAlamat(rs.getString("alamat"));
                b.setJenis(rs.getString("jenis"));
                b.setMerk(rs.getString("merk"));
                b.setHarga(rs.getString("harga"));
                b.setPajak(rs.getString("pajak"));
                b.setTotal(rs.getString("total"));
                lb.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Kendaraann.class.getName()).log(Level.SEVERE, null, ex);
       } 
        return lb;
    }

    @Override
    public java.util.List<Model_Kendaraann> getALL(){
        java.util.List<Model_Kendaraann> lb = null;
        try{
            lb = new ArrayList<Model_Kendaraann>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                Model_Kendaraann b = new Model_Kendaraann();
                b.setKode(rs.getString("kode"));
                b.setNama(rs.getString("nama"));
                b.setNo_telepon(rs.getInt("no_telepon"));
                b.setAlamat(rs.getString("alamat"));
                b.setJenis(rs.getString("jenis"));
                b.setMerk(rs.getString("merk"));
                b.setHarga(rs.getString("harga"));
                b.setPajak(rs.getString("pajak"));
                b.setTotal(rs.getString("total"));
                lb.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Kendaraann.class.getName()).log(Level.SEVERE, null, ex);
       } 
        return lb;
    }



    
    

}