/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.restController;
import com.example.MongoDb.Apliccation;
import com.example.MongoDb.Compania;
import com.example.MongoDb.CompanyRepository;
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
    
    @RequestMapping(method = RequestMethod.GET,value="/{frecuencia}/{compania}")
    public ResponseEntity<?> getOrders(@PathVariable("frecuencia") String frecuencia, @PathVariable("compania") String compania){
        try{
            //if(empresas.containsKey(compania)){
            //if(base.founRegister(compania)){
            if(infoServices.findAccion(compania)){
                //return new ResponseEntity<>(empresas.get(compania),HttpStatus.ACCEPTED);
                return new ResponseEntity<>(infoServices.getAcciones(frecuencia, compania),HttpStatus.ACCEPTED);
            }else{
                //base.almacenar(compania,infoServices.getAcciones(frecuencia, compania));
                infoServices.saveAcciones(compania, (String)infoServices.getAcciones(frecuencia,compania));
                //empresas.put(compania,);
                return new ResponseEntity<>(infoServices.getAcciones(frecuencia,compania),HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            Logger.getLogger(CompaniaAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }


    
}
