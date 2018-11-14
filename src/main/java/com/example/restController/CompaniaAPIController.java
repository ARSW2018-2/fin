/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.restController;
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

/**
 *
 * @author dicom
 */

@RestController
@RequestMapping(value = "/info")
@Service
public class CompaniaAPIController {
    
    @Autowired
    InformationServices infoServices;
                    //CIudad-frecuencia                //Cudad-frecuencia
    private HashMap <String, Object> empresas = new HashMap <String, Object> ();
    
    @RequestMapping(method = RequestMethod.GET,value="/{frecuencia}/{compania}")
    public ResponseEntity<?> getOrders(@PathVariable("frecuencia") String frecuencia, @PathVariable("compania") String compania){
        try{
            if(empresas.containsKey(compania)){
                return new ResponseEntity<>(empresas.get(compania),HttpStatus.ACCEPTED);
            }else{
                empresas.put(compania,infoServices.getInfo(frecuencia,compania));
                return new ResponseEntity<>(infoServices.getInfo(frecuencia,compania),HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            Logger.getLogger(CompaniaAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }
}
