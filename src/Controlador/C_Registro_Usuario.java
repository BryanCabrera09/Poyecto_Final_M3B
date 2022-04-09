/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Secretaria;
import Modelo.Buf_SecretariaDB;
import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import vista.V_Registro_Usuario;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Usuario {

    V_Registro_Usuario crearuser;
    Buf_Usuarios U = new Buf_Usuarios();
    Buf_SecretariaDB S_DB = new Buf_SecretariaDB();
    Buf_UsuariosDB U_DB = new Buf_UsuariosDB();
    Buf_AbogadoDB A_DB = new Buf_AbogadoDB();

    public C_Registro_Usuario(V_Registro_Usuario crearuser) {

        this.crearuser = crearuser;

        Nuevo();
        Campos();
    }

    public void Iniciar_Control() {

        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == crearuser.getTxt_usuario()) {
                    int key = evt.getKeyChar();

                    if (crearuser.getTxt_usuario().getText().length() <= 20) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32 || key >= 48 && key <= 57;

                        if (!letra) {

                            evt.consume();
                        }

                    } else {

                        evt.consume();
                    }
                }
                if (evt.getSource() == crearuser.getTxt_cedula()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && crearuser.getTxt_cedula().getText().length() <= 9) {

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
                if (evt.getSource() == crearuser.getTxt_cedula()) {

                    Campo_Vacio();
                }
                if (evt.getSource() == crearuser.getTxt_usuario()) {

                    Campo_Vacio();
                }
                if (evt.getSource() == crearuser.getPsw_contraseña()) {

                    Campo_Vacio();
                }
            }
        };
        //INICIAR KEYS
        crearuser.getTxt_cedula().addKeyListener(K);
        crearuser.getTxt_usuario().addKeyListener(K);
        crearuser.getPsw_contraseña().addKeyListener(K);

        //INICIAR BOTONES
        crearuser.getBtn_registar().addActionListener(l -> {
            Registrar();
        });
        crearuser.getBtn_cancelar().addActionListener(l -> {
            Cancelar_Registro();
        });
        crearuser.getBtn_nuevo().addActionListener(l -> {
            Nuevo_Registro();
        });
    }

    public void Registrar() {

        if (Validar_Datos() == true) {
            if (crearuser.getPsw_contraseña().getText().length() > 5) {
                if (Validar_Registro() == true) {
                    if (Usuario_Creado() == true) {
                        if (Validar_Usuario() == true) {
                            int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:
                                    Subir_Datos();
                                    break;
                                case 1:
                                    JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                    break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario Ya Registrado");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya Cuenta Con Un Registro");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no Registrado");
                }
            } else {
                Campo_Vacio();
                JOptionPane.showMessageDialog(null, "Longitud de Contraseña Incorrecta");
            }
        } else {
            Campo_Vacio();
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
        }
    }

    public void Cancelar_Registro() {

        if (!crearuser.getTxt_cedula().getText().equals("") || !crearuser.getTxt_usuario().getText().equals("") || !crearuser.getPsw_contraseña().getText().equals("")) {
            int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
            switch (salir) {
                case 0:
                    Cancelar();
                    Nuevo();
                    Campos();
                    crearuser.getBtn_cancelar().setEnabled(false);
                    break;
                case 1:
                    Campo_Vacio();
                    break;
            }
        }
    }

    public void Nuevo_Registro() {

        crearuser.getTxt_cedula().setEditable(true);
        crearuser.getTxt_usuario().setEditable(true);
        crearuser.getPsw_contraseña().setEditable(true);
    }

    public void Subir_Datos() {

        U.setCedula(crearuser.getTxt_cedula().getText());
        U.setUsuario(crearuser.getTxt_usuario().getText());
        U.setContrasenia(crearuser.getPsw_contraseña().getText());
        U.setId_User(Integer.parseInt(crearuser.getTxt_id().getText()));

        if (U_DB.Register(U)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            Nuevo();
            Campos();
            crearuser.getBtn_cancelar().setEnabled(false);
        }
    }

    public void Nuevo() {

        crearuser.getBtn_cancelar().setEnabled(false);
        crearuser.getBtn_registar().setEnabled(false);
        crearuser.getTxt_cedula().setEditable(false);
        crearuser.getTxt_usuario().setEditable(false);
        crearuser.getPsw_contraseña().setEditable(false);
        crearuser.getTxt_id().setEditable(false);
        crearuser.getTxt_cedula().setText("");
        crearuser.getTxt_usuario().setText("");
        crearuser.getPsw_contraseña().setText("");
        crearuser.getTxt_id().setText("");
    }

    public void Cancelar() {

        crearuser.getTxt_cedula().setText("");
        crearuser.getTxt_usuario().setText("");
        crearuser.getPsw_contraseña().setText("");
        crearuser.getTxt_id().setText("");
    }

    public void Campos() {
        crearuser.getLb_cedula().setVisible(false);
        crearuser.getLb_usuario().setVisible(false);
        crearuser.getLb_contraseña().setVisible(false);
        crearuser.getLb_contracorta().setVisible(false);
        crearuser.getLb_existente().setVisible(false);
        crearuser.getLb_registro().setVisible(false);
    }

    public void Campo_Vacio() {

        if (crearuser.getTxt_cedula().getText().isEmpty()) {
            crearuser.getLb_cedula().setVisible(true);
            crearuser.getBtn_cancelar().setEnabled(false);
        }

        if (crearuser.getTxt_usuario().getText().isEmpty()) {
            crearuser.getLb_usuario().setVisible(true);
            crearuser.getBtn_cancelar().setEnabled(false);
        }

        if (crearuser.getPsw_contraseña().getText().isEmpty()) {
            crearuser.getLb_contraseña().setVisible(true);
            crearuser.getBtn_cancelar().setEnabled(false);
        }

        if (!crearuser.getTxt_cedula().getText().isEmpty()) {
            crearuser.getLb_cedula().setVisible(false);
            crearuser.getBtn_cancelar().setEnabled(true);

            Validar();
        }

        if (!crearuser.getTxt_usuario().getText().isEmpty()) {
            crearuser.getLb_usuario().setVisible(false);
            crearuser.getBtn_cancelar().setEnabled(true);

            List<Buf_Usuarios> List_user = U_DB.Getter();

            for (int i = 0; i < List_user.size(); i++) {
                if (List_user.get(i).getUsuario().equalsIgnoreCase(crearuser.getTxt_usuario().getText())) {
                    crearuser.getLb_existente().setVisible(true);
                } else {
                    crearuser.getLb_existente().setVisible(false);
                }
            }
        }

        if (!crearuser.getPsw_contraseña().getText().isEmpty()) {
            crearuser.getLb_contraseña().setVisible(false);
            crearuser.getBtn_cancelar().setEnabled(true);

            if (crearuser.getPsw_contraseña().getText().length() < 6) {

                crearuser.getLb_contracorta().setVisible(true);
                crearuser.getBtn_cancelar().setEnabled(true);
            } else {

                crearuser.getLb_contracorta().setVisible(false);
            }
        }

        if (!crearuser.getTxt_cedula().getText().equals("") && !crearuser.getTxt_usuario().getText().equals("") && !crearuser.getPsw_contraseña().getText().equals("")) {
            crearuser.getBtn_registar().setEnabled(true);
        } else {
            crearuser.getBtn_registar().setEnabled(false);
        }
    }

    public void Validar() {

        List<Buf_Usuarios> List_user = U_DB.Getter();
        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();

        if (List_user.isEmpty()) {
            for (int i = 0; i < List_abg.size(); i++) {
                if (List_abg.get(i).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                    crearuser.getTxt_id().setText(String.valueOf(List_abg.get(i).getId_abg()));
                    i = List_abg.size();
                } else {
                    crearuser.getTxt_id().setText("");
                }
            }
        }
        if (List_secre.isEmpty()) {

            for (int i = 0; i < List_user.size(); i++) {
                for (int p = 0; p < List_abg.size(); p++) {
                    if (List_abg.get(p).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                        crearuser.getTxt_id().setText(String.valueOf(List_abg.get(p).getId_abg()));
                        i = List_user.size();
                        p = List_abg.size();
                    } else {
                        crearuser.getTxt_id().setText("");
                    }
                    if (List_user.get(i).getCedula().equals(crearuser.getTxt_cedula().getText()) && List_abg.get(p).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                        crearuser.getLb_registro().setVisible(true);
                    } else if (!List_user.get(i).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                        crearuser.getLb_registro().setVisible(false);
                    }
                }
            }
        }
        for (int j = 0; j < List_secre.size(); j++) {
            for (int u = 0; u < List_user.size(); u++) {
                for (int i = 0; i < List_abg.size(); i++) {
                    if (List_abg.get(i).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                        crearuser.getTxt_id().setText(String.valueOf(List_abg.get(i).getId_abg()));
                        j = List_secre.size();
                        u = List_user.size();
                        i = List_abg.size();
                    } else if (List_secre.get(j).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                        crearuser.getTxt_id().setText(String.valueOf(List_secre.get(j).getId_secretaria()));
                        j = List_secre.size();
                        u = List_user.size();
                        i = List_abg.size();
                    } else {
                        crearuser.getTxt_id().setText("");
                    }
                    if (List_user.get(u).getCedula().equals(crearuser.getTxt_cedula().getText()) && List_abg.get(i).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                        crearuser.getLb_registro().setVisible(true);
                    } else if ((List_user.get(u).getCedula().equals(crearuser.getTxt_cedula().getText()) && List_secre.get(j).getCedula().equals(crearuser.getTxt_cedula().getText()))) {
                        crearuser.getLb_registro().setVisible(true);
                    } else if (!List_user.get(u).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                        crearuser.getLb_registro().setVisible(false);
                    }
                }
            }
        }
    }

    public boolean Validar_Registro() {

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();

        if (List_secre.isEmpty()) {
            for (int i = 0; i < List_abg.size(); i++) {
                if (List_abg.get(i).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                    return true;
                }
            }
            return false;
        }

        for (int j = 0; j < List_secre.size(); j++) {
            for (int i = 0; i < List_abg.size(); i++) {
                if (List_abg.get(i).getCedula().equals(crearuser.getTxt_cedula().getText()) || List_secre.get(j).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean Usuario_Creado() {

        List<Buf_Usuarios> List_user = U_DB.Getter();

        for (int i = 0; i < List_user.size(); i++) {
            if (List_user.get(i).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Usuario() {

        List<Buf_Usuarios> List_user = U_DB.Getter();

        for (int i = 0; i < List_user.size(); i++) {
            if (List_user.get(i).getCedula().equalsIgnoreCase(crearuser.getTxt_cedula().getText()) || List_user.get(i).getUsuario().equalsIgnoreCase(crearuser.getTxt_usuario().getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Datos() {

        if (!crearuser.getTxt_cedula().getText().equals("") && !crearuser.getTxt_usuario().getText().equals("") && !crearuser.getTxt_id().getText().equals("") && !crearuser.getPsw_contraseña().getText().equals("")) {

            return true;
        } else {

            return false;
        }
    }
}
