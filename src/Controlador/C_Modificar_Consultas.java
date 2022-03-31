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
import static vista.Consultas.Lista_consulta;
import vista.Consuta_Consultas;
import static vista.Consuta_Consultas.table;
import static vista.MenuInicio.escritorio;
import vista.Modificar_Consulta;
import static vista.Modificar_Consulta.cbcaso;
import static vista.Modificar_Consulta.jhora;
import static vista.Modificar_Consulta.lanombres;
import static vista.Modificar_Consulta.txdescripcion;
import static vista.Modificar_Consulta.txtapellidos;
import static vista.Modificar_Consulta.txtnombres;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Consultas implements ActionListener, KeyListener {

    Modificar_Consulta modificar_Consulta;

    public C_Modificar_Consultas(Modificar_Consulta modificar_Consulta) {
        this.modificar_Consulta = modificar_Consulta;
        this.modificar_Consulta.btnguardar.addActionListener(this);
        this.modificar_Consulta.btnmodificar.addActionListener(this);
        this.modificar_Consulta.btnregresar.addActionListener(this);

        this.modificar_Consulta.txtnombres.addKeyListener(this);
        Campos();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == modificar_Consulta.btnguardar) {
            String caso = (String) cbcaso.getSelectedItem();

            String hora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(jhora.getValue());

            if (txtnombres.getText().isEmpty()) {

                Campo_Vacio();
                JOptionPane.showMessageDialog(null, "LOS CAMPOS DEBEN ESTAR LLENOS");

            } else {

                int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                switch (resp) {
                    case 0:

                        int datos = table.getSelectedRow();

                        Lista_consulta.get(datos).setNombres(txtnombres.getText());
                        Lista_consulta.get(datos).setHora(hora);
                        Lista_consulta.get(datos).setConsulta(txdescripcion.getText());
                        modificar_Consulta.btnmodificar.setEnabled(true);
                        Campo_Vacio();
                        Campos();

                        break;

                    case 1:
                        JOptionPane.showMessageDialog(null, "MODIFICACION CANCELADA");
                        break;
                }
            }
        }
        if (evt.getSource() == modificar_Consulta.btnmodificar) {
            txtnombres.setEditable(true);
            txdescripcion.setEditable(true);
            jhora.setEnabled(true);
            modificar_Consulta.btnmodificar.setEnabled(false);
        }
        if (evt.getSource() == modificar_Consulta.btnregresar) {
            modificar_Consulta.dispose();
            Consuta_Consultas C = new Consuta_Consultas();
            escritorio.add(C);
            C.show();
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == modificar_Consulta.txtnombres) {
            int key = evt.getKeyChar();

            if (txtnombres.getText().length() <= 30) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                if (!letra) {

                    evt.consume();
                }

            } else {

                evt.consume();
            }
        }
        if (evt.getSource() == modificar_Consulta.txtapellidos) {
            char c = evt.getKeyChar();

            if ((c < 'a' && c < 'z') && (c < 'A' && c < 'Z')) {
                evt.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {

    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getSource() == modificar_Consulta.txtnombres) {
            Campo_Vacio();
        }
    }

    public void Campo_Vacio() {

        if (txtnombres.getText().isEmpty()) {
            lanombres.setVisible(true);
            modificar_Consulta.btnguardar.setEnabled(false);
        }

        if (!txtnombres.getText().isEmpty()) {
            lanombres.setVisible(false);
            modificar_Consulta.btnguardar.setEnabled(true);
        }
    }

    public void Campos() {

        txtnombres.setEditable(false);
        cbcaso.setEnabled(false);
        txtapellidos.setEditable(false);
        jhora.setEnabled(false);
        txdescripcion.setEditable(false);
    }
}
