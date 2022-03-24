/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Usuario
 */
public class RequisitosRenovacionPasaporte extends javax.swing.JInternalFrame {

    public static String x;

    /**
     * Creates new form RequisitosRenovacionPasaporte
     */
    public RequisitosRenovacionPasaporte() {
        initComponents();
        x = "x";
        int a = MenuInicio.escritorio.getWidth() - this.getWidth();
        int b = MenuInicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rq1 = new javax.swing.JCheckBox();
        rq4 = new javax.swing.JCheckBox();
        rq5 = new javax.swing.JCheckBox();
        rq3 = new javax.swing.JCheckBox();
        rq2 = new javax.swing.JCheckBox();
        rq6 = new javax.swing.JCheckBox();
        comboNum = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        honorarios = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btn_pago = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("RENOVACION PASAPORTE AMERICANO");
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

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("REQUISITOS RENOVACION PASAPORTE ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 19, -1, -1));

        rq1.setText("PASAPORTE AMERICANO CADUCADO");
        jPanel2.add(rq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 66, -1, -1));

        rq4.setText("FOTOS DE PROGRESION");
        jPanel2.add(rq4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 194, -1, -1));

        rq5.setText("2 FOTOS 5 x 5 ");
        jPanel2.add(rq5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 235, -1, -1));

        rq3.setText("SOCIAL SECURITY");
        jPanel2.add(rq3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        rq2.setText("ACTA DE NATURALIZACION");
        jPanel2.add(rq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 107, -1, -1));

        rq6.setText("DIRECCION EN LOS EEUU");
        jPanel2.add(rq6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 276, -1, -1));

        jPanel2.add(comboNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 67, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NUMERO DE PERSONAS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 70, -1, -1));

        observaciones.setColumns(20);
        observaciones.setRows(5);
        jScrollPane1.setViewportView(observaciones);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 202, 290, -1));

        jLabel3.setText("OBSERVACIONES:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 177, -1, -1));

        honorarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        honorarios.setForeground(new java.awt.Color(51, 0, 0));
        honorarios.setText("HONORARIOS: 100 POR PERSONA");
        jPanel2.add(honorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 116, -1, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        btn_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pagar.png"))); // NOI18N
        btn_pago.setText("PAGO");
        jPanel2.add(btn_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_pantalla.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 670, 350));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btn_pago;
    public javax.swing.JComboBox<String> comboNum;
    public javax.swing.JLabel honorarios;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea observaciones;
    public javax.swing.JCheckBox rq1;
    public javax.swing.JCheckBox rq2;
    public javax.swing.JCheckBox rq3;
    public javax.swing.JCheckBox rq4;
    public javax.swing.JCheckBox rq5;
    public javax.swing.JCheckBox rq6;
    // End of variables declaration//GEN-END:variables
}