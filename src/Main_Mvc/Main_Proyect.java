/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Mvc;

import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import controlador.C_Inicio_Sesion;
import controlador.C_Menu_Inicio;
import java.util.List;
import vista.V_Inicio_Sesion;
import vista.V_Menu_Inicio;

/*
 * @author BRYAN_CABRERA
 */
public class Main_Proyect {

    public static void main(String[] args) {

        V_Inicio_Sesion inicio_Sesion = new V_Inicio_Sesion();
        Buf_UsuariosDB userDB = new Buf_UsuariosDB();
        Buf_Usuarios U = new Buf_Usuarios();

        List<Buf_Usuarios> List_user = userDB.Getter();

        if (List_user.isEmpty()) {
            V_Menu_Inicio inicio = new V_Menu_Inicio();
            C_Menu_Inicio ctrlInicio = new C_Menu_Inicio(inicio);
            ctrlInicio.Iniciar_Control();
        } else {
            C_Inicio_Sesion ctrlI = new C_Inicio_Sesion(inicio_Sesion, userDB, U);

            ctrlI.Iniciar_Control();
        }
    }
}
