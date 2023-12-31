package com.codoacodo.test;

import com.codoacodo.dao.OradorDAO;
import com.codoacodo.model.Orador;
import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OradorTest {
    
   static Logger logger = LoggerFactory.getLogger(OradorTest.class);
    
   public static void main(String[] args) throws SQLException, NullPointerException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
       List<Orador> oradores = new ArrayList();
       OradorDAO dao = new OradorDAO();
        
        //selecciono los registros de oradores en la tabla y los asigno a oradores.
        //Despues itero la lista con un iterator
        oradores = dao.selectOradores();
        
        Iterator<Orador> it = oradores.iterator();
        while(it.hasNext()) {
         logger.info("Orador: " + it.next());
        }
        
        //Creo un orador para insertarlo a la db
        Orador oraUno = new Orador("Tomás", "Perez", "tomi@mail.com", "musica clásica");

        dao.insertarOrador(oraUno);
        oradores = dao.selectOradores();
        
       for (Orador next : oradores) {
           logger.info(next.toString());
       } // Actualizo un orador existente.
   
    //Orador oraExistente = new Orador( "Pablo", "Iglesias", "pigle @gmail.com", "Rock nacional", Timestamp.valueOf(LocalDateTime.now()));"etrabajos@mail.com", "El matrimonio es como una naranja", Timestamp.valueOf(LocalDateTime.now()));
     //dao.actualizarOrador(oraExistente, apellido, mail, tema);
        
        oradores = dao.selectOradores();
        
        //recorro
        for(Orador ora: oradores) {
       logger.info(ora.toString());
       }
        
        //Long idOrador = ;
        //dao.eliminarOrador(idOrador);
        
        oradores = dao.selectOradores();
        for (Orador oradore : oradores) {
            logger.info(oradore.toString());
        }
        
    }
    
}
