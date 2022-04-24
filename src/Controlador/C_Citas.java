/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso;
import Modelo.Buf_CasoDB;
import Modelo.Buf_Cita;
import Modelo.Buf_CitaDB;
import Modelo.Buf_Consulta;
import Modelo.Buf_ConsultaDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import vista.V_Citas;

/*
 * @author BRYAN_CABRERA
 */
public class C_Citas {

    V_Citas citas;

    Buf_CasoDB Ca_DB = new Buf_CasoDB();
    Buf_CitaDB C_DB = new Buf_CitaDB();
    Buf_ConsultaDB Co_DB = new Buf_ConsultaDB();
    Buf_Cita C = new Buf_Cita();

    public C_Citas(V_Citas citas) {

        this.citas = citas;

        Nuevo();
        Campos();
    }

    public void Iniciar_Control() {

        //EVENTOS KEY
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == citas.getTxt_cedula()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && citas.getTxt_cedula().getText().length() <= 9) {
                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == citas.getTxt_celular()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && citas.getTxt_celular().getText().length() <= 9) {
                    } else {
                        evt.consume();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (citas.getBtn_guardar().isEnabled()) {
                        citas.getBtn_guardar().doClick();
                    }
                    if (!citas.getBtn_guardar().isEnabled() && citas.getBtn_buscar().isEnabled()) {
                        citas.getBtn_buscar().doClick();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getSource() == citas.getTxt_cedula()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == citas.getTxt_celular()) {
                    Campo_Vacio();
                }

            }
        };
        citas.getTxt_cedula().addKeyListener(K);
        citas.getTxt_celular().addKeyListener(K);

        //ACTION BUTTONS
        citas.getBtn_buscar().addActionListener(l -> {
            Buscar();
        });
        citas.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
        citas.getCb_caso().addActionListener(tl -> {
            Campo_Vacio();
        });
        citas.getBtn_cancelar().addActionListener(tl -> {
            Cancelar();
        });
        citas.getBtn_nuevo().addActionListener(tl -> {
            Registrar();
        });
    }

    public void Registrar() {

        citas.getBtn_guardar().setEnabled(true);
        citas.getBtn_cancelar().setEnabled(true);
        citas.getJs_hora().setEnabled(true);
        citas.getTxt_celular().setEditable(true);
        citas.getCb_caso().setEnabled(true);
        citas.getTxa_descripcion().setEditable(true);
    }

    public void Buscar() {

        List<Buf_Caso> List_caso = Ca_DB.Getter();
        List<Buf_Cita> List_cita = C_DB.Getter();

        citas.getCb_caso().removeAllItems();

        if (Buscar_Caso() == true) {
            if (Buscar_Cita() == true) {
                citas.getCb_caso().addItem("Seleccionar");

                for (int i = 0; i < List_caso.size(); i++) {
                    if (!List_cita.isEmpty()) {
                        for (int j = 0; j < List_cita.size(); j++) {
                            if (List_cita.get(j).getNom_caso().equals(List_caso.get(i).getCaso())) {
                                citas.getTxt_cedula().setEditable(false);
                                citas.getBtn_buscar().setEnabled(false);
                                citas.getBtn_nuevo().setEnabled(false);
                            } else {
                                citas.getCb_caso().addItem(List_caso.get(i).getCaso());
                            }
                        }
                    } else {
                        citas.getCb_caso().addItem(List_caso.get(i).getCaso());
                    }
                }
                Buscar_Datos();
            } else {

                JOptionPane.showMessageDialog(null, "Ya registra una cita pendiente", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "No Registra Casos", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean Buscar_Cita() {

        List<Buf_Cita> List_cita = C_DB.Getter();
        List<Buf_Caso> List_caso = Ca_DB.Getter();

        String caso = (String) citas.getCb_caso().getSelectedItem();

        if (List_cita.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(citas.getTxt_cedula().getText()) && List_caso.get(i).getId_caso() == Integer.parseInt(citas.getTxt_id().getText())) {
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < List_cita.size(); i++) {
            if (List_cita.get(i).getCedula().equals(citas.getTxt_cedula().getText()) && !List_cita.get(i).getNom_caso().equalsIgnoreCase(caso) && !citas.getTxt_id().getText().isEmpty()) {
                return true;
            } else {

                for (int j = 0; j < List_caso.size(); j++) {
                    if (List_caso.get(i).getCedula().equals(citas.getTxt_cedula().getText())) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public boolean Buscar_Caso() {

        List<Buf_Caso> List_caso = Ca_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(citas.getTxt_cedula().getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean Validar_Registro() {

        String caso = (String) citas.getCb_caso().getSelectedItem();

        List<Buf_Cita> List_cita = C_DB.Getter();
        for (int j = 0; j < List_cita.size(); j++) {
            if (List_cita.get(j).getCedula().equals(citas.getTxt_cedula().getText()) && List_cita.get(j).getNom_caso().equalsIgnoreCase(caso)) {
                return false;
            }
        }
        return true;
    }

    public void Cancelar() {

        if (Validar_Cancelar() == true) {
            int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
            switch (salir) {
                case 0:
                    Nuevo();
                    Campos();
                    break;
                case 1:
                    Campo_Vacio();
                    break;
            }
        }
    }

    public boolean Validar_Cancelar() {

        String caso = (String) citas.getCb_caso().getSelectedItem();

        if (!citas.getTxt_cedula().getText().equals("") || !citas.getTxt_celular().getText().equals("") || !caso.equals("Seleccionar")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Validar_Hora() {

        List<Buf_Consulta> List_consult = Co_DB.Getter();
        List<Buf_Cita> List_cita = C_DB.Getter();

        String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(citas.getJs_hora().getValue());

        if (List_consult.isEmpty()) {
            for (int i = 0; i < List_cita.size(); i++) {
                if (List_cita.get(i).getHora().equalsIgnoreCase(hora)) {
                    return false;
                }
            }
            return true;
        }

        if (List_cita.isEmpty()) {
            for (int i = 0; i < List_consult.size(); i++) {
                if (List_consult.get(i).getHora().equalsIgnoreCase(hora)) {
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

    public boolean Validar_Fecha_Actual() {

        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaSistema = formateador.format(fechaActual);

        Date fecha = (Date) citas.getJs_hora().getValue();
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechas = Formato.format(fecha);

        if (fecha.before(fechaActual)) {
            return false;
        }
        return true;
    }

    public int Id_Generator() {

        List<Buf_Consulta> List_consult = Co_DB.Getter();
        List<Buf_Cita> List_cita = C_DB.Getter();

        int id_cita = (int) Math.floor(Math.random() * (999999 - 111111 + 1) + 111111);

        int a = 0;
        do {

            if (List_consult.isEmpty()) {
                for (int i = 0; i < List_cita.size(); i++) {
                    if (List_cita.get(i).getId_cita() == id_cita) {
                        a = 1;
                    }
                }
            }

            for (int i = 0; i < List_consult.size(); i++) {
                for (int j = 0; j < List_cita.size(); j++) {
                    if (List_consult.get(i).getId_consulta() == id_cita || List_cita.get(j).getId_cita() == id_cita) {
                        a = 1;
                    }
                }
            }
        } while (a == 1);

        return id_cita;
    }

    public void Guardar() {

        if (Validar_Datos() == true) {
            if (Validar_Registro() == true) {
                if (citas.getTxt_cedula().getText().length() == 10 && citas.getTxt_celular().getText().length() == 10) {
                    if (Validar_Hora() == true) {
                        if (Validar_Fecha_Actual() == true) {
                            Subir_Datos();
                        } else {
                            JOptionPane.showMessageDialog(null, "No Se Puede Registar Una Fecha Pasada", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya Registra Una Cita Para La Fecha Seleccionada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Datos Ingrsados Erroneos", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Consulta Registrada Previamente", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {

            Campo_Vacio();
            JOptionPane.showMessageDialog(null, "LOS CAMPOS DEBEN ESTAR LLENOS");
        }
    }

    public boolean Validar_Datos() {

        String caso = (String) citas.getCb_caso().getSelectedItem();

        if (!caso.equals("Seleccionar") && !citas.getTxt_cedula().getText().isEmpty() && !citas.getTxt_celular().getText().isEmpty()) {

            return true;
        } else {

            return false;
        }
    }

    public void Subir_Datos() {

        String caso = (String) citas.getCb_caso().getSelectedItem();
        String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(citas.getJs_hora().getValue());

        C.setId_cita(Id_Generator());
        C.setCedula(citas.getTxt_cedula().getText());
        C.setId_caso(Integer.parseInt(citas.getTxt_id().getText()));
        C.setNom_caso(caso);
        C.setNum_celular(citas.getTxt_celular().getText());
        C.setDescripcion(citas.getTxa_descripcion().getText());
        C.setHora(hora);

        if (C_DB.Register(C)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            Campos();
            Nuevo();
            JOptionPane.showMessageDialog(null, "<html><b>CITA AGENDADA</b><br><br>Caso " + caso.toUpperCase() + ", Para El " + hora + "</html>");
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Nuevo() {

        citas.getBtn_guardar().setEnabled(false);
        citas.getBtn_cancelar().setEnabled(false);
        citas.getJs_hora().setEnabled(false);
        citas.getTxt_celular().setEditable(false);
        citas.getCb_caso().setEnabled(false);
        citas.getTxa_descripcion().setEditable(false);
        citas.getTxt_celular().setText("");
        citas.getCb_caso().setSelectedIndex(0);
        citas.getTxt_cedula().setText("");
        citas.getTxt_id().setText("");
        citas.getTxa_descripcion().setText("");
    }

    public void Campo_Vacio() {

        if (citas.getCb_caso().getSelectedIndex() == 0 && !citas.getTxt_cedula().isEditable() == true) {
            citas.getLb_caso().setVisible(true);
            citas.getBtn_cancelar().setEnabled(false);
        }

        if (citas.getTxt_celular().getText().isEmpty() && !citas.getTxt_cedula().isEditable() == true) {
            citas.getLb_celular().setVisible(true);
            citas.getBtn_cancelar().setEnabled(false);
        }

        if (citas.getTxt_cedula().getText().isEmpty()) {
            citas.getLb_cedula().setVisible(true);
            citas.getBtn_cancelar().setEnabled(false);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!citas.getTxt_celular().getText().isEmpty()) {
            citas.getLb_celular().setVisible(false);
            citas.getBtn_cancelar().setEnabled(true);
        }

        if (!citas.getTxt_cedula().getText().isEmpty()) {
            citas.getLb_cedula().setVisible(false);
            citas.getBtn_cancelar().setEnabled(true);
        }

        if (citas.getLb_cedula().isShowing() == true) {
            citas.getCedula().setVisible(false);
        } else if (citas.getTxt_cedula().getText().length() < 10) {
            citas.getCedula().setVisible(true);
            citas.getBtn_buscar().setEnabled(false);
        } else if (citas.getTxt_cedula().getText().length() == 10) {
            citas.getCedula().setVisible(false);
            Cargar_Id();
            citas.getBtn_buscar().setEnabled(true);
        }

        if (citas.getLb_celular().isShowing() == true) {
            citas.getCelular().setVisible(false);
        } else if (citas.getTxt_celular().getText().length() < 10 && !citas.getTxt_cedula().isEditable() == true) {
            citas.getCelular().setVisible(true);
        } else if (citas.getTxt_celular().getText().length() == 10) {
            citas.getCelular().setVisible(false);
        }

        if (!citas.getTxt_celular().getText().isEmpty() && !citas.getCaso().equals("Seleccionar") && !citas.getTxt_cedula().getText().isEmpty()) {
            citas.getBtn_guardar().setEnabled(true);
        } else {
            citas.getBtn_guardar().setEnabled(false);
        }
    }

    public void Cargar_Id() {

        List<Buf_Caso> List_caso = Ca_DB.Getter();
        List<Buf_Cita> List_cita = C_DB.Getter();

        if (List_cita.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(citas.getTxt_cedula().getText())) {
                    citas.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                    i = List_caso.size();
                } else {
                    citas.getTxt_id().setText("");
                }
            }
        } else {

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(citas.getTxt_cedula().getText())) {
                    citas.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                    for (int j = 0; j < List_cita.size(); j++) {
                        if (!citas.getTxt_id().getText().isEmpty()) {
                            if (List_cita.get(j).getId_caso() == Integer.parseInt(citas.getTxt_id().getText())) {
                                citas.getTxt_id().setText("");
                            } else if (List_caso.get(i).equals(List_caso.get(i).getId_caso())) {
                                citas.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                            }
                        }
                    }
                }
            }
        }
    }

    public void Campos() {

        citas.getLb_celular().setVisible(false);
        citas.getTxt_id().setEditable(false);
        citas.getLb_caso().setVisible(false);
        citas.getCedula().setVisible(false);
        citas.getCelular().setVisible(false);
        citas.getLb_caso().setVisible(false);
        citas.getLb_cedula().setVisible(false);
        citas.getLb_celular().setVisible(false);
        citas.getTxt_celular().setVisible(false);
        citas.getCeiu().setVisible(false);
        citas.getCb_caso().setVisible(false);
        citas.getTxa_descripcion().setVisible(false);
        citas.getJs_hora().setVisible(false);
        citas.getHora().setVisible(false);
        citas.getDescripcion().setVisible(false);
        citas.getBtn_guardar().setVisible(false);
        citas.getBtn_cancelar().setVisible(false);
        citas.getCaso().setVisible(false);
        citas.getBtn_buscar().setEnabled(false);
        citas.getBtn_buscar().setEnabled(true);
        citas.getBtn_nuevo().setEnabled(false);
        citas.getTxt_cedula().setVisible(true);
    }

    public void Buscar_Datos() {

        citas.getBtn_buscar().setEnabled(false);
        citas.getBtn_nuevo().setEnabled(true);
        citas.getBtn_cancelar().setEnabled(false);
        citas.getTxt_cedula().setEditable(true);
        citas.getTxt_celular().setVisible(true);
        citas.getCeiu().setVisible(true);
        citas.getCb_caso().setVisible(true);
        citas.getTxa_descripcion().setVisible(true);
        citas.getJs_hora().setVisible(true);
        citas.getHora().setVisible(true);
        citas.getDescripcion().setVisible(true);
        citas.getBtn_guardar().setVisible(true);
        citas.getBtn_cancelar().setVisible(true);
        citas.getCaso().setVisible(true);
    }
}
