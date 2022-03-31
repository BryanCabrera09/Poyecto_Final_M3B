/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.RenovacionPasaporte;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosRenovacionPasaporte;
import static vista.RequisitosRenovacionPasaporte.listarenovacion;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_RenovacionPasaporte implements ActionListener {

    public static String ced, ca;
    String r1, r2, r3, r4, r5, r6, obser;

    RequisitosRenovacionPasaporte rrp;

    public C_Requisitos_RenovacionPasaporte(RequisitosRenovacionPasaporte rrp) {
        this.rrp = rrp;
        this.rrp.btnGuardar.addActionListener(this);
        this.rrp.btn_pago.addActionListener(this);
        this.rrp.btnModificar.addActionListener(this);
        this.rrp.rq1.addActionListener(this);
        this.rrp.rq2.addActionListener(this);
        this.rrp.rq3.addActionListener(this);
        this.rrp.rq4.addActionListener(this);
        this.rrp.rq5.addActionListener(this);
        this.rrp.rq6.addActionListener(this);

        numBeneficiario();
        cargarcheck();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == rrp.btnGuardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == rrp.btnModificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == rrp.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago pago = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            rrp.setVisible(false);
        }
        if (evt.getSource() == rrp.rq1) {

        }
        if (evt.getSource() == rrp.rq2) {

        }
        if (evt.getSource() == rrp.rq3) {

        }
        if (evt.getSource() == rrp.rq4) {

        }
        if (evt.getSource() == rrp.rq5) {

        }
        if (evt.getSource() == rrp.rq6) {

        }
    }

    public void numBeneficiario() {
        rrp.comboNum.addItem("Seleccionar...");
        rrp.comboNum.addItem("1");
        rrp.comboNum.addItem("2");
        rrp.comboNum.addItem("3");
        rrp.comboNum.addItem("4");
    }

    public void agregar() {

        if (rrp.rq1.isSelected() == true) {
            r1 = rrp.rq1.getText();
        }
        if (rrp.rq2.isSelected() == true) {
            r2 = rrp.rq2.getText();
        }
        if (rrp.rq3.isSelected() == true) {
            r3 = rrp.rq3.getText();
        }
        if (rrp.rq4.isSelected() == true) {
            r4 = rrp.rq4.getText();
        }
        if (rrp.rq5.isSelected() == true) {
            r5 = rrp.rq5.getText();
        }
        if (rrp.rq6.isSelected() == true) {
            r6 = rrp.rq6.getText();
        }
        String cantidad = (String) rrp.comboNum.getSelectedItem();
        obser = rrp.observaciones.getText();
        RenovacionPasaporte m = new RenovacionPasaporte(ced, r1, r2, r3, r4, r5, r6, cantidad, "", obser);
        listarenovacion.add(m);

    }

    public void cargarcheck() {
        for (int i = 0; i < listarenovacion.size(); i++) {
            if (listarenovacion.get(i).getCedula().equals(ced)) {
                if (listarenovacion.get(i).getRq1() == null) {
                } else {
                    if (listarenovacion.get(i).getRq1().equals("PASAPORTE AMERICANO CADUCADO")) {
                        rrp.rq1.setSelected(true);
                    }
                }
                if (listarenovacion.get(i).getRq2() == null) {
                } else {
                    if (listarenovacion.get(i).getRq2().equals("ACTA DE NATURALIZACION")) {
                        rrp.rq2.setSelected(true);
                    }
                }
                if (listarenovacion.get(i).getRq3() == null) {
                } else {
                    if (listarenovacion.get(i).getRq3().equals("SOCIAL SECURITY")) {
                        rrp.rq3.setSelected(true);
                    }
                }
                if (listarenovacion.get(i).getRq4() == null) {
                } else {
                    if (listarenovacion.get(i).getRq4().equals("FOTOS DE PROGRESION")) {
                        rrp.rq4.setSelected(true);
                    }
                }
                if (listarenovacion.get(i).getRq5() == null) {
                } else {
                    if (listarenovacion.get(i).getRq5().equals("2 FOTOS 5 x 5 ")) {
                        rrp.rq5.setSelected(true);
                    }
                }
                if (listarenovacion.get(i).getRq6() == null) {
                } else {
                    if (listarenovacion.get(i).getRq6().equals("DIRECCION EN LOS EEUU")) {
                        rrp.rq6.setSelected(true);
                    }
                }
                rrp.comboNum.removeAllItems();
                rrp.comboNum.addItem(listarenovacion.get(i).getNumpersona());

                obser = listarenovacion.get(i).getObservaciones();
                rrp.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        String cantidad = (String) rrp.comboNum.getSelectedItem();
        rrp.observaciones.setEditable(true);
        if (rrp.rq1.isSelected() == true) {
            r1 = rrp.rq1.getText();
        }
        if (rrp.rq2.isSelected() == true) {
            r2 = rrp.rq2.getText();
        }
        if (rrp.rq3.isSelected() == true) {
            r3 = rrp.rq3.getText();
        }
        if (rrp.rq4.isSelected() == true) {
            r4 = rrp.rq4.getText();
        }
        if (rrp.rq5.isSelected() == true) {
            r5 = rrp.rq5.getText();
        }
        if (rrp.rq6.isSelected() == true) {
            r6 = rrp.rq6.getText();
        }
        for (int i = 0; i < listarenovacion.size(); i++) {
            if (listarenovacion.get(i).getCedula().equals(ced)) {
                listarenovacion.get(i).setRq1(r1);
                listarenovacion.get(i).setRq2(r2);
                listarenovacion.get(i).setRq3(r3);
                listarenovacion.get(i).setRq4(r4);
                listarenovacion.get(i).setRq5(r5);
                listarenovacion.get(i).setRq6(r6);
                listarenovacion.get(i).setObservaciones(rrp.observaciones.getText());
            }
        }

    }

}
