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
import static vista.Citas.Lista_Cita;
import vista.Consuta_Citas;
import static vista.Consuta_Citas.table;
import static vista.MenuInicio.escritorio;
import vista.Modificacion_Citas;
import static vista.Modificacion_Citas.cbcaso;
import static vista.Modificacion_Citas.jhora;
import static vista.Modificacion_Citas.lacelular;
import static vista.Modificacion_Citas.txdescripcion;
import static vista.Modificacion_Citas.txtcedula;
import static vista.Modificacion_Citas.txtcelular;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificacion_Citas implements ActionListener, KeyListener {

    Modificacion_Citas modificacion_Citas;

    public C_Modificacion_Citas(Modificacion_Citas modificacion_Citas) {
        this.modificacion_Citas = modificacion_Citas;
        this.modificacion_Citas.btnguardar.addActionListener(this);
        this.modificacion_Citas.btnmodificar.addActionListener(this);
        this.modificacion_Citas.btnregresar.addActionListener(this);
        this.modificacion_Citas.btnguardar.addActionListener(this);

        this.modificacion_Citas.txtcelular.addKeyListener(this);
        this.modificacion_Citas.txtcedula.addKeyListener(this);

        Campos();
    }

    public void Campo_Vacio() {

        if (txtcelular.getText().isEmpty()) {
            lacelular.setVisible(true);
            modificacion_Citas.btnguardar.setEnabled(false);
        }

        if (!txtcelular.getText().isEmpty()) {
            lacelular.setVisible(false);
            modificacion_Citas.btnguardar.setEnabled(true);
        }

        if (lacelular.isShowing() == true) {
            modificacion_Citas.celular.setVisible(false);
        } else if (txtcelular.getText().length() < 10) {
            modificacion_Citas.celular.setVisible(true);
        } else if (txtcelular.getText().length() == 10) {
            modificacion_Citas.celular.setVisible(false);
        }
    }

    public void Campos() {

        modificacion_Citas.celular.setVisible(false);
        txtcedula.setEditable(false);
        cbcaso.setEnabled(false);
        txtcelular.setEditable(false);
        txdescripcion.setEditable(false);
        jhora.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == modificacion_Citas.btnguardar) {
            String caso = (String) cbcaso.getSelectedItem();

            String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(jhora.getValue());

            System.out.println(hora);

            if (txtcelular.getText().isEmpty()) {

                Campo_Vacio();
                JOptionPane.showMessageDialog(null, "LOS CAMPOS DEBEN ESTAR LLENOS");

            } else {
                if (txtcelular.getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:

                            int datos = table.getSelectedRow();

                            Lista_Cita.get(datos).setCelular(txtcelular.getText());
                            Lista_Cita.get(datos).setHora(hora);
                            Lista_Cita.get(datos).setCita(txdescripcion.getText());
                            Campos();
                            Campo_Vacio();
                            modificacion_Citas.btnmodificar.setEnabled(false);

                            break;

                        case 1:
                            JOptionPane.showMessageDialog(null, "MODIFICACION CANCELADA");
                            break;
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "DATOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (evt.getSource() == modificacion_Citas.btnmodificar) {
            txtcelular.setEditable(true);
            jhora.setEnabled(true);
            modificacion_Citas.btnmodificar.setEnabled(false);
            txdescripcion.setEditable(true);
        }
        if (evt.getSource() == modificacion_Citas.btnregresar) {
            Consuta_Citas CI = new Consuta_Citas();
            escritorio.add(CI);
            CI.show();
            modificacion_Citas.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == modificacion_Citas.txtcedula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && txtcedula.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == modificacion_Citas.celular) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && txtcelular.getText().length() <= 9) {

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
        if (evt.getSource() == modificacion_Citas.txtcelular) {
            Campo_Vacio();
        }
    }
}
