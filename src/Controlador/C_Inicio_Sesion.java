/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import Vista.V_RecuperarContraseña;
import Controlador.C_Recuperar_Contraseña;
import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Admin_User;
import Modelo.Buf_Admin_UserDB;
import Modelo.Buf_Secretaria;
import Modelo.Buf_SecretariaDB;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import vista.V_Inicio_Sesion;
import vista.V_Menu_Inicio;

/*
 * @author BRYAN_CABRERA
 */
public class C_Inicio_Sesion {

    V_Inicio_Sesion sesion = new V_Inicio_Sesion();
    V_Menu_Inicio inicio = new V_Menu_Inicio();

    Buf_UsuariosDB userDB = new Buf_UsuariosDB();
    Buf_Usuarios U = new Buf_Usuarios();
    Buf_Admin_User Admin = new Buf_Admin_User();
    Buf_Admin_UserDB AdminDB = new Buf_Admin_UserDB();

    Buf_AbogadoDB A_DB = new Buf_AbogadoDB();
    Buf_Abogado A = new Buf_Abogado();
    Buf_SecretariaDB S_DB = new Buf_SecretariaDB();
    Buf_Secretaria S = new Buf_Secretaria();

    public C_Inicio_Sesion(V_Inicio_Sesion sesion) {

        this.sesion = sesion;

        Campos();

        sesion.setVisible(true);
        sesion.setLocationRelativeTo(null);
    }

    public void Iniciar_Control() {

        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    sesion.getBtn_ingresar().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        sesion.getPsw_contraseña().addKeyListener(K);
        sesion.getTxt_usuario().addKeyListener(K);

        //ACTIVAR BOTONES
        sesion.getBtn_cancelar().addActionListener(l -> {
            Cancelar();
        });
        sesion.getBtn_ingresar().addActionListener(l -> {
            Validar_Datos();
        });

        //EVENTOS DE MOUSE
        MouseListener M = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getSource() == sesion.getLb_olvidar()) {

                    V_RecuperarContraseña rec = new V_RecuperarContraseña();
                    C_Recuperar_Contraseña recupera = new C_Recuperar_Contraseña(rec);
                    recupera.Iniciar_Control();
                    rec.setVisible(true);
                    sesion.setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                if (e.getSource() == sesion.getLb_olvidar()) {

                    sesion.getLb_olvidar().setForeground(Color.BLUE);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

                if (e.getSource() == sesion.getLb_olvidar()) {

                    sesion.getLb_olvidar().setForeground(Color.darkGray);
                }
            }
        };
        sesion.getLb_olvidar().addMouseListener(M);
    }

    public void Validar_Datos() {

        if (Validar_Campos() == true) {

            if ((Validar_Usuario() == true) && (Validar_Contraseña() == true)) {

                Campos();
                C_Menu_Inicio iniciar = new C_Menu_Inicio(inicio);
                iniciar.Iniciar_Control();
                inicio.setVisible(true);
                sesion.setVisible(false);

            } else {

                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", "Error Datos", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos", "Compos Vacios", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Campos() {

        sesion.getTxt_usuario().setText("");
        sesion.getPsw_contraseña().setText("");
    }

    public void Cancelar() {

        sesion.getTxt_usuario().setText("");
        sesion.getPsw_contraseña().setText("");
    }

    public boolean Validar_Usuario() {

        List<Buf_Admin_User> List_Adm = AdminDB.Getter();
        List<Buf_Usuarios> List_usr = userDB.Getter();

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();

        if (List_usr.isEmpty()) {
            for (int i = 0; i < List_Adm.size(); i++) {
                if (List_Adm.get(i).getUsuario().equals(sesion.getTxt_usuario().getText())) {
                    return true;
                }
            }
            return false;
        }

        for (int j = 0; j < List_Adm.size(); j++) {
            if (List_Adm.get(j).getUsuario().equals(sesion.getTxt_usuario().getText())) {
                return true;
            }
        }

        if (List_secre.isEmpty()) {
            for (int i = 0; i < List_usr.size(); i++) {
                for (int j = 0; j < List_abg.size(); j++) {
                    if ((List_usr.get(i).getUsuario().equals(sesion.getTxt_usuario().getText()) && List_usr.get(i).getCedula().equals(List_abg.get(j).getCedula()))) {
                        return true;
                    }
                }
                return false;
            }
        }

        if (List_abg.isEmpty()) {
            for (int i = 0; i < List_usr.size(); i++) {
                for (int k = 0; k < List_secre.size(); k++) {
                    if ((List_usr.get(i).getUsuario().equals(sesion.getTxt_usuario().getText()) && List_usr.get(i).getCedula().equals(List_secre.get(k).getCedula()))) {
                        return true;
                    }
                }
                return false;
            }
        }

        for (int i = 0; i < List_usr.size(); i++) {
            for (int j = 0; j < List_abg.size(); j++) {
                for (int k = 0; k < List_secre.size(); k++) {
                    if ((List_usr.get(i).getUsuario().equals(sesion.getTxt_usuario().getText()) && List_usr.get(i).getCedula().equals(List_abg.get(j).getCedula()))) {
                        return true;
                    } else if ((List_usr.get(i).getUsuario().equals(sesion.getTxt_usuario().getText()) && List_usr.get(i).getCedula().equals(List_secre.get(k).getCedula()))) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean Validar_Contraseña() {

        List<Buf_Admin_User> List_Adm = AdminDB.Getter();
        List<Buf_Usuarios> List_usr = userDB.Getter();

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();

        char[] arrayC = sesion.getPsw_contraseña().getPassword();
        String password = new String(arrayC);

        if (List_usr.isEmpty()) {
            for (int i = 0; i < List_Adm.size(); i++) {
                if (List_Adm.get(i).getContrasenia().equals(password)) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < List_Adm.size(); i++) {
            if (List_Adm.get(i).getContrasenia().equals(password)) {
                return true;
            }
        }
        if (List_abg.isEmpty()) {
            for (int i = 0; i < List_usr.size(); i++) {
                for (int k = 0; k < List_secre.size(); k++) {
                    if ((List_usr.get(i).getContrasenia().equals(password) && List_usr.get(i).getCedula().equals(List_secre.get(k).getCedula()))) {
                        inicio.getReg_abogado().setEnabled(false);
                        inicio.getMod_abogado().setEnabled(false);
                        inicio.getReg_secretaria().setEnabled(false);
                        inicio.getMod_secretaria().setEnabled(false);
                        inicio.getReg_usuario().setEnabled(false);
                        return true;
                    }
                }
                return false;
            }
        }
        if (List_secre.isEmpty()) {
            for (int i = 0; i < List_usr.size(); i++) {
                for (int j = 0; j < List_abg.size(); j++) {
                    if ((List_usr.get(i).getContrasenia().equals(password) && List_usr.get(i).getCedula().equals(List_abg.get(j).getCedula()))) {
                        inicio.getReg_abogado().setEnabled(false);
                        inicio.getMod_abogado().setEnabled(false);
                        return true;
                    }
                }
                return false;
            }
        }
        for (int i = 0; i < List_usr.size(); i++) {
            for (int j = 0; j < List_abg.size(); j++) {
                for (int k = 0; k < List_secre.size(); k++) {
                    if ((List_usr.get(i).getContrasenia().equals(password) && List_usr.get(i).getCedula().equals(List_abg.get(j).getCedula()))) {
                        inicio.getReg_abogado().setEnabled(false);
                        inicio.getMod_abogado().setEnabled(false);
                        return true;
                    } else if ((List_usr.get(i).getContrasenia().equals(password) && List_usr.get(i).getCedula().equals(List_secre.get(k).getCedula()))) {
                        inicio.getReg_abogado().setEnabled(false);
                        inicio.getMod_abogado().setEnabled(false);
                        inicio.getReg_secretaria().setEnabled(false);
                        inicio.getMod_secretaria().setEnabled(false);
                        inicio.getReg_usuario().setEnabled(false);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean Validar_Campos() {

        char[] arrayC = sesion.getPsw_contraseña().getPassword();
        String password = new String(arrayC);

        if (!(sesion.getTxt_usuario().getText().isEmpty()) && !(password.isEmpty())) {

            return true;
        } else {

            return false;
        }
    }
}
