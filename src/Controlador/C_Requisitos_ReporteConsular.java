/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ReporteConsular;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosReporteConsular;
import static vista.RequisitosReporteConsular.listaconsular;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_ReporteConsular implements ActionListener {

    RequisitosReporteConsular consular;
    public static String ced;
    public static String ca;
    String r1, r2, r3, r4, r5, r6, r7, r8, obser;

    public C_Requisitos_ReporteConsular(RequisitosReporteConsular consular) {
        this.consular = consular;
        this.consular.btn_pago.addActionListener(this);
        this.consular.btnguardar.addActionListener(this);
        this.consular.btnmodificar.addActionListener(this);
        this.consular.rq1.addActionListener(this);
        this.consular.rq2.addActionListener(this);
        this.consular.rq3.addActionListener(this);
        this.consular.rq4.addActionListener(this);
        this.consular.rq5.addActionListener(this);
        this.consular.rq6.addActionListener(this);
        this.consular.rq7.addActionListener(this);
        this.consular.rq8.addActionListener(this);

        numBeneficiario();
        cargarcheck();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == consular.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            consular.setVisible(false);
        }
        if (evt.getSource() == consular.btnguardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == consular.btnmodificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == consular.rq1) {

        }
        if (evt.getSource() == consular.rq2) {

        }
        if (evt.getSource() == consular.rq3) {

        }
        if (evt.getSource() == consular.rq3) {

        }
        if (evt.getSource() == consular.rq5) {

        }
        if (evt.getSource() == consular.rq6) {

        }
        if (evt.getSource() == consular.rq7) {

        }
        if (evt.getSource() == consular.rq8) {

        }
    }

    public void numBeneficiario() {
        consular.comboNum.addItem("Seleccionar...");
        consular.comboNum.addItem("1");
        consular.comboNum.addItem("2");
        consular.comboNum.addItem("3");
        consular.comboNum.addItem("4");
    }

    public void agregar() {

        if (consular.rq1.isSelected() == true) {
            r1 = consular.rq1.getText();
        }
        if (consular.rq2.isSelected() == true) {
            r2 = consular.rq2.getText();
        }
        if (consular.rq3.isSelected() == true) {
            r3 = consular.rq3.getText();
        }
        if (consular.rq4.isSelected() == true) {
            r4 = consular.rq4.getText();
        }
        if (consular.rq5.isSelected() == true) {
            r5 = consular.rq5.getText();
        }
        if (consular.rq6.isSelected() == true) {
            r6 = consular.rq6.getText();
        }
        if (consular.rq7.isSelected() == true) {
            r7 = consular.rq7.getText();
        }
        if (consular.rq8.isSelected() == true) {
            r8 = consular.rq8.getText();
        }

        String cantidad = (String) consular.comboNum.getSelectedItem();
        if (cantidad.equals("Seleccionar...")) {

        } else {
            obser = consular.observaciones.getText();
            System.out.println(r1 + r2 + obser);
            ReporteConsular m = new ReporteConsular(ced, r1, r2, r3, r4, r5, r6, r7, r8, cantidad, "250", obser);
            listaconsular.add(m);
        }

    }

    public void cargarcheck() {
        for (int i = 0; i < listaconsular.size(); i++) {
            if (listaconsular.get(i).getCedula().equals(ced)) {
                if (listaconsular.get(i).getRq1() == null) {
                } else {
                    if (listaconsular.get(i).getRq1().equals("DS-2029")) {
                        consular.rq1.setSelected(true);
                    }
                }
                if (listaconsular.get(i).getRq2() == null) {
                } else {
                    if (listaconsular.get(i).getRq2().equals("DS- 11")) {
                        consular.rq2.setSelected(true);
                    }
                }
                if (listaconsular.get(i).getRq3() == null) {
                } else {
                    if (listaconsular.get(i).getRq3().equals("PRUEBA DE CIUDADANIA")) {
                        consular.rq3.setSelected(true);
                    }
                }
                if (listaconsular.get(i).getRq4() == null) {
                } else {
                    if (listaconsular.get(i).getRq4().equals("CERTIFICADO NATURALIZACION")) {
                        consular.rq4.setSelected(true);
                    }
                }
                if (listaconsular.get(i).getRq5() == null) {
                } else {
                    if (listaconsular.get(i).getRq5().equals("INSCRIPCION DE NACIMIENTO")) {
                        consular.rq5.setSelected(true);
                    }
                }
                if (listaconsular.get(i).getRq6() == null) {
                } else {
                    if (listaconsular.get(i).getRq6().equals("DIRECCION EN LOS EEUU")) {
                        consular.rq6.setSelected(true);
                    }
                }
                if (listaconsular.get(i).getRq7() == null) {
                } else {
                    if (listaconsular.get(i).getRq7().equals("RECORD MEDICOS")) {
                        consular.rq7.setSelected(true);
                    }
                }
                if (listaconsular.get(i).getRq8() == null) {
                } else {
                    if (listaconsular.get(i).getRq8().equals("REGISTRO DE VACUNAS")) {
                        consular.rq8.setSelected(true);
                    }
                }

                consular.comboNum.removeAllItems();
                consular.comboNum.addItem(listaconsular.get(i).getNumpersona());

                obser = listaconsular.get(i).getObservaciones();
                consular.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        String cantidad = (String) consular.comboNum.getSelectedItem();
        consular.observaciones.setEditable(true);
        if (consular.rq1.isSelected() == true) {
            r1 = consular.rq1.getText();
        }
        if (consular.rq2.isSelected() == true) {
            r2 = consular.rq2.getText();
        }
        if (consular.rq3.isSelected() == true) {
            r3 = consular.rq3.getText();
        }
        if (consular.rq4.isSelected() == true) {
            r4 = consular.rq4.getText();
        }
        if (consular.rq5.isSelected() == true) {
            r5 = consular.rq5.getText();
        }
        if (consular.rq6.isSelected() == true) {
            r6 = consular.rq6.getText();
        }
        if (consular.rq7.isSelected() == true) {
            r7 = consular.rq7.getText();
        }
        if (consular.rq8.isSelected() == true) {
            r8 = consular.rq8.getText();
        }

        for (int i = 0; i < listaconsular.size(); i++) {
            if (listaconsular.get(i).getCedula().equals(ced)) {
                listaconsular.get(i).setRq1(r1);
                listaconsular.get(i).setRq2(r2);
                listaconsular.get(i).setRq3(r3);
                listaconsular.get(i).setRq4(r4);
                listaconsular.get(i).setRq5(r5);
                listaconsular.get(i).setRq6(r6);
                listaconsular.get(i).setRq7(r7);
                listaconsular.get(i).setRq8(r8);
                listaconsular.get(i).setObservaciones(consular.observaciones.getText());
            }
        }
    }
}
