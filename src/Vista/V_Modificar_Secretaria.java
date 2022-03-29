/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * @author BRYAN_CABRERA
 */
public class V_Modificar_Secretaria extends javax.swing.JInternalFrame {

    /**
     * Creates new form ModificacionSecretaria
     */
    public static String x;

    public V_Modificar_Secretaria() {
        initComponents();
        tablepersona.getTableHeader().setResizingAllowed(false);
        tablepersona.getTableHeader().setReorderingAllowed(false);
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);

    }

    public static JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public static void setBtn_cancelar(JButton btn_cancelar) {
        V_Modificar_Secretaria.btn_cancelar = btn_cancelar;
    }

    public static JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public static void setBtn_eliminar(JButton btn_eliminar) {
        V_Modificar_Secretaria.btn_eliminar = btn_eliminar;
    }

    public static JButton getBtn_guardar() {
        return btn_guardar;
    }

    public static void setBtn_guardar(JButton btn_guardar) {
        V_Modificar_Secretaria.btn_guardar = btn_guardar;
    }

    public static JButton getBtn_imagen() {
        return btn_imagen;
    }

    public static void setBtn_imagen(JButton btn_imagen) {
        V_Modificar_Secretaria.btn_imagen = btn_imagen;
    }

    public static JButton getBtn_modificar() {
        return btn_modificar;
    }

    public static void setBtn_modificar(JButton btn_modificar) {
        V_Modificar_Secretaria.btn_modificar = btn_modificar;
    }

    public static JCheckBox getCb_1() {
        return cb_1;
    }

    public static void setCb_1(JCheckBox cb_1) {
        V_Modificar_Secretaria.cb_1 = cb_1;
    }

    public static JCheckBox getCb_2() {
        return cb_2;
    }

    public static void setCb_2(JCheckBox cb_2) {
        V_Modificar_Secretaria.cb_2 = cb_2;
    }

    public static JCheckBox getCb_3() {
        return cb_3;
    }

    public static void setCb_3(JCheckBox cb_3) {
        V_Modificar_Secretaria.cb_3 = cb_3;
    }

    public static JCheckBox getCb_4() {
        return cb_4;
    }

    public static void setCb_4(JCheckBox cb_4) {
        V_Modificar_Secretaria.cb_4 = cb_4;
    }

    public static JComboBox<String> getCb_estado() {
        return cb_estado;
    }

    public static void setCb_estado(JComboBox<String> cb_estado) {
        V_Modificar_Secretaria.cb_estado = cb_estado;
    }

    public static JLabel getCelular() {
        return celular;
    }

    public static void setCelular(JLabel celular) {
        V_Modificar_Secretaria.celular = celular;
    }

    public static JLabel getCorreo() {
        return correo;
    }

    public static void setCorreo(JLabel correo) {
        V_Modificar_Secretaria.correo = correo;
    }

    public static JLabel getjLabel1() {
        return jLabel1;
    }

    public static void setjLabel1(JLabel jLabel1) {
        V_Modificar_Secretaria.jLabel1 = jLabel1;
    }

    public static JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public static void setjScrollPane1(JScrollPane jScrollPane1) {
        V_Modificar_Secretaria.jScrollPane1 = jScrollPane1;
    }

    public static JLabel getLaapellido() {
        return laapellido;
    }

    public static void setLaapellido(JLabel laapellido) {
        V_Modificar_Secretaria.laapellido = laapellido;
    }

    public static JLabel getLacedula() {
        return lacedula;
    }

    public static void setLacedula(JLabel lacedula) {
        V_Modificar_Secretaria.lacedula = lacedula;
    }

    public static JLabel getLacelular() {
        return lacelular;
    }

    public static void setLacelular(JLabel lacelular) {
        V_Modificar_Secretaria.lacelular = lacelular;
    }

    public static JLabel getLacorreo() {
        return lacorreo;
    }

    public static void setLacorreo(JLabel lacorreo) {
        V_Modificar_Secretaria.lacorreo = lacorreo;
    }

    public static JLabel getLadireccion() {
        return ladireccion;
    }

    public static void setLadireccion(JLabel ladireccion) {
        V_Modificar_Secretaria.ladireccion = ladireccion;
    }

    public static JLabel getLaestado() {
        return laestado;
    }

    public static void setLaestado(JLabel laestado) {
        V_Modificar_Secretaria.laestado = laestado;
    }

    public static JLabel getLafecha_nac() {
        return lafecha_nac;
    }

    public static void setLafecha_nac(JLabel lafecha_nac) {
        V_Modificar_Secretaria.lafecha_nac = lafecha_nac;
    }

    public static JLabel getLahorario() {
        return lahorario;
    }

    public static void setLahorario(JLabel lahorario) {
        V_Modificar_Secretaria.lahorario = lahorario;
    }

    public static JLabel getLanombre() {
        return lanombre;
    }

    public static void setLanombre(JLabel lanombre) {
        V_Modificar_Secretaria.lanombre = lanombre;
    }

    public static JLabel getLaregistro() {
        return laregistro;
    }

    public static void setLaregistro(JLabel laregistro) {
        V_Modificar_Secretaria.laregistro = laregistro;
    }

    public static JLabel getLb_celular() {
        return lb_celular;
    }

    public static void setLb_celular(JLabel lb_celular) {
        V_Modificar_Secretaria.lb_celular = lb_celular;
    }

    public static JLabel getLb_correo() {
        return lb_correo;
    }

    public static void setLb_correo(JLabel lb_correo) {
        V_Modificar_Secretaria.lb_correo = lb_correo;
    }

    public static JLabel getLb_direccion() {
        return lb_direccion;
    }

    public static void setLb_direccion(JLabel lb_direccion) {
        V_Modificar_Secretaria.lb_direccion = lb_direccion;
    }

    public static JLabel getLb_estado() {
        return lb_estado;
    }

    public static void setLb_estado(JLabel lb_estado) {
        V_Modificar_Secretaria.lb_estado = lb_estado;
    }

    public static JLabel getLb_foto() {
        return lb_foto;
    }

    public static void setLb_foto(JLabel lb_foto) {
        V_Modificar_Secretaria.lb_foto = lb_foto;
    }

    public static JLabel getLb_horario() {
        return lb_horario;
    }

    public static void setLb_horario(JLabel lb_horario) {
        V_Modificar_Secretaria.lb_horario = lb_horario;
    }

    public static JLabel getLb_nombre() {
        return lb_nombre;
    }

    public static void setLb_nombre(JLabel lb_nombre) {
        V_Modificar_Secretaria.lb_nombre = lb_nombre;
    }

    public static JTextField getNacimeinto() {
        return nacimeinto;
    }

    public static void setNacimeinto(JTextField nacimeinto) {
        V_Modificar_Secretaria.nacimeinto = nacimeinto;
    }

    public static JTable getTablepersona() {
        return tablepersona;
    }

    public static void setTablepersona(JTable tablepersona) {
        V_Modificar_Secretaria.tablepersona = tablepersona;
    }

    public static JTextField getTxt_apellido() {
        return txt_apellido;
    }

    public static void setTxt_apellido(JTextField txt_apellido) {
        V_Modificar_Secretaria.txt_apellido = txt_apellido;
    }

    public static JTextField getTxt_buscar() {
        return txt_buscar;
    }

    public static void setTxt_buscar(JTextField txt_buscar) {
        V_Modificar_Secretaria.txt_buscar = txt_buscar;
    }

    public static JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public static void setTxt_cedula(JTextField txt_cedula) {
        V_Modificar_Secretaria.txt_cedula = txt_cedula;
    }

    public static JTextField getTxt_celular() {
        return txt_celular;
    }

    public static void setTxt_celular(JTextField txt_celular) {
        V_Modificar_Secretaria.txt_celular = txt_celular;
    }

    public static JTextField getTxt_correo() {
        return txt_correo;
    }

    public static void setTxt_correo(JTextField txt_correo) {
        V_Modificar_Secretaria.txt_correo = txt_correo;
    }

    public static JTextField getTxt_direccion() {
        return txt_direccion;
    }

    public static void setTxt_direccion(JTextField txt_direccion) {
        V_Modificar_Secretaria.txt_direccion = txt_direccion;
    }

    public static JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public static void setTxt_nombre(JTextField txt_nombre) {
        V_Modificar_Secretaria.txt_nombre = txt_nombre;
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
        lacelular = new javax.swing.JLabel();
        lanombre = new javax.swing.JLabel();
        lacorreo = new javax.swing.JLabel();
        laapellido = new javax.swing.JLabel();
        ladireccion = new javax.swing.JLabel();
        lafecha_nac = new javax.swing.JLabel();
        laestado = new javax.swing.JLabel();
        lahorario = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        cb_estado = new javax.swing.JComboBox<>();
        btn_eliminar = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        cb_1 = new javax.swing.JCheckBox();
        cb_2 = new javax.swing.JCheckBox();
        cb_3 = new javax.swing.JCheckBox();
        cb_4 = new javax.swing.JCheckBox();
        nacimeinto = new javax.swing.JTextField();
        lb_nombre = new javax.swing.JLabel();
        lb_correo = new javax.swing.JLabel();
        lb_estado = new javax.swing.JLabel();
        lb_celular = new javax.swing.JLabel();
        lb_horario = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepersona = new javax.swing.JTable();
        correo = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        btn_imagen = new javax.swing.JButton();
        lb_foto = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MODIFICAR Y ELIMINAR SECRETARIA");
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(550, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        laregistro.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        laregistro.setText("Modificar Informacion");
        jPanel1.add(laregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 30));

        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, 20));

        lacelular.setText("Celular:");
        jPanel1.add(lacelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, 20));

        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 20));

        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, 20));

        laapellido.setText("Apellido:");
        jPanel1.add(laapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, 20));

        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 60, 20));

        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 130, 20));

        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, 20));

        lahorario.setText("Registro de horario:");
        jPanel1.add(lahorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, -1, 20));
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 139, -1));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 139, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 620, 90, 50));

        jPanel1.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 140, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.png"))); // NOI18N
        btn_eliminar.setText("ELIMINAR REGISTRO");
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 620, -1, 50));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 139, -1));
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 139, -1));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 140, -1));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 139, -1));

        cb_1.setText("9:00-13:00");
        jPanel1.add(cb_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, -1, -1));

        cb_2.setText("13:00-15:00");
        jPanel1.add(cb_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, -1, -1));

        cb_3.setText("15:00-16:30");
        jPanel1.add(cb_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, -1, -1));

        cb_4.setText("16:30-18:30");
        jPanel1.add(cb_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, -1, -1));
        jPanel1.add(nacimeinto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 140, -1));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        lb_correo.setBackground(new java.awt.Color(255, 255, 255));
        lb_correo.setForeground(new java.awt.Color(255, 0, 0));
        lb_correo.setText("*Campo Obligatorio");
        jPanel1.add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        lb_estado.setBackground(new java.awt.Color(255, 255, 255));
        lb_estado.setForeground(new java.awt.Color(255, 0, 0));
        lb_estado.setText("*Campo Obligatorio");
        jPanel1.add(lb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, -1));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel1.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        lb_horario.setBackground(new java.awt.Color(255, 255, 255));
        lb_horario.setForeground(new java.awt.Color(255, 0, 0));
        lb_horario.setText("*Campo Obligatorio");
        jPanel1.add(lb_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        lb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        lb_direccion.setForeground(new java.awt.Color(255, 0, 0));
        lb_direccion.setText("*Campo Obligatorio");
        jPanel1.add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        tablepersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablepersona);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 880, 180));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 110, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 110, -1));

        btn_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Foto.png"))); // NOI18N
        btn_imagen.setText("FOTO");
        jPanel1.add(btn_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, -1, 40));
        jPanel1.add(lb_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 130, 140));
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 230, -1));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("BUSCAR:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 70, 30));

        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 100, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_eliminar;
    public static javax.swing.JButton btn_guardar;
    public static javax.swing.JButton btn_imagen;
    public static javax.swing.JButton btn_modificar;
    public static javax.swing.JCheckBox cb_1;
    public static javax.swing.JCheckBox cb_2;
    public static javax.swing.JCheckBox cb_3;
    public static javax.swing.JCheckBox cb_4;
    public static javax.swing.JComboBox<String> cb_estado;
    public static javax.swing.JLabel celular;
    public static javax.swing.JLabel correo;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel laapellido;
    public static javax.swing.JLabel lacedula;
    public static javax.swing.JLabel lacelular;
    public static javax.swing.JLabel lacorreo;
    public static javax.swing.JLabel ladireccion;
    public static javax.swing.JLabel laestado;
    public static javax.swing.JLabel lafecha_nac;
    public static javax.swing.JLabel lahorario;
    public static javax.swing.JLabel lanombre;
    public static javax.swing.JLabel laregistro;
    public static javax.swing.JLabel lb_celular;
    public static javax.swing.JLabel lb_correo;
    public static javax.swing.JLabel lb_direccion;
    public static javax.swing.JLabel lb_estado;
    public static javax.swing.JLabel lb_foto;
    public static javax.swing.JLabel lb_horario;
    public static javax.swing.JLabel lb_nombre;
    public static javax.swing.JTextField nacimeinto;
    public static javax.swing.JTable tablepersona;
    public static javax.swing.JTextField txt_apellido;
    public static javax.swing.JTextField txt_buscar;
    public static javax.swing.JTextField txt_cedula;
    public static javax.swing.JTextField txt_celular;
    public static javax.swing.JTextField txt_correo;
    public static javax.swing.JTextField txt_direccion;
    public static javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
