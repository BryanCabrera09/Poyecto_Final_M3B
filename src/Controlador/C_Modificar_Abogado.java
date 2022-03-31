/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Abogado;
import vista.MenuInicio;
import vista.ModificarAbogado;
import static vista.ModificarAbogado.x;
import static vista.RegistroAbogado.Lista_abogado;
import static vista.RegistroCliente.Lista_cliente;
import static vista.RegistroSecretaria.Lista_Secretaria;
import static vista.RegistroUsuario.listausuario;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Abogado implements ActionListener, KeyListener, MouseListener {

    ModificarAbogado modificarAbogado;
    TableRowSorter<DefaultTableModel> sorter;
    protected static String Imagen, Dest, Orig;
    private DefaultTableModel modelo;
    String cedula = "";

    public C_Modificar_Abogado(ModificarAbogado modificarAbogado) {
        this.modificarAbogado = modificarAbogado;
        this.modificarAbogado.btncancelar.addActionListener(this);
        this.modificarAbogado.btnelimina.addActionListener(this);
        this.modificarAbogado.btnguardar.addActionListener(this);
        this.modificarAbogado.btnimagen.addActionListener(this);
        this.modificarAbogado.btnmodificar.addActionListener(this);
        this.modificarAbogado.cbestado.addActionListener(this);
        this.modificarAbogado.cb1.addActionListener(this);
        this.modificarAbogado.cb2.addActionListener(this);
        this.modificarAbogado.cb3.addActionListener(this);
        this.modificarAbogado.cb4.addActionListener(this);

        this.modificarAbogado.tablepersona.addMouseListener(this);

        this.modificarAbogado.txtapellido.addKeyListener(this);
        this.modificarAbogado.txtcuenta.addKeyListener(this);
        this.modificarAbogado.txtbuscar.addKeyListener(this);
        this.modificarAbogado.txtcedula.addKeyListener(this);
        this.modificarAbogado.txtcelular.addKeyListener(this);
        this.modificarAbogado.txtcorreo.addKeyListener(this);
        this.modificarAbogado.txtdireccion.addKeyListener(this);
        this.modificarAbogado.txtmatricula.addKeyListener(this);
        this.modificarAbogado.txtnombre.addKeyListener(this);

        estado_civil();
        Campos();
        cargarDatos();
    }

    public void estado_civil() {
        modificarAbogado.cbestado.addItem("Seleccionar");
        modificarAbogado.cbestado.addItem("Soltero");
        modificarAbogado.cbestado.addItem("Casado");
        modificarAbogado.cbestado.addItem("Divorciado");
    }

    public void Campo_Vacio() {
        String estado = (String) modificarAbogado.cbestado.getSelectedItem();
        if (modificarAbogado.txtnombre.getText().isEmpty()) {
            modificarAbogado.lanombre1.setVisible(true);
        }

        if (modificarAbogado.txtcelular.getText().isEmpty()) {
            modificarAbogado.lacelular1.setVisible(true);
        }

        if (modificarAbogado.txtcorreo.getText().isEmpty()) {
            modificarAbogado.lacorreo1.setVisible(true);
        }

        if (modificarAbogado.txtcuenta.getText().isEmpty()) {
            modificarAbogado.lacuenta.setVisible(true);
        }

        if (modificarAbogado.txtdireccion.getText().isEmpty()) {
            modificarAbogado.ladireccion1.setVisible(true);
        }

        if (estado.equals("Seleccionar")) {
            modificarAbogado.laestado1.setVisible(true);
        }

        if (!(modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
            modificarAbogado.lahorario1.setVisible(true);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!modificarAbogado.txtnombre.getText().isEmpty()) {
            modificarAbogado.lanombre1.setVisible(false);
        }

        if (!modificarAbogado.txtcelular.getText().isEmpty()) {
            modificarAbogado.lacelular1.setVisible(false);
        }

        if (!modificarAbogado.txtcorreo.getText().isEmpty()) {
            modificarAbogado.lacorreo1.setVisible(false);
        }

        if (!modificarAbogado.txtcuenta.getText().isEmpty()) {
            modificarAbogado.lacuenta.setVisible(false);
        }

        if (!modificarAbogado.txtdireccion.getText().isEmpty()) {
            modificarAbogado.ladireccion1.setVisible(false);
        }

        if (!estado.equals("Seleccionar")) {
            modificarAbogado.laestado1.setVisible(false);
        }

        if ((modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
            modificarAbogado.lahorario1.setVisible(false);
        }

        if (modificarAbogado.lacelular1.isShowing() == true) {
            modificarAbogado.celular.setVisible(false);
        } else if (!verificarCedula(modificarAbogado.txtcedula.getText())) {
            modificarAbogado.celular.setVisible(true);
        } else if (verificarCedula(modificarAbogado.txtcedula.getText())) {
            modificarAbogado.celular.setVisible(false);
        }

        if (!modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !(modificarAbogado.lafoto.getIcon() == null) && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
            modificarAbogado.btnguardar.setEnabled(true);
        } else {
            modificarAbogado.btnguardar.setEnabled(false);
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

        modificarAbogado.celular.setVisible(false);
        modificarAbogado.lanombre1.setVisible(false);
        modificarAbogado.lacorreo1.setVisible(false);
        modificarAbogado.lacelular1.setVisible(false);
        modificarAbogado.lacuenta.setVisible(false);
        modificarAbogado.lahorario1.setVisible(false);
        modificarAbogado.laestado1.setVisible(false);
        modificarAbogado.ladireccion1.setVisible(false);
        modificarAbogado.correo.setVisible(false);
        modificarAbogado.btnguardar.setEnabled(false);
        modificarAbogado.btnimagen.setEnabled(false);
        modificarAbogado.btncancelar.setEnabled(false);
        modificarAbogado.btnmodificar.setEnabled(false);
    }

    public void cargarDatos() {
        modificarAbogado.tablepersona.setDefaultEditor(Object.class, null);
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
        for (Abogado persona : Lista_abogado) {

            Object[] fila = new Object[8];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellidos();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getNacimiento();
            fila[5] = persona.getCelular();
            fila[6] = persona.getDireccion();
            fila[7] = persona.getNum_matricula();
            modelo.addRow(fila);
        }
        modificarAbogado.tablepersona.setModel(modelo);
        modificarAbogado.tablepersona.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        modificarAbogado.tablepersona.setRowSorter(sorter);
        Nuevo();
    }

    public void Nuevo() {
        modificarAbogado.btnguardar.setEnabled(false);
        modificarAbogado.btnelimina.setEnabled(false);
        modificarAbogado.txtnombre.setEditable(false);
        modificarAbogado.txtcedula.setEditable(false);
        modificarAbogado.txtapellido.setEditable(false);
        modificarAbogado.cbestado.setEnabled(false);
        modificarAbogado.txtcelular.setEditable(false);
        modificarAbogado.txtcuenta.setEditable(false);
        modificarAbogado.txtdireccion.setEditable(false);
        modificarAbogado.txtmatricula.setEditable(false);
        modificarAbogado.txtcorreo.setEditable(false);
        modificarAbogado.cb1.setEnabled(false);
        modificarAbogado.cb2.setEnabled(false);
        modificarAbogado.cb3.setEnabled(false);
        modificarAbogado.cb4.setEnabled(false);
        modificarAbogado.nacimeinto.setEditable(false);
        modificarAbogado.txtcedula.setText("");
        modificarAbogado.txtnombre.setText("");
        modificarAbogado.cbestado.setSelectedIndex(0);
        modificarAbogado.txtapellido.setText("");
        modificarAbogado.txtcelular.setText("");
        modificarAbogado.txtcuenta.setText("");
        modificarAbogado.txtdireccion.setText("");
        modificarAbogado.txtmatricula.setText("");
        modificarAbogado.txtcorreo.setText("");
        modificarAbogado.cb1.setSelected(false);
        modificarAbogado.cb2.setSelected(false);
        modificarAbogado.cb3.setSelected(false);
        modificarAbogado.cb4.setSelected(false);
        modificarAbogado.nacimeinto.setText("");
        modificarAbogado.lafoto.setIcon(null);
    }

    public void Actualizar_Tabla() {

        for (Abogado persona : Lista_abogado) {

            Object[] fila = new Object[8];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellidos();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getNacimiento();
            fila[5] = persona.getCelular();
            fila[6] = persona.getDireccion();
            fila[7] = persona.getNum_matricula();
            modelo.addRow(fila);
        }
        modificarAbogado.tablepersona.setModel(modelo);
    }

    public void Limpiar_Tabla() {

        modelo.setRowCount(0);
        modificarAbogado.txtcedula.setText("");
        modificarAbogado.txtnombre.setText("");
        modificarAbogado.cbestado.setSelectedIndex(0);
        modificarAbogado.txtapellido.setText("");
        modificarAbogado.txtcelular.setText("");
        modificarAbogado.txtcuenta.setText("");
        modificarAbogado.txtdireccion.setText("");
        modificarAbogado.txtmatricula.setText("");
        modificarAbogado.txtcorreo.setText("");
        modificarAbogado.cb1.setSelected(false);
        modificarAbogado.cb2.setSelected(false);
        modificarAbogado.cb3.setSelected(false);
        modificarAbogado.cb4.setSelected(false);
        modificarAbogado.nacimeinto.setText("");
    }

    private void Datos() {

        try {
            sorter.setRowFilter(RowFilter.regexFilter(modificarAbogado.txtbuscar.getText(), 0));

        } catch (Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == modificarAbogado.btncancelar) {
            modificarAbogado.txtnombre.setEditable(false);
            modificarAbogado.txtapellido.setEditable(false);
            modificarAbogado.txtcedula.setEditable(false);
            modificarAbogado.txtcorreo.setEditable(false);
            modificarAbogado.txtcelular.setEditable(false);
            modificarAbogado.txtcuenta.setEditable(false);
            modificarAbogado.txtdireccion.setEditable(false);
            modificarAbogado.cbestado.setEnabled(false);
            modificarAbogado.cb1.setEnabled(false);
            modificarAbogado.cb2.setEnabled(false);
            modificarAbogado.cb3.setEnabled(false);
            modificarAbogado.cb4.setEnabled(false);
            modificarAbogado.txtmatricula.setEditable(false);
            modificarAbogado.nacimeinto.setEditable(false);
            modificarAbogado.btnimagen.setEnabled(false);
            modificarAbogado.txtbuscar.setEditable(true);
            modificarAbogado.btnguardar.setEnabled(false);
            modificarAbogado.btncancelar.setEnabled(false);
            modificarAbogado.btnelimina.setEnabled(true);
            modificarAbogado.btnmodificar.setEnabled(true);
        }
        if (evt.getSource() == modificarAbogado.btnelimina) {
            for (int i = 0; i < Lista_abogado.size(); i++) {
                if (Lista_abogado.get(i).getCedula().equals(modificarAbogado.txtcedula.getText())) {
                    int elimina = JOptionPane.showConfirmDialog(null, "ELIMINAR REGISTRO", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (elimina) {
                        case 0:
                            Lista_abogado.remove(i);
                            Nuevo();
                            modificarAbogado.txtbuscar.setEditable(true);
                            modificarAbogado.btnmodificar.setEnabled(false);
                            modificarAbogado.btnelimina.setEnabled(false);
                            Limpiar_Tabla();
                            Actualizar_Tabla();
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "ELIMINACION CANCELADA");
                            break;
                    }
                }
            }

            for (int i = 0; i < listausuario.size(); i++) {
                if (listausuario.get(i).getCedula().equals(cedula)) {
                    listausuario.remove(i);
                }
            }
        }
        if (evt.getSource() == modificarAbogado.btnguardar) {
            if (Imagen.isEmpty()) {
                if (!(modificarAbogado.lafoto.getIcon() == null)) {
                    try {

                        Path Destino = Paths.get(Dest);
                        Path Origen = Paths.get(Orig);
                        Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);

                    } catch (IOException e) {
                        Logger.getLogger(ModificarAbogado.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
            String estado = (String) modificarAbogado.cbestado.getSelectedItem();
            String horario = "";
            if (modificarAbogado.cb1.isSelected() == true) {

                horario = horario + modificarAbogado.cb1.getText();
            }
            if (modificarAbogado.cb2.isSelected() == true) {

                horario = horario + modificarAbogado.cb2.getText();
            }
            if (modificarAbogado.cb3.isSelected() == true) {

                horario = horario + modificarAbogado.cb3.getText();
            }
            if (modificarAbogado.cb4.isSelected() == true) {

                horario = horario + modificarAbogado.cb4.getText();
            }

            if (!modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
                if (!Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !Lista_cliente.isEmpty()) {
                    if (Validar_Correo() == true) {
                        if (Validar_Correo(modificarAbogado.txtcorreo.getText()) && modificarAbogado.txtcelular.getText().length() == 10) {
                            int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:

                                    int select = modificarAbogado.tablepersona.getSelectedRow();

                                    Lista_abogado.get(select).setNombre(modificarAbogado.txtnombre.getText());
                                    Lista_abogado.get(select).setCorreo(modificarAbogado.txtcorreo.getText());
                                    Lista_abogado.get(select).setDireccion(modificarAbogado.txtdireccion.getText());
                                    Lista_abogado.get(select).setCelular(modificarAbogado.txtcelular.getText());
                                    Lista_abogado.get(select).setNum_cuenta(modificarAbogado.txtcuenta.getText());
                                    Lista_abogado.get(select).setRegistro_horario(horario);
                                    Lista_abogado.get(select).setEstado(estado);
                                    Lista_abogado.get(select).setImagen(Imagen);
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

            if (Lista_abogado.size() <= 0 && Lista_Secretaria.size() <= 0 && Lista_cliente.size() <= 0 && !modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
                if (Validar_Correo(modificarAbogado.txtcorreo.getText()) && modificarAbogado.txtcelular.getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:

                            int select = modificarAbogado.tablepersona.getSelectedRow();

                            Lista_abogado.get(select).setNombre(modificarAbogado.txtnombre.getText());
                            Lista_abogado.get(select).setCorreo(modificarAbogado.txtcorreo.getText());
                            Lista_abogado.get(select).setDireccion(modificarAbogado.txtdireccion.getText());
                            Lista_abogado.get(select).setCelular(modificarAbogado.txtcelular.getText());
                            Lista_abogado.get(select).setNum_cuenta(modificarAbogado.txtcuenta.getText());
                            Lista_abogado.get(select).setRegistro_horario(horario);
                            Lista_abogado.get(select).setEstado(estado);
                            Lista_abogado.get(select).setImagen(Imagen);
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
            } else if (!(Lista_abogado.size() <= 0) && Lista_Secretaria.size() <= 0 && Lista_cliente.size() <= 0 && !modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarAbogado.txtcorreo.getText()) && modificarAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarAbogado.tablepersona.getSelectedRow();

                                Lista_abogado.get(select).setNombre(modificarAbogado.txtnombre.getText());
                                Lista_abogado.get(select).setCorreo(modificarAbogado.txtcorreo.getText());
                                Lista_abogado.get(select).setDireccion(modificarAbogado.txtdireccion.getText());
                                Lista_abogado.get(select).setCelular(modificarAbogado.txtcelular.getText());
                                Lista_abogado.get(select).setNum_cuenta(modificarAbogado.txtcuenta.getText());
                                Lista_abogado.get(select).setRegistro_horario(horario);
                                Lista_abogado.get(select).setEstado(estado);
                                Lista_abogado.get(select).setImagen(Imagen);
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

            } else if (!(Lista_abogado.size() <= 0) && !(Lista_Secretaria.size() <= 0) && Lista_cliente.size() <= 0 && !modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarAbogado.txtcorreo.getText()) && modificarAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarAbogado.tablepersona.getSelectedRow();

                                Lista_abogado.get(select).setNombre(modificarAbogado.txtnombre.getText());
                                Lista_abogado.get(select).setCorreo(modificarAbogado.txtcorreo.getText());
                                Lista_abogado.get(select).setDireccion(modificarAbogado.txtdireccion.getText());
                                Lista_abogado.get(select).setCelular(modificarAbogado.txtcelular.getText());
                                Lista_abogado.get(select).setNum_cuenta(modificarAbogado.txtcuenta.getText());
                                Lista_abogado.get(select).setRegistro_horario(horario);
                                Lista_abogado.get(select).setEstado(estado);
                                Lista_abogado.get(select).setImagen(Imagen);
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

            } else if (!(Lista_abogado.size() <= 0) && Lista_Secretaria.size() <= 0 && !(Lista_cliente.size() <= 0) && !modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarAbogado.txtcorreo.getText()) && modificarAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarAbogado.tablepersona.getSelectedRow();

                                Lista_abogado.get(select).setNombre(modificarAbogado.txtnombre.getText());
                                Lista_abogado.get(select).setCorreo(modificarAbogado.txtcorreo.getText());
                                Lista_abogado.get(select).setDireccion(modificarAbogado.txtdireccion.getText());
                                Lista_abogado.get(select).setCelular(modificarAbogado.txtcelular.getText());
                                Lista_abogado.get(select).setNum_cuenta(modificarAbogado.txtcuenta.getText());
                                Lista_abogado.get(select).setRegistro_horario(horario);
                                Lista_abogado.get(select).setEstado(estado);
                                Lista_abogado.get(select).setImagen(Imagen);
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

            } else if (Lista_abogado.size() <= 0 && !(Lista_Secretaria.size() <= 0) && !(Lista_cliente.size() <= 0) && !modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarAbogado.txtcorreo.getText()) && modificarAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarAbogado.tablepersona.getSelectedRow();

                                Lista_abogado.get(select).setNombre(modificarAbogado.txtnombre.getText());
                                Lista_abogado.get(select).setCorreo(modificarAbogado.txtcorreo.getText());
                                Lista_abogado.get(select).setDireccion(modificarAbogado.txtdireccion.getText());
                                Lista_abogado.get(select).setCelular(modificarAbogado.txtcelular.getText());
                                Lista_abogado.get(select).setNum_cuenta(modificarAbogado.txtcuenta.getText());
                                Lista_abogado.get(select).setRegistro_horario(horario);
                                Lista_abogado.get(select).setEstado(estado);
                                Lista_abogado.get(select).setImagen(Imagen);
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
            } else if (Lista_abogado.isEmpty() && Lista_Secretaria.isEmpty() && !(Lista_cliente.size() <= 0) && !modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarAbogado.txtcorreo.getText()) && modificarAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarAbogado.tablepersona.getSelectedRow();

                                Lista_abogado.get(select).setNombre(modificarAbogado.txtnombre.getText());
                                Lista_abogado.get(select).setCorreo(modificarAbogado.txtcorreo.getText());
                                Lista_abogado.get(select).setDireccion(modificarAbogado.txtdireccion.getText());
                                Lista_abogado.get(select).setCelular(modificarAbogado.txtcelular.getText());
                                Lista_abogado.get(select).setNum_cuenta(modificarAbogado.txtcuenta.getText());
                                Lista_abogado.get(select).setRegistro_horario(horario);
                                Lista_abogado.get(select).setEstado(estado);
                                Lista_abogado.get(select).setImagen(Imagen);
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
            } else if (Lista_abogado.isEmpty() && !Lista_Secretaria.isEmpty() && Lista_cliente.isEmpty() && !modificarAbogado.txtnombre.getText().isEmpty() && !modificarAbogado.txtcorreo.getText().isEmpty() && !modificarAbogado.txtdireccion.getText().isEmpty() && !modificarAbogado.txtcelular.getText().isEmpty() && !modificarAbogado.txtcuenta.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarAbogado.cb1.isSelected() || modificarAbogado.cb2.isSelected() || modificarAbogado.cb3.isSelected() || modificarAbogado.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarAbogado.txtcorreo.getText()) && modificarAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarAbogado.tablepersona.getSelectedRow();

                                Lista_abogado.get(select).setNombre(modificarAbogado.txtnombre.getText());
                                Lista_abogado.get(select).setCorreo(modificarAbogado.txtcorreo.getText());
                                Lista_abogado.get(select).setDireccion(modificarAbogado.txtdireccion.getText());
                                Lista_abogado.get(select).setCelular(modificarAbogado.txtcelular.getText());
                                Lista_abogado.get(select).setNum_cuenta(modificarAbogado.txtcuenta.getText());
                                Lista_abogado.get(select).setRegistro_horario(horario);
                                Lista_abogado.get(select).setEstado(estado);
                                Lista_abogado.get(select).setImagen(Imagen);
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
        if (evt.getSource() == modificarAbogado.btnimagen) {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("C:\\Users\\ACER\\OneDrive\\Escritorio\\ACTIVIDAD_PRODUCTOS\\REGISTRO_PRODUCTOS"));
            file.showOpenDialog(modificarAbogado);
            File archivo = file.getSelectedFile();
            Dest = "src\\Imagenes_Abogados\\" + archivo.getName();
            Orig = archivo.getPath();
            Imagen = archivo.getName();

            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(modificarAbogado.lafoto.getWidth(), modificarAbogado.lafoto.getHeight(), Image.SCALE_DEFAULT));
            modificarAbogado.lafoto.setText(null);
            modificarAbogado.lafoto.setIcon(icono);

            Campo_Vacio();
        }
        if (evt.getSource() == modificarAbogado.btnmodificar) {
            modificarAbogado.txtnombre.setEditable(true);
            modificarAbogado.txtapellido.setEditable(false);
            modificarAbogado.txtcedula.setEditable(false);
            modificarAbogado.txtcorreo.setEditable(true);
            modificarAbogado.txtcelular.setEditable(true);
            modificarAbogado.txtcuenta.setEditable(true);
            modificarAbogado.txtdireccion.setEditable(true);
            modificarAbogado.cbestado.setEnabled(true);
            modificarAbogado.cb1.setEnabled(true);
            modificarAbogado.cb2.setEnabled(true);
            modificarAbogado.cb3.setEnabled(true);
            modificarAbogado.cb4.setEnabled(true);
            modificarAbogado.txtmatricula.setEditable(false);
            modificarAbogado.nacimeinto.setEditable(false);
            modificarAbogado.btnimagen.setEnabled(true);
            modificarAbogado.btnelimina.setEnabled(false);
            modificarAbogado.txtbuscar.setEditable(false);
            modificarAbogado.btncancelar.setEnabled(true);
            modificarAbogado.btnmodificar.setEnabled(false);
        }
        if (evt.getSource() == modificarAbogado.cbestado) {
            if (modificarAbogado.cbestado.isEditable() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarAbogado.cb1) {
            if (modificarAbogado.cb1.isEnabled() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarAbogado.cb2) {
            if (modificarAbogado.cb2.isEnabled() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarAbogado.cb3) {
            if (modificarAbogado.cb3.isEnabled() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarAbogado.cb4) {
            if (modificarAbogado.cb4.isEnabled() == true) {
                Campo_Vacio();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == modificarAbogado.txtcuenta) {
            char c = evt.getKeyChar();

            if (c < '0' || c > '9') {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarAbogado.txtcelular) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && modificarAbogado.txtcelular.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarAbogado.txtnombre) {
            char c = evt.getKeyChar();

            if ((c < 'a' && c < 'z') && (c < 'A' && c < 'Z')) {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarAbogado.txtbuscar) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && modificarAbogado.txtbuscar.getText().length() <= 9) {

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
        if (evt.getSource() == modificarAbogado.txtbuscar) {
            Datos();
        }
        if (evt.getSource() == modificarAbogado.txtcuenta) {
            if (modificarAbogado.txtcuenta.isEditable() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarAbogado.txtdireccion) {
            if (modificarAbogado.txtdireccion.isEditable() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarAbogado.txtcelular) {
            if (modificarAbogado.txtcelular.isEditable() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarAbogado.txtcorreo) {
            if (modificarAbogado.txtcorreo.isEditable() == true) {
                Campo_Vacio();
            }

            if (Validar_Correo(modificarAbogado.txtcorreo.getText())) {

                modificarAbogado.correo.setVisible(false);
            } else {

                if (modificarAbogado.lacorreo1.isShowing() == true) {

                    modificarAbogado.correo.setVisible(false);
                } else {
                    modificarAbogado.correo.setVisible(true);
                }
            }
        }
        if (evt.getSource() == modificarAbogado.txtnombre) {
            if (modificarAbogado.txtnombre.isEditable() == true) {
                Campo_Vacio();
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent evt) {
        if (evt.getSource() == modificarAbogado.tablepersona) {
            int select = modificarAbogado.tablepersona.getSelectedRow();

            if (select != -1) {

                modificarAbogado.cb1.setSelected(false);
                modificarAbogado.cb2.setSelected(false);
                modificarAbogado.cb3.setSelected(false);
                modificarAbogado.cb4.setSelected(false);
                modificarAbogado.txtnombre.setText(Lista_abogado.get(select).getNombre());
                modificarAbogado.txtapellido.setText(Lista_abogado.get(select).getApellidos());
                modificarAbogado.txtcedula.setText(Lista_abogado.get(select).getCedula());
                cedula = Lista_abogado.get(select).getCedula();
                modificarAbogado.txtcorreo.setText(Lista_abogado.get(select).getCorreo());
                modificarAbogado.txtcelular.setText(Lista_abogado.get(select).getCelular());
                modificarAbogado.txtcuenta.setText(Lista_abogado.get(select).getNum_cuenta());
                modificarAbogado.txtdireccion.setText(Lista_abogado.get(select).getDireccion());
                modificarAbogado.cbestado.setSelectedItem(Lista_abogado.get(select).getEstado());
                if (Lista_abogado.get(select).getRegistro_horario().equals("9:00-13:00")) {
                    modificarAbogado.cb1.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("13:00-15:00")) {
                    modificarAbogado.cb2.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("15:00-16:30")) {
                    modificarAbogado.cb3.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("16:30-18:30")) {
                    modificarAbogado.cb4.setSelected(true);
                }

                //MAS DE DOS OPCIONES
                if (Lista_abogado.get(select).getRegistro_horario().equals("9:00-13:0013:00-15:00")) {
                    modificarAbogado.cb1.setSelected(true);
                    modificarAbogado.cb2.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("9:00-13:0015:00-16:30")) {
                    modificarAbogado.cb1.setSelected(true);
                    modificarAbogado.cb3.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("9:00-13:0016:30-18:30")) {
                    modificarAbogado.cb1.setSelected(true);
                    modificarAbogado.cb4.setSelected(true);
                }

                if (Lista_abogado.get(select).getRegistro_horario().equals("13:00-15:0015:00-16:30")) {
                    modificarAbogado.cb2.setSelected(true);
                    modificarAbogado.cb3.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("15:00-16:3016:30-18:30")) {
                    modificarAbogado.cb3.setSelected(true);
                    modificarAbogado.cb4.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("13:00-15:0016:30-18:30")) {
                    modificarAbogado.cb2.setSelected(true);
                    modificarAbogado.cb4.setSelected(true);
                }

                if (Lista_abogado.get(select).getRegistro_horario().equals("9:00-13:0013:00-15:0015:00-16:30")) {
                    modificarAbogado.cb1.setSelected(true);
                    modificarAbogado.cb2.setSelected(true);
                    modificarAbogado.cb3.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("9:00-13:0013:00-15:0016:30-18:30")) {
                    modificarAbogado.cb1.setSelected(true);
                    modificarAbogado.cb2.setSelected(true);
                    modificarAbogado.cb4.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("13:00-15:0015:00-16:3016:30-18:30")) {
                    modificarAbogado.cb2.setSelected(true);
                    modificarAbogado.cb3.setSelected(true);
                    modificarAbogado.cb4.setSelected(true);
                }
                if (Lista_abogado.get(select).getRegistro_horario().equals("9:00-13:0013:00-15:0015:00-16:3016:30-18:30")) {
                    modificarAbogado.cb1.setSelected(true);
                    modificarAbogado.cb2.setSelected(true);
                    modificarAbogado.cb3.setSelected(true);
                    modificarAbogado.cb4.setSelected(true);
                }
                modificarAbogado.txtmatricula.setText(Lista_abogado.get(select).getNum_matricula());
                modificarAbogado.nacimeinto.setText(Lista_abogado.get(select).getNacimiento());
                Imagen = Lista_abogado.get(select).getImagen();
                Orig = "src/Imagenes_Abogados/" + Imagen;
                ImageIcon icon = new ImageIcon(Orig);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(modificarAbogado.lafoto.getWidth(), modificarAbogado.lafoto.getHeight(), Image.SCALE_DEFAULT));
                modificarAbogado.lafoto.setText(null);
                modificarAbogado.lafoto.setIcon(icono);
                modificarAbogado.btnelimina.setEnabled(true);
                modificarAbogado.btnmodificar.setEnabled(true);
                modificarAbogado.btnimagen.setEnabled(false);
                modificarAbogado.txtbuscar.setEditable(true);
            }
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

    public boolean Validar_Correo(String correo) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher valida = patron.matcher(correo);

        return valida.find();
    }

    public boolean Validar_Correo() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCorreo().equalsIgnoreCase(modificarAbogado.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCorreo().equalsIgnoreCase(modificarAbogado.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCorreo().equalsIgnoreCase(modificarAbogado.txtcorreo.getText())) {
                return false;
            }
        }
        return true;
    }

}
