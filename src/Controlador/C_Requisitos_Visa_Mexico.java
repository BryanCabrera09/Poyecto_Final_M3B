/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.VisaMexico;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosVisaMexico;
import static vista.RequisitosVisaMexico.listamexico;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Visa_Mexico implements ActionListener {

    RequisitosVisaMexico mexico;
    public static String ced, ca;
    String r1, r2, r3, r4, r5, obser;

    public C_Requisitos_Visa_Mexico(RequisitosVisaMexico mexico) {
        this.mexico = mexico;
        this.mexico.btnGuardar.addActionListener(this);
        this.mexico.btnModificar.addActionListener(this);
        this.mexico.btn_pago.addActionListener(this);
        this.mexico.req1.addActionListener(this);
        this.mexico.req2.addActionListener(this);
        this.mexico.req3.addActionListener(this);
        this.mexico.req4.addActionListener(this);
        this.mexico.req5.addActionListener(this);

        numBeneficiario();
        cargarcheck();

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == mexico.btnGuardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == mexico.btnModificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == mexico.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            mexico.setVisible(false);
        }
        if (evt.getSource() == mexico.req1) {

        }
        if (evt.getSource() == mexico.req2) {

        }
        if (evt.getSource() == mexico.req3) {

        }
        if (evt.getSource() == mexico.req4) {

        }
        if (evt.getSource() == mexico.req5) {

        }
    }

    public void numBeneficiario() {
        mexico.comboNum.addItem("Seleccionar...");
        mexico.comboNum.addItem("1");
        mexico.comboNum.addItem("2");
        mexico.comboNum.addItem("3");
        mexico.comboNum.addItem("4");
    }

    public void agregar() {

        if (mexico.req1.isSelected() == true) {
            r1 = mexico.req1.getText();
        }
        if (mexico.req2.isSelected() == true) {
            r2 = mexico.req2.getText();
        }
        if (mexico.req3.isSelected() == true) {
            r3 = mexico.req3.getText();
        }
        if (mexico.req4.isSelected() == true) {
            r4 = mexico.req4.getText();
        }
        if (mexico.req5.isSelected() == true) {
            r5 = mexico.req5.getText();
        }
        String cantidad = (String) mexico.comboNum.getSelectedItem();
        obser = mexico.obv.getText();
        VisaMexico m = new VisaMexico(ced, r1, r2, r3, r4, r5, cantidad, "", obser);
        listamexico.add(m);

    }

    public void cargarcheck() {
        for (int i = 0; i < listamexico.size(); i++) {
            if (listamexico.get(i).getCedula().equals(ced)) {
                if (listamexico.get(i).getReq1() == null) {
                } else {
                    if (listamexico.get(i).getReq1().equals("PASAPORTE")) {
                        mexico.req1.setSelected(true);
                    }
                }
                if (listamexico.get(i).getReq2() == null) {
                } else {
                    if (listamexico.get(i).getReq2().equals("FOTO 3 x 3.5")) {
                        mexico.req2.setSelected(true);
                    }
                }
                if (listamexico.get(i).getReq3() == null) {
                } else {
                    if (listamexico.get(i).getReq3().equals("PREDIOS")) {
                        mexico.req3.setSelected(true);
                    }
                }
                if (listamexico.get(i).getReq4() == null) {
                } else {
                    if (listamexico.get(i).getReq4().equals("CERTIFICADO DE TRABAJO")) {
                        mexico.req4.setSelected(true);
                    }
                }
                if (listamexico.get(i).getReq5() == null) {
                } else {
                    if (listamexico.get(i).getReq5().equals("CERTIFICADO DE ESTUDIOS")) {
                        mexico.req5.setSelected(true);
                    }
                }
                mexico.comboNum.removeAllItems();
                mexico.comboNum.addItem(listamexico.get(i).getNum());

                obser = listamexico.get(i).getObservaciones();
                mexico.obv.setText(obser);
            }
        }

    }

    public void modificarreq() {
        String cantidad = (String) mexico.comboNum.getSelectedItem();
        mexico.obv.setEditable(true);
        if (mexico.req1.isSelected() == true) {
            r1 = mexico.req1.getText();
        }
        if (mexico.req2.isSelected() == true) {
            r2 = mexico.req2.getText();
        }
        if (mexico.req3.isSelected() == true) {
            r3 = mexico.req3.getText();
        }
        if (mexico.req4.isSelected() == true) {
            r4 = mexico.req4.getText();
        }
        if (mexico.req5.isSelected() == true) {
            r5 = mexico.req5.getText();
        }

        for (int i = 0; i < listamexico.size(); i++) {
            if (listamexico.get(i).getCedula().equals(ced)) {
                listamexico.get(i).setReq1(r1);
                listamexico.get(i).setReq2(r2);
                listamexico.get(i).setReq3(r3);
                listamexico.get(i).setReq4(r4);
                listamexico.get(i).setReq5(r5);//listamexico.get(i).setobservacion(nombretextarea.getText)
                listamexico.get(i).setObservaciones(mexico.obv.getText());
            }
        }

    }

}
