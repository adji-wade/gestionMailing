/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.dao;

import sn.isi.entities.Mail;

/**
 *
 * @author adji
 */
public class MailImp implements IMail{
   BD db = new BD();
    @Override
    public int Add(Mail m) throws Exception {
        db.open();

      
        String sql = "INSERT INTO mail VALUES (null ,?, ?, ?)";
        db.init(sql);
        db.getPst().setString(1,m.getObjet());
        db.getPst().setString(2,m.getCorps());
        db.getPst().setInt(3,m.getClient().getId());

        int ok = db.executeUpdate();
        return ok   ;
    }
    
}
