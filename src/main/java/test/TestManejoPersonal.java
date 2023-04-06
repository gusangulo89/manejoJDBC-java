
package test;

import datos.PersonaDAO;
import domain.Personal;
import java.util.*;

public class TestManejoPersonal {
    public static void main(String[] args) {
        int cantRowsInsert;
        
        PersonaDAO personalDAO = new PersonaDAO();
        
        
        
        //Insertando un nuevo registro en la base de datos
        //Personal elementoNuevo = new Personal(1,"/foto",12121212,"ADRIAN GUSTAVO ANGULO MELENDEZ", 33, 4, 1, "REGISTRO DE PRUEBA JAVA");
//        cantRowsInsert = personalDAO.insertar(elementoNuevo);
//        System.out.println("Cantidad de Registros insertados = " + cantRowsInsert);
        //Modificar un registro
//        Personal elementoModif = new Personal(1,"/foto/img008.jpg",12121212,"ADRIAN G. ANGULO MELENDEZ", 33, 4, 1, "REGISTRO DE PRUEBA de Modificación JAVA");
//        int cantRowsUpdated = personalDAO.actualizar(elementoModif);

        //Eliminar un registro
        Personal elementoDelete =  new Personal(12121212);
        int cantRowsDeleted = personalDAO.eliminar(elementoDelete);
        System.out.println("Cantidad de Registros eliminados" + cantRowsDeleted);
        
        
        
        
        List<Personal> personal = personalDAO.selecciionar();
        
        for(Personal elementos: personal){
            System.out.println("Persona" + elementos);
        }
    }
}
