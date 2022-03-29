/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * @author BRYAN_CABRERA
 */
public class V_Registro_Secretaria extends javax.swing.JInternalFrame {
    
    public static String x;

    public V_Registro_Secretaria() {
        initComponents();
       
        setTitle("SECRETARIAS");
      
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public static JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public static void setBtn_cancelar(JButton btn_cancelar) {
        V_Registro_Secretaria.btn_cancelar = btn_cancelar;
    }

    public static JButton getBtn_guardar() {
        return btn_guardar;
    }

    public static void setBtn_guardar(JButton btn_guardar) {
        V_Registro_Secretaria.btn_guardar = btn_guardar;
    }

    public static JButton getBtn_imagen() {
        return btn_imagen;
    }

    public static void setBtn_imagen(JButton btn_imagen) {
        V_Registro_Secretaria.btn_imagen = btn_imagen;
    }

    public static JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public static void setBtn_nuevo(JButton btn_nuevo) {
        V_Registro_Secretaria.btn_nuevo = btn_nuevo;
    }

    public static JCheckBox getCb_1() {
        return cb_1;
    }

    public static void setCb_1(JCheckBox cb_1) {
        V_Registro_Secretaria.cb_1 = cb_1;
    }

    public static JCheckBox getCb_2() {
        return cb_2;
    }

    public static void setCb_2(JCheckBox cb_2) {
        V_Registro_Secretaria.cb_2 = cb_2;
    }

    public static JCheckBox getCb_3() {
        return cb_3;
    }

    public static void setCb_3(JCheckBox cb_3) {
        V_Registro_Secretaria.cb_3 = cb_3;
    }

    public static JCheckBox getCb_4() {
        return cb_4;
    }

    public static void setCb_4(JCheckBox cb_4) {
        V_Registro_Secretaria.cb_4 = cb_4;
    }

    public static JComboBox<String> getCb_estado() {
        return cb_estado;
    }

    public static void setCb_estado(JComboBox<String> cb_estado) {
        V_Registro_Secretaria.cb_estado = cb_estado;
    }

    public static JLabel getCedula() {
        return cedula;
    }

    public static void setCedula(JLabel cedula) {
        V_Registro_Secretaria.cedula = cedula;
    }

    public static JLabel getCelular() {
        return celular;
    }

    public static void setCelular(JLabel celular) {
        V_Registro_Secretaria.celular = celular;
    }

    public static JLabel getCorreo() {
        return correo;
    }

    public static void setCorreo(JLabel correo) {
        V_Registro_Secretaria.correo = correo;
    }

    public static JLabel getDatocedula() {
        return datocedula;
    }

    public static void setDatocedula(JLabel datocedula) {
        V_Registro_Secretaria.datocedula = datocedula;
    }

    public static JLabel getDatocorreo() {
        return datocorreo;
    }

    public static void setDatocorreo(JLabel datocorreo) {
        V_Registro_Secretaria.datocorreo = datocorreo;
    }

    public static JLabel getFoto() {
        return foto;
    }

    public static void setFoto(JLabel foto) {
        V_Registro_Secretaria.foto = foto;
    }

    public static JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public static void setjDateChooser1(JDateChooser jDateChooser1) {
        V_Registro_Secretaria.jDateChooser1 = jDateChooser1;
    }

    public static JLabel getjLabel1() {
        return jLabel1;
    }

    public static void setjLabel1(JLabel jLabel1) {
        V_Registro_Secretaria.jLabel1 = jLabel1;
    }

    public static JLabel getLaapellido2() {
        return laapellido2;
    }

    public static void setLaapellido2(JLabel laapellido2) {
        V_Registro_Secretaria.laapellido2 = laapellido2;
    }

    public static JLabel getLacedula() {
        return lacedula;
    }

    public static void setLacedula(JLabel lacedula) {
        V_Registro_Secretaria.lacedula = lacedula;
    }

    public static JLabel getLacelular2() {
        return lacelular2;
    }

    public static void setLacelular2(JLabel lacelular2) {
        V_Registro_Secretaria.lacelular2 = lacelular2;
    }

    public static JLabel getLacorreo() {
        return lacorreo;
    }

    public static void setLacorreo(JLabel lacorreo) {
        V_Registro_Secretaria.lacorreo = lacorreo;
    }

    public static JLabel getLadireccion() {
        return ladireccion;
    }

    public static void setLadireccion(JLabel ladireccion) {
        V_Registro_Secretaria.ladireccion = ladireccion;
    }

    public static JLabel getLaestado() {
        return laestado;
    }

    public static void setLaestado(JLabel laestado) {
        V_Registro_Secretaria.laestado = laestado;
    }

    public static JLabel getLafecha_nac() {
        return lafecha_nac;
    }

    public static void setLafecha_nac(JLabel lafecha_nac) {
        V_Registro_Secretaria.lafecha_nac = lafecha_nac;
    }

    public static JLabel getLahorario() {
        return lahorario;
    }

    public static void setLahorario(JLabel lahorario) {
        V_Registro_Secretaria.lahorario = lahorario;
    }

    public static JLabel getLanombre() {
        return lanombre;
    }

    public static void setLanombre(JLabel lanombre) {
        V_Registro_Secretaria.lanombre = lanombre;
    }

    public static JLabel getLb_apellido() {
        return lb_apellido;
    }

    public static void setLb_apellido(JLabel lb_apellido) {
        V_Registro_Secretaria.lb_apellido = lb_apellido;
    }

    public static JLabel getLb_cedula() {
        return lb_cedula;
    }

    public static void setLb_cedula(JLabel lb_cedula) {
        V_Registro_Secretaria.lb_cedula = lb_cedula;
    }

    public static JLabel getLb_celular() {
        return lb_celular;
    }

    public static void setLb_celular(JLabel lb_celular) {
        V_Registro_Secretaria.lb_celular = lb_celular;
    }

    public static JLabel getLb_correo() {
        return lb_correo;
    }

    public static void setLb_correo(JLabel lb_correo) {
        V_Registro_Secretaria.lb_correo = lb_correo;
    }

    public static JLabel getLb_direccion() {
        return lb_direccion;
    }

    public static void setLb_direccion(JLabel lb_direccion) {
        V_Registro_Secretaria.lb_direccion = lb_direccion;
    }

    public static JLabel getLb_estado() {
        return lb_estado;
    }

    public static void setLb_estado(JLabel lb_estado) {
        V_Registro_Secretaria.lb_estado = lb_estado;
    }

    public static JLabel getLb_fecha() {
        return lb_fecha;
    }

    public static void setLb_fecha(JLabel lb_fecha) {
        V_Registro_Secretaria.lb_fecha = lb_fecha;
    }

    public static JLabel getLb_foto() {
        return lb_foto;
    }

    public static void setLb_foto(JLabel lb_foto) {
        V_Registro_Secretaria.lb_foto = lb_foto;
    }

    public static JLabel getLb_horario() {
        return lb_horario;
    }

    public static void setLb_horario(JLabel lb_horario) {
        V_Registro_Secretaria.lb_horario = lb_horario;
    }

    public static JLabel getLb_nombre() {
        return lb_nombre;
    }

    public static void setLb_nombre(JLabel lb_nombre) {
        V_Registro_Secretaria.lb_nombre = lb_nombre;
    }

    public static JTextField getTxt_apellido() {
        return txt_apellido;
    }

    public static void setTxt_apellido(JTextField txt_apellido) {
        V_Registro_Secretaria.txt_apellido = txt_apellido;
    }

    public static JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public static void setTxt_cedula(JTextField txt_cedula) {
        V_Registro_Secretaria.txt_cedula = txt_cedula;
    }

    public static JTextField getTxt_celular() {
        return txt_celular;
    }

    public static void setTxt_celular(JTextField txt_celular) {
        V_Registro_Secretaria.txt_celular = txt_celular;
    }

    public static JTextField getTxt_correo() {
        return txt_correo;
    }

    public static void setTxt_correo(JTextField txt_correo) {
        V_Registro_Secretaria.txt_correo = txt_correo;
    }

    public static JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public static void setTxt_direccion(JTextField txt_direccion) {
        V_Registro_Secretaria.txt_direccion = txt_direccion;
    }

    public static JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public static void setTxt_nombre(JTextField txt_nombre) {
        V_Registro_Secretaria.txt_nombre = txt_nombre;
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
        lb_correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        lafecha_nac = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lb_fecha = new javax.swing.JLabel();
        laestado = new javax.swing.JLabel();
        lb_estado = new javax.swing.JLabel();
        cb_estado = new javax.swing.JComboBox<>();
        lahorario = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        cb_1 = new javax.swing.JCheckBox();
        cb_2 = new javax.swing.JCheckBox();
        cb_3 = new javax.swing.JCheckBox();
        cb_4 = new javax.swing.JCheckBox();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        correo = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        lb_foto = new javax.swing.JLabel();
        btn_imagen = new javax.swing.JButton();
        datocedula = new javax.swing.JLabel();
        datocorreo = new javax.swing.JLabel();
        lb_horario = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO SECRETARIA");
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
        jLabel1.setText("Registro de Secretarias");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 220, 53));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 20));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 132, -1));

        laapellido2.setText("Apellido:");
        jPanel1.add(laapellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 20));

        lb_apellido.setBackground(new java.awt.Color(255, 255, 255));
        lb_apellido.setForeground(new java.awt.Color(255, 0, 0));
        lb_apellido.setText("*Campo Obligatorio");
        jPanel1.add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 132, -1));

        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 20));

        lb_cedula.setBackground(new java.awt.Color(255, 255, 255));
        lb_cedula.setForeground(new java.awt.Color(255, 0, 0));
        lb_cedula.setText("*Campo Obligatorio");
        jPanel1.add(lb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 130, -1));

        lacelular2.setText("Celular:");
        jPanel1.add(lacelular2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, 20));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel1.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 130, -1));

        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, 20));

        lb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        lb_direccion.setForeground(new java.awt.Color(255, 0, 0));
        lb_direccion.setText("*Campo Obligatorio");
        jPanel1.add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 150, -1));

        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 20));

        lb_correo.setBackground(new java.awt.Color(255, 255, 255));
        lb_correo.setForeground(new java.awt.Color(255, 0, 0));
        lb_correo.setText("*Campo Obligatorio");
        jPanel1.add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 145, -1));

        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, 20));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 141, -1));

        lb_fecha.setBackground(new java.awt.Color(255, 255, 255));
        lb_fecha.setForeground(new java.awt.Color(255, 0, 0));
        lb_fecha.setText("*Campo Obligatorio");
        jPanel1.add(lb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, 20));

        lb_estado.setBackground(new java.awt.Color(255, 255, 255));
        lb_estado.setForeground(new java.awt.Color(255, 0, 0));
        lb_estado.setText("*Campo Obligatorio");
        jPanel1.add(lb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        jPanel1.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 145, -1));

        lahorario.setText("Registro de horario:");
        jPanel1.add(lahorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, 20));

        foto.setBackground(new java.awt.Color(255, 255, 255));
        foto.setForeground(new java.awt.Color(255, 0, 0));
        foto.setText("*Campo Obligatorio");
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, -1));

        cb_1.setText("9:00-13:00");
        jPanel1.add(cb_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        cb_2.setText("13:00-15:00");
        jPanel1.add(cb_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, -1));

        cb_3.setText("15:00-16:30");
        jPanel1.add(cb_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        cb_4.setText("16:30-18:30");
        jPanel1.add(cb_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, -1, -1));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 130, 50));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 120, 50));

        btn_nuevo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 50));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 110, -1));

        cedula.setForeground(new java.awt.Color(255, 0, 0));
        cedula.setText("*Cedula Erronea");
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 100, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));
        jPanel1.add(lb_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 150, 160));

        btn_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Foto.png"))); // NOI18N
        btn_imagen.setText("FOTO");
        jPanel1.add(btn_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, -1, 40));

        datocedula.setForeground(new java.awt.Color(255, 0, 0));
        datocedula.setText("*Dato Existente");
        jPanel1.add(datocedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        datocorreo.setForeground(new java.awt.Color(255, 0, 0));
        datocorreo.setText("*Dato Existente");
        jPanel1.add(datocorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        lb_horario.setBackground(new java.awt.Color(255, 255, 255));
        lb_horario.setForeground(new java.awt.Color(255, 0, 0));
        lb_horario.setText("*Campo Obligatorio");
        jPanel1.add(lb_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_guardar;
    public static javax.swing.JButton btn_imagen;
    public static javax.swing.JButton btn_nuevo;
    public static javax.swing.JCheckBox cb_1;
    public static javax.swing.JCheckBox cb_2;
    public static javax.swing.JCheckBox cb_3;
    public static javax.swing.JCheckBox cb_4;
    public static javax.swing.JComboBox<String> cb_estado;
    public static javax.swing.JLabel cedula;
    public static javax.swing.JLabel celular;
    public static javax.swing.JLabel correo;
    public static javax.swing.JLabel datocedula;
    public static javax.swing.JLabel datocorreo;
    public static javax.swing.JLabel foto;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
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
    public static javax.swing.JLabel lb_foto;
    public static javax.swing.JLabel lb_horario;
    public static javax.swing.JLabel lb_nombre;
    public static javax.swing.JTextField txt_apellido;
    public static javax.swing.JTextField txt_cedula;
    public static javax.swing.JTextField txt_celular;
    public static javax.swing.JTextField txt_correo;
    public static javax.swing.JTextField txt_direccion;
    public static javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
