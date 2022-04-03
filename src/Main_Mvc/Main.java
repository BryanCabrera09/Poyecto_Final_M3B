/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Mvc;

import controlador.C_Menu_Inicio;
import vista.V_Inicio_Sesion;
import vista.V_Menu_Inicio;

/**
 *
 * @author Andy
 */
public class Main {

    public static void main(String[] args) {

        //aqui solo dejan el que necesiten que inicie primero por logica seria el sesion.
//        V_Inicio_Sesion inicio_Sesion=new V_Inicio_Sesion();
//            C_Inicio_Sesion ctrlI=new    C_Inicio_Sesion(inicio_Sesion);
        //ctrlI.sesion.setVisible(true);
        V_Menu_Inicio inicio = new V_Menu_Inicio();
        C_Menu_Inicio iniciar = new C_Menu_Inicio(inicio);
        iniciar.Iniciar();
    }
}
