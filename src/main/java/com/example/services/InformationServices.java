/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;
import com.example.services.InfoServicesException;


/**
 *
 * @author dicom
 */

public interface InformationServices {
    public Object getAcciones(String frecuencia, String compania)throws InfoServicesException;
    public String getNombreAcciones(String nombre)throws InfoServicesException;
    public Boolean findAccion(String compania)throws InfoServicesException;
    public void saveAcciones(String nombre, String datos)throws InfoServicesException;
    
}
