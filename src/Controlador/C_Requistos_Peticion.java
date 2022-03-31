/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.PeticionFamiliar;
import vista.MenuInicio;
import vista.Pago;
import vista.RequisitosPeticion;
import static vista.RequisitosPeticion.listapeticion;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requistos_Peticion implements ActionListener {

    String r1, r2, r3, r4, r5, r6, r7, r8, r9, obser;
    RequisitosPeticion peticion;
    public static String ced;
    public static String ca;

    public C_Requistos_Peticion(RequisitosPeticion peticion) {
        this.peticion = peticion;
        this.peticion.btnModificar.addActionListener(this);
        this.peticion.btn_guardar.addActionListener(this);
        this.peticion.btn_pago.addActionListener(this);
        this.peticion.rq1.addActionListener(this);
        this.peticion.rq2.addActionListener(this);
        this.peticion.rq3.addActionListener(this);
        this.peticion.rq4.addActionListener(this);
        this.peticion.rq5.addActionListener(this);
        this.peticion.rq6.addActionListener(this);
        this.peticion.rq7.addActionListener(this);
        this.peticion.rq8.addActionListener(this);
        this.peticion.rq9.addActionListener(this);

        numBeneficiario();
        cargarcheck();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == peticion.btnModificar) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == peticion.btn_guardar) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == peticion.btn_pago) {
            Pago pa = new Pago(ced, ca);
            C_Pago p = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            peticion.setVisible(false);
        }
        if (evt.getSource() == peticion.rq1) {

        }
        if (evt.getSource() == peticion.rq2) {

        }
        if (evt.getSource() == peticion.rq3) {

        }
        if (evt.getSource() == peticion.rq4) {

        }
        if (evt.getSource() == peticion.rq5) {

        }
        if (evt.getSource() == peticion.rq6) {

        }
        if (evt.getSource() == peticion.rq7) {

        }
        if (evt.getSource() == peticion.rq8) {

        }
        if (evt.getSource() == peticion.rq9) {

        }
    }

    public void numBeneficiario() {
        peticion.comboNum.addItem("Seleccionar...");
        peticion.comboNum.addItem("1");
        peticion.comboNum.addItem("2");
        peticion.comboNum.addItem("3");
        peticion.comboNum.addItem("4");
    }

    public void agregar() {

        if (peticion.rq1.isSelected() == true) {
            r1 = peticion.rq1.getText();
        }
        if (peticion.rq2.isSelected() == true) {
            r2 = peticion.rq2.getText();
        }
        if (peticion.rq3.isSelected() == true) {
            r3 = peticion.rq3.getText();
        }
        if (peticion.rq4.isSelected() == true) {
            r4 = peticion.rq4.getText();
        }
        if (peticion.rq5.isSelected() == true) {
            r5 = peticion.rq5.getText();
        }
        if (peticion.rq6.isSelected() == true) {
            r6 = peticion.rq6.getText();
        }
        if (peticion.rq7.isSelected() == true) {
            r7 = peticion.rq7.getText();
        }
        if (peticion.rq8.isSelected() == true) {
            r8 = peticion.rq8.getText();
        }
        if (peticion.rq9.isSelected() == true) {
            r9 = peticion.rq9.getText();
        }
        String cantidad = (String) peticion.comboNum.getSelectedItem();
        obser = peticion.observaciones.getText();
        PeticionFamiliar m = new PeticionFamiliar(ced, r1, r2, r3, r4, r5, r6, r7, r8, r9, cantidad, "", obser);
        listapeticion.add(m);

    }

    public void cargarcheck() {
        for (int i = 0; i < listapeticion.size(); i++) {
            if (listapeticion.get(i).getCedula().equals(ced)) {
                if (listapeticion.get(i).getReq1() == null) {
                } else {
                    if (listapeticion.get(i).getReq1().equals("PASAPORTE")) {
                        peticion.rq1.setSelected(true);
                    }
                }
                if (listapeticion.get(i).getReq2() == null) {
                } else {
                    if (listapeticion.get(i).getReq2().equals("PARTIDA DE NACIMIENTO - PETICIONARIO")) {
                        peticion.rq2.setSelected(true);
                    }
                }
                if (listapeticion.get(i).getReq3() == null) {
                } else {
                    if (listapeticion.get(i).getReq3().equals("PARTIDA DE NACIMIENTO - BENEFICIARIO")) {
                        peticion.rq3.setSelected(true);
                    }
                }
                if (listapeticion.get(i).getReq4() == null) {
                } else {
                    if (listapeticion.get(i).getReq4().equals("PARTIDAS DE MATRIMONIO")) {
                        peticion.rq4.setSelected(true);
                    }
                }
                if (listapeticion.get(i).getReq5() == null) {
                } else {
                    if (listapeticion.get(i).getReq5().equals("FOTOS 5 x 5 - PETICIONARIO")) {
                        peticion.rq5.setSelected(true);
                    }
                }
                if (listapeticion.get(i).getReq6() == null) {
                } else {
                    if (listapeticion.get(i).getReq6().equals("CERTIFICADO DE TRABAJO")) {
                        peticion.rq6.setSelected(true);
                    }
                }
                if (listapeticion.get(i).getReq7() == null) {
                } else {
                    if (listapeticion.get(i).getReq7().equals("FOTOS 5 x 5 - BENEFICIARIO")) {
                        peticion.rq7.setSelected(true);
                    }
                }
                if (listapeticion.get(i).getReq8() == null) {
                } else {
                    if (listapeticion.get(i).getReq8().equals("SENTENCIA DE DIVORCIO")) {
                        peticion.rq8.setSelected(true);
                    }
                }
                if (listapeticion.get(i).getReq9() == null) {
                } else {
                    if (listapeticion.get(i).getReq9().equals("ACTA DE NATURALIZACION")) {
                        peticion.rq9.setSelected(true);
                    }
                }
                peticion.comboNum.removeAllItems();
                peticion.comboNum.addItem(listapeticion.get(i).getNum());

                obser = listapeticion.get(i).getObservaciones();
                peticion.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        String cantidad = (String) peticion.comboNum.getSelectedItem();
        peticion.observaciones.setEditable(true);
        if (peticion.rq1.isSelected() == true) {
            r1 = peticion.rq1.getText();
        }
        if (peticion.rq2.isSelected() == true) {
            r2 = peticion.rq2.getText();
        }
        if (peticion.rq3.isSelected() == true) {
            r3 = peticion.rq3.getText();
        }
        if (peticion.rq4.isSelected() == true) {
            r4 = peticion.rq4.getText();
        }
        if (peticion.rq5.isSelected() == true) {
            r5 = peticion.rq5.getText();
        }
        if (peticion.rq6.isSelected() == true) {
            r6 = peticion.rq6.getText();
        }
        if (peticion.rq7.isSelected() == true) {
            r7 = peticion.rq7.getText();
        }
        if (peticion.rq8.isSelected() == true) {
            r8 = peticion.rq8.getText();
        }
        if (peticion.rq9.isSelected() == true) {
            r9 = peticion.rq9.getText();
        }
        for (int i = 0; i < listapeticion.size(); i++) {
            if (listapeticion.get(i).getCedula().equals(ced)) {
                listapeticion.get(i).setReq1(r1);
                listapeticion.get(i).setReq2(r2);
                listapeticion.get(i).setReq3(r3);
                listapeticion.get(i).setReq4(r4);
                listapeticion.get(i).setReq5(r5);
                listapeticion.get(i).setReq6(r6);
                listapeticion.get(i).setReq7(r7);
                listapeticion.get(i).setReq8(r8);
                listapeticion.get(i).setReq9(r9);
                listapeticion.get(i).setObservaciones(peticion.observaciones.getText());
            }
        }

    }

}
