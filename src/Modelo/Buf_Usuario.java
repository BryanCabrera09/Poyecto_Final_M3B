
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Usuario {
    
    private int id_abg;
    private String cedula;
    private String usuario;
    private String contrasenia;

    public Buf_Usuario(int id_abg, String cedula, String usuario, String contrasenia) {
        this.id_abg = id_abg;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Buf_Usuario() {
    }

    public int getId_abg() {
        return id_abg;
    }

    public void setId_abg(int id_abg) {
        this.id_abg = id_abg;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
