
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Admin_User {
    
    private String cedula;
    private String usuario;
    private String contrasenia;

    public Buf_Admin_User(String cedula, String usuario, String contrasenia) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Buf_Admin_User() {
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
