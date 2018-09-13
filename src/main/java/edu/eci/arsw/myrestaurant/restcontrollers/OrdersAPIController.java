/*
 * Copyright (C) 2016 Pivotal Software, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.arsw.myrestaurant.restcontrollers;

import edu.eci.arsw.myrestaurant.context.OrdersRestaurantConfig;
import edu.eci.arsw.myrestaurant.model.Order;
import edu.eci.arsw.myrestaurant.model.ProductType;
import edu.eci.arsw.myrestaurant.model.RestaurantProduct;
import edu.eci.arsw.myrestaurant.services.RestaurantOrderServices;
import edu.eci.arsw.myrestaurant.services.RestaurantOrderServicesStub;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */



    @RestController
    @RequestMapping(value = "/orders")
public class OrdersAPIController {
    @Autowired
     RestaurantOrderServices mOrdenes;
    
    @CrossOrigin("*")
    @RequestMapping(value="/{numTable}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getOrdersByTable(@PathVariable Integer numTable){
        try {
                ApplicationContext cxt = 
                    new AnnotationConfigApplicationContext(OrdersRestaurantConfig.class);
                RestaurantOrderServices  re=cxt.getBean(RestaurantOrderServicesStub.class) ;
                //Set<Integer> data = re.getTablesWithOrders();
                Order data = re.getTableOrder(numTable);
                if(re.getTableOrder(numTable)==null){
                    throw new Exception();
                }else{
                    return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
                }
        } catch (Exception ex) {
                Logger.getLogger(OrdersAPIController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }  
    }
    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> manejadorPostRecursoOrdenes(@RequestBody Order orden){
        try {
            mOrdenes.addNewOrderToTable(orden);
            return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception ex) {
        Logger.getLogger(OrdersAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error hola",HttpStatus.FORBIDDEN);            
            }        
        }
    
    @RequestMapping(value="/or",method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrders(){
             try {
                ApplicationContext cxt = 
                    new AnnotationConfigApplicationContext(OrdersRestaurantConfig.class);
                RestaurantOrderServices  re=cxt.getBean(RestaurantOrderServicesStub.class) ;
                //Set<Integer> data = re.getTablesWithOrders();
                Map<Integer, Order> data = re.getTableOders();
                return new ResponseEntity<>(data,HttpStatus.ACCEPTED);

                
        } catch (Exception ex) {
                Logger.getLogger(OrdersAPIController.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }  
    
    
    }
    

    @RequestMapping(path = "/{numTable}/total" , method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetTotalOrden(@PathVariable Integer numTable){
        try {
            //obtener datos que se enviarán a través del API
                        
            return new ResponseEntity<>(mOrdenes.calculateTableBill(numTable), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(OrdersAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/{numTable}",method = RequestMethod.PUT)    
    public ResponseEntity<?> manejadorPostRecursoSetPlato(@PathVariable Integer numTable, @RequestBody String food){
        try {            
            Map<Integer, Order>  data=mOrdenes.getTableOders();
            data.get(numTable).addDish(food, 0);
          
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(OrdersAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.FORBIDDEN);            
        }        

    }


}