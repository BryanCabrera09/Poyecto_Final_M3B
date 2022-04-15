/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso;
import Modelo.Buf_CasoDB;
import Modelo.Buf_Cliente;
import Modelo.Buf_ClienteDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import vista.V_Registro_Caso;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Caso {

    V_Registro_Caso registro;

    Buf_Caso Ca = new Buf_Caso();
    Buf_CasoDB Ca_DB = new Buf_CasoDB();
    Buf_ClienteDB C_DB = new Buf_ClienteDB();

    public C_Registro_Caso(V_Registro_Caso registro) {

        this.registro = registro;

        Num_Casos();
    }

    public void Num_Casos() {

        registro.getCb_caso().addItem("Seleccionar");
        registro.getCb_caso().addItem("Divorcio");
        registro.getCb_caso().addItem("Pensiones Alimenticias");
        registro.getCb_caso().addItem("Peticion Familiar");
        registro.getCb_caso().addItem("Perdon-EEUU");
        registro.getCb_caso().addItem("Visa EEUU");
        registro.getCb_caso().addItem("Visa Europa");
        registro.getCb_caso().addItem("Loteria EEUU");
        registro.getCb_caso().addItem("Visa Mexico");
        registro.getCb_caso().addItem("Renovacion Pasaporte Americano");
        registro.getCb_caso().addItem("Retornante Inmigrante");
        registro.getCb_caso().addItem("Reporte Consular");
    }

    public void Iniciar_Control() {

        //EVENTOS TECLADO
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == registro.getTxt_cedula()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && registro.getTxt_cedula().getText().length() <= 9) {

                    } else {
                        evt.consume();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                 if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    registro.getBtn_guardar().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent evt) {
            }
        };
        registro.getTxt_cedula().addKeyListener(K);

        //ACTION BUTTONS
        registro.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
    }

    public boolean Validar_Datos() {

        String caso = (String) registro.getCb_caso().getSelectedItem();

        if (!registro.getTxt_cedula().getText().equals("") && !caso.equals("Seleccionar")) {
            return true;
        } else {
            return false;
        }
    }

    public int Id_Generator() {

        List<Buf_Caso> List_caso = Ca_DB.Getter();

        int id_caso = (int) Math.floor(Math.random() * (99999 - 11111 + 1) + 11111);

        int a = 0;
        do {

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getId_caso() == id_caso) {
                    a = 1;
                }
            }

        } while (a == 1);

        return id_caso;
    }

    public void Guardar() {

        if (Validar_Datos() == true) {
            if (Cedula_Cliente() == true) {
                if (Cedula_Repetida() == true) {
                    Subir_Datos();
                } else {
                    JOptionPane.showMessageDialog(null, "Caso Registrado Previamente", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente No Registrado", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar Todos Los Datos", "ERROR!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void Subir_Datos() {

        String caso = (String) registro.getCb_caso().getSelectedItem();

        Ca.setCedula(registro.getTxt_cedula().getText());
        Ca.setId_caso(Id_Generator());
        Ca.setCaso(caso);

        if (Ca_DB.Register(Ca)) {

            JOptionPane.showMessageDialog(null, "Caso " + caso + " Registrado");
            registro.getCb_caso().setSelectedIndex(0);
            registro.getTxt_cedula().setText("");
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean Cedula_Cliente() {

        List<Buf_Cliente> List_cliente = C_DB.Getter();

        for (int i = 0; i < List_cliente.size(); i++) {
            if (List_cliente.get(i).getCedula().equals(registro.getTxt_cedula().getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean Cedula_Repetida() {

        String caso = (String) registro.getCb_caso().getSelectedItem();

        List<Buf_Caso> List_caso = Ca_DB.Getter();

        for (int j = 0; j < List_caso.size(); j++) {
            if (List_caso.get(j).getCaso().equals(caso)) {
                return false;
            }
        }
        return true;
    }
}
