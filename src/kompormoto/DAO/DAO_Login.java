/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompormoto.DAO;

import kompormoto.View.View_Dashboard;
import kompormoto.Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kompormoto.Model.Model_Login;
import kompormoto.DAOImplement.Implement_Login;
import kompormoto.View.View_Login;


/**
 *
 * @author ASUS
 */
public class DAO_Login implements Implement_Login{
    private Connection con;
    
    public DAO_Login(){
        con = Koneksi.connection();
    }

    @Override
    public void prosesLogin(Model_Login modlogin) {
        PreparedStatement st = null;
        ResultSet rs         = null;
        String Id            = null;
        String Nama          = null;
        String Jabatan        = null;
        String sql = "SELECT * FROM pengguna WHERE(id_pengguna='"+modlogin.getId_user()+"' "+"OR username='"+modlogin.getUsername()+"')"+"AND password='"+modlogin.getPass_user()+"'";
    
    try{
        st = con.prepareStatement(sql);
        rs = st.executeQuery();
        if(rs.next()){
            Id = rs.getString("id_pengguna");
            Nama = rs.getString("nama_pengguna");
            Jabatan = rs.getString("jabatan");
            
            View_Dashboard menu = new View_Dashboard(Id, Nama, Jabatan);
            menu.setVisible(true);
            menu.revalidate();
            
            View_Login lg = new View_Login();
            lg.tutup = true;
            
        } else{
            JOptionPane.showMessageDialog(null, "Username dah Password Salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            View_Login lg = new View_Login();
            lg.tutup = false;
        }
    } catch(SQLException ex){
        Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
    } finally{
        if(st!=null){
            try{
                st.close();
            }catch(SQLException ex){
                Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
}
