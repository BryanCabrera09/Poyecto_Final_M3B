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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import modelo.Pagos;
import vista.MenuInicio;
import vista.Pago;
import static vista.Pago.listapago;

/*
 * @author BRYAN_CABRERA
 */
public class C_Pago implements ActionListener, KeyListener {

    DefaultTableModel modelo;
    Pago pago;

    public static String cedu;
    public static String caso;

    public C_Pago(Pago pago) {
        this.pago = pago;
        this.pago.btn_abono.addActionListener(this);
        this.pago.btn_guardar.addActionListener(this);
        this.pago.txtCantidad.addKeyListener(this);
        this.pago.txt_valorInicial.addKeyListener(this);
        cargarDatos();
        actualizarTabla();
        nuevo();
    }

    public C_Pago(Pago pago, String cedula, String ca) {
        this.pago = pago;
        this.pago.btn_abono.addActionListener(this);
        this.pago.btn_guardar.addActionListener(this);

        cargarDatos();
        actualizarTabla();
        nuevo();
    }

    public void cargarDatos() {
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
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("SALDO");

    }

    public void actualizarTabla() {
        for (int i = 0; i < listapago.size(); i++) {
            if (listapago.get(i).getCedula().equals(cedu) && listapago.get(i).getCaso().equals(caso)) {
                Object[] fila = new Object[3];
                fila[0] = listapago.get(i).getFecha();
                fila[1] = listapago.get(i).getAbono();
                fila[2] = listapago.get(i).getSaldo();
                modelo.addRow(fila);
            }
        }
        pago.tablaPago.setModel(modelo);
    }

    public void limpiarTabla() {
        modelo.setNumRows(0); //LIMPIAR TABLA
        pago.txtCantidad.setText("");
        pago.jDateChooser1.setCalendar(null);
    }

    public void nuevo() {
        pago.txtCantidad.setEditable(false);
        pago.jDateChooser1.setCalendar(null);
        pago.btn_guardar.setEnabled(true);
        pago.btn_abono.setEnabled(false);

        for (int i = 0; i < listapago.size(); i++) {
            if (listapago.get(i).getCedula().equals(cedu) && listapago.get(i).getCaso().equals(caso)) {
                pago.txt_valorInicial.setEditable(false);
                pago.btn_guardar.setEnabled(false);
                pago.btn_abono.setEnabled(true);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == pago.btn_abono) {
            pago.btn_guardar.setEnabled(true);
            pago.txtCantidad.setEditable(true);
            pago.jDateChooser1.setEnabled(true);
        }
        if (evt.getSource() == pago.btn_guardar) {
            String fechas = "";
            if (!(pago.jDateChooser1.getDate() == null)) {
                Date fecha = pago.jDateChooser1.getDate();
                DateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
                fechas = Formato.format(fecha);
            }

            if (listapago.isEmpty()) {
                double cantidad = Double.parseDouble(pago.txt_valorInicial.getText());
                double saldo = cantidad;
                System.out.println(cedu + " " + fechas + " " + cantidad + " " + caso);
                Pagos p = new Pagos(cedu, fechas, cantidad, caso, saldo);
                listapago.add(p);
                limpiarTabla();
                actualizarTabla();
                nuevo();
                pago.btn_guardar.setEnabled(false);
            } else {
                double cantidad;
                double saldo = 0;
                if (pago.txtCantidad.getText().equals("")) {
                    cantidad = Double.parseDouble(pago.txt_valorInicial.getText());
                    saldo = cantidad;
                } else {
                    cantidad = Double.parseDouble(pago.txtCantidad.getText());
                    for (int i = 0; i < listapago.size(); i++) {
                        if (listapago.get(i).getCedula().equals(cedu) && listapago.get(i).getCaso().equals(caso)) {
                            saldo = listapago.get(i).getSaldo();
                        }
                    }
                    saldo = saldo - cantidad;
                }
                Pagos p = new Pagos(cedu, fechas, cantidad, caso, saldo);
                listapago.add(p);
                limpiarTabla();
                for (int i = 0; i < listapago.size(); i++) {
                    if (listapago.get(i).getCedula().equals(cedu) && listapago.get(i).getCaso().equals(caso)) {
                        Object[] fila = new Object[3];
                        fila[0] = listapago.get(i).getFecha();
                        fila[1] = listapago.get(i).getAbono();
                        fila[2] = listapago.get(i).getSaldo();
                        modelo.addRow(fila);
                    }
                }
                pago.tablaPago.setModel(modelo);
                nuevo();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == pago.txtCantidad) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && pago.txtCantidad.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == pago.txt_valorInicial) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && pago.txt_valorInicial.getText().length() <= 9) {

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
