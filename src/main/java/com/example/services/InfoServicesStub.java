/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.conection.HttpConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dicom
 */
@Service
public class InfoServicesStub implements InformationServices{
    @Autowired
    HttpConnection conection;
   
    
    @Override
    public Object getInfo(String frecuencia, String compania) throws InfoServicesException {
        conection.connect(frecuencia, compania);
        try {
            conection.run();
            return conection.getResult();
            
        } catch (Exception e) {
            Logger.getLogger(InfoServicesStub.class.getName()).log(Level.SEVERE,null, e);
            throw new InfoServicesException("Error conectando");
            
        }
        
    }
    
}
