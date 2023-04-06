package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioJDBC {

    private static final String SQL_SELECT = "SELECT id, nombre, apellido, username, idcatrol,"
            + "password, useractivado FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios (nombre, apellido, "
            + "username, idcatrol, password, useractivado) values (?, ?, ?, ?, ?, ?, 1)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, apellido = ? , idcatrol = ?, "
            + "password = ?, useractivado = ? WHERE username = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE username = ?";
     

    public List<Usuario> selecciionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection(); //Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_SELECT); //Se genera una consulta preparada
            rs = stmt.executeQuery(); //Con esta instrucción se ejecuta el query

            while (rs.next()) {
                int id           = rs.getInt("id");
                String nombre    = rs.getString("nombre");
                String apellido  = rs.getString("apellido");
                String username  = rs.getString("username");
                int idcatrol     = rs.getInt("idcatrol");
                String password  = rs.getString("password");
                int useractivado = rs.getInt("useractivado");
                
               
                Usuario usuarioRow = new Usuario(id, username, password, nombre, apellido, idcatrol, useractivado);

                usuarios.add(usuarioRow);
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

        return usuarios;
    }
    
    public int insertar(Usuario userOperator){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,userOperator.getId());
            stmt.setString(2,userOperator.getNombre());
            stmt.setString(3,userOperator.getApellido());
            stmt.setString(4,userOperator.getUsername());
            stmt.setInt(5,userOperator.getIdcatrol());
            stmt.setString(6,userOperator.getPassword());
            stmt.setInt(7,userOperator.getUseractivado());
            registros = stmt.executeUpdate(); //Se ejecuta la inserción del registro
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
    
    public int actualizar(Usuario elemento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1,elemento.getNombre());
            stmt.setString(2,elemento.getApellido());
            stmt.setInt(3,elemento.getIdcatrol());
            stmt.setString(4,elemento.getPassword());
            stmt.setInt(5,elemento.getUseractivado());
            stmt.setString(6,elemento.getUsername());
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
    
    public int eliminar(Usuario elemento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1,elemento.getUsername());
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
