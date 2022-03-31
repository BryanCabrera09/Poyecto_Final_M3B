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
import modelo.Consulta;
import static vista.Citas.Lista_Cita;
import vista.Consultas;
import static vista.Consultas.Lista_consulta;

/*
 * @author BRYAN_CABRERA
 */
public class C_Consultas implements ActionListener, KeyListener {

    Consultas consultas;

    public C_Consultas(Consultas consultas) {
        this.consultas = consultas;
        this.consultas.btncancelar.addActionListener(this);
        this.consultas.btnguardar.addActionListener(this);
        this.consultas.btnnuevo.addActionListener(this);
        this.consultas.cbcaso.addActionListener(this);

        this.consultas.txtapellidos.addKeyListener(this);
        this.consultas.txtnombres.addKeyListener(this);
        this.consultas.cbcaso.addKeyListener(this);
        this.consultas.jSpinner1.addKeyListener(this);
        this.consultas.txdescripcion.addKeyListener(this);

        Nuevo();
        Campos();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == consultas.btnguardar) {
            String caso = (String) consultas.cbcaso.getSelectedItem();

            String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(consultas.jSpinner1.getValue());

            Consulta C = new Consulta(caso, hora, consultas.txtnombres.getText(), consultas.txtapellidos.getText(), consultas.txdescripcion.getText());

            int a = 0, p = 0, r = 0;

            if (caso.equals("Seleccione") || consultas.txtnombres.getText().isEmpty() || consultas.txtapellidos.getText().isEmpty()) {

                Campo_Vacio();
                JOptionPane.showMessageDialog(null, "LOS CAMPOS DEBEN ESTAR LLENOS");
            } else {

                if (Lista_Cita.isEmpty() && Lista_consulta.isEmpty()) {

                    Lista_consulta.add(C);
                    Nuevo();
                    Campos();
                    consultas.btnnuevo.setEnabled(true);
                    consultas.btncancelar.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "CITA AGENDADA " + caso.toUpperCase());
                } else if (!Lista_Cita.isEmpty() && Lista_consulta.isEmpty()) {
                    for (int j = 0; j < Lista_Cita.size(); j++) {
                        if (!Lista_Cita.get(j).getHora().equals(hora)) {
                            Lista_consulta.add(C);
                            Nuevo();
                            Campos();
                            consultas.btnnuevo.setEnabled(true);
                            JOptionPane.showMessageDialog(null, "CITA AGENDADA " + caso.toUpperCase());
                            j = Lista_Cita.size();
                            consultas.btncancelar.setEnabled(false);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "CITA YA AGENDADA CON LA FECHA SELECCIONADA", "CITA", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }

                    }
                } else if (Lista_Cita.isEmpty() && !Lista_consulta.isEmpty()) {
                    for (int j = 0; j < Lista_consulta.size(); j++) {
                        if (!Lista_consulta.get(j).getApellidos().equals(consultas.txtapellidos.getText()) && !Lista_consulta.get(j).getHora().equals(hora)) {
                            Lista_consulta.add(C);
                            Nuevo();
                            Campos();
                            consultas.btnnuevo.setEnabled(true);
                            JOptionPane.showMessageDialog(null, "CITA AGENDADA " + caso.toUpperCase());
                            j = Lista_consulta.size();
                            consultas.btncancelar.setEnabled(false);
                            break;
                        } else {

                            JOptionPane.showMessageDialog(null, "CITA YA AGENDADA", "CITA", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                } else if (!Lista_Cita.isEmpty() && !Lista_consulta.isEmpty()) {
                    for (int i = 0; i < Lista_Cita.size(); i++) {
                        for (int j = 0; j < Lista_consulta.size(); j++) {
                            if (!Lista_Cita.get(i).getHora().equals(hora) && !Lista_consulta.get(j).getHora().equals(hora) && !Lista_consulta.get(j).getApellidos().equals(consultas.txtapellidos.getText())) {
                                Lista_consulta.add(C);
                                Nuevo();
                                Campos();
                                consultas.btnnuevo.setEnabled(true);
                                JOptionPane.showMessageDialog(null, "CITA AGENDADA " + caso.toUpperCase());
                                j = Lista_consulta.size();
                                i = Lista_Cita.size();
                                consultas.btncancelar.setEnabled(false);
                                break;
                            } else {

                                JOptionPane.showMessageDialog(null, "CITA YA AGENDADA", "CITA", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (evt.getSource() == consultas.btncancelar) {
            String caso = (String) consultas.cbcaso.getSelectedItem();
            if (!consultas.txtnombres.getText().equals("") || !consultas.txtapellidos.getText().equals("") || !caso.equals("Seleccione")) {
                int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
                switch (salir) {
                    case 0:
                        Nuevo();
                        Campos();
                        consultas.btncancelar.setEnabled(false);
                        consultas.btnnuevo.setEnabled(true);
                        break;
                    case 1:
                        Campo_Vacio();
                        break;
                }
            }
        }
        if (evt.getSource() == consultas.btnnuevo) {
            consultas.jSpinner1.setEnabled(true);
            consultas.cbcaso.setEnabled(true);
            consultas.txtnombres.setEditable(true);
            consultas.txtapellidos.setEditable(true);
            consultas.txdescripcion.setEditable(true);
            consultas.btnnuevo.setEnabled(false);
        }
        if (evt.getSource() == consultas.cbcaso) {
            Campo_Vacio();
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == consultas.btnguardar) {
            int key = evt.getKeyChar();

            if (consultas.txtnombres.getText().length() <= 30) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                if (!letra) {

                    evt.consume();
                }

            } else {

                evt.consume();
            }
        }
        if (evt.getSource() == consultas.txtapellidos) {

            int key = evt.getKeyChar();

            if (consultas.txtapellidos.getText().length() <= 30) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                if (!letra) {

                    evt.consume();
                }

            } else {

                evt.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getSource() == consultas.btnguardar) {

        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getSource() == consultas.txtnombres) {
            Campo_Vacio();
        }
        if (evt.getSource() == consultas.txtapellidos) {
            Campo_Vacio();
        }

    }

    public void Nuevo() {
        consultas.btncancelar.setEnabled(false);
        consultas.btnguardar.setEnabled(false);
        consultas.jSpinner1.setEnabled(false);
        consultas.cbcaso.setEnabled(false);
        consultas.cbcaso.setSelectedIndex(0);
        consultas.txtapellidos.setEditable(false);
        consultas.txtnombres.setEditable(false);
        consultas.txtapellidos.setText("");
        consultas.txtnombres.setText("");
        consultas.txdescripcion.setText("");
    }

    public void Campo_Vacio() {
        String caso = (String) consultas.cbcaso.getSelectedItem();
        if (caso.equals("Seleccione")) {
            consultas.lacaso1.setVisible(true);
            consultas.btncancelar.setEnabled(false);
        }

        if (consultas.txtapellidos.getText().isEmpty()) {
            consultas.apellidos.setVisible(true);
            consultas.btncancelar.setEnabled(false);
        }

        if (consultas.txtnombres.getText().isEmpty()) {
            consultas.nombres.setVisible(true);
            consultas.btncancelar.setEnabled(false);
        }
        //CUANDO EL CAMPO ESTA LLENO
        if (!caso.equals("Seleccione")) {
            consultas.lacaso1.setVisible(false);
            consultas.btncancelar.setEnabled(true);
        }

        if (!consultas.txtapellidos.getText().isEmpty()) {
            consultas.apellidos.setVisible(false);
            consultas.btncancelar.setEnabled(true);
        }

        if (!consultas.txtnombres.getText().isEmpty()) {
            consultas.nombres.setVisible(false);
            consultas.btncancelar.setEnabled(true);
        }

        if (!consultas.txtnombres.getText().isEmpty() && !caso.equals("Seleccione") && !consultas.txtapellidos.getText().isEmpty()) {
            consultas.btnguardar.setEnabled(true);
        } else {
            consultas.btnguardar.setEnabled(false);
        }
    }

    public void Campos() {

        consultas.btnguardar.setEnabled(false);
        consultas.nombres.setVisible(false);
        consultas.apellidos.setVisible(false);
        consultas.lacaso1.setVisible(false);
    }
}
