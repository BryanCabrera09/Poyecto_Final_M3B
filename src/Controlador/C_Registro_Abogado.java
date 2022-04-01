package controlador;

import Metodos.Validar_Abogados;
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
import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import vista.V_Registro_Abogado;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Abogado implements ActionListener, KeyListener {

    Buf_Abogado A;
    Buf_Persona P;
    V_Registro_Abogado registro;
    Buf_AbogadoDB A_DB;
    Buf_PersonaDB P_DB;
    Validar_Abogados V;

    public C_Registro_Abogado(Buf_Abogado A, Buf_Persona P, V_Registro_Abogado registro, Buf_AbogadoDB A_DB, Buf_PersonaDB P_DB) {
        this.A = A;
        this.P = P;
        this.registro = registro;
        this.A_DB = A_DB;
        this.P_DB = P_DB;

        this.registro = registro;
        this.registro.getBtn_cancelar().addActionListener(this);
        this.registro.getBtn_guardar().addActionListener(this);
        this.registro.getBtn_imagen().addActionListener(this);
        this.registro.getBtn_nuevo().addActionListener(this);
        this.registro.getCb_estado().addActionListener(this);
        this.registro.getCb_1().addActionListener(this);
        this.registro.getCb_2().addActionListener(this);
        this.registro.getCb_3().addActionListener(this);
        this.registro.getCb_4().addActionListener(this);
        this.registro.getTxt_nombre().addKeyListener(this);
        this.registro.getTxt_correo().addKeyListener(this);
        this.registro.getTxt_apellido().addKeyListener(this);
        this.registro.getTxt_cedula().addKeyListener(this);
        this.registro.getTxt_celular().addKeyListener(this);
        this.registro.getTxt_cuenta().addKeyListener(this);
        this.registro.getTxt_matricula().addKeyListener(this);
        this.registro.getTxt_direccion().addKeyListener(this);
        this.registro.getCalendar().addKeyListener(this);

        V.Estado_Civil();
        this.registro.setTitle("ABOGADOS");
        V.Nuevo();
        V.Campos();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == registro.getBtn_cancelar()) {

            if (V.Validar_Cancelar() == true) {
                int salir = JOptionPane.showConfirmDialog(null, "Descartar Datos Ingresados", "CANCELAR", JOptionPane.YES_NO_OPTION);
                switch (salir) {
                    case 0:
                        V.Cancelar();
                        V.Nuevo();
                        V.Campos();
                        registro.getBtn_cancelar().setEnabled(false);
                        registro.getBtn_nuevo().setEnabled(true);
                        break;
                    case 1:
                        V.Campo_Vacio();
                        break;
                }
            }
        }

        if (evt.getSource() == registro.getBtn_imagen()) {

            registro.Cargar_Imagen();
            V.Campo_Vacio();
        }

        if (evt.getSource() == registro.getBtn_nuevo()) {

            V.Activar_Campos();
        }
        if (evt.getSource() == registro.getCb_estado()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getCb_1()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getCb_2()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getCb_3()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getCb_4()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getBtn_guardar()) {

            if (!(registro.getLb_foto().getIcon() == null)) {
                try {

                    Path Destino = Paths.get(Dest);
                    Path Origen = Paths.get(Orig);
                    Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    Logger.getLogger(V_Registro_Abogado.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            String horario = "";
            if (registro.getCb_1().isSelected() == true) {

                horario = horario + registro.getCb_1().getText();
            }
            if (registro.getCb_2().isSelected() == true) {

                horario = horario + registro.getCb_2().getText();
            }
            if (registro.getCb_3().isSelected() == true) {

                horario = horario + registro.getCb_3().getText();
            }
            if (registro.getCb_4().isSelected() == true) {

                horario = horario + registro.getCb_4().getText();
            }

            String estado = (String) registro.getCb_estado().getSelectedItem();
            String fechas = "";
            if (!(registro.getCalendar().getDate() == null)) {
                Date fecha = registro.getCalendar().getDate();
                DateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
                fechas = Formato.format(fecha);
            }

            if (!registro.getTxt_cedula().getText().equals("") && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
                if (!Lista_Secretaria.isEmpty() && !Lista_abogado.isEmpty() && !Lista_cliente.isEmpty()) {
                    if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                        if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                            int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:
                                    V.Nuevo();
                                    Lista_abogado.add(AB);
                                    V.Campos();
                                    registro.getBtn_cancelar().setEnabled(false);
                                    registro.getBtn_nuevo().setEnabled(true);
                                    break;
                                case 1:
                                    V.Campo_Vacio();
                                    JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                    break;
                            }
                        } else {

                            V.Campo_Vacio();
                            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {

                        V.Campo_Vacio();
                        JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                V.Campo_Vacio();
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            }

            if (Lista_abogado.size() <= 0 && Lista_Secretaria.size() <= 0 && Lista_cliente.size() <= 0 && !registro.getTxt_cedula().getText().equals("") && !registro.getTxt_nombre().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !registro.getTxt_apellido().getText().equals("") && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
                if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:
                            V.Nuevo();
                            Lista_abogado.add(AB);
                            V.Campos();
                            registro.getBtn_cancelar().setEnabled(false);
                            registro.getBtn_nuevo().setEnabled(true);
                            break;
                        case 1:
                            V.Campo_Vacio();
                            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                            break;
                    }
                } else {

                    V.Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (!(Lista_abogado.size() <= 0) && Lista_Secretaria.size() <= 0 && Lista_cliente.size() <= 0 && !registro.getTxt_cedula().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                V.Nuevo();
                                Lista_abogado.add(AB);
                                V.Campos();
                                registro.getBtn_cancelar().setEnabled(false);
                                registro.getBtn_nuevo().setEnabled(true);
                                break;
                            case 1:
                                V.Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        V.Campo_Vacio();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }

            } else if (!(Lista_abogado.size() <= 0) && !(Lista_Secretaria.size() <= 0) && Lista_cliente.size() <= 0 && !registro.getTxt_cedula().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                V.Nuevo();
                                Lista_abogado.add(AB);
                                V.Campos();
                                registro.getBtn_cancelar().setEnabled(false);
                                registro.getBtn_nuevo().setEnabled(true);
                                break;
                            case 1:
                                V.Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        V.Campo_Vacio();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }

            } else if (!(Lista_abogado.size() <= 0) && Lista_Secretaria.size() <= 0 && !(Lista_cliente.size() <= 0) && !registro.getTxt_cedula().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                V.Nuevo();
                                Lista_abogado.add(AB);
                                V.Campos();
                                registro.getBtn_cancelar().setEnabled(false);
                                registro.getBtn_nuevo().setEnabled(true);
                                break;
                            case 1:
                                V.Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        V.Campo_Vacio();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (Lista_abogado.size() <= 0 && !(Lista_Secretaria.size() <= 0) && !(Lista_cliente.size() <= 0) && !registro.getTxt_cedula().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                V.Nuevo();
                                Lista_abogado.add(AB);
                                V.Campos();
                                registro.getBtn_cancelar().setEnabled(false);
                                registro.getBtn_nuevo().setEnabled(true);
                                break;
                            case 1:
                                V.Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        V.Campo_Vacio();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (Lista_abogado.isEmpty() && Lista_Secretaria.isEmpty() && !(Lista_cliente.size() <= 0) && !registro.getTxt_cedula().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                V.Nuevo();
                                Lista_abogado.add(AB);
                                V.Campos();
                                registro.getBtn_cancelar().setEnabled(false);
                                registro.getBtn_nuevo().setEnabled(true);
                                break;
                            case 1:
                                V.Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        V.Campo_Vacio();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (Lista_abogado.isEmpty() && !Lista_Secretaria.isEmpty() && Lista_cliente.isEmpty() && !registro.getTxt_cedula().getText().equals("") && !registro.getTxt_nombre().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !registro.getTxt_apellido().getText().equals("") && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                V.Nuevo();
                                Lista_abogado.add(AB);
                                V.Campos();
                                registro.getBtn_cancelar().setEnabled(false);
                                registro.getBtn_nuevo().setEnabled(true);
                                break;
                            case 1:
                                V.Campo_Vacio();
                                JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS CON LA INFORMACION CORRECTA");
                                break;
                        }
                    } else {

                        V.Campo_Vacio();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

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
        if (evt.getSource() == registro.getTxt_celular()) {
            char c = evt.getKeyChar();
            if (c >= '0' && c <= '9' && registro.getTxt_celular().getText().length() <= 9) {
            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == registro.getTxt_cuenta()) {
            char c = evt.getKeyChar();

            if (c < '0' || c > '9') {
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
        if (evt.getSource() == registro.getTxt_matricula()) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && registro.getTxt_matricula().getText().length() <= 9) {

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
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getTxt_correo()) {
            V.Campo_Vacio();

            if (V.Validar_Correo(registro.getTxt_correo().getText())) {

                registro.correo.setVisible(false);
            } else {

                if (registro.getLb_correo().isShowing() == true) {

                    registro.correo.setVisible(false);
                } else {
                    registro.correo.setVisible(true);
                }
            }

            if (V.Validar_Correo() == true) {
                registro.datocorreo.setVisible(false);
            } else {
                registro.datocorreo.setVisible(true);
            }
        }
        if (evt.getSource() == registro.getTxt_apellido()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getTxt_cedula()) {
            V.Campo_Vacio();

            if (V.Validar_Cedula() == true) {
                registro.datocedula.setVisible(false);
            } else {
                registro.datocedula.setVisible(true);
            }
        }
        if (evt.getSource() == registro.getCalendar()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getTxt_celular()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getTxt_cuenta()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getTxt_direccion()) {
            V.Campo_Vacio();
        }
        if (evt.getSource() == registro.getTxt_matricula()) {
            V.Campo_Vacio();
            if (V.Validar_Matricula() == true) {
                registro.datomatricula.setVisible(false);
            } else {
                registro.datomatricula.setVisible(true);
            }
        }
    }
}
