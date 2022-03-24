package vista;

/*
 * @author BRYAN_CABRERA
 */
public class RegistroUsuario extends javax.swing.JInternalFrame {
    
    public static String x;

    public RegistroUsuario() {
        initComponents();
        setTitle("USUARIOS");
       
        x = "x";
        int a = MenuInicio.escritorio.getWidth() - this.getWidth();
        int b = MenuInicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
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
        contraseña = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txt_cedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

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
        jPanel1.add(lbl_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        lbl_cedula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_cedula.setText("CEDULA");
        jPanel1.add(lbl_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 60, 20));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_usuario.setText("USUARIO");
        jPanel1.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 60, 20));

        lbl_contraseña.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_contraseña.setText("CONTRASEÑA");
        jPanel1.add(lbl_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, 20));
        jPanel1.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 140, -1));
        jPanel1.add(psw_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, -1));

        btn_registar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_registar.setText("GUARDAR");
        jPanel1.add(btn_registar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 120, 30));

        contraseña.setBackground(new java.awt.Color(255, 255, 255));
        contraseña.setForeground(new java.awt.Color(255, 0, 0));
        contraseña.setText("*Campo Obligatorio");
        jPanel1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        cedula.setBackground(new java.awt.Color(255, 255, 255));
        cedula.setForeground(new java.awt.Color(255, 0, 0));
        cedula.setText("*Campo Obligatorio");
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        usuario.setBackground(new java.awt.Color(255, 255, 255));
        usuario.setForeground(new java.awt.Color(255, 0, 0));
        usuario.setText("*Campo Obligatorio");
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 40));

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 140, 33));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_pantalla.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 470, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_registar;
    public javax.swing.JButton btncancelar;
    public javax.swing.JButton btnnuevo;
    public javax.swing.JLabel cedula;
    public javax.swing.JLabel contraseña;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lbl_cedula;
    public javax.swing.JLabel lbl_contraseña;
    public javax.swing.JLabel lbl_registro;
    public javax.swing.JLabel lbl_usuario;
    public javax.swing.JPasswordField psw_contraseña;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_usuario;
    public javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
