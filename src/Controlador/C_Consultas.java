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
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vista.V_Consultas;

/*
 * @author BRYAN_CABRERA
 */
public class C_Consultas {

    V_Consultas consultas;

    Buf_Consulta C = new Buf_Consulta();
    Buf_ConsultaDB C_DB = new Buf_ConsultaDB();
    Buf_CitaDB Ci_DB = new Buf_CitaDB();

    public C_Consultas(V_Consultas consultas) {

        this.consultas = consultas;

        Nuevo();
        Campos();
    }

    public void Iniciar_Control() {

        //EVENTO KEY
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == consultas.getTxt_nombres()) {
                    int key = evt.getKeyChar();

                    if (consultas.getTxt_nombres().getText().length() <= 30) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;
                        if (!letra) {
                            evt.consume();
                        }
                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == consultas.getTxt_apellidos()) {

                    int key = evt.getKeyChar();

                    if (consultas.getTxt_apellidos().getText().length() <= 30) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;
                        if (!letra) {
                            evt.consume();
                        }
                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == consultas.getTxt_celular()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && consultas.getTxt_celular().getText().length() <= 9) {
                    } else {
                        evt.consume();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (consultas.getBtn_guardar().isEnabled()) {
                        consultas.getBtn_guardar().doClick();
                    }
                    if (!consultas.getBtn_guardar().isEnabled() && consultas.getBtn_nuevo().isEnabled()) {
                        consultas.getBtn_nuevo().doClick();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getSource() == consultas.getTxt_nombres()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == consultas.getTxt_apellidos()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == consultas.getTxt_celular()) {
                    Campo_Vacio();
                }
            }
        };
        consultas.getTxt_apellidos().addKeyListener(K);
        consultas.getTxt_nombres().addKeyListener(K);
        consultas.getTxt_celular().addKeyListener(K);

        //ACTION BUTTONS
        consultas.getBtn_cancelar().addActionListener(l -> {
            Cancelar();
        });
        consultas.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
        consultas.getBtn_nuevo().addActionListener(l -> {
            Nuevo_Registro();
        });
        consultas.getCb_caso().addActionListener(l -> {
            Campo_Vacio();
        });
    }

    public boolean Validar_Datos() {

        String caso = (String) consultas.getCb_caso().getSelectedItem();

        if (!caso.equals("Seleccionar") && !consultas.getTxt_nombres().getText().isEmpty() && !consultas.getTxt_apellidos().getText().isEmpty() && !consultas.getTxt_celular().getText().isEmpty()) {

            return true;
        } else {

            return false;
        }
    }

    public void Guardar() {

        if (Validar_Datos() == true) {
            if (Validar_Registro() == true) {
                if (Validar_Hora() == true) {
                    if (Validar_Fecha_Actual() == true) {
                    Subir_Datos();
                    } else {
                        JOptionPane.showMessageDialog(null, "No Se Puede Registar Una Fecha Pasada", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CONSULTA YA AGENDADA CON LA FECHA SELECCIONADA", "CITA", JOptionPane.INFORMATION_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Consulta Registrada Previamente", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {

            Campo_Vacio();
            JOptionPane.showMessageDialog(null, "LOS CAMPOS DEBEN ESTAR LLENOS");
        }
    }

    public String upperCaseFirst(String val) {

        System.out.println(val);
        StringBuffer strbf = new StringBuffer();
        Matcher match = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(val);
        while (match.find()) {
            match.appendReplacement(strbf, match.group(1).toUpperCase() + match.group(2).toLowerCase());
        }
        return match.appendTail(strbf).toString();
    }

    public int Id_Generator() {

        List<Buf_Consulta> List_consult = C_DB.Getter();
        List<Buf_Cita> List_cita = Ci_DB.Getter();

        int id_consulta = (int) Math.floor(Math.random() * (999999 - 111111 + 1) + 111111);

        int a = 0;
        do {

            if (List_cita.isEmpty()) {
                for (int i = 0; i < List_consult.size(); i++) {
                    if (List_consult.get(i).getId_consulta() == id_consulta) {
                        a = 1;
                    }
                }
            }

            for (int i = 0; i < List_cita.size(); i++) {
                for (int j = 0; j < List_consult.size(); j++) {
                    if (List_cita.get(i).getId_cita() == id_consulta || List_consult.get(j).getId_consulta() == id_consulta) {
                        a = 1;
                    }
                }
            }
        } while (a == 1);

        return id_consulta;
    }

    public boolean Validar_Hora() {

        List<Buf_Consulta> List_consult = C_DB.Getter();
        List<Buf_Cita> List_cita = Ci_DB.Getter();

        String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(consultas.getJs_hora().getValue());

        if (List_cita.isEmpty()) {
            for (int i = 0; i < List_consult.size(); i++) {
                if (List_consult.get(i).getHora().equalsIgnoreCase(hora)) {
                    return false;
                }
            }
        }

        if (List_consult.isEmpty()) {
            for (int i = 0; i < List_cita.size(); i++) {
                if (List_cita.get(i).getHora().equalsIgnoreCase(hora)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < List_cita.size(); i++) {
            for (int j = 0; j < List_consult.size(); j++) {
                if (List_cita.get(i).getHora().equalsIgnoreCase(hora) || List_consult.get(j).getHora().equalsIgnoreCase(hora)) {
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

        Date fecha = (Date) consultas.getJs_hora().getValue();
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechas = Formato.format(fecha);

        if (fecha.before(fechaActual)) {
            return false;
        }
        return true;
    }

    public boolean Validar_Registro() {

        String caso = (String) consultas.getCb_caso().getSelectedItem();

        List<Buf_Consulta> List_consult = C_DB.Getter();
        for (int j = 0; j < List_consult.size(); j++) {
            if (List_consult.get(j).getNombre().equalsIgnoreCase(consultas.getTxt_nombres().getText()) && List_consult.get(j).getNombre().equalsIgnoreCase(consultas.getTxt_nombres().getText()) && List_consult.get(j).getCaso().equalsIgnoreCase(caso)) {
                return false;
            }
        }
        return true;
    }

    public void Subir_Datos() {

        String caso = (String) consultas.getCb_caso().getSelectedItem();
        String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(consultas.getJs_hora().getValue());

        C.setId_consulta(Id_Generator());
        C.setNombre(upperCaseFirst(consultas.getTxt_nombres().getText()));
        C.setApellido(upperCaseFirst(consultas.getTxt_apellidos().getText()));
        C.setNum_celular(consultas.getTxt_celular().getText());
        C.setDescripcion(consultas.getTxa_descripcion().getText());
        C.setCaso(caso);
        C.setHora(hora);

        if (C_DB.Register(C)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            Nuevo();
            Campos();
            JOptionPane.showMessageDialog(null, "<html><b>CONSULTA AGENDADA</b><br><br>Caso " + caso.toUpperCase() + ", Para El " + hora + "</html>");
            consultas.getBtn_nuevo().setEnabled(true);
            consultas.getBtn_cancelar().setEnabled(false);
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Cancelar() {

        if (Validar_Cancelar() == true) {
            int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
            switch (salir) {
                case 0:
                    Nuevo();
                    Campos();
                    consultas.getBtn_cancelar().setEnabled(false);
                    consultas.getBtn_nuevo().setEnabled(true);
                    break;
                case 1:
                    Campo_Vacio();
                    break;
            }
        }
    }

    public boolean Validar_Cancelar() {

        String caso = (String) consultas.getCb_caso().getSelectedItem();

        if (!consultas.getTxt_nombres().getText().equals("") || !consultas.getTxt_celular().getText().equals("") || !consultas.getTxt_apellidos().getText().equals("") || !caso.equals("Seleccionar")) {
            return true;
        } else {
            return false;
        }
    }

    public void Nuevo_Registro() {

        consultas.getJs_hora().setEnabled(true);
        consultas.getCb_caso().setEnabled(true);
        consultas.getTxt_nombres().setEditable(true);
        consultas.getTxt_celular().setEditable(true);
        consultas.getTxt_apellidos().setEditable(true);
        consultas.getTxa_descripcion().setEditable(true);
        consultas.getBtn_nuevo().setEnabled(false);
    }

    public void Nuevo() {

        consultas.getBtn_cancelar().setEnabled(false);
        consultas.getBtn_guardar().setEnabled(false);
        consultas.getJs_hora().setEnabled(false);
        consultas.getCb_caso().setEnabled(false);
        consultas.getCb_caso().setSelectedIndex(0);
        consultas.getTxt_apellidos().setEditable(false);
        consultas.getTxt_celular().setEditable(false);
        consultas.getTxt_nombres().setEditable(false);
        consultas.getTxt_apellidos().setText("");
        consultas.getTxt_celular().setText("");
        consultas.getTxt_nombres().setText("");
        consultas.getTxa_descripcion().setText("");
    }

    public void Campo_Vacio() {
        String caso = (String) consultas.getCb_caso().getSelectedItem();
        if (caso.equals("Seleccionar")) {
            consultas.getLb_caso().setVisible(true);
            consultas.getBtn_cancelar().setEnabled(false);
        }

        if (consultas.getTxt_apellidos().getText().isEmpty()) {
            consultas.getLb_apellido().setVisible(true);
            consultas.getBtn_cancelar().setEnabled(false);
        }

        if (consultas.getTxt_nombres().getText().isEmpty()) {
            consultas.getLb_nombre().setVisible(true);
            consultas.getBtn_cancelar().setEnabled(false);
        }

        if (consultas.getTxt_celular().getText().isEmpty()) {
            consultas.getLb_celular().setVisible(true);
            consultas.getBtn_cancelar().setEnabled(false);
        }
        //CUANDO EL CAMPO ESTA LLENO
        if (!caso.equals("Seleccionar")) {
            consultas.getLb_caso().setVisible(false);
            consultas.getBtn_cancelar().setEnabled(true);
        }

        if (!consultas.getTxt_celular().getText().isEmpty()) {
            consultas.getLb_celular().setVisible(false);
            consultas.getBtn_cancelar().setEnabled(true);
        }

        if (!consultas.getTxt_apellidos().getText().isEmpty()) {
            consultas.getLb_apellido().setVisible(false);
            consultas.getBtn_cancelar().setEnabled(true);
        }

        if (!consultas.getTxt_nombres().getText().isEmpty()) {
            consultas.getLb_nombre().setVisible(false);
            consultas.getBtn_cancelar().setEnabled(true);
        }

        if (consultas.getLb_celular().isShowing() == true) {
            consultas.getCelular().setVisible(false);
        } else if (consultas.getTxt_celular().getText().length() < 10) {
            consultas.getCelular().setVisible(true);
        } else if (consultas.getTxt_celular().getText().length() == 10) {
            consultas.getCelular().setVisible(false);
        }

        if (!consultas.getTxt_nombres().getText().isEmpty() && !caso.equals("Seleccione") && !consultas.getTxt_apellidos().getText().isEmpty() && !consultas.getTxt_celular().getText().isEmpty()) {
            consultas.getBtn_guardar().setEnabled(true);
        } else {
            consultas.getBtn_guardar().setEnabled(false);
        }
    }

    public void Campos() {

        consultas.getBtn_guardar().setEnabled(false);
        consultas.getLb_nombre().setVisible(false);
        consultas.getLb_apellido().setVisible(false);
        consultas.getLb_caso().setVisible(false);
        consultas.getCelular().setVisible(false);
        consultas.getLb_celular().setVisible(false);
    }
}
