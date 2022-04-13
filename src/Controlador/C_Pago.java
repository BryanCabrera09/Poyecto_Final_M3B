/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Cita;
import Modelo.Buf_CitaDB;
import Modelo.Buf_Pagos;
import Modelo.Buf_PagosDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.V_Pago;

/*
 * @author BRYAN_CABRERA
 */
public class C_Pago {

    DefaultTableModel modelo;
    V_Pago pago;

    Buf_Cita C = new Buf_Cita();
    Buf_CitaDB C_DB = new Buf_CitaDB();
    Buf_Pagos P = new Buf_Pagos();
    Buf_PagosDB P_DB = new Buf_PagosDB();

    public C_Pago(V_Pago pago) {

        this.pago = pago;

        Cargar_Datos();
        Nuevo();
        Campos();
    }

    public void Iniciar_Control() {

        //EVENTS KEY
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == pago.getTxt_abona()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && pago.getTxt_abona().getText().length() <= 9) {

                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == pago.getTxt_valorInicial()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && pago.getTxt_valorInicial().getText().length() <= 9) {

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
        };
        pago.getTxt_valorInicial().addKeyListener(K);
        pago.getTxt_abona().addKeyListener(K);

        //ACTION BUTTON
        pago.getBtn_abono().addActionListener(l -> {
            Abono();
        });
        pago.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
        pago.getBtn_cargar().addActionListener(l -> {
            Actualizar_Tabla();
            Nuevo();
        });
    }

    public void Cargar_Datos() {

        pago.getTable_pago().getTableHeader().setResizingAllowed(false);
        pago.getTable_pago().getTableHeader().setReorderingAllowed(false);

        pago.getTable_pago().setDefaultEditor(Object.class, null);
        modelo = new DefaultTableModel() {
            public boolean isceleditable(int fila, int columnas) {
                if (columnas == 3) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        modelo.addColumn("FECHA");
        modelo.addColumn("ABONO");
        modelo.addColumn("SALDO");

    }

    public void Actualizar_Tabla() {

        List<Buf_Cita> List_cita = C_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();

        if (!List_pago.isEmpty()) {
            for (int i = 0; i < List_cita.size(); i++) {
                if (List_cita.get(i).getCedula().equals(pago.getTxt_cedula().getText()) && List_cita.get(i).getId_caso() == Integer.parseInt(pago.getTxt_id().getText())) {
                    for (int j = 0; j < List_pago.size(); j++) {
                        if (List_pago.get(j).getCedula().equals(pago.getTxt_cedula().getText()) && List_pago.get(j).getId_caso() == Integer.parseInt(pago.getTxt_id().getText())) {
                            Object[] fila = new Object[3];
                            fila[0] = List_pago.get(j).getFecha_Pago();
                            fila[1] = List_pago.get(j).getAbono();
                            fila[2] = List_pago.get(j).getSaldo();
                            modelo.addRow(fila);
                        }
                    }
                }
            }
            pago.getTable_pago().setModel(modelo);
        }
    }
    
    public void Actualizar_Pagar(){
        
        List<Buf_Pagos> List_pago = P_DB.Getter();
        
        for (int i = 0; i < List_pago.size(); i++) {
            if (List_pago.get(i).getCedula().equals(pago.getTxt_cedula().getText()) && List_pago.get(i).getId_caso() == Integer.parseInt(pago.getTxt_id().getText())) {
                pago.getTxt_a_pagar().setText(String.valueOf(List_pago.get(i).getSaldo()));
            }
        }
    }

    public void Limpiar_Tabla() {
        modelo.setNumRows(0);
        pago.getTxt_abona().setText("");
        pago.getCalendar().setCalendar(null);
    }

    public void Campos() {

        pago.getBtn_guardar().setEnabled(false);
        pago.getCalendar().setEnabled(false);
        pago.getTxt_a_pagar().setEditable(false);
        pago.getTxt_valorInicial().setEditable(false);
    }

    public void Nuevo() {

        pago.getTxt_abona().setEditable(false);
        pago.getCalendar().setCalendar(null);
        pago.getCalendar().setEnabled(true);
        pago.getTxt_abona().setEditable(false);
        pago.getTxt_valorInicial().setEditable(true);
        pago.getBtn_guardar().setEnabled(true);
        pago.getBtn_abono().setEnabled(false);
        pago.getTxt_cedula().setEditable(false);
        pago.getTxt_id().setEditable(false);

        List<Buf_Pagos> List_pago = P_DB.Getter();

        for (int i = 0; i < List_pago.size(); i++) {
            if (List_pago.get(i).getCedula().equals(pago.getTxt_cedula().getText()) && List_pago.get(i).getId_caso() == Integer.parseInt(pago.getTxt_id().getText())) {
                pago.getTxt_valorInicial().setEditable(false);
                pago.getTxt_abona().setEditable(true);
                pago.getBtn_guardar().setEnabled(false);
                pago.getBtn_abono().setEnabled(true);
                pago.getBtn_cargar().setEnabled(false);
                Actualizar_Pagar();
            }
        }
    }

    public void Abono() {

        pago.getBtn_guardar().setEnabled(true);
        pago.getTxt_abona().setEditable(true);
        pago.getCalendar().setEnabled(true);
    }

    public int Id_Generator() {

        List<Buf_Pagos> List_pago = P_DB.Getter();

        int id_pago = (int) Math.floor(Math.random() * (9999999 - 1111111 + 1) + 1111111);

        int a = 0;
        do {

            for (int i = 0; i < List_pago.size(); i++) {
                if (List_pago.get(i).getId_pago() == id_pago) {
                    a = 1;
                }
            }
        } while (a == 1);

        return id_pago;
    }

    public void Guardar() {

        List<Buf_Pagos> List_pago = P_DB.Getter();

        if (List_pago.isEmpty()) {

            Subir_Datos();
            Limpiar_Tabla();
            Actualizar_Tabla();
            Nuevo();
            Actualizar_Pagar();
            pago.getBtn_guardar().setEnabled(false);
        } else {

            Subir_Datos();
            Limpiar_Tabla();
            Actualizar_Tabla();
            Nuevo();
            Actualizar_Pagar();
            pago.getBtn_guardar().setEnabled(false);
        }
    }

    public void Subir_Datos() {

        List<Buf_Pagos> List_pago = P_DB.Getter();

        if (List_pago.isEmpty()) {

            double cantidad = Double.parseDouble(pago.getTxt_valorInicial().getText());
            double saldo = Double.parseDouble(pago.getTxt_a_pagar().getText()) - cantidad;

            String fechas = "";

            if (!(pago.getCalendar().getDate() == null)) {
                Date fecha = pago.getCalendar().getDate();
                DateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");
                fechas = Formato.format(fecha);
            }

            P.setId_pago(Id_Generator());
            P.setId_caso(Integer.parseInt(pago.getTxt_id().getText()));
            P.setCedula(pago.getTxt_cedula().getText());
            P.setFecha_Pago(fechas);
            P.setAbono(cantidad);
            P.setSaldo(saldo);
            if (P_DB.Register(P)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error Al Guardar Los Datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            double abona = 0;
            double saldo = 0;

            if (!pago.getTxt_abona().getText().isEmpty()) {
                abona = Double.parseDouble(pago.getTxt_abona().getText());
                saldo = Double.parseDouble(pago.getTxt_a_pagar().getText()) - Double.parseDouble(pago.getTxt_abona().getText());
            } else if (pago.getTxt_abona().getText().isEmpty()) {
                abona = 0;
                saldo = Double.parseDouble(pago.getTxt_a_pagar().getText()) - Double.parseDouble(pago.getTxt_abona().getText());
            }

            String fechas = "";

            if (!(pago.getCalendar().getDate() == null)) {
                Date fecha = pago.getCalendar().getDate();
                DateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");
                fechas = Formato.format(fecha);
            }

            P.setId_pago(Id_Generator());
            P.setId_caso(Integer.parseInt(pago.getTxt_id().getText()));
            P.setCedula(pago.getTxt_cedula().getText());
            P.setFecha_Pago(fechas);
            P.setAbono(abona);
            P.setSaldo(saldo);
            if (P_DB.Register(P)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error Al Guardar Los Datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
