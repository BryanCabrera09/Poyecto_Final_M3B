/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Mvc;

import vista.Inicio_Sesion;
import vista.MenuInicio;

/**
 *
 * @author Andy
 */
public class main {
    public static void main(String[] args) {
        //aqui solo dejan el que necesiten que inicie primero por logica seria el sesion.
        
        Inicio_Sesion inicio_Sesion=new Inicio_Sesion();
        ctrl_inicio_sesion ctrlI=new ctrl_inicio_sesion(inicio_Sesion);
        //ctrlI.sesion.setVisible(true);
        MenuInicio inicio=new MenuInicio();
        ctrlMenuInicio ctrlInicio=new ctrlMenuInicio(inicio);
        ctrlInicio.iniciar();
    }
}
