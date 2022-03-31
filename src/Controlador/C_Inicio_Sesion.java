/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Inicio_Sesion;
import vista.MenuInicio;
import static vista.RegistroUsuario.listausuario;

/*
 * @author BRYAN_CABRERA
 */
public class C_Inicio_Sesion implements ActionListener{
    Inicio_Sesion sesion;

    public C_Inicio_Sesion(Inicio_Sesion sesion) {
        this.sesion = sesion;
        this.sesion.btnIngresar.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==sesion.btnIngresar) {
            validarDatos();
        }
    }
    public void validarDatos(){
        int con = 0;
        for (int i = 0; i < listausuario.size(); i++) {
            System.out.println(listausuario.get(i).getCedula() + "" + listausuario.get(i).getUsuario() + "" + listausuario.get(i).getContraseña());
            if (listausuario.get(i).getUsuario().equals(sesion.txt_usuario.getText()) && listausuario.get(i).getContraseña().equals(sesion.psw_contraseña.getText())) {
                MenuInicio menu = new MenuInicio();
                menu.setVisible(true);
                sesion.setVisible(false);
                con = 1;
            }
//            } else {
//                txt_usuario.setText("");
//                psw_contraseña.setText("");
////                JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS", "", 0);
//            }
        }
        if (con != 1) {
            if (sesion.txt_usuario.getText().equals("Admin") && sesion.psw_contraseña.getText().equals("1234")) {
                MenuInicio menu = new MenuInicio();
                menu.setVisible(true);
                sesion.setVisible(false);
            } else {
                sesion.txt_usuario.setText("");
                sesion.psw_contraseña.setText("");
            }
        }
    }
}

