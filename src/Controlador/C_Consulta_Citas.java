/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Cita;
import static vista.Citas.Lista_Cita;
import vista.Consuta_Citas;
import static vista.Consuta_Citas.table;
import static vista.Consuta_Citas.x;
import vista.MenuInicio;
import static vista.MenuInicio.escritorio;
import vista.Modificacion_Citas;

/*
 * @author BRYAN_CABRERA
 */
public class C_Consulta_Citas implements KeyListener, MouseListener {

    Consuta_Citas consulta_Cita;
    private DefaultTableModel modelo;

    TableRowSorter<DefaultTableModel> sorter;

    public C_Consulta_Citas(Consuta_Citas consulta_Cita) {
        this.consulta_Cita = consulta_Cita;
        this.consulta_Cita.table.addMouseListener(this);
        this.consulta_Cita.txtcedula.addKeyListener(this);

        cargarDatos();
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == consulta_Cita.txtcedula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && consulta_Cita.txtcedula.getText().length() <= 9) {

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
        if (evt.getSource() == consulta_Cita.txtcedula) {
            Datos();
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {

    }

    @Override
    public void mousePressed(MouseEvent evt) {
        if (evt.getSource() == consulta_Cita.table) {
            String x = Modificacion_Citas.x;
            try {
                Modificacion_Citas CI = new Modificacion_Citas();
                C_Modificacion_Citas modificacion_Citas = new C_Modificacion_Citas(CI);
                escritorio.add(CI);
                CI.show();
                consulta_Cita.setVisible(false);

                int datos = table.getSelectedRow();

                String hora = Lista_Cita.get(datos).getHora();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date dataFormateada = formato.parse(hora);
                Date fecha = formato.parse(hora);

                Modificacion_Citas.txtcedula.setText(Lista_Cita.get(datos).getCedula());
                Modificacion_Citas.txtcelular.setText(Lista_Cita.get(datos).getCelular());
                Modificacion_Citas.cbcaso.addItem(Lista_Cita.get(datos).getCaso());
                Modificacion_Citas.jhora.setValue(fecha);
                Modificacion_Citas.txdescripcion.setText(Lista_Cita.get(datos).getCita());
                Modificacion_Citas.lacelular.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void cargarDatos() {

        table.setDefaultEditor(Object.class, null);
        modelo = new DefaultTableModel() {
            //CARGAR CAMPOS EN LA TABLA
            public boolean iscelleditable(int filas, int columnas) {
                if (columnas == 3) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        modelo.addColumn("CEDULA");
        modelo.addColumn("CASO");
        modelo.addColumn("HORA");

        for (Cita cita : Lista_Cita) {

            Object[] fila = new Object[3];
            fila[0] = cita.getCedula();
            fila[1] = cita.getCaso();
            fila[2] = cita.getHora();
            modelo.addRow(fila);
        }
        table.setModel(modelo);
        table.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        table.setRowSorter(sorter);
    }

    private void Datos() {

        try {
            sorter.setRowFilter(RowFilter.regexFilter(consulta_Cita.txtcedula.getText(), 0));

        } catch (Exception e) {
        }
    }
}
