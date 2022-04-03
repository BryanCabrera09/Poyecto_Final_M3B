/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Metodos.Validar_Abogados;
import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Cliente;
import Modelo.Buf_ClienteDB;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import Modelo.Buf_Secretaria;
import Modelo.Buf_SecretariaDB;
import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.V_Modificar_Abogado;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Abogado implements ActionListener, KeyListener, MouseListener {

    V_Modificar_Abogado modificar;
    Buf_Abogado A;
    Buf_Persona P;
    Buf_Usuarios U;
    Buf_AbogadoDB A_DB;
    Buf_PersonaDB P_DB;
    Buf_SecretariaDB S_DB;
    Buf_ClienteDB C_DB;
    Buf_UsuariosDB U_DB;
    Validar_Abogados V;

    Image img;
    private DefaultTableModel modelo;

    public C_Modificar_Abogado(Buf_Abogado A, Buf_Persona P, Buf_Usuarios U, V_Modificar_Abogado modificar, Buf_AbogadoDB A_DB, Buf_PersonaDB P_DB, Buf_SecretariaDB S_DB, Buf_ClienteDB C_DB, Buf_UsuariosDB U_DB, Validar_Abogados V) {
        this.A = A;
        this.P = P;
        this.U = U;
        this.modificar = modificar;
        this.A_DB = A_DB;
        this.P_DB = P_DB;
        this.S_DB = S_DB;
        this.C_DB = C_DB;
        this.U_DB = U_DB;
        this.V = V;
        
        this.modificar.getBtn_cancelar().addActionListener(this);
        this.modificar.getBtn_elimina().addActionListener(this);
        this.modificar.getBtn_guardar().addActionListener(this);
        this.modificar.getBtn_imagen().addActionListener(this);
        this.modificar.getBtn_modificar().addActionListener(this);
        this.modificar.getCb_estado().addActionListener(this);
        this.modificar.getCb_1().addActionListener(this);
        this.modificar.getCb_2().addActionListener(this);
        this.modificar.getCb_3().addActionListener(this);
        this.modificar.getCb_4().addActionListener(this);

        this.modificar.getTablepersona().addMouseListener(this);

        this.modificar.getTxt_apellido().addKeyListener(this);
        this.modificar.getTxt_cuenta().addKeyListener(this);
        this.modificar.getTxt_buscar().addKeyListener(this);
        this.modificar.getTxt_celular().addKeyListener(this);
        this.modificar.getTxt_correo().addKeyListener(this);
        this.modificar.getTxt_direccion().addKeyListener(this);
        this.modificar.getTxt_nombre().addKeyListener(this);

        this.V.Estado_Civil();
        this.V.Campos_Modificar();
        Datos_Table();

    }

    public void Datos_Table() {

        modificar.getTablepersona().getTableHeader().setResizingAllowed(false);
        modificar.getTablepersona().getTableHeader().setReorderingAllowed(false);

        modificar.getTablepersona().setDefaultEditor(Object.class, null);
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

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Persona> List_per = P_DB.Getter();

        for (Buf_Persona persona : List_per) {

            for (Buf_Abogado abogado : List_abg) {

                Object[] fila = new Object[8];
                fila[0] = persona.getCedula();
                fila[1] = persona.getNombre();
                fila[2] = persona.getApellido();
                fila[3] = persona.getCorreo();
                fila[4] = persona.getFecha_Nacimiento();
                fila[5] = persona.getNum_celular();
                fila[6] = persona.getDireccion();
                fila[7] = abogado.getNum_matricula();
                modelo.addRow(fila);
            }
        }
        modificar.getTablepersona().setModel(modelo);
    }

    public void Actualizar_Tabla() {

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Persona> List_per = P_DB.Getter();

        for (Buf_Persona persona : List_per) {

            for (Buf_Abogado abogado : List_abg) {

                Object[] fila = new Object[8];
                fila[0] = persona.getCedula();
                fila[1] = persona.getNombre();
                fila[2] = persona.getApellido();
                fila[3] = persona.getCorreo();
                fila[4] = persona.getFecha_Nacimiento();
                fila[5] = persona.getNum_celular();
                fila[6] = persona.getDireccion();
                fila[7] = abogado.getNum_matricula();
                modelo.addRow(fila);
            }
        }
        modificar.getTablepersona().setModel(modelo);
    }

    public void Limpiar_Tabla() {

        modelo.setRowCount(0);
        modificar.getTxt_cedula().setText("");
        modificar.getTxt_nombre().setText("");
        modificar.getCb_estado().setSelectedIndex(0);
        modificar.getTxt_apellido().setText("");
        modificar.getTxt_celular().setText("");
        modificar.getTxt_cuenta().setText("");
        modificar.getTxt_direccion().setText("");
        modificar.getTxt_matricula().setText("");
        modificar.getTxt_correo().setText("");
        modificar.getCb_1().setSelected(false);
        modificar.getCb_2().setSelected(false);
        modificar.getCb_3().setSelected(false);
        modificar.getCb_4().setSelected(false);
        modificar.nacimeinto.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == modificar.getBtn_cancelar()) {

            V.Cancelar_Modificar();
        }
        if (evt.getSource() == modificar.getBtn_elimina()) {

            List<Buf_Abogado> List_abg = A_DB.Getter();
            List<Buf_Usuarios> List_user = U_DB.Getter();

            for (int i = 0; i < List_abg.size(); i++) {
                if (List_abg.get(i).getId_abg() == V.Id_Generator_Modificar()) {
                    int elimina = JOptionPane.showConfirmDialog(null, "ELIMINAR REGISTRO", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (elimina) {
                        case 0:

                            A.setId_abg(V.Id_Generator_Modificar());

                            if (A_DB.Delete(A)) {

                                V.Nuevo_Modificar();
                                modificar.getTxt_buscar().setEditable(true);
                                modificar.getBtn_modificar().setEnabled(false);
                                modificar.getBtn_elimina().setEnabled(false);
                                Limpiar_Tabla();
                                Actualizar_Tabla();
                            } else {

                                JOptionPane.showConfirmDialog(null, "Proceso de Eliminacion Cancelado");
                            }
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "ELIMINACION CANCELADA");
                            break;
                    }
                }
            }

            for (int i = 0; i < List_user.size(); i++) {
                if (List_user.get(i).getId_abg() == V.Id_Generator_Modificar()) {

                    A.setId_abg(V.Id_Generator_Modificar());

                    if (U_DB.Delete(U)) {

                    } else {

                        JOptionPane.showConfirmDialog(null, "Proceso de Eliminacion Cancelado");
                    }
                }
            }
        }
        if (evt.getSource() == modificar.getBtn_guardar()) {

            List<Buf_Abogado> List_abg = A_DB.Getter();
            List<Buf_Secretaria> List_secre = S_DB.Getter();
            List<Buf_Cliente> List_cliente = C_DB.Getter();

            if (V.Valdar_Datos_Modificar() == true) {
                if (!List_secre.isEmpty() && !List_abg.isEmpty() && !List_cliente.isEmpty()) {
                    if (V.Validar_Correo() == true) {
                        if (V.Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                            V.Campo_Vacio_Modificar();
                            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {

                        V.Campo_Vacio_Modificar();
                        JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                V.Campo_Vacio_Modificar();
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            }

            if (List_abg.size() <= 0 && List_secre.size() <= 0 && List_cliente.size() <= 0 && V.Valdar_Datos_Modificar() == true) {
                if (V.Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                    V.Campo_Vacio_Modificar();
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (!(List_abg.size() <= 0) && List_secre.size() <= 0 && List_cliente.size() <= 0 && V.Valdar_Datos_Modificar() == true) {
                if (V.Validar_Correo() == true) {
                    if (V.Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                        V.Campo_Vacio_Modificar();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio_Modificar();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }

            } else if (!(List_abg.size() <= 0) && !(List_secre.size() <= 0) && List_cliente.size() <= 0 && V.Valdar_Datos_Modificar() == true) {
                if (V.Validar_Correo() == true) {
                    if (V.Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                        V.Campo_Vacio_Modificar();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio_Modificar();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }

            } else if (!(List_abg.size() <= 0) && List_secre.size() <= 0 && !(List_cliente.size() <= 0) && V.Valdar_Datos_Modificar() == true) {
                if (V.Validar_Correo() == true) {
                    if (V.Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                        V.Campo_Vacio_Modificar();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio_Modificar();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }

            } else if (List_abg.size() <= 0 && !(List_secre.size() <= 0) && !(List_cliente.size() <= 0) && V.Valdar_Datos_Modificar() == true) {
                if (V.Validar_Correo() == true) {
                    if (V.Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                        V.Campo_Vacio_Modificar();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio_Modificar();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (List_abg.isEmpty() && List_secre.isEmpty() && !(List_cliente.size() <= 0) && V.Valdar_Datos_Modificar() == true) {
                if (V.Validar_Correo() == true) {
                    if (V.Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                        V.Campo_Vacio_Modificar();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio_Modificar();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else if (List_abg.isEmpty() && !List_secre.isEmpty() && List_cliente.isEmpty() && V.Valdar_Datos_Modificar() == true) {
                if (V.Validar_Correo() == true) {
                    if (V.Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                        V.Campo_Vacio_Modificar();
                        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    V.Campo_Vacio_Modificar();
                    JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (evt.getSource() == modificar.getBtn_imagen()) {

            modificar.Cargar_Imagen();

            V.Campo_Vacio_Modificar();
        }
        if (evt.getSource() == modificar.getBtn_modificar()) {

            V.Modificar();
        }
        if (evt.getSource() == modificar.getCb_estado()) {
            if (modificar.getCb_estado().isEditable() == true) {
                V.Campo_Vacio_Modificar();
            }
        }
        if (evt.getSource() == modificar.getCb_1()) {
            if (modificar.getCb_1().isEnabled() == true) {
                V.Campo_Vacio_Modificar();
            }
        }
        if (evt.getSource() == modificar.getCb_2()) {
            if (modificar.getCb_2().isEnabled() == true) {
                V.Campo_Vacio_Modificar();
            }
        }
        if (evt.getSource() == modificar.getCb_3()) {
            if (modificar.getCb_3().isEnabled() == true) {
                V.Campo_Vacio_Modificar();
            }
        }
        if (evt.getSource() == modificar.getCb_4()) {
            if (modificar.getCb_4().isEnabled() == true) {
                V.Campo_Vacio_Modificar();
            }
        }
    }

    public void Subir_Datos() {

        int select = modificar.getTablepersona().getSelectedRow();

        String horario = " | ";
        if (modificar.getCb_1().isSelected() == true) {

            horario = horario + modificar.getCb_1().getText();
        }
        if (modificar.getCb_2().isSelected() == true) {

            horario = horario + modificar.getCb_2().getText();
        }
        if (modificar.getCb_3().isSelected() == true) {

            horario = horario + modificar.getCb_3().getText();
        }
        if (modificar.getCb_4().isSelected() == true) {

            horario = horario + modificar.getCb_4().getText();
        }

        String estado = (String) modificar.getCb_estado().getSelectedItem();

        P.setNombre(modificar.getTxt_nombre().getText());
        P.setApellido(modificar.getTxt_apellido().getText());
        P.setCorreo(modificar.getTxt_correo().getText());
        P.setDireccion(modificar.getTxt_direccion().getText());
        P.setNum_celular(modificar.getTxt_celular().getText());
        P.setEstado_civil(estado);
        P.setCedula(modificar.getTxt_cedula().getText());

        A.setNum_cuenta(Integer.parseInt(modificar.getTxt_cuenta().getText()));
        A.setHorario(horario);
        File ruta = new File(modificar.rutas);

        try {
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            A.setFoto(icono);
        } catch (Exception ex) {
            A.setFoto(null);
        }
        A.setId_abg(V.Id_Generator_Modificar());

        if (P_DB.Update(P)) {

            if (A_DB.Update(A)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado");
                V.Campos_Modificar();
                Limpiar_Tabla();
                Actualizar_Tabla();
                V.Nuevo_Modificar();
            } else {

                JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (evt.getSource() == modificar.getTxt_cuenta()) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && modificar.getTxt_cuenta().getText().length() <= 9) {

            } else {
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
        if (evt.getSource() == modificar.getTxt_nombre()) {
            char c = evt.getKeyChar();

            if ((c < 'a' && c < 'z') && (c < 'A' && c < 'Z')) {
                evt.consume();
            }
        }
        if (evt.getSource() == modificar.getTxt_buscar()) {
            char c = evt.getKeyChar();

            if (c >= '0' && c <= '9' && modificar.getTxt_buscar().getText().length() <= 9) {

            } else {
                evt.consume();
            }
        }
        if (evt.getSource() == modificar.getTxt_apellido()) {
            int key = evt.getKeyChar();

            if (modificar.getTxt_apellido().getText().length() <= 20) {
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

    }

    public void Buscar() {

        if (modificar.getTxt_buscar().getText().isEmpty()) {

            Limpiar_Tabla();
            Actualizar_Tabla();
        }

        modelo.setRowCount(0);
        List<Buf_Abogado> List_abg = A_DB.Search(modificar.getTxt_buscar().getText());
        List<Buf_Persona> List_per = P_DB.Search(modificar.getTxt_buscar().getText());

        for (Buf_Persona persona : List_per) {

            for (Buf_Abogado abogado : List_abg) {

                Object[] fila = new Object[8];
                fila[0] = persona.getCedula();
                fila[1] = persona.getNombre();
                fila[2] = persona.getApellido();
                fila[3] = persona.getCorreo();
                fila[4] = persona.getFecha_Nacimiento();
                fila[5] = persona.getNum_celular();
                fila[6] = persona.getDireccion();
                fila[7] = abogado.getNum_matricula();
                modelo.addRow(fila);
            }
        }
        modificar.getTablepersona().setModel(modelo);
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getSource() == modificar.getTxt_buscar()) {
            Buscar();
        }
        if (evt.getSource() == modificar.getTxt_cuenta()) {
            if (modificar.getTxt_cuenta().isEditable() == true) {
                V.Campo_Vacio_Modificar();
            }
        }
        if (evt.getSource() == modificar.getTxt_direccion()) {
            if (modificar.getTxt_direccion().isEditable() == true) {
                V.Campo_Vacio_Modificar();
            }
        }
        if (evt.getSource() == modificar.getTxt_celular()) {
            if (modificar.getTxt_celular().isEditable() == true) {
                V.Campo_Vacio_Modificar();
            }
        }
        if (evt.getSource() == modificar.getTxt_correo()) {
            if (modificar.getTxt_correo().isEditable() == true) {
                V.Campo_Vacio_Modificar();
            }

            if (V.Validar_Correo(modificar.getTxt_correo().getText())) {

                modificar.correo.setVisible(false);
            } else {

                if (modificar.getLb_correo().isShowing() == true) {

                    modificar.correo.setVisible(false);
                } else {
                    modificar.correo.setVisible(true);
                }
            }
        }
        if (evt.getSource() == modificar.getTxt_nombre()) {
            if (modificar.getTxt_nombre().isEditable() == true) {
                V.Campo_Vacio_Modificar();
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void Cargar_Table() {

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Persona> List_per = P_DB.Getter();

        int select = modificar.getTablepersona().getSelectedRow();

        if (select != -1) {

            modificar.getCb_1().setSelected(false);
            modificar.getCb_2().setSelected(false);
            modificar.getCb_3().setSelected(false);
            modificar.getCb_4().setSelected(false);

            modificar.getTxt_cedula().setText(List_per.get(select).getCedula());
            modificar.getTxt_nombre().setText(List_per.get(select).getNombre());
            modificar.getTxt_apellido().setText(List_per.get(select).getApellido());
            modificar.getTxt_correo().setText(List_abg.get(select).getCorreo());
            modificar.getTxt_direccion().setText(List_abg.get(select).getDireccion());
            modificar.getTxt_celular().setText(List_abg.get(select).getNum_celular());
            modificar.getCb_estado().setSelectedItem(List_abg.get(select).getEstado_civil());
            modificar.nacimeinto.setText(List_abg.get(select).getFecha_Nacimiento());

            modificar.getTxt_matricula().setText(String.valueOf(List_abg.get(select).getNum_matricula()));
            modificar.getTxt_cuenta().setText(String.valueOf(List_abg.get(select).getNum_cuenta()));

            if (List_abg.get(select).getHorario().equals("9:00-13:00")) {
                modificar.getCb_1().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("13:00-15:00")) {
                modificar.getCb_2().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("15:00-16:30")) {
                modificar.getCb_3().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("16:30-18:30")) {
                modificar.getCb_4().setSelected(true);
            }

            //MAS DE DOS OPCIONES
            if (List_abg.get(select).getHorario().equals("9:00-13:00 | 13:00-15:00")) {
                modificar.getCb_1().setSelected(true);
                modificar.getCb_2().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("9:00-13:00 | 15:00-16:30")) {
                modificar.getCb_1().setSelected(true);
                modificar.getCb_3().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("9:00-13:00 | 16:30-18:30")) {
                modificar.getCb_1().setSelected(true);
                modificar.getCb_4().setSelected(true);
            }

            if (List_abg.get(select).getHorario().equals("13:00-15:00 | 15:00-16:30")) {
                modificar.getCb_2().setSelected(true);
                modificar.getCb_3().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("15:00-16:30 | 16:30-18:30")) {
                modificar.getCb_3().setSelected(true);
                modificar.getCb_4().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("13:00-15:00 | 16:30-18:30")) {
                modificar.getCb_2().setSelected(true);
                modificar.getCb_4().setSelected(true);
            }

            if (List_abg.get(select).getHorario().equals("9:00-13:00 | 13:00-15:00 | 15:00-16:30")) {
                modificar.getCb_1().setSelected(true);
                modificar.getCb_2().setSelected(true);
                modificar.getCb_3().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("9:00-13:00 | 13:00-15:00 | 16:30-18:30")) {
                modificar.getCb_1().setSelected(true);
                modificar.getCb_2().setSelected(true);
                modificar.getCb_4().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("13:00-15:00 | 15:00-16:30 | 16:30-18:30")) {
                modificar.getCb_2().setSelected(true);
                modificar.getCb_3().setSelected(true);
                modificar.getCb_4().setSelected(true);
            }
            if (List_abg.get(select).getHorario().equals("9:00-13:00 | 13:00-15:00 | 15:00-16:30 | 16:30-18:30")) {
                modificar.getCb_1().setSelected(true);
                modificar.getCb_2().setSelected(true);
                modificar.getCb_3().setSelected(true);
                modificar.getCb_4().setSelected(true);
            }

            try {
                byte[] bi = List_abg.get(select).getFoto();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(modificar.getLa_foto().getWidth(), modificar.getLa_foto().getHeight(), img.SCALE_DEFAULT));
                modificar.getLa_foto().setIcon(imgi);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            modificar.getBtn_elimina().setEnabled(true);
            modificar.getBtn_modificar().setEnabled(true);
            modificar.getBtn_imagen().setEnabled(false);
            modificar.getTxt_buscar().setEditable(true);
        }
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
}
