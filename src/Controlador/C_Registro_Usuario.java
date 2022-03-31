/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import static vista.RegistroAbogado.Lista_abogado;
import static vista.RegistroSecretaria.Lista_Secretaria;
import vista.RegistroUsuario;
import static vista.RegistroUsuario.listausuario;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Usuario implements ActionListener, KeyListener {

    RegistroUsuario registroUsuario;

    public C_Registro_Usuario(RegistroUsuario registroUsuario) {
        this.registroUsuario = registroUsuario;
        this.registroUsuario.btn_registar.addActionListener(this);
        this.registroUsuario.btncancelar.addActionListener(this);
        this.registroUsuario.btnnuevo.addActionListener(this);

        this.registroUsuario.txt_cedula.addKeyListener(this);
        this.registroUsuario.txt_usuario.addKeyListener(this);
        this.registroUsuario.psw_contraseña.addKeyListener(this);

        Nuevo();
        Campos();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == registroUsuario.btn_registar) {
            if (!registroUsuario.txt_cedula.getText().equals("") && !registroUsuario.txt_usuario.getText().equals("") && !registroUsuario.psw_contraseña.getText().equals("")) {
                int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                switch (resp) {
                    case 0:
                        ValidarRegistro();
                        Nuevo();
                        Campos();
                        registroUsuario.btncancelar.setEnabled(false);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                        break;
                }
            } else {
                Campo_Vacio();
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            }
        }
        if (evt.getSource() == registroUsuario.btncancelar) {
            if (!registroUsuario.txt_cedula.getText().equals("") || !registroUsuario.txt_usuario.getText().equals("") || !registroUsuario.psw_contraseña.getText().equals("")) {
                int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
                switch (salir) {
                    case 0:
                        Cancelar();
                        Nuevo();
                        Campos();
                        registroUsuario.btncancelar.setEnabled(false);
                        break;
                    case 1:
                        Campo_Vacio();
                        break;
                }
            }
        }
        if (evt.getSource() == registroUsuario.btnnuevo) {
            registroUsuario.txt_cedula.setEditable(true);
            registroUsuario.txt_usuario.setEditable(true);
            registroUsuario.psw_contraseña.setEditable(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == registroUsuario.txt_usuario) {
            int key = evt.getKeyChar();

            if (registroUsuario.txt_usuario.getText().length() <= 20) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32 || key >= 48 && key <= 57;

                if (!letra) {

                    evt.consume();
                }

            } else {

                evt.consume();
            }
        }
        if (evt.getSource() == registroUsuario.txt_cedula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && registroUsuario.txt_cedula.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent evt) {

    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getSource() == registroUsuario.txt_cedula) {

            Campo_Vacio();
        }
        if (evt.getSource() == registroUsuario.txt_usuario) {

            Campo_Vacio();
        }
        if (evt.getSource() == registroUsuario.psw_contraseña) {

            Campo_Vacio();
        }
    }

    public void ValidarRegistro() {
        //VALIDACION CEDULA
        int x = 0;
        int y = 0;
        int z = 0;
        boolean usuario = false;

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCedula().equals(registroUsuario.txt_cedula.getText())) {
                for (int j = 0; j < listausuario.size(); j++) {
                    if (listausuario.get(j).getCedula().equals(registroUsuario.txt_cedula.getText())) {
                        z = 1;
                        break;
                    } else {
                        usuario = true;
                        break;
                    }
                }
                usuario = true;
                break;
            }
        }
        for (int j = 0; j < Lista_Secretaria.size(); j++) {
            if (Lista_Secretaria.get(j).getCedula().equals(registroUsuario.txt_cedula.getText())) {
                boolean cedula = false;
                for (int q = 0; q < listausuario.size(); q++) {
                    if (listausuario.get(q).getCedula().equals(registroUsuario.txt_cedula.getText())) {
                        z = 1;
                        cedula = true;
                        break;
                    } else {
                        usuario = true;
                    }
                }
                if (cedula == false) {
                    usuario = true;
                }
                break;

            }
        }
        //VALIDACION USUARIO
        boolean ced = false;
        if (usuario == true) {
            for (int a = 0; a < listausuario.size(); a++) {
                if (listausuario.get(a).getUsuario().equals(registroUsuario.txt_usuario.getText()) || listausuario.get(a).getCedula().equals(registroUsuario.txt_cedula.getText())) {
                    x = 1;
                    ced = true;
                    break;
                }
            }

            if (ced == false) {
                Usuario usu = new Usuario(registroUsuario.txt_cedula.getText(), registroUsuario.txt_usuario.getText(), registroUsuario.psw_contraseña.getText());
                listausuario.add(usu);
                y = 1;
            }

            if (listausuario.size() < 1) {
                System.out.println("hola");
                Usuario usu = new Usuario(registroUsuario.txt_cedula.getText(), registroUsuario.txt_usuario.getText(), registroUsuario.psw_contraseña.getText());
                listausuario.add(usu);
                y = 1;
            }

        }
        if (usuario == false && z == 0) {
            JOptionPane.showMessageDialog(null, "CEDULA NO EXISTE", "", 0);
            registroUsuario.txt_cedula.setText("");
            registroUsuario.txt_usuario.setText("");
            registroUsuario.psw_contraseña.setText("");
        }

        if (y == 1) {
            JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO CORRECTAMENTE", "", 1);
            registroUsuario.txt_cedula.setText("");
            registroUsuario.txt_usuario.setText("");
            registroUsuario.psw_contraseña.setText("");
        }
        if (x == 1) {
            JOptionPane.showMessageDialog(null, "ESTE USUARIO YA EXISTE", "", 0);
            z = 0;
            registroUsuario.txt_usuario.setText("");
            registroUsuario.psw_contraseña.setText("");
        }
        if (z == 1) {
            JOptionPane.showMessageDialog(null, "ESTA CEDULA YA TIENE UN USUARIO", "", 0);
            registroUsuario.txt_cedula.setText("");
            registroUsuario.txt_usuario.setText("");
            registroUsuario.psw_contraseña.setText("");
        }
    }

    public void Campo_Vacio() {

        if (registroUsuario.txt_cedula.getText().isEmpty()) {
            registroUsuario.cedula.setVisible(true);
            registroUsuario.btncancelar.setEnabled(false);
        }

        if (registroUsuario.txt_usuario.getText().isEmpty()) {
            registroUsuario.usuario.setVisible(true);
            registroUsuario.btncancelar.setEnabled(false);
        }

        if (registroUsuario.psw_contraseña.getText().isEmpty()) {
            registroUsuario.contraseña.setVisible(true);
            registroUsuario.btncancelar.setEnabled(false);
        }

        if (!registroUsuario.txt_cedula.getText().isEmpty()) {
            registroUsuario.cedula.setVisible(false);
            registroUsuario.btncancelar.setEnabled(true);
        }

        if (!registroUsuario.txt_usuario.getText().isEmpty()) {
            registroUsuario.usuario.setVisible(false);
            registroUsuario.btncancelar.setEnabled(true);
        }

        if (!registroUsuario.psw_contraseña.getText().isEmpty()) {
            registroUsuario.contraseña.setVisible(false);
            registroUsuario.btncancelar.setEnabled(true);
        }

        if (!registroUsuario.txt_cedula.getText().equals("") && !registroUsuario.txt_usuario.getText().equals("") && !registroUsuario.psw_contraseña.getText().equals("")) {
            registroUsuario.btn_registar.setEnabled(true);
        } else {
            registroUsuario.btn_registar.setEnabled(false);
        }
    }

    public void Nuevo() {

        registroUsuario.btncancelar.setEnabled(false);
        registroUsuario.btn_registar.setEnabled(false);
        registroUsuario.txt_cedula.setEditable(false);
        registroUsuario.txt_usuario.setEditable(false);
        registroUsuario.psw_contraseña.setEditable(false);
        registroUsuario.txt_cedula.setText("");
        registroUsuario.txt_usuario.setText("");
        registroUsuario.psw_contraseña.setText("");
    }

    public void Cancelar() {

        registroUsuario.txt_cedula.setText("");
        registroUsuario.txt_usuario.setText("");
        registroUsuario.psw_contraseña.setText("");
    }

    public void Campos() {
        registroUsuario.cedula.setVisible(false);
        registroUsuario.usuario.setVisible(false);
        registroUsuario.contraseña.setVisible(false);
    }
}
