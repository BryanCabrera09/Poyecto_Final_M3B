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
import javax.swing.JOptionPane;
import vista.V_Consulta_Citas;
import vista.V_Menu_Inicio;
import vista.V_Modificacion_Citas;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificacion_Citas {

    V_Modificacion_Citas modificacion;
    V_Menu_Inicio Inicio;

    Buf_CitaDB C_DB = new Buf_CitaDB();
    Buf_ConsultaDB Co_DB = new Buf_ConsultaDB();
    Buf_Cita C = new Buf_Cita();

    public C_Modificacion_Citas(V_Modificacion_Citas modificacion) {

        this.modificacion = modificacion;

        Campos();
    }

    public void Iniciar_Control() {

        //EVENTOS KEY
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == modificacion.getTxt_cedula()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && modificacion.getTxt_cedula().getText().length() <= 9) {
                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == modificacion.getTxt_celular()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && modificacion.getTxt_celular().getText().length() <= 9) {
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
                if (evt.getSource() == modificacion.getTxt_celular()) {
                    Campo_Vacio();
                }
            }
        };
        modificacion.getTxt_celular().addKeyListener(K);
        modificacion.getTxt_cedula().addKeyListener(K);

        //ACTION BUTTON
        modificacion.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
        modificacion.getBtn_modificar().addActionListener(l -> {
            Modificar();
        });
        modificacion.getBtn_regresar().addActionListener(l -> {
            Regresar();
        });
        modificacion.getBtn_cancelar().addActionListener(l -> {
            Cancelar_Cita();
        });
    }

    public void Campo_Vacio() {

        if (modificacion.getTxt_celular().getText().isEmpty()) {
            modificacion.getLb_celular().setVisible(true);
            modificacion.getBtn_guardar().setEnabled(false);
        }

        if (!modificacion.getTxt_celular().getText().isEmpty()) {
            modificacion.getLb_celular().setVisible(false);
            modificacion.getBtn_guardar().setEnabled(true);
        }

        if (modificacion.getLb_celular().isShowing() == true) {
            modificacion.getCelular().setVisible(false);
        } else if (modificacion.getTxt_celular().getText().length() < 10) {
            modificacion.getCelular().setVisible(true);
        } else if (modificacion.getTxt_celular().getText().length() == 10) {
            modificacion.getCelular().setVisible(false);
        }
    }

    public void Campos() {

        modificacion.getCelular().setVisible(false);
        modificacion.getTxt_cedula().setEditable(false);
        modificacion.getTxt_id().setEditable(false);
        modificacion.getCb_caso().setEnabled(false);
        modificacion.getTxt_celular().setEditable(false);
        modificacion.getTxa_descripcion().setEditable(false);
        modificacion.getJs_hora().setEnabled(false);
        modificacion.getBtn_guardar().setEnabled(false);

    }

    public void Guardar() {

        if (!modificacion.getTxt_celular().getText().isEmpty()) {
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

    public void Cargar_Datos() {

        String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(modificacion.getJs_hora().getValue());

        C.setNum_celular(modificacion.getTxt_celular().getText());
        C.setDescripcion(modificacion.getTxa_descripcion().getText());
        C.setHora(hora);
        C.setId_cita(Integer.parseInt(modificacion.getTxt_id().getText()));

        if (C_DB.Update(C)) {

            Campos();
            Campo_Vacio();
            modificacion.getBtn_modificar().setEnabled(false);
            JOptionPane.showMessageDialog(null, "Modificacion Realizada");
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void Cancelar_Cita() {

        List<Buf_Cita> List_cita = C_DB.Getter();

        for (int i = 0; i < List_cita.size(); i++) {
            if (List_cita.get(i).getCedula().equals(modificacion.getTxt_cedula().getText())) {
                int elimina = JOptionPane.showConfirmDialog(null, "¿Cancelar Cita?", "AVISO", JOptionPane.YES_NO_OPTION);
                switch (elimina) {
                    case 0:
                        C.setId_cita(Integer.parseInt(modificacion.getTxt_id().getText()));

                        if (C_DB.Delete(C)) {

                            JOptionPane.showMessageDialog(null, "Cita Cancelada");

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

    public boolean Validar_Hora() {

        List<Buf_Consulta> List_consult = Co_DB.Getter();
        List<Buf_Cita> List_cita = C_DB.Getter();

        String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(modificacion.getJs_hora().getValue());

        if (List_consult.isEmpty()) {
            for (int i = 0; i < List_cita.size(); i++) {
                if (List_cita.get(i).getHora().equalsIgnoreCase(hora)) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < List_consult.size(); i++) {
            for (int j = 0; j < List_cita.size(); j++) {
                if (List_consult.get(i).getHora().equalsIgnoreCase(hora) || List_cita.get(j).getHora().equalsIgnoreCase(hora)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void Regresar() {

        V_Consulta_Citas CI = new V_Consulta_Citas();
        C_Consulta_Citas C = new C_Consulta_Citas(CI);
        Inicio.escritorio.add(CI);
        CI.show();
        C.Iniciar_Control();
        modificacion.dispose();
    }

    public void Modificar() {

        modificacion.getTxt_celular().setEditable(true);
        modificacion.getJs_hora().setEnabled(true);
        modificacion.getBtn_modificar().setEnabled(false);
        modificacion.getBtn_guardar().setEnabled(true);
        modificacion.getTxa_descripcion().setEditable(true);
    }
}
