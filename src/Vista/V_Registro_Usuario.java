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

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public void setBtn_nuevo(JButton btn_nuevo) {
        this.btn_nuevo = btn_nuevo;
    }

    public JButton getBtn_registar() {
        return btn_registar;
    }

    public void setBtn_registar(JButton btn_registar) {
        this.btn_registar = btn_registar;
    }

    public JLabel getLb_cedula() {
        return lb_cedula;
    }

    public void setLb_cedula(JLabel lb_cedula) {
        this.lb_cedula = lb_cedula;
    }

    public JLabel getLb_contracorta() {
        return lb_contracorta;
    }

    public void setLb_contracorta(JLabel lb_contracorta) {
        this.lb_contracorta = lb_contracorta;
    }

    public JLabel getLb_contraseña() {
        return lb_contraseña;
    }

    public void setLb_contraseña(JLabel lb_contraseña) {
        this.lb_contraseña = lb_contraseña;
    }

    public JLabel getLb_existente() {
        return lb_existente;
    }

    public void setLb_existente(JLabel lb_existente) {
        this.lb_existente = lb_existente;
    }

    public JLabel getLb_usuario() {
        return lb_usuario;
    }

    public void setLb_usuario(JLabel lb_usuario) {
        this.lb_usuario = lb_usuario;
    }

    public JLabel getLbl_cedula() {
        return lbl_cedula;
    }

    public void setLbl_cedula(JLabel lbl_cedula) {
        this.lbl_cedula = lbl_cedula;
    }

    public JLabel getLbl_contraseña() {
        return lbl_contraseña;
    }

    public void setLbl_contraseña(JLabel lbl_contraseña) {
        this.lbl_contraseña = lbl_contraseña;
    }

    public JLabel getLbl_registro() {
        return lbl_registro;
    }

    public void setLbl_registro(JLabel lbl_registro) {
        this.lbl_registro = lbl_registro;
    }

    public JLabel getLbl_usuario() {
        return lbl_usuario;
    }

    public void setLbl_usuario(JLabel lbl_usuario) {
        this.lbl_usuario = lbl_usuario;
    }

    public JPasswordField getPsw_contraseña() {
        return psw_contraseña;
    }

    public void setPsw_contraseña(JPasswordField psw_contraseña) {
        this.psw_contraseña = psw_contraseña;
    }

    public JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public void setTxt_cedula(JTextField txt_cedula) {
        this.txt_cedula = txt_cedula;
    }

    public JTextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(JTextField txt_id) {
        this.txt_id = txt_id;
    }

    public JTextField getTxt_usuario() {
        return txt_usuario;
    }

    public void setTxt_usuario(JTextField txt_usuario) {
        this.txt_usuario = txt_usuario;
    }

    public JLabel getLb_registro() {
        return lb_registro;
    }

    public void setLb_registro(JLabel lb_registro) {
        this.lb_registro = lb_registro;
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
        lb_existente = new javax.swing.JLabel();
        lb_contracorta = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lb_registro = new javax.swing.JLabel();

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

        btn_registar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_registar.setText("GUARDAR");
        jPanel1.add(btn_registar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 120, 50));

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

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Nuevo.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 50));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 130, 50));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 180, 30));

        lb_existente.setBackground(new java.awt.Color(255, 255, 255));
        lb_existente.setForeground(new java.awt.Color(255, 0, 0));
        lb_existente.setText("*Usuario ya registrado");
        jPanel1.add(lb_existente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        lb_contracorta.setBackground(new java.awt.Color(255, 255, 255));
        lb_contracorta.setForeground(new java.awt.Color(255, 0, 0));
        lb_contracorta.setText("*Minimo 6 Caractéres");
        jPanel1.add(lb_contracorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 110, -1));

        lb_registro.setForeground(new java.awt.Color(255, 0, 0));
        lb_registro.setText("*Ya Posee Un Registro");
        jPanel1.add(lb_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_registar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_cedula;
    private javax.swing.JLabel lb_contracorta;
    private javax.swing.JLabel lb_contraseña;
    private javax.swing.JLabel lb_existente;
    private javax.swing.JLabel lb_registro;
    private javax.swing.JLabel lb_usuario;
    private javax.swing.JLabel lbl_cedula;
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_registro;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPasswordField psw_contraseña;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
