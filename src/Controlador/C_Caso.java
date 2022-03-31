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
import vista.V_Caso;
import vista.V_Menu_Inicio;
import static vista.V_Registro_Caso.Lista_ClienteCaso;
import vista.RequisitoDivorcio;
import vista.RequisitosEstadosUnidos;
import vista.RequisitosEuropa;
import vista.RequisitosLoteria;
import vista.RequisitosPensionesAlimenticias;
import vista.RequisitosPerdon;
import vista.RequisitosPeticion;
import vista.RequisitosRenovacionPasaporte;
import vista.RequisitosReporteConsular;
import vista.RequisitosRetornanteInmigrante;
import vista.RequisitosVisaMexico;

/*
 * @author BRYAN_CABRERA
 */
public class C_Caso implements ActionListener, KeyListener {

    Caso caso;

    public C_Caso(Caso caso) {
        this.caso = caso;
        this.caso.btn_buscar.addActionListener(this);
        this.caso.comboCaso.addActionListener(this);
        this.caso.txtCedula.addKeyListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == caso.btn_buscar) {
            System.out.println(caso.comboCaso.getItemCount() + "dddd");
            caso.comboCaso.removeAllItems();
//        for (int i = 0; i < comboCaso.getItemCount(); i++) {
//            comboCaso.removeItemAt(i);
//        }
//        for (int i = comboCaso.getItemCount() - 1; i >= 0; i--) {
//            comboCaso.removeItemAt(i);
//        }
//        if (comboCaso.getItemCount() > 0) {
//            comboCaso.removeAllItems();
//            comboCaso.removeActionListener(comboCaso);
//            
//        }
            int a = 0;
            int p = 0;
            int b = 0;
            for (int i = 0; i < Lista_ClienteCaso.size(); i++) {
                if (Lista_ClienteCaso.get(i).getCedula().equals(caso.txtCedula.getText())) {
                    caso.comboCaso.addItem(Lista_ClienteCaso.get(i).getCaso());
                    p = 1;
                    b = 1;
                } else {
                    a = 1;
                }
            }
            if (a == 1 && p == 0) {
                JOptionPane.showMessageDialog(null, "ESTA CEDULA NO EXISTE EN EL REGISTRO", "", 3);
            }

//        if (b == 1) {
//            combo();
//        }
        }
        if (evt.getSource() == caso.comboCaso) {
            caso.btn_buscar.setEnabled(false);
            System.out.println(caso.comboCaso.getSelectedItem().toString());
            caso.comboCaso.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (caso.comboCaso.getSelectedItem().toString().equals("Divorcio")) {
                        RequisitoDivorcio rq = new RequisitoDivorcio(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_Divorcio divorcio = new C_Requisitos_Divorcio(rq);
                        MenuInicio.escritorio.add(rq);
                        rq.toFront();
                        rq.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Pensiones Alimenticias")) {
                        RequisitosPensionesAlimenticias ra = new RequisitosPensionesAlimenticias(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_PensionesAlimenticias alimenticias = new C_Requisitos_PensionesAlimenticias(ra);
                        MenuInicio.escritorio.add(ra);
                        ra.toFront();
                        ra.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Peticion Familiar")) {
                        RequisitosPeticion rp = new RequisitosPeticion(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requistos_Peticion peticion = new C_Requistos_Peticion(rp);
                        MenuInicio.escritorio.add(rp);
                        rp.toFront();
                        rp.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Perdon-EEUU")) {
                        RequisitosPerdon rp1 = new RequisitosPerdon(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_Perdon perdon = new C_Requisitos_Perdon(rp1);
                        MenuInicio.escritorio.add(rp1);
                        rp1.toFront();
                        rp1.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Visa EEUU")) {
                        RequisitosEstadosUnidos re = new RequisitosEstadosUnidos(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_Visa_EEUU reu = new C_Requisitos_Visa_EEUU(re);
                        MenuInicio.escritorio.add(re);
                        re.toFront();
                        re.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Visa Europa")) {
                        RequisitosEuropa re1 = new RequisitosEuropa(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_Visa_Europa re = new C_Requisitos_Visa_Europa(re1);
                        MenuInicio.escritorio.add(re1);
                        re1.toFront();
                        re1.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Loteria EEUU")) {
                        RequisitosLoteria rl = new RequisitosLoteria(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_Visa_Loteria loteria = new C_Requisitos_Visa_Loteria(rl);
                        MenuInicio.escritorio.add(rl);
                        rl.toFront();
                        rl.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Visa Mexico")) {
                        //RequisitosVisaMexico rm = new RequisitosVisaMexico();
                        RequisitosVisaMexico rm = new RequisitosVisaMexico(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_Visa_Mexico mexico =new C_Requisitos_Visa_Mexico(rm);
                        MenuInicio.escritorio.add(rm);
                        rm.toFront();
                        rm.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Renovacion Pasaporte Americano")) {
                        RequisitosRenovacionPasaporte rrp = new RequisitosRenovacionPasaporte(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_RenovacionPasaporte renovacion = new C_Requisitos_RenovacionPasaporte(rrp);
                        MenuInicio.escritorio.add(rrp);
                        rrp.toFront();
                        rrp.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Retornante Inmigrante")) {
                        RequisitosRetornanteInmigrante rri = new RequisitosRetornanteInmigrante(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_RetornanteInmigrante inmigrante = new C_Requisitos_RetornanteInmigrante(rri);
                        MenuInicio.escritorio.add(rri);
                        rri.toFront();
                        rri.setVisible(true);
                        Cerrar();
                    } else if (caso.comboCaso.getSelectedItem().toString().equals("Reporte Consular")) {
                        RequisitosReporteConsular rrc = new RequisitosReporteConsular(caso.txtCedula.getText(), caso.comboCaso.getSelectedItem().toString());
                        C_Requisitos_ReporteConsular consular = new C_Requisitos_ReporteConsular(rrc);
                        MenuInicio.escritorio.add(rrc);
                        rrc.toFront();
                        rrc.setVisible(true);
                        Cerrar();
                    }
                }

            });
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == caso.txtCedula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && caso.txtCedula.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent evt) {

    }

    @Override
    public void keyReleased(KeyEvent evt) {

    }

    public void Cerrar() {
        caso.dispose();
    }

    
}
