/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/*
 * @author BRYAN_CABRERA
 */
public class RegistroSecretaria extends javax.swing.JInternalFrame {
    
    public static String x;

    public RegistroSecretaria() {
        initComponents();
       
        setTitle("SECRETARIAS");
      
        x = "x";
        int a = MenuInicio.escritorio.getWidth() - this.getWidth();
        int b = MenuInicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lanombre1 = new javax.swing.JLabel();
        lanombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        laapellido2 = new javax.swing.JLabel();
        laapellido1 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        lacedula = new javax.swing.JLabel();
        lacedula1 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        lacelular2 = new javax.swing.JLabel();
        lacelular1 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        ladireccion = new javax.swing.JLabel();
        ladireccion1 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        lacorreo = new javax.swing.JLabel();
        lacorreo1 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        lafecha_nac = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lafecha = new javax.swing.JLabel();
        laestado = new javax.swing.JLabel();
        laestado1 = new javax.swing.JLabel();
        cbestado = new javax.swing.JComboBox<>();
        lahorario = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        cb1 = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb3 = new javax.swing.JCheckBox();
        cb4 = new javax.swing.JCheckBox();
        btncancelar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        correo = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        lafoto = new javax.swing.JLabel();
        btnimagen = new javax.swing.JButton();
        datocedula = new javax.swing.JLabel();
        datocorreo = new javax.swing.JLabel();
        lahorario1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 220, 53));

        lanombre1.setBackground(new java.awt.Color(255, 255, 255));
        lanombre1.setForeground(new java.awt.Color(255, 0, 0));
        lanombre1.setText("*Campo Obligatorio");
        jPanel1.add(lanombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        lanombre.setText("Nombre:");
        jPanel1.add(lanombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 132, -1));

        laapellido2.setText("Apellido:");
        jPanel1.add(laapellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        laapellido1.setBackground(new java.awt.Color(255, 255, 255));
        laapellido1.setForeground(new java.awt.Color(255, 0, 0));
        laapellido1.setText("*Campo Obligatorio");
        jPanel1.add(laapellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 132, -1));

        lacedula.setText("Cedula:");
        jPanel1.add(lacedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, 20));

        lacedula1.setBackground(new java.awt.Color(255, 255, 255));
        lacedula1.setForeground(new java.awt.Color(255, 0, 0));
        lacedula1.setText("*Campo Obligatorio");
        jPanel1.add(lacedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 130, -1));

        lacelular2.setText("Celular:");
        jPanel1.add(lacelular2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 20));

        lacelular1.setBackground(new java.awt.Color(255, 255, 255));
        lacelular1.setForeground(new java.awt.Color(255, 0, 0));
        lacelular1.setText("*Campo Obligatorio");
        jPanel1.add(lacelular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));
        jPanel1.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 130, -1));

        ladireccion.setText("Direccion:");
        jPanel1.add(ladireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, 20));

        ladireccion1.setBackground(new java.awt.Color(255, 255, 255));
        ladireccion1.setForeground(new java.awt.Color(255, 0, 0));
        ladireccion1.setText("*Campo Obligatorio");
        jPanel1.add(ladireccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 150, -1));

        lacorreo.setText("Correo Electronico:");
        jPanel1.add(lacorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, 20));

        lacorreo1.setBackground(new java.awt.Color(255, 255, 255));
        lacorreo1.setForeground(new java.awt.Color(255, 0, 0));
        lacorreo1.setText("*Campo Obligatorio");
        jPanel1.add(lacorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));
        jPanel1.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 145, -1));

        lafecha_nac.setText("Fecha de Nacimiento:");
        jPanel1.add(lafecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, 20));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 141, -1));

        lafecha.setBackground(new java.awt.Color(255, 255, 255));
        lafecha.setForeground(new java.awt.Color(255, 0, 0));
        lafecha.setText("*Campo Obligatorio");
        jPanel1.add(lafecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        laestado.setText("Estado civil:");
        jPanel1.add(laestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, 20));

        laestado1.setBackground(new java.awt.Color(255, 255, 255));
        laestado1.setForeground(new java.awt.Color(255, 0, 0));
        laestado1.setText("*Campo Obligatorio");
        jPanel1.add(laestado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        jPanel1.add(cbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 145, -1));

        lahorario.setText("Registro de horario:");
        jPanel1.add(lahorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, 20));

        foto.setBackground(new java.awt.Color(255, 255, 255));
        foto.setForeground(new java.awt.Color(255, 0, 0));
        foto.setText("*Campo Obligatorio");
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, -1, -1));

        cb1.setText("9:00-13:00");
        jPanel1.add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, -1));

        cb2.setText("13:00-15:00");
        jPanel1.add(cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, -1, -1));

        cb3.setText("15:00-16:30");
        jPanel1.add(cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        cb4.setText("16:30-18:30");
        jPanel1.add(cb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, -1, -1));

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 130, 40));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnguardar.setText("GUARDAR");
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 120, 40));

        btnnuevo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 40));

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(255, 0, 0));
        correo.setText("*Correo Erroneo");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 110, -1));

        cedula.setForeground(new java.awt.Color(255, 0, 0));
        cedula.setText("*Cedula Erronea");
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 100, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));
        jPanel1.add(lafoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 150, 160));

        btnimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Foto.png"))); // NOI18N
        btnimagen.setText("FOTO");
        jPanel1.add(btnimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, -1));

        datocedula.setForeground(new java.awt.Color(255, 0, 0));
        datocedula.setText("*Dato Existente");
        jPanel1.add(datocedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        datocorreo.setForeground(new java.awt.Color(255, 0, 0));
        datocorreo.setText("*Dato Existente");
        jPanel1.add(datocorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        lahorario1.setBackground(new java.awt.Color(255, 255, 255));
        lahorario1.setForeground(new java.awt.Color(255, 0, 0));
        lahorario1.setText("*Campo Obligatorio");
        jPanel1.add(lahorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_pantalla.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 910, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btncancelar;
    public javax.swing.JButton btnguardar;
    public javax.swing.JButton btnimagen;
    public javax.swing.JButton btnnuevo;
    public javax.swing.JCheckBox cb1;
    public javax.swing.JCheckBox cb2;
    public javax.swing.JCheckBox cb3;
    public javax.swing.JCheckBox cb4;
    public javax.swing.JComboBox<String> cbestado;
    public javax.swing.JLabel cedula;
    public javax.swing.JLabel celular;
    public javax.swing.JLabel correo;
    public javax.swing.JLabel datocedula;
    public javax.swing.JLabel datocorreo;
    public javax.swing.JLabel foto;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel laapellido1;
    public javax.swing.JLabel laapellido2;
    public javax.swing.JLabel lacedula;
    public javax.swing.JLabel lacedula1;
    public javax.swing.JLabel lacelular1;
    public javax.swing.JLabel lacelular2;
    public javax.swing.JLabel lacorreo;
    public javax.swing.JLabel lacorreo1;
    public javax.swing.JLabel ladireccion;
    public javax.swing.JLabel ladireccion1;
    public javax.swing.JLabel laestado;
    public javax.swing.JLabel laestado1;
    public javax.swing.JLabel lafecha;
    public javax.swing.JLabel lafecha_nac;
    public javax.swing.JLabel lafoto;
    public javax.swing.JLabel lahorario;
    public javax.swing.JLabel lahorario1;
    public javax.swing.JLabel lanombre;
    public javax.swing.JLabel lanombre1;
    public javax.swing.JTextField txtapellido;
    public javax.swing.JTextField txtcedula;
    public javax.swing.JTextField txtcelular;
    public javax.swing.JTextField txtcorreo;
    public javax.swing.JTextField txtdireccion;
    public javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
