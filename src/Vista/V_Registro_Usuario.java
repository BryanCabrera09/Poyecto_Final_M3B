package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * @author BRYAN_CABRERA
 */
public class V_Registro_Usuario extends javax.swing.JInternalFrame {
    
    public static String x;

    public V_Registro_Usuario() {
        initComponents();
        setTitle("USUARIOS");
       
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public static JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public static void setBtn_cancelar(JButton btn_cancelar) {
        V_Registro_Usuario.btn_cancelar = btn_cancelar;
    }

    public static JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public static void setBtn_nuevo(JButton btn_nuevo) {
        V_Registro_Usuario.btn_nuevo = btn_nuevo;
    }

    public static JButton getBtn_registar() {
        return btn_registar;
    }

    public static void setBtn_registar(JButton btn_registar) {
        V_Registro_Usuario.btn_registar = btn_registar;
    }

    public static JLabel getLb_cedula() {
        return lb_cedula;
    }

    public static void setLb_cedula(JLabel lb_cedula) {
        V_Registro_Usuario.lb_cedula = lb_cedula;
    }

    public static JLabel getLb_contraseña() {
        return lb_contraseña;
    }

    public static void setLb_contraseña(JLabel lb_contraseña) {
        V_Registro_Usuario.lb_contraseña = lb_contraseña;
    }

    public static JLabel getLb_usuario() {
        return lb_usuario;
    }

    public static void setLb_usuario(JLabel lb_usuario) {
        V_Registro_Usuario.lb_usuario = lb_usuario;
    }

    public static JLabel getLbl_cedula() {
        return lbl_cedula;
    }

    public static void setLbl_cedula(JLabel lbl_cedula) {
        V_Registro_Usuario.lbl_cedula = lbl_cedula;
    }

    public static JLabel getLbl_contraseña() {
        return lbl_contraseña;
    }

    public static void setLbl_contraseña(JLabel lbl_contraseña) {
        V_Registro_Usuario.lbl_contraseña = lbl_contraseña;
    }

    public static JLabel getLbl_registro() {
        return lbl_registro;
    }

    public static void setLbl_registro(JLabel lbl_registro) {
        V_Registro_Usuario.lbl_registro = lbl_registro;
    }

    public static JLabel getLbl_usuario() {
        return lbl_usuario;
    }

    public static void setLbl_usuario(JLabel lbl_usuario) {
        V_Registro_Usuario.lbl_usuario = lbl_usuario;
    }

    public static JPasswordField getPsw_contraseña() {
        return psw_contraseña;
    }

    public static void setPsw_contraseña(JPasswordField psw_contraseña) {
        V_Registro_Usuario.psw_contraseña = psw_contraseña;
    }

    public static JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public static void setTxt_cedula(JTextField txt_cedula) {
        V_Registro_Usuario.txt_cedula = txt_cedula;
    }

    public static JTextField getTxt_usuario() {
        return txt_usuario;
    }

    public static void setTxt_usuario(JTextField txt_usuario) {
        V_Registro_Usuario.txt_usuario = txt_usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_registro = new javax.swing.JLabel();
        lbl_cedula = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contraseña = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        psw_contraseña = new javax.swing.JPasswordField();
        btn_registar = new javax.swing.JButton();
        lb_contraseña = new javax.swing.JLabel();
        lb_cedula = new javax.swing.JLabel();
        lb_usuario = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_cedula = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO USUARIO");
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

        lbl_registro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_registro.setText("REGISTRO USUARIO");
        jPanel1.add(lbl_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 150, 30));

        lbl_cedula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_cedula.setText("CEDULA:");
        jPanel1.add(lbl_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 60, 20));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_usuario.setText("USUARIO:");
        jPanel1.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 60, 20));

        lbl_contraseña.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_contraseña.setText("CONTRASEÑA:");
        jPanel1.add(lbl_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 90, 20));
        jPanel1.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 180, 30));

        psw_contraseña.setEchoChar('\u25cf');
        jPanel1.add(psw_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 180, 30));

        btn_registar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_registar.setText("GUARDAR");
        jPanel1.add(btn_registar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 120, 50));

        lb_contraseña.setBackground(new java.awt.Color(255, 255, 255));
        lb_contraseña.setForeground(new java.awt.Color(255, 0, 0));
        lb_contraseña.setText("*Campo Obligatorio");
        jPanel1.add(lb_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        lb_cedula.setBackground(new java.awt.Color(255, 255, 255));
        lb_cedula.setForeground(new java.awt.Color(255, 0, 0));
        lb_cedula.setText("*Campo Obligatorio");
        jPanel1.add(lb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        lb_usuario.setBackground(new java.awt.Color(255, 255, 255));
        lb_usuario.setForeground(new java.awt.Color(255, 0, 0));
        lb_usuario.setText("*Campo Obligatorio");
        jPanel1.add(lb_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 50));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 130, 50));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_nuevo;
    public static javax.swing.JButton btn_registar;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lb_cedula;
    public static javax.swing.JLabel lb_contraseña;
    public static javax.swing.JLabel lb_usuario;
    public static javax.swing.JLabel lbl_cedula;
    public static javax.swing.JLabel lbl_contraseña;
    public static javax.swing.JLabel lbl_registro;
    public static javax.swing.JLabel lbl_usuario;
    public static javax.swing.JPasswordField psw_contraseña;
    public static javax.swing.JTextField txt_cedula;
    public static javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
