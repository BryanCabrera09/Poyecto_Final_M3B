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
import modelo.ClienteCaso;
import vista.RegistroCaso;
import static vista.RegistroCaso.Lista_ClienteCaso;
import static vista.RegistroCliente.Lista_cliente;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Caso implements ActionListener, KeyListener {

    RegistroCaso registroCaso;

    public C_Registro_Caso(RegistroCaso registroCaso) {
        this.registroCaso = registroCaso;
        this.registroCaso.btn_guardar.addActionListener(this);
        this.registroCaso.txt_cedula.addKeyListener(this);
        numCaso();
    }

    public void numCaso() {
        registroCaso.comboCaso.addItem("Seleccionar...");
        registroCaso.comboCaso.addItem("Divorcio");
        registroCaso.comboCaso.addItem("Pensiones Alimenticias");
        registroCaso.comboCaso.addItem("Peticion Familiar");
        registroCaso.comboCaso.addItem("Perdon-EEUU");
        registroCaso.comboCaso.addItem("Visa EEUU");
        registroCaso.comboCaso.addItem("Visa Europa");
        registroCaso.comboCaso.addItem("Loteria EEUU");
        registroCaso.comboCaso.addItem("Visa Mexico");
        registroCaso.comboCaso.addItem("Renovacion Pasaporte Americano");
        registroCaso.comboCaso.addItem("Retornante Inmigrante");
        registroCaso.comboCaso.addItem("Reporte Consular");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == registroCaso.btn_guardar) {

//        for (int i = 0; i < Lista_cliente.size(); i++) {
//            System.out.println(Lista_cliente.get(i).getCedula());
//        }
            String caso = (String) registroCaso.comboCaso.getSelectedItem();
            int c = 0;
            if (!caso.equals("Seleccionar...")) {
                for (int i = 0; i < Lista_cliente.size(); i++) {
                    if (Lista_cliente.get(i).getCedula().equals(registroCaso.txt_cedula.getText())) {
                        if (Lista_ClienteCaso.isEmpty()) {
                            ClienteCaso cc = new ClienteCaso(registroCaso.txt_cedula.getText(), caso);
                            Lista_ClienteCaso.add(cc);
                            JOptionPane.showMessageDialog(null, "Registrado " + caso);
                            registroCaso.comboCaso.setSelectedIndex(0);
                            registroCaso.txt_cedula.setText("");
                        } else {
                            c = 1;
                        }

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llene Todos los campos");
            }
            int p = 0;

            if (c == 1) {

                for (int j = 0; j < Lista_ClienteCaso.size(); j++) {
                    p = 0;
                    caso = (String) registroCaso.comboCaso.getSelectedItem();
                    if (Lista_ClienteCaso.get(j).getCedula().equals(registroCaso.txt_cedula.getText()) && Lista_ClienteCaso.get(j).getCaso().equals(caso)) {
                        JOptionPane.showMessageDialog(null, "Esta cedula ya tiene este caso", "", 0);
                        break;
                    } else {
                        p = 1;
                    }
                }
            }

            if (p == 1) {
                ClienteCaso cc = new ClienteCaso(registroCaso.txt_cedula.getText(), caso);
                Lista_ClienteCaso.add(cc);
                JOptionPane.showMessageDialog(null, "Registrado " + caso);
                registroCaso.comboCaso.setSelectedIndex(0);
                registroCaso.txt_cedula.setText("");
            }

            /*
        
        String caso = (String) comboCaso.getSelectedItem();
        int a = 0, b = 0;
        for (int i = 0; i < Lista_cliente.size(); i++) {

            if (Lista_cliente.get(i).getCedula().equals(txt_cedula.getText())) {
                ClienteCaso cc = new ClienteCaso(txt_cedula.getText(), caso);
                for (int j = 0; j < Lista_ClienteCaso.size(); j++) {
                    System.out.println("------------");
                    System.out.println(caso);
                    System.out.println("------------");
                    if (Lista_ClienteCaso.get(j).getCaso().equals(caso)) {
                        b = 1;
                        System.out.println("rrrrrrrrrrrrr");
                        break;
                    } else if (!Lista_ClienteCaso.get(j).getCaso().equalsIgnoreCase(caso)) {
                        Lista_ClienteCaso.add(cc);
                        break;
                    }
                }

                if (Lista_ClienteCaso.size() == 0) {
                    Lista_ClienteCaso.add(cc);

                }
                Limpiar();
                break;
            } else {
                a = 1;
                Limpiar();
                break;
            }
        }
        if (a == 1) {
            JOptionPane.showMessageDialog(null, "ESTA CEDULA NO EXISTE EN EL REGISTRO", "", 3);
        }
        if (b == 1) {
            JOptionPane.showMessageDialog(null, "ESTA CEDULA YA REGISTRO ESTE CASO", "", 3);
        }*/
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == registroCaso.txt_cedula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && registroCaso.txt_cedula.getText().length() <= 9) {

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

}
