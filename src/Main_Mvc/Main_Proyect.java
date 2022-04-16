/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Mvc;

import controlador.C_Inicio_Sesion;
import vista.V_Inicio_Sesion;

/*
 * @author BRYAN_CABRERA
 */
public class Main_Proyect {

    public static void main(String[] args) {

        V_Inicio_Sesion inicio_Sesion = new V_Inicio_Sesion();
        C_Inicio_Sesion ctrlI = new C_Inicio_Sesion(inicio_Sesion);
        ctrlI.Iniciar_Control();
    }
}
