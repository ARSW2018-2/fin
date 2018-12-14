/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.restController;
import com.google.gson.reflect.TypeToken;



import com.google.gson.Gson;
import com.example.MongoDb.Apliccation;
import com.example.MongoDb.Compania;
import com.example.MongoDb.CompanyRepository;
import com.example.model.Pelicula;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.services.InformationServices;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.HashMap;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author dicom
 */

@RestController
@RequestMapping(value = "/info")
//@Service
//@SpringBootApplication
public class CompaniaAPIController {
    
    @Autowired
    InformationServices infoServices;
                    //CIudad-frecuencia                //Cudad-frecuencia
    private HashMap <String, Object> empresas = new HashMap <String, Object> ();
    
    @RequestMapping(method = RequestMethod.GET,value="/{pelicula}/{ano}")
    public ResponseEntity<?> getOrders(@PathVariable("pelicula") String pelicula, @PathVariable("ano") String ano){
        try{
             Gson gson = new Gson();
            String[] palabras = pelicula.split(" ");
            String pelfin="";
            
            for (String palabra : palabras)
            {
                pelfin+=palabra+"+";           
            }
            if(infoServices.findAccion(pelfin)){
                //return new ResponseEntity<>(empresas.get(compania),HttpStatus.ACCEPTED);
                return new ResponseEntity<>(infoServices.getAcciones(pelfin, ano),HttpStatus.ACCEPTED);
            }else{
                //base.almacenar(compania,infoServices.getAcciones(frecuencia, compania));
                infoServices.saveAcciones(pelfin, (String)infoServices.getAcciones(pelfin,ano));
                //empresas.put(compania,);
                return new ResponseEntity<>(infoServices.getAcciones(pelfin,ano),HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            Logger.getLogger(CompaniaAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }
    
       @RequestMapping(method = RequestMethod.GET,value="/{pelicula}")
    public ResponseEntity<?> g(@PathVariable("pelicula") String pelicula){
        try{
             Gson gson = new Gson();
            String[] palabras = pelicula.split(" ");
            String pelfin="";
            
            for (String palabra : palabras)
            {
                pelfin+=palabra+"+";
            }
            if(infoServices.findAccion(pelfin)){
                //return new ResponseEntity<>(empresas.get(compania),HttpStatus.ACCEPTED);
                return new ResponseEntity<>(infoServices.getAcciones(pelfin),HttpStatus.ACCEPTED);
            }else{
                //base.almacenar(compania,infoServices.getAcciones(frecuencia, compania));
                infoServices.saveAcciones(pelfin, (String)infoServices.getAcciones(pelfin));
                //empresas.put(compania,);
                return new ResponseEntity<>(infoServices.getAcciones(pelfin),HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            Logger.getLogger(CompaniaAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    } 
}
