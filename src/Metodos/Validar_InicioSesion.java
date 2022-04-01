
package Metodos;

import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import java.util.List;
import vista.V_Inicio_Sesion;

/*
 * @author BRYAN_CABRERA
 */
public class Validar_InicioSesion {
    
    private V_Inicio_Sesion inicio;
    private Buf_UsuariosDB userDB;
    
    public void Campos() {

        inicio.getTxt_usuario().setText("");
        inicio.getPsw_contraseña().setText("");
        inicio.getLb_contra().setVisible(false);
        inicio.getLb_usuario().setVisible(false);
    }
    
    public void Campo_Vacio() {

        if (inicio.getTxt_usuario().getText().isEmpty()) {
            
            inicio.getLb_usuario().setVisible(true);
        }
        if (inicio.getPsw_contraseña().getText().isEmpty()) {
            
            inicio.getLb_contra().setVisible(true);
        }
        
        if (!(inicio.getTxt_usuario().getText().isEmpty())) {
            
            inicio.getLb_usuario().setVisible(false);
        }
        if (!(inicio.getPsw_contraseña().getText().isEmpty())) {
            
            inicio.getLb_contra().setVisible(false);
        } 
    }
    
    public boolean Validar_Usuario() {

        List<Buf_Usuarios> List_usr = userDB.Getter();
        
        for (int i = 0; i < List_usr.size(); i++) {
            if (List_usr.get(i).getUsuario().equals(inicio.getTxt_usuario().getText())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean Validar_Contraseña() {

        List<Buf_Usuarios> List_usr = userDB.Getter();
        
        for (int i = 0; i < List_usr.size(); i++) {
            if (List_usr.get(i).getContrasenia().equals(inicio.getPsw_contraseña().getText())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean Validar_Campos(){
        
        if (!(inicio.getTxt_usuario().getText().isEmpty()) && !(inicio.getPsw_contraseña().getText().isEmpty())) {
            
            return true;
        } else {
            
            return false;
        }
    }
}
