
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Usuarios {
    
    private int id_user;
    private String cedula;
    private String usuario;
    private String contrasenia;

    public Buf_Usuarios(int id_user, String cedula, String usuario, String contrasenia) {
        this.id_user = id_user;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Buf_Usuarios() {
    }

    public int getId_User() {
        return id_user;
    }

    public void setId_User(int id_user) {
        this.id_user= id_user;
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
