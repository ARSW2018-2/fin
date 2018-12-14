/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.example.conection.HttpConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.services.InformationServices;

/**
 *
 * @author dicom
 */
@RunWith(SpringRunner.class)

@SpringBootTest(classes={com.example.Main.class})
public class InfoServicesStubTest {
    @Autowired
    private HttpConnection coneccion1;
    @Autowired
    private HttpConnection coneccion2;
    @Autowired
    private HttpConnection coneccion3;
    
    @Test
    public void getInfoTest(){
            
           
        try {
            coneccion1.connect("The Avengers");
            coneccion2.connect("The Social Network","2010");
            coneccion3.connect("The Social Network");
            coneccion1.run();
            coneccion2.run();
            coneccion3.run();
            String respuesta1 = coneccion1.getResult();
            String respuesta2 = coneccion2.getResult();
            String respuesta3 = coneccion3.getResult();
            System.out.println("dsadsa"+respuesta1);
            String g=respuesta1.substring(0,10);
            assertEquals(g, "{\"Title\":\"The Avengers\",\"Year\":\"2012\",\"Rated\":\"PG-13\",\"Released\":\"04 May 2012\",\"Runtime\":\"143 min\"");
            assertEquals(respuesta2.substring(0,125), "{\"Title\":\"The Social Network\",\"Year\":\"2010\",\"Rated\":\"PG-13\",\"Released\":\"01 Oct 2010\",\"Runtime\":\"120 mi");
            assertEquals(respuesta3.substring(0,125), "{\"Title\":\"The Social Network\",\"Year\":\"2010\",\"Rated\":\"PG-13\",\"Released\":\"01 Oct 2010\",\"Runtime\":\"120 mi");
        } catch (IOException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

