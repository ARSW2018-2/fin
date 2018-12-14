/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.conection;

import org.springframework.stereotype.Service;

/**
 *
 * @author dicom
 */
@Service
public interface Provider {
    
    public String getUrl(String frecuencia, String compania);
    public String getUrl(String pelicula);
    
}
