/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Admin_User;
import Modelo.Buf_Admin_UserDB;
import Modelo.Buf_Secretaria;
import Modelo.Buf_SecretariaDB;
import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import vista.V_Menu_Inicio;
import vista.V_Registro_Usuario;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Usuario {

    V_Registro_Usuario crearuser;
    V_Menu_Inicio inicio = new V_Menu_Inicio();

    Buf_Admin_User Admin = new Buf_Admin_User();
    Buf_Admin_UserDB AdminDB = new Buf_Admin_UserDB();
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
                if (evt.getSource() == crearuser.getPsw_contraseña()) {

                    char presionar = evt.getKeyChar();

                    if (presionar == KeyEvent.VK_ENTER) {

                        crearuser.getBtn_registar().doClick();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    crearuser.getBtn_registar().doClick();
                }
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

        char[] arrayC = crearuser.getPsw_contraseña().getPassword();
        String password = new String(arrayC);

        if (Validar_Datos() == true) {
            if (password.length() > 5) {
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

        char[] arrayC = crearuser.getPsw_contraseña().getPassword();
        String password = new String(arrayC);

        if (!crearuser.getTxt_cedula().getText().equals("") || !crearuser.getTxt_usuario().getText().isEmpty() || !password.isEmpty()) {
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

        char[] arrayC = crearuser.getPsw_contraseña().getPassword();
        String password = new String(arrayC);

        U.setCedula(crearuser.getTxt_cedula().getText());
        U.setUsuario(crearuser.getTxt_usuario().getText());
        U.setContrasenia(password);
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

        char[] arrayC = crearuser.getPsw_contraseña().getPassword();
        String password = new String(arrayC);

        if (crearuser.getTxt_cedula().getText().isEmpty()) {
            crearuser.getLb_cedula().setVisible(true);
            crearuser.getBtn_cancelar().setEnabled(false);
        }

        if (crearuser.getTxt_usuario().getText().isEmpty()) {
            crearuser.getLb_usuario().setVisible(true);
            crearuser.getBtn_cancelar().setEnabled(false);
        }

        if (password.isEmpty()) {
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

        if (!password.isEmpty()) {
            crearuser.getLb_contraseña().setVisible(false);
            crearuser.getBtn_cancelar().setEnabled(true);

            if (password.length() < 6) {

                crearuser.getLb_contracorta().setVisible(true);
                crearuser.getBtn_cancelar().setEnabled(true);
            } else {

                crearuser.getLb_contracorta().setVisible(false);
            }
        }

        if (!crearuser.getTxt_cedula().getText().isEmpty() && !crearuser.getTxt_usuario().getText().isEmpty() && !password.isEmpty()) {
            crearuser.getBtn_registar().setEnabled(true);
        } else {
            crearuser.getBtn_registar().setEnabled(false);
        }
    }

    public void Validar() {

        List<Buf_Usuarios> List_user = U_DB.Getter();
        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();

        if (inicio.getReg_abogado().isEnabled() || inicio.getReg_secretaria().isEnabled()) {
            if (List_user.isEmpty()) {
                if (inicio.getReg_abogado().isEnabled()) {
                    for (int i = 0; i < List_abg.size(); i++) {
                        if (List_abg.get(i).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                            crearuser.getTxt_id().setText(String.valueOf(List_abg.get(i).getId_abg()));
                            i = List_abg.size();
                        } else {
                            crearuser.getTxt_id().setText("");
                        }
                    }
                }
            }
            if (List_secre.isEmpty()) {

                if (inicio.getReg_abogado().isEnabled()) {
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
            }
            for (int j = 0; j < List_secre.size(); j++) {
                for (int u = 0; u < List_user.size(); u++) {
                    for (int i = 0; i < List_abg.size(); i++) {
                        if (inicio.getReg_abogado().isEnabled()) {
                            if (List_abg.get(i).getCedula().equals(crearuser.getTxt_cedula().getText())) {
                                crearuser.getTxt_id().setText(String.valueOf(List_abg.get(i).getId_abg()));
                                j = List_secre.size();
                                u = List_user.size();
                                i = List_abg.size();
                            } else {
                                crearuser.getTxt_id().setText("");
                            }
                        }
                        if (List_secre.get(j).getCedula().equals(crearuser.getTxt_cedula().getText())) {
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
        List<Buf_Admin_User> List_Adm = AdminDB.Getter();

        for (int i = 0; i < List_user.size(); i++) {
            for (int j = 0; j < List_Adm.size(); j++) {

                if (List_user.get(i).getCedula().equalsIgnoreCase(crearuser.getTxt_cedula().getText()) || List_user.get(i).getUsuario().equalsIgnoreCase(crearuser.getTxt_usuario().getText()) || List_Adm.get(j).getUsuario().equalsIgnoreCase(crearuser.getTxt_usuario().getText())) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public boolean Validar_Datos() {

        char[] arrayC = crearuser.getPsw_contraseña().getPassword();
        String password = new String(arrayC);

        if (!crearuser.getTxt_cedula().getText().equals("") && !crearuser.getTxt_usuario().getText().equals("") && !crearuser.getTxt_id().getText().equals("") && !password.isEmpty()) {

            return true;
        } else {

            return false;
        }
    }
}
