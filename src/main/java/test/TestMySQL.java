
package test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestMySQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3308/fuerzatarea2020java?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
//          Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","root"); 
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT idpersonal, noempleado, recibo, nombre FROM personal limit 10";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                System.out.println("Id Persona: " + resultado.getInt("idpersonal"));
                System.out.println("No Empleado: " + resultado.getInt("noempleado"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Recibo: " + resultado.getString("recibo"));
                System.out.println("");
            }
            
            resultado.close();
            instruccion.close();
            conexion.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
