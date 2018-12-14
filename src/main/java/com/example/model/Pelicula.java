/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author estudiante
 */
public class Pelicula {
    
    private String pelicula;

    
    public Pelicula(String pelicula){
        this.pelicula=pelicula;
       
    
    }
    public void setPelicula(String pelicula){
        this.pelicula=pelicula;
    }
    public String getPelicula(){
        return pelicula;
    }
   @Override
    public String toString(){
        return String.format("Pelicula [nombre=%s]", pelicula);
    }
}
