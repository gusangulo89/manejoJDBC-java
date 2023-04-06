package datos;

import domain.Personal;
import java.sql.*;
import java.util.*;

public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT idpersonal, idcatgrados, recibo, noempleado, "
            + "nombre, idcatsector, idcatarmas, idcatsituacion, observaciones  FROM personal ORDER BY idpersonal DESC LIMIT 5";
    private static final String SQL_INSERT = "INSERT INTO personal (idcatgrados, recibo, noempleado, "
            + "nombre, idcatsector, idcatarmas, idcatsituacion, observaciones ) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE personal SET idcatgrados = ?, recibo = ? , noempleado = ?, "
            + "nombre = ?, idcatsector = ?, idcatarmas = ?, idcatsituacion = ?, observaciones = ?  WHERE noempleado = ?";
    private static final String SQL_DELETE = "DELETE FROM personal WHERE noempleado = ?";
     

    public List<Personal> selecciionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Personal> personas = new ArrayList<>();

        try {
            conn = Conexion.getConnection(); //Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_SELECT); //Se genera una consulta preparada
            rs = stmt.executeQuery(); //Con esta instrucción se ejecuta el query

            while (rs.next()) {
                int idPersona        = rs.getInt("idpersonal");
                int idCatGrados      = rs.getInt("idcatgrados");
                String recibo        = rs.getString("recibo");
                int noempleado       = rs.getInt("noempleado");
                String nombre        = rs.getString("nombre");
                int idcatsector      = rs.getInt("idcatsector");
                int idcatarmas       = rs.getInt("idcatarmas");
                int idcatsituacion   = rs.getInt("idcatsituacion");
                String observaciones = rs.getString("observaciones");

                Personal persona = new Personal(idPersona, idCatGrados, recibo,
                        noempleado, nombre, idcatsector, idcatarmas, idcatsituacion, observaciones);

                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs); //Se cierra el objeto resulset
                Conexion.close(stmt); //Se cierra el objeto del prepared statement
                Conexion.close(conn); // Se cierra la conexion con la base de datos
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return personas;
    }
    
    public int insertar(Personal elemento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,elemento.getIdcatgrados());
            stmt.setString(2,elemento.getRecibo());
            stmt.setInt(3,elemento.getNoempleado());
            stmt.setString(4,elemento.getNombre());
            stmt.setInt(5,elemento.getIdcatsector());
            stmt.setInt(6,elemento.getIdcatarmas());
            stmt.setInt(7,elemento.getIdcatsituacion());
            stmt.setString(8,elemento.getObservaciones());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int actualizar(Personal elemento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,elemento.getIdcatgrados());
            stmt.setString(2,elemento.getRecibo());
            stmt.setInt(3,elemento.getNoempleado());
            stmt.setString(4,elemento.getNombre());
            stmt.setInt(5,elemento.getIdcatsector());
            stmt.setInt(6,elemento.getIdcatarmas());
            stmt.setInt(7,elemento.getIdcatsituacion());
            stmt.setString(8,elemento.getObservaciones());
            stmt.setInt(9,elemento.getNoempleado());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int eliminar(Personal elemento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,elemento.getNoempleado());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }

}
