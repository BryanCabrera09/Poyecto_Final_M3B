/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Cliente;
import Modelo.Buf_ClienteDB;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import Modelo.Buf_Secretaria;
import Modelo.Buf_SecretariaDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vista.V_Registro_Secretaria;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Secretaria {

    V_Registro_Secretaria registro;
    Buf_Persona P = new Buf_Persona();
    Buf_Secretaria S = new Buf_Secretaria();
    Buf_AbogadoDB A_DB = new Buf_AbogadoDB();
    Buf_PersonaDB P_DB = new Buf_PersonaDB();
    Buf_SecretariaDB S_DB = new Buf_SecretariaDB();
    Buf_ClienteDB C_DB = new Buf_ClienteDB();

    public C_Registro_Secretaria(V_Registro_Secretaria registro) {

        this.registro = registro;

        estado_civil();
        Nuevo();
        Campos();
    }

    public void Iniciar_Control() {

        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (evt.getSource() == registro.getTxt_nombre()) {
                    int key = evt.getKeyChar();

                    if (registro.getTxt_nombre().getText().length() <= 20) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                        if (!letra) {

                            evt.consume();
                        }

                    } else {

                        evt.consume();
                    }
                }
                if (evt.getSource() == registro.getTxt_apellido()) {
                    int key = evt.getKeyChar();

                    if (registro.getTxt_apellido().getText().length() <= 20) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                        if (!letra) {

                            evt.consume();
                        }

                    } else {

                        evt.consume();
                    }
                }
                if (evt.getSource() == registro.getTxt_cedula()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && registro.getTxt_cedula().getText().length() <= 9) {

                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == registro.getTxt_celular()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && registro.getTxt_celular().getText().length() <= 9) {

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

                if (evt.getSource() == registro.getTxt_nombre()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == registro.getTxt_correo()) {
                    Campo_Vacio();
                    if (Validar_Correo(registro.getTxt_correo().getText())) {

                        registro.getCorreo().setVisible(false);
                    } else {

                        if (registro.getLb_correo().isShowing() == true) {

                            registro.getCorreo().setVisible(false);
                        } else {
                            registro.getCorreo().setVisible(true);
                        }
                    }

                    if (Validar_Correo() == true) {
                        registro.getDatocorreo().setVisible(false);
                    } else {
                        registro.getDatocorreo().setVisible(true);
                    }
                }
                if (evt.getSource() == registro.getTxt_apellido()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == registro.getjDateChooser1()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == registro.getTxt_cedula()) {
                    Campo_Vacio();

                    if (Validar_Cedula() == true) {
                        registro.getDatocedula().setVisible(false);
                    } else {
                        registro.getDatocedula().setVisible(true);
                    }
                }
                if (evt.getSource() == registro.getTxt_celular()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == registro.getTxt_direccion()) {
                    Campo_Vacio();
                }
                if (evt.getSource() == registro.getTxt_apellido()) {
                    Campo_Vacio();
                }
            }
        };

        registro.getTxt_apellido().addKeyListener(K);
        registro.getTxt_nombre().addKeyListener(K);
        registro.getTxt_cedula().addKeyListener(K);
        registro.getTxt_celular().addKeyListener(K);
        registro.getTxt_correo().addKeyListener(K);
        registro.getjDateChooser1().addKeyListener(K);
        registro.getTxt_direccion().addKeyListener(K);

        //DAR FUNCION A LOS BOTONES
        registro.getBtn_cancelar().addActionListener(l -> {
            Cancelar();
        });
        registro.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
        registro.getBtn_imagen().addActionListener(l -> {
            registro.Cargar_Imagen();
            Campo_Vacio();
        });
        registro.getBtn_nuevo().addActionListener(l -> {
            Nuevo_Campos();
        });
        registro.getCb_estado().addActionListener(l -> {
            Campo_Vacio();
        });
        registro.getCb_1().addActionListener(l -> {
            Campo_Vacio();
        });
        registro.getCb_2().addActionListener(l -> {
            Campo_Vacio();
        });
        registro.getCb_3().addActionListener(l -> {
            Campo_Vacio();
        });
        registro.getCb_4().addActionListener(l -> {
            Campo_Vacio();
        });
    }

    public void Nuevo_Campos() {

        registro.getTxt_nombre().setEditable(true);
        registro.getTxt_cedula().setEditable(true);
        registro.getTxt_apellido().setEditable(true);
        registro.getCb_estado().setEnabled(true);
        registro.getTxt_celular().setEditable(true);
        registro.getTxt_direccion().setEditable(true);
        registro.getTxt_correo().setEditable(true);
        registro.getCb_1().setEnabled(true);
        registro.getCb_2().setEnabled(true);
        registro.getCb_3().setEnabled(true);
        registro.getCb_4().setEnabled(true);
        registro.getjDateChooser1().setEnabled(true);
        registro.getBtn_nuevo().setEnabled(false);
        registro.getBtn_imagen().setEnabled(true);
    }

    public void estado_civil() {

        registro.getCb_estado().addItem("Seleccionar");
        registro.getCb_estado().addItem("Soltero");
        registro.getCb_estado().addItem("Casado");
        registro.getCb_estado().addItem("Divorciado");
    }

    public void Nuevo() {

        registro.getBtn_guardar().setEnabled(false);
        registro.getTxt_nombre().setEditable(false);
        registro.getTxt_cedula().setEditable(false);
        registro.getTxt_apellido().setEditable(false);
        registro.getCb_estado().setEnabled(false);
        registro.getTxt_celular().setEditable(false);
        registro.getTxt_direccion().setEditable(false);
        registro.getTxt_correo().setEditable(false);
        registro.getTxt_id_abg().setEditable(false);
        registro.getTxt_abogado().setEditable(false);
        registro.getCb_1().setEnabled(false);
        registro.getCb_2().setEnabled(false);
        registro.getCb_3().setEnabled(false);
        registro.getCb_4().setEnabled(false);
        registro.getjDateChooser1().setEnabled(false);
        registro.getTxt_cedula().setText("");
        registro.getTxt_nombre().setText("");
        registro.getCb_estado().setSelectedIndex(0);
        registro.getTxt_apellido().setText("");
        registro.getTxt_celular().setText("");
        registro.getTxt_direccion().setText("");
        registro.getTxt_correo().setText("");
        registro.getTxt_id_abg().setText("");
        registro.getTxt_abogado().setText("");
        registro.getCb_1().setSelected(false);
        registro.getCb_2().setSelected(false);
        registro.getCb_3().setSelected(false);
        registro.getCb_4().setSelected(false);
        registro.getjDateChooser1().setCalendar(null);
        registro.getLb_foto().setIcon(null);
    }

    public void Cancelar_Datos() {

        registro.getTxt_cedula().setText("");
        registro.getTxt_nombre().setText("");
        registro.getCb_estado().setSelectedIndex(0);
        registro.getTxt_apellido().setText("");
        registro.getTxt_celular().setText("");
        registro.getTxt_direccion().setText("");
        registro.getTxt_correo().setText("");
        registro.getTxt_id_abg().setText("");
        registro.getTxt_abogado().setText("");
        registro.getCb_1().setSelected(false);
        registro.getCb_2().setSelected(false);
        registro.getCb_3().setSelected(false);
        registro.getCb_4().setSelected(false);
        registro.getjDateChooser1().setCalendar(null);
        registro.getLb_foto().setIcon(null);
    }

    public void Campo_Vacio() {
        String estado = (String) registro.getCb_estado().getSelectedItem();
        if (registro.getTxt_nombre().getText().isEmpty()) {
            registro.getLb_nombre().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_apellido().getText().isEmpty()) {
            registro.getLb_apellido().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_cedula().getText().isEmpty()) {
            registro.getLb_cedula().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_celular().getText().isEmpty()) {
            registro.getLb_celular().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_correo().getText().isEmpty()) {
            registro.getLb_correo().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_direccion().getText().isEmpty()) {
            registro.getLb_direccion().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (estado.equals("Seleccionar")) {
            registro.getLb_estado().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (!(registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
            registro.getFoto().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getjDateChooser1().getDate() == null) {
            registro.getLb_fecha().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getLb_foto().getIcon() == null) {
            registro.getFoto().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (!(registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
            registro.getLb_horario().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!registro.getTxt_nombre().getText().isEmpty()) {
            registro.getLb_nombre().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!(registro.getLb_foto().getIcon() == null)) {
            registro.getFoto().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_apellido().getText().isEmpty()) {
            registro.getLb_apellido().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_cedula().getText().isEmpty()) {
            registro.getLb_cedula().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_celular().getText().isEmpty()) {
            registro.getLb_celular().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_correo().getText().isEmpty()) {
            registro.getLb_correo().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_direccion().getText().isEmpty()) {
            registro.getLb_direccion().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!estado.equals("Seleccionar")) {
            registro.getLb_estado().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if ((registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
            registro.getLb_horario().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!(registro.getjDateChooser1().getDate() == null)) {
            registro.getLb_fecha().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (registro.getLb_cedula().isShowing() == true) {
            registro.getCedula().setVisible(false);
        } else if (!Verificar_Cedula(registro.getTxt_cedula().getText())) {
            registro.getCedula().setVisible(true);
            registro.getTxt_id_abg().setText("");
            registro.getTxt_abogado().setText("");
        } else if (Verificar_Cedula(registro.getTxt_cedula().getText())) {
            registro.getCedula().setVisible(false);
            Validar_Abogado();
        }

        if (registro.getLb_celular().isShowing() == true) {
            registro.getCelular().setVisible(false);
        } else if (registro.getTxt_celular().getText().length() < 10) {
            registro.getCelular().setVisible(true);
        } else if (registro.getTxt_celular().getText().length() == 10) {
            registro.getCelular().setVisible(false);
        }

        if (!registro.getTxt_cedula().getText().equals("") && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getjDateChooser1().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
            registro.getBtn_guardar().setEnabled(true);
        } else {
            registro.getBtn_guardar().setEnabled(false);
        }
    }

    public void Validar_Abogado() {

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();
        List<Buf_Persona> List_pers = P_DB.Getter_Abg();

        if (List_secre.isEmpty()) {

            for (int i = 0; i < List_abg.size(); i++) {
                if (!List_abg.get(i).getCedula().equalsIgnoreCase(registro.getTxt_cedula().getText())) {
                    registro.getTxt_id_abg().setText(String.valueOf(List_abg.get(i).getId_abg()));
                    registro.getTxt_abogado().setText(List_pers.get(i).getApellido().toUpperCase() + " " + List_pers.get(i).getNombre().toUpperCase());
                }
            }
        }

        for (int i = 0; i < List_abg.size(); i++) {
            for (int j = 0; j < List_secre.size(); j++) {
                if (List_abg.get(i).getId_abg() != List_secre.get(j).getId_abg()) {

                    registro.getTxt_id_abg().setText(String.valueOf(List_abg.get(i).getId_abg()));
                    registro.getTxt_abogado().setText(List_pers.get(i).getApellido().toUpperCase() + " " + List_pers.get(i).getNombre().toUpperCase());
                } else {
                    registro.getTxt_id_abg().setText("");
                    registro.getTxt_abogado().setText("");
                }
            }
        }
    }

    public boolean Verificar_Cedula(String cedula) {

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

    public int Id_Generator() {

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();
        List<Buf_Cliente> List_cliente = C_DB.Getter();

        int id_secre = (int) Math.floor(Math.random() * (99999999 - 11111111 + 1) + 11111111);

        int a = 0;
        do {

            for (int i = 0; i < List_abg.size(); i++) {
                if (List_abg.get(i).getId_abg() == id_secre) {
                    a = 1;
                }
            }

            for (int i = 0; i < List_secre.size(); i++) {
                if ((List_secre.get(i).getId_secretaria() == id_secre) || (List_abg.get(i).getId_abg() == id_secre)) {
                    a = 1;
                }
            }

            for (int i = 0; i < List_cliente.size(); i++) {
                if ((List_cliente.get(i).getId_cliente() == id_secre) || (List_abg.get(i).getId_abg() == id_secre)) {
                    a = 1;
                }
            }
        } while (a == 1);

        return id_secre;
    }

    public void Campos() {

        registro.getCedula().setVisible(false);
        registro.getCelular().setVisible(false);
        registro.getLb_apellido().setVisible(false);
        registro.getLb_nombre().setVisible(false);
        registro.getLb_cedula().setVisible(false);
        registro.getLb_correo().setVisible(false);
        registro.getLb_celular().setVisible(false);
        registro.getLb_fecha().setVisible(false);
        registro.getFoto().setVisible(false);
        registro.getLb_estado().setVisible(false);
        registro.getLb_direccion().setVisible(false);
        registro.getCorreo().setVisible(false);
        registro.getBtn_guardar().setEnabled(false);
        registro.getDatocedula().setVisible(false);
        registro.getDatocorreo().setVisible(false);
        registro.getBtn_imagen().setEnabled(false);
        registro.getFoto().setVisible(false);
        registro.getLb_horario().setVisible(false);
    }

    public boolean Validar_Cedula() {

        List<Buf_Persona> List_pers = P_DB.Getter();

        for (int i = 0; i < List_pers.size(); i++) {
            if (List_pers.get(i).getCedula().equals(registro.getTxt_cedula().getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Correo() {

        List<Buf_Persona> List_pers = P_DB.Getter();

        for (int i = 0; i < List_pers.size(); i++) {
            if (List_pers.get(i).getCorreo().equalsIgnoreCase(registro.getTxt_correo().getText())) {
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

    public boolean Validar_Cancelar() {

        String estado = (String) registro.getCb_estado().getSelectedItem();

        if (!registro.getTxt_cedula().getText().equals("") || !registro.getTxt_nombre().getText().equals("") || !registro.getTxt_apellido().getText().equals("") || !(registro.getjDateChooser1().getDate() == null) || !registro.getTxt_celular().getText().equals("") || !registro.getTxt_correo().getText().equals("") || !registro.getTxt_direccion().getText().equals("") || !estado.equals("Seleccionar") || (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {

            return true;
        } else {

            return false;
        }
    }

    public void Cancelar() {

        if (Validar_Cancelar() == true) {
            int salir = JOptionPane.showConfirmDialog(null, "DESCARTAR DATOS INGRESADOS", "SALIR", JOptionPane.YES_NO_OPTION);
            switch (salir) {
                case 0:
                    Cancelar_Datos();
                    Nuevo();
                    Campos();
                    registro.getBtn_cancelar().setEnabled(false);
                    break;
                case 1:
                    Campo_Vacio();
                    break;
            }
        }
    }

    public void Guardar() {

        if (Validar_Datos() == true) {
            if (Validar_Cedula() == true && Validar_Correo() == true) {
                if (Validar_Correo(registro.getTxt_correo().getText()) && Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:
                            Subir_Datos();
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
        } else {
            Campo_Vacio();
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
        }
    }

    public boolean Validar_Datos() {

        String estado = (String) registro.getCb_estado().getSelectedItem();

        if (!registro.getTxt_cedula().getText().equals("") && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getjDateChooser1().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_id_abg().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !estado.equals("Seleccionar") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {

            return true;
        } else {

            return false;
        }
    }

    public void Subir_Datos() {

        String horario = "";
        if (registro.getCb_1().isSelected() == true) {

            horario = horario + " | " + registro.getCb_1().getText() + " | ";
        }
        if (registro.getCb_2().isSelected() == true) {

            horario = horario + " | " + registro.getCb_2().getText() + " | ";
        }
        if (registro.getCb_3().isSelected() == true) {

            horario = horario + " | " + registro.getCb_3().getText() + " | ";
        }
        if (registro.getCb_4().isSelected() == true) {

            horario = horario + " | " + registro.getCb_4().getText() + " | ";
        }

        String estado = (String) registro.getCb_estado().getSelectedItem();

        String fechas = "";
        if (!(registro.getjDateChooser1().getDate() == null)) {
            Date fecha = registro.getjDateChooser1().getDate();
            DateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
            fechas = Formato.format(fecha);
        }

        P.setCedula(registro.getTxt_cedula().getText());
        P.setNombre(registro.getTxt_nombre().getText());
        P.setApellido(registro.getTxt_apellido().getText());
        P.setCorreo(registro.getTxt_correo().getText());
        P.setDireccion(registro.getTxt_direccion().getText());
        P.setNum_celular(registro.getTxt_celular().getText());
        P.setEstado_civil(estado);
        P.setFecha_Nacimiento(fechas);

        S.setId_secretaria(Id_Generator());
        S.setId_abg(Integer.parseInt(registro.getTxt_id_abg().getText()));
        S.setCedula(registro.getTxt_cedula().getText());
        S.setHorario(horario);
        File ruta = new File(registro.rutas);

        try {
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            S.setFoto(icono);
        } catch (Exception ex) {
            S.setFoto(null);
        }

        if (P_DB.Register(P)) {

        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        if (S_DB.Register(S)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            Nuevo();
            Campos();
            registro.getBtn_cancelar().setEnabled(false);
            registro.getBtn_nuevo().setEnabled(true);
        }

    }
}
