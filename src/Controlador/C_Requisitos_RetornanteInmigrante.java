/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.RetornanteInmigrante;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosRetornanteInmigrante;
import static vista.RequisitosRetornanteInmigrante.listaretornante;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_RetornanteInmigrante implements ActionListener {

    RequisitosRetornanteInmigrante inmigrante;
    public static String ced;
    public static String ca;
    String r1, r2, r3, r4, r5, r6, obser;

    public C_Requisitos_RetornanteInmigrante(RequisitosRetornanteInmigrante inmigrante) {
        this.inmigrante = inmigrante;
        this.inmigrante.btnGuardar.addActionListener(this);
        this.inmigrante.btnModificar.addActionListener(this);
        this.inmigrante.btn_pago.addActionListener(this);
        this.inmigrante.rq1.addActionListener(this);
        this.inmigrante.rq2.addActionListener(this);
        this.inmigrante.rq3.addActionListener(this);
        this.inmigrante.rq4.addActionListener(this);
        this.inmigrante.rq5.addActionListener(this);
        this.inmigrante.rq6.addActionListener(this);

        numBeneficiario();
        cargarcheck();

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == inmigrante.btnGuardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == inmigrante.btnModificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == inmigrante.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            inmigrante.setVisible(false);
        }
        if (evt.getSource() == inmigrante.rq1) {

        }
        if (evt.getSource() == inmigrante.rq2) {

        }
        if (evt.getSource() == inmigrante.rq3) {

        }
        if (evt.getSource() == inmigrante.rq4) {

        }
        if (evt.getSource() == inmigrante.rq5) {

        }
        if (evt.getSource() == inmigrante.rq6) {

        }
    }

    public void numBeneficiario() {
        inmigrante.comboNum.addItem("Seleccionar...");
        inmigrante.comboNum.addItem("1");
        inmigrante.comboNum.addItem("2");
        inmigrante.comboNum.addItem("3");
        inmigrante.comboNum.addItem("4");
    }

    public void agregar() {

        if (inmigrante.rq1.isSelected() == true) {
            r1 = inmigrante.rq1.getText();
        }
        if (inmigrante.rq2.isSelected() == true) {
            r2 = inmigrante.rq2.getText();
        }
        if (inmigrante.rq3.isSelected() == true) {
            r3 = inmigrante.rq3.getText();
        }
        if (inmigrante.rq4.isSelected() == true) {
            r4 = inmigrante.rq4.getText();
        }
        if (inmigrante.rq5.isSelected() == true) {
            r5 = inmigrante.rq5.getText();
        }
        if (inmigrante.rq6.isSelected() == true) {
            r6 = inmigrante.rq6.getText();
        }
        String cantidad = (String) inmigrante.comboNum.getSelectedItem();
        obser = inmigrante.observaciones.getText();
        RetornanteInmigrante m = new RetornanteInmigrante(ced, r1, r2, r3, r4, r5, r6, cantidad, "", obser);
        listaretornante.add(m);

    }

    public void cargarcheck() {
        for (int i = 0; i < listaretornante.size(); i++) {
            if (listaretornante.get(i).getCedula().equals(ced)) {
                if (listaretornante.get(i).getRq1() == null) {
                } else {
                    if (listaretornante.get(i).getRq1().equals("DS - 117")) {
                        inmigrante.rq1.setSelected(true);
                    }
                }
                if (listaretornante.get(i).getRq2() == null) {
                } else {
                    if (listaretornante.get(i).getRq2().equals("ACTA DE NATURALIZACION")) {
                        inmigrante.rq2.setSelected(true);
                    }
                }
                if (listaretornante.get(i).getRq3() == null) {
                } else {
                    if (listaretornante.get(i).getRq3().equals("SOCIAL SECURITY")) {
                        inmigrante.rq3.setSelected(true);
                    }
                }
                if (listaretornante.get(i).getRq4() == null) {
                } else {
                    if (listaretornante.get(i).getRq4().equals("TAXES ")) {
                        inmigrante.rq4.setSelected(true);
                    }
                }
                if (listaretornante.get(i).getRq5() == null) {
                } else {
                    if (listaretornante.get(i).getRq5().equals("PRUEBAS QUE DEMUESTREN POR QUE ESTUVO FUERA DE LOS ESTADOS UNIDOS ")) {
                        inmigrante.rq5.setSelected(true);
                    }
                }
                if (listaretornante.get(i).getRq6() == null) {
                } else {
                    if (listaretornante.get(i).getRq6().equals("EVIDENCIA DE VINCULO CON LOS EEUU")) {
                        inmigrante.rq6.setSelected(true);
                    }
                }
                inmigrante.comboNum.removeAllItems();
                inmigrante.comboNum.addItem(listaretornante.get(i).getNumpersona());

                obser = listaretornante.get(i).getObservaciones();
                inmigrante.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        String cantidad = (String) inmigrante.comboNum.getSelectedItem();
        inmigrante.observaciones.setEditable(true);
        if (inmigrante.rq1.isSelected() == true) {
            r1 = inmigrante.rq1.getText();
        }
        if (inmigrante.rq2.isSelected() == true) {
            r2 = inmigrante.rq2.getText();
        }
        if (inmigrante.rq3.isSelected() == true) {
            r3 = inmigrante.rq3.getText();
        }
        if (inmigrante.rq4.isSelected() == true) {
            r4 = inmigrante.rq4.getText();
        }
        if (inmigrante.rq5.isSelected() == true) {
            r5 = inmigrante.rq5.getText();
        }
        if (inmigrante.rq6.isSelected() == true) {
            r6 = inmigrante.rq6.getText();
        }
        for (int i = 0; i < listaretornante.size(); i++) {
            if (listaretornante.get(i).getCedula().equals(ced)) {
                listaretornante.get(i).setRq1(r1);
                listaretornante.get(i).setRq2(r2);
                listaretornante.get(i).setRq3(r3);
                listaretornante.get(i).setRq4(r4);
                listaretornante.get(i).setRq5(r5);
                listaretornante.get(i).setRq6(r6);
                listaretornante.get(i).setObservaciones(inmigrante.observaciones.getText());
            }
        }

    }
}
