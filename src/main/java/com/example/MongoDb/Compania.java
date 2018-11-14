/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MongoDb;

import java.util.Locale;
import org.springframework.data.annotation.Id;

/**
 *
 * @author 2098325
 */
public class Compania {
    @Id
    public String Nombre;
    public String Frecuencia;
    public String json;
    public Compania(){}
    
    
    public Compania(String Nombre, String Frecuencia){
        this.Nombre=Nombre;
        this.Frecuencia=Frecuencia;
        this.json=Nombre+"/"+Frecuencia;
    
    }
    @Override
    public String toString(){
    
        return String.format("Compania con [nombre=%s, frecuencia='%s']", Nombre, Frecuencia);
    }
    
    
}
