
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Consulta {
    
    private int id_consulta;
    private String nombre;
    private String apellido;
    private String descripcion;
    private String caso;
    private String hora;

    public Buf_Consulta(int id_consulta, String nombre, String apellido, String descripcion, String caso, String hora) {
        this.id_consulta = id_consulta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.caso = caso;
        this.hora = hora;
    }

    public Buf_Consulta() {
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaso() {
        return caso;
    }

    public void setCaso(String caso) {
        this.caso = caso;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
