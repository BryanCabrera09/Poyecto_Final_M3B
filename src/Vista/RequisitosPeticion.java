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
public class RequisitosPeticion extends javax.swing.JInternalFrame {

    public static String x;

    /**
     * Creates new form Requisitos
     */
    public RequisitosPeticion() {
        initComponents();
        setTitle("PETICION FAMILIAR");
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

        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rq1 = new javax.swing.JCheckBox();
        rq2 = new javax.swing.JCheckBox();
        rq4 = new javax.swing.JCheckBox();
        rq5 = new javax.swing.JCheckBox();
        rq3 = new javax.swing.JCheckBox();
        rq8 = new javax.swing.JCheckBox();
        rq7 = new javax.swing.JCheckBox();
        rq9 = new javax.swing.JCheckBox();
        rq6 = new javax.swing.JCheckBox();
        comboNum = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        honorarios = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_pago = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jCheckBox10.setText("COPIA PASAPORTE - BENEFICIARIO");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("PETICION FAMILIAR");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("REQUISITOS PETICION FAMILIAR ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 19, -1, -1));

        rq1.setText("PASAPORTE");
        jPanel1.add(rq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 66, -1, -1));

        rq2.setText("PARTIDA DE NACIMIENTO - PETICIONARIO");
        jPanel1.add(rq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 107, -1, -1));

        rq4.setText("PARTIDAS DE MATRIMONIO");
        jPanel1.add(rq4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 189, -1, -1));

        rq5.setText("FOTOS 5 x 5 - PETICIONARIO");
        jPanel1.add(rq5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 230, -1, -1));

        rq3.setText("PARTIDA DE NACIMIENTO - BENEFICIARIO");
        jPanel1.add(rq3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 148, -1, -1));

        rq8.setText("SENTENCIA DE DIVORCIO");
        jPanel1.add(rq8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, 20));

        rq7.setText("FOTOS 5 x 5 - BENEFICIARIO");
        jPanel1.add(rq7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        rq9.setText("ACTA DE NATURALIZACION");
        jPanel1.add(rq9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        rq6.setText("CERTIFICADO DE TRABAJO");
        jPanel1.add(rq6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 271, -1, -1));

        jPanel1.add(comboNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 67, 110, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NUMERO DE PERSONAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        observaciones.setColumns(20);
        observaciones.setRows(5);
        jScrollPane1.setViewportView(observaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 312, 467, 130));

        jLabel3.setText("OBSERVACIONES:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 312, -1, -1));

        honorarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        honorarios.setForeground(new java.awt.Color(51, 0, 0));
        honorarios.setText("HONORARIOS:2.000 POR PERSONA");
        jPanel1.add(honorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, -1, -1));

        btn_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pagar.png"))); // NOI18N
        btn_pago.setText("PAGO");
        jPanel1.add(btn_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_pantalla.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JButton btn_pago;
    public javax.swing.JComboBox<String> comboNum;
    public javax.swing.JLabel honorarios;
    private javax.swing.JCheckBox jCheckBox10;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea observaciones;
    public javax.swing.JCheckBox rq1;
    public javax.swing.JCheckBox rq2;
    public javax.swing.JCheckBox rq3;
    public javax.swing.JCheckBox rq4;
    public javax.swing.JCheckBox rq5;
    public javax.swing.JCheckBox rq6;
    public javax.swing.JCheckBox rq7;
    public javax.swing.JCheckBox rq8;
    public javax.swing.JCheckBox rq9;
    // End of variables declaration//GEN-END:variables
}
