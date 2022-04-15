/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso;
import Modelo.Buf_CasoDB;
import Modelo.Buf_CitaDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import vista.V_Caso;
import vista.V_Menu_Inicio;
import vista.V_Requisitos_Divorcio;
import vista.V_Requisitos_PensionesAlimenticias;
import vista.V_Requisitos_Perdon;
import vista.V_Requisitos_Peticion;
import vista.V_Requisitos_RenovacionPasaporte;
import vista.V_Requisitos_ReporteConsular;
import vista.V_Requisitos_RetornanteInmigrante;
import vista.V_Requisitos_Visa_EEUU;
import vista.V_Requisitos_Visa_Europa;
import vista.V_Requisitos_Visa_Loteria;
import vista.V_Requisitos_Visa_Mexico;

/*
 * @author BRYAN_CABRERA
 */
public class C_Caso {

    V_Caso caso;
    V_Menu_Inicio inicio;
    Buf_CasoDB Ca_DB = new Buf_CasoDB();
    Buf_CitaDB C_DB = new Buf_CitaDB();

    public C_Caso(V_Caso caso) {

        this.caso = caso;

    }

    public void Iniciar_Control() {

        //EVENTS KEYS
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == caso.getTxt_cedula()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && caso.getTxt_cedula().getText().length() <= 9) {

                    } else {
                        evt.consume();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    caso.getBtn_buscar().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent evt) {

            }
        };
        caso.getTxt_cedula().addKeyListener(K);

        //ACTION BUTTON
        caso.getBtn_buscar().addActionListener(l -> {
            Buscar();
        });
        caso.getCb_caso().addActionListener(l -> {
            Campo();
            Caso_Requisitos();
        });
    }

    public boolean Buscar_Caso() {

        List<Buf_Caso> List_caso = Ca_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                return true;
            }
        }
        return false;
    }

    public void Campo() {

        if (caso.getTxt_cedula().getText().isEmpty()) {

            caso.getBtn_buscar().setEnabled(false);
        }
        if (!caso.getTxt_cedula().getText().isEmpty()) {

            caso.getBtn_buscar().setEnabled(false);
        }
    }

    public void Buscar() {

        List<Buf_Caso> List_caso = Ca_DB.Getter();

        caso.getCb_caso().removeAllItems();

        if (Buscar_Caso() == true) {

            caso.getCb_caso().addItem("Seleccionar");
            for (int i = 0; i < List_caso.size(); i++) {
                caso.getCb_caso().addItem(List_caso.get(i).getCaso());
            }
        } else {

            JOptionPane.showMessageDialog(null, "No Registra Casos", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void Caso_Requisitos() {

        if (caso.getCb_caso().getSelectedItem().toString().equals("Divorcio")) {
            V_Requisitos_Divorcio rq = new V_Requisitos_Divorcio();
            C_Requisitos_Divorcio divorcio = new C_Requisitos_Divorcio(rq);
            inicio.escritorio.add(rq);
            rq.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    rq.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    rq.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            divorcio.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Pensiones Alimenticias")) {
            V_Requisitos_PensionesAlimenticias ra = new V_Requisitos_PensionesAlimenticias();
            C_Requisitos_PensionesAlimenticias alimenticias = new C_Requisitos_PensionesAlimenticias(ra);
            inicio.escritorio.add(ra);
            ra.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    ra.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    ra.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            alimenticias.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Peticion Familiar")) {
            V_Requisitos_Peticion rp = new V_Requisitos_Peticion();
            C_Requistos_Peticion peticion = new C_Requistos_Peticion(rp);
            inicio.escritorio.add(rp);
            rp.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    rp.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    rp.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            peticion.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Perdon-EEUU")) {
            V_Requisitos_Perdon rp1 = new V_Requisitos_Perdon();
            C_Requisitos_Perdon perdon = new C_Requisitos_Perdon(rp1);
            inicio.escritorio.add(rp1);
            rp1.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    rp1.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    rp1.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            perdon.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Visa EEUU")) {
            V_Requisitos_Visa_EEUU re = new V_Requisitos_Visa_EEUU();
            C_Requisitos_Visa_EEUU reu = new C_Requisitos_Visa_EEUU(re);
            inicio.escritorio.add(re);
            re.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    re.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    re.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            reu.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Visa Europa")) {
            V_Requisitos_Visa_Europa re1 = new V_Requisitos_Visa_Europa();
            C_Requisitos_Visa_Europa re = new C_Requisitos_Visa_Europa(re1);
            inicio.escritorio.add(re1);
            re1.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    re1.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    re1.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            re.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Loteria EEUU")) {
            V_Requisitos_Visa_Loteria rl = new V_Requisitos_Visa_Loteria();
            C_Requisitos_Visa_Loteria loteria = new C_Requisitos_Visa_Loteria(rl);
            inicio.escritorio.add(rl);
            rl.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    rl.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    rl.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            loteria.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Visa Mexico")) {
            V_Requisitos_Visa_Mexico rm = new V_Requisitos_Visa_Mexico();
            C_Requisitos_Visa_Mexico mexico = new C_Requisitos_Visa_Mexico(rm);
            inicio.escritorio.add(rm);
            rm.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    rm.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    rm.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            mexico.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Renovacion Pasaporte Americano")) {
            V_Requisitos_RenovacionPasaporte rrp = new V_Requisitos_RenovacionPasaporte();
            C_Requisitos_RenovacionPasaporte renovacion = new C_Requisitos_RenovacionPasaporte(rrp);
            inicio.escritorio.add(rrp);
            rrp.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    rrp.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    rrp.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            renovacion.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Retornante Inmigrante")) {
            V_Requisitos_RetornanteInmigrante rri = new V_Requisitos_RetornanteInmigrante();
            C_Requisitos_RetornanteInmigrante inmigrante = new C_Requisitos_RetornanteInmigrante(rri);
            inicio.escritorio.add(rri);
            rri.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    rri.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    rri.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            inmigrante.Iniciar_Control();
        } else if (caso.getCb_caso().getSelectedItem().toString().equals("Reporte Consular")) {
            V_Requisitos_ReporteConsular rrc = new V_Requisitos_ReporteConsular();
            C_Requisitos_ReporteConsular consular = new C_Requisitos_ReporteConsular(rrc);
            inicio.escritorio.add(rrc);
            rrc.show();
            List<Buf_Caso> List_caso = Ca_DB.Getter();
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(caso.getTxt_cedula().getText())) {
                    rrc.getTxt_cedula().setText(caso.getTxt_cedula().getText());
                    rrc.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                }
            }
            consular.Iniciar_Control();
        }
    }
}
