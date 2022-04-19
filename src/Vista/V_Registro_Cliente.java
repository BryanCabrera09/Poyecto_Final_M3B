/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Myrian
 */
public class V_Registro_Cliente extends javax.swing.JInternalFrame {

    public static String x;

    public V_Registro_Cliente() {
        initComponents();
        setTitle("CLIENTES");
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getLaapellido2() {
        return laapellido2;
    }

    public void setLaapellido2(JLabel laapellido2) {
        this.laapellido2 = laapellido2;
    }

    public JLabel getLacedula() {
        return lacedula;
    }

    public void setLacedula(JLabel lacedula) {
        this.lacedula = lacedula;
    }

    public JLabel getLacelular2() {
        return lacelular2;
    }

    public void setLacelular2(JLabel lacelular2) {
        this.lacelular2 = lacelular2;
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

    public JLabel getLb_nombre() {
        return lb_nombre;
    }

    public void setLb_nombre(JLabel lb_nombre) {
        this.lb_nombre = lb_nombre;
    }

    public JLabel getLb_ocupacion() {
        return lb_ocupacion;
    }

    public void setLb_ocupacion(JLabel lb_ocupacion) {
        this.lb_ocupacion = lb_ocupacion;
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

    public JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public void setTxt_direccion(JTextField txt_direccion) {
        this.txt_direccion = txt_direccion;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(JTextField txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public JTextField getTxt_ocupacion() {
        return txt_ocupacion;
    }

    public void setTxt_ocupacion(JTextField txt_ocupacion) {
        this.txt_ocupacion = txt_ocupacion;
    }

    public JTextField getTxt_abogado() {
        return txt_abogado;
    }

    public void setTxt_abogado(JTextField txt_abogado) {
        this.txt_abogado = txt_abogado;
    }

    public JTextField getTxt_id_abg() {
        return txt_id_abg;
    }

    public void setTxt_id_abg(JTextField txt_id_abg) {
        this.txt_id_abg = txt_id_abg;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        lanombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        laapellido2 = new javax.swing.JLabel();
        lb_apellido = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        lacedula = new javax.swing.JLabel();
        lb_cedula = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        lacelular2 = new javax.swing.JLabel();
        lb_celular = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        ladireccion = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lacorreo = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        lafecha_nac = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JDateChooser();
        lb_fecha = new javax.swing.JLabel();
        laestado = new javax.swing.JLabel();
        lb_estado = new javax.swing.JLabel();
        cb_estado = new javax.swing.JComboBox<>();
        lahorario = new javax.swing.JLabel();
        lb_ocupacion = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        txt_ocupacion = new javax.swing.JTextField();
        lb_correo = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        datocedula = new javax.swing.JLabel();
        datocorreo = new javax.swing.JLabel();
        txt_abogado = new javax.swing.JTextField();
        txt_id_abg = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("REGISTRO CLIENTE");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 180, 52));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        lanombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lanombre.setForeground(new java.awt.Color(255, 255, 255));
        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 20));

        txt_nombre.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, -1));

        laapellido2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        laapellido2.setForeground(new java.awt.Color(255, 255, 255));
        laapellido2.setText("Apellido:");
        jPanel1.add(laapellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 80, 20));

        lb_apellido.setBackground(new java.awt.Color(255, 255, 255));
        lb_apellido.setForeground(new java.awt.Color(255, 0, 0));
        lb_apellido.setText("*Campo Obligatorio");
        jPanel1.add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        txt_apellido.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 160, -1));

        lacedula.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lacedula.setForeground(new java.awt.Color(255, 255, 255));
        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 70, 20));

        lb_cedula.setBackground(new java.awt.Color(255, 255, 255));
        lb_cedula.setForeground(new java.awt.Color(255, 0, 0));
        lb_cedula.setText("*Campo Obligatorio");
        jPanel1.add(lb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        txt_cedula.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 160, -1));

        lacelular2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lacelular2.setForeground(new java.awt.Color(255, 255, 255));
        lacelular2.setText("Celular:");
        jPanel1.add(lacelular2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 70, 20));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel1.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        txt_celular.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 160, -1));

        ladireccion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        ladireccion.setForeground(new java.awt.Color(255, 255, 255));
        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 90, 20));

        lb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        lb_direccion.setForeground(new java.awt.Color(255, 0, 0));
        lb_direccion.setText("*Campo Obligatorio");
        jPanel1.add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        txt_direccion.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 160, -1));

        lacorreo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lacorreo.setForeground(new java.awt.Color(255, 255, 255));
        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 150, 20));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 110, -1));

        txt_correo.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 160, -1));

        lafecha_nac.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lafecha_nac.setForeground(new java.awt.Color(255, 255, 255));
        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 160, 20));
        jPanel1.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 160, -1));

        lb_fecha.setBackground(new java.awt.Color(255, 255, 255));
        lb_fecha.setForeground(new java.awt.Color(255, 0, 0));
        lb_fecha.setText("*Campo Obligatorio");
        jPanel1.add(lb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        laestado.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        laestado.setForeground(new java.awt.Color(255, 255, 255));
        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 100, 20));

        lb_estado.setBackground(new java.awt.Color(255, 255, 255));
        lb_estado.setForeground(new java.awt.Color(255, 0, 0));
        lb_estado.setText("*Campo Obligatorio");
        jPanel1.add(lb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        cb_estado.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 160, -1));

        lahorario.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        lahorario.setForeground(new java.awt.Color(255, 255, 255));
        lahorario.setText("Ocupacion:");
        jPanel1.add(lahorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 90, 20));

        lb_ocupacion.setBackground(new java.awt.Color(255, 255, 255));
        lb_ocupacion.setForeground(new java.awt.Color(255, 0, 0));
        lb_ocupacion.setText("*Campo Obligatorio");
        jPanel1.add(lb_ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, -1));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 130, 50));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 130, 50));

        btn_nuevo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Nuevo.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 50));

        txt_ocupacion.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 160, -1));

        lb_correo.setBackground(new java.awt.Color(255, 255, 255));
        lb_correo.setForeground(new java.awt.Color(255, 0, 0));
        lb_correo.setText("*Campo Obligatorio");
        jPanel1.add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 120, -1));

        cedula.setForeground(new java.awt.Color(255, 0, 0));
        cedula.setText("*Cedula Erronea");
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 110, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 110, -1));

        datocedula.setForeground(new java.awt.Color(255, 0, 0));
        datocedula.setText("*Dato Existente");
        jPanel1.add(datocedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        datocorreo.setForeground(new java.awt.Color(255, 0, 0));
        datocorreo.setText("*Dato Existente");
        jPanel1.add(datocorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        txt_abogado.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_abogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 130, -1));

        txt_id_abg.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_id_abg, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JComboBox<String> cb_estado;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel datocedula;
    private javax.swing.JLabel datocorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel laapellido2;
    private javax.swing.JLabel lacedula;
    private javax.swing.JLabel lacelular2;
    private javax.swing.JLabel lacorreo;
    private javax.swing.JLabel ladireccion;
    private javax.swing.JLabel laestado;
    private javax.swing.JLabel lafecha_nac;
    private javax.swing.JLabel lahorario;
    private javax.swing.JLabel lanombre;
    private javax.swing.JLabel lb_apellido;
    private javax.swing.JLabel lb_cedula;
    private javax.swing.JLabel lb_celular;
    private javax.swing.JLabel lb_correo;
    private javax.swing.JLabel lb_direccion;
    private javax.swing.JLabel lb_estado;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel lb_ocupacion;
    private javax.swing.JTextField txt_abogado;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_id_abg;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ocupacion;
    // End of variables declaration//GEN-END:variables
}
