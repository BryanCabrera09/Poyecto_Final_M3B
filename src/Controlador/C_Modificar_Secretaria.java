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
import modelo.Secretaria;
import vista.ModificarSecretaria;
import static vista.RegistroAbogado.Lista_abogado;
import static vista.RegistroCliente.Lista_cliente;
import static vista.RegistroSecretaria.Lista_Secretaria;
import static vista.RegistroUsuario.listausuario;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Secretaria implements ActionListener, KeyListener, MouseListener {

    ModificarSecretaria modificarSecretaria;
    private DefaultTableModel modelo;

    String cedula = "";
    TableRowSorter<DefaultTableModel> sorter;

    protected static String Imagen, Dest, Orig;

    public C_Modificar_Secretaria(ModificarSecretaria modificarSecretaria) {
        this.modificarSecretaria = modificarSecretaria;
        this.modificarSecretaria.btncancelar.addActionListener(this);
        this.modificarSecretaria.btnelimina.addActionListener(this);
        this.modificarSecretaria.btnguardar.addActionListener(this);
        this.modificarSecretaria.btnimagen.addActionListener(this);
        this.modificarSecretaria.btnmodificar.addActionListener(this);
        this.modificarSecretaria.cbestado.addActionListener(this);
        this.modificarSecretaria.cb1.addActionListener(this);
        this.modificarSecretaria.cb2.addActionListener(this);
        this.modificarSecretaria.cb3.addActionListener(this);
        this.modificarSecretaria.cb4.addActionListener(this);

        this.modificarSecretaria.tablepersona.addMouseListener(this);

        this.modificarSecretaria.txtcelular.addKeyListener(this);
        this.modificarSecretaria.txtnombre.addKeyListener(this);
        this.modificarSecretaria.txtdireccion.addKeyListener(this);
        this.modificarSecretaria.txtcorreo.addKeyListener(this);
        this.modificarSecretaria.txtbuscar.addKeyListener(this);
        estado_civil();
        Campos();
        cargarDatos();

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == modificarSecretaria.btncancelar) {
            modificarSecretaria.cb1.setEnabled(false);
            modificarSecretaria.cb2.setEnabled(false);
            modificarSecretaria.cb3.setEnabled(false);
            modificarSecretaria.cb4.setEnabled(false);
            modificarSecretaria.txtnombre.setEditable(false);
            modificarSecretaria.txtcorreo.setEditable(false);
            modificarSecretaria.txtcelular.setEditable(false);
            modificarSecretaria.txtdireccion.setEditable(false);
            modificarSecretaria.cbestado.setEnabled(false);
            modificarSecretaria.btnimagen.setEnabled(false);
            modificarSecretaria.nacimeinto.setEditable(false);
            modificarSecretaria.txtbuscar.setEditable(true);
            modificarSecretaria.btnimagen.setEnabled(false);
            modificarSecretaria.btnguardar.setEnabled(false);
            modificarSecretaria.btncancelar.setEnabled(false);
            modificarSecretaria.btnelimina.setEnabled(true);
            modificarSecretaria.btnmodificar.setEnabled(true);
        }
        if (evt.getSource() == modificarSecretaria.btnelimina) {
            for (int i = 0; i < Lista_Secretaria.size(); i++) {
                if (Lista_Secretaria.get(i).getCedula().equals(modificarSecretaria.txtcedula.getText())) {
                    int elimina = JOptionPane.showConfirmDialog(null, "ELIMINAR REGISTRO", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (elimina) {
                        case 0:
                            Lista_Secretaria.remove(i);
                            Nuevo();
                            modificarSecretaria.txtbuscar.setEditable(true);
                            modificarSecretaria.btnmodificar.setEnabled(false);
                            modificarSecretaria.btnelimina.setEnabled(false);
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
        if (evt.getSource() == modificarSecretaria.btnguardar) {

            if (Imagen.isEmpty()) {
                if (!(modificarSecretaria.lafoto.getIcon() == null)) {
                    try {

                        Path Destino = Paths.get(Dest);
                        Path Origen = Paths.get(Orig);
                        Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);

                    } catch (IOException e) {
                        Logger.getLogger(ModificarSecretaria.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }

            String estado = (String) modificarSecretaria.cbestado.getSelectedItem();
            String horario = "";
            if (modificarSecretaria.cb1.isSelected() == true) {

                horario = horario + modificarSecretaria.cb1.getText();
            }
            if (modificarSecretaria.cb2.isSelected() == true) {

                horario = horario + modificarSecretaria.cb2.getText();
            }
            if (modificarSecretaria.cb3.isSelected() == true) {

                horario = horario + modificarSecretaria.cb3.getText();
            }
            if (modificarSecretaria.cb4.isSelected() == true) {

                horario = horario + modificarSecretaria.cb4.getText();
            }

            if (!modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
                if (!Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !Lista_cliente.isEmpty()) {
                    if (Validar_Correo() == true) {
                        if (Validar_Correo(modificarSecretaria.txtcorreo.getText()) && modificarSecretaria.txtcelular.getText().length() == 10) {
                            int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:

                                    int select = modificarSecretaria.tablepersona.getSelectedRow();

                                    Lista_Secretaria.get(select).setNombre(modificarSecretaria.txtnombre.getText());
                                    Lista_Secretaria.get(select).setCorreo(modificarSecretaria.txtcorreo.getText());
                                    Lista_Secretaria.get(select).setDireccion(modificarSecretaria.txtdireccion.getText());
                                    Lista_Secretaria.get(select).setCelular(modificarSecretaria.txtcelular.getText());
                                    Lista_Secretaria.get(select).setHorario(horario);
                                    Lista_Secretaria.get(select).setEstado(estado);
                                    Lista_Secretaria.get(select).setImagen(Imagen);
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

            if (Lista_Secretaria.size() <= 0 && Lista_cliente.size() <= 0 && Lista_abogado.size() <= 0 && !modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar...") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
                if (Validar_Correo(modificarSecretaria.txtcorreo.getText()) && modificarSecretaria.txtcelular.getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:

                            int select = modificarSecretaria.tablepersona.getSelectedRow();

                            Lista_Secretaria.get(select).setNombre(modificarSecretaria.txtnombre.getText());
                            Lista_Secretaria.get(select).setCorreo(modificarSecretaria.txtcorreo.getText());
                            Lista_Secretaria.get(select).setDireccion(modificarSecretaria.txtdireccion.getText());
                            Lista_Secretaria.get(select).setCelular(modificarSecretaria.txtcelular.getText());
                            Lista_Secretaria.get(select).setHorario(horario);
                            Lista_Secretaria.get(select).setEstado(estado);
                            Lista_Secretaria.get(select).setImagen(Imagen);
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
            } else if (!(Lista_Secretaria.size() <= 0) && Lista_cliente.size() <= 0 && Lista_abogado.size() <= 0 && !modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarSecretaria.txtcorreo.getText()) && modificarSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarSecretaria.tablepersona.getSelectedRow();

                                Lista_Secretaria.get(select).setNombre(modificarSecretaria.txtnombre.getText());
                                Lista_Secretaria.get(select).setCorreo(modificarSecretaria.txtcorreo.getText());
                                Lista_Secretaria.get(select).setDireccion(modificarSecretaria.txtdireccion.getText());
                                Lista_Secretaria.get(select).setCelular(modificarSecretaria.txtcelular.getText());
                                Lista_Secretaria.get(select).setHorario(horario);
                                Lista_Secretaria.get(select).setEstado(estado);
                                Lista_Secretaria.get(select).setImagen(Imagen);
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
            } else if (!(Lista_Secretaria.size() <= 0) && !(Lista_cliente.size() <= 0) && Lista_abogado.size() <= 0 && !modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarSecretaria.txtcorreo.getText()) && modificarSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarSecretaria.tablepersona.getSelectedRow();

                                Lista_Secretaria.get(select).setNombre(modificarSecretaria.txtnombre.getText());
                                Lista_Secretaria.get(select).setCorreo(modificarSecretaria.txtcorreo.getText());
                                Lista_Secretaria.get(select).setDireccion(modificarSecretaria.txtdireccion.getText());
                                Lista_Secretaria.get(select).setCelular(modificarSecretaria.txtcelular.getText());
                                Lista_Secretaria.get(select).setHorario(horario);
                                Lista_Secretaria.get(select).setEstado(estado);
                                Lista_Secretaria.get(select).setImagen(Imagen);
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
            } else if (!(Lista_Secretaria.size() <= 0) && Lista_cliente.size() <= 0 && !(Lista_abogado.size() <= 0) && !modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarSecretaria.txtcorreo.getText()) && modificarSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarSecretaria.tablepersona.getSelectedRow();

                                Lista_Secretaria.get(select).setNombre(modificarSecretaria.txtnombre.getText());
                                Lista_Secretaria.get(select).setCorreo(modificarSecretaria.txtcorreo.getText());
                                Lista_Secretaria.get(select).setDireccion(modificarSecretaria.txtdireccion.getText());
                                Lista_Secretaria.get(select).setCelular(modificarSecretaria.txtcelular.getText());
                                Lista_Secretaria.get(select).setHorario(horario);
                                Lista_Secretaria.get(select).setEstado(estado);
                                Lista_Secretaria.get(select).setImagen(Imagen);
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
            } else if (Lista_Secretaria.size() <= 0 && !(Lista_cliente.size() <= 0) && !(Lista_abogado.size() <= 0) && !modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarSecretaria.txtcorreo.getText()) && modificarSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarSecretaria.tablepersona.getSelectedRow();

                                Lista_Secretaria.get(select).setNombre(modificarSecretaria.txtnombre.getText());
                                Lista_Secretaria.get(select).setCorreo(modificarSecretaria.txtcorreo.getText());
                                Lista_Secretaria.get(select).setDireccion(modificarSecretaria.txtdireccion.getText());
                                Lista_Secretaria.get(select).setCelular(modificarSecretaria.txtcelular.getText());
                                Lista_Secretaria.get(select).setHorario(horario);
                                Lista_Secretaria.get(select).setEstado(estado);
                                Lista_Secretaria.get(select).setImagen(Imagen);
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
            } else if (Lista_Secretaria.isEmpty() && Lista_cliente.isEmpty() && !(Lista_abogado.size() <= 0) && !modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarSecretaria.txtcorreo.getText()) && modificarSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarSecretaria.tablepersona.getSelectedRow();

                                Lista_Secretaria.get(select).setNombre(modificarSecretaria.txtnombre.getText());
                                Lista_Secretaria.get(select).setCorreo(modificarSecretaria.txtcorreo.getText());
                                Lista_Secretaria.get(select).setDireccion(modificarSecretaria.txtdireccion.getText());
                                Lista_Secretaria.get(select).setCelular(modificarSecretaria.txtcelular.getText());
                                Lista_Secretaria.get(select).setHorario(horario);
                                Lista_Secretaria.get(select).setEstado(estado);
                                Lista_Secretaria.get(select).setImagen(Imagen);
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
            } else if (Lista_Secretaria.isEmpty() && !(Lista_cliente.size() <= 0) && Lista_abogado.isEmpty() && !modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
                if (Validar_Correo() == true) {
                    if (Validar_Correo(modificarSecretaria.txtcorreo.getText()) && modificarSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:

                                int select = modificarSecretaria.tablepersona.getSelectedRow();

                                Lista_Secretaria.get(select).setNombre(modificarSecretaria.txtnombre.getText());
                                Lista_Secretaria.get(select).setCorreo(modificarSecretaria.txtcorreo.getText());
                                Lista_Secretaria.get(select).setDireccion(modificarSecretaria.txtdireccion.getText());
                                Lista_Secretaria.get(select).setCelular(modificarSecretaria.txtcelular.getText());
                                Lista_Secretaria.get(select).setHorario(horario);
                                Lista_Secretaria.get(select).setEstado(estado);
                                Lista_Secretaria.get(select).setImagen(Imagen);
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
        if (evt.getSource() == modificarSecretaria.btnimagen) {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("C:\\Users\\ACER\\OneDrive\\Escritorio\\ACTIVIDAD_PRODUCTOS\\REGISTRO_PRODUCTOS"));
            file.showOpenDialog(modificarSecretaria);
            File archivo = file.getSelectedFile();
            Dest = "src\\Imagenes_Secretarias\\" + archivo.getName();
            Orig = archivo.getPath();
            Imagen = archivo.getName();

            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(modificarSecretaria.lafoto.getWidth(), modificarSecretaria.lafoto.getHeight(), Image.SCALE_DEFAULT));
            modificarSecretaria.lafoto.setText(null);
            modificarSecretaria.lafoto.setIcon(icono);

            Campo_Vacio();
        }
        if (evt.getSource() == modificarSecretaria.btnmodificar) {

            modificarSecretaria.cb1.setEnabled(true);
            modificarSecretaria.cb2.setEnabled(true);
            modificarSecretaria.cb3.setEnabled(true);
            modificarSecretaria.cb4.setEnabled(true);
            modificarSecretaria.txtnombre.setEditable(true);
            modificarSecretaria.txtcorreo.setEditable(true);
            modificarSecretaria.txtcelular.setEditable(true);
            modificarSecretaria.txtdireccion.setEditable(true);
            modificarSecretaria.cbestado.setEnabled(true);
            modificarSecretaria.btnimagen.setEnabled(true);
            modificarSecretaria.nacimeinto.setEditable(false);
            modificarSecretaria.txtbuscar.setEditable(false);
            modificarSecretaria.btnelimina.setEnabled(false);
            modificarSecretaria.btnimagen.setEnabled(true);
            modificarSecretaria.btncancelar.setEnabled(true);
            modificarSecretaria.btnmodificar.setEnabled(false);
        }
        if (evt.getSource() == modificarSecretaria.cbestado) {
            if (modificarSecretaria.cbestado.isEnabled() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarSecretaria.cb1) {
            if (modificarSecretaria.cb1.isEnabled() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarSecretaria.cb2) {
            if (modificarSecretaria.cb2.isEnabled() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarSecretaria.cb3) {
            if (modificarSecretaria.cb3.isEnabled() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarSecretaria.cb4) {
            if (modificarSecretaria.cb4.isEnabled() == true) {
                Campo_Vacio();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {

        if (evt.getSource() == modificarSecretaria.txtcelular) {

            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && modificarSecretaria.txtcelular.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarSecretaria.txtnombre) {
            char c = evt.getKeyChar();

            if ((c < 'a' && c < 'z') && (c < 'A' && c < 'Z')) {
                evt.consume();
            }
        }
        if (evt.getSource() == modificarSecretaria.txtbuscar) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && modificarSecretaria.txtbuscar.getText().length() <= 9) {

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
        if (evt.getSource() == modificarSecretaria.txtbuscar) {
            Datos();
        }
        if (evt.getSource() == modificarSecretaria.txtcelular) {
            if (modificarSecretaria.txtcelular.isEditable() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarSecretaria.txtcorreo) {
            if (modificarSecretaria.txtcorreo.isEditable() == true) {
                Campo_Vacio();
            }

            if (Validar_Correo(modificarSecretaria.txtcorreo.getText())) {

                modificarSecretaria.correo.setVisible(false);
            } else {

                if (modificarSecretaria.lacorreo1.isShowing() == true) {

                    modificarSecretaria.correo.setVisible(false);
                } else {
                    modificarSecretaria.correo.setVisible(true);
                }
            }
        }
        if (evt.getSource() == modificarSecretaria.txtdireccion) {
            if (modificarSecretaria.txtdireccion.isEditable() == true) {
                Campo_Vacio();
            }
        }
        if (evt.getSource() == modificarSecretaria.txtnombre) {
            if (modificarSecretaria.txtnombre.isEditable() == true) {
                Campo_Vacio();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {

    }

    @Override
    public void mousePressed(MouseEvent evt) {
        if (evt.getSource() == modificarSecretaria.tablepersona) {
            int select = modificarSecretaria.tablepersona.getSelectedRow();

            if (select != -1) {

                modificarSecretaria.txtbuscar.setEditable(true);
                modificarSecretaria.cb1.setSelected(false);
                modificarSecretaria.cb2.setSelected(false);
                modificarSecretaria.cb3.setSelected(false);
                modificarSecretaria.cb4.setSelected(false);
                modificarSecretaria.txtnombre.setText(Lista_Secretaria.get(select).getNombre());
                modificarSecretaria.txtapellido.setText(Lista_Secretaria.get(select).getApellidos());
                modificarSecretaria.txtcedula.setText(Lista_Secretaria.get(select).getCedula());
                cedula = Lista_Secretaria.get(select).getCedula();
                modificarSecretaria.txtcorreo.setText(Lista_Secretaria.get(select).getCorreo());
                modificarSecretaria.txtcelular.setText(Lista_Secretaria.get(select).getCelular());
                modificarSecretaria.txtdireccion.setText(Lista_Secretaria.get(select).getDireccion());
                modificarSecretaria.cbestado.setSelectedItem(Lista_Secretaria.get(select).getEstado());
                if (Lista_Secretaria.get(select).getHorario().equals("9:00-13:00")) {
                    modificarSecretaria.cb1.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("13:00-15:00")) {
                    modificarSecretaria.cb2.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("15:00-16:30")) {
                    modificarSecretaria.cb3.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("16:30-18:30")) {
                    modificarSecretaria.cb4.setSelected(true);
                }

                //MAS DE DOS OPCIONES
                if (Lista_Secretaria.get(select).getHorario().equals("9:00-13:0013:00-15:00")) {
                    modificarSecretaria.cb1.setSelected(true);
                    modificarSecretaria.cb2.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("9:00-13:0015:00-16:30")) {
                    modificarSecretaria.cb1.setSelected(true);
                    modificarSecretaria.cb3.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("9:00-13:0016:30-18:30")) {
                    modificarSecretaria.cb1.setSelected(true);
                    modificarSecretaria.cb4.setSelected(true);
                }

                if (Lista_Secretaria.get(select).getHorario().equals("13:00-15:0015:00-16:30")) {
                    modificarSecretaria.cb2.setSelected(true);
                    modificarSecretaria.cb3.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("15:00-16:3016:30-18:30")) {
                    modificarSecretaria.cb3.setSelected(true);
                    modificarSecretaria.cb4.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("13:00-15:0016:30-18:30")) {
                    modificarSecretaria.cb2.setSelected(true);
                    modificarSecretaria.cb4.setSelected(true);
                }

                if (Lista_Secretaria.get(select).getHorario().equals("9:00-13:0013:00-15:0015:00-16:30")) {
                    modificarSecretaria.cb1.setSelected(true);
                    modificarSecretaria.cb2.setSelected(true);
                    modificarSecretaria.cb3.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("9:00-13:0013:00-15:0016:30-18:30")) {
                    modificarSecretaria.cb1.setSelected(true);
                    modificarSecretaria.cb2.setSelected(true);
                    modificarSecretaria.cb4.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("13:00-15:0015:00-16:3016:30-18:30")) {
                    modificarSecretaria.cb2.setSelected(true);
                    modificarSecretaria.cb3.setSelected(true);
                    modificarSecretaria.cb4.setSelected(true);
                }
                if (Lista_Secretaria.get(select).getHorario().equals("9:00-13:0013:00-15:0015:00-16:3016:30-18:30")) {
                    modificarSecretaria.cb1.setSelected(true);
                    modificarSecretaria.cb2.setSelected(true);
                    modificarSecretaria.cb3.setSelected(true);
                    modificarSecretaria.cb4.setSelected(true);
                }

                modificarSecretaria.nacimeinto.setText(Lista_Secretaria.get(select).getNacimiento());
                Imagen = Lista_Secretaria.get(select).getImagen();
                Orig = "src/Imagenes_Secretarias/" + Imagen;
                ImageIcon icon = new ImageIcon(Orig);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(modificarSecretaria.lafoto.getWidth(), modificarSecretaria.lafoto.getHeight(), Image.SCALE_DEFAULT));
                modificarSecretaria.lafoto.setText(null);
                modificarSecretaria.lafoto.setIcon(icono);
                modificarSecretaria.btnimagen.setEnabled(false);
                modificarSecretaria.btnmodificar.setEnabled(true);
                modificarSecretaria.btnelimina.setEnabled(true);
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

    public void cargarDatos() {
        modificarSecretaria.tablepersona.setDefaultEditor(Object.class, null);
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
        modelo.addColumn("HORARIO");
        for (Secretaria persona : Lista_Secretaria) {

            Object[] fila = new Object[9];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellidos();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getNacimiento();
            fila[5] = persona.getCelular();
            fila[6] = persona.getDireccion();
            fila[7] = persona.getHorario();
            modelo.addRow(fila);
        }
        modificarSecretaria.tablepersona.setModel(modelo);
        modificarSecretaria.tablepersona.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        modificarSecretaria.tablepersona.setRowSorter(sorter);
        Nuevo();
    }

    public void estado_civil() {
        modificarSecretaria.cbestado.addItem("Seleccionar");
        modificarSecretaria.cbestado.addItem("Soltero");
        modificarSecretaria.cbestado.addItem("Casado");
        modificarSecretaria.cbestado.addItem("Divorciado");
    }

    public void Campo_Vacio() {
        String estado = (String) modificarSecretaria.cbestado.getSelectedItem();
        if (modificarSecretaria.txtnombre.getText().isEmpty()) {
            modificarSecretaria.lanombre1.setVisible(true);
        }

        if (modificarSecretaria.txtcelular.getText().isEmpty()) {
            modificarSecretaria.lacelular1.setVisible(true);
        }

        if (modificarSecretaria.txtcorreo.getText().isEmpty()) {
            modificarSecretaria.lacorreo1.setVisible(true);
        }

        if (modificarSecretaria.txtdireccion.getText().isEmpty()) {
            modificarSecretaria.ladireccion1.setVisible(true);
        }

        if (estado.equals("Seleccionar")) {
            modificarSecretaria.laestado1.setVisible(true);
        }

        if (!(modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
            modificarSecretaria.lahorario1.setVisible(true);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!modificarSecretaria.txtnombre.getText().isEmpty()) {
            modificarSecretaria.lanombre1.setVisible(false);
        }

        if (!modificarSecretaria.txtcelular.getText().isEmpty()) {
            modificarSecretaria.lacelular1.setVisible(false);
        }

        if (!modificarSecretaria.txtcorreo.getText().isEmpty()) {
            modificarSecretaria.lacorreo1.setVisible(false);
        }

        if (!modificarSecretaria.txtdireccion.getText().isEmpty()) {
            modificarSecretaria.ladireccion1.setVisible(false);
        }

        if (!estado.equals("Seleccionar")) {
            modificarSecretaria.laestado1.setVisible(false);
        }

        if ((modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
            modificarSecretaria.lahorario1.setVisible(false);
        }

        if (modificarSecretaria.lacelular1.isShowing() == true) {
            modificarSecretaria.celular.setVisible(false);
        } else if (!verificarCedula(modificarSecretaria.txtcedula.getText())) {
            modificarSecretaria.celular.setVisible(true);
        } else if (verificarCedula(modificarSecretaria.txtcedula.getText())) {
            modificarSecretaria.celular.setVisible(false);
        }

        if (!modificarSecretaria.txtnombre.getText().isEmpty() && !modificarSecretaria.txtcorreo.getText().isEmpty() && !(modificarSecretaria.lafoto.getIcon() == null) && !modificarSecretaria.txtdireccion.getText().isEmpty() && !modificarSecretaria.txtcelular.getText().isEmpty() && !estado.equals("Seleccionar") && (modificarSecretaria.cb1.isSelected() || modificarSecretaria.cb2.isSelected() || modificarSecretaria.cb3.isSelected() || modificarSecretaria.cb4.isSelected())) {
            modificarSecretaria.btnguardar.setEnabled(true);
        } else {
            modificarSecretaria.btnguardar.setEnabled(false);
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

        modificarSecretaria.celular.setVisible(false);
        modificarSecretaria.lanombre1.setVisible(false);
        modificarSecretaria.lacorreo1.setVisible(false);
        modificarSecretaria.lacelular1.setVisible(false);
        modificarSecretaria.lahorario1.setVisible(false);
        modificarSecretaria.laestado1.setVisible(false);
        modificarSecretaria.ladireccion1.setVisible(false);
        modificarSecretaria.correo.setVisible(false);
        modificarSecretaria.btnguardar.setEnabled(false);
        modificarSecretaria.btnmodificar.setEnabled(false);
        modificarSecretaria.btnimagen.setEnabled(false);
        modificarSecretaria.btncancelar.setEnabled(false);
    }

    public void Nuevo() {
        modificarSecretaria.btnguardar.setEnabled(false);
        modificarSecretaria.btnelimina.setEnabled(false);
        modificarSecretaria.txtnombre.setEditable(false);
        modificarSecretaria.txtcedula.setEditable(false);
        modificarSecretaria.txtapellido.setEditable(false);
        modificarSecretaria.cbestado.setEnabled(false);
        modificarSecretaria.txtcelular.setEditable(false);
        modificarSecretaria.txtdireccion.setEditable(false);
        modificarSecretaria.txtcorreo.setEditable(false);
        modificarSecretaria.cb1.setEnabled(false);
        modificarSecretaria.cb2.setEnabled(false);
        modificarSecretaria.cb3.setEnabled(false);
        modificarSecretaria.cb4.setEnabled(false);
        modificarSecretaria.nacimeinto.setEditable(false);
        modificarSecretaria.txtcedula.setText("");
        modificarSecretaria.txtnombre.setText("");
        modificarSecretaria.cbestado.setSelectedIndex(0);
        modificarSecretaria.txtapellido.setText("");
        modificarSecretaria.txtcelular.setText("");
        modificarSecretaria.txtdireccion.setText("");
        modificarSecretaria.txtcorreo.setText("");
        modificarSecretaria.cb1.setSelected(false);
        modificarSecretaria.cb2.setSelected(false);
        modificarSecretaria.cb3.setSelected(false);
        modificarSecretaria.cb4.setSelected(false);
        modificarSecretaria.nacimeinto.setText("");
        modificarSecretaria.lafoto.setIcon(null);
    }

    public void Actualizar_Tabla() {

        for (Secretaria persona : Lista_Secretaria) {

            Object[] fila = new Object[8];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellidos();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getNacimiento();
            fila[5] = persona.getCelular();
            fila[6] = persona.getDireccion();
            fila[7] = persona.getHorario();
            modelo.addRow(fila);
        }
        modificarSecretaria.tablepersona.setModel(modelo);
    }

    public void Limpiar_Tabla() {

        modelo.setRowCount(0);
        modificarSecretaria.txtcedula.setText("");
        modificarSecretaria.txtnombre.setText("");
        modificarSecretaria.cbestado.setSelectedIndex(0);
        modificarSecretaria.txtapellido.setText("");
        modificarSecretaria.txtcelular.setText("");
        modificarSecretaria.txtdireccion.setText("");
        modificarSecretaria.txtcorreo.setText("");
        modificarSecretaria.cb1.setSelected(false);
        modificarSecretaria.cb2.setSelected(false);
        modificarSecretaria.cb3.setSelected(false);
        modificarSecretaria.cb4.setSelected(false);
        modificarSecretaria.nacimeinto.setText("");
    }

    public boolean Validar_Correo() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCorreo().equalsIgnoreCase(modificarSecretaria.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCorreo().equalsIgnoreCase(modificarSecretaria.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCorreo().equalsIgnoreCase(modificarSecretaria.txtcorreo.getText())) {
                return false;
            }
        }
        return true;
    }

    private void Datos() {

        try {
            sorter.setRowFilter(RowFilter.regexFilter(modificarSecretaria.txtbuscar.getText(), 0));

        } catch (Exception e) {
        }
    }

    public boolean Validar_Correo(String correo) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher valida = patron.matcher(correo);

        return valida.find();
    }
}
