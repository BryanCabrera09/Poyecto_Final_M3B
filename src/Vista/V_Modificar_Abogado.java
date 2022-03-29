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
public class V_Modificar_Abogado extends javax.swing.JInternalFrame {

    public static String x;

    public V_Modificar_Abogado() {

        initComponents();
        tablepersona.getTableHeader().setResizingAllowed(false);
        tablepersona.getTableHeader().setReorderingAllowed(false);

        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public static JButton getBtncancelar() {
        return btn_cancelar;
    }

    public static void setBtncancelar(JButton btncancelar) {
        V_Modificar_Abogado.btn_cancelar = btncancelar;
    }

    public static JButton getBtnelimina() {
        return btn_elimina;
    }

    public static void setBtnelimina(JButton btnelimina) {
        V_Modificar_Abogado.btn_elimina = btnelimina;
    }

    public static JButton getBtnguardar() {
        return btn_guardar;
    }

    public static void setBtnguardar(JButton btnguardar) {
        V_Modificar_Abogado.btn_guardar = btnguardar;
    }

    public static JButton getBtnimagen() {
        return btn_imagen;
    }

    public static void setBtnimagen(JButton btnimagen) {
        V_Modificar_Abogado.btn_imagen = btnimagen;
    }

    public static JButton getBtnmodificar() {
        return btn_modificar;
    }

    public static void setBtnmodificar(JButton btnmodificar) {
        V_Modificar_Abogado.btn_modificar = btnmodificar;
    }

    public static JCheckBox getCb1() {
        return cb_1;
    }

    public static void setCb1(JCheckBox cb1) {
        V_Modificar_Abogado.cb_1 = cb1;
    }

    public static JCheckBox getCb2() {
        return cb_2;
    }

    public static void setCb2(JCheckBox cb2) {
        V_Modificar_Abogado.cb_2 = cb2;
    }

    public static JCheckBox getCb3() {
        return cb_3;
    }

    public static void setCb3(JCheckBox cb3) {
        V_Modificar_Abogado.cb_3 = cb3;
    }

    public static JCheckBox getCb4() {
        return cb_4;
    }

    public static void setCb4(JCheckBox cb4) {
        V_Modificar_Abogado.cb_4 = cb4;
    }

    public static JComboBox<String> getCbestado() {
        return cb_estado;
    }

    public static void setCbestado(JComboBox<String> cbestado) {
        V_Modificar_Abogado.cb_estado = cbestado;
    }

    public static JLabel getCelular() {
        return celular;
    }

    public static void setCelular(JLabel celular) {
        V_Modificar_Abogado.celular = celular;
    }

    public static JLabel getCorreo() {
        return correo;
    }

    public static void setCorreo(JLabel correo) {
        V_Modificar_Abogado.correo = correo;
    }

    public static JLabel getjLabel2() {
        return jLabel2;
    }

    public static void setjLabel2(JLabel jLabel2) {
        V_Modificar_Abogado.jLabel2 = jLabel2;
    }

    public static JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public static void setjScrollPane1(JScrollPane jScrollPane1) {
        V_Modificar_Abogado.jScrollPane1 = jScrollPane1;
    }

    public static JLabel getLaapellido() {
        return laapellido;
    }

    public static void setLaapellido(JLabel laapellido) {
        V_Modificar_Abogado.laapellido = laapellido;
    }

    public static JLabel getLacedula() {
        return lacedula;
    }

    public static void setLacedula(JLabel lacedula) {
        V_Modificar_Abogado.lacedula = lacedula;
    }

    public static JLabel getLacelular() {
        return lacelular;
    }

    public static void setLacelular(JLabel lacelular) {
        V_Modificar_Abogado.lacelular = lacelular;
    }

    public static JLabel getLacelular1() {
        return lb_celular;
    }

    public static void setLacelular1(JLabel lacelular1) {
        V_Modificar_Abogado.lb_celular = lacelular1;
    }

    public static JLabel getLacorreo() {
        return lacorreo;
    }

    public static void setLacorreo(JLabel lacorreo) {
        V_Modificar_Abogado.lacorreo = lacorreo;
    }

    public static JLabel getLacorreo1() {
        return lb_correo;
    }

    public static void setLacorreo1(JLabel lacorreo1) {
        V_Modificar_Abogado.lb_correo = lacorreo1;
    }

    public static JLabel getLacuenta() {
        return lb_cuenta;
    }

    public static void setLacuenta(JLabel lacuenta) {
        V_Modificar_Abogado.lb_cuenta = lacuenta;
    }

    public static JLabel getLadireccion() {
        return ladireccion;
    }

    public static void setLadireccion(JLabel ladireccion) {
        V_Modificar_Abogado.ladireccion = ladireccion;
    }

    public static JLabel getLadireccion1() {
        return lb_direccion;
    }

    public static void setLadireccion1(JLabel ladireccion1) {
        V_Modificar_Abogado.lb_direccion = ladireccion1;
    }

    public static JLabel getLaestado() {
        return laestado;
    }

    public static void setLaestado(JLabel laestado) {
        V_Modificar_Abogado.laestado = laestado;
    }

    public static JLabel getLaestado1() {
        return lb_estado;
    }

    public static void setLaestado1(JLabel laestado1) {
        V_Modificar_Abogado.lb_estado = laestado1;
    }

    public static JLabel getLafecha_nac() {
        return lafecha_nac;
    }

    public static void setLafecha_nac(JLabel lafecha_nac) {
        V_Modificar_Abogado.lafecha_nac = lafecha_nac;
    }

    public static JLabel getLafoto() {
        return la_foto;
    }

    public static void setLafoto(JLabel lafoto) {
        V_Modificar_Abogado.la_foto = lafoto;
    }

    public static JLabel getLahorario() {
        return lahorario;
    }

    public static void setLahorario(JLabel lahorario) {
        V_Modificar_Abogado.lahorario = lahorario;
    }

    public static JLabel getLahorario1() {
        return lb_horario;
    }

    public static void setLahorario1(JLabel lahorario1) {
        V_Modificar_Abogado.lb_horario = lahorario1;
    }

    public static JLabel getLanombre() {
        return lanombre;
    }

    public static void setLanombre(JLabel lanombre) {
        V_Modificar_Abogado.lanombre = lanombre;
    }

    public static JLabel getLanombre1() {
        return lb_nombre;
    }

    public static void setLanombre1(JLabel lanombre1) {
        V_Modificar_Abogado.lb_nombre = lanombre1;
    }

    public static JLabel getLanum_cuenta() {
        return lanum_cuenta;
    }

    public static void setLanum_cuenta(JLabel lanum_cuenta) {
        V_Modificar_Abogado.lanum_cuenta = lanum_cuenta;
    }

    public static JLabel getLanum_matri() {
        return lanum_matri;
    }

    public static void setLanum_matri(JLabel lanum_matri) {
        V_Modificar_Abogado.lanum_matri = lanum_matri;
    }

    public static JLabel getLaregistro() {
        return laregistro;
    }

    public static void setLaregistro(JLabel laregistro) {
        V_Modificar_Abogado.laregistro = laregistro;
    }

    public static JTextField getNacimeinto() {
        return nacimeinto;
    }

    public static void setNacimeinto(JTextField nacimeinto) {
        V_Modificar_Abogado.nacimeinto = nacimeinto;
    }

    public static JTable getTablepersona() {
        return tablepersona;
    }

    public static void setTablepersona(JTable tablepersona) {
        V_Modificar_Abogado.tablepersona = tablepersona;
    }

    public static JTextField getTxtapellido() {
        return txt_apellido;
    }

    public static void setTxtapellido(JTextField txtapellido) {
        V_Modificar_Abogado.txt_apellido = txtapellido;
    }

    public static JTextField getTxtbuscar() {
        return txt_buscar;
    }

    public static void setTxtbuscar(JTextField txtbuscar) {
        V_Modificar_Abogado.txt_buscar = txtbuscar;
    }

    public static JTextField getTxtcedula() {
        return txt_cedula;
    }

    public static void setTxtcedula(JTextField txtcedula) {
        V_Modificar_Abogado.txt_cedula = txtcedula;
    }

    public static JTextField getTxtcelular() {
        return txt_celular;
    }

    public static void setTxtcelular(JTextField txtcelular) {
        V_Modificar_Abogado.txt_celular = txtcelular;
    }

    public static JTextField getTxtcorreo() {
        return txt_correo;
    }

    public static void setTxtcorreo(JTextField txtcorreo) {
        V_Modificar_Abogado.txt_correo = txtcorreo;
    }

    public static JTextField getTxtcuenta() {
        return txt_cuenta;
    }

    public static void setTxtcuenta(JTextField txtcuenta) {
        V_Modificar_Abogado.txt_cuenta = txtcuenta;
    }

    public static JTextField getTxtdireccion() {
        return txt_direccion;
    }

    public static void setTxtdireccion(JTextField txtdireccion) {
        V_Modificar_Abogado.txt_direccion = txtdireccion;
    }

    public static JTextField getTxtmatricula() {
        return txt_matricula;
    }

    public static void setTxtmatricula(JTextField txtmatricula) {
        V_Modificar_Abogado.txt_matricula = txtmatricula;
    }

    public static JTextField getTxtnombre() {
        return txt_nombre;
    }

    public static void setTxtnombre(JTextField txtnombre) {
        V_Modificar_Abogado.txt_nombre = txtnombre;
    }

    /**
     * Creates new form Modificacion
     */
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
        lanum_matri = new javax.swing.JLabel();
        lanum_cuenta = new javax.swing.JLabel();
        lahorario = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_matricula = new javax.swing.JTextField();
        txt_cuenta = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        cb_estado = new javax.swing.JComboBox<>();
        btn_elimina = new javax.swing.JButton();
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
        lb_cuenta = new javax.swing.JLabel();
        lb_celular = new javax.swing.JLabel();
        lb_horario = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepersona = new javax.swing.JTable();
        correo = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        btn_imagen = new javax.swing.JButton();
        la_foto = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MODIFAR Y ELIMINAR ABOGADO");
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
        jPanel1.add(laregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 50, 20));

        lacelular.setText("Celular:");
        jPanel1.add(lacelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 50, 20));

        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 50, 20));

        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 110, 20));

        laapellido.setText("Apellido:");
        jPanel1.add(laapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 50, 20));

        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 60, 20));

        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 130, 20));

        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 80, 20));

        lanum_matri.setText("Numero de Matricula:");
        jPanel1.add(lanum_matri, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 130, 20));

        lanum_cuenta.setText("Numero de Cuenta:");
        jPanel1.add(lanum_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 110, 20));

        lahorario.setText("Registro de horario:");
        jPanel1.add(lahorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, 20));
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 139, -1));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 139, -1));
        jPanel1.add(txt_matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 160, 20));
        jPanel1.add(txt_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 160, 20));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 690, -1, 40));

        jPanel1.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 160, 20));

        btn_elimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.png"))); // NOI18N
        btn_elimina.setText("ELIMINAR REGISTRO");
        jPanel1.add(btn_elimina, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 690, -1, 40));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 139, -1));
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 139, -1));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 160, 20));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 139, -1));

        cb_1.setText("9:00-13:00");
        jPanel1.add(cb_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, -1, -1));

        cb_2.setText("13:00-15:00");
        jPanel1.add(cb_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, -1, -1));

        cb_3.setText("15:00-16:30");
        jPanel1.add(cb_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, -1, -1));

        cb_4.setText("16:30-18:30");
        jPanel1.add(cb_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, -1, -1));
        jPanel1.add(nacimeinto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 160, 20));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        lb_correo.setBackground(new java.awt.Color(255, 255, 255));
        lb_correo.setForeground(new java.awt.Color(255, 0, 0));
        lb_correo.setText("*Campo Obligatorio");
        jPanel1.add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, 10));

        lb_estado.setBackground(new java.awt.Color(255, 255, 255));
        lb_estado.setForeground(new java.awt.Color(255, 0, 0));
        lb_estado.setText("*Campo Obligatorio");
        jPanel1.add(lb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        lb_cuenta.setBackground(new java.awt.Color(255, 255, 255));
        lb_cuenta.setForeground(new java.awt.Color(255, 0, 0));
        lb_cuenta.setText("*Campo Obligatorio");
        jPanel1.add(lb_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel1.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        lb_horario.setBackground(new java.awt.Color(255, 255, 255));
        lb_horario.setForeground(new java.awt.Color(255, 0, 0));
        lb_horario.setText("*Campo Obligatorio");
        jPanel1.add(lb_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, -1, -1));

        lb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        lb_direccion.setForeground(new java.awt.Color(255, 0, 0));
        lb_direccion.setText("*Campo Obligatorio");
        jPanel1.add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        tablepersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablepersona);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 850, 180));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 110, 10));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 110, -1));

        btn_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Foto.png"))); // NOI18N
        btn_imagen.setText("FOTO");
        jPanel1.add(btn_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, -1, -1));
        jPanel1.add(la_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, 150, 170));
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 230, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("BUSCAR:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 60, 30));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 50));

        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 690, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_elimina;
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
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel la_foto;
    public static javax.swing.JLabel laapellido;
    public static javax.swing.JLabel lacedula;
    public static javax.swing.JLabel lacelular;
    public static javax.swing.JLabel lacorreo;
    public static javax.swing.JLabel ladireccion;
    public static javax.swing.JLabel laestado;
    public static javax.swing.JLabel lafecha_nac;
    public static javax.swing.JLabel lahorario;
    public static javax.swing.JLabel lanombre;
    public static javax.swing.JLabel lanum_cuenta;
    public static javax.swing.JLabel lanum_matri;
    public static javax.swing.JLabel laregistro;
    public static javax.swing.JLabel lb_celular;
    public static javax.swing.JLabel lb_correo;
    public static javax.swing.JLabel lb_cuenta;
    public static javax.swing.JLabel lb_direccion;
    public static javax.swing.JLabel lb_estado;
    public static javax.swing.JLabel lb_horario;
    public static javax.swing.JLabel lb_nombre;
    public static javax.swing.JTextField nacimeinto;
    public static javax.swing.JTable tablepersona;
    public static javax.swing.JTextField txt_apellido;
    public static javax.swing.JTextField txt_buscar;
    public static javax.swing.JTextField txt_cedula;
    public static javax.swing.JTextField txt_celular;
    public static javax.swing.JTextField txt_correo;
    public static javax.swing.JTextField txt_cuenta;
    public static javax.swing.JTextField txt_direccion;
    public static javax.swing.JTextField txt_matricula;
    public static javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
