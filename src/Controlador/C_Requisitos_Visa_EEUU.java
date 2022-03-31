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
import javax.swing.JOptionPane;
import modelo.VisaEEUU;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosEstadosUnidos;
import static vista.RequisitosEstadosUnidos.listaeeuu;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Visa_EEUU implements ActionListener {

    RequisitosEstadosUnidos reu;
    String r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, obser;
    public static String ced;
    public static String ca;

    public C_Requisitos_Visa_EEUU(RequisitosEstadosUnidos reu) {
        this.reu = reu;
        this.reu.btn_guardar.addActionListener(this);
        this.reu.btn_pago.addActionListener(this);
        this.reu.btnmoficar.addActionListener(this);
        this.reu.rq1.addActionListener(this);
        this.reu.rq2.addActionListener(this);
        this.reu.rq3.addActionListener(this);
        this.reu.rq4.addActionListener(this);
        this.reu.rq5.addActionListener(this);
        this.reu.rq6.addActionListener(this);
        this.reu.rq7.addActionListener(this);
        this.reu.rq8.addActionListener(this);
        this.reu.rq9.addActionListener(this);
        this.reu.rq10.addActionListener(this);
        numBeneficiario();
        cargarcheck();
    }

    public void numBeneficiario() {
        reu.comboNum.addItem("Seleccionar...");
        reu.comboNum.addItem("1");
        reu.comboNum.addItem("2");
        reu.comboNum.addItem("3");
        reu.comboNum.addItem("4");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == reu.btn_guardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();

            for (int i = 0; i < listaeeuu.size(); i++) {
                System.out.println("" + listaeeuu.get(i).getCedula() + "" + listaeeuu.get(i).getReq1() + " " + listaeeuu.get(i).getHonorarios() + " " + listaeeuu.get(i).getNum() + " " + listaeeuu.get(i).getObservaciones());
            }
            for (int i = 0; i < listaeeuu.size(); i++) {
                System.out.println(listaeeuu.get(i));
            }
        }
        if (evt.getSource() == reu.btnmoficar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == reu.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            reu.setVisible(false);
        }

        if (evt.getSource() == reu.rq1) {

        }
        if (evt.getSource() == reu.rq2) {

        }
        if (evt.getSource() == reu.rq3) {

        }
        if (evt.getSource() == reu.rq4) {

        }
        if (evt.getSource() == reu.rq5) {

        }
        if (evt.getSource() == reu.rq6) {

        }
        if (evt.getSource() == reu.rq7) {

        }
        if (evt.getSource() == reu.rq8) {

        }
        if (evt.getSource() == reu.rq9) {

        }
        if (evt.getSource() == reu.rq10) {

        }

    }

    public void agregar() {

        if (reu.rq1.isSelected() == true) {
            r1 = reu.rq1.getText();
        }
        if (reu.rq2.isSelected() == true) {
            r2 = reu.rq2.getText();
        }
        if (reu.rq3.isSelected() == true) {
            r3 = reu.rq3.getText();
        }
        if (reu.rq4.isSelected() == true) {
            r4 = reu.rq4.getText();
        }
        if (reu.rq5.isSelected() == true) {
            r5 = reu.rq5.getText();
        }
        if (reu.rq6.isSelected() == true) {
            r6 = reu.rq6.getText();
        }
        if (reu.rq7.isSelected() == true) {
            r7 = reu.rq7.getText();
        }
        if (reu.rq8.isSelected() == true) {
            r8 = reu.rq8.getText();
        }
        if (reu.rq9.isSelected() == true) {
            r9 = reu.rq9.getText();
        }
        if (reu.rq10.isSelected() == true) {
            r10 = reu.rq10.getText();
        }
        if (reu.rq11.isSelected() == true) {
            r11 = reu.rq11.getText();
        }
        String cantidad = (String) reu.comboNum.getSelectedItem();
        obser = reu.observaciones.getText();
        System.out.println(r1 + r2 + obser);
        VisaEEUU m = new VisaEEUU(ced, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, cantidad, "90", obser);
        listaeeuu.add(m);

    }

    public void cargarcheck() {
        for (int i = 0; i < listaeeuu.size(); i++) {
            if (listaeeuu.get(i).getCedula().equals(ced)) {
                if (listaeeuu.get(i).getReq1() == null) {
                } else {
                    if (listaeeuu.get(i).getReq1().equals("PASAPORTE")) {
                        reu.rq1.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq2() == null) {
                } else {
                    if (listaeeuu.get(i).getReq2().equals("COPIA DE CEDULA")) {
                        reu.rq2.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq3() == null) {
                } else {
                    if (listaeeuu.get(i).getReq3().equals("PARTIDAS DE NACIMIENTOS ")) {
                        reu.rq3.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq4() == null) {
                } else {
                    if (listaeeuu.get(i).getReq4().equals("PARTIDA DE MATRIMONIO")) {
                        reu.rq4.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq5() == null) {
                } else {
                    if (listaeeuu.get(i).getReq5().equals("DIRECCION DE LOS EEUU")) {
                        reu.rq5.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq6() == null) {
                } else {
                    if (listaeeuu.get(i).getReq6().equals("FOTOS 5 x 5 ")) {
                        reu.rq6.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq7() == null) {
                } else {
                    if (listaeeuu.get(i).getReq7().equals("MATRICULA DE VEHICULO")) {
                        reu.rq7.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq8() == null) {
                } else {
                    if (listaeeuu.get(i).getReq8().equals("CERTIFICADOS BANCARIOS")) {
                        reu.rq8.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq9() == null) {
                } else {
                    if (listaeeuu.get(i).getReq9().equals("CERTIFICADO DE TRABAJO")) {
                        reu.rq9.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq10() == null) {
                } else {
                    if (listaeeuu.get(i).getReq10().equals("CERTIFICADO DE ESTUDIO")) {
                        reu.rq10.setSelected(true);
                    }
                }
                if (listaeeuu.get(i).getReq11() == null) {
                } else {
                    if (listaeeuu.get(i).getReq11().equals("PREDIOS")) {
                        reu.rq11.setSelected(true);
                    }
                }
                reu.comboNum.removeAllItems();
                reu.comboNum.addItem(listaeeuu.get(i).getNum());

                obser = listaeeuu.get(i).getObservaciones();
                reu.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        String cantidad = (String) reu.comboNum.getSelectedItem();
        reu.observaciones.setEditable(true);
        if (reu.rq1.isSelected() == true) {
            r1 = reu.rq1.getText();
        }
        if (reu.rq2.isSelected() == true) {
            r2 = reu.rq2.getText();
        }
        if (reu.rq3.isSelected() == true) {
            r3 = reu.rq3.getText();
        }
        if (reu.rq4.isSelected() == true) {
            r4 = reu.rq4.getText();
        }
        if (reu.rq5.isSelected() == true) {
            r5 = reu.rq5.getText();
        }
        if (reu.rq6.isSelected() == true) {
            r6 = reu.rq6.getText();
        }
        if (reu.rq7.isSelected() == true) {
            r7 = reu.rq7.getText();
        }
        if (reu.rq8.isSelected() == true) {
            r8 = reu.rq8.getText();
        }
        if (reu.rq9.isSelected() == true) {
            r9 = reu.rq9.getText();
        }
        if (reu.rq10.isSelected() == true) {
            r10 = reu.rq10.getText();
        }
        if (reu.rq11.isSelected() == true) {
            r11 = reu.rq11.getText();
        }

        for (int i = 0; i < listaeeuu.size(); i++) {
            if (listaeeuu.get(i).getCedula().equals(ced)) {
                listaeeuu.get(i).setReq1(r1);
                listaeeuu.get(i).setReq2(r2);
                listaeeuu.get(i).setReq3(r3);
                listaeeuu.get(i).setReq4(r4);
                listaeeuu.get(i).setReq5(r5);
                listaeeuu.get(i).setReq6(r6);
                listaeeuu.get(i).setReq7(r7);
                listaeeuu.get(i).setReq8(r8);
                listaeeuu.get(i).setReq9(r9);
                listaeeuu.get(i).setReq10(r10);
                listaeeuu.get(i).setReq11(r11);
                listaeeuu.get(i).setObservaciones(reu.observaciones.getText());
            }
        }
    }
}
