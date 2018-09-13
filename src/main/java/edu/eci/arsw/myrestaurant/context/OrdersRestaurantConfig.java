/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.myrestaurant.context;
import edu.eci.arsw.myrestaurant.beans.BillCalculator;
import edu.eci.arsw.myrestaurant.beans.impl.BasicBillCalculator;
import edu.eci.arsw.myrestaurant.model.Order;
import edu.eci.arsw.myrestaurant.model.RestaurantProduct;
import edu.eci.arsw.myrestaurant.services.RestaurantOrderServices;
import edu.eci.arsw.myrestaurant.services.RestaurantOrderServicesStub;
import java.util.Map;
import org.springframework.context.annotation.*;
/**
 *
 * @author 2098325
 */

@Configuration
public class OrdersRestaurantConfig {
    
    @Bean
    public RestaurantOrderServices restaurantOrderServices(){
        RestaurantOrderServicesStub  pr=new RestaurantOrderServicesStub();
        pr.setBillCalculator(basicBillCalculator());
        return pr;
    
    }
    @Bean
    public BillCalculator  basicBillCalculator (){
        return new BasicBillCalculator();
        
        
        
    
    }
    
    
}
