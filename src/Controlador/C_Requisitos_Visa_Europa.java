/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.VisaEuropa;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosEuropa;
import static vista.RequisitosEuropa.listaeuropa;
import static vista.RequisitosEuropa.x;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Visa_Europa implements ActionListener {

    RequisitosEuropa re;

    String r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, obser;
    public static String ced;
    public static String ca;

    public C_Requisitos_Visa_Europa(RequisitosEuropa re) {
        this.re = re;
        this.re.btn_pago.addActionListener(this);
        this.re.btnguardar.addActionListener(this);
        this.re.btnmodificar.addActionListener(this);
        this.re.rq1.addActionListener(this);
        this.re.rq2.addActionListener(this);
        this.re.rq3.addActionListener(this);
        this.re.rq4.addActionListener(this);
        this.re.rq5.addActionListener(this);
        this.re.rq6.addActionListener(this);
        this.re.rq7.addActionListener(this);
        this.re.rq8.addActionListener(this);
        this.re.rq9.addActionListener(this);
        this.re.rq10.addActionListener(this);
        this.re.rq11.addActionListener(this);
        this.re.rq12.addActionListener(this);
        this.re.rq13.addActionListener(this);
        this.re.rq14.addActionListener(this);
        this.re.rq15.addActionListener(this);
        this.re.rq16.addActionListener(this);
        this.re.rq17.addActionListener(this);

        numBeneficiario();
        cargarcheck();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == re.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            re.setVisible(false);
        }
        if (evt.getSource() == re.btnguardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == re.btnmodificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == re.rq1) {

        }
        if (evt.getSource() == re.rq2) {

        }
        if (evt.getSource() == re.rq3) {

        }
        if (evt.getSource() == re.rq4) {

        }
        if (evt.getSource() == re.rq5) {

        }
        if (evt.getSource() == re.rq6) {

        }
        if (evt.getSource() == re.rq7) {

        }
        if (evt.getSource() == re.rq8) {

        }
        if (evt.getSource() == re.rq9) {

        }
        if (evt.getSource() == re.rq10) {

        }
        if (evt.getSource() == re.rq11) {

        }
        if (evt.getSource() == re.rq12) {

        }
        if (evt.getSource() == re.rq13) {

        }
        if (evt.getSource() == re.rq14) {

        }
        if (evt.getSource() == re.rq15) {

        }
        if (evt.getSource() == re.rq16) {

        }
        if (evt.getSource() == re.rq17) {

        }
    }

    public void numBeneficiario() {
        re.comboNum.addItem("Seleccionar...");
        re.comboNum.addItem("1");
        re.comboNum.addItem("2");
        re.comboNum.addItem("3");
        re.comboNum.addItem("4");
    }

    /**
     * Creates new form RequisistoEuropa
     */
    public void agregar() {

        if (re.rq1.isSelected() == true) {
            r1 = re.rq1.getText();
        }
        if (re.rq2.isSelected() == true) {
            r2 = re.rq2.getText();
        }
        if (re.rq3.isSelected() == true) {
            r3 = re.rq3.getText();
        }
        if (re.rq4.isSelected() == true) {
            r4 = re.rq4.getText();
        }
        if (re.rq5.isSelected() == true) {
            r5 = re.rq5.getText();
        }
        if (re.rq6.isSelected() == true) {
            r6 = re.rq6.getText();
        }
        if (re.rq7.isSelected() == true) {
            r7 = re.rq7.getText();
        }
        if (re.rq8.isSelected() == true) {
            r8 = re.rq8.getText();
        }
        if (re.rq9.isSelected() == true) {
            r9 = re.rq9.getText();
        }
        if (re.rq10.isSelected() == true) {
            r10 = re.rq10.getText();
        }
        if (re.rq11.isSelected() == true) {
            r11 = re.rq11.getText();
        }
        if (re.rq12.isSelected() == true) {
            r12 = re.rq12.getText();
        }
        if (re.rq13.isSelected() == true) {
            r13 = re.rq13.getText();
        }
        if (re.rq14.isSelected() == true) {
            r14 = re.rq14.getText();
        }
        if (re.rq15.isSelected() == true) {
            r15 = re.rq15.getText();
        }
        if (re.rq16.isSelected() == true) {
            r16 = re.rq16.getText();
        }
        if (re.rq17.isSelected() == true) {
            r17 = re.rq17.getText();
        }
        String cantidad = (String) re.comboNum.getSelectedItem();
        obser = re.observaciones.getText();
        System.out.println(r1 + r2 + obser);
        VisaEuropa m = new VisaEuropa(ced, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, cantidad, "70", obser);
        listaeuropa.add(m);

    }

    public void cargarcheck() {
        for (int i = 0; i < listaeuropa.size(); i++) {
            if (listaeuropa.get(i).getCedula().equals(ced)) {
                if (listaeuropa.get(i).getReq1() == null) {
                } else {
                    if (listaeuropa.get(i).getReq1().equals("PARTIDA DE MATRIMONIO")) {
                        re.rq1.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq2() == null) {
                } else {
                    if (listaeuropa.get(i).getReq2().equals("CERTIFICADO BANCARIO")) {
                        re.rq2.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq3() == null) {
                } else {
                    if (listaeuropa.get(i).getReq3().equals("ESCRITURAS ORIGINALES")) {
                        re.rq3.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq4() == null) {
                } else {
                    if (listaeuropa.get(i).getReq4().equals("PAGO DE SEGURO")) {
                        re.rq4.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq5() == null) {
                } else {
                    if (listaeuropa.get(i).getReq5().equals("LIBRETA DE AHORRO")) {
                        re.rq5.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq6() == null) {
                } else {
                    if (listaeuropa.get(i).getReq6().equals("ESTADOS DE CUENTA")) {
                        re.rq6.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq7() == null) {
                } else {
                    if (listaeuropa.get(i).getReq7().equals("ESTADOS DE CUENTA")) {
                        re.rq7.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq8() == null) {
                } else {
                    if (listaeuropa.get(i).getReq8().equals("DIRECCION EN EUROPA")) {
                        re.rq8.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq9() == null) {
                } else {
                    if (listaeuropa.get(i).getReq9().equals("2 FOTOS 5 X5")) {
                        re.rq9.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq10() == null) {
                } else {
                    if (listaeuropa.get(i).getReq10().equals("COPIA DE CEDULA")) {
                        re.rq10.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq11() == null) {
                } else {
                    if (listaeuropa.get(i).getReq11().equals("COPIA DE CEDULA")) {
                        re.rq11.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq12() == null) {
                } else {
                    if (listaeuropa.get(i).getReq12().equals("COPIA DE CEDULA")) {
                        re.rq12.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq13() == null) {
                } else {
                    if (listaeuropa.get(i).getReq13().equals("IMPUESTO A LA RENTA")) {
                        re.rq13.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq14() == null) {
                } else {
                    if (listaeuropa.get(i).getReq14().equals("RUC Y DECLARACIONES")) {
                        re.rq14.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq15() == null) {
                } else {
                    if (listaeuropa.get(i).getReq15().equals("CERTIFICADO DE TRABAJO")) {
                        re.rq15.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq16() == null) {
                } else {
                    if (listaeuropa.get(i).getReq16().equals("PAGO DE PREDIO")) {
                        re.rq16.setSelected(true);
                    }
                }
                if (listaeuropa.get(i).getReq17() == null) {
                } else {
                    if (listaeuropa.get(i).getReq17().equals("COPIA DE TITULO")) {
                        re.rq17.setSelected(true);
                    }
                }
                re.comboNum.removeAllItems();
                re.comboNum.addItem(listaeuropa.get(i).getNum());

                obser = listaeuropa.get(i).getObservaciones();
                re.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        String cantidad = (String) re.comboNum.getSelectedItem();
        re.observaciones.setEditable(true);
        if (re.rq1.isSelected() == true) {
            r1 = re.rq1.getText();
        }
        if (re.rq2.isSelected() == true) {
            r2 = re.rq2.getText();
        }
        if (re.rq3.isSelected() == true) {
            r3 = re.rq3.getText();
        }
        if (re.rq4.isSelected() == true) {
            r4 = re.rq4.getText();
        }
        if (re.rq5.isSelected() == true) {
            r5 = re.rq5.getText();
        }
        if (re.rq6.isSelected() == true) {
            r6 = re.rq6.getText();
        }
        if (re.rq7.isSelected() == true) {
            r7 = re.rq7.getText();
        }
        if (re.rq8.isSelected() == true) {
            r8 = re.rq8.getText();
        }
        if (re.rq9.isSelected() == true) {
            r9 = re.rq9.getText();
        }
        if (re.rq10.isSelected() == true) {
            r10 = re.rq10.getText();
        }
        if (re.rq11.isSelected() == true) {
            r11 = re.rq11.getText();
        }
        if (re.rq12.isSelected() == true) {
            r12 = re.rq12.getText();
        }
        if (re.rq13.isSelected() == true) {
            r13 = re.rq13.getText();
        }
        if (re.rq14.isSelected() == true) {
            r14 = re.rq14.getText();
        }
        if (re.rq15.isSelected() == true) {
            r15 = re.rq15.getText();
        }
        if (re.rq16.isSelected() == true) {
            r16 = re.rq16.getText();
        }
        if (re.rq17.isSelected() == true) {
            r17 = re.rq17.getText();
        }

        for (int i = 0; i < listaeuropa.size(); i++) {
            if (listaeuropa.get(i).getCedula().equals(ced)) {
                listaeuropa.get(i).setReq1(r1);
                listaeuropa.get(i).setReq2(r2);
                listaeuropa.get(i).setReq3(r3);
                listaeuropa.get(i).setReq4(r4);
                listaeuropa.get(i).setReq5(r5);
                listaeuropa.get(i).setReq6(r6);
                listaeuropa.get(i).setReq7(r7);
                listaeuropa.get(i).setReq8(r8);
                listaeuropa.get(i).setReq9(r9);
                listaeuropa.get(i).setReq10(r10);
                listaeuropa.get(i).setReq11(r11);
                listaeuropa.get(i).setReq12(r12);
                listaeuropa.get(i).setReq13(r13);
                listaeuropa.get(i).setReq14(r14);
                listaeuropa.get(i).setReq15(r15);
                listaeuropa.get(i).setReq16(r16);
                listaeuropa.get(i).setReq17(r17);
                listaeuropa.get(i).setObservaciones(re.observaciones.getText());
            }
        }
    }

}
