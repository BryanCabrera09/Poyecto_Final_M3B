/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.PensionesAlimenticias;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosPensionesAlimenticias;
import static vista.RequisitosPensionesAlimenticias.listapensiones;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_PensionesAlimenticias implements ActionListener {

    RequisitosPensionesAlimenticias rpa;
    String r1, r2, r3, r4, r5, r6, obser;
    public static String ced;
    public static String ca;

    public C_Requisitos_PensionesAlimenticias(RequisitosPensionesAlimenticias rpa) {
        this.rpa = rpa;
        this.rpa.btnGuardar.addActionListener(this);
        this.rpa.btnModificar.addActionListener(this);
        this.rpa.btn_pago.addActionListener(this);
        this.rpa.rq1.addActionListener(this);
        this.rpa.rq2.addActionListener(this);
        this.rpa.rq3.addActionListener(this);
        this.rpa.rq4.addActionListener(this);
        this.rpa.rq5.addActionListener(this);
        this.rpa.rq6.addActionListener(this);

        cargarcheck();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == rpa.btnGuardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == rpa.btnModificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == rpa.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago pago = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            rpa.setVisible(false);
        }
        if (evt.getSource() == rpa.rq1) {

        }
        if (evt.getSource() == rpa.rq2) {

        }
        if (evt.getSource() == rpa.rq3) {

        }
        if (evt.getSource() == rpa.rq4) {

        }
        if (evt.getSource() == rpa.rq5) {

        }
        if (evt.getSource() == rpa.rq6) {

        }
    }

    public void agregar() {

        if (rpa.rq1.isSelected() == true) {
            r1 = rpa.rq1.getText();
        }
        if (rpa.rq2.isSelected() == true) {
            r2 = rpa.rq2.getText();
        }
        if (rpa.rq3.isSelected() == true) {
            r3 = rpa.rq3.getText();
        }
        if (rpa.rq4.isSelected() == true) {
            r4 = rpa.rq4.getText();
        }
        if (rpa.rq5.isSelected() == true) {
            r5 = rpa.rq5.getText();
        }
        if (rpa.rq6.isSelected() == true) {
            r6 = rpa.rq6.getText();
        }
        obser = rpa.observaciones.getText();
        PensionesAlimenticias di = new PensionesAlimenticias(ced, r1, r2, r3, r4, r5, r6, "", obser);
        listapensiones.add(di);

    }

    public void cargarcheck() {
        for (int i = 0; i < listapensiones.size(); i++) {
            if (listapensiones.get(i).getCedula().equals(ced)) {
                if (listapensiones.get(i).getRq1() == null) {
                } else {
                    if (listapensiones.get(i).getRq1().equals("COPIA DE CEDULA")) {
                        rpa.rq1.setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq2() == null) {
                } else {
                    if (listapensiones.get(i).getRq2().equals("COPIA DE PAPEL DE VOTACION")) {
                        rpa.rq2.setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq3() == null) {
                } else {
                    if (listapensiones.get(i).getRq3().equals("PARTIDAS DE NACIMIENTO DEL NIÑO")) {
                        rpa.rq3.setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq4() == null) {
                } else {
                    if (listapensiones.get(i).getRq4().equals("DIRECCION DEL TRABAJO Y CASA DEL DEMANDADO")) {
                        rpa.rq4.setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq5() == null) {
                } else {
                    if (listapensiones.get(i).getRq5().equals("RECIBOS Y FACTURAS DE GASTOS")) {
                        rpa.rq5.setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq6() == null) {
                } else {
                    if (listapensiones.get(i).getRq6().equals("CERTIFICADO DE CONADIS SI TIENE DISCAPACIDAD")) {
                        rpa.rq6.setSelected(true);
                    }
                }
                obser = listapensiones.get(i).getObservaciones();
                rpa.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        rpa.observaciones.setEditable(true);
        if (rpa.rq1.isSelected() == true) {
            r1 = rpa.rq1.getText();
        }
        if (rpa.rq2.isSelected() == true) {
            r2 = rpa.rq2.getText();
        }
        if (rpa.rq3.isSelected() == true) {
            r3 = rpa.rq3.getText();
        }
        if (rpa.rq4.isSelected() == true) {
            r4 = rpa.rq4.getText();
        }
        if (rpa.rq5.isSelected() == true) {
            r5 = rpa.rq5.getText();
        }
        if (rpa.rq6.isSelected() == true) {
            r6 = rpa.rq6.getText();
        }

        for (int i = 0; i < listapensiones.size(); i++) {
            if (listapensiones.get(i).getCedula().equals(ced)) {
                listapensiones.get(i).setRq1(r1);
                listapensiones.get(i).setRq2(r2);
                listapensiones.get(i).setRq3(r3);
                listapensiones.get(i).setRq4(r4);
                listapensiones.get(i).setRq5(r5);
                listapensiones.get(i).setRq6(r6);
                listapensiones.get(i).setObservaciones(rpa.observaciones.getText());
            }
        }

    }

}
