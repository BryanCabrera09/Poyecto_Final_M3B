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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.Cita;
import vista.Citas;
import static vista.Citas.Lista_Cita;
import static vista.Citas.jhora;
import static vista.Consultas.Lista_consulta;
import static vista.RegistroCaso.Lista_ClienteCaso;
import static vista.RegistroCliente.Lista_cliente;

/*
 * @author BRYAN_CABRERA
 */
public class C_Citas implements ActionListener, KeyListener {

    Citas citas;

    public C_Citas(Citas citas) {
        this.citas = citas;
        this.citas.btnbuscar.addActionListener(this);
        this.citas.btnguardar.addActionListener(this);
        this.citas.cbcaso.addActionListener(this);

        this.citas.cbcaso.addKeyListener(this);
        this.citas.jhora.addKeyListener(this);
        this.citas.txtcedula.addKeyListener(this);
        this.citas.txtcelular.addKeyListener(this);
        this.citas.txdescripcion.addKeyListener(this);
        Campos();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == citas.btnbuscar) {
            citas.cbcaso.removeAllItems();
            if (Lista_ClienteCaso.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO DE CASO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            } else if (Lista_Cita.isEmpty() && !Lista_ClienteCaso.isEmpty()) {
                if (citas.txtcedula.getText().length() == 10) {
                    citas.cbcaso.addItem("Seleccione");
                    for (int i = 0; i < Lista_ClienteCaso.size(); i++) {
                        if (Lista_ClienteCaso.get(i).getCedula().equals(citas.txtcedula.getText())) {
                            citas.cbcaso.addItem(Lista_ClienteCaso.get(i).getCaso());
                            i = Lista_ClienteCaso.size();
                            Buscar();
                        }
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (!Lista_Cita.isEmpty() && !Lista_ClienteCaso.isEmpty()) {
                citas.cbcaso.addItem("Seleccione");
                for (int i = 0; i < Lista_ClienteCaso.size(); i++) {
                    if (Lista_ClienteCaso.get(i).getCedula().equals(citas.txtcedula.getText())) {
                        for (int j = 0; j < Lista_Cita.size(); j++) {
                            if (citas.txtcedula.getText().length() == 10) {
                                if (!Lista_Cita.get(j).getCedula().equals(citas.txtcedula.getText())) {
                                    citas.cbcaso.addItem(Lista_ClienteCaso.get(i).getCaso());
                                    Buscar();
                                    i = Lista_ClienteCaso.size();
                                    j = Lista_Cita.size();
                                    break;
                                } else if (Lista_Cita.get(j).getCedula().equals(citas.txtcedula.getText())) {
                                    JOptionPane.showMessageDialog(null, "CITA YA AGENDADA", "ERROR!!", 0);
                                    i = Lista_ClienteCaso.size();
                                    j = Lista_Cita.size();
                                    break;
                                } else if (!Lista_ClienteCaso.get(i).getCedula().equals(citas.txtcedula.getText())) {
                                    JOptionPane.showMessageDialog(null, "CEDULA DIGITADA NO REGISTRADA", "ERROR!!", 0);
                                    i = Lista_ClienteCaso.size();
                                    j = Lista_Cita.size();
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "NO CUENTA CON UN REGISTRO DE CASO", "ERROR!!", 3);
                                    i = Lista_ClienteCaso.size();
                                    j = Lista_Cita.size();
                                    break;
                                }
                            } else {

                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    }
                }
            } else if (Lista_Cita.isEmpty() && Lista_ClienteCaso.isEmpty()) {

                JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO DE CEDULA", "ERROR!!", 0);
            }
        }
        if (evt.getSource() == citas.btnguardar) {
            String caso = (String) citas.cbcaso.getSelectedItem();

            String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(jhora.getValue());

            Cita CI = new Cita(caso, hora, citas.txtcedula.getText(), citas.txtcelular.getText(), citas.txdescripcion.getText());

            if (citas.txtcelular.getText().isEmpty() || caso.equals("Seleccione") || citas.txtcedula.getText().isEmpty()) {

                Campo_Vacio();
                JOptionPane.showMessageDialog(null, "LOS CAMPOS DEBEN ESTAR LLENOS");

            } else {

                if (Lista_Cita.isEmpty() && Lista_cliente.isEmpty() && Lista_consulta.isEmpty()) {

                    JOptionPane.showMessageDialog(null, "NO EXISTE UN REGISTRO DE LA CEDULA INGRESADA", "SIN DATOS", JOptionPane.INFORMATION_MESSAGE);

                } else if (Lista_Cita.isEmpty() && !Lista_cliente.isEmpty() && Lista_consulta.isEmpty()) {
                    if (citas.txtcedula.getText().length() == 10 && citas.txtcelular.getText().length() == 10) {
                        for (int i = 0; i < Lista_cliente.size(); i++) {
                            if (Lista_cliente.get(i).getCedula().equals(citas.txtcedula.getText())) {
                                Lista_Cita.add(CI);
                                Campos();
                                Nuevo();
                                i = Lista_cliente.size();
                                System.out.println(caso);
                                JOptionPane.showMessageDialog(null, "CITA AGENDADA " + caso.toUpperCase());
                                break;
                            }
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS DIGITADOS INCOMPLETOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }

                } else if (!Lista_Cita.isEmpty() && !Lista_cliente.isEmpty() && Lista_consulta.isEmpty()) {
                    if (citas.txtcedula.getText().length() == 10 && citas.txtcelular.getText().length() == 10) {
                        for (int i = 0; i < Lista_cliente.size(); i++) {
                            for (int j = 0; j < Lista_Cita.size(); j++) {
                                if (Lista_cliente.get(i).getCedula().equals(citas.txtcedula.getText()) && !Lista_Cita.get(j).getCedula().equals(citas.txtcedula.getText()) && !Lista_Cita.get(j).getHora().equals(hora)) {
                                    Lista_Cita.add(CI);
                                    Campos();
                                    Nuevo();
                                    JOptionPane.showMessageDialog(null, "CITA AGENDADA " + caso.toUpperCase());
                                    i = Lista_cliente.size();
                                    j = Lista_Cita.size();
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "CITA YA AGENDADA", "CITA", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            }
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS DIGITADOS INCOMPLETOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (Lista_Cita.isEmpty() && !Lista_cliente.isEmpty() && !Lista_consulta.isEmpty()) {
                    if (citas.txtcedula.getText().length() == 10 && citas.txtcelular.getText().length() == 10) {
                        for (int i = 0; i < Lista_cliente.size(); i++) {
                            for (int j = 0; j < Lista_consulta.size(); j++) {
                                if (Lista_cliente.get(i).getCedula().equals(citas.txtcedula.getText()) && !Lista_consulta.get(j).getHora().equals(hora)) {
                                    Lista_Cita.add(CI);
                                    Campos();
                                    Nuevo();
                                    JOptionPane.showMessageDialog(null, "CITA AGENDADA " + caso.toUpperCase());
                                    i = Lista_cliente.size();
                                    j = Lista_consulta.size();
                                    break;
                                } else {

                                    JOptionPane.showMessageDialog(null, "CITA YA AGENDADA CON LA FECHA SELECCIONADA", "CITA", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            }
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS DIGITADOS INCOMPLETOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (!Lista_Cita.isEmpty() && !Lista_cliente.isEmpty() && !Lista_consulta.isEmpty()) {
                    if (citas.txtcedula.getText().length() == 10 && citas.txtcelular.getText().length() == 10) {
                        for (int i = 0; i < Lista_Cita.size(); i++) {
                            for (int j = 0; j < Lista_consulta.size(); j++) {
                                for (int k = 0; k < Lista_cliente.size(); k++) {
                                    if (Lista_cliente.get(i).getCedula().equals(citas.txtcedula.getText()) && !Lista_consulta.get(j).getHora().equals(hora) && !Lista_Cita.get(j).getCedula().equals(citas.txtcedula.getText()) && !Lista_Cita.get(j).getHora().equals(hora)) {
                                        Lista_Cita.add(CI);
                                        Campos();
                                        Nuevo();
                                        JOptionPane.showMessageDialog(null, "CITA AGENDADA " + caso.toUpperCase());
                                        k = Lista_cliente.size();
                                        j = Lista_consulta.size();
                                        i = Lista_Cita.size();
                                        break;
                                    } else {

                                        JOptionPane.showMessageDialog(null, "CITA YA AGENDADA", "CITA", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "DATOS DIGITADOS INCOMPLETOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (evt.getSource() == citas.cbcaso) {
            Campo_Vacio();
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == citas.txtcedula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && citas.txtcedula.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == citas.txtcelular) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && citas.txtcelular.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getSource() == citas.btnbuscar) {

        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getSource() == citas.txtcedula) {
            if (citas.txtcedula.getText().isEmpty()) {
                citas.lacedula.setVisible(true);
            }

            if (!citas.txtcedula.getText().isEmpty()) {
                citas.lacedula.setVisible(false);
            }

            if (citas.lacedula.isShowing() == true) {
                citas.cedula.setVisible(false);
            } else if (citas.txtcedula.getText().length() < 10) {
                citas.cedula.setVisible(true);
            } else if (citas.txtcedula.getText().length() == 10) {
                citas.cedula.setVisible(false);
            }

        }
        if (evt.getSource() == citas.txtcelular) {
            Campo_Vacio();
        }

    }

    public void Nuevo() {
        citas.btnguardar.setEnabled(false);
        citas.jhora.setEnabled(false);
        citas.txtcelular.setEditable(false);
        citas.cbcaso.setEnabled(false);
        citas.txtcelular.setText("");
        citas.cbcaso.setSelectedIndex(0);
        citas.txtcedula.setText("");
        citas.txdescripcion.setText("");
        citas.txdescripcion.setEditable(false);
    }

    public void Campo_Vacio() {

        if (citas.cbcaso.getSelectedIndex() == 0 && !citas.txtcedula.isEditable() == true) {
            citas.lacaso.setVisible(true);
        }

        if (citas.txtcelular.getText().isEmpty() && !citas.txtcedula.isEditable() == true) {
            citas.lacelular.setVisible(true);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!(citas.cbcaso.getSelectedIndex() == 0)) {
            citas.lacaso.setVisible(false);
        }

        if (!citas.txtcelular.getText().isEmpty()) {
            citas.lacelular.setVisible(false);
        }

        if (citas.lacelular.isShowing() == true) {
            citas.celular.setVisible(false);
        } else if (citas.txtcelular.getText().length() < 10 && !citas.txtcedula.isEditable() == true) {
            citas.celular.setVisible(true);
        } else if (citas.txtcelular.getText().length() == 10) {
            citas.celular.setVisible(false);
        }

        if (!citas.txtcelular.getText().isEmpty() && !citas.caso.equals("Seleccione") && !citas.txtcedula.getText().isEmpty()) {
            citas.btnguardar.setEnabled(true);
        } else {
            citas.btnguardar.setEnabled(false);
        }

    }

    public void Campos() {

        citas.lacelular.setVisible(false);
        citas.lacaso.setVisible(false);
        citas.cedula.setVisible(false);
        citas.celular.setVisible(false);
        citas.lacaso.setVisible(false);
        citas.lacedula.setVisible(false);
        citas.lacelular.setVisible(false);
        citas.txtcelular.setVisible(false);
        citas.dds.setVisible(false);
        citas.cbcaso.setVisible(false);
        citas.txdescripcion.setVisible(false);
        citas.jhora.setVisible(false);
        citas.hora.setVisible(false);
        citas.descripcion.setVisible(false);
        citas.btnguardar.setVisible(false);
        citas.caso.setVisible(false);
        citas.btnbuscar.setEnabled(true);
        citas.txtcedula.setEditable(true);
    }

    public void Buscar() {

        citas.btnbuscar.setEnabled(false);
        citas.txtcedula.setEditable(false);
        citas.txtcelular.setVisible(true);
        citas.dds.setVisible(true);
        citas.cbcaso.setVisible(true);
        citas.txdescripcion.setVisible(true);
        citas.jhora.setVisible(true);
        citas.hora.setVisible(true);
        citas.descripcion.setVisible(true);
        citas.btnguardar.setVisible(true);
        citas.caso.setVisible(true);
    }

}
