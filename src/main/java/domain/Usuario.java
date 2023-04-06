
package domain;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private int idcatrol;
    private int useractivado;

    public Usuario() {
    }

    public Usuario(int id, String username, String password, String nombre, 
            String apellido, int idcatrol, int useractivado) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idcatrol = idcatrol;
        this.useractivado = useractivado;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdcatrol() {
        return idcatrol;
    }

    public void setIdcatrol(int idcatrol) {
        this.idcatrol = idcatrol;
    }

    public int getUseractivado() {
        return useractivado;
    }

    public void setUseractivado(int useractivado) {
        this.useractivado = useractivado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + ", idcatrol=" + idcatrol + ", useractivado=" + useractivado + '}';
    }
       
}
