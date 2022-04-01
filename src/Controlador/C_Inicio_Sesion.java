/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Metodos.Validar_InicioSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.V_Inicio_Sesion;
import vista.V_Menu_Inicio;

/*
 * @author BRYAN_CABRERA
 */
public class C_Inicio_Sesion implements ActionListener {

    V_Inicio_Sesion sesion;
    Validar_InicioSesion V;

    public C_Inicio_Sesion(V_Inicio_Sesion sesion) {

        this.sesion = sesion;
        this.sesion.getBtn_ingresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sesion.getBtn_ingresar()) {

            validarDatos();
        }
    }

    public void validarDatos() {

        if (V.Validar_Campos() == true) {

            if ((V.Validar_Usuario() == true) && (V.Validar_Contraseña() == true)) {

                V_Menu_Inicio menu = new V_Menu_Inicio();
                menu.setVisible(true);
                sesion.setVisible(false);

            } else {

                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", "Error Datos", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos", "Compos Vacios", JOptionPane.ERROR_MESSAGE);
        }
    }
}
