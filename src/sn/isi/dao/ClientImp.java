/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.dao;

import com.mysql.cj.xdevapi.Result;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sn.isi.entities.Client;

/**
 *
 * @author adji
 */
public class ClientImp implements IClient{
        BD db = new BD();
    @Override
    public int Add(Client c) throws Exception {
        db.open();
         String sql = "INSERT INTO client VALUES (null, ?, ?, ?,?)";
        db.init(sql);
        db.getPst().setString(1,c.getPrenom());
        db.getPst().setString(2,c.getNom());
        db.getPst().setString(3,c.getEmail());
        db.getPst().setString(4,c.getTel());

        int ok = db.executeUpdate();
        return ok   ;
    }

    @Override
    public int Delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Client c) throws Exception {
         db.open();
      
        String sql = "UPDATE client SET prenom = ?, nom = ?, email = ?,  tel = ? WHERE id = ?";
        db.init(sql);
        db.getPst().setString(1,c.getPrenom());
        db.getPst().setString(2,c.getNom());
        db.getPst().setString(3,c.getEmail());
        db.getPst().setString(4,c.getTel());
        db.getPst().setInt(5,c.getId());


        int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public Client get(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> liste() throws Exception {
       
        List<Client> lClient = new ArrayList<>();
        db.open();
        String sql = "SELECT * FROM client";
        db.init(sql);
        ResultSet rset = db.executeSelect();
        while(rset.next()){
            Client c = new Client();
            c.setId(rset.getInt(1));
            c.setPrenom(rset.getString(2));
            c.setNom(rset.getString(3));
            c.setEmail(rset.getString(4));
            c.setTel(rset.getString(5));
            lClient.add(c);
        }
        return lClient;
    }
        
   
    
    
}
