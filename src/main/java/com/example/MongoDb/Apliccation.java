/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MongoDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 *
 * @author 2098325
 */
//@SpringBootApplication
public class Apliccation implements CommandLineRunner {
    @Autowired
    private CompanyRepository repositorio;
    
        
    public void almacenar(String nombre, Object objec)throws Exception{
        repositorio.deleteAll();
        repositorio.save(new Compania(nombre, (String)objec));
        
    }
    
    public Boolean founRegister(String nombreCompania){
        Boolean resp=false;
        if(repositorio.findByName(nombreCompania)!=null){
            resp=true;
        }
        
        return resp;
    }
    public Compania getRegister(String Nombre){
        return repositorio.findByName(Nombre);
   
    }
    
    @Override
    public void run(String... strings) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
