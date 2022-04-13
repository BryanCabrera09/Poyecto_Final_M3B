/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Consulta;
import Modelo.Buf_ConsultaDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.V_Consulta_Consultas;
import vista.V_Menu_Inicio;
import vista.V_Modificar_Consulta;

/*
 * @author BRYAN_CABRERA
 */
public class C_Consultas_Consultas {

    V_Consulta_Consultas consultas;
    V_Menu_Inicio Inicio;

    Buf_ConsultaDB C_DB = new Buf_ConsultaDB();

    private DefaultTableModel modelo;

    public C_Consultas_Consultas(V_Consulta_Consultas consultas) {

        this.consultas = consultas;
        Cargar_Datos();
    }

    public void Iniciar_Control() {

        //EVENTS KEY
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == consultas.getTxt_apellido()) {
                    int key = evt.getKeyChar();

                    if (consultas.getTxt_apellido().getText().length() <= 20) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                        if (!letra) {

                            evt.consume();
                        }

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
                if (evt.getSource() == consultas.getTxt_apellido()) {
                    Buscar();
                }
            }
        };
        consultas.getTxt_apellido().addKeyListener(K);

        //EVENTS MOUSE
        MouseListener M = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == consultas.getTable()) {
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
        consultas.getTable().addMouseListener(M);
    }

    public void Abrir_Modificar() {

        String x = V_Modificar_Consulta.x;

        try {
            V_Modificar_Consulta CI = new V_Modificar_Consulta();
            C_Modificar_Consultas modificar = new C_Modificar_Consultas(CI);
            Inicio.getEscritorio().add(CI);
            CI.show();
            consultas.setVisible(false);

            List<Buf_Consulta> List_consulta = C_DB.Getter();

            int datos = consultas.getTable().getSelectedRow();

            String hora = List_consulta.get(datos).getHora();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date fecha = formato.parse(hora);

            CI.getTxt_nombres().setText(List_consulta.get(datos).getNombre());
            CI.getTxt_apellidos().setText(List_consulta.get(datos).getApellido());
            CI.getCb_caso().setSelectedItem(List_consulta.get(datos).getCaso());
            CI.getJs_hora().setValue(fecha);
            for (int i = 0; i < List_consulta.size(); i++) {
                if (List_consulta.get(i).getApellido().equals(CI.getTxt_apellidos().getText())) {
                    CI.getTxt_celular().setText(List_consulta.get(i).getNum_celular());
                    CI.getTxa_descripcion().setText(List_consulta.get(i).getDescripcion());
                    CI.getTxt_id().setText(String.valueOf(List_consulta.get(i).getId_consulta()));
                }
            }
            CI.getLb_nombre().setVisible(false);
            modificar.Iniciar_Control();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Cargar_Datos() {

        consultas.getTable().getTableHeader().setResizingAllowed(false);
        consultas.getTable().getTableHeader().setReorderingAllowed(false);

        consultas.getTable().setDefaultEditor(Object.class, null);
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

        List<Buf_Consulta> List_consulta = C_DB.Getter();

        List_consulta.stream().map((consulta) -> {
            Object[] fila = new Object[4];
            fila[0] = consulta.getNombre();
            fila[1] = consulta.getApellido();
            fila[2] = consulta.getCaso();
            fila[3] = consulta.getHora();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        consultas.getTable().setModel(modelo);
    }

    public void Limpiar_Tabla() {

        modelo.setRowCount(0);
        consultas.getTxt_apellido().setText("");
    }

    public void Actualizar_Tabla() {

        List<Buf_Consulta> List_consulta = C_DB.Getter();

        List_consulta.stream().map((consulta) -> {
            Object[] fila = new Object[4];
            fila[0] = consulta.getNombre();
            fila[1] = consulta.getApellido();
            fila[2] = consulta.getCaso();
            fila[3] = consulta.getHora();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        consultas.getTable().setModel(modelo);
    }

    public void Buscar() {

        if (consultas.getTxt_apellido().getText().isEmpty()) {

            Limpiar_Tabla();
            Actualizar_Tabla();
        }

        modelo.setRowCount(0);
        List<Buf_Consulta> List_consulta = C_DB.Search(consultas.getTxt_apellido().getText());

        List_consulta.stream().map((consulta) -> {
            Object[] fila = new Object[4];
            fila[0] = consulta.getNombre();
            fila[1] = consulta.getApellido();
            fila[2] = consulta.getCaso();
            fila[3] = consulta.getHora();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        consultas.getTable().setModel(modelo);
    }
}
