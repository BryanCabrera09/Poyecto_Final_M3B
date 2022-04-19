/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author BRYAN_CABRERA
 */
public class V_Registro_Abogado extends javax.swing.JInternalFrame {

    public static String x;

    protected static File ruta;
    protected static Image img;

    public String rutas;

    /**
     * Creates new form Abogados
     */
    public V_Registro_Abogado() {
        initComponents();
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public JButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public JButton getBtn_imagen() {
        return btn_imagen;
    }

    public void setBtn_imagen(JButton btn_imagen) {
        this.btn_imagen = btn_imagen;
    }

    public JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public void setBtn_nuevo(JButton btn_nuevo) {
        this.btn_nuevo = btn_nuevo;
    }

    public JDateChooser getCalendar() {
        return calendar;
    }

    public void setCalendar(JDateChooser calendar) {
        this.calendar = calendar;
    }

    public JCheckBox getCb_1() {
        return cb_1;
    }

    public void setCb_1(JCheckBox cb_1) {
        this.cb_1 = cb_1;
    }

    public JCheckBox getCb_2() {
        return cb_2;
    }

    public void setCb_2(JCheckBox cb_2) {
        this.cb_2 = cb_2;
    }

    public JCheckBox getCb_3() {
        return cb_3;
    }

    public void setCb_3(JCheckBox cb_3) {
        this.cb_3 = cb_3;
    }

    public JCheckBox getCb_4() {
        return cb_4;
    }

    public void setCb_4(JCheckBox cb_4) {
        this.cb_4 = cb_4;
    }

    public JComboBox<String> getCb_estado() {
        return cb_estado;
    }

    public void setCb_estado(JComboBox<String> cb_estado) {
        this.cb_estado = cb_estado;
    }

    public JLabel getCedula() {
        return cedula;
    }

    public void setCedula(JLabel cedula) {
        this.cedula = cedula;
    }

    public JLabel getCelular() {
        return celular;
    }

    public void setCelular(JLabel celular) {
        this.celular = celular;
    }

    public JLabel getCorreo() {
        return correo;
    }

    public void setCorreo(JLabel correo) {
        this.correo = correo;
    }

    public JLabel getDatocedula() {
        return datocedula;
    }

    public void setDatocedula(JLabel datocedula) {
        this.datocedula = datocedula;
    }

    public JLabel getDatocorreo() {
        return datocorreo;
    }

    public void setDatocorreo(JLabel datocorreo) {
        this.datocorreo = datocorreo;
    }

    public JLabel getDatomatricula() {
        return datomatricula;
    }

    public void setDatomatricula(JLabel datomatricula) {
        this.datomatricula = datomatricula;
    }

    public JLabel getFoto() {
        return foto;
    }

    public void setFoto(JLabel foto) {
        this.foto = foto;
    }

    public JLabel getLaapellido() {
        return laapellido;
    }

    public void setLaapellido(JLabel laapellido) {
        this.laapellido = laapellido;
    }

    public JLabel getLacedula() {
        return lacedula;
    }

    public void setLacedula(JLabel lacedula) {
        this.lacedula = lacedula;
    }

    public JLabel getLacelular() {
        return lacelular;
    }

    public void setLacelular(JLabel lacelular) {
        this.lacelular = lacelular;
    }

    public JLabel getLacorreo() {
        return lacorreo;
    }

    public void setLacorreo(JLabel lacorreo) {
        this.lacorreo = lacorreo;
    }

    public JLabel getLadireccion() {
        return ladireccion;
    }

    public void setLadireccion(JLabel ladireccion) {
        this.ladireccion = ladireccion;
    }

    public JLabel getLaestado() {
        return laestado;
    }

    public void setLaestado(JLabel laestado) {
        this.laestado = laestado;
    }

    public JLabel getLafecha_nac() {
        return lafecha_nac;
    }

    public void setLafecha_nac(JLabel lafecha_nac) {
        this.lafecha_nac = lafecha_nac;
    }

    public JLabel getLahorario() {
        return lahorario;
    }

    public void setLahorario(JLabel lahorario) {
        this.lahorario = lahorario;
    }

    public JLabel getLanombre() {
        return lanombre;
    }

    public void setLanombre(JLabel lanombre) {
        this.lanombre = lanombre;
    }

    public JLabel getLanum_cuenta() {
        return lanum_cuenta;
    }

    public void setLanum_cuenta(JLabel lanum_cuenta) {
        this.lanum_cuenta = lanum_cuenta;
    }

    public JLabel getLanum_matri() {
        return lanum_matri;
    }

    public void setLanum_matri(JLabel lanum_matri) {
        this.lanum_matri = lanum_matri;
    }

    public JLabel getLaregistro() {
        return laregistro;
    }

    public void setLaregistro(JLabel laregistro) {
        this.laregistro = laregistro;
    }

    public JLabel getLb_apellido() {
        return lb_apellido;
    }

    public void setLb_apellido(JLabel lb_apellido) {
        this.lb_apellido = lb_apellido;
    }

    public JLabel getLb_cedula() {
        return lb_cedula;
    }

    public void setLb_cedula(JLabel lb_cedula) {
        this.lb_cedula = lb_cedula;
    }

    public JLabel getLb_celular() {
        return lb_celular;
    }

    public void setLb_celular(JLabel lb_celular) {
        this.lb_celular = lb_celular;
    }

    public JLabel getLb_correo() {
        return lb_correo;
    }

    public void setLb_correo(JLabel lb_correo) {
        this.lb_correo = lb_correo;
    }

    public JLabel getLb_cuenta() {
        return lb_cuenta;
    }

    public void setLb_cuenta(JLabel lb_cuenta) {
        this.lb_cuenta = lb_cuenta;
    }

    public JLabel getLb_direccion() {
        return lb_direccion;
    }

    public void setLb_direccion(JLabel lb_direccion) {
        this.lb_direccion = lb_direccion;
    }

    public JLabel getLb_estado() {
        return lb_estado;
    }

    public void setLb_estado(JLabel lb_estado) {
        this.lb_estado = lb_estado;
    }

    public JLabel getLb_fecha() {
        return lb_fecha;
    }

    public void setLb_fecha(JLabel lb_fecha) {
        this.lb_fecha = lb_fecha;
    }

    public JLabel getLb_foto() {
        return lb_foto;
    }

    public void setLb_foto(JLabel lb_foto) {
        this.lb_foto = lb_foto;
    }

    public JLabel getLb_horario() {
        return lb_horario;
    }

    public void setLb_horario(JLabel lb_horario) {
        this.lb_horario = lb_horario;
    }

    public JLabel getLb_matricula() {
        return lb_matricula;
    }

    public void setLb_matricula(JLabel lb_matricula) {
        this.lb_matricula = lb_matricula;
    }

    public JLabel getLb_nombre() {
        return lb_nombre;
    }

    public void setLb_nombre(JLabel lb_nombre) {
        this.lb_nombre = lb_nombre;
    }

    public JTextField getTxt_apellido() {
        return txt_apellido;
    }

    public void setTxt_apellido(JTextField txt_apellido) {
        this.txt_apellido = txt_apellido;
    }

    public JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public void setTxt_cedula(JTextField txt_cedula) {
        this.txt_cedula = txt_cedula;
    }

    public JTextField getTxt_celular() {
        return txt_celular;
    }

    public void setTxt_celular(JTextField txt_celular) {
        this.txt_celular = txt_celular;
    }

    public JTextField getTxt_correo() {
        return txt_correo;
    }

    public void setTxt_correo(JTextField txt_correo) {
        this.txt_correo = txt_correo;
    }

    public JTextField getTxt_cuenta() {
        return txt_cuenta;
    }

    public void setTxt_cuenta(JTextField txt_cuenta) {
        this.txt_cuenta = txt_cuenta;
    }

    public JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public void setTxt_direccion(JTextField txt_direccion) {
        this.txt_direccion = txt_direccion;
    }

    public JTextField getTxt_matricula() {
        return txt_matricula;
    }

    public void setTxt_matricula(JTextField txt_matricula) {
        this.txt_matricula = txt_matricula;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(JTextField txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        laregistro = new javax.swing.JLabel();
        lacedula = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        lacelular = new javax.swing.JLabel();
        lanombre = new javax.swing.JLabel();
        lacorreo = new javax.swing.JLabel();
        laapellido = new javax.swing.JLabel();
        ladireccion = new javax.swing.JLabel();
        lafecha_nac = new javax.swing.JLabel();
        laestado = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        lanum_matri = new javax.swing.JLabel();
        lanum_cuenta = new javax.swing.JLabel();
        lahorario = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_matricula = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_cuenta = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        calendar = new com.toedter.calendar.JDateChooser();
        cb_estado = new javax.swing.JComboBox<>();
        cb_1 = new javax.swing.JCheckBox();
        cb_2 = new javax.swing.JCheckBox();
        cb_3 = new javax.swing.JCheckBox();
        cb_4 = new javax.swing.JCheckBox();
        btn_nuevo = new javax.swing.JButton();
        lb_nombre = new javax.swing.JLabel();
        lb_apellido = new javax.swing.JLabel();
        lb_cedula = new javax.swing.JLabel();
        lb_celular = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        lb_correo = new javax.swing.JLabel();
        lb_fecha = new javax.swing.JLabel();
        lb_estado = new javax.swing.JLabel();
        lb_cuenta = new javax.swing.JLabel();
        lb_matricula = new javax.swing.JLabel();
        lb_horario = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        lb_foto = new javax.swing.JLabel();
        btn_imagen = new javax.swing.JButton();
        datomatricula = new javax.swing.JLabel();
        datocorreo = new javax.swing.JLabel();
        datocedula = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("REGISTRO ABOGADO");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(176, 131, 87));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        laregistro.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        laregistro.setForeground(new java.awt.Color(255, 255, 255));
        laregistro.setText("Registro de Abogado");
        jPanel1.add(laregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 40));

        lacedula.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lacedula.setForeground(new java.awt.Color(255, 255, 255));
        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, 20));

        txt_correo.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 160, -1));

        txt_nombre.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 150, -1));

        lacelular.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lacelular.setForeground(new java.awt.Color(255, 255, 255));
        lacelular.setText("Celular:");
        jPanel1.add(lacelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, 20));

        lanombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lanombre.setForeground(new java.awt.Color(255, 255, 255));
        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 20));

        lacorreo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lacorreo.setForeground(new java.awt.Color(255, 255, 255));
        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 20));

        laapellido.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        laapellido.setForeground(new java.awt.Color(255, 255, 255));
        laapellido.setText("Apellido:");
        jPanel1.add(laapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, 20));

        ladireccion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        ladireccion.setForeground(new java.awt.Color(255, 255, 255));
        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 90, 20));

        lafecha_nac.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lafecha_nac.setForeground(new java.awt.Color(255, 255, 255));
        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, 20));

        laestado.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        laestado.setForeground(new java.awt.Color(255, 255, 255));
        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, 20));

        txt_apellido.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 150, -1));

        lanum_matri.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lanum_matri.setForeground(new java.awt.Color(255, 255, 255));
        lanum_matri.setText("Numero de Matricula:");
        jPanel1.add(lanum_matri, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, 25));

        lanum_cuenta.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lanum_cuenta.setForeground(new java.awt.Color(255, 255, 255));
        lanum_cuenta.setText("Numero de Cuenta:");
        jPanel1.add(lanum_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, 20));

        lahorario.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lahorario.setForeground(new java.awt.Color(255, 255, 255));
        lahorario.setText("Registro de horario:");
        jPanel1.add(lahorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, 20));

        txt_celular.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 150, -1));

        txt_direccion.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 150, -1));

        txt_matricula.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 160, -1));

        txt_cedula.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 150, -1));

        txt_cuenta.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 160, -1));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 130, 50));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 120, 50));
        jPanel1.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 160, -1));

        cb_estado.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 160, -1));

        cb_1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        cb_1.setText("9:00-13:00");
        jPanel1.add(cb_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 100, -1));

        cb_2.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        cb_2.setText("13:00-15:00");
        jPanel1.add(cb_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, -1, -1));

        cb_3.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        cb_3.setText("15:00-16:30");
        jPanel1.add(cb_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, -1, -1));

        cb_4.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        cb_4.setText("16:30-18:30");
        jPanel1.add(cb_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, -1, -1));

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Nuevo.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 40));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        lb_apellido.setBackground(new java.awt.Color(255, 255, 255));
        lb_apellido.setForeground(new java.awt.Color(255, 0, 0));
        lb_apellido.setText("*Campo Obligatorio");
        jPanel1.add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        lb_cedula.setBackground(new java.awt.Color(255, 255, 255));
        lb_cedula.setForeground(new java.awt.Color(255, 0, 0));
        lb_cedula.setText("*Campo Obligatorio");
        jPanel1.add(lb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel1.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        lb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        lb_direccion.setForeground(new java.awt.Color(255, 0, 0));
        lb_direccion.setText("*Campo Obligatorio");
        jPanel1.add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        lb_correo.setBackground(new java.awt.Color(255, 255, 255));
        lb_correo.setForeground(new java.awt.Color(255, 0, 0));
        lb_correo.setText("*Campo Obligatorio");
        jPanel1.add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        lb_fecha.setBackground(new java.awt.Color(255, 255, 255));
        lb_fecha.setForeground(new java.awt.Color(255, 0, 0));
        lb_fecha.setText("*Campo Obligatorio");
        jPanel1.add(lb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        lb_estado.setBackground(new java.awt.Color(255, 255, 255));
        lb_estado.setForeground(new java.awt.Color(255, 0, 0));
        lb_estado.setText("*Campo Obligatorio");
        jPanel1.add(lb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        lb_cuenta.setBackground(new java.awt.Color(255, 255, 255));
        lb_cuenta.setForeground(new java.awt.Color(255, 0, 0));
        lb_cuenta.setText("*Campo Obligatorio");
        jPanel1.add(lb_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        lb_matricula.setBackground(new java.awt.Color(255, 255, 255));
        lb_matricula.setForeground(new java.awt.Color(255, 0, 0));
        lb_matricula.setText("*Campo Obligatorio");
        jPanel1.add(lb_matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        lb_horario.setBackground(new java.awt.Color(255, 255, 255));
        lb_horario.setForeground(new java.awt.Color(255, 0, 0));
        lb_horario.setText("*Campo Obligatorio");
        jPanel1.add(lb_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 110, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        cedula.setForeground(new java.awt.Color(255, 0, 0));
        cedula.setText("*Cedula Erronea");
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 100, -1));
        jPanel1.add(lb_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 160, 170));

        btn_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Foto.png"))); // NOI18N
        btn_imagen.setText("FOTO");
        jPanel1.add(btn_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, -1, 40));

        datomatricula.setForeground(new java.awt.Color(255, 0, 0));
        datomatricula.setText("*Dato Existente");
        jPanel1.add(datomatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        datocorreo.setForeground(new java.awt.Color(255, 0, 0));
        datocorreo.setText("*Dato Existente");
        jPanel1.add(datocorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        datocedula.setForeground(new java.awt.Color(255, 0, 0));
        datocedula.setText("*Dato Existente");
        jPanel1.add(datocedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        foto.setBackground(new java.awt.Color(255, 255, 255));
        foto.setForeground(new java.awt.Color(255, 0, 0));
        foto.setText("*Campo Obligatorio");
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    public void Cargar_Imagen() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);
        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
            img = getToolkit().getImage(String.valueOf(rutas));
            img = img.getScaledInstance(getLb_foto().getWidth(), getLb_foto().getHeight(), img.SCALE_DEFAULT);
            getLb_foto().setIcon(new ImageIcon(img));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imagen;
    private javax.swing.JButton btn_nuevo;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JCheckBox cb_1;
    private javax.swing.JCheckBox cb_2;
    private javax.swing.JCheckBox cb_3;
    private javax.swing.JCheckBox cb_4;
    private javax.swing.JComboBox<String> cb_estado;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel datocedula;
    private javax.swing.JLabel datocorreo;
    private javax.swing.JLabel datomatricula;
    private javax.swing.JLabel foto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel laapellido;
    private javax.swing.JLabel lacedula;
    private javax.swing.JLabel lacelular;
    private javax.swing.JLabel lacorreo;
    private javax.swing.JLabel ladireccion;
    private javax.swing.JLabel laestado;
    private javax.swing.JLabel lafecha_nac;
    private javax.swing.JLabel lahorario;
    private javax.swing.JLabel lanombre;
    private javax.swing.JLabel lanum_cuenta;
    private javax.swing.JLabel lanum_matri;
    private javax.swing.JLabel laregistro;
    private javax.swing.JLabel lb_apellido;
    private javax.swing.JLabel lb_cedula;
    private javax.swing.JLabel lb_celular;
    private javax.swing.JLabel lb_correo;
    private javax.swing.JLabel lb_cuenta;
    private javax.swing.JLabel lb_direccion;
    private javax.swing.JLabel lb_estado;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_foto;
    private javax.swing.JLabel lb_horario;
    private javax.swing.JLabel lb_matricula;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_cuenta;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_matricula;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
