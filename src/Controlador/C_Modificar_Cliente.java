/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Cliente;
import Modelo.Buf_ClienteDB;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.V_Modificar_Cliente;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Cliente {

    V_Modificar_Cliente modificar;

    Buf_Cliente C = new Buf_Cliente();
    Buf_ClienteDB C_DB = new Buf_ClienteDB();
    Buf_Persona P = new Buf_Persona();
    Buf_PersonaDB P_DB = new Buf_PersonaDB();

    private DefaultTableModel modelo;

    public C_Modificar_Cliente(V_Modificar_Cliente modificar) {

        this.modificar = modificar;

        Estado_Civil();
        Campos();
        Nuevo();
        Cargar_Datos();
    }

    public void Iniciar_Control() {

        //EVENTO TECLADO
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == modificar.getTxt_buscar()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && modificar.getTxt_buscar().getText().length() <= 9) {

                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == modificar.getTxt_nombre()) {
                    char c = evt.getKeyChar();

                    if ((c < 'a' && c < 'z') && (c < 'A' && c < 'Z')) {
                        evt.consume();
                    }
                }
                if (evt.getSource() == modificar.getTxt_ocupacion()) {
                    char c = evt.getKeyChar();

                    if ((c < 'a' && c < 'z') && (c < 'A' && c < 'Z')) {
                        evt.consume();
                    }
                }
                if (evt.getSource() == modificar.getTxt_celular()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && modificar.getTxt_celular().getText().length() <= 9) {

                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == modificar.getTxt_apellido()) {
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
                if (evt.getSource() == modificar.getTxt_buscar()) {
                    Buscar();
                }
                if (evt.getSource() == modificar.getTxt_ocupacion()) {
                    if (modificar.getTxt_ocupacion().isEditable() == true) {
                        Campo_Vacio();
                    }
                }

                if (evt.getSource() == modificar.getTxt_direccion()) {
                    if (modificar.getTxt_direccion().isEditable() == true) {
                        Campo_Vacio();
                    }
                }
                if (evt.getSource() == modificar.getTxt_celular()) {
                    if (modificar.getTxt_celular().isEditable() == true) {
                        Campo_Vacio();
                    }
                }
                if (evt.getSource() == modificar.getTxt_correo()) {
                    if (modificar.getTxt_correo().isEditable() == true) {
                        Campo_Vacio();
                    }

                    if (Validar_Correo(modificar.getTxt_correo().getText())) {

                        modificar.getCorreo().setVisible(false);
                    } else {

                        if (modificar.getLb_correo().isShowing() == true) {

                            modificar.getCorreo().setVisible(false);
                        } else {
                            modificar.getCorreo().setVisible(true);
                        }
                    }
                }
                if (evt.getSource() == modificar.getTxt_nombre()) {
                    if (modificar.getTxt_nombre().isEditable() == true) {
                        Campo_Vacio();
                    }
                }
                if (evt.getSource() == modificar.getTxt_apellido()) {
                    if (modificar.getTxt_apellido().isEditable() == true) {
                        Campo_Vacio();
                    }
                }

            }
        };
        modificar.getTxt_ocupacion().addKeyListener(K);
        modificar.getTxt_celular().addKeyListener(K);
        modificar.getTxt_nombre().addKeyListener(K);
        modificar.getTxt_correo().addKeyListener(K);
        modificar.getTxt_direccion().addKeyListener(K);
        modificar.getTxt_buscar().addKeyListener(K);
        modificar.getTxt_apellido().addKeyListener(K);

        //EVENTO MOUSE
        MouseListener M = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent evt) {

            }

            @Override
            public void mousePressed(MouseEvent evt) {

                if (evt.getSource() == modificar.getTablepersona()) {

                    Cargar_Table();
                }
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
            }

            @Override
            public void mouseExited(MouseEvent evt) {
            }
        };
        modificar.getTablepersona().addMouseListener(M);

        //ACTION BOTTON
        modificar.getBtn_cancelar().addActionListener(l -> {
            Cancelar();
        });
        modificar.getBtn_eliminar().addActionListener(l -> {
            Eliminar();
        });
        modificar.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
        modificar.getBtn_modificar().addActionListener(l -> {
            Modificar();
        });
        modificar.getCb_estado().addActionListener(l -> {
            if (modificar.getCb_estado().isEnabled() == true) {
                Campo_Vacio();
            }
        });
    }

    public void Eliminar() {

        List<Buf_Cliente> List_cliente = C_DB.Getter();

        for (int i = 0; i < List_cliente.size(); i++) {
            if (List_cliente.get(i).getCedula().equals(modificar.getTxt_cedula().getText())) {
                int elimina = JOptionPane.showConfirmDialog(null, "ELIMINAR REGISTRO", "AVISO", JOptionPane.YES_NO_OPTION);
                switch (elimina) {
                    case 0:
                        C.setId_cliente(Integer.parseInt(modificar.getTxt_id().getText()));

                        if (C_DB.Delete(C)) {

                            Nuevo();
                            modificar.getTxt_buscar().setEditable(true);
                            modificar.getBtn_modificar().setEnabled(false);
                            modificar.getBtn_eliminar().setEnabled(false);
                            Limpiar_Tabla();
                            Actualizar_Tabla();

                            JOptionPane.showMessageDialog(null, "Eliminacion Completada");
                        } else {

                            JOptionPane.showMessageDialog(null, "Proceso de Eliminacion Cancelado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 1:
                        JOptionPane.showMessageDialog(null, "ELIMINACION CANCELADA");
                        break;
                }
            }
        }
    }

    public void Guardar() {

        if (Validar_Datos() == true) {
            if (Validar_Correo() == true) {
                if (Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:
                            Subir_Datos();
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "MODIFICACION CANCELADA");
                            break;
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else {

                Campo_Vacio();
                JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Campo_Vacio();
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
        }
    }

    public void Subir_Datos() {

        String estado = (String) modificar.getCb_estado().getSelectedItem();

        P.setNombre(modificar.getTxt_nombre().getText());
        P.setApellido(modificar.getTxt_apellido().getText());
        P.setCorreo(modificar.getTxt_correo().getText());
        P.setDireccion(modificar.getTxt_direccion().getText());
        P.setNum_celular(modificar.getTxt_celular().getText());
        P.setEstado_civil(estado);
        P.setCedula(modificar.getTxt_cedula().getText());

        C.setOcupacion(modificar.getTxt_ocupacion().getText());
        C.setId_cliente(Integer.parseInt(modificar.getTxt_id().getText()));

        if (P_DB.Update(P)) {

        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        if (C_DB.Update(C)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            Campos();
            Nuevo();
            Limpiar_Tabla();
            Actualizar_Tabla();
        }
    }

    public boolean Validar_Datos() {

        String estado = (String) modificar.getCb_estado().getSelectedItem();

        if (!modificar.getTxt_nombre().getText().isEmpty() && !modificar.getTxt_apellido().getText().equals("") && !modificar.getTxt_correo().getText().isEmpty() && !modificar.getTxt_direccion().getText().isEmpty() && !modificar.getTxt_celular().getText().isEmpty() && !modificar.getTxt_ocupacion().getText().isEmpty() && !estado.equals("Seleccionar")) {
            return true;
        } else {
            return false;
        }
    }

    public void Modificar() {

        modificar.getTxt_nombre().setEditable(true);
        modificar.getTxt_apellido().setEditable(true);
        modificar.getTxt_cedula().setEditable(false);
        modificar.getTxt_correo().setEditable(true);
        modificar.getTxt_ocupacion().setEditable(true);
        modificar.getTxt_direccion().setEditable(true);
        modificar.getNacimeinto().setEditable(false);
        modificar.getBtn_eliminar().setEnabled(false);
        modificar.getTxt_buscar().setEditable(false);
        modificar.getBtn_cancelar().setEnabled(true);
        modificar.getBtn_modificar().setEnabled(false);
    }

    public void Cancelar() {

        modificar.getTxt_nombre().setEditable(false);
        modificar.getTxt_apellido().setEditable(false);
        modificar.getTxt_cedula().setEditable(false);
        modificar.getTxt_correo().setEditable(false);
        modificar.getTxt_celular().setEditable(false);
        modificar.getTxt_ocupacion().setEditable(false);
        modificar.getTxt_direccion().setEditable(false);
        modificar.getNacimeinto().setEditable(false);
        modificar.getBtn_guardar().setEnabled(false);
        modificar.getTxt_buscar().setEditable(true);
        modificar.getBtn_cancelar().setEnabled(false);
        modificar.getBtn_eliminar().setEnabled(true);
        modificar.getBtn_modificar().setEnabled(true);
    }

    public void Buscar() {

        if (modificar.getTxt_buscar().getText().isEmpty()) {

            Limpiar_Tabla();
            Actualizar_Tabla();
        }

        modelo.setRowCount(0);
        List<Buf_Persona> List_per = P_DB.Search_Cliente(modificar.getTxt_buscar().getText());

        List_per.stream().map((persona) -> {
            Object[] fila = new Object[7];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellido();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getFecha_Nacimiento();
            fila[5] = persona.getNum_celular();
            fila[6] = persona.getDireccion();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        modificar.getTablepersona().setModel(modelo);
    }

    public void Cargar_Table() {

        List<Buf_Cliente> List_cliente = C_DB.Getter();
        List<Buf_Persona> List_per = P_DB.Getter_Cliente();

        int select = modificar.getTablepersona().getSelectedRow();

        if (select != -1) {

            modificar.getTxt_buscar().setEditable(true);

            modificar.getTxt_cedula().setText(List_per.get(select).getCedula());
            modificar.getTxt_nombre().setText(List_per.get(select).getNombre());
            modificar.getTxt_apellido().setText(List_per.get(select).getApellido());
            modificar.getTxt_correo().setText(List_per.get(select).getCorreo());
            modificar.getTxt_direccion().setText(List_per.get(select).getDireccion());
            modificar.getTxt_celular().setText(List_per.get(select).getNum_celular());
            modificar.getCb_estado().setSelectedItem(List_per.get(select).getEstado_civil());
            modificar.getNacimeinto().setText(List_per.get(select).getFecha_Nacimiento());

            modificar.getTxt_ocupacion().setText(List_cliente.get(select).getOcupacion());
            modificar.getTxt_id().setText(String.valueOf(List_cliente.get(select).getId_cliente()));
        }
        modificar.getBtn_modificar().setEnabled(true);
        modificar.getBtn_eliminar().setEnabled(true);
    }

    public void Estado_Civil() {

        modificar.getCb_estado().addItem("Seleccionar");
        modificar.getCb_estado().addItem("Soltero");
        modificar.getCb_estado().addItem("Casado");
        modificar.getCb_estado().addItem("Divorciado");
    }

    public void Campo_Vacio() {

        if (modificar.getTxt_nombre().getText().isEmpty()) {
            modificar.getLb_nombre().setVisible(true);
        }

        if (modificar.getTxt_celular().getText().isEmpty()) {
            modificar.getLb_celular().setVisible(true);
        }

        if (modificar.getTxt_apellido().getText().isEmpty()) {
            modificar.getLb_apellido().setVisible(true);
            modificar.getBtn_cancelar().setEnabled(false);
        }

        if (modificar.getTxt_correo().getText().isEmpty()) {
            modificar.getLb_correo().setVisible(true);
        }

        if (modificar.getTxt_ocupacion().getText().isEmpty()) {
            modificar.getLb_cuenta().setVisible(true);
        }

        if (modificar.getTxt_direccion().getText().isEmpty()) {
            modificar.getLb_direccion().setVisible(true);
        }

        if (modificar.getCb_estado().getSelectedIndex() == 0) {
            modificar.getLb_estado().setVisible(true);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!modificar.getTxt_nombre().getText().isEmpty()) {
            modificar.getLb_nombre().setVisible(false);
        }

        if (!modificar.getTxt_celular().getText().isEmpty()) {
            modificar.getLb_celular().setVisible(false);
        }

        if (!modificar.getTxt_correo().getText().isEmpty()) {
            modificar.getLb_correo().setVisible(false);
        }

        if (!modificar.getTxt_ocupacion().getText().isEmpty()) {
            modificar.getLb_cuenta().setVisible(false);
        }

        if (!modificar.getTxt_direccion().getText().isEmpty()) {
            modificar.getLb_direccion().setVisible(false);
        }

        if (!(modificar.getCb_estado().getSelectedIndex() == 0)) {
            modificar.getLb_estado().setVisible(false);
        }

        if (!modificar.getTxt_apellido().getText().isEmpty()) {
            modificar.getLb_apellido().setVisible(false);
            modificar.getBtn_cancelar().setEnabled(true);
        }

        if (modificar.getLb_celular().isShowing() == true) {
            modificar.getCelular().setVisible(false);
        } else if (modificar.getTxt_celular().getText().length() < 10) {
            modificar.getCelular().setVisible(true);
        } else if (modificar.getTxt_celular().getText().length() == 10) {
            modificar.getCelular().setVisible(false);
        }

        if (!modificar.getTxt_nombre().getText().isEmpty() && !modificar.getTxt_correo().getText().isEmpty() && !modificar.getTxt_direccion().getText().isEmpty() && !modificar.getTxt_celular().getText().isEmpty() && !modificar.getTxt_ocupacion().getText().isEmpty() && !(modificar.getCb_estado().getSelectedIndex() == 0)) {
            modificar.getBtn_guardar().setEnabled(true);
        } else {
            modificar.getBtn_guardar().setEnabled(false);
        }
    }

    public void Campos() {

        modificar.getCelular().setVisible(false);
        modificar.getLb_apellido().setVisible(false);
        modificar.getLb_nombre().setVisible(false);
        modificar.getLb_correo().setVisible(false);
        modificar.getLb_celular().setVisible(false);
        modificar.getLb_cuenta().setVisible(false);
        modificar.getLb_estado().setVisible(false);
        modificar.getLb_direccion().setVisible(false);
        modificar.getCorreo().setVisible(false);
        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_modificar().setEnabled(false);
        modificar.getBtn_cancelar().setEnabled(false);
    }

    public void Cargar_Datos() {

        modificar.getTablepersona().getTableHeader().setResizingAllowed(false);
        modificar.getTablepersona().getTableHeader().setReorderingAllowed(false);

        modificar.getTablepersona().setDefaultEditor(Object.class, null);
        modelo = new DefaultTableModel() {
            //CARGAR CAMPOS EN LA TABLA
            public boolean iscelleditable(int filas, int columnas) {
                if (columnas == 7) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("CORREO");
        modelo.addColumn("FECHA DE NACIMIENTO");
        modelo.addColumn("CELULAR");
        modelo.addColumn("DIRECCION");

        List<Buf_Persona> List_per = P_DB.Getter_Cliente();

        List_per.stream().map((persona) -> {
            Object[] fila = new Object[7];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellido();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getFecha_Nacimiento();
            fila[5] = persona.getNum_celular();
            fila[6] = persona.getDireccion();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });

        modificar.getTablepersona().setModel(modelo);
        Nuevo();
    }

    public void Nuevo() {

        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_eliminar().setEnabled(false);
        modificar.getTxt_nombre().setEditable(false);
        modificar.getTxt_cedula().setEditable(false);
        modificar.getTxt_apellido().setEditable(false);
        modificar.getTxt_id().setEditable(false);
        modificar.getCb_estado().setEnabled(false);
        modificar.getTxt_celular().setEditable(false);
        modificar.getTxt_ocupacion().setEditable(false);
        modificar.getTxt_direccion().setEditable(false);
        modificar.getTxt_correo().setEditable(false);
        modificar.getNacimeinto().setEditable(false);
        modificar.getTxt_id().setText("");
        modificar.getTxt_cedula().setText("");
        modificar.getTxt_nombre().setText("");
        modificar.getCb_estado().setSelectedIndex(0);
        modificar.getTxt_apellido().setText("");
        modificar.getTxt_celular().setText("");
        modificar.getTxt_ocupacion().setText("");
        modificar.getTxt_direccion().setText("");
        modificar.getTxt_correo().setText("");
        modificar.getNacimeinto().setText("");
    }

    public void Actualizar_Tabla() {

        List<Buf_Persona> List_per = P_DB.Getter_Cliente();

        List_per.stream().map((persona) -> {
            Object[] fila = new Object[7];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellido();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getFecha_Nacimiento();
            fila[5] = persona.getNum_celular();
            fila[6] = persona.getDireccion();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        modificar.getTablepersona().setModel(modelo);
    }

    public void Limpiar_Tabla() {

        modelo.setRowCount(0);
        modificar.getTxt_cedula().setText("");
        modificar.getTxt_nombre().setText("");
        modificar.getCb_estado().setSelectedIndex(0);
        modificar.getTxt_apellido().setText("");
        modificar.getTxt_celular().setText("");
        modificar.getTxt_id().setText("");
        modificar.getTxt_ocupacion().setText("");
        modificar.getTxt_direccion().setText("");
        modificar.getTxt_ocupacion().setText("");
        modificar.getTxt_correo().setText("");
        modificar.getNacimeinto().setText("");
    }

    public boolean Validar_Correo() {

        List<Buf_Persona> List_pers = P_DB.Getter();

        for (int i = 0; i < List_pers.size(); i++) {
            if (List_pers.get(i).getCorreo().equalsIgnoreCase(modificar.getTxt_correo().getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Correo(String correo) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher valida = patron.matcher(correo);

        return valida.find();
    }
}
