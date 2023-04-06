
package domain;

public class Personal {
    private int idpersonal;
    private int idcatgrados;
    private String recibo;
    private int noempleado;
    private String nombre;
    private int idcatsector;
    private int idcatarmas;
    private int idcatsituacion;
    private String observaciones;

    public Personal() {
    }

    public Personal(int noempleado) {
        this.noempleado = noempleado;
    }

    public Personal(int idcatgrados, String recibo, int noempleado, String nombre, int idcatsector, 
            int idcatarmas, int idcatsituacion, String observaciones) {
        this.idcatgrados = idcatgrados;
        this.recibo = recibo;
        this.noempleado = noempleado;
        this.nombre = nombre;
        this.idcatsector = idcatsector;
        this.idcatarmas = idcatarmas;
        this.idcatsituacion = idcatsituacion;
        this.observaciones = observaciones;
    }

    public Personal(int idpersonal, int idcatgrados, String recibo, int noempleado, String nombre, 
            int idcatsector, int idcatarmas, int idcatsituacion, String observaciones) {
        this.idpersonal = idpersonal;
        this.idcatgrados = idcatgrados;
        this.recibo = recibo;
        this.noempleado = noempleado;
        this.nombre = nombre;
        this.idcatsector = idcatsector;
        this.idcatarmas = idcatarmas;
        this.idcatsituacion = idcatsituacion;
        this.observaciones = observaciones;
    }

    public int getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    public int getIdcatgrados() {
        return idcatgrados;
    }

    public void setIdcatgrados(int idcatgrados) {
        this.idcatgrados = idcatgrados;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public int getNoempleado() {
        return noempleado;
    }

    public void setNoempleado(int noempleado) {
        this.noempleado = noempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdcatsector() {
        return idcatsector;
    }

    public void setIdcatsector(int idcatsector) {
        this.idcatsector = idcatsector;
    }

    public int getIdcatarmas() {
        return idcatarmas;
    }

    public void setIdcatarmas(int idcatarmas) {
        this.idcatarmas = idcatarmas;
    }

    public int getIdcatsituacion() {
        return idcatsituacion;
    }

    public void setIdcatsituacion(int idcatsituacion) {
        this.idcatsituacion = idcatsituacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Personal{" + "idpersonal=" + idpersonal + ", idcatgrados=" + idcatgrados + ", recibo=" + recibo + ", noempleado=" + noempleado + ", nombre=" + nombre + ", idcatsector=" + idcatsector + ", idcatarmas=" + idcatarmas + ", idcatsituacion=" + idcatsituacion + ", observaciones=" + observaciones + '}';
    }
    
    
    
    
    
    
    
    
}
