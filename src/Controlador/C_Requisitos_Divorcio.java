/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Divorcio;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitoDivorcio;
import static vista.RequisitoDivorcio.listadivorcio;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Divorcio implements ActionListener {

    RequisitoDivorcio divorcio;

    String r1, r2, r3, r4, r5, r6, obser;
    public static String ced;
    public static String ca;

    public C_Requisitos_Divorcio(RequisitoDivorcio divorcio) {
        this.divorcio = divorcio;
        this.divorcio.btnGuardar.addActionListener(this);
        this.divorcio.btnModificar.addActionListener(this);
        this.divorcio.btn_pago.addActionListener(this);
        this.divorcio.rq1.addActionListener(this);
        this.divorcio.rq2.addActionListener(this);
        this.divorcio.rq3.addActionListener(this);
        this.divorcio.rq4.addActionListener(this);
        this.divorcio.rq5.addActionListener(this);

        cargarcheck();

    }

    public void agregar() {

        if (divorcio.rq1.isSelected() == true) {
            r1 = divorcio.rq1.getText();
        }
        if (divorcio.rq2.isSelected() == true) {
            r2 = divorcio.rq2.getText();
        }
        if (divorcio.rq3.isSelected() == true) {
            r3 = divorcio.rq3.getText();
        }
        if (divorcio.rq4.isSelected() == true) {
            r4 = divorcio.rq4.getText();
        }
        if (divorcio.rq5.isSelected() == true) {
            r5 = divorcio.rq5.getText();
        }
        if (divorcio.rq6.isSelected() == true) {
            r6 = divorcio.rq6.getText();
        }
        obser = divorcio.observaciones.getText();
        Divorcio di = new Divorcio(ced, r1, r2, r3, r4, r5, r6, "", obser);
        listadivorcio.add(di);

    }

    public void cargarcheck() {
        for (int i = 0; i < listadivorcio.size(); i++) {
            if (listadivorcio.get(i).getCedula().equals(ced)) {
                if (listadivorcio.get(i).getRq1() == null) {
                } else {
                    if (listadivorcio.get(i).getRq1().equals("CEDULA Y PAPEL DE VOTACION")) {
                        divorcio.rq1.setSelected(true);
                    }
                }
                if (listadivorcio.get(i).getRq2() == null) {
                } else {
                    if (listadivorcio.get(i).getRq2().equals("PARTIDA DE MATRIMONIO")) {
                        divorcio.rq2.setSelected(true);
                    }
                }
                if (listadivorcio.get(i).getRq3() == null) {
                } else {
                    if (listadivorcio.get(i).getRq3().equals("PARTIDAS DE NACIMIENTOS DE HIJOS")) {
                        divorcio.rq3.setSelected(true);
                    }
                }
                if (listadivorcio.get(i).getRq4() == null) {
                } else {
                    if (listadivorcio.get(i).getRq4().equals("CERTIFICADO DE BIENES DENTRO DEL MATRIMONIO")) {
                        divorcio.rq4.setSelected(true);
                    }
                }
                if (listadivorcio.get(i).getRq5() == null) {
                } else {
                    if (listadivorcio.get(i).getRq5().equals("UBICACIONES ")) {
                        divorcio.rq5.setSelected(true);
                    }
                }
                if (listadivorcio.get(i).getRq6() == null) {
                } else {
                    if (listadivorcio.get(i).getRq6().equals("TESTIGOS- PARTIDA DE NACIMIENTO DE HIJOS CONCEBIDOS FUERA DEL MATRIMONIO")) {
                        divorcio.rq6.setSelected(true);
                    }
                }
                obser = listadivorcio.get(i).getObservaciones();
                divorcio.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        divorcio.observaciones.setEditable(true);
        if (divorcio.rq1.isSelected() == true) {
            r1 = divorcio.rq1.getText();
        }
        if (divorcio.rq2.isSelected() == true) {
            r2 = divorcio.rq2.getText();
        }
        if (divorcio.rq3.isSelected() == true) {
            r3 = divorcio.rq3.getText();
        }
        if (divorcio.rq4.isSelected() == true) {
            r4 = divorcio.rq4.getText();
        }
        if (divorcio.rq5.isSelected() == true) {
            r5 = divorcio.rq5.getText();
        }
        if (divorcio.rq6.isSelected() == true) {
            r6 = divorcio.rq6.getText();
        }

        for (int i = 0; i < listadivorcio.size(); i++) {
            if (listadivorcio.get(i).getCedula().equals(ced)) {
                listadivorcio.get(i).setRq1(r1);
                listadivorcio.get(i).setRq2(r2);
                listadivorcio.get(i).setRq3(r3);
                listadivorcio.get(i).setRq4(r4);
                listadivorcio.get(i).setRq5(r5);
                listadivorcio.get(i).setRq6(r6);
                listadivorcio.get(i).setObservaciones(divorcio.observaciones.getText());
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == divorcio.btnGuardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == divorcio.btnModificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == divorcio.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p=new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            divorcio.setVisible(false);
        }
        if (evt.getSource() == divorcio.rq1) {

        }
        if (evt.getSource() == divorcio.rq2) {

        }
        if (evt.getSource() == divorcio.rq3) {

        }
        if (evt.getSource() == divorcio.rq4) {

        }
        if (evt.getSource() == divorcio.rq5) {

        }
    }

}
