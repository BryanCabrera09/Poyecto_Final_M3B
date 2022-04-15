/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Cita;
import Modelo.Buf_CitaDB;
import Modelo.Buf_Consulta;
import Modelo.Buf_ConsultaDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vista.V_Consulta_Consultas;
import vista.V_Menu_Inicio;
import vista.V_Modificar_Consulta;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Consultas {

    V_Modificar_Consulta modificar;
    V_Menu_Inicio Inicio;

    Buf_CitaDB Ci_DB = new Buf_CitaDB();
    Buf_ConsultaDB C_DB = new Buf_ConsultaDB();
    Buf_Consulta C = new Buf_Consulta();

    public C_Modificar_Consultas(V_Modificar_Consulta modificar) {

        this.modificar = modificar;

        Campos();
    }

    public void Iniciar_Control() {

        //EVENTO KEY
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == modificar.getTxt_nombres()) {
                    int key = evt.getKeyChar();

                    if (modificar.getTxt_nombres().getText().length() <= 30) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;
                        if (!letra) {
                            evt.consume();
                        }
                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == modificar.getTxt_apellidos()) {

                    int key = evt.getKeyChar();

                    if (modificar.getTxt_apellidos().getText().length() <= 20) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                        if (!letra) {

                            evt.consume();
                        }

                    } else {

                        evt.consume();
                    }
                }
                if (evt.getSource() == modificar.getTxt_celular()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && modificar.getTxt_celular().getText().length() <= 9) {
                    } else {
                        evt.consume();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (modificar.getBtn_guardar().isEnabled()) {
                        modificar.getBtn_guardar().doClick();
                    }
                    if (!modificar.getBtn_guardar().isEnabled() && modificar.getBtn_modificar().isEnabled()) {
                        modificar.getBtn_modificar().doClick();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getSource() == modificar.getTxt_nombres()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == modificar.getTxt_apellidos()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == modificar.getTxt_celular()) {
                    Campo_Vacio();
                }
            }
        };
        modificar.getTxt_nombres().addKeyListener(K);
        modificar.getTxt_celular().addKeyListener(K);
        modificar.getTxt_apellidos().addKeyListener(K);
        modificar.getBtn_guardar().addKeyListener(K);
        modificar.getBtn_modificar().addKeyListener(K);

        //ACTION BUTTON
        modificar.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
        modificar.getBtn_modificar().addActionListener(l -> {
            Modificar();
        });
        modificar.getBtn_regresar().addActionListener(l -> {
            Regresar();
        });
        modificar.getBtn_cancelar().addActionListener(l -> {
            Cancelar_Consulta();
        });
    }

    public void Cancelar_Consulta() {

        List<Buf_Consulta> List_consult = C_DB.Getter();

        for (int i = 0; i < List_consult.size(); i++) {
            if (List_consult.get(i).getId_consulta() == Integer.parseInt(modificar.getTxt_id().getText())) {
                int elimina = JOptionPane.showConfirmDialog(null, "¿Cancelar Consulta?", "AVISO", JOptionPane.YES_NO_OPTION);
                switch (elimina) {
                    case 0:
                        C.setId_consulta(Integer.parseInt(modificar.getTxt_id().getText()));

                        if (C_DB.Delete(C)) {

                            JOptionPane.showMessageDialog(null, "Consulta Cancelada");

                            Regresar();
                        } else {

                            JOptionPane.showMessageDialog(null, "Proceso de Eliminacion Cancelado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 1:
                        JOptionPane.showMessageDialog(null, "ELIMINACION CANCELADA");
                        break;
                }
            }
        }
    }

    public void Guardar() {

        if (Validar_Datos() == true) {
            if (Validar_Hora() == true) {
                int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                switch (resp) {
                    case 0:
                        Cargar_Datos();
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "MODIFICACION CANCELADA");
                        break;
                }
            } else {

                JOptionPane.showMessageDialog(null, "Fecha Ya Registrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Campo_Vacio();
            JOptionPane.showMessageDialog(null, "LOS CAMPOS DEBEN ESTAR LLENOS");
        }
    }

    public boolean Validar_Datos() {

        if (!modificar.getTxt_nombres().getText().isEmpty() && !modificar.getTxt_apellidos().getText().isEmpty() && !modificar.getTxt_celular().getText().isEmpty()) {

            return true;
        } else {

            return false;
        }
    }

    public String upperCaseFirst(String val) {

        StringBuffer strbf = new StringBuffer();
        Matcher match = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(val);
        while (match.find()) {
            match.appendReplacement(strbf, match.group(1).toUpperCase() + match.group(2).toLowerCase());
        }
        return match.appendTail(strbf).toString();
    }

    public void Cargar_Datos() {

        String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(modificar.getJs_hora().getValue());

        C.setNombre(upperCaseFirst(modificar.getTxt_nombres().getText()));
        C.setApellido(upperCaseFirst(modificar.getTxt_apellidos().getText()));
        C.setNum_celular(modificar.getTxt_celular().getText());
        C.setDescripcion(modificar.getTxa_descripcion().getText());
        C.setHora(hora);
        C.setId_consulta(Integer.parseInt(modificar.getTxt_id().getText()));

        if (C_DB.Update(C)) {

            Campos();
            Campo_Vacio();
            modificar.getBtn_modificar().setEnabled(false);
            JOptionPane.showMessageDialog(null, "Modificacion Realizada");
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean Validar_Hora() {

        List<Buf_Consulta> List_consult = C_DB.Getter();
        List<Buf_Cita> List_cita = Ci_DB.Getter();

        String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(modificar.getJs_hora().getValue());

        if (List_cita.isEmpty()) {
            for (int i = 0; i < List_consult.size(); i++) {
                if (List_consult.get(i).getHora().equalsIgnoreCase(hora) && List_consult.get(i).getId_consulta() != Integer.parseInt(modificar.getTxt_id().getText())) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < List_cita.size(); i++) {
            for (int j = 0; j < List_consult.size(); j++) {
                if ((List_cita.get(i).getHora().equalsIgnoreCase(hora) || List_consult.get(j).getHora().equalsIgnoreCase(hora)) && List_consult.get(i).getId_consulta() != Integer.parseInt(modificar.getTxt_id().getText())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void Regresar() {

        V_Consulta_Consultas CI = new V_Consulta_Consultas();
        C_Consultas_Consultas C = new C_Consultas_Consultas(CI);
        Inicio.escritorio.add(CI);
        CI.show();
        C.Iniciar_Control();
        modificar.dispose();
    }

    public void Modificar() {

        modificar.getTxt_nombres().setEditable(true);
        modificar.getTxt_apellidos().setEditable(true);
        modificar.getTxa_descripcion().setEditable(true);
        modificar.getTxt_celular().setEditable(true);
        modificar.getJs_hora().setEnabled(true);
        modificar.getBtn_modificar().setEnabled(false);
        modificar.getBtn_cancelar().setEnabled(false);
    }

    public void Campo_Vacio() {

        if (modificar.getTxt_apellidos().getText().isEmpty()) {
            modificar.getLb_apellido().setVisible(true);
            modificar.getBtn_guardar().setEnabled(false);
        }

        if (modificar.getTxt_nombres().getText().isEmpty()) {
            modificar.getLb_nombre().setVisible(true);
            modificar.getBtn_guardar().setEnabled(false);
        }

        if (modificar.getTxt_celular().getText().isEmpty()) {
            modificar.getLb_celular().setVisible(true);
            modificar.getBtn_guardar().setEnabled(false);
        }
        //CUANDO EL CAMPO ESTA LLENO

        if (!modificar.getTxt_apellidos().getText().isEmpty()) {
            modificar.getLb_apellido().setVisible(false);
            modificar.getBtn_guardar().setEnabled(true);
        }

        if (!modificar.getTxt_nombres().getText().isEmpty()) {
            modificar.getLb_nombre().setVisible(false);
            modificar.getBtn_guardar().setEnabled(true);
        }

        if (modificar.getLb_celular().isShowing() == true) {
            modificar.getCelular().setVisible(false);
        } else if (modificar.getTxt_celular().getText().length() < 10) {
            modificar.getCelular().setVisible(true);
        } else if (modificar.getTxt_celular().getText().length() == 10) {
            modificar.getCelular().setVisible(false);
        }

        if (!modificar.getTxt_nombres().getText().isEmpty() && !modificar.getTxt_apellidos().getText().isEmpty() && !modificar.getTxt_celular().getText().isEmpty()) {
            modificar.getBtn_guardar().setEnabled(true);
        } else {
            modificar.getBtn_guardar().setEnabled(false);
        }
    }

    public void Campos() {

        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_cancelar().setEnabled(true);
        modificar.getLb_nombre().setVisible(false);
        modificar.getLb_apellido().setVisible(false);
        modificar.getCelular().setVisible(false);
        modificar.getLb_celular().setVisible(false);
        modificar.getCb_caso().setEnabled(false);
        modificar.getTxt_celular().setEditable(false);
        modificar.getTxt_id().setEditable(false);
        modificar.getTxt_nombres().setEditable(false);
        modificar.getTxt_apellidos().setEditable(false);
        modificar.getTxa_descripcion().setEditable(false);
        modificar.getJs_hora().setEnabled(false);
    }
}
