/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.VisaLoteria;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosLoteria;
import static vista.RequisitosLoteria.listaloteria;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Visa_Loteria implements ActionListener {

    RequisitosLoteria loteria;
    String r1, r2, r3, r4, r5, r6, r7, r8, r9, obser;
    public static String ced, ca;

    public C_Requisitos_Visa_Loteria(RequisitosLoteria loteria) {
        this.loteria = loteria;
        this.loteria.btn_pago.addActionListener(this);
        this.loteria.btnguardar.addActionListener(this);
        this.loteria.btnmodificar.addActionListener(this);
        this.loteria.rq1.addActionListener(this);
        this.loteria.rq2.addActionListener(this);
        this.loteria.rq3.addActionListener(this);
        this.loteria.rq4.addActionListener(this);
        this.loteria.rq5.addActionListener(this);
        this.loteria.rq6.addActionListener(this);
        this.loteria.rq7.addActionListener(this);
        this.loteria.rq8.addActionListener(this);
        this.loteria.rq9.addActionListener(this);

        numBeneficiario();
        cargarcheck();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == loteria.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            loteria.setVisible(false);
        }
        if (evt.getSource() == loteria.btnguardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == loteria.btnmodificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == loteria.rq1) {

        }
        if (evt.getSource() == loteria.rq2) {

        }
        if (evt.getSource() == loteria.rq3) {

        }
        if (evt.getSource() == loteria.rq4) {

        }
        if (evt.getSource() == loteria.rq5) {

        }
        if (evt.getSource() == loteria.rq6) {

        }
        if (evt.getSource() == loteria.rq7) {

        }
        if (evt.getSource() == loteria.rq8) {

        }
        if (evt.getSource() == loteria.rq9) {

        }
    }

    public void numBeneficiario() {
        loteria.comboNum.addItem("Seleccionar...");
        loteria.comboNum.addItem("1");
        loteria.comboNum.addItem("2");
        loteria.comboNum.addItem("3");
        loteria.comboNum.addItem("4");
    }

    public void agregar() {

        if (loteria.rq1.isSelected() == true) {
            r1 = loteria.rq1.getText();
        }
        if (loteria.rq2.isSelected() == true) {
            r2 = loteria.rq2.getText();
        }
        if (loteria.rq3.isSelected() == true) {
            r3 = loteria.rq3.getText();
        }
        if (loteria.rq4.isSelected() == true) {
            r4 = loteria.rq4.getText();
        }
        if (loteria.rq5.isSelected() == true) {
            r5 = loteria.rq5.getText();
        }
        if (loteria.rq6.isSelected() == true) {
            r6 = loteria.rq6.getText();
        }
        if (loteria.rq7.isSelected() == true) {
            r7 = loteria.rq7.getText();
        }
        if (loteria.rq8.isSelected() == true) {
            r8 = loteria.rq8.getText();
        }
        if (loteria.rq9.isSelected() == true) {
            r9 = loteria.rq9.getText();
        }
        String cantidad = (String) loteria.comboNum.getSelectedItem();
        obser = loteria.observaciones.getText();
        VisaLoteria m = new VisaLoteria(ced, r1, r2, r3, r4, r5, r6, r7, r8, r9, cantidad, "", obser);
        listaloteria.add(m);

    }

    public void cargarcheck() {
        for (int i = 0; i < listaloteria.size(); i++) {
            if (listaloteria.get(i).getCedula().equals(ced)) {
                if (listaloteria.get(i).getReq1() == null) {
                } else {
                    if (listaloteria.get(i).getReq1().equals("PASAPORTE")) {
                        loteria.rq1.setSelected(true);
                    }
                }
                if (listaloteria.get(i).getReq2() == null) {
                } else {
                    if (listaloteria.get(i).getReq2().equals("PARTIDA DE NACIMIENTOS")) {
                        loteria.rq2.setSelected(true);
                    }
                }
                if (listaloteria.get(i).getReq3() == null) {
                } else {
                    if (listaloteria.get(i).getReq3().equals("PARTIDA DE MATRIMONIO")) {
                        loteria.rq3.setSelected(true);
                    }
                }
                if (listaloteria.get(i).getReq4() == null) {
                } else {
                    if (listaloteria.get(i).getReq4().equals("DATOS DE ESTUDIOS")) {
                        loteria.rq4.setSelected(true);
                    }
                }
                if (listaloteria.get(i).getReq5() == null) {
                } else {
                    if (listaloteria.get(i).getReq5().equals("DATOS DE PADRES")) {
                        loteria.rq5.setSelected(true);
                    }
                }
                if (listaloteria.get(i).getReq6() == null) {
                } else {
                    if (listaloteria.get(i).getReq6().equals("DATOS DE HERMANOS")) {
                        loteria.rq6.setSelected(true);
                    }
                }
                if (listaloteria.get(i).getReq7() == null) {
                } else {
                    if (listaloteria.get(i).getReq7().equals("DIRECCION DE LOS EEUU")) {
                        loteria.rq7.setSelected(true);
                    }
                }
                if (listaloteria.get(i).getReq8() == null) {
                } else {
                    if (listaloteria.get(i).getReq8().equals("FOTO DIGITAL 5 X5")) {
                        loteria.rq8.setSelected(true);
                    }
                }
                if (listaloteria.get(i).getReq9() == null) {
                } else {
                    if (listaloteria.get(i).getReq9().equals("DATOS DE TRABAJO")) {
                        loteria.rq9.setSelected(true);
                    }
                }
                loteria.comboNum.removeAllItems();
                loteria.comboNum.addItem(listaloteria.get(i).getNum());

                obser = listaloteria.get(i).getObservaciones();
                loteria.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        String cantidad = (String) loteria.comboNum.getSelectedItem();
        loteria.observaciones.setEditable(true);
        if (loteria.rq1.isSelected() == true) {
            r1 = loteria.rq1.getText();
        }
        if (loteria.rq2.isSelected() == true) {
            r2 = loteria.rq2.getText();
        }
        if (loteria.rq3.isSelected() == true) {
            r3 = loteria.rq3.getText();
        }
        if (loteria.rq4.isSelected() == true) {
            r4 = loteria.rq4.getText();
        }
        if (loteria.rq5.isSelected() == true) {
            r5 = loteria.rq5.getText();
        }
        if (loteria.rq6.isSelected() == true) {
            r6 = loteria.rq6.getText();
        }
        if (loteria.rq7.isSelected() == true) {
            r7 = loteria.rq7.getText();
        }
        if (loteria.rq8.isSelected() == true) {
            r8 = loteria.rq8.getText();
        }
        if (loteria.rq9.isSelected() == true) {
            r9 = loteria.rq9.getText();
        }

        for (int i = 0; i < listaloteria.size(); i++) {
            if (listaloteria.get(i).getCedula().equals(ced)) {
                listaloteria.get(i).setReq1(r1);
                listaloteria.get(i).setReq2(r2);
                listaloteria.get(i).setReq3(r3);
                listaloteria.get(i).setReq4(r4);
                listaloteria.get(i).setReq5(r5);//listamexico.get(i).setobservacion(nombretextarea.getText)
                listaloteria.get(i).setReq6(r6);
                listaloteria.get(i).setReq7(r7);
                listaloteria.get(i).setReq8(r8);
                listaloteria.get(i).setReq9(r9);
                listaloteria.get(i).setObservaciones(loteria.observaciones.getText());
            }
        }

    }

}
