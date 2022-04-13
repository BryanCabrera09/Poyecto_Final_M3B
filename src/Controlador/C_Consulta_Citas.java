/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Cita;
import Modelo.Buf_CitaDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.V_Consulta_Citas;
import vista.V_Menu_Inicio;
import vista.V_Modificacion_Citas;

/*
 * @author BRYAN_CABRERA
 */
public class C_Consulta_Citas {

    V_Consulta_Citas consulta;
    V_Menu_Inicio Inicio;

    Buf_CitaDB Ci_DB = new Buf_CitaDB();

    private DefaultTableModel modelo;

    public C_Consulta_Citas(V_Consulta_Citas consulta) {

        this.consulta = consulta;

        Cargar_Datos();
    }

    public void Iniciar_Control() {

        //KEY EVENTO
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == consulta.getTxt_cedula()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && consulta.getTxt_cedula().getText().length() <= 9) {

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
                if (evt.getSource() == consulta.getTxt_cedula()) {
                    Buscar();
                }
            }
        };
        consulta.getTxt_cedula().addKeyListener(K);

        //MOUSE EVENTO
        MouseListener M = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent evt) {
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                if (evt.getSource() == consulta.getTable()) {
                    Abrir_Modificar();
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
        };
        consulta.getTable().addMouseListener(M);
    }

    public void Abrir_Modificar() {

        String x = V_Modificacion_Citas.x;

        try {
            V_Modificacion_Citas CI = new V_Modificacion_Citas();
            C_Modificacion_Citas modificacion = new C_Modificacion_Citas(CI);
            Inicio.getEscritorio().add(CI);
            CI.show();
            consulta.setVisible(false);

            List<Buf_Cita> List_cita = Ci_DB.Getter();

            int datos = consulta.getTable().getSelectedRow();

            String hora = List_cita.get(datos).getHora();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date fecha = formato.parse(hora);

            CI.getTxt_cedula().setText(List_cita.get(datos).getCedula());
            CI.getCb_caso().addItem(List_cita.get(datos).getNom_caso());
            CI.getJs_hora().setValue(fecha);
            for (int i = 0; i < List_cita.size(); i++) {
                if (List_cita.get(i).getCedula().equals(CI.getTxt_cedula().getText())) {
                    CI.getTxt_celular().setText(String.valueOf(List_cita.get(i).getNum_celular()));
                    CI.getTxt_id().setText(String.valueOf(List_cita.get(i).getId_cita()));
                    CI.getTxa_descripcion().setText(List_cita.get(i).getDescripcion());
                    modificacion.id_caso = String.valueOf(List_cita.get(i).getId_caso());
                }
            }
            CI.getLb_celular().setVisible(false);
            modificacion.Iniciar_Control();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Cargar_Datos() {

        consulta.getTable().getTableHeader().setResizingAllowed(false);
        consulta.getTable().getTableHeader().setReorderingAllowed(false);

        consulta.getTable().setDefaultEditor(Object.class, null);
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

        modelo.addColumn("CEDULA");
        modelo.addColumn("CASO");
        modelo.addColumn("HORA");

        List<Buf_Cita> List_cita = Ci_DB.Getter();

        List_cita.stream().map((cita) -> {
            Object[] fila = new Object[3];
            fila[0] = cita.getCedula();
            fila[1] = cita.getNom_caso();
            fila[2] = cita.getHora();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        consulta.getTable().setModel(modelo);
    }

    public void Limpiar_Tabla() {

        modelo.setRowCount(0);
        consulta.getTxt_cedula().setText("");
    }

    public void Actualizar_Tabla() {

        List<Buf_Cita> List_cita = Ci_DB.Getter();

        List_cita.stream().map((cita) -> {
            Object[] fila = new Object[3];
            fila[0] = cita.getCedula();
            fila[1] = cita.getNom_caso();
            fila[2] = cita.getHora();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        consulta.getTable().setModel(modelo);
    }

    public void Buscar() {

        if (consulta.getTxt_cedula().getText().isEmpty()) {

            Limpiar_Tabla();
            Actualizar_Tabla();
        }

        modelo.setRowCount(0);
        List<Buf_Cita> List_cita = Ci_DB.Search(consulta.getTxt_cedula().getText());

        List_cita.stream().map((cita) -> {
            Object[] fila = new Object[3];
            fila[0] = cita.getCedula();
            fila[1] = cita.getNom_caso();
            fila[2] = cita.getHora();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        consulta.getTable().setModel(modelo);
    }
}
