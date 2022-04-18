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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * @author BRYAN_CABRERA
 */
public class V_Requisitos_Visa_Europa extends javax.swing.JInternalFrame {

    public static String x;

    public V_Requisitos_Visa_Europa() {
        initComponents();
        setTitle("TRAMITES DE VISA");
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
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

    public JButton getBtn_pago() {
        return btn_pago;
    }

    public void setBtn_pago(JButton btn_pago) {
        this.btn_pago = btn_pago;
    }

    public JComboBox<String> getCb_numpers() {
        return cb_numpers;
    }

    public void setCb_numpers(JComboBox<String> cb_numpers) {
        this.cb_numpers = cb_numpers;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JCheckBox getReq_1() {
        return req_1;
    }

    public void setReq_1(JCheckBox req_1) {
        this.req_1 = req_1;
    }

    public JCheckBox getReq_10() {
        return req_10;
    }

    public void setReq_10(JCheckBox req_10) {
        this.req_10 = req_10;
    }

    public JCheckBox getReq_11() {
        return req_11;
    }

    public void setReq_11(JCheckBox req_11) {
        this.req_11 = req_11;
    }

    public JCheckBox getReq_12() {
        return req_12;
    }

    public void setReq_12(JCheckBox req_12) {
        this.req_12 = req_12;
    }

    public JCheckBox getReq_13() {
        return req_13;
    }

    public void setReq_13(JCheckBox req_13) {
        this.req_13 = req_13;
    }

    public JCheckBox getReq_14() {
        return req_14;
    }

    public void setReq_14(JCheckBox req_14) {
        this.req_14 = req_14;
    }

    public JCheckBox getReq_15() {
        return req_15;
    }

    public void setReq_15(JCheckBox req_15) {
        this.req_15 = req_15;
    }

    public JCheckBox getReq_16() {
        return req_16;
    }

    public void setReq_16(JCheckBox req_16) {
        this.req_16 = req_16;
    }

    public JCheckBox getReq_17() {
        return req_17;
    }

    public void setReq_17(JCheckBox req_17) {
        this.req_17 = req_17;
    }

    public JCheckBox getReq_2() {
        return req_2;
    }

    public void setReq_2(JCheckBox req_2) {
        this.req_2 = req_2;
    }

    public JCheckBox getReq_3() {
        return req_3;
    }

    public void setReq_3(JCheckBox req_3) {
        this.req_3 = req_3;
    }

    public JCheckBox getReq_4() {
        return req_4;
    }

    public void setReq_4(JCheckBox req_4) {
        this.req_4 = req_4;
    }

    public JCheckBox getReq_5() {
        return req_5;
    }

    public void setReq_5(JCheckBox req_5) {
        this.req_5 = req_5;
    }

    public JCheckBox getReq_6() {
        return req_6;
    }

    public void setReq_6(JCheckBox req_6) {
        this.req_6 = req_6;
    }

    public JCheckBox getReq_7() {
        return req_7;
    }

    public void setReq_7(JCheckBox req_7) {
        this.req_7 = req_7;
    }

    public JCheckBox getReq_8() {
        return req_8;
    }

    public void setReq_8(JCheckBox req_8) {
        this.req_8 = req_8;
    }

    public JCheckBox getReq_9() {
        return req_9;
    }

    public void setReq_9(JCheckBox req_9) {
        this.req_9 = req_9;
    }

    public JTextArea getTxa_observ() {
        return txa_observ;
    }

    public void setTxa_observ(JTextArea txa_observ) {
        this.txa_observ = txa_observ;
    }

    public JButton getBtn_cargar() {
        return btn_cargar;
    }

    public void setBtn_cargar(JButton btn_cargar) {
        this.btn_cargar = btn_cargar;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        req_3 = new javax.swing.JCheckBox();
        req_11 = new javax.swing.JCheckBox();
        req_1 = new javax.swing.JCheckBox();
        req_8 = new javax.swing.JCheckBox();
        req_5 = new javax.swing.JCheckBox();
        req_2 = new javax.swing.JCheckBox();
        req_10 = new javax.swing.JCheckBox();
        req_6 = new javax.swing.JCheckBox();
        req_4 = new javax.swing.JCheckBox();
        req_9 = new javax.swing.JCheckBox();
        req_14 = new javax.swing.JCheckBox();
        req_15 = new javax.swing.JCheckBox();
        req_16 = new javax.swing.JCheckBox();
        req_13 = new javax.swing.JCheckBox();
        req_12 = new javax.swing.JCheckBox();
        req_7 = new javax.swing.JCheckBox();
        req_17 = new javax.swing.JCheckBox();
        cb_numpers = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_observ = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_pago = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        btn_cargar = new javax.swing.JButton();
        txt_cedula = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("VISA EUROPA");
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

        jPanel1.setBackground(new java.awt.Color(176, 131, 87));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REQUISITOS VISA A EUROPA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 370, 40));

        req_3.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_3.setText("ESCRITURAS ORIGINALES");
        jPanel1.add(req_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 180, 30));

        req_11.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_11.setText("PASAPORTE");
        jPanel1.add(req_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 110, 30));

        req_1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_1.setText("PARTIDA DE MATRIMONIO");
        jPanel1.add(req_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 180, 30));

        req_8.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_8.setText("DIRECCION EN EUROPA");
        jPanel1.add(req_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 170, 30));

        req_5.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_5.setText("LIBRETA DE AHORRO");
        jPanel1.add(req_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 150, 30));

        req_2.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_2.setText("CERTIFICADO BANCARIO");
        jPanel1.add(req_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 170, 30));

        req_10.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_10.setText("COPIA DE CEDULA");
        jPanel1.add(req_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 140, 30));

        req_6.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_6.setText("ESTADOS DE CUENTA");
        jPanel1.add(req_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 160, 30));

        req_4.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_4.setText("PAGO DE SEGURO");
        jPanel1.add(req_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 140, 30));

        req_9.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_9.setText("2 FOTOS 5x5");
        jPanel1.add(req_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 110, 30));

        req_14.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_14.setText("RUC Y DECLARACIONES");
        jPanel1.add(req_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 170, 30));

        req_15.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_15.setText("CERTIFICADO DE TRABAJO");
        jPanel1.add(req_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 190, 30));

        req_16.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_16.setText("PAGO DE PREDIO");
        jPanel1.add(req_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 130, 30));

        req_13.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_13.setText("IMPUESTO A LA RENTA");
        jPanel1.add(req_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 170, 30));

        req_12.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_12.setText("MATRICULAS VEHICULO");
        jPanel1.add(req_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 170, 30));

        req_7.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_7.setText("SEGURO DE VIAJE");
        jPanel1.add(req_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 140, 30));

        req_17.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        req_17.setText("COPIA DE TITULO");
        jPanel1.add(req_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 140, 30));

        cb_numpers.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(cb_numpers, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 90, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NUMERO DE PERSONAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 170, 30));

        txa_observ.setColumns(20);
        txa_observ.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txa_observ.setLineWrap(true);
        txa_observ.setRows(5);
        jScrollPane2.setViewportView(txa_observ);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 590, 110));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jLabel3.setText("HONORARIO: 120 POR PERSONA ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 230, 20));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("OBSERVACIONES:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 140, 20));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, -1, 40));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 130, 40));

        btn_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pagar.png"))); // NOI18N
        btn_pago.setText("PAGO");
        jPanel1.add(btn_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 100, 40));

        txt_id.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 90, 30));

        btn_cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/businessapplication_database_database_accepteitheracceptthedatabase_connect_connectdatabase_negocios_aplicacion_basededato_2310.png"))); // NOI18N
        btn_cargar.setText("CARGAR");
        jPanel1.add(btn_cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 40));

        txt_cedula.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_pago;
    private javax.swing.JComboBox<String> cb_numpers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox req_1;
    private javax.swing.JCheckBox req_10;
    private javax.swing.JCheckBox req_11;
    private javax.swing.JCheckBox req_12;
    private javax.swing.JCheckBox req_13;
    private javax.swing.JCheckBox req_14;
    private javax.swing.JCheckBox req_15;
    private javax.swing.JCheckBox req_16;
    private javax.swing.JCheckBox req_17;
    private javax.swing.JCheckBox req_2;
    private javax.swing.JCheckBox req_3;
    private javax.swing.JCheckBox req_4;
    private javax.swing.JCheckBox req_5;
    private javax.swing.JCheckBox req_6;
    private javax.swing.JCheckBox req_7;
    private javax.swing.JCheckBox req_8;
    private javax.swing.JCheckBox req_9;
    private javax.swing.JTextArea txa_observ;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
