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
public class RegistroCliente extends javax.swing.JInternalFrame {

    public static String x;

    public RegistroCliente() {
        initComponents();
        setTitle("CLIENTES");
        x = "x";
        int a = MenuInicio.escritorio.getWidth() - this.getWidth();
        int b = MenuInicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public static JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public static void setBtn_cancelar(JButton btn_cancelar) {
        RegistroCliente.btn_cancelar = btn_cancelar;
    }

    public static JButton getBtn_guardar() {
        return btn_guardar;
    }

    public static void setBtn_guardar(JButton btn_guardar) {
        RegistroCliente.btn_guardar = btn_guardar;
    }

    public static JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public static void setBtn_nuevo(JButton btn_nuevo) {
        RegistroCliente.btn_nuevo = btn_nuevo;
    }

    public static JDateChooser getCalendar() {
        return calendar;
    }

    public static void setCalendar(JDateChooser calendar) {
        RegistroCliente.calendar = calendar;
    }

    public static JComboBox<String> getCb_estado() {
        return cb_estado;
    }

    public static void setCb_estado(JComboBox<String> cb_estado) {
        RegistroCliente.cb_estado = cb_estado;
    }

    public static JLabel getCedula() {
        return cedula;
    }

    public static void setCedula(JLabel cedula) {
        RegistroCliente.cedula = cedula;
    }

    public static JLabel getCelular() {
        return celular;
    }

    public static void setCelular(JLabel celular) {
        RegistroCliente.celular = celular;
    }

    public static JLabel getCorreo() {
        return correo;
    }

    public static void setCorreo(JLabel correo) {
        RegistroCliente.correo = correo;
    }

    public static JLabel getDatocedula() {
        return datocedula;
    }

    public static void setDatocedula(JLabel datocedula) {
        RegistroCliente.datocedula = datocedula;
    }

    public static JLabel getDatocorreo() {
        return datocorreo;
    }

    public static void setDatocorreo(JLabel datocorreo) {
        RegistroCliente.datocorreo = datocorreo;
    }

    public static JLabel getjLabel1() {
        return jLabel1;
    }

    public static void setjLabel1(JLabel jLabel1) {
        RegistroCliente.jLabel1 = jLabel1;
    }

    public static JLabel getLaapellido2() {
        return laapellido2;
    }

    public static void setLaapellido2(JLabel laapellido2) {
        RegistroCliente.laapellido2 = laapellido2;
    }

    public static JLabel getLacedula() {
        return lacedula;
    }

    public static void setLacedula(JLabel lacedula) {
        RegistroCliente.lacedula = lacedula;
    }

    public static JLabel getLacelular2() {
        return lacelular2;
    }

    public static void setLacelular2(JLabel lacelular2) {
        RegistroCliente.lacelular2 = lacelular2;
    }

    public static JLabel getLacorreo() {
        return lacorreo;
    }

    public static void setLacorreo(JLabel lacorreo) {
        RegistroCliente.lacorreo = lacorreo;
    }

    public static JLabel getLadireccion() {
        return ladireccion;
    }

    public static void setLadireccion(JLabel ladireccion) {
        RegistroCliente.ladireccion = ladireccion;
    }

    public static JLabel getLaestado() {
        return laestado;
    }

    public static void setLaestado(JLabel laestado) {
        RegistroCliente.laestado = laestado;
    }

    public static JLabel getLafecha_nac() {
        return lafecha_nac;
    }

    public static void setLafecha_nac(JLabel lafecha_nac) {
        RegistroCliente.lafecha_nac = lafecha_nac;
    }

    public static JLabel getLahorario() {
        return lahorario;
    }

    public static void setLahorario(JLabel lahorario) {
        RegistroCliente.lahorario = lahorario;
    }

    public static JLabel getLanombre() {
        return lanombre;
    }

    public static void setLanombre(JLabel lanombre) {
        RegistroCliente.lanombre = lanombre;
    }

    public static JLabel getLb_apellido() {
        return lb_apellido;
    }

    public static void setLb_apellido(JLabel lb_apellido) {
        RegistroCliente.lb_apellido = lb_apellido;
    }

    public static JLabel getLb_cedula() {
        return lb_cedula;
    }

    public static void setLb_cedula(JLabel lb_cedula) {
        RegistroCliente.lb_cedula = lb_cedula;
    }

    public static JLabel getLb_celular() {
        return lb_celular;
    }

    public static void setLb_celular(JLabel lb_celular) {
        RegistroCliente.lb_celular = lb_celular;
    }

    public static JLabel getLb_correo() {
        return lb_correo;
    }

    public static void setLb_correo(JLabel lb_correo) {
        RegistroCliente.lb_correo = lb_correo;
    }

    public static JLabel getLb_direccion() {
        return lb_direccion;
    }

    public static void setLb_direccion(JLabel lb_direccion) {
        RegistroCliente.lb_direccion = lb_direccion;
    }

    public static JLabel getLb_estado() {
        return lb_estado;
    }

    public static void setLb_estado(JLabel lb_estado) {
        RegistroCliente.lb_estado = lb_estado;
    }

    public static JLabel getLb_fecha() {
        return lb_fecha;
    }

    public static void setLb_fecha(JLabel lb_fecha) {
        RegistroCliente.lb_fecha = lb_fecha;
    }

    public static JLabel getLb_nombre() {
        return lb_nombre;
    }

    public static void setLb_nombre(JLabel lb_nombre) {
        RegistroCliente.lb_nombre = lb_nombre;
    }

    public static JLabel getLb_ocupacion() {
        return lb_ocupacion;
    }

    public static void setLb_ocupacion(JLabel lb_ocupacion) {
        RegistroCliente.lb_ocupacion = lb_ocupacion;
    }

    public static JTextField getTxt_apellido() {
        return txt_apellido;
    }

    public static void setTxt_apellido(JTextField txt_apellido) {
        RegistroCliente.txt_apellido = txt_apellido;
    }

    public static JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public static void setTxt_cedula(JTextField txt_cedula) {
        RegistroCliente.txt_cedula = txt_cedula;
    }

    public static JTextField getTxt_celular() {
        return txt_celular;
    }

    public static void setTxt_celular(JTextField txt_celular) {
        RegistroCliente.txt_celular = txt_celular;
    }

    public static JTextField getTxt_correo() {
        return txt_correo;
    }

    public static void setTxt_correo(JTextField txt_correo) {
        RegistroCliente.txt_correo = txt_correo;
    }

    public static JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public static void setTxt_direccion(JTextField txt_direccion) {
        RegistroCliente.txt_direccion = txt_direccion;
    }

    public static JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public static void setTxt_nombre(JTextField txt_nombre) {
        RegistroCliente.txt_nombre = txt_nombre;
    }

    public static JTextField getTxt_ocupacion() {
        return txt_ocupacion;
    }

    public static void setTxt_ocupacion(JTextField txt_ocupacion) {
        RegistroCliente.txt_ocupacion = txt_ocupacion;
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

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 180, 52));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 20));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, -1));

        laapellido2.setText("Apellido:");
        jPanel1.add(laapellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 20));

        lb_apellido.setBackground(new java.awt.Color(255, 255, 255));
        lb_apellido.setForeground(new java.awt.Color(255, 0, 0));
        lb_apellido.setText("*Campo Obligatorio");
        jPanel1.add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 160, -1));

        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, 20));

        lb_cedula.setBackground(new java.awt.Color(255, 255, 255));
        lb_cedula.setForeground(new java.awt.Color(255, 0, 0));
        lb_cedula.setText("*Campo Obligatorio");
        jPanel1.add(lb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 160, -1));

        lacelular2.setText("Celular:");
        jPanel1.add(lacelular2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, 20));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel1.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 160, -1));

        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, 20));

        lb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        lb_direccion.setForeground(new java.awt.Color(255, 0, 0));
        lb_direccion.setText("*Campo Obligatorio");
        jPanel1.add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 160, -1));

        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 20));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 110, -1));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 160, -1));

        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, 20));
        jPanel1.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 160, -1));

        lb_fecha.setBackground(new java.awt.Color(255, 255, 255));
        lb_fecha.setForeground(new java.awt.Color(255, 0, 0));
        lb_fecha.setText("*Campo Obligatorio");
        jPanel1.add(lb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, 20));

        lb_estado.setBackground(new java.awt.Color(255, 255, 255));
        lb_estado.setForeground(new java.awt.Color(255, 0, 0));
        lb_estado.setText("*Campo Obligatorio");
        jPanel1.add(lb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        jPanel1.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 160, -1));

        lahorario.setText("Ocupacion:");
        jPanel1.add(lahorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, 20));

        lb_ocupacion.setBackground(new java.awt.Color(255, 255, 255));
        lb_ocupacion.setForeground(new java.awt.Color(255, 0, 0));
        lb_ocupacion.setText("*Campo Obligatorio");
        jPanel1.add(lb_ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, -1));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 130, 50));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 120, 50));

        btn_nuevo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 50));
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
    public static javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_guardar;
    public static javax.swing.JButton btn_nuevo;
    public static com.toedter.calendar.JDateChooser calendar;
    public static javax.swing.JComboBox<String> cb_estado;
    public static javax.swing.JLabel cedula;
    public static javax.swing.JLabel celular;
    public static javax.swing.JLabel correo;
    public static javax.swing.JLabel datocedula;
    public static javax.swing.JLabel datocorreo;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel laapellido2;
    public static javax.swing.JLabel lacedula;
    public static javax.swing.JLabel lacelular2;
    public static javax.swing.JLabel lacorreo;
    public static javax.swing.JLabel ladireccion;
    public static javax.swing.JLabel laestado;
    public static javax.swing.JLabel lafecha_nac;
    public static javax.swing.JLabel lahorario;
    public static javax.swing.JLabel lanombre;
    public static javax.swing.JLabel lb_apellido;
    public static javax.swing.JLabel lb_cedula;
    public static javax.swing.JLabel lb_celular;
    public static javax.swing.JLabel lb_correo;
    public static javax.swing.JLabel lb_direccion;
    public static javax.swing.JLabel lb_estado;
    public static javax.swing.JLabel lb_fecha;
    public static javax.swing.JLabel lb_nombre;
    public static javax.swing.JLabel lb_ocupacion;
    public static javax.swing.JTextField txt_apellido;
    public static javax.swing.JTextField txt_cedula;
    public static javax.swing.JTextField txt_celular;
    public static javax.swing.JTextField txt_correo;
    public static javax.swing.JTextField txt_direccion;
    public static javax.swing.JTextField txt_nombre;
    public static javax.swing.JTextField txt_ocupacion;
    // End of variables declaration//GEN-END:variables
}
