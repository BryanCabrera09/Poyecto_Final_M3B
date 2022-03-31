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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Secretaria;
import static vista.RegistroAbogado.Lista_abogado;
import static vista.RegistroCliente.Lista_cliente;
import vista.RegistroSecretaria;
import static vista.RegistroSecretaria.Lista_Secretaria;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Secretaria implements ActionListener, KeyListener {

    protected static String Imagen = "", Dest, Orig;
    RegistroSecretaria registroSecretaria;

    public C_Registro_Secretaria(RegistroSecretaria registroSecretaria) {
        this.registroSecretaria = registroSecretaria;
        this.registroSecretaria.btncancelar.addActionListener(this);
        this.registroSecretaria.btnguardar.addActionListener(this);
        this.registroSecretaria.btnimagen.addActionListener(this);
        this.registroSecretaria.btnnuevo.addActionListener(this);
        this.registroSecretaria.cbestado.addActionListener(this);
        this.registroSecretaria.cb1.addActionListener(this);
        this.registroSecretaria.cb2.addActionListener(this);
        this.registroSecretaria.cb3.addActionListener(this);
        this.registroSecretaria.cb4.addActionListener(this);

        this.registroSecretaria.txtapellido.addKeyListener(this);
        this.registroSecretaria.txtnombre.addKeyListener(this);
        this.registroSecretaria.txtcedula.addKeyListener(this);
        this.registroSecretaria.txtcelular.addKeyListener(this);
        this.registroSecretaria.txtcorreo.addKeyListener(this);
        this.registroSecretaria.jDateChooser1.addKeyListener(this);
        this.registroSecretaria.txtdireccion.addKeyListener(this);

        estado_civil();
        Nuevo();
        Campos();
    }

    public void estado_civil() {
        registroSecretaria.cbestado.addItem("Seleccionar");
        registroSecretaria.cbestado.addItem("Soltero");
        registroSecretaria.cbestado.addItem("Casado");
        registroSecretaria.cbestado.addItem("Divorciado");
    }

    public void Nuevo() {
        registroSecretaria.btnguardar.setEnabled(false);
        registroSecretaria.txtnombre.setEditable(false);
        registroSecretaria.txtcedula.setEditable(false);
        registroSecretaria.txtapellido.setEditable(false);
        registroSecretaria.cbestado.setEnabled(false);
        registroSecretaria.txtcelular.setEditable(false);
        registroSecretaria.txtdireccion.setEditable(false);
        registroSecretaria.txtcorreo.setEditable(false);
        registroSecretaria.cb1.setEnabled(false);
        registroSecretaria.cb2.setEnabled(false);
        registroSecretaria.cb3.setEnabled(false);
        registroSecretaria.cb4.setEnabled(false);
        registroSecretaria.jDateChooser1.setEnabled(false);
        registroSecretaria.txtcedula.setText("");
        registroSecretaria.txtnombre.setText("");
        registroSecretaria.cbestado.setSelectedIndex(0);
        registroSecretaria.txtapellido.setText("");
        registroSecretaria.txtcelular.setText("");
        registroSecretaria.txtdireccion.setText("");
        registroSecretaria.txtcorreo.setText("");
        registroSecretaria.cb1.setSelected(false);
        registroSecretaria.cb2.setSelected(false);
        registroSecretaria.cb3.setSelected(false);
        registroSecretaria.cb4.setSelected(false);
        registroSecretaria.jDateChooser1.setCalendar(null);
        registroSecretaria.lafoto.setIcon(null);
    }

    public void cancelar() {

        registroSecretaria.txtcedula.setText("");
        registroSecretaria.txtnombre.setText("");
        registroSecretaria.cbestado.setSelectedIndex(0);
        registroSecretaria.txtapellido.setText("");
        registroSecretaria.txtcelular.setText("");
        registroSecretaria.txtdireccion.setText("");
        registroSecretaria.txtcorreo.setText("");
        registroSecretaria.cb1.setSelected(false);
        registroSecretaria.cb2.setSelected(false);
        registroSecretaria.cb3.setSelected(false);
        registroSecretaria.cb4.setSelected(false);
        registroSecretaria.jDateChooser1.setCalendar(null);
        registroSecretaria.lafoto.setIcon(null);
    }

    public void Campo_Vacio() {
        String estado = (String) registroSecretaria.cbestado.getSelectedItem();
        if (registroSecretaria.txtnombre.getText().isEmpty()) {
            registroSecretaria.lanombre1.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (registroSecretaria.txtapellido.getText().isEmpty()) {
            registroSecretaria.laapellido1.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (registroSecretaria.txtcedula.getText().isEmpty()) {
            registroSecretaria.lacedula1.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (registroSecretaria.txtcelular.getText().isEmpty()) {
            registroSecretaria.lacelular1.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (registroSecretaria.txtcorreo.getText().isEmpty()) {
            registroSecretaria.lacorreo1.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (registroSecretaria.txtdireccion.getText().isEmpty()) {
            registroSecretaria.ladireccion1.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (estado.equals("Seleccionar")) {
            registroSecretaria.laestado1.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (!(registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
            registroSecretaria.foto.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (registroSecretaria.jDateChooser1.getDate() == null) {
            registroSecretaria.lafecha.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (registroSecretaria.lafoto.getIcon() == null) {
            registroSecretaria.foto.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        if (!(registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
            registroSecretaria.lahorario1.setVisible(true);
            registroSecretaria.btncancelar.setEnabled(false);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!registroSecretaria.txtnombre.getText().isEmpty()) {
            registroSecretaria.lanombre1.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (!(registroSecretaria.lafoto.getIcon() == null)) {
            registroSecretaria.foto.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (!registroSecretaria.txtapellido.getText().isEmpty()) {
            registroSecretaria.laapellido1.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (!registroSecretaria.txtcedula.getText().isEmpty()) {
            registroSecretaria.lacedula1.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (!registroSecretaria.txtcelular.getText().isEmpty()) {
            registroSecretaria.lacelular1.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (!registroSecretaria.txtcorreo.getText().isEmpty()) {
            registroSecretaria.lacorreo1.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (!registroSecretaria.txtdireccion.getText().isEmpty()) {
            registroSecretaria.ladireccion1.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (!estado.equals("Seleccionar")) {
            registroSecretaria.laestado1.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if ((registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
            registroSecretaria.lahorario1.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (!(registroSecretaria.jDateChooser1.getDate() == null)) {
            registroSecretaria.lafecha.setVisible(false);
            registroSecretaria.btncancelar.setEnabled(true);
        }

        if (registroSecretaria.lacedula1.isShowing() == true) {
            registroSecretaria.cedula.setVisible(false);
        } else if (!verificarCedula(registroSecretaria.txtcedula.getText())) {
            registroSecretaria.cedula.setVisible(true);
        } else if (verificarCedula(registroSecretaria.txtcedula.getText())) {
            registroSecretaria.cedula.setVisible(false);
        }

        if (registroSecretaria.lacelular1.isShowing() == true) {
            registroSecretaria.celular.setVisible(false);
        } else if (registroSecretaria.txtcelular.getText().length() < 10) {
            registroSecretaria.celular.setVisible(true);
        } else if (registroSecretaria.txtcelular.getText().length() == 10) {
            registroSecretaria.celular.setVisible(false);
        }

        if (!registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
            registroSecretaria.btnguardar.setEnabled(true);
        } else {
            registroSecretaria.btnguardar.setEnabled(false);
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

        registroSecretaria.cedula.setVisible(false);
        registroSecretaria.celular.setVisible(false);
        registroSecretaria.laapellido1.setVisible(false);
        registroSecretaria.lanombre1.setVisible(false);
        registroSecretaria.lacedula1.setVisible(false);
        registroSecretaria.lacorreo1.setVisible(false);
        registroSecretaria.lacelular1.setVisible(false);
        registroSecretaria.lafecha.setVisible(false);
        registroSecretaria.foto.setVisible(false);
        registroSecretaria.laestado1.setVisible(false);
        registroSecretaria.ladireccion1.setVisible(false);
        registroSecretaria.correo.setVisible(false);
        registroSecretaria.btnguardar.setEnabled(false);
        registroSecretaria.datocedula.setVisible(false);
        registroSecretaria.datocorreo.setVisible(false);
        registroSecretaria.btnimagen.setEnabled(false);
        registroSecretaria.foto.setVisible(false);
        registroSecretaria.lahorario1.setVisible(false);
    }

    public boolean Validar_Cedula() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCedula().equalsIgnoreCase(registroSecretaria.txtcedula.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCedula().equalsIgnoreCase(registroSecretaria.txtcedula.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCedula().equalsIgnoreCase(registroSecretaria.txtcedula.getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Correo() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCorreo().equalsIgnoreCase(registroSecretaria.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCorreo().equalsIgnoreCase(registroSecretaria.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCorreo().equalsIgnoreCase(registroSecretaria.txtcorreo.getText())) {
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

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == registroSecretaria.btncancelar) {
            String estado = (String) registroSecretaria.cbestado.getSelectedItem();
            if (!registroSecretaria.txtcedula.getText().equals("") || !registroSecretaria.txtnombre.getText().equals("") || !registroSecretaria.txtapellido.getText().equals("") || !(registroSecretaria.jDateChooser1.getDate() == null) || !registroSecretaria.txtcelular.getText().equals("") || !registroSecretaria.txtcorreo.getText().equals("") || !registroSecretaria.txtdireccion.getText().equals("") || !estado.equals("Seleccionar") || (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
                switch (salir) {
                    case 0:
                        cancelar();
                        Nuevo();
                        Campos();
                        registroSecretaria.btncancelar.setEnabled(false);
                        break;
                    case 1:
                        Campo_Vacio();
                        break;
                }
            }
        }
        if (evt.getSource() == registroSecretaria.btnguardar) {
            if (!(registroSecretaria.lafoto.getIcon() == null)) {
                try {

                    Path Destino = Paths.get(Dest);
                    Path Origen = Paths.get(Orig);
                    Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    Logger.getLogger(RegistroSecretaria.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            String horario = "";
            if (registroSecretaria.cb1.isSelected() == true) {

                horario = horario + registroSecretaria.cb1.getText();
            }
            if (registroSecretaria.cb2.isSelected() == true) {

                horario = horario + registroSecretaria.cb2.getText();
            }
            if (registroSecretaria.cb3.isSelected() == true) {

                horario = horario + registroSecretaria.cb3.getText();
            }
            if (registroSecretaria.cb4.isSelected() == true) {

                horario = horario + registroSecretaria.cb4.getText();
            }

            String estado = (String) registroSecretaria.cbestado.getSelectedItem();

            String fechas = "";
            if (!(registroSecretaria.jDateChooser1.getDate() == null)) {
                Date fecha = registroSecretaria.jDateChooser1.getDate();
                DateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
                fechas = Formato.format(fecha);
            }

            Secretaria AB = new Secretaria(registroSecretaria.txtcedula.getText(), registroSecretaria.txtnombre.getText(), registroSecretaria.txtapellido.getText(), registroSecretaria.txtcorreo.getText(), registroSecretaria.txtdireccion.getText(), registroSecretaria.txtcelular.getText(), estado, fechas, horario, Imagen);

            if (!registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !(registroSecretaria.lafoto.getIcon() == null) && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                if (!Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !Lista_cliente.isEmpty()) {
                    if (Validar_Cedula() == true && Validar_Correo() == true) {
                        if (Validar_Correo(registroSecretaria.txtcorreo.getText()) && verificarCedula(registroSecretaria.txtcedula.getText()) && registroSecretaria.txtcelular.getText().length() == 10) {
                            int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:
                                    Lista_Secretaria.add(AB);
                                    Nuevo();
                                    Campos();
                                    registroSecretaria.btncancelar.setEnabled(false);
                                    registroSecretaria.btnnuevo.setEnabled(true);
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

            if (Lista_Secretaria.size() <= 0 && Lista_cliente.size() <= 0 && Lista_abogado.size() <= 0 && !registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.lafoto.getIcon() == null) && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                if (Validar_Correo(registroSecretaria.txtcorreo.getText()) && verificarCedula(registroSecretaria.txtcedula.getText()) && registroSecretaria.txtcelular.getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:
                            Lista_Secretaria.add(AB);
                            Nuevo();
                            Campos();
                            registroSecretaria.btncancelar.setEnabled(false);
                            registroSecretaria.btnnuevo.setEnabled(true);
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                            break;
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!(Lista_Secretaria.size() <= 0) && Lista_cliente.size() <= 0 && Lista_abogado.size() <= 0 && !registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.lafoto.getIcon() == null) && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroSecretaria.txtcorreo.getText()) && verificarCedula(registroSecretaria.txtcedula.getText()) && registroSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_Secretaria.add(AB);
                                Nuevo();
                                Campos();
                                registroSecretaria.btncancelar.setEnabled(false);
                                registroSecretaria.btnnuevo.setEnabled(true);
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
            } else if (!(Lista_Secretaria.size() <= 0) && !(Lista_cliente.size() <= 0) && Lista_abogado.size() <= 0 && !registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.lafoto.getIcon() == null) && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroSecretaria.txtcorreo.getText()) && verificarCedula(registroSecretaria.txtcedula.getText()) && registroSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_Secretaria.add(AB);
                                Nuevo();
                                Campos();
                                registroSecretaria.btnnuevo.setEnabled(true);
                                registroSecretaria.btncancelar.setEnabled(false);
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
            } else if (!(Lista_Secretaria.size() <= 0) && Lista_cliente.size() <= 0 && !(Lista_abogado.size() <= 0) && !registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.lafoto.getIcon() == null) && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroSecretaria.txtcorreo.getText()) && verificarCedula(registroSecretaria.txtcedula.getText()) && registroSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_Secretaria.add(AB);
                                Nuevo();
                                Campos();
                                registroSecretaria.btncancelar.setEnabled(false);
                                registroSecretaria.btnnuevo.setEnabled(true);
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
            } else if (Lista_Secretaria.size() <= 0 && !(Lista_cliente.size() <= 0) && !(Lista_abogado.size() <= 0) && !registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.lafoto.getIcon() == null) && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroSecretaria.txtcorreo.getText()) && verificarCedula(registroSecretaria.txtcedula.getText()) && registroSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_Secretaria.add(AB);
                                Nuevo();
                                Campos();
                                registroSecretaria.btncancelar.setEnabled(false);
                                registroSecretaria.btnnuevo.setEnabled(true);
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
            } else if (Lista_Secretaria.isEmpty() && Lista_cliente.isEmpty() && !(Lista_abogado.size() <= 0) && !registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.lafoto.getIcon() == null) && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroSecretaria.txtcorreo.getText()) && verificarCedula(registroSecretaria.txtcedula.getText()) && registroSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_Secretaria.add(AB);
                                Nuevo();
                                Campos();
                                registroSecretaria.btncancelar.setEnabled(false);
                                registroSecretaria.btnnuevo.setEnabled(true);
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
            } else if (Lista_Secretaria.isEmpty() && !(Lista_cliente.size() <= 0) && Lista_abogado.isEmpty() && !registroSecretaria.txtcedula.getText().equals("") && !registroSecretaria.txtnombre.getText().equals("") && !registroSecretaria.txtapellido.getText().equals("") && !(registroSecretaria.lafoto.getIcon() == null) && !(registroSecretaria.jDateChooser1.getDate() == null) && !registroSecretaria.txtcelular.getText().equals("") && !registroSecretaria.txtcorreo.getText().equals("") && !registroSecretaria.txtdireccion.getText().equals("") && !estado.equals("Seleccionar") && (registroSecretaria.cb1.isSelected() || registroSecretaria.cb2.isSelected() || registroSecretaria.cb3.isSelected() || registroSecretaria.cb4.isSelected())) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroSecretaria.txtcorreo.getText()) && verificarCedula(registroSecretaria.txtcedula.getText()) && registroSecretaria.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_Secretaria.add(AB);
                                Nuevo();
                                Campos();
                                registroSecretaria.btncancelar.setEnabled(false);
                                registroSecretaria.btnnuevo.setEnabled(true);
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
        if (evt.getSource() == registroSecretaria.btnimagen) {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("C:\\Users\\ACER\\OneDrive\\Escritorio\\ACTIVIDAD_PRODUCTOS\\REGISTRO_PRODUCTOS"));
            file.showOpenDialog(registroSecretaria);
            File archivo = file.getSelectedFile();
            Dest = "src\\Imagenes_Secretarias\\" + archivo.getName();
            Orig = archivo.getPath();
            Imagen = archivo.getName();

            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(registroSecretaria.lafoto.getWidth(), registroSecretaria.lafoto.getHeight(), Image.SCALE_DEFAULT));
            registroSecretaria.lafoto.setText(null);
            registroSecretaria.lafoto.setIcon(icono);

            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.btnnuevo) {
            registroSecretaria.txtnombre.setEditable(true);
            registroSecretaria.txtcedula.setEditable(true);
            registroSecretaria.txtapellido.setEditable(true);
            registroSecretaria.cbestado.setEnabled(true);
            registroSecretaria.txtcelular.setEditable(true);
            registroSecretaria.txtdireccion.setEditable(true);
            registroSecretaria.txtcorreo.setEditable(true);
            registroSecretaria.cb1.setEnabled(true);
            registroSecretaria.cb2.setEnabled(true);
            registroSecretaria.cb3.setEnabled(true);
            registroSecretaria.cb4.setEnabled(true);
            registroSecretaria.jDateChooser1.setEnabled(true);
            registroSecretaria.btnnuevo.setEnabled(false);
            registroSecretaria.btnimagen.setEnabled(true);
        }
        if (evt.getSource() == registroSecretaria.cbestado) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.cb1) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.cb2) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.cb3) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.cb4) {
            Campo_Vacio();
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == registroSecretaria.txtnombre) {
            int key = evt.getKeyChar();

            if (registroSecretaria.txtnombre.getText().length() <= 20) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                if (!letra) {

                    evt.consume();
                }

            } else {

                evt.consume();
            }
        }
        if (evt.getSource() == registroSecretaria.txtapellido) {
            int key = evt.getKeyChar();

            if (registroSecretaria.txtapellido.getText().length() <= 20) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                if (!letra) {

                    evt.consume();
                }

            } else {

                evt.consume();
            }
        }
        if (evt.getSource() == registroSecretaria.txtcedula) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && registroSecretaria.txtcedula.getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == registroSecretaria.txtcelular) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && registroSecretaria.txtcelular.getText().length() <= 9) {

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

        if (evt.getSource() == registroSecretaria.txtnombre) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.txtcorreo) {
            Campo_Vacio();
            if (Validar_Correo(registroSecretaria.txtcorreo.getText())) {

                registroSecretaria.correo.setVisible(false);
            } else {

                if (registroSecretaria.lacorreo1.isShowing() == true) {

                    registroSecretaria.correo.setVisible(false);
                } else {
                    registroSecretaria.correo.setVisible(true);
                }
            }

            if (Validar_Correo() == true) {
                registroSecretaria.datocorreo.setVisible(false);
            } else {
                registroSecretaria.datocorreo.setVisible(true);
            }
        }
        if (evt.getSource() == registroSecretaria.txtapellido) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.jDateChooser1) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.txtcedula) {
            Campo_Vacio();

            if (Validar_Cedula() == true) {
                registroSecretaria.datocedula.setVisible(false);
            } else {
                registroSecretaria.datocedula.setVisible(true);
            }
        }
        if (evt.getSource() == registroSecretaria.txtcelular) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.txtdireccion) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroSecretaria.txtapellido) {

        }
    }
}
