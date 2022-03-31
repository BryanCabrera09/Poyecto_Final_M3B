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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Cliente;
import vista.ModificarCliente;
import static vista.RegistroAbogado.Lista_abogado;
import static vista.RegistroCliente.Lista_cliente;
import static vista.RegistroSecretaria.Lista_Secretaria;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Cliente implements ActionListener, KeyListener, MouseListener {

    ModificarCliente modificarCliente;
    private DefaultTableModel modelo;

    public C_Modificar_Cliente(ModificarCliente modificarCliente) {
        this.modificarCliente = modificarCliente;
        this.modificarCliente.btncancelar.addActionListener(this);
        this.modificarCliente.btnelimina.addActionListener(this);
        this.modificarCliente.btnguardar.addActionListener(this);
        this.modificarCliente.btnmodificar.addActionListener(this);
        this.modificarCliente.cbestado.addActionListener(this);

        this.modificarCliente.tablepersona.addMouseListener(this);

        this.modificarCliente.txtocupacion.addKeyListener(this);
        this.modificarCliente.txtcelular.addKeyListener(this);
        this.modificarCliente.txtnombre.addKeyListener(this);
        this.modificarCliente.txtcorreo.addKeyListener(this);
        this.modificarCliente.txtdireccion.addKeyListener(this);
        this.modificarCliente.txtbuscar.addKeyListener(this);
        estado_civil();
        Campos();
        cargarDatos();
    }

    TableRowSorter<DefaultTableModel> sorter;

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == modificarCliente.cbestado) {
            if (modificarCliente.cbestado.isEnabled() == true) {
                Campo_Vacio();
            }

        }
        if (evt.getSource() == modificarCliente.btnelimina) {
            for (int i = 0; i < Lista_cliente.size(); i++) {
                if (Lista_cliente.get(i).getCedula().equals(modificarCliente.txtcedula.getText())) {
                    int elimina = JOptionPane.showConfirmDialog(null, "ELIMINAR REGISTRO", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (elimina) {
                        case 0:
                            Lista_cliente.remove(i);
                            modificarCliente.txtbuscar.setEditable(true);
                            modificarCliente.btnmodificar.setEnabled(false);
                            modificarCliente.btnelimina.setEnabled(false);
                            Limpiar_Tabla();
                            Actualizar_Tabla();
                            break;

                        case 1:
                            JOptionPane.showMessageDialog(null, "ELIMINACION CANCELADA");
                            break;
                    }
                }
            }
        }
        if (evt.getSource() == modificarCliente.btnguardar) {
            String estado = (String) modificarCliente.cbestado.getSelectedItem();

            if (!modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !estado.equals("Seleccionar")) {
                if (!Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !Lista_cliente.isEmpty()) {
                    if (Validar_Correo() == true) {
                        if (Validar_Correo(modificarCliente.txtcorreo.getText()) && modificarCliente.txtcelular.getText().length() == 10) {
                            int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:

                                    int select = modificarCliente.tablepersona.getSelectedRow();

                                    Lista_cliente.get(select).setNombre(modificarCliente.txtnombre.getText());
                                    Lista_cliente.get(select).setCorreo(modificarCliente.txtcorreo.getText());
                                    Lista_cliente.get(select).setDireccion(modificarCliente.txtdireccion.getText());
                                    Lista_cliente.get(select).setCelular(modificarCliente.txtcelular.getText());
                                    Lista_cliente.get(select).setOcupacion(modificarCliente.txtocupacion.getText());
                                    Lista_cliente.get(select).setEstado(estado);
                                    Campos();
                                    Limpiar_Tabla();
                                    Actualizar_Tabla();
                                    Nuevo();
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
                }
            } else {
                Campo_Vacio();
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            }

            if (Lista_cliente.isEmpty() && Lista_Secretaria.isEmpty() && Lista_abogado.isEmpty() && !modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !estado.equals("Seleccionar")) {
                if (Validar_Correo(modificarCliente.txtcorreo.getText()) && modificarCliente.txtcelular.getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:

                            int select = modificarCliente.tablepersona.getSelectedRow();

                            Lista_cliente.get(select).setNombre(modificarCliente.txtnombre.getText());
                            Lista_cliente.get(select).setCorreo(modificarCliente.txtcorreo.getText());
                            Lista_cliente.get(select).setDireccion(modificarCliente.txtdireccion.getText());
                            Lista_cliente.get(select).setCelular(modificarCliente.txtcelular.getText());
                            Lista_cliente.get(select).setOcupacion(modificarCliente.txtocupacion.getText());
                            Lista_cliente.get(select).setEstado(estado);
                            Campos();
                            Limpiar_Tabla();
                            Actualizar_Tabla();
                            Nuevo();

                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "MODIFICACION CANCELADA");
                            break;
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!Lista_cliente.isEmpty() && Lista_Secretaria.isEmpty() && Lista_abogado.isEmpty() && !modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !estado.equals("Seleccionar")) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarCliente.txtcorreo.getText()) && modificarCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarCliente.tablepersona.getSelectedRow();

                                Lista_cliente.get(select).setNombre(modificarCliente.txtnombre.getText());
                                Lista_cliente.get(select).setCorreo(modificarCliente.txtcorreo.getText());
                                Lista_cliente.get(select).setDireccion(modificarCliente.txtdireccion.getText());
                                Lista_cliente.get(select).setCelular(modificarCliente.txtcelular.getText());
                                Lista_cliente.get(select).setOcupacion(modificarCliente.txtocupacion.getText());
                                Lista_cliente.get(select).setEstado(estado);
                                Campos();
                                Limpiar_Tabla();
                                Actualizar_Tabla();
                                Nuevo();
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
            } else if (!Lista_cliente.isEmpty() && !Lista_Secretaria.isEmpty() && Lista_abogado.isEmpty() && !modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !estado.equals("Seleccionar")) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarCliente.txtcorreo.getText()) && modificarCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarCliente.tablepersona.getSelectedRow();

                                Lista_cliente.get(select).setNombre(modificarCliente.txtnombre.getText());
                                Lista_cliente.get(select).setCorreo(modificarCliente.txtcorreo.getText());
                                Lista_cliente.get(select).setDireccion(modificarCliente.txtdireccion.getText());
                                Lista_cliente.get(select).setCelular(modificarCliente.txtcelular.getText());
                                Lista_cliente.get(select).setOcupacion(modificarCliente.txtocupacion.getText());
                                Lista_cliente.get(select).setEstado(estado);
                                Campos();
                                Limpiar_Tabla();
                                Actualizar_Tabla();
                                Nuevo();
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
            } else if (!Lista_cliente.isEmpty() && Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !estado.equals("Seleccionar")) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarCliente.txtcorreo.getText()) && modificarCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarCliente.tablepersona.getSelectedRow();

                                Lista_cliente.get(select).setNombre(modificarCliente.txtnombre.getText());
                                Lista_cliente.get(select).setCorreo(modificarCliente.txtcorreo.getText());
                                Lista_cliente.get(select).setDireccion(modificarCliente.txtdireccion.getText());
                                Lista_cliente.get(select).setCelular(modificarCliente.txtcelular.getText());
                                Lista_cliente.get(select).setOcupacion(modificarCliente.txtocupacion.getText());
                                Lista_cliente.get(select).setEstado(estado);
                                Campos();
                                Limpiar_Tabla();
                                Actualizar_Tabla();
                                Nuevo();
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
            } else if (Lista_cliente.isEmpty() && !Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !estado.equals("Seleccionar")) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarCliente.txtcorreo.getText()) && modificarCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarCliente.tablepersona.getSelectedRow();

                                Lista_cliente.get(select).setNombre(modificarCliente.txtnombre.getText());
                                Lista_cliente.get(select).setCorreo(modificarCliente.txtcorreo.getText());
                                Lista_cliente.get(select).setDireccion(modificarCliente.txtdireccion.getText());
                                Lista_cliente.get(select).setCelular(modificarCliente.txtcelular.getText());
                                Lista_cliente.get(select).setOcupacion(modificarCliente.txtocupacion.getText());
                                Lista_cliente.get(select).setEstado(estado);
                                Campos();
                                Limpiar_Tabla();
                                Actualizar_Tabla();
                                Nuevo();
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
            } else if (Lista_cliente.isEmpty() && Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !estado.equals("Seleccionar")) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarCliente.txtcorreo.getText()) && modificarCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarCliente.tablepersona.getSelectedRow();

                                Lista_cliente.get(select).setNombre(modificarCliente.txtnombre.getText());
                                Lista_cliente.get(select).setCorreo(modificarCliente.txtcorreo.getText());
                                Lista_cliente.get(select).setDireccion(modificarCliente.txtdireccion.getText());
                                Lista_cliente.get(select).setCelular(modificarCliente.txtcelular.getText());
                                Lista_cliente.get(select).setOcupacion(modificarCliente.txtocupacion.getText());
                                Lista_cliente.get(select).setEstado(estado);
                                Campos();
                                Limpiar_Tabla();
                                Actualizar_Tabla();
                                Nuevo();
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
            } else if (Lista_cliente.isEmpty() && !Lista_Secretaria.isEmpty() && Lista_abogado.isEmpty() && !modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !estado.equals("Seleccionar")) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarCliente.txtcorreo.getText()) && modificarCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarCliente.tablepersona.getSelectedRow();

                                Lista_cliente.get(select).setNombre(modificarCliente.txtnombre.getText());
                                Lista_cliente.get(select).setCorreo(modificarCliente.txtcorreo.getText());
                                Lista_cliente.get(select).setDireccion(modificarCliente.txtdireccion.getText());
                                Lista_cliente.get(select).setCelular(modificarCliente.txtcelular.getText());
                                Lista_cliente.get(select).setOcupacion(modificarCliente.txtocupacion.getText());
                                Lista_cliente.get(select).setEstado(estado);
                                Campos();
                                Limpiar_Tabla();
                                Actualizar_Tabla();
                                Nuevo();
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
            }
        }
        if (evt.getSource() == modificarCliente.btnmodificar) {
            modificarCliente.txtnombre.setEditable(true);
            modificarCliente.txtapellido.setEditable(false);
            modificarCliente.txtcedula.setEditable(false);
            modificarCliente.txtcorreo.setEditable(true);
            modificarCliente.txtocupacion.setEditable(true);
            modificarCliente.txtdireccion.setEditable(true);
            modificarCliente.nacimeinto.setEditable(false);
            modificarCliente.btnelimina.setEnabled(false);
            modificarCliente.txtbuscar.setEditable(false);
            modificarCliente.btncancelar.setEnabled(true);
            modificarCliente.btnmodificar.setEnabled(false);
        }
        if (evt.getSource() == modificarCliente.btncancelar) {
            modificarCliente.txtnombre.setEditable(false);
            modificarCliente.txtapellido.setEditable(false);
            modificarCliente.txtcedula.setEditable(false);
            modificarCliente.txtcorreo.setEditable(false);
            modificarCliente.txtcelular.setEditable(false);
            modificarCliente.txtocupacion.setEditable(false);
            modificarCliente.txtdireccion.setEditable(false);
            modificarCliente.nacimeinto.setEditable(false);
            modificarCliente.btnguardar.setEnabled(false);
            modificarCliente.txtbuscar.setEditable(true);
            modificarCliente.btncancelar.setEnabled(false);
            modificarCliente.btnelimina.setEnabled(true);
            modificarCliente.btnmodificar.setEnabled(true);
        }
    }

    private void Datos() {

        try {
            sorter.setRowFilter(RowFilter.regexFilter(modificarCliente.txtbuscar.getText(), 0));

        } catch (Exception e) {
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == modificarCliente.txtbuscar) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && modificarCliente.txtbuscar.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarCliente.txtnombre) {
            char c = evt.getKeyChar();

            if ((c < 'a' && c < 'z') && (c < 'A' && c < 'Z')) {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarCliente.txtocupacion) {
            char c = evt.getKeyChar();

            if (c < '0' || c > '9') {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarCliente.txtcelular) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && modificarCliente.txtcelular.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarCliente.txtapellido) {

        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {

    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getSource() == modificarCliente.txtbuscar) {
            Datos();
        }
        if (evt.getSource() == modificarCliente.txtocupacion) {
            if (modificarCliente.txtocupacion.isEditable() == true) {
                Campo_Vacio();
            }
        }

        if (evt.getSource() == modificarCliente.txtdireccion) {
            if (modificarCliente.txtdireccion.isEditable() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarCliente.txtcelular) {
            if (modificarCliente.txtcelular.isEditable() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarCliente.txtcorreo) {
            if (modificarCliente.txtcorreo.isEditable() == true) {
                Campo_Vacio();
            }

            if (Validar_Correo(modificarCliente.txtcorreo.getText())) {

                modificarCliente.correo.setVisible(false);
            } else {

                if (modificarCliente.lacorreo1.isShowing() == true) {

                    modificarCliente.correo.setVisible(false);
                } else {
                    modificarCliente.correo.setVisible(true);
                }
            }
        }
        if (evt.getSource() == modificarCliente.txtnombre) {
            if (modificarCliente.txtnombre.isEditable() == true) {
                Campo_Vacio();
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent evt) {

    }

    @Override
    public void mousePressed(MouseEvent evt) {
        if (evt.getSource() == modificarCliente.tablepersona) {
            int select = modificarCliente.tablepersona.getSelectedRow();

            if (select != -1) {

                modificarCliente.txtbuscar.setEditable(true);
                modificarCliente.txtnombre.setText(Lista_cliente.get(select).getNombre());
                modificarCliente.txtapellido.setText(Lista_cliente.get(select).getApellidos());
                modificarCliente.txtcedula.setText(Lista_cliente.get(select).getCedula());
                modificarCliente.txtcorreo.setText(Lista_cliente.get(select).getCorreo());
                modificarCliente.txtcelular.setText(Lista_cliente.get(select).getCelular());
                modificarCliente.txtocupacion.setText(Lista_cliente.get(select).getOcupacion());
                modificarCliente.txtdireccion.setText(Lista_cliente.get(select).getDireccion());
                modificarCliente.nacimeinto.setText(Lista_cliente.get(select).getNacimiento());
                modificarCliente.cbestado.setSelectedItem(Lista_cliente.get(select).getEstado());
            }
            modificarCliente.btnmodificar.setEnabled(true);
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

    public void estado_civil() {
        modificarCliente.cbestado.addItem("Seleccionar");
        modificarCliente.cbestado.addItem("Soltero");
        modificarCliente.cbestado.addItem("Casado");
        modificarCliente.cbestado.addItem("Divorciado");
    }

    public void Campo_Vacio() {

        if (modificarCliente.txtnombre.getText().isEmpty()) {
            modificarCliente.lanombre1.setVisible(true);
        }

        if (modificarCliente.txtcelular.getText().isEmpty()) {
            modificarCliente.lacelular1.setVisible(true);
        }

        if (modificarCliente.txtcorreo.getText().isEmpty()) {
            modificarCliente.lacorreo1.setVisible(true);
        }

        if (modificarCliente.txtocupacion.getText().isEmpty()) {
            modificarCliente.lacuenta.setVisible(true);
        }

        if (modificarCliente.txtdireccion.getText().isEmpty()) {
            modificarCliente.ladireccion1.setVisible(true);
        }

        if (modificarCliente.cbestado.getSelectedIndex() == 0) {
            modificarCliente.laestado1.setVisible(true);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!modificarCliente.txtnombre.getText().isEmpty()) {
            modificarCliente.lanombre1.setVisible(false);
        }

        if (!modificarCliente.txtcelular.getText().isEmpty()) {
            modificarCliente.lacelular1.setVisible(false);
        }

        if (!modificarCliente.txtcorreo.getText().isEmpty()) {
            modificarCliente.lacorreo1.setVisible(false);
        }

        if (!modificarCliente.txtocupacion.getText().isEmpty()) {
            modificarCliente.lacuenta.setVisible(false);
        }

        if (!modificarCliente.txtdireccion.getText().isEmpty()) {
            modificarCliente.ladireccion1.setVisible(false);
        }

        if (!(modificarCliente.cbestado.getSelectedIndex() == 0)) {
            modificarCliente.laestado1.setVisible(false);
        }

        if (modificarCliente.lacelular1.isShowing() == true) {
            modificarCliente.celular.setVisible(false);
        } else if (!verificarCedula(modificarCliente.txtcedula.getText())) {
            modificarCliente.celular.setVisible(true);
        } else if (verificarCedula(modificarCliente.txtcedula.getText())) {
            modificarCliente.celular.setVisible(false);
        }

        if (!modificarCliente.txtnombre.getText().isEmpty() && !modificarCliente.txtcorreo.getText().isEmpty() && !modificarCliente.txtdireccion.getText().isEmpty() && !modificarCliente.txtcelular.getText().isEmpty() && !modificarCliente.txtocupacion.getText().isEmpty() && !(modificarCliente.cbestado.getSelectedIndex() == 0)) {
            modificarCliente.btnguardar.setEnabled(true);
        } else {
            modificarCliente.btnguardar.setEnabled(false);
        }
    }

    public boolean verificarCedula(String cedula) {
        int total = 0;
        int tamanoLongitudCedula = 10;
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int numeroProviancias = 24;
        int tercerdigito = 6;
        if (cedula.matches("[0-9]*") && cedula.length() == tamanoLongitudCedula) {
            int provincia = Integer.parseInt(cedula.charAt(0) + "" + cedula.charAt(1));
            int digitoTres = Integer.parseInt(cedula.charAt(2) + "");
            if ((provincia > 0 && provincia <= numeroProviancias) && digitoTres < tercerdigito) {
                int digitoVerificadorRecibido = Integer.parseInt(cedula.charAt(9) + "");
                for (int i = 0; i < coeficientes.length; i++) {
                    int valor = Integer.parseInt(coeficientes[i] + "") * Integer.parseInt(cedula.charAt(i) + "");
                    total = valor >= 10 ? total + (valor - 9) : total + valor;
                }
                int digitoVerificadorObtenido = total >= 10 ? (total % 10) != 0 ? 10 - (total % 10) : (total % 10) : total;
                if (digitoVerificadorObtenido == digitoVerificadorRecibido) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void Campos() {

        modificarCliente.celular.setVisible(false);
        modificarCliente.lanombre1.setVisible(false);
        modificarCliente.lacorreo1.setVisible(false);
        modificarCliente.lacelular1.setVisible(false);
        modificarCliente.lacuenta.setVisible(false);
        modificarCliente.laestado1.setVisible(false);
        modificarCliente.ladireccion1.setVisible(false);
        modificarCliente.correo.setVisible(false);
        modificarCliente.btnguardar.setEnabled(false);
        modificarCliente.btnmodificar.setEnabled(false);
        modificarCliente.btncancelar.setEnabled(false);
    }

    public void cargarDatos() {
        modificarCliente.tablepersona.setDefaultEditor(Object.class, null);
        modelo = new DefaultTableModel() {
            //CARGAR CAMPOS EN LA TABLA
            public boolean iscelleditable(int filas, int columnas) {
                if (columnas == 8) {
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
        modelo.addColumn("MATRICULA");
        for (Cliente persona : Lista_cliente) {

            Object[] fila = new Object[11];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellidos();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getNacimiento();
            fila[5] = persona.getCelular();
            fila[6] = persona.getDireccion();
            fila[7] = persona.getOcupacion();
            modelo.addRow(fila);
        }
        modificarCliente.tablepersona.setModel(modelo);
        modificarCliente.tablepersona.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        modificarCliente.tablepersona.setRowSorter(sorter);
        Nuevo();
    }

    public void Nuevo() {
        modificarCliente.btnguardar.setEnabled(false);
        modificarCliente.btnelimina.setEnabled(false);
        modificarCliente.txtnombre.setEditable(false);
        modificarCliente.txtcedula.setEditable(false);
        modificarCliente.txtapellido.setEditable(false);
        modificarCliente.cbestado.setEnabled(false);
        modificarCliente.txtcelular.setEditable(false);
        modificarCliente.txtocupacion.setEditable(false);
        modificarCliente.txtdireccion.setEditable(false);
        modificarCliente.txtcorreo.setEditable(false);
        modificarCliente.nacimeinto.setEditable(false);
        modificarCliente.txtcedula.setText("");
        modificarCliente.txtnombre.setText("");
        modificarCliente.cbestado.setSelectedIndex(0);
        modificarCliente.txtapellido.setText("");
        modificarCliente.txtcelular.setText("");
        modificarCliente.txtocupacion.setText("");
        modificarCliente.txtdireccion.setText("");
        modificarCliente.txtocupacion.setText("");
        modificarCliente.txtcorreo.setText("");
        modificarCliente.nacimeinto.setText("");
    }

    public void Actualizar_Tabla() {

        for (Cliente persona : Lista_cliente) {

            Object[] fila = new Object[8];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellidos();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getNacimiento();
            fila[5] = persona.getCelular();
            fila[6] = persona.getDireccion();
            fila[7] = persona.getOcupacion();
            modelo.addRow(fila);
        }
        modificarCliente.tablepersona.setModel(modelo);
    }

    public void Limpiar_Tabla() {

        modelo.setRowCount(0);
        modificarCliente.txtcedula.setText("");
        modificarCliente.txtnombre.setText("");
        modificarCliente.cbestado.setSelectedIndex(0);
        modificarCliente.txtapellido.setText("");
        modificarCliente.txtcelular.setText("");
        modificarCliente.txtocupacion.setText("");
        modificarCliente.txtdireccion.setText("");
        modificarCliente.txtocupacion.setText("");
        modificarCliente.txtcorreo.setText("");
        modificarCliente.nacimeinto.setText("");
    }

    public boolean Validar_Correo() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCorreo().equalsIgnoreCase(modificarCliente.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCorreo().equalsIgnoreCase(modificarCliente.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCorreo().equalsIgnoreCase(modificarCliente.txtcorreo.getText())) {
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
