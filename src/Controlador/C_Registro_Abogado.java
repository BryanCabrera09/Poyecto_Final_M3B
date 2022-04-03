package controlador;

import Metodos.Validar_Abogados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Cliente;
import Modelo.Buf_ClienteDB;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import Modelo.Buf_Secretaria;
import Modelo.Buf_SecretariaDB;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import vista.V_Registro_Abogado;

/*
 * @author BRYAN_CABRERA
 */
public class C_Registro_Abogado implements ActionListener, KeyListener {

    V_Registro_Abogado registro;
    Buf_Abogado A;
    Buf_Persona P;
    Buf_AbogadoDB A_DB;
    Buf_PersonaDB P_DB;
    Buf_SecretariaDB S_DB;
    Buf_ClienteDB C_DB;
    Validar_Abogados V;

    public C_Registro_Abogado(Buf_Abogado A, Buf_Persona P, V_Registro_Abogado registro, Buf_AbogadoDB A_DB, Buf_PersonaDB P_DB, Buf_SecretariaDB S_DB, Buf_ClienteDB C_DB, Validar_Abogados V) {
        this.A = A;
        this.P = P;
        this.registro = registro;
        this.A_DB = A_DB;
        this.P_DB = P_DB;
        this.S_DB = S_DB;
        this.C_DB = C_DB;
        this.V = V;
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
        this.registro.getTxt_cuenta().addKeyListener(this);
        this.registro.getCalendar().addKeyListener(this);

        registro.setTitle("ABOGADOS");
        this.V.Estado_Civil();
        this.V.Nuevo();
        this.V.Campos();
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

            List<Buf_Abogado> List_abg = A_DB.Getter();
            List<Buf_Secretaria> List_secre = S_DB.Getter();
            List<Buf_Cliente> List_cliente = C_DB.Getter();

            if (V.Validar_Datos() == true) {
                if (!List_secre.isEmpty() && !List_abg.isEmpty() && !List_cliente.isEmpty()) {
                    if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                        if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                            int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                            switch (resp) {
                                case 0:
                                    Subir_Datos();
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

            if (List_abg.size() <= 0 && List_secre.size() <= 0 && List_cliente.size() <= 0 && V.Validar_Datos() == true) {
                if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:
                            Subir_Datos();
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
            } else if (!(List_abg.size() <= 0) && List_secre.size() <= 0 && List_cliente.size() <= 0 && (V.Validar_Datos() == true)) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Subir_Datos();
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

            } else if (!(List_abg.size() <= 0) && !(List_secre.size() <= 0) && List_cliente.size() <= 0 && (V.Validar_Datos() == true)) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Subir_Datos();
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

            } else if (!(List_abg.size() <= 0) && List_secre.size() <= 0 && !(List_cliente.size() <= 0) && (V.Validar_Datos() == true)) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Subir_Datos();
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
            } else if (List_abg.size() <= 0 && !(List_secre.size() <= 0) && !(List_cliente.size() <= 0) && (V.Validar_Datos() == true)) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Subir_Datos();
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
            } else if (List_abg.isEmpty() && List_secre.isEmpty() && !(List_cliente.size() <= 0) && (V.Validar_Datos() == true)) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Subir_Datos();
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
            } else if (List_abg.isEmpty() && !List_secre.isEmpty() && List_cliente.isEmpty() && (V.Validar_Datos() == true)) {
                if (V.Validar_Cedula() == true && V.Validar_Correo() == true && V.Validar_Matricula() == true) {
                    if (V.Validar_Correo(registro.getTxt_correo().getText()) && V.Verificar_Cedula(registro.getTxt_cedula().getText()) && registro.getTxt_celular().getText().length() == 10) {
                        int resp = JOptionPane.showConfirmDialog(null, "LOS DATOS INGRESADOS SON CORRECTOS...?", "AVISO", JOptionPane.YES_NO_OPTION);
                        switch (resp) {
                            case 0:
                                Subir_Datos();
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

    public void Subir_Datos() {

        String horario = " | ";
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
        if (registro.getCalendar().getDate() != null) {
            Date fecha = registro.getCalendar().getDate();
            DateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");
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

        A.setId_abg(V.Id_Generator());
        A.setNum_matricula(Integer.parseInt(registro.getTxt_matricula().getText()));
        A.setCedula(registro.getTxt_cedula().getText());
        A.setNum_cuenta(Integer.parseInt(registro.getTxt_cuenta().getText()));
        A.setHorario(horario);
        File ruta = new File(registro.rutas);

        try {
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            A.setFoto(icono);
        } catch (Exception ex) {
            A.setFoto(null);
        }
        
        if (P_DB.Register(P)) {
            

        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        if (A_DB.Register(A)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            V.Nuevo();
            V.Campos();
            registro.getBtn_cancelar().setEnabled(false);
            registro.getBtn_nuevo().setEnabled(true);
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

            if (c >= '0' && c <= '9' && registro.getTxt_cuenta().getText().length() <= 9) {

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

            if (c >= '0' && c <= '9' && registro.getTxt_matricula().getText().length() <= 7) {

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
