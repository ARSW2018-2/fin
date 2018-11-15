/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.MongoDb;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author 2098325
 */
public interface CompanyRepository extends MongoRepository<Compania,String>{
    
    //public String findByName(String nombreCompany);
    //public List<String> findByFrecuency(String Frecuencia);
    
}
