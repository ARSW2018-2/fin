/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MongoDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2098325
 */
//@SpringBootApplication
@Service
public class Apliccation {
    @Autowired
    private CompanyRepository repositorio;
    
        
    public void almacenar(String nombre, Object objec)throws Exception{
        repositorio.deleteAll();
        repositorio.save(new Compania(nombre, (String)objec));
        
    }
    
    public Boolean founRegister(String nombreCompania){
        Boolean resp=false;
        /*
        if(repositorio.existsById(nombreCompania)){
            resp=true;
        }*/
        return resp;
    }
    public String getRegister(String Nombre){
        //return new Compania();
        //return repositorio.findByName(Nombre);
       return "";
   
    }
   
}
