/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Perdon;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosPerdon;
import static vista.RequisitosPerdon.listaperdon;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Perdon implements ActionListener {

    String r1, r2, r3, r4, r5, r6, obser;
    RequisitosPerdon perdon;
    public static String ced;
    public static String ca;

    public C_Requisitos_Perdon(RequisitosPerdon perdon) {
        this.perdon = perdon;
        this.perdon.btnGuardar.addActionListener(this);
        this.perdon.btnModificar.addActionListener(this);
        this.perdon.btn_pago.addActionListener(this);
        this.perdon.rq1.addActionListener(this);
        this.perdon.rq2.addActionListener(this);
        this.perdon.rq3.addActionListener(this);
        this.perdon.rq4.addActionListener(this);
        this.perdon.rq5.addActionListener(this);
        this.perdon.rq6.addActionListener(this);

        numBeneficiario();
        cargarcheck();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == perdon.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            perdon.setVisible(false);
        }
        if (evt.getSource() == perdon.btnModificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == perdon.btnGuardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == perdon.rq1) {

        }
        if (evt.getSource() == perdon.rq2) {

        }
        if (evt.getSource() == perdon.rq3) {

        }
        if (evt.getSource() == perdon.rq4) {

        }
        if (evt.getSource() == perdon.rq5) {

        }
        if (evt.getSource() == perdon.rq6) {

        }
    }

    public void numBeneficiario() {
        perdon.comboNum.addItem("Seleccionar...");
        perdon.comboNum.addItem("1");
        perdon.comboNum.addItem("2");
        perdon.comboNum.addItem("3");
        perdon.comboNum.addItem("4");
    }

    public void agregar() {

        if (perdon.rq1.isSelected() == true) {
            r1 = perdon.rq1.getText();
        }
        if (perdon.rq2.isSelected() == true) {
            r2 = perdon.rq2.getText();
        }
        if (perdon.rq3.isSelected() == true) {
            r3 = perdon.rq3.getText();
        }
        if (perdon.rq4.isSelected() == true) {
            r4 = perdon.rq4.getText();
        }
        if (perdon.rq5.isSelected() == true) {
            r5 = perdon.rq5.getText();
        }
        if (perdon.rq6.isSelected() == true) {
            r6 = perdon.rq6.getText();
        }
        String cantidad = (String) perdon.comboNum.getSelectedItem();
        obser = perdon.observaciones.getText();
        Perdon m = new Perdon(ced, r1, r2, r3, r4, r5, r6, cantidad, "", obser);
        listaperdon.add(m);

    }

    public void cargarcheck() {
        for (int i = 0; i < listaperdon.size(); i++) {
            if (listaperdon.get(i).getCedula().equals(ced)) {
                if (listaperdon.get(i).getRq1() == null) {
                } else {
                    if (listaperdon.get(i).getRq1().equals("COPIA DE CEDULA")) {
                        perdon.rq1.setSelected(true);
                    }
                }
                if (listaperdon.get(i).getRq2() == null) {
                } else {
                    if (listaperdon.get(i).getRq2().equals("INSCIPCION DE MATRIMONIO")) {
                        perdon.rq2.setSelected(true);
                    }
                }
                if (listaperdon.get(i).getRq3() == null) {
                } else {
                    if (listaperdon.get(i).getRq3().equals("PASAPORTE")) {
                        perdon.rq3.setSelected(true);
                    }
                }
                if (listaperdon.get(i).getRq4() == null) {
                } else {
                    if (listaperdon.get(i).getRq4().equals("HUELLAS DIGITALES")) {
                        perdon.rq4.setSelected(true);
                    }
                }
                if (listaperdon.get(i).getRq5() == null) {
                } else {
                    if (listaperdon.get(i).getRq5().equals("INSCRIPCION DE NACIMIENTO")) {
                        perdon.rq5.setSelected(true);
                    }
                }
                if (listaperdon.get(i).getRq6() == null) {
                } else {
                    if (listaperdon.get(i).getRq6().equals("RECORD POLICIAL")) {
                        perdon.rq6.setSelected(true);
                    }
                }
                perdon.comboNum.removeAllItems();
                perdon.comboNum.addItem(listaperdon.get(i).getNumpersona());

                obser = listaperdon.get(i).getObservaciones();
                perdon.observaciones.setText(obser);
            }
        }
    }

    public void modificarreq() {
        String cantidad = (String) perdon.comboNum.getSelectedItem();
        perdon.observaciones.setEditable(true);
        if (perdon.rq1.isSelected() == true) {
            r1 = perdon.rq1.getText();
        }
        if (perdon.rq2.isSelected() == true) {
            r2 = perdon.rq2.getText();
        }
        if (perdon.rq3.isSelected() == true) {
            r3 = perdon.rq3.getText();
        }
        if (perdon.rq4.isSelected() == true) {
            r4 = perdon.rq4.getText();
        }
        if (perdon.rq5.isSelected() == true) {
            r5 = perdon.rq5.getText();
        }
        if (perdon.rq6.isSelected() == true) {
            r6 = perdon.rq6.getText();
        }
        for (int i = 0; i < listaperdon.size(); i++) {
            if (listaperdon.get(i).getCedula().equals(ced)) {
                listaperdon.get(i).setRq1(r1);
                listaperdon.get(i).setRq2(r2);
                listaperdon.get(i).setRq3(r3);
                listaperdon.get(i).setRq4(r4);
                listaperdon.get(i).setRq5(r5);
                listaperdon.get(i).setRq6(r6);
                listaperdon.get(i).setObservaciones(perdon.observaciones.getText());
            }
        }

    }

}
