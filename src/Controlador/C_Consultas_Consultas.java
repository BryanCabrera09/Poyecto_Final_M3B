/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Consulta;
import static vista.Consultas.Lista_consulta;
import vista.Consuta_Consultas;
import static vista.Consuta_Consultas.table;
import static vista.MenuInicio.escritorio;
import vista.Modificacion_Citas;
import vista.Modificar_Consulta;

/*
 * @author BRYAN_CABRERA
 */
public class C_Consultas_Consultas implements KeyListener, MouseListener {

    Consuta_Consultas consuta_Consultas;
    private DefaultTableModel modelo;

    TableRowSorter<DefaultTableModel> sorter;

    public C_Consultas_Consultas(Consuta_Consultas consuta_Consultas) {
        this.consuta_Consultas = consuta_Consultas;
        table.addMouseListener(this);
        this.consuta_Consultas.txtapellido.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == consuta_Consultas.txtapellido) {
            char c = evt.getKeyChar();

            if ((c < 'a' && c < 'z') && (c < 'A' && c < 'Z')) {
                evt.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {

    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getSource() == consuta_Consultas.txtapellido) {
            Datos();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        String x = Modificar_Consulta.x;
        try {
            Modificar_Consulta CI = new Modificar_Consulta();
            C_Modificar_Consultas modificarConsultas = new C_Modificar_Consultas(CI);
            escritorio.add(CI);
            CI.show();
            consuta_Consultas.setVisible(false);

            int datos = table.getSelectedRow();

            String hora = Lista_consulta.get(datos).getHora();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date dataFormateada = formato.parse(hora);
            Date fecha = formato.parse(hora);

            Modificar_Consulta.txtnombres.setText(Lista_consulta.get(datos).getNombres());
            Modificar_Consulta.txtapellidos.setText(Lista_consulta.get(datos).getApellidos());
            Modificar_Consulta.cbcaso.setSelectedItem(Lista_consulta.get(datos).getCaso());
            Modificar_Consulta.jhora.setValue(fecha);
            Modificar_Consulta.txdescripcion.setText(Lista_consulta.get(datos).getConsulta());
            Modificacion_Citas.lacelular.setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                if (columnas == 4) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        modelo.addColumn("NOMBRES");
        modelo.addColumn("APELLIDOS");
        modelo.addColumn("CASO");
        modelo.addColumn("HORA");

        for (Consulta consulta : Lista_consulta) {

            Object[] fila = new Object[4];
            fila[0] = consulta.getNombres();
            fila[1] = consulta.getApellidos();
            fila[2] = consulta.getCaso();
            fila[3] = consulta.getHora();
            modelo.addRow(fila);
        }
        table.setModel(modelo);
        table.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        table.setRowSorter(sorter);
    }

    private void Datos() {

        try {
            sorter.setRowFilter(RowFilter.regexFilter(consuta_Consultas.txtapellido.getText(), 1));

        } catch (Exception e) {
        }
    }
}
