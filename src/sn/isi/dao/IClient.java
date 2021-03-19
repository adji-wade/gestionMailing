/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.dao;

import java.util.List;
import sn.isi.entities.Client;

/**
 *
 * @author adji
 */
public interface IClient {
  
    public int Add(Client c) throws Exception;
    public int Delete(int id) throws Exception;
    public int update(Client c) throws Exception;
    public Client get(int id) throws Exception;
    public List<Client> liste() throws Exception;

    
}
