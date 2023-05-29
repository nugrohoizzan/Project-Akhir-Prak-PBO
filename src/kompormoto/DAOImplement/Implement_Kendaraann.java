/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompormoto.DAOImplement;

import java.util.List;
import kompormoto.Model.Model_Kendaraann;

/**
 *
 * @author ASUS
 */
public interface Implement_Kendaraann {
    public void insert(Model_Kendaraann b);
    public void update(Model_Kendaraann b);
    public void delete(String kode);
  
    public java.util.List<Model_Kendaraann> getALL();
    public java.util.List<Model_Kendaraann> getCariNama(String nama);
    
    
    String nomor();
    
   
}
