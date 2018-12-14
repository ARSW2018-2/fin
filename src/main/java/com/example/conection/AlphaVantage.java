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
public class AlphaVantage implements Provider{

    @Override
    public String getUrl(String pelicula, String año) {
        String r="http://www.omdbapi.com/?t="+pelicula+"&y="+año+"&apikey=fc4de1fa";       
        return "http://www.omdbapi.com/?t="+pelicula+"&y="+año+"&apikey=fc4de1fa";
    }

    @Override
    public String getUrl(String pelicula) {
        String r="http://www.omdbapi.com/?t="+pelicula+"&apikey=fc4de1fa";
        return "http://www.omdbapi.com/?t="+pelicula+"&apikey=fc4de1fa";
    }
    
}
