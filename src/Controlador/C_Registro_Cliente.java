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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Cliente;
import static vista.RegistroAbogado.Lista_abogado;
import vista.RegistroCliente;
import static vista.RegistroCliente.Lista_cliente;
import static vista.RegistroSecretaria.Lista_Secretaria;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Cliente implements ActionListener, KeyListener {

    RegistroCliente registroCliente;

    public C_Registro_Cliente(RegistroCliente registroCliente) {
        this.registroCliente = registroCliente;
        this.registroCliente.btncancelar.addActionListener(this);
        this.registroCliente.btnguardar.addActionListener(this);
        this.registroCliente.btnnuevo.addActionListener(this);
        this.registroCliente.cbestado.addActionListener(this);

        this.registroCliente.txtnombre.addKeyListener(this);
        this.registroCliente.txtapellido.addKeyListener(this);
        this.registroCliente.txtcedula.addKeyListener(this);
        this.registroCliente.txtcelular.addKeyListener(this);
        this.registroCliente.txtcorreo.addKeyListener(this);
        this.registroCliente.txtocupacion.addKeyListener(this);
        this.registroCliente.jDateChooser1.addKeyListener(this);
        this.registroCliente.txtdireccion.addKeyListener(this);
        

        estado_civil();
        Nuevo();
        Campos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registroCliente.btncancelar) {
            String estado = (String) registroCliente.cbestado.getSelectedItem();
            if (!registroCliente.txtcedula.getText().equals("") || !registroCliente.txtnombre.getText().equals("") || !registroCliente.txtapellido.getText().equals("") || !(registroCliente.jDateChooser1.getDate() == null) || !registroCliente.txtcelular.getText().equals("") || !registroCliente.txtcorreo.getText().equals("") || !registroCliente.txtdireccion.getText().equals("") || !estado.equals("Seleccionar") || !registroCliente.txtocupacion.getText().equals("")) {
                int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
                switch (salir) {
                    case 0:
                        Cancelar();
                        Nuevo();
                        Campos();
                        registroCliente.btncancelar.setEnabled(false);
                        registroCliente.btnnuevo.setEnabled(true);
                        break;
                    case 1:
                        Campo_Vacio();
                        break;
                }
            }
        }
        if (e.getSource() == registroCliente.cbestado) {
            Campo_Vacio();
        }
        if (e.getSource() == registroCliente.btnguardar) {
            String estado = (String) registroCliente.cbestado.getSelectedItem();

            String fechas = "";
            if (!(registroCliente.jDateChooser1.getDate() == null)) {
                Date fecha = registroCliente.jDateChooser1.getDate();
                DateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
                fechas = Formato.format(fecha);
            }

            Cliente cli = new Cliente(registroCliente.txtcedula.getText(), registroCliente.txtnombre.getText(), registroCliente.txtapellido.getText(), registroCliente.txtcorreo.getText(), registroCliente.txtdireccion.getText(), registroCliente.txtcelular.getText(), estado, fechas, registroCliente.txtocupacion.getText());

            if (!registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
                if (!Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !Lista_cliente.isEmpty()) {
                    if (Validar_Cedula() == true && Validar_Correo() == true) {
                        if (Validar_Correo(registroCliente.txtcorreo.getText()) && verificarCedula(registroCliente.txtcedula.getText()) && registroCliente.txtcelular.getText().length() == 10) {
                            int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:
                                    Lista_cliente.add(cli);
                                    Nuevo();
                                    Campos();
                                    registroCliente.btncancelar.setEnabled(false);
                                    registroCliente.btnnuevo.setEnabled(true);
                                    break;
                                case 1:
                                    Campo_Vacio();
                                    JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                    break;
                            }
                        } else {

                            Campo_Vacio();
                            JOptionPane.showMessageDialog(null, "CORREO DIGITADO ERRONEO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
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

            if (Lista_cliente.isEmpty() && Lista_Secretaria.isEmpty() && Lista_abogado.isEmpty() && !registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
                if (Validar_Correo(registroCliente.txtcorreo.getText()) && verificarCedula(registroCliente.txtcedula.getText()) && registroCliente.txtcelular.getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:
                            Lista_cliente.add(cli);
                            Nuevo();
                            Campos();
                            registroCliente.btncancelar.setEnabled(false);
                            registroCliente.btnnuevo.setEnabled(true);
                            break;
                        case 1:
                            Campo_Vacio();
                            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                            break;
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!Lista_cliente.isEmpty() && Lista_Secretaria.isEmpty() && Lista_abogado.isEmpty() && !registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroCliente.txtcorreo.getText()) && verificarCedula(registroCliente.txtcedula.getText()) && registroCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_cliente.add(cli);
                                Nuevo();
                                Campos();
                                registroCliente.btncancelar.setEnabled(false);
                                registroCliente.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (!Lista_cliente.isEmpty() && !Lista_Secretaria.isEmpty() && Lista_abogado.isEmpty() && !registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroCliente.txtcorreo.getText()) && verificarCedula(registroCliente.txtcedula.getText()) && registroCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_cliente.add(cli);
                                Nuevo();
                                Campos();
                                registroCliente.btncancelar.setEnabled(false);
                                registroCliente.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;

                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (!Lista_cliente.isEmpty() && Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroCliente.txtcorreo.getText()) && verificarCedula(registroCliente.txtcedula.getText()) && registroCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_cliente.add(cli);
                                Nuevo();
                                Campos();
                                registroCliente.btncancelar.setEnabled(false);
                                registroCliente.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (Lista_cliente.isEmpty() && !Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroCliente.txtcorreo.getText()) && verificarCedula(registroCliente.txtcedula.getText()) && registroCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_cliente.add(cli);
                                Nuevo();
                                Campos();
                                registroCliente.btncancelar.setEnabled(false);
                                registroCliente.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (Lista_cliente.isEmpty() && Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroCliente.txtcorreo.getText()) && verificarCedula(registroCliente.txtcedula.getText()) && registroCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_cliente.add(cli);
                                Nuevo();
                                Campos();
                                registroCliente.btncancelar.setEnabled(false);
                                registroCliente.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (Lista_cliente.isEmpty() && !Lista_Secretaria.isEmpty() && Lista_abogado.isEmpty() && !registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
                if (Validar_Cedula() == true && Validar_Correo() == true) {
                    if (Validar_Correo(registroCliente.txtcorreo.getText()) && verificarCedula(registroCliente.txtcedula.getText()) && registroCliente.txtcelular.getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Lista_cliente.add(cli);
                                Nuevo();
                                Campos();
                                registroCliente.btncancelar.setEnabled(false);
                                registroCliente.btnnuevo.setEnabled(true);
                                break;
                            case 1:
                                Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == registroCliente.btnnuevo) {
            registroCliente.txtnombre.setEditable(true);
            registroCliente.txtcedula.setEditable(true);
            registroCliente.txtapellido.setEditable(true);
            registroCliente.cbestado.setEnabled(true);
            registroCliente.txtcelular.setEditable(true);
            registroCliente.txtdireccion.setEditable(true);
            registroCliente.txtcorreo.setEditable(true);
            registroCliente.jDateChooser1.setEnabled(true);
            registroCliente.txtocupacion.setEditable(true);
            registroCliente.btnnuevo.setEnabled(false);
        }
    }

    public void Nuevo() {
        registroCliente.btnguardar.setEnabled(false);
        registroCliente.txtnombre.setEditable(false);
        registroCliente.txtcedula.setEditable(false);
        registroCliente.txtapellido.setEditable(false);
        registroCliente.cbestado.setEnabled(false);
        registroCliente.txtcelular.setEditable(false);
        registroCliente.txtdireccion.setEditable(false);
        registroCliente.txtcorreo.setEditable(false);
        registroCliente.jDateChooser1.setEnabled(false);
        registroCliente.txtcedula.setText("");
        registroCliente.txtnombre.setText("");
        registroCliente.cbestado.setSelectedIndex(0);
        registroCliente.txtapellido.setText("");
        registroCliente.txtcelular.setText("");
        registroCliente.txtdireccion.setText("");
        registroCliente.txtcorreo.setText("");
        registroCliente.txtocupacion.setText("");
        registroCliente.jDateChooser1.setCalendar(null);
        registroCliente.txtocupacion.setEditable(false);
    }

    public void estado_civil() {
        registroCliente.cbestado.addItem("Seleccionar");
        registroCliente.cbestado.addItem("Soltero");
        registroCliente.cbestado.addItem("Casado");
        registroCliente.cbestado.addItem("Divorciado");
    }

    public void Cancelar() {

        registroCliente.txtcedula.setText("");
        registroCliente.txtnombre.setText("");
        registroCliente.cbestado.setSelectedIndex(0);
        registroCliente.txtapellido.setText("");
        registroCliente.txtcelular.setText("");
        registroCliente.txtdireccion.setText("");
        registroCliente.txtcorreo.setText("");
        registroCliente.txtocupacion.setText("");
        registroCliente.jDateChooser1.setCalendar(null);
        registroCliente.txtocupacion.setEditable(false);
    }

    public void Campo_Vacio() {
        String estado = (String) registroCliente.cbestado.getSelectedItem();
        if (registroCliente.txtnombre.getText().isEmpty()) {
            registroCliente.lanombre1.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        if (registroCliente.txtapellido.getText().isEmpty()) {
            registroCliente.laapellido1.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        if (registroCliente.txtcedula.getText().isEmpty()) {
            registroCliente.lacedula1.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        if (registroCliente.txtcelular.getText().isEmpty()) {
            registroCliente.lacelular1.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        if (registroCliente.txtcorreo.getText().isEmpty()) {
            registroCliente.lacorreo1.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        if (registroCliente.txtdireccion.getText().isEmpty()) {
            registroCliente.ladireccion1.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        if (estado.equals("Seleccionar")) {
            registroCliente.laestado1.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        if (registroCliente.jDateChooser1.getDate() == null) {
            registroCliente.lafecha.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        if (registroCliente.txtocupacion.getText().isEmpty()) {
            registroCliente.laocupacion.setVisible(true);
            registroCliente.btncancelar.setEnabled(false);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!registroCliente.txtnombre.getText().isEmpty()) {
            registroCliente.lanombre1.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (!registroCliente.txtapellido.getText().isEmpty()) {
            registroCliente.laapellido1.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (!registroCliente.txtcedula.getText().isEmpty()) {
            registroCliente.lacedula1.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (!registroCliente.txtcelular.getText().isEmpty()) {
            registroCliente.lacelular1.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (!registroCliente.txtcorreo.getText().isEmpty()) {
            registroCliente.lacorreo1.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (!registroCliente.txtdireccion.getText().isEmpty()) {
            registroCliente.ladireccion1.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (!estado.equals("Seleccionar")) {
            registroCliente.laestado1.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (!(registroCliente.jDateChooser1.getDate() == null)) {
            registroCliente.lafecha.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (!registroCliente.txtocupacion.getText().isEmpty()) {
            registroCliente.laocupacion.setVisible(false);
            registroCliente.btncancelar.setEnabled(true);
        }

        if (registroCliente.lacedula1.isShowing() == true) {
            registroCliente.cedula.setVisible(false);
        } else if (!verificarCedula(registroCliente.txtcedula.getText())) {
            registroCliente.cedula.setVisible(true);
        } else if (verificarCedula(registroCliente.txtcedula.getText())) {
            registroCliente.cedula.setVisible(false);
        }

        if (registroCliente.lacelular1.isShowing() == true) {
            registroCliente.celular.setVisible(false);
        } else if (registroCliente.txtcelular.getText().length() < 10) {
            registroCliente.celular.setVisible(true);
        } else if (registroCliente.txtcelular.getText().length() == 10) {
            registroCliente.celular.setVisible(false);
        }

        if (!registroCliente.txtcedula.getText().equals("") && !registroCliente.txtnombre.getText().equals("") && !registroCliente.txtapellido.getText().equals("") && !(registroCliente.jDateChooser1.getDate() == null) && !registroCliente.txtcelular.getText().equals("") && !registroCliente.txtcorreo.getText().equals("") && !registroCliente.txtdireccion.getText().equals("") && !estado.equals("Seleccionar")) {
            registroCliente.btnguardar.setEnabled(true);
        } else {
            registroCliente.btnguardar.setEnabled(false);
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

        registroCliente.cedula.setVisible(false);
        registroCliente.celular.setVisible(false);
        registroCliente.laapellido1.setVisible(false);
        registroCliente.lanombre1.setVisible(false);
        registroCliente.lacedula1.setVisible(false);
        registroCliente.lacorreo1.setVisible(false);
        registroCliente.lacelular1.setVisible(false);
        registroCliente.lafecha.setVisible(false);
        registroCliente.laocupacion.setVisible(false);
        registroCliente.laestado1.setVisible(false);
        registroCliente.ladireccion1.setVisible(false);
        registroCliente.btnguardar.setEnabled(false);
        registroCliente.correo.setVisible(false);
        registroCliente.datocedula.setVisible(false);
        registroCliente.datocorreo.setVisible(false);
    }

    public boolean Validar_Cedula() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCedula().equalsIgnoreCase(registroCliente.txtcedula.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCedula().equalsIgnoreCase(registroCliente.txtcedula.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCedula().equalsIgnoreCase(registroCliente.txtcedula.getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Correo() {

        for (int i = 0; i < Lista_abogado.size(); i++) {
            if (Lista_abogado.get(i).getCorreo().equalsIgnoreCase(registroCliente.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_Secretaria.size(); i++) {
            if (Lista_Secretaria.get(i).getCorreo().equalsIgnoreCase(registroCliente.txtcorreo.getText())) {
                return false;
            }
        }

        for (int i = 0; i < Lista_cliente.size(); i++) {
            if (Lista_cliente.get(i).getCorreo().equalsIgnoreCase(registroCliente.txtcorreo.getText())) {
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
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == registroCliente.txtnombre) {
            int key = evt.getKeyChar();
            if (registroCliente.txtnombre.getText().length() <= 20) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;
                if (!letra) {
                    evt.consume();
                }
            } else {
                evt.consume();
            }
        }

        if (evt.getSource() == registroCliente.txtapellido) {
            int key = evt.getKeyChar();
            if (registroCliente.txtapellido.getText().length() <= 20) {
                boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;
                if (!letra) {
                    evt.consume();
                }
            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == registroCliente.txtcedula) {
            char c = evt.getKeyChar();
            if (c >= '0' && c <= '9' && registroCliente.txtcedula.getText().length() <= 9) {
            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == registroCliente.txtcelular) {
            char c = evt.getKeyChar();
            if (c >= '0' && c <= '9' && registroCliente.txtcelular.getText().length() <= 9) {
            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == registroCliente.txtcorreo) {
            Campo_Vacio();

            if (Validar_Correo(registroCliente.txtcorreo.getText())) {

                registroCliente.correo.setVisible(false);
            } else {

                if (registroCliente.lacorreo1.isShowing() == true) {

                    registroCliente.correo.setVisible(false);
                } else {
                    registroCliente.correo.setVisible(true);
                }
            }

            if (Validar_Correo() == true) {
                registroCliente.datocorreo.setVisible(false);
            } else {
                registroCliente.datocorreo.setVisible(true);
            }
        }
        if (evt.getSource() == registroCliente.txtocupacion) {
            int key = evt.getKeyChar();

            if (registroCliente.txtocupacion.getText().length() <= 30) {
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
        if (evt.getSource() == registroCliente.txtapellido) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroCliente.jDateChooser1) {
            Campo_Vacio();
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getSource() == registroCliente.txtnombre) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroCliente.txtcedula) {
            Campo_Vacio();

            if (Validar_Cedula() == true) {
                registroCliente.datocedula.setVisible(false);
            } else {
                registroCliente.datocedula.setVisible(true);
            }
        }
        if (evt.getSource() == registroCliente.txtcelular) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroCliente.txtocupacion) {
            Campo_Vacio();
        }
        if (evt.getSource() == registroCliente.txtdireccion) {
            Campo_Vacio();
        }
    }

}
