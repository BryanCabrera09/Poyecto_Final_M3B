/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * @author BRYAN_CABRERA
 */
public class V_Modificar_Cliente extends javax.swing.JInternalFrame {

    public static String x;

    /**
     * Creates new form Modificacion
     */
    public V_Modificar_Cliente() {

        initComponents();
        tablepersona.getTableHeader().setResizingAllowed(false);
        tablepersona.getTableHeader().setReorderingAllowed(false);
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

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public JButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public JButton getBtn_modificar() {
        return btn_modificar;
    }

    public void setBtn_modificar(JButton btn_modificar) {
        this.btn_modificar = btn_modificar;
    }

    public JComboBox<String> getCb_estado() {
        return cb_estado;
    }

    public void setCb_estado(JComboBox<String> cb_estado) {
        this.cb_estado = cb_estado;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
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

    public JLabel getLaregistro() {
        return laregistro;
    }

    public void setLaregistro(JLabel laregistro) {
        this.laregistro = laregistro;
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

    public JLabel getLb_nombre() {
        return lb_nombre;
    }

    public void setLb_nombre(JLabel lb_nombre) {
        this.lb_nombre = lb_nombre;
    }

    public JTextField getNacimeinto() {
        return nacimeinto;
    }

    public void setNacimeinto(JTextField nacimeinto) {
        this.nacimeinto = nacimeinto;
    }

    public JTable getTablepersona() {
        return tablepersona;
    }

    public void setTablepersona(JTable tablepersona) {
        this.tablepersona = tablepersona;
    }

    public JTextField getTxt_apellido() {
        return txt_apellido;
    }

    public void setTxt_apellido(JTextField txt_apellido) {
        this.txt_apellido = txt_apellido;
    }

    public JTextField getTxt_buscar() {
        return txt_buscar;
    }

    public void setTxt_buscar(JTextField txt_buscar) {
        this.txt_buscar = txt_buscar;
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

    public JTextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(JTextField txt_id) {
        this.txt_id = txt_id;
    }

    public JLabel getLb_apellido() {
        return lb_apellido;
    }

    public void setLb_apellido(JLabel lb_apellido) {
        this.lb_apellido = lb_apellido;
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
        lanum_cuenta = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_ocupacion = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        cb_estado = new javax.swing.JComboBox<>();
        btn_eliminar = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        nacimeinto = new javax.swing.JTextField();
        lb_nombre = new javax.swing.JLabel();
        lb_correo = new javax.swing.JLabel();
        lb_estado = new javax.swing.JLabel();
        lb_cuenta = new javax.swing.JLabel();
        lb_celular = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepersona = new javax.swing.JTable();
        correo = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_modificar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        lb_apellido = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MODICIFAR Y ELIMINAR CLIENTE");
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
        jPanel1.add(laregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 30));

        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, 20));

        lacelular.setText("Celular:");
        jPanel1.add(lacelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, 20));

        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 20));

        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, 20));

        laapellido.setText("Apellido:");
        jPanel1.add(laapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, 20));

        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, 20));

        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, 20));

        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, 20));

        lanum_cuenta.setText("Ocupacion:");
        jPanel1.add(lanum_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, 20));
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 139, -1));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 139, -1));
        jPanel1.add(txt_ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 160, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 720, -1, 40));

        jPanel1.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 160, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar.png"))); // NOI18N
        btn_eliminar.setText("ELIMINAR REGISTRO");
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 720, -1, 40));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 139, -1));
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 139, -1));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 160, -1));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 139, -1));
        jPanel1.add(nacimeinto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 160, -1));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        lb_correo.setBackground(new java.awt.Color(255, 255, 255));
        lb_correo.setForeground(new java.awt.Color(255, 0, 0));
        lb_correo.setText("*Campo Obligatorio");
        jPanel1.add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        lb_estado.setBackground(new java.awt.Color(255, 255, 255));
        lb_estado.setForeground(new java.awt.Color(255, 0, 0));
        lb_estado.setText("*Campo Obligatorio");
        jPanel1.add(lb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        lb_cuenta.setBackground(new java.awt.Color(255, 255, 255));
        lb_cuenta.setForeground(new java.awt.Color(255, 0, 0));
        lb_cuenta.setText("*Campo Obligatorio");
        jPanel1.add(lb_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, -1, -1));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel1.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        lb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        lb_direccion.setForeground(new java.awt.Color(255, 0, 0));
        lb_direccion.setText("*Campo Obligatorio");
        jPanel1.add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        tablepersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablepersona);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 770, 180));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 110, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 110, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("BUSCAR:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 70, 30));
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 200, -1));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 40));

        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 720, -1, 40));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 120, -1));

        lb_apellido.setBackground(new java.awt.Color(255, 255, 255));
        lb_apellido.setForeground(new java.awt.Color(255, 0, 0));
        lb_apellido.setText("*Campo Obligatorio");
        jPanel1.add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cb_estado;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel laapellido;
    private javax.swing.JLabel lacedula;
    private javax.swing.JLabel lacelular;
    private javax.swing.JLabel lacorreo;
    private javax.swing.JLabel ladireccion;
    private javax.swing.JLabel laestado;
    private javax.swing.JLabel lafecha_nac;
    private javax.swing.JLabel lanombre;
    private javax.swing.JLabel lanum_cuenta;
    private javax.swing.JLabel laregistro;
    private javax.swing.JLabel lb_apellido;
    private javax.swing.JLabel lb_celular;
    private javax.swing.JLabel lb_correo;
    private javax.swing.JLabel lb_cuenta;
    private javax.swing.JLabel lb_direccion;
    private javax.swing.JLabel lb_estado;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JTextField nacimeinto;
    private javax.swing.JTable tablepersona;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ocupacion;
    // End of variables declaration//GEN-END:variables
}
