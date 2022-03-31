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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Abogado;
import vista.RegistroAbogado;
import static vista.RegistroAbogado.Lista_abogado;
import static vista.RegistroCliente.Lista_cliente;
import static vista.RegistroSecretaria.Lista_Secretaria;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Abogado implements ActionListener, KeyListener {

    RegistroAbogado registroAbogado;

    

    protected static String Imagen, Dest, Orig;

    public C_Registro_Abogado(RegistroAbogado registroAbogado) {
        this.registroAbogado = registroAbogado;
        this.registroAbogado.btncancelar.addActionListener(this);
        this.registroAbogado.btnguardar.addActionListener(this);
        this.registroAbogado.btnimagen.addActionListener(this);
        this.registroAbogado.btnnuevo.addActionListener(this);
        this.registroAbogado.cbestado.addActionListener(this);
        this.registroAbogado.cb1.addActionListener(this);
        this.registroAbogado.cb2.addActionListener(this);
        this.registroAbogado.cb3.addActionListener(this);
        this.registroAbogado.cb4.addActionListener(this);

        this.registroAbogado.txtnombre.addKeyListener(this);
        this.registroAbogado.txtcorreo.addKeyListener(this);
        this.registroAbogado.txtapellido.addKeyListener(this);
        this.registroAbogado.txtcedula.addKeyListener(this);
        this.registroAbogado.txtcelular.addKeyListener(this);
        this.registroAbogado.txtcuenta.addKeyListener(this);
        this.registroAbogado.txtmatricula.addKeyListener(this);
        this.registroAbogado.txtdireccion.addKeyListener(this);
        this.registroAbogado.jDateChooser1.addKeyListener(this);

        estado_civil();
        this.registroAbogado.setTitle("ABOGADOS");
        Nuevo();
        Campos();

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == registroAbogado.btncancelar) {
            String estado = (String) registroAbogado.cbestado.getSelectedItem();
            if (!registroAbogado.txtcedula.getText().equals("") || !registroAbogado.txtnombre.getText().equals("") || !registroAbogado.txtapellido.getText().equals("") || !(registroAbogado.jDateChooser1.getDate() == null) || !registroAbogado.txtcelular.getText().equals("") || !registroAbogado.txtcuenta.getText().equals("") || !registroAbogado.txtcorreo.getText().equals("") || !registroAbogado.txtdireccion.getText().equals("") || !estado.equals("Seleccionar") || !registroAbogado.txtmatricula.getText().equals("") || (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
                switch (salir) {
                    case 0:
                        Cancelar();
                        Nuevo();
                        Campos();
                        registroAbogado.btncancelar.setEnabled(false);
                        registroAbogado.btnnuevo.setEnabled(true);
                        break;
                    case 1:
                        Campo_Vacio();
                        break;
                }
            }
        }
        if (evt.getSource() == registroAbogado.btnimagen) {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(registroAbogado);
            File archivo = file.getSelectedFile();
            Dest = "src\\Imagenes_Abogados\\" + archivo.getName();
            Orig = archivo.getPath();
            Imagen = archivo.getName();

            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(registroAbogado.lafoto.getWidth(), registroAbogado.lafoto.getHeight(), Image.SCALE_DEFAULT));
            registroAbogado.lafoto.setText(null);
            registroAbogado.lafoto.setIcon(icono);

            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.btnnuevo) {
            registroAbogado.btnimagen.setEnabled(true);
            registroAbogado.txtnombre.setEditable(true);
            registroAbogado.txtcedula.setEditable(true);
            registroAbogado.txtapellido.setEditable(true);
            registroAbogado.cbestado.setEnabled(true);
            registroAbogado.txtcelular.setEditable(true);
            registroAbogado.txtcuenta.setEditable(true);
            registroAbogado.txtdireccion.setEditable(true);
            registroAbogado.txtmatricula.setEditable(true);
            registroAbogado.txtcorreo.setEditable(true);
            registroAbogado.cb1.setEnabled(true);
            registroAbogado.cb2.setEnabled(true);
            registroAbogado.cb3.setEnabled(true);
            registroAbogado.cb4.setEnabled(true);
            registroAbogado.jDateChooser1.setEnabled(true);
            registroAbogado.btnnuevo.setEnabled(false);
        }
        if (evt.getSource() == registroAbogado.cbestado) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.cb1) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.cb2) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.cb3) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.cb4) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.btnguardar) {
            if (!(registroAbogado.lafoto.getIcon() == null)) {
                try {

                    Path Destino = Paths.get(Dest);
                    Path Origen = Paths.get(Orig);
                    Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    Logger.getLogger(RegistroAbogado.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            String horario = "";
            if (registroAbogado.cb1.isSelected() == true) {

                horario = horario + registroAbogado.cb1.getText();
            }
            if (registroAbogado.cb2.isSelected() == true) {

                horario = horario + registroAbogado.cb2.getText();
            }
            if (registroAbogado.cb3.isSelected() == true) {

                horario = horario + registroAbogado.cb3.getText();
            }
            if (registroAbogado.cb4.isSelected() == true) {

                horario = horario + registroAbogado.cb4.getText();
            }

            String estado = (String) registroAbogado.cbestado.getSelectedItem();
            String fechas = "";
            if (!(registroAbogado.jDateChooser1.getDate() == null)) {
                Date fecha = registroAbogado.jDateChooser1.getDate();
                DateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
                fechas = Formato.format(fecha);
            }

            Abogado AB = new Abogado(registroAbogado.txtcedula.getText(), registroAbogado.txtnombre.getText(), registroAbogado.txtapellido.getText(), registroAbogado.txtcorreo.getText(), registroAbogado.txtdireccion.getText(), registroAbogado.txtcelular.getText(), estado, fechas, registroAbogado.txtmatricula.getText(), registroAbogado.txtcuenta.getText(), horario, Imagen);

            if (!registroAbogado.txtcedula.getText().equals("") && !registroAbogado.txtnombre.getText().equals("") && !registroAbogado.txtapellido.getText().equals("") && !(registroAbogado.lafoto.getIcon() == null) && !(registroAbogado.jDateChooser1.getDate() == null) && !registroAbogado.txtcelular.getText().equals("") && !registroAbogado.txtcuenta.getText().equals("") && !registroAbogado.txtcorreo.getText().equals("") && !registroAbogado.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && !registroAbogado.txtmatricula.getText().equals("") && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                if (!Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !Lista_cliente.isEmpty()) {
                    if (Validar_Cedula() == true && Validar_Correo() == true && Validar_Matricula() == true) {
                        if (Validar_Correo(registroAbogado.txtcorreo.getText()) && verificarCedula(registroAbogado.txtcedula.getText()) && registroAbogado.txtcelular.getText().length() == 10) {
                            int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:
                                    Nuevo();
                                    Lista_abogado.add(AB);
                                    Campos();
                                    registroAbogado.btncancelar.setEnabled(false);
                                    registroAbogado.btnnuevo.setEnabled(true);
                                    break;
                                case 1:
                                    Campo_Vacio();
                                    JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
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

            if (Lista_abogado.size() <= 0 && Lista_Secretaria.size() <= 0 && Lista_cliente.size() <= 0 && !registroAbogado.txtcedula.getText().equals("") && !registroAbogado.txtnombre.getText().equals("") && !(registroAbogado.lafoto.getIcon() == null) && !registroAbogado.txtapellido.getText().equals("") && !(registroAbogado.jDateChooser1.getDate() == null) && !registroAbogado.txtcelular.getText().equals("") && !registroAbogado.txtcuenta.getText().equals("") && !registroAbogado.txtcorreo.getText().equals("") && !registroAbogado.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && !registroAbogado.txtmatricula.getText().equals("") && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                if (Validar_Correo(registroAbogado.txtcorreo.getText()) && verificarCedula(registroAbogado.txtcedula.getText()) && registroAbogado.txtcelular.getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:
                            Nuevo();
                            Lista_abogado.add(AB);
                            Campos();
                            registroAbogado.btncancelar.setEnabled(false);
                            registroAbogado.btnnuevo.setEnabled(true);
                            break;
                        case 1:
                            Campo_Vacio();
                            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                            break;
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (!(Lista_abogado.size() <= 0) && Lista_Secretaria.size() <= 0 && Lista_cliente.size() <= 0 && !registroAbogado.txtcedula.getText().equals("") && !(registroAbogado.lafoto.getIcon() == null) && !registroAbogado.txtnombre.getText().equals("") && !registroAbogado.txtapellido.getText().equals("") && !(registroAbogado.jDateChooser1.getDate() == null) && !registroAbogado.txtcelular.getText().equals("") && !registroAbogado.txtcuenta.getText().equals("") && !registroAbogado.txtcorreo.getText().equals("") && !registroAbogado.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && !registroAbogado.txtmatricula.getText().equals("") && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true && Validar_Matricula() == true) {
                    if (Validar_Correo(registroAbogado.txtcorreo.getText()) && verificarCedula(registroAbogado.txtcedula.getText()) && registroAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Nuevo();
                                Lista_abogado.add(AB);
                                Campos();
                                registroAbogado.btncancelar.setEnabled(false);
                                registroAbogado.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
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

            } else if (!(Lista_abogado.size() <= 0) && !(Lista_Secretaria.size() <= 0) && Lista_cliente.size() <= 0 && !registroAbogado.txtcedula.getText().equals("") && !(registroAbogado.lafoto.getIcon() == null) && !registroAbogado.txtnombre.getText().equals("") && !registroAbogado.txtapellido.getText().equals("") && !(registroAbogado.jDateChooser1.getDate() == null) && !registroAbogado.txtcelular.getText().equals("") && !registroAbogado.txtcuenta.getText().equals("") && !registroAbogado.txtcorreo.getText().equals("") && !registroAbogado.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && !registroAbogado.txtmatricula.getText().equals("") && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true && Validar_Matricula() == true) {
                    if (Validar_Correo(registroAbogado.txtcorreo.getText()) && verificarCedula(registroAbogado.txtcedula.getText()) && registroAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Nuevo();
                                Lista_abogado.add(AB);
                                Campos();
                                registroAbogado.btncancelar.setEnabled(false);
                                registroAbogado.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
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

            } else if (!(Lista_abogado.size() <= 0) && Lista_Secretaria.size() <= 0 && !(Lista_cliente.size() <= 0) && !registroAbogado.txtcedula.getText().equals("") && !(registroAbogado.lafoto.getIcon() == null) && !registroAbogado.txtnombre.getText().equals("") && !registroAbogado.txtapellido.getText().equals("") && !(registroAbogado.jDateChooser1.getDate() == null) && !registroAbogado.txtcelular.getText().equals("") && !registroAbogado.txtcuenta.getText().equals("") && !registroAbogado.txtcorreo.getText().equals("") && !registroAbogado.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && !registroAbogado.txtmatricula.getText().equals("") && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true && Validar_Matricula() == true) {
                    if (Validar_Correo(registroAbogado.txtcorreo.getText()) && verificarCedula(registroAbogado.txtcedula.getText()) && registroAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Nuevo();
                                Lista_abogado.add(AB);
                                Campos();
                                registroAbogado.btncancelar.setEnabled(false);
                                registroAbogado.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
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
            } else if (Lista_abogado.size() <= 0 && !(Lista_Secretaria.size() <= 0) && !(Lista_cliente.size() <= 0) && !registroAbogado.txtcedula.getText().equals("") && !(registroAbogado.lafoto.getIcon() == null) && !registroAbogado.txtnombre.getText().equals("") && !registroAbogado.txtapellido.getText().equals("") && !(registroAbogado.jDateChooser1.getDate() == null) && !registroAbogado.txtcelular.getText().equals("") && !registroAbogado.txtcuenta.getText().equals("") && !registroAbogado.txtcorreo.getText().equals("") && !registroAbogado.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && !registroAbogado.txtmatricula.getText().equals("") && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true && Validar_Matricula() == true) {
                    if (Validar_Correo(registroAbogado.txtcorreo.getText()) && verificarCedula(registroAbogado.txtcedula.getText()) && registroAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Nuevo();
                                Lista_abogado.add(AB);
                                Campos();
                                registroAbogado.btncancelar.setEnabled(false);
                                registroAbogado.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
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
            } else if (Lista_abogado.isEmpty() && Lista_Secretaria.isEmpty() && !(Lista_cliente.size() <= 0) && !registroAbogado.txtcedula.getText().equals("") && !(registroAbogado.lafoto.getIcon() == null) && !registroAbogado.txtnombre.getText().equals("") && !registroAbogado.txtapellido.getText().equals("") && !(registroAbogado.jDateChooser1.getDate() == null) && !registroAbogado.txtcelular.getText().equals("") && !registroAbogado.txtcuenta.getText().equals("") && !registroAbogado.txtcorreo.getText().equals("") && !registroAbogado.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && !registroAbogado.txtmatricula.getText().equals("") && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true && Validar_Matricula() == true) {
                    if (Validar_Correo(registroAbogado.txtcorreo.getText()) && verificarCedula(registroAbogado.txtcedula.getText()) && registroAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Nuevo();
                                Lista_abogado.add(AB);
                                Campos();
                                registroAbogado.btncancelar.setEnabled(false);
                                registroAbogado.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
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
            } else if (Lista_abogado.isEmpty() && !Lista_Secretaria.isEmpty() && Lista_cliente.isEmpty() && !registroAbogado.txtcedula.getText().equals("") && !registroAbogado.txtnombre.getText().equals("") && !(registroAbogado.lafoto.getIcon() == null) && !registroAbogado.txtapellido.getText().equals("") && !(registroAbogado.jDateChooser1.getDate() == null) && !registroAbogado.txtcelular.getText().equals("") && !registroAbogado.txtcuenta.getText().equals("") && !registroAbogado.txtcorreo.getText().equals("") && !registroAbogado.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && !registroAbogado.txtmatricula.getText().equals("") && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true && Validar_Matricula() == true) {
                    if (Validar_Correo(registroAbogado.txtcorreo.getText()) && verificarCedula(registroAbogado.txtcedula.getText()) && registroAbogado.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Nuevo();
                                Lista_abogado.add(AB);
                                Campos();
                                registroAbogado.btncancelar.setEnabled(false);
                                registroAbogado.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
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
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == registroAbogado.txtnombre) {
            int key = evt.getKeyChar();
            if (registroAbogado.txtnombre.getText().length() <= 20) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;
                if (!letra) {
                    evt.consume();
                }
            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == registroAbogado.txtcelular) {
            char c = evt.getKeyChar();
            if (c >= '0' && c <= '9' && registroAbogado.txtcelular.getText().length() <= 9) {
            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == registroAbogado.txtcuenta) {
            char c = evt.getKeyChar();

            if (c < '0' || c > '9') {
                evt.consume();
            }
        }
        if (evt.getSource() == registroAbogado.txtcedula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && registroAbogado.txtcedula.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == registroAbogado.txtapellido) {
            int key = evt.getKeyChar();

            if (registroAbogado.txtapellido.getText().length() <= 20) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                if (!letra) {

                    evt.consume();
                }

            } else {

                evt.consume();
            }
        }
        if (evt.getSource() == registroAbogado.txtmatricula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && registroAbogado.txtmatricula.getText().length() <= 9) {

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
        if (evt.getSource() == registroAbogado.txtnombre) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.txtcorreo) {
            Campo_Vacio();

            if (Validar_Correo(registroAbogado.txtcorreo.getText())) {

                registroAbogado.correo.setVisible(false);
            } else {

                if (registroAbogado.lacorreo1.isShowing() == true) {

                    registroAbogado.correo.setVisible(false);
                } else {
                    registroAbogado.correo.setVisible(true);
                }
            }

            if (Validar_Correo() == true) {
                registroAbogado.datocorreo.setVisible(false);
            } else {
                registroAbogado.datocorreo.setVisible(true);
            }
        }
        if (evt.getSource() == registroAbogado.txtapellido) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.txtcedula) {
            Campo_Vacio();

            if (Validar_Cedula() == true) {
                registroAbogado.datocedula.setVisible(false);
            } else {
                registroAbogado.datocedula.setVisible(true);
            }
        }
        if (evt.getSource() == registroAbogado.jDateChooser1) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.txtcelular) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.txtcuenta) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.txtdireccion) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroAbogado.txtmatricula) {
            Campo_Vacio();
            if (Validar_Matricula() == true) {
                registroAbogado.datomatricula.setVisible(false);
            } else {
                registroAbogado.datomatricula.setVisible(true);
            }
        }
    }

    public void estado_civil() {
        registroAbogado.cbestado.addItem("Seleccionar");
        registroAbogado.cbestado.addItem("Soltero");
        registroAbogado.cbestado.addItem("Casado");
        registroAbogado.cbestado.addItem("Divorciado");
    }

    public void Nuevo() {
        registroAbogado.btnguardar.setEnabled(false);
        registroAbogado.btnimagen.setEnabled(false);
        registroAbogado.btncancelar.setEnabled(false);
        registroAbogado.txtnombre.setEditable(false);
        registroAbogado.txtcedula.setEditable(false);
        registroAbogado.txtapellido.setEditable(false);
        registroAbogado.cbestado.setEnabled(false);
        registroAbogado.txtcelular.setEditable(false);
        registroAbogado.txtcuenta.setEditable(false);
        registroAbogado.txtdireccion.setEditable(false);
        registroAbogado.txtmatricula.setEditable(false);
        registroAbogado.txtcorreo.setEditable(false);
        registroAbogado.cb1.setEnabled(false);
        registroAbogado.cb2.setEnabled(false);
        registroAbogado.cb3.setEnabled(false);
        registroAbogado.cb4.setEnabled(false);
        registroAbogado.jDateChooser1.setEnabled(false);
        registroAbogado.txtcedula.setText("");
        registroAbogado.txtnombre.setText("");
        registroAbogado.cbestado.setSelectedIndex(0);
        registroAbogado.txtapellido.setText("");
        registroAbogado.txtcelular.setText("");
        registroAbogado.txtcuenta.setText("");
        registroAbogado.txtdireccion.setText("");
        registroAbogado.txtmatricula.setText("");
        registroAbogado.txtcorreo.setText("");
        registroAbogado.cb1.setSelected(false);
        registroAbogado.cb2.setSelected(false);
        registroAbogado.cb3.setSelected(false);
        registroAbogado.cb4.setSelected(false);
        registroAbogado.jDateChooser1.setCalendar(null);
        registroAbogado.lafoto.setIcon(null);
    }

    public void Cancelar() {

        registroAbogado.txtcedula.setText("");
        registroAbogado.txtnombre.setText("");
        registroAbogado.cbestado.setSelectedIndex(0);
        registroAbogado.txtapellido.setText("");
        registroAbogado.txtcelular.setText("");
        registroAbogado.txtcuenta.setText("");
        registroAbogado.txtdireccion.setText("");
        registroAbogado.txtmatricula.setText("");
        registroAbogado.txtcorreo.setText("");
        registroAbogado.cb1.setSelected(false);
        registroAbogado.cb2.setSelected(false);
        registroAbogado.cb3.setSelected(false);
        registroAbogado.cb4.setSelected(false);
        registroAbogado.jDateChooser1.setCalendar(null);
        registroAbogado.lafoto.setIcon(null);
    }

    public void Campo_Vacio() {
        String estado = (String) registroAbogado.cbestado.getSelectedItem();

        if (registroAbogado.txtnombre.getText().isEmpty()) {
            registroAbogado.lanombre1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (registroAbogado.txtapellido.getText().isEmpty()) {
            registroAbogado.laapellido1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (registroAbogado.txtcedula.getText().isEmpty()) {
            registroAbogado.lacedula1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (registroAbogado.txtcelular.getText().isEmpty()) {
            registroAbogado.lacelular1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (registroAbogado.txtcorreo.getText().isEmpty()) {
            registroAbogado.lacorreo1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (registroAbogado.txtcuenta.getText().isEmpty()) {
            registroAbogado.lacuenta1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (registroAbogado.txtdireccion.getText().isEmpty()) {
            registroAbogado.ladireccion1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (registroAbogado.txtmatricula.getText().isEmpty()) {
            registroAbogado.lamatricula1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (estado.equals("Seleccionar")) {
            registroAbogado.laestado1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (!(registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
            registroAbogado.lahorario1.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (!(registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
            registroAbogado.foto.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        if (registroAbogado.jDateChooser1.getDate() == null) {
            registroAbogado.lafecha.setVisible(true);
            registroAbogado.btncancelar.setEnabled(false);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!registroAbogado.txtnombre.getText().isEmpty()) {
            registroAbogado.lanombre1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!registroAbogado.txtapellido.getText().isEmpty()) {
            registroAbogado.laapellido1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!registroAbogado.txtcedula.getText().isEmpty()) {
            registroAbogado.lacedula1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!registroAbogado.txtcelular.getText().isEmpty()) {
            registroAbogado.lacelular1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!registroAbogado.txtcorreo.getText().isEmpty()) {
            registroAbogado.lacorreo1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!registroAbogado.txtcuenta.getText().isEmpty()) {
            registroAbogado.lacuenta1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!registroAbogado.txtdireccion.getText().isEmpty()) {
            registroAbogado.ladireccion1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!registroAbogado.txtmatricula.getText().isEmpty()) {
            registroAbogado.lamatricula1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!estado.equals("Seleccionar")) {
            registroAbogado.laestado1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!(registroAbogado.lafoto.getIcon() == null)) {
            registroAbogado.foto.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if ((registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected())) {
            registroAbogado.lahorario1.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (!(registroAbogado.jDateChooser1.getDate() == null)) {
            registroAbogado.lafecha.setVisible(false);
            registroAbogado.btncancelar.setEnabled(true);
        }

        if (registroAbogado.lacedula1.isShowing() == true) {
            registroAbogado.cedula.setVisible(false);
        } else if (!verificarCedula(registroAbogado.txtcedula.getText())) {
            registroAbogado.cedula.setVisible(true);
        } else if (verificarCedula(registroAbogado.txtcedula.getText())) {
            registroAbogado.cedula.setVisible(false);
        }

        if (registroAbogado.lacelular1.isShowing() == true) {
            registroAbogado.celular.setVisible(false);
        } else if (registroAbogado.txtcelular.getText().length() < 10) {
            registroAbogado.celular.setVisible(true);
        } else if (registroAbogado.txtcelular.getText().length() == 10) {
            registroAbogado.celular.setVisible(false);
        }

        if (!registroAbogado.txtnombre.getText().isEmpty() && !registroAbogado.txtapellido.getText().isEmpty() && !registroAbogado.txtcedula.getText().isEmpty() && !registroAbogado.txtcelular.getText().isEmpty() && !registroAbogado.txtcorreo.getText().isEmpty() && !registroAbogado.txtcuenta.getText().isEmpty() && !registroAbogado.txtdireccion.getText().isEmpty() && !registroAbogado.txtmatricula.getText().isEmpty() && (registroAbogado.cb1.isSelected() || registroAbogado.cb2.isSelected() || registroAbogado.cb3.isSelected() || registroAbogado.cb4.isSelected()) && !estado.equals("Seleccionar") && !(registroAbogado.jDateChooser1.getDate() == null)) {
            registroAbogado.btnguardar.setEnabled(true);
        } else {
            registroAbogado.btnguardar.setEnabled(false);
        }
    }

    public void Campos() {

        registroAbogado.cedula.setVisible(false);
        registroAbogado.celular.setVisible(false);
        registroAbogado.laapellido1.setVisible(false);
        registroAbogado.lanombre1.setVisible(false);
        registroAbogado.lacedula1.setVisible(false);
        registroAbogado.lacorreo1.setVisible(false);
        registroAbogado.lacelular1.setVisible(false);
        registroAbogado.lacuenta1.setVisible(false);
        registroAbogado.lafecha.setVisible(false);
        registroAbogado.lahorario1.setVisible(false);
        registroAbogado.lamatricula1.setVisible(false);
        registroAbogado.laestado1.setVisible(false);
        registroAbogado.ladireccion1.setVisible(false);
        registroAbogado.correo.setVisible(false);
        registroAbogado.btnguardar.setEnabled(false);
        registroAbogado.datocedula.setVisible(false);
        registroAbogado.datocorreo.setVisible(false);
        registroAbogado.datomatricula.setVisible(false);
        registroAbogado.foto.setVisible(false);
    }

    public boolean Validar_Cedula() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCedula().equalsIgnoreCase(registroAbogado.txtcedula.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCedula().equalsIgnoreCase(registroAbogado.txtcedula.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCedula().equalsIgnoreCase(registroAbogado.txtcedula.getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Correo() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCorreo().equalsIgnoreCase(registroAbogado.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCorreo().equalsIgnoreCase(registroAbogado.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCorreo().equalsIgnoreCase(registroAbogado.txtcorreo.getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Matricula() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getNum_matricula().equalsIgnoreCase(registroAbogado.txtmatricula.getText())) {
                return false;
            }
        }
        return true;
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

    public boolean Validar_Correo(String correo) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher valida = patron.matcher(correo);

        return valida.find();
    }

}
