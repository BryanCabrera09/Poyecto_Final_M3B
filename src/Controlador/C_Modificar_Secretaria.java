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
import Modelo.DB_Connect;
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
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.V_Modificar_Secretaria;

/*
 * @author BRYAN_CABRERA
 */
public class C_Modificar_Secretaria {

    V_Modificar_Secretaria modificar;
    Buf_Abogado A = new Buf_Abogado();
    Buf_Persona P = new Buf_Persona();
    Buf_Secretaria S = new Buf_Secretaria();
    Buf_Usuarios U = new Buf_Usuarios();
    Buf_AbogadoDB A_DB = new Buf_AbogadoDB();
    Buf_PersonaDB P_DB = new Buf_PersonaDB();
    Buf_UsuariosDB U_DB = new Buf_UsuariosDB();
    Buf_SecretariaDB S_DB = new Buf_SecretariaDB();
    Buf_ClienteDB C_DB = new Buf_ClienteDB();

    Image img;
    private DefaultTableModel modelo;

    public C_Modificar_Secretaria(V_Modificar_Secretaria modificar) {

        this.modificar = modificar;

        Estado_Civil();
        Campos();
        Nuevo();
        Datos_Table();

    }

    public void Iniciar_Control() {

        //EVENTOS TECLADO
        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {

                if (evt.getSource() == modificar.getTxt_celular()) {

                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && modificar.getTxt_celular().getText().length() <= 9) {

                    } else {
                        evt.consume();
                    }
                }
                if (evt.getSource() == modificar.getTxt_nombre()) {
                    int key = evt.getKeyChar();

                    if (modificar.getTxt_nombre().getText().length() <= 20) {
                        boolean letra = key >= 97 && key <= 122 || key == 8 || key >= 65 && key <= 90 || key == 32;

                        if (!letra) {

                            evt.consume();
                        }

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
                if (evt.getSource() == modificar.getTxt_buscar()) {
                    char c = evt.getKeyChar();

                    if (c >= '0' && c <= '9' && modificar.getTxt_buscar().getText().length() <= 9) {

                    } else {
                        evt.consume();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (modificar.getBtn_guardar().isEnabled()) {
                        modificar.getBtn_guardar().doClick();
                    }
                    if (!modificar.getBtn_guardar().isEnabled() && modificar.getBtn_modificar().isEnabled()) {
                        modificar.getBtn_modificar().doClick();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getSource() == modificar.getTxt_buscar()) {
                    Buscar();
                }
                if (evt.getSource() == modificar.getTxt_celular()) {
                    if (modificar.getTxt_celular().isEditable() == true) {
                        Campo_Vacio();
                    }
                }
                if (evt.getSource() == modificar.getTxt_correo()) {
                    if (modificar.getTxt_correo().isEditable() == true) {
                        Campo_Vacio();
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
                if (evt.getSource() == modificar.getTxt_direccion()) {
                    if (modificar.getTxt_direccion().isEditable() == true) {
                        Campo_Vacio();
                    }
                }
                if (evt.getSource() == modificar.getTxt_nombre()) {
                    if (modificar.getTxt_nombre().isEditable() == true) {
                        Campo_Vacio();
                    }
                }
                if (evt.getSource() == modificar.getTxt_apellido()) {
                    if (modificar.getTxt_apellido().isEditable() == true) {
                        Campo_Vacio();
                    }
                }
            }
        };
        modificar.getTxt_celular().addKeyListener(K);
        modificar.getTxt_nombre().addKeyListener(K);
        modificar.getTxt_direccion().addKeyListener(K);
        modificar.getTxt_correo().addKeyListener(K);
        modificar.getTxt_buscar().addKeyListener(K);
        modificar.getTxt_apellido().addKeyListener(K);
        modificar.getBtn_modificar().addKeyListener(K);
        modificar.getBtn_guardar().addKeyListener(K);

        //EVENTOS MOUSE
        MouseListener M = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent evt) {

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

        //ACCION BOTONES
        modificar.getBtn_cancelar().addActionListener(l -> {
            Cancelar_Modificar();
        });
        modificar.getBtn_eliminar().addActionListener(l -> {
            Eliminar_Datos();
        });
        modificar.getBtn_guardar().addActionListener(l -> {
            Guardar();
        });
        modificar.getBtn_imagen().addActionListener(l -> {
            modificar.Cargar_Imagen();
            Campo_Vacio();
        });
        modificar.getBtn_imprimir().addActionListener(l -> {
            Imprimir();
        });
        modificar.getBtn_modificar().addActionListener(l -> {
            Modificar();
        });
        modificar.getCb_estado().addActionListener(l -> {
            if (modificar.getCb_estado().isEnabled() == true) {
                Campo_Vacio();
            }
        });
        modificar.getCb_1().addActionListener(l -> {
            if (modificar.getCb_1().isEnabled() == true) {
                Campo_Vacio();
            }
        });
        modificar.getCb_2().addActionListener(l -> {
            if (modificar.getCb_2().isEnabled() == true) {
                Campo_Vacio();
            }
        });
        modificar.getCb_3().addActionListener(l -> {
            if (modificar.getCb_3().isEnabled() == true) {
                Campo_Vacio();
            }
        });
        modificar.getCb_4().addActionListener(l -> {
            if (modificar.getCb_4().isEnabled() == true) {
                Campo_Vacio();
            }
        });
    }

    public void Imprimir() {

        DB_Connect con = new DB_Connect();
        Connection conn = con.Connect();

        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Report_Secretarias.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            JOptionPane.showMessageDialog(null, "Cargando Reporte...");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Modificar_Abogado.class.getName()).log(Level.SEVERE, null, e);
        }
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

        List<Buf_Persona> List_per = P_DB.Getter_Secre();

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
        List<Buf_Persona> List_per = P_DB.Search_Secre(modificar.getTxt_buscar().getText());

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

    public void Cancelar_Modificar() {

        modificar.getCb_1().setEnabled(false);
        modificar.getCb_2().setEnabled(false);
        modificar.getCb_3().setEnabled(false);
        modificar.getCb_4().setEnabled(false);
        modificar.getTxt_nombre().setEditable(false);
        modificar.getTxt_correo().setEditable(false);
        modificar.getTxt_celular().setEditable(false);
        modificar.getTxt_direccion().setEditable(false);
        modificar.getCb_estado().setEnabled(false);
        modificar.getBtn_imagen().setEnabled(false);
        modificar.getNacimeinto().setEditable(false);
        modificar.getTxt_buscar().setEditable(true);
        modificar.getTxt_apellido().setEditable(false);
        modificar.getBtn_imagen().setEnabled(false);
        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_cancelar().setEnabled(false);
        modificar.getBtn_eliminar().setEnabled(true);
        modificar.getBtn_modificar().setEnabled(true);
    }

    public void Eliminar_Datos() {

        List<Buf_Secretaria> List_secre = S_DB.Getter();
        List<Buf_Usuarios> List_user = U_DB.Getter();
        List<Buf_Persona> List_per = P_DB.Getter();

        for (int i = 0; i < List_secre.size(); i++) {
            if (List_secre.get(i).getId_secretaria() == Integer.parseInt(modificar.getTxt_id().getText())) {
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

                        S.setId_secretaria(Integer.parseInt(modificar.getTxt_id().getText()));

                        if (S_DB.Delete(S)) {

                            for (int p = 0; p < List_per.size(); p++) {
                                if (List_per.get(p).getCedula().equalsIgnoreCase(modificar.getTxt_cedula().getText())) {

                                    P.setCedula(modificar.getTxt_cedula().getText());

                                    Nuevo();
                                    modificar.getTxt_buscar().setEditable(true);
                                    modificar.getBtn_modificar().setEnabled(false);
                                    modificar.getBtn_eliminar().setEnabled(false);

                                    JOptionPane.showMessageDialog(null, "Eliminacion Completada");
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

    public void Guardar() {

        if (Validar_Datos() == true) {
            if (Validar_Correo() == true) {
                if (Validar_Correo(modificar.getTxt_correo().getText()) && modificar.getTxt_celular().getText().length() == 10) {
                    int resp = JOptionPane.showConfirmDialog(null, "GUARDAR CAMBIOS", "AVISO", JOptionPane.YES_NO_OPTION);
                    switch (resp) {
                        case 0:
                            Cargar_Datos();
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
        } else {
            Campo_Vacio();
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
        }
    }

    public String upperCaseFirst(String val) {

        StringBuffer strbf = new StringBuffer();
        Matcher match = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(val);
        while (match.find()) {
            match.appendReplacement(strbf, match.group(1).toUpperCase() + match.group(2).toLowerCase());
        }
        return match.appendTail(strbf).toString();
    }

    public void Cargar_Datos() {

        String estado = (String) modificar.getCb_estado().getSelectedItem();

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

        P.setNombre(upperCaseFirst(modificar.getTxt_nombre().getText()));
        P.setApellido(upperCaseFirst(modificar.getTxt_apellido().getText()));
        P.setCorreo(modificar.getTxt_correo().getText());
        P.setDireccion(modificar.getTxt_direccion().getText());
        P.setNum_celular(modificar.getTxt_celular().getText());
        P.setEstado_civil(estado);
        P.setCedula(modificar.getTxt_cedula().getText());

        S.setHorario(horario);

        if (modificar.ruta != null) {

            File ruta = new File(modificar.rutas);

            try {
                byte[] icono = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(icono);
                S.setFoto(icono);
            } catch (Exception ex) {
                S.setFoto(null);
            }
        } else {
            List<Buf_Secretaria> List_secre = S_DB.Getter();

            for (int i = 0; i < List_secre.size(); i++) {
                if (List_secre.get(i).getCedula().equals(modificar.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_secre.get(i).getFoto();
                        if (bi != null) {
                            S.setFoto(bi);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        S.setId_secretaria(Integer.parseInt(modificar.getTxt_id().getText()));
        if (P_DB.Update(P)) {

        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        if (S_DB.Update(S)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            Campos();
            Nuevo();
            Limpiar_Tabla();
            Actualizar_Tabla();
        }

    }

    public void Modificar() {

        modificar.getCb_1().setEnabled(true);
        modificar.getCb_2().setEnabled(true);
        modificar.getCb_3().setEnabled(true);
        modificar.getCb_4().setEnabled(true);
        modificar.getTxt_nombre().setEditable(true);
        modificar.getTxt_correo().setEditable(true);
        modificar.getTxt_celular().setEditable(true);
        modificar.getTxt_direccion().setEditable(true);
        modificar.getTxt_apellido().setEditable(true);
        modificar.getCb_estado().setEnabled(true);
        modificar.getBtn_imagen().setEnabled(true);
        modificar.getNacimeinto().setEditable(false);
        modificar.getTxt_buscar().setEditable(false);
        modificar.getBtn_eliminar().setEnabled(false);
        modificar.getBtn_imagen().setEnabled(true);
        modificar.getBtn_cancelar().setEnabled(true);
        modificar.getBtn_modificar().setEnabled(false);
    }

    public void Cargar_Table() {

        List<Buf_Secretaria> List_secre = S_DB.Getter();
        List<Buf_Persona> List_per = P_DB.Getter_Secre();

        int select = modificar.getTablepersona().getSelectedRow();

        if (select != -1) {

            modificar.getTxt_buscar().setEditable(true);
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

            for (int i = 0; i < List_secre.size(); i++) {
                if (List_secre.get(i).getCedula().equals(modificar.getTxt_cedula().getText())) {

                    modificar.getTxt_id().setText(String.valueOf(List_secre.get(i).getId_secretaria()));

                    if (List_secre.get(i).getHorario().equals(" | 9:00-13:00 | ")) {
                        modificar.getCb_1().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 13:00-15:00 | ")) {
                        modificar.getCb_2().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 15:00-16:30 | ")) {
                        modificar.getCb_3().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 16:30-18:30 | ")) {
                        modificar.getCb_4().setSelected(true);
                    }

                    //MAS DE DOS OPCIONES
                    if (List_secre.get(i).getHorario().equals(" | 9:00-13:00 |  | 13:00-15:00 | ")) {
                        modificar.getCb_1().setSelected(true);
                        modificar.getCb_2().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 9:00-13:00 |  | 15:00-16:30 | ")) {
                        modificar.getCb_1().setSelected(true);
                        modificar.getCb_3().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 9:00-13:00 |  | 16:30-18:30 | ")) {
                        modificar.getCb_1().setSelected(true);
                        modificar.getCb_4().setSelected(true);
                    }

                    if (List_secre.get(i).getHorario().equals(" | 13:00-15:00 |  | 15:00-16:30 | ")) {
                        modificar.getCb_2().setSelected(true);
                        modificar.getCb_3().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 15:00-16:30 |  | 16:30-18:30 | ")) {
                        modificar.getCb_3().setSelected(true);
                        modificar.getCb_4().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 13:00-15:00 |  | 16:30-18:30 | ")) {
                        modificar.getCb_2().setSelected(true);
                        modificar.getCb_4().setSelected(true);
                    }

                    if (List_secre.get(i).getHorario().equals(" | 9:00-13:00 |  | 13:00-15:00 |  | 15:00-16:30 | ")) {
                        modificar.getCb_1().setSelected(true);
                        modificar.getCb_2().setSelected(true);
                        modificar.getCb_3().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 9:00-13:00 |  | 13:00-15:00 |  | 16:30-18:30 | ")) {
                        modificar.getCb_1().setSelected(true);
                        modificar.getCb_2().setSelected(true);
                        modificar.getCb_4().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 13:00-15:00 |  | 15:00-16:30 |  | 16:30-18:30 | ")) {
                        modificar.getCb_2().setSelected(true);
                        modificar.getCb_3().setSelected(true);
                        modificar.getCb_4().setSelected(true);
                    }
                    if (List_secre.get(i).getHorario().equals(" | 9:00-13:00 |  | 13:00-15:00 |  | 15:00-16:30 |  | 16:30-18:30 | ")) {
                        modificar.getCb_1().setSelected(true);
                        modificar.getCb_2().setSelected(true);
                        modificar.getCb_3().setSelected(true);
                        modificar.getCb_4().setSelected(true);
                    }

                    try {
                        byte[] bi = List_secre.get(i).getFoto();
                        BufferedImage image = null;
                        InputStream in = new ByteArrayInputStream(bi);
                        image = ImageIO.read(in);
                        ImageIcon imgi = new ImageIcon(image.getScaledInstance(modificar.getLb_foto().getWidth(), modificar.getLb_foto().getHeight(), img.SCALE_DEFAULT));
                        modificar.getLb_foto().setIcon(imgi);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            modificar.getBtn_imagen().setEnabled(false);
            modificar.getBtn_modificar().setEnabled(true);
            modificar.getBtn_eliminar().setEnabled(true);
        }
    }

    public void Estado_Civil() {

        modificar.getCb_estado().addItem("Seleccionar");
        modificar.getCb_estado().addItem("Soltero");
        modificar.getCb_estado().addItem("Casado");
        modificar.getCb_estado().addItem("Divorciado");
    }

    public void Campo_Vacio() {

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

        if (modificar.getTxt_direccion().getText().isEmpty()) {
            modificar.getLb_direccion().setVisible(true);
        }

        if (modificar.getTxt_apellido().getText().isEmpty()) {
            modificar.getLb_apellido().setVisible(true);
        }

        if (estado.equals("Seleccionar")) {
            modificar.getLb_estado().setVisible(true);
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

        if (!modificar.getTxt_apellido().getText().isEmpty()) {
            modificar.getLb_apellido().setVisible(false);
        }

        if (!modificar.getTxt_correo().getText().isEmpty()) {
            modificar.getLb_correo().setVisible(false);
        }

        if (!modificar.getTxt_direccion().getText().isEmpty()) {
            modificar.getLb_direccion().setVisible(false);
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

        if (!modificar.getTxt_nombre().getText().isEmpty() && !modificar.getTxt_correo().getText().isEmpty() && !(modificar.getLb_foto().getIcon() == null) && !modificar.getTxt_direccion().getText().isEmpty() && !modificar.getTxt_celular().getText().isEmpty() && !estado.equals("Seleccionar") && (modificar.getCb_1().isSelected() || modificar.getCb_2().isSelected() || modificar.getCb_3().isSelected() || modificar.getCb_4().isSelected())) {
            modificar.getBtn_guardar().setEnabled(true);
        } else {
            modificar.getBtn_guardar().setEnabled(false);
        }
    }

    public void Campos() {

        modificar.getCelular().setVisible(false);
        modificar.getLb_nombre().setVisible(false);
        modificar.getLb_correo().setVisible(false);
        modificar.getLb_celular().setVisible(false);
        modificar.getLb_horario().setVisible(false);
        modificar.getLb_estado().setVisible(false);
        modificar.getLb_direccion().setVisible(false);
        modificar.getCorreo().setVisible(false);
        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_modificar().setEnabled(false);
        modificar.getBtn_imagen().setEnabled(false);
        modificar.getBtn_cancelar().setEnabled(false);
        modificar.getLb_apellido().setVisible(false);
    }

    public void Nuevo() {

        modificar.getBtn_guardar().setEnabled(false);
        modificar.getBtn_eliminar().setEnabled(false);
        modificar.getTxt_nombre().setEditable(false);
        modificar.getTxt_cedula().setEditable(false);
        modificar.getTxt_apellido().setEditable(false);
        modificar.getCb_estado().setEnabled(false);
        modificar.getTxt_celular().setEditable(false);
        modificar.getTxt_direccion().setEditable(false);
        modificar.getTxt_correo().setEditable(false);
        modificar.getTxt_id().setEditable(false);
        modificar.getCb_1().setEnabled(false);
        modificar.getCb_2().setEnabled(false);
        modificar.getCb_3().setEnabled(false);
        modificar.getCb_4().setEnabled(false);
        modificar.getNacimeinto().setEditable(false);
        modificar.getTxt_buscar().setEditable(true);
        modificar.getTxt_buscar().setText("");
        modificar.getTxt_cedula().setText("");
        modificar.getTxt_nombre().setText("");
        modificar.getTxt_id().setText("");
        modificar.getCb_estado().setSelectedIndex(0);
        modificar.getTxt_apellido().setText("");
        modificar.getTxt_celular().setText("");
        modificar.getTxt_direccion().setText("");
        modificar.getTxt_correo().setText("");
        modificar.getCb_1().setSelected(false);
        modificar.getCb_2().setSelected(false);
        modificar.getCb_3().setSelected(false);
        modificar.getCb_4().setSelected(false);
        modificar.getNacimeinto().setText("");
        modificar.getLb_foto().setIcon(null);
    }

    public void Actualizar_Tabla() {

        List<Buf_Persona> List_per = P_DB.Getter_Secre();

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
        modificar.getTxt_direccion().setText("");
        modificar.getTxt_correo().setText("");
        modificar.getTxt_buscar().setText("");
        modificar.getTxt_id().setText("");
        modificar.getCb_1().setSelected(false);
        modificar.getCb_2().setSelected(false);
        modificar.getCb_3().setSelected(false);
        modificar.getCb_4().setSelected(false);
        modificar.getNacimeinto().setText("");
    }

    public boolean Validar_Datos() {

        String estado = (String) modificar.getCb_estado().getSelectedItem();

        if (!modificar.getTxt_nombre().getText().isEmpty() && !modificar.getTxt_apellido().getText().equals("") && !modificar.getTxt_correo().getText().isEmpty() && !modificar.getTxt_direccion().getText().isEmpty() && !modificar.getTxt_celular().getText().isEmpty() && !estado.equals("Seleccionar") && (modificar.getCb_1().isSelected() || modificar.getCb_2().isSelected() || modificar.getCb_3().isSelected() || modificar.getCb_4().isSelected())) {
            return true;
        } else {

            return false;
        }

    }

    public boolean Validar_Correo() {

        List<Buf_Persona> List_pers = P_DB.Getter();

        for (int i = 0; i < List_pers.size(); i++) {
            if (List_pers.get(i).getCorreo().equalsIgnoreCase(modificar.getTxt_correo().getText()) && !List_pers.get(i).getCedula().equals(modificar.getTxt_cedula().getText())) {
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
}
