
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Cita {
    
    private int id_cita;
    private String cedula;
    private String num_celular;
    private String descripcion;
    private String nom_caso;
    private int id_caso;
    private String hora;

    public Buf_Cita(int id_cita, String cedula, String num_celular, String descripcion, String nom_caso, int id_caso, String hora) {
        this.id_cita = id_cita;
        this.cedula = cedula;
        this.num_celular = num_celular;
        this.descripcion = descripcion;
        this.nom_caso = nom_caso;
        this.id_caso = id_caso;
        this.hora = hora;
    }

    public Buf_Cita() {
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNum_celular() {
        return num_celular;
    }

    public void setNum_celular(String num_celular) {
        this.num_celular = num_celular;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNom_caso() {
        return nom_caso;
    }

    public void setNom_caso(String nom_caso) {
        this.nom_caso = nom_caso;
    }

    public int getId_caso() {
        return id_caso;
    }

    public void setId_caso(int id_caso) {
        this.id_caso = id_caso;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
