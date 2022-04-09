/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_ClienteDB;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import Modelo.Buf_Secretaria;
import Modelo.Buf_SecretariaDB;
import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import java.awt.Image;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.V_Modificar_Abogado;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Abogado {

    V_Modificar_Abogado modificar;
    Buf_Abogado A = new Buf_Abogado();
    Buf_Persona P = new Buf_Persona();
    Buf_Usuarios U = new Buf_Usuarios();
    Buf_Secretaria S = new Buf_Secretaria();
    Buf_AbogadoDB A_DB = new Buf_AbogadoDB();
    Buf_PersonaDB P_DB = new Buf_PersonaDB();
    Buf_SecretariaDB S_DB = new Buf_SecretariaDB();
    Buf_ClienteDB C_DB = new Buf_ClienteDB();
    Buf_UsuariosDB U_DB = new Buf_UsuariosDB();

    Image img;
    private DefaultTableModel modelo;

    public C_Modificar_Abogado(V_Modificar_Abogado modificar) {

        this.modificar = modificar;

        Estado_Civil_Modificar();
        Campos_Modificar();
        Nuevo_Modificar();
        Datos_Table();

    }

    public void Iniciar_Control() {

        KeyListener K = new KeyListener() {
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

            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getSource() == modificar.getTxt_buscar()) {
                    Buscar();
                }
                if (evt.getSource() == modificar.getTxt_cuenta()) {
                    if (modificar.getTxt_cuenta().isEditable() == true) {
                        Campo_Vacio_Modificar();
                    }
                }
                if (evt.getSource() == modificar.getTxt_direccion()) {
                    if (modificar.getTxt_direccion().isEditable() == true) {
                        Campo_Vacio_Modificar();
                    }
                }
                if (evt.getSource() == modificar.getTxt_celular()) {
                    if (modificar.getTxt_celular().isEditable() == true) {
                        Campo_Vacio_Modificar();
                    }
                }
                if (evt.getSource() == modificar.getTxt_correo()) {
                    if (modificar.getTxt_correo().isEditable() == true) {
                        Campo_Vacio_Modificar();
                    }

                    if (Validar_Correo(modificar.getTxt_correo().getText())) {

                        modificar.getCorreo().setVisible(false);
                    } else {

                        if (modificar.getLb_correo().isShowing() == true) {

                            modificar.getCorreo().setVisible(false);
                        } else {
                            modificar.getCorreo().setVisible(true);
                        }
                    }
                }
                if (evt.getSource() == modificar.getTxt_nombre()) {
                    if (modificar.getTxt_nombre().isEditable() == true) {
                        Campo_Vacio_Modificar();
                    }
                }
                if (evt.getSource() == modificar.getTxt_apellido()) {
                    if (modificar.getTxt_apellido().isEditable() == true) {
                        Campo_Vacio_Modificar();
                    }
                }
            }
        };

        modificar.getTxt_apellido().addKeyListener(K);
        modificar.getTxt_cuenta().addKeyListener(K);
        modificar.getTxt_buscar().addKeyListener(K);
        modificar.getTxt_celular().addKeyListener(K);
        modificar.getTxt_correo().addKeyListener(K);
        modificar.getTxt_direccion().addKeyListener(K);
        modificar.getTxt_nombre().addKeyListener(K);

        //ACCIONAR MOUSELISTNER
        MouseListener M = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
        };

        modificar.getTablepersona().addMouseListener(M);

        //ACCIONAR BOTONES
        modificar.getBtn_cancelar().addActionListener(l -> {
            Cancelar_Modificar();
        });
        modificar.getBtn_elimina().addActionListener(l -> {
            Eliminar_Datos();
        });
        modificar.getBtn_guardar().addActionListener(l -> {
            Guardar_Datos();
        });
        modificar.getBtn_imagen().addActionListener(l -> {
            modificar.Cargar_Imagen();
            Campo_Vacio_Modificar();
        });
        modificar.getBtn_modificar().addActionListener(l -> {
            Modificar();
        });
        modificar.getCb_estado().addActionListener(l -> {
            if (modificar.getCb_estado().isEditable() == true) {
                Campo_Vacio_Modificar();
            }
        });
        modificar.getCb_1().addActionListener(l -> {
            if (modificar.getCb_1().isEnabled() == true) {
                Campo_Vacio_Modificar();
            }
        });
        modificar.getCb_2().addActionListener(l -> {
            if (modificar.getCb_2().isEnabled() == true) {
                Campo_Vacio_Modificar();
            }
        });
        modificar.getCb_3().addActionListener(l -> {
            if (modificar.getCb_3().isEnabled() == true) {
                Campo_Vacio_Modificar();
            }
        });
        modificar.getCb_4().addActionListener(l -> {
            if (modificar.getCb_4().isEnabled() == true) {
                Campo_Vacio_Modificar();
            }
        });
    }

    public void Datos_Table() {

        modificar.getTablepersona().getTableHeader().setResizingAllowed(false);
        modificar.getTablepersona().getTableHeader().setReorderingAllowed(false);

        modificar.getTablepersona().setDefaultEditor(Object.class, null);
        modelo = new DefaultTableModel() {
            //CARGAR CAMPOS EN LA TABLA
            public boolean iscelleditable(int filas, int columnas) {
                if (columnas == 7) {
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

        List<Buf_Persona> List_per = P_DB.Getter_Abg();

        List_per.stream().map((persona) -> {
            Object[] fila = new Object[7];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellido();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getFecha_Nacimiento();
            fila[5] = persona.getNum_celular();
            fila[6] = persona.getDireccion();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        modificar.getTablepersona().setModel(modelo);
    }

    public void Buscar() {

        if (modificar.getTxt_buscar().getText().isEmpty()) {

            Limpiar_Tabla();
            Actualizar_Tabla();
        }

        modelo.setRowCount(0);
        List<Buf_Persona> List_per = P_DB.Search_Abg(modificar.getTxt_buscar().getText());

        List_per.stream().map((persona) -> {
            Object[] fila = new Object[7];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellido();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getFecha_Nacimiento();
            fila[5] = persona.getNum_celular();
            fila[6] = persona.getDireccion();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
        modificar.getTablepersona().setModel(modelo);
    }

    public void Actualizar_Tabla() {

        List<Buf_Persona> List_per = P_DB.Getter_Abg();

        List_per.stream().map((persona) -> {
            Object[] fila = new Object[7];
            fila[0] = persona.getCedula();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellido();
            fila[3] = persona.getCorreo();
            fila[4] = persona.getFecha_Nacimiento();
            fila[5] = persona.getNum_celular();
            fila[6] = persona.getDireccion();
            return fila;
        }).forEachOrdered((fila) -> {
            modelo.addRow(fila);
        });
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
        modificar.getTxt_id().setText("");
        modificar.getTxt_buscar().setText("");
        modificar.getCb_1().setSelected(false);
        modificar.getCb_2().setSelected(false);
        modificar.getCb_3().setSelected(false);
        modificar.getCb_4().setSelected(false);
        modificar.getNacimeinto().setText("");
    }

    public void Guardar_Datos() {

        if (Validar_Datos_Modificar() == true) {
            if (Validar_Correo_Modificar() == true) {
                if (Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
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

                    Campo_Vacio_Modificar();
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS ERRONEOS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            } else {

                Campo_Vacio_Modificar();
                JOptionPane.showMessageDialog(null, "DATOS YA INGRESADO", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            Campo_Vacio_Modificar();
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
        }
    }

    public void Eliminar_Datos() {

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Usuarios> List_user = U_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();
        List<Buf_Persona> List_per = P_DB.Getter();

        for (int i = 0; i < List_abg.size(); i++) {
            if (List_abg.get(i).getId_abg() == Integer.parseInt(modificar.getTxt_id().getText())) {
                int elimina = JOptionPane.showConfirmDialog(null, "ELIMINAR REGISTRO", "AVISO", JOptionPane.YES_NO_OPTION);
                switch (elimina) {
                    case 0:

                        for (int u = 0; u < List_user.size(); u++) {
                            if (List_user.get(u).getId_User() == Integer.parseInt(modificar.getTxt_id().getText())) {

                                U.setId_User(Integer.parseInt(modificar.getTxt_id().getText()));

                                if (U_DB.Delete(U)) {

                                } else {

                                    JOptionPane.showMessageDialog(null, "Proceso de Eliminacion Cancelado", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }

                        if (!List_secre.isEmpty()) {
                            for (int j = 0; j < List_secre.size(); j++) {

                                if (List_secre.get(i).getId_abg() == Integer.parseInt(modificar.getTxt_id().getText())) {

                                    S.setId_abg(Integer.parseInt(modificar.getTxt_id().getText()));

                                    if (S_DB.Delete_From_Abg(S)) {

                                    } else {

                                        JOptionPane.showMessageDialog(null, "Proceso de Eliminacion Cancelado", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        }
                        A.setId_abg(Integer.parseInt(modificar.getTxt_id().getText()));

                        if (A_DB.Delete(A)) {

                            for (int p = 0; p < List_per.size(); p++) {
                                if (List_per.get(p).getCedula().equalsIgnoreCase(modificar.getTxt_cedula().getText())) {

                                    P.setCedula(modificar.getTxt_cedula().getText());

                                    Nuevo_Modificar();
                                    modificar.getTxt_buscar().setEditable(true);
                                    modificar.getBtn_modificar().setEnabled(false);
                                    modificar.getBtn_elimina().setEnabled(false);

                                    if (P_DB.Delete(P)) {

                                    } else {

                                        JOptionPane.showMessageDialog(null, "Proceso de Eliminacion Cancelado", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                            Limpiar_Tabla();
                            Actualizar_Tabla();
                        } else {

                            JOptionPane.showMessageDialog(null, "Proceso de Eliminacion Cancelado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "ELIMINACION CANCELADA");
                        break;
                }
            }
        }
    }

    public void Subir_Datos() {

        String horario = "";
        if (modificar.getCb_1().isSelected() == true) {

            horario = horario + " | " + modificar.getCb_1().getText() + " | ";
        }
        if (modificar.getCb_2().isSelected() == true) {

            horario = horario + " | " + modificar.getCb_2().getText() + " | ";
        }
        if (modificar.getCb_3().isSelected() == true) {

            horario = horario + " | " + modificar.getCb_3().getText() + " | ";
        }
        if (modificar.getCb_4().isSelected() == true) {

            horario = horario + " | " + modificar.getCb_4().getText() + " | ";
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
        A.setId_abg(Integer.parseInt(modificar.getTxt_id().getText()));

        if (P_DB.Update(P)) {

            if (A_DB.Update(A)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado");
                Campos_Modificar();
                Limpiar_Tabla();
                Actualizar_Tabla();
                Nuevo_Modificar();
            } else {

                JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Cargar_Table() {

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Persona> List_per = P_DB.Getter_Abg();

        int select = modificar.getTablepersona().getSelectedRow();

        modificar.getCb_1().setSelected(false);
        modificar.getCb_2().setSelected(false);
        modificar.getCb_3().setSelected(false);
        modificar.getCb_4().setSelected(false);

        modificar.getTxt_cedula().setText(List_per.get(select).getCedula());
        modificar.getTxt_nombre().setText(List_per.get(select).getNombre());
        modificar.getTxt_apellido().setText(List_per.get(select).getApellido());
        modificar.getTxt_correo().setText(List_per.get(select).getCorreo());
        modificar.getTxt_direccion().setText(List_per.get(select).getDireccion());
        modificar.getTxt_celular().setText(List_per.get(select).getNum_celular());
        modificar.getCb_estado().setSelectedItem(List_per.get(select).getEstado_civil());
        modificar.getNacimeinto().setText(List_per.get(select).getFecha_Nacimiento());

        modificar.getTxt_id().setText(String.valueOf(List_abg.get(select).getId_abg()));
        modificar.getTxt_matricula().setText(String.valueOf(List_abg.get(select).getNum_matricula()));
        modificar.getTxt_cuenta().setText(String.valueOf(List_abg.get(select).getNum_cuenta()));

        if (List_abg.get(select).getHorario().equals(" | 9:00-13:00 | ")) {
            modificar.getCb_1().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 13:00-15:00 | ")) {
            modificar.getCb_2().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 15:00-16:30 | ")) {
            modificar.getCb_3().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 16:30-18:30 | ")) {
            modificar.getCb_4().setSelected(true);
        }

        //MAS DE DOS OPCIONES
        if (List_abg.get(select).getHorario().equals(" | 9:00-13:00 |  | 13:00-15:00 | ")) {
            modificar.getCb_1().setSelected(true);
            modificar.getCb_2().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 9:00-13:00 |  | 15:00-16:30 | ")) {
            modificar.getCb_1().setSelected(true);
            modificar.getCb_3().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 9:00-13:00 |  | 16:30-18:30 | ")) {
            modificar.getCb_1().setSelected(true);
            modificar.getCb_4().setSelected(true);
        }

        if (List_abg.get(select).getHorario().equals(" | 13:00-15:00 |  | 15:00-16:30 | ")) {
            modificar.getCb_2().setSelected(true);
            modificar.getCb_3().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 15:00-16:30 |  | 16:30-18:30 | ")) {
            modificar.getCb_3().setSelected(true);
            modificar.getCb_4().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 13:00-15:00 |  | 16:30-18:30 | ")) {
            modificar.getCb_2().setSelected(true);
            modificar.getCb_4().setSelected(true);
        }

        if (List_abg.get(select).getHorario().equals(" | 9:00-13:00 |  | 13:00-15:00 |  | 15:00-16:30 | ")) {
            modificar.getCb_1().setSelected(true);
            modificar.getCb_2().setSelected(true);
            modificar.getCb_3().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 9:00-13:00 |  | 13:00-15:00 |  | 16:30-18:30 | ")) {
            modificar.getCb_1().setSelected(true);
            modificar.getCb_2().setSelected(true);
            modificar.getCb_4().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 13:00-15:00 |  | 15:00-16:30 |  | 16:30-18:30 | ")) {
            modificar.getCb_2().setSelected(true);
            modificar.getCb_3().setSelected(true);
            modificar.getCb_4().setSelected(true);
        }
        if (List_abg.get(select).getHorario().equals(" | 9:00-13:00 |  | 13:00-15:00 |  | 15:00-16:30 |  | 16:30-18:30 | ")) {
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
    }

    public boolean Validar_Datos_Modificar() {

        String estado = (String) modificar.getCb_estado().getSelectedItem();

        if (!modificar.getTxt_nombre().getText().equals("") && !modificar.getTxt_correo().getText().equals("") && !modificar.getTxt_apellido().getText().equals("") && !modificar.getTxt_direccion().getText().equals("") && !modificar.getTxt_celular().getText().equals("") && !modificar.getTxt_cuenta().getText().equals("") && !estado.equals("Seleccionar") && (modificar.getCb_1().isSelected() || modificar.getCb_2().isSelected() || modificar.getCb_3().isSelected() || modificar.getCb_4().isSelected())) {
            return true;
        } else {

            return false;
        }

    }

    public void Estado_Civil_Modificar() {

        modificar.getCb_estado().addItem("Seleccionar");
        modificar.getCb_estado().addItem("Soltero");
        modificar.getCb_estado().addItem("Casado");
        modificar.getCb_estado().addItem("Divorciado");
    }

    public boolean Validar_Correo_Modificar() {

        List<Buf_Persona> List_pers = P_DB.Getter();

        for (int i = 0; i < List_pers.size(); i++) {
            if (List_pers.get(i).getCorreo().equalsIgnoreCase(modificar.getTxt_correo().getText())) {
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

    public void Campo_Vacio_Modificar() {
        String estado = (String) modificar.getCb_estado().getSelectedItem();
        if (modificar.getTxt_nombre().getText().isEmpty()) {
            modificar.getLb_nombre().setVisible(true);
        }

        if (modificar.getTxt_celular().getText().isEmpty()) {
            modificar.getLb_celular().setVisible(true);
        }

        if (modificar.getTxt_correo().getText().isEmpty()) {
            modificar.getLb_correo().setVisible(true);
        }

        if (modificar.getTxt_cuenta().getText().isEmpty()) {
            modificar.getLb_cuenta().setVisible(true);
        }

        if (modificar.getTxt_direccion().getText().isEmpty()) {
            modificar.getLb_direccion().setVisible(true);
        }

        if (estado.equals("Seleccionar")) {
            modificar.getLb_estado().setVisible(true);
        }

        if (modificar.getTxt_apellido().getText().isEmpty()) {
            modificar.getLb_apellido().setVisible(true);
        }

        if (!(modificar.getCb_1().isSelected() || modificar.getCb_2().isSelected() || modificar.getCb_3().isSelected() || modificar.getCb_4().isSelected())) {
            modificar.getLb_horario().setVisible(true);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!modificar.getTxt_nombre().getText().isEmpty()) {
            modificar.getLb_nombre().setVisible(false);
        }

        if (!modificar.getTxt_celular().getText().isEmpty()) {
            modificar.getLb_celular().setVisible(false);
        }

        if (!modificar.getTxt_correo().getText().isEmpty()) {
            modificar.getLb_correo().setVisible(false);
        }

        if (!modificar.getTxt_cuenta().getText().isEmpty()) {
            modificar.getLb_cuenta().setVisible(false);
        }

        if (!modificar.getTxt_direccion().getText().isEmpty()) {
            modificar.getLb_direccion().setVisible(false);
        }

        if (!modificar.getTxt_apellido().getText().isEmpty()) {
            modificar.getLb_apellido().setVisible(false);
        }

        if (!estado.equals("Seleccionar")) {
            modificar.getLb_estado().setVisible(false);
        }

        if ((modificar.getCb_1().isSelected() || modificar.getCb_2().isSelected() || modificar.getCb_3().isSelected() || modificar.getCb_4().isSelected())) {
            modificar.getLb_horario().setVisible(false);
        }

        if (modificar.getLb_celular().isShowing() == true) {
            modificar.getCelular().setVisible(false);
        } else if (modificar.getTxt_celular().getText().length() < 10) {
            modificar.getCelular().setVisible(true);
        } else if (modificar.getTxt_celular().getText().length() == 10) {
            modificar.getCelular().setVisible(false);
        }

        if (!modificar.getTxt_nombre().getText().isEmpty() && !modificar.getTxt_correo().getText().isEmpty() && !modificar.getTxt_direccion().getText().isEmpty() && !(modificar.getLa_foto().getIcon() == null) && !modificar.getTxt_celular().getText().isEmpty() && !modificar.getTxt_cuenta().getText().isEmpty() && !estado.equals("Seleccionar") && (modificar.getCb_1().isSelected() || modificar.getCb_2().isSelected() || modificar.getCb_3().isSelected() || modificar.getCb_4().isSelected())) {
            modificar.getBtn_guardar().setEnabled(true);
        } else {
            modificar.getBtn_guardar().setEnabled(false);
        }
    }

    public void Campos_Modificar() {

        modificar.getCelular().setVisible(false);
        modificar.getLb_nombre().setVisible(false);
        modificar.getLb_correo().setVisible(false);
        modificar.getLb_celular().setVisible(false);
        modificar.getLb_cuenta().setVisible(false);
        modificar.getLb_horario().setVisible(false);
        modificar.getLb_estado().setVisible(false);
        modificar.getLb_direccion().setVisible(false);
        modificar.getLb_apellido().setVisible(false);
        modificar.getCorreo().setVisible(false);
        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_imagen().setEnabled(false);
        modificar.getBtn_cancelar().setEnabled(false);
        modificar.getBtn_modificar().setEnabled(false);
    }

    public void Nuevo_Modificar() {

        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_elimina().setEnabled(false);
        modificar.getTxt_nombre().setEditable(false);
        modificar.getTxt_cedula().setEditable(false);
        modificar.getTxt_apellido().setEditable(false);
        modificar.getTxt_id().setEditable(false);
        modificar.getCb_estado().setEnabled(false);
        modificar.getTxt_celular().setEditable(false);
        modificar.getTxt_cuenta().setEditable(false);
        modificar.getTxt_direccion().setEditable(false);
        modificar.getTxt_matricula().setEditable(false);
        modificar.getTxt_correo().setEditable(false);
        modificar.getCb_1().setEnabled(false);
        modificar.getCb_2().setEnabled(false);
        modificar.getCb_3().setEnabled(false);
        modificar.getCb_4().setEnabled(false);
        modificar.getNacimeinto().setEditable(false);
        modificar.getTxt_buscar().setEditable(true);
        modificar.getTxt_cedula().setText("");
        modificar.getTxt_buscar().setText("");
        modificar.getTxt_id().setText("");
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
        modificar.getNacimeinto().setText("");
        modificar.getLa_foto().setIcon(null);
    }

    public void Modificar() {

        modificar.getTxt_nombre().setEditable(true);
        modificar.getTxt_apellido().setEditable(true);
        modificar.getTxt_cedula().setEditable(false);
        modificar.getTxt_correo().setEditable(true);
        modificar.getTxt_celular().setEditable(true);
        modificar.getTxt_cuenta().setEditable(true);
        modificar.getTxt_buscar().setEditable(false);
        modificar.getTxt_direccion().setEditable(true);
        modificar.getCb_estado().setEnabled(true);
        modificar.getCb_1().setEnabled(true);
        modificar.getCb_2().setEnabled(true);
        modificar.getCb_3().setEnabled(true);
        modificar.getCb_4().setEnabled(true);
        modificar.getTxt_matricula().setEditable(false);
        modificar.getNacimeinto().setEditable(false);
        modificar.getBtn_imagen().setEnabled(true);
        modificar.getBtn_elimina().setEnabled(false);
        modificar.getTxt_buscar().setEditable(false);
        modificar.getBtn_cancelar().setEnabled(true);
        modificar.getBtn_modificar().setEnabled(false);
    }

    public void Cancelar_Modificar() {

        modificar.getTxt_nombre().setEditable(false);
        modificar.getTxt_apellido().setEditable(false);
        modificar.getTxt_cedula().setEditable(false);
        modificar.getTxt_correo().setEditable(false);
        modificar.getTxt_celular().setEditable(false);
        modificar.getTxt_cuenta().setEditable(false);
        modificar.getTxt_direccion().setEditable(false);
        modificar.getCb_estado().setEnabled(false);
        modificar.getCb_1().setEnabled(false);
        modificar.getCb_2().setEnabled(false);
        modificar.getCb_3().setEnabled(false);
        modificar.getCb_4().setEnabled(false);
        modificar.getTxt_matricula().setEditable(false);
        modificar.getNacimeinto().setEditable(false);
        modificar.getBtn_imagen().setEnabled(false);
        modificar.getTxt_buscar().setEditable(true);
        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_cancelar().setEnabled(false);
        modificar.getBtn_elimina().setEnabled(true);
        modificar.getBtn_modificar().setEnabled(true);
    }
}
