/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.MongoDb.Apliccation;
import com.example.MongoDb.Compania;
import com.example.conection.HttpConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author dicom
 */
@Service
public class InfoServicesStub implements InformationServices{
    @Autowired
    HttpConnection conection;

    
    @Autowired
    Apliccation repository;
    
    @Override
    public Object getAcciones(String frecuencia, String compania) throws InfoServicesException {
        conection.connect(frecuencia, compania);
        try {
            conection.run();
            return conection.getResult();
            
        } catch (Exception e) {
            Logger.getLogger(InfoServicesStub.class.getName()).log(Level.SEVERE,null, e);
            throw new InfoServicesException("Error conectando");
            
        }
        
    }

    @Override
    public Object getAcciones(String frecuencia) throws InfoServicesException {
        conection.connect(frecuencia);
        try {
            conection.run();
            return conection.getResult();
            
        } catch (Exception e) {
            Logger.getLogger(InfoServicesStub.class.getName()).log(Level.SEVERE,null, e);
            throw new InfoServicesException("Error conectando");
            
        }
        
    }

    @Override
    public String getNombreAcciones(String nombre) {
        return repository.getRegister(nombre);
    }

    @Override
    public Boolean findAccion(String compania) throws InfoServicesException {
        return repository.founRegister(compania);
    }

    @Override
    public void saveAcciones(String nombre, String datos) throws InfoServicesException {
        try {
            repository.almacenar(nombre, datos);
        } catch (Exception ex) {
            Logger.getLogger(InfoServicesStub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
