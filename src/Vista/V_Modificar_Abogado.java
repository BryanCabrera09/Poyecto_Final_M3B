/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * @author BRYAN_CABRERA
 */
public class V_Modificar_Abogado extends javax.swing.JInternalFrame {

    public static String x;

    protected static File ruta;
    protected static Image img;

    public String rutas;

    public V_Modificar_Abogado() {

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

    public JButton getBtn_elimina() {
        return btn_elimina;
    }

    public void setBtn_elimina(JButton btn_elimina) {
        this.btn_elimina = btn_elimina;
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

    public JButton getBtn_modificar() {
        return btn_modificar;
    }

    public void setBtn_modificar(JButton btn_modificar) {
        this.btn_modificar = btn_modificar;
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLa_foto() {
        return la_foto;
    }

    public void setLa_foto(JLabel la_foto) {
        this.la_foto = la_foto;
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

    public JLabel getLb_horario() {
        return lb_horario;
    }

    public void setLb_horario(JLabel lb_horario) {
        this.lb_horario = lb_horario;
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

    public JTextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(JTextField txt_id) {
        this.txt_id = txt_id;
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
            img = img.getScaledInstance(getLa_foto().getWidth(), getLa_foto().getHeight(), img.SCALE_DEFAULT);
            getLa_foto().setIcon(new ImageIcon(img));
        }
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
        lb_apellido = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();

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
        jPanel1.add(laregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 50, 20));

        lacelular.setText("Celular:");
        jPanel1.add(lacelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 50, 20));

        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 50, 20));

        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 110, 20));

        laapellido.setText("Apellido:");
        jPanel1.add(laapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 50, 20));

        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 60, 20));

        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 130, 20));

        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 80, 20));

        lanum_matri.setText("Numero de Matricula:");
        jPanel1.add(lanum_matri, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 130, 20));

        lanum_cuenta.setText("Numero de Cuenta:");
        jPanel1.add(lanum_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 110, 20));

        lahorario.setText("Registro de horario:");
        jPanel1.add(lahorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, 20));
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 139, -1));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 139, -1));
        jPanel1.add(txt_matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 160, 20));
        jPanel1.add(txt_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 160, 20));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 730, -1, 40));

        jPanel1.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 160, 20));

        btn_elimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar.png"))); // NOI18N
        btn_elimina.setText("ELIMINAR REGISTRO");
        jPanel1.add(btn_elimina, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 730, -1, 40));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 139, -1));
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 139, -1));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 160, 20));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 139, -1));

        cb_1.setText("9:00-13:00");
        jPanel1.add(cb_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, -1, -1));

        cb_2.setText("13:00-15:00");
        jPanel1.add(cb_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, -1, -1));

        cb_3.setText("15:00-16:30");
        jPanel1.add(cb_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, -1, -1));

        cb_4.setText("16:30-18:30");
        jPanel1.add(cb_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, -1, -1));
        jPanel1.add(nacimeinto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 160, 20));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        lb_correo.setBackground(new java.awt.Color(255, 255, 255));
        lb_correo.setForeground(new java.awt.Color(255, 0, 0));
        lb_correo.setText("*Campo Obligatorio");
        jPanel1.add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, 10));

        lb_estado.setBackground(new java.awt.Color(255, 255, 255));
        lb_estado.setForeground(new java.awt.Color(255, 0, 0));
        lb_estado.setText("*Campo Obligatorio");
        jPanel1.add(lb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        lb_cuenta.setBackground(new java.awt.Color(255, 255, 255));
        lb_cuenta.setForeground(new java.awt.Color(255, 0, 0));
        lb_cuenta.setText("*Campo Obligatorio");
        jPanel1.add(lb_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, -1));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel1.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        lb_horario.setBackground(new java.awt.Color(255, 255, 255));
        lb_horario.setForeground(new java.awt.Color(255, 0, 0));
        lb_horario.setText("*Campo Obligatorio");
        jPanel1.add(lb_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, -1, -1));

        lb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        lb_direccion.setForeground(new java.awt.Color(255, 0, 0));
        lb_direccion.setText("*Campo Obligatorio");
        jPanel1.add(lb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, -1));

        tablepersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablepersona);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 850, 180));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 110, 10));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 110, -1));

        btn_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Foto.png"))); // NOI18N
        btn_imagen.setText("FOTO");
        jPanel1.add(btn_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, -1));
        jPanel1.add(la_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 150, 170));
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 230, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("BUSCAR:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 60, 30));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 50));

        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 730, -1, 40));

        lb_apellido.setBackground(new java.awt.Color(255, 255, 255));
        lb_apellido.setForeground(new java.awt.Color(255, 0, 0));
        lb_apellido.setText("*Campo Obligatorio");
        jPanel1.add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_elimina;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imagen;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JCheckBox cb_1;
    private javax.swing.JCheckBox cb_2;
    private javax.swing.JCheckBox cb_3;
    private javax.swing.JCheckBox cb_4;
    private javax.swing.JComboBox<String> cb_estado;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel la_foto;
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
    private javax.swing.JLabel lb_celular;
    private javax.swing.JLabel lb_correo;
    private javax.swing.JLabel lb_cuenta;
    private javax.swing.JLabel lb_direccion;
    private javax.swing.JLabel lb_estado;
    private javax.swing.JLabel lb_horario;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JTextField nacimeinto;
    private javax.swing.JTable tablepersona;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_cuenta;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_matricula;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
