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
    public String getUrl(String frecuencia, String compania) {
        String fercuen="";
        
        switch(frecuencia){
            case "intraDia": fercuen="TIME_SERIES_INTRADAY&symbol=";
            break;
            case "Diaria":fercuen="TIME_SERIES_DAILY&symbol=";
            break;
            case "Semanal":fercuen="TIME_SERIES_WEEKLY&symbol=";
            break;
            case "Mensual":fercuen="TIME_SERIES_MONTHLY&symbol=";
            break;        
            default: fercuen="TIME_SERIES_INTRADAY&symbol=";
            break;
        }        
                //https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=&symbol=intraDia&interval=5min&outputsize=full&apikey=MV0DMAP8H86105CT
        return "https://www.alphavantage.co/query?function="+fercuen+"&symbol="+compania+"&interval=5min&outputsize=full&apikey=MV0DMAP8H86105CT";
                
    }


    
}


