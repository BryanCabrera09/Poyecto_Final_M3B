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
public class V_Requisitos_Visa_Loteria extends javax.swing.JInternalFrame {

    public static String x;

    public V_Requisitos_Visa_Loteria() {
        initComponents();
        x = "x";
        setTitle("TRAMITES DE VISAS");
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

    public JComboBox<String> getCb_numper() {
        return cb_numper;
    }

    public void setCb_numper(JComboBox<String> cb_numper) {
        this.cb_numper = cb_numper;
    }

    public JLabel getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(JLabel honorarios) {
        this.honorarios = honorarios;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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
        req_2 = new javax.swing.JCheckBox();
        req_1 = new javax.swing.JCheckBox();
        req_4 = new javax.swing.JCheckBox();
        req_3 = new javax.swing.JCheckBox();
        req_5 = new javax.swing.JCheckBox();
        req_8 = new javax.swing.JCheckBox();
        req_7 = new javax.swing.JCheckBox();
        req_9 = new javax.swing.JCheckBox();
        req_6 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_numper = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_observ = new javax.swing.JTextArea();
        honorarios = new javax.swing.JLabel();
        btn_pago = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        btn_cargar = new javax.swing.JButton();
        txt_cedula = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

        req_2.setText("PARTIDA DE NACIMIENTOS");
        jPanel1.add(req_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 180, 30));

        req_1.setText("PASAPORTE");
        jPanel1.add(req_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 110, 30));

        req_4.setText("DATOS DE ESTUDIOS");
        jPanel1.add(req_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 160, 30));

        req_3.setText("PARTIDA DE MATRIMONIO");
        jPanel1.add(req_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 180, 30));

        req_5.setText("DATOS DE PADRES");
        jPanel1.add(req_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 140, 30));

        req_8.setText("FOTO DIGITAL 5x5");
        jPanel1.add(req_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 140, 30));

        req_7.setText("DIRECCION DE LOS EEUU");
        jPanel1.add(req_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 180, 30));

        req_9.setText("DATOS DE TRABAJO");
        jPanel1.add(req_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 150, 30));

        req_6.setText("DATOS DE HERMANOS");
        jPanel1.add(req_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 160, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("REQUISITOS VISA DE LOTERIA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 390, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("NUMERO DE PERSONAS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, 30));

        jPanel1.add(cb_numper, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("OBSERVACIONES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 100, 20));

        txa_observ.setColumns(20);
        txa_observ.setLineWrap(true);
        txa_observ.setRows(5);
        jScrollPane2.setViewportView(txa_observ);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 520, 100));

        honorarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        honorarios.setForeground(new java.awt.Color(51, 0, 0));
        honorarios.setText("HONORARIOS: 40 POR PERSONA");
        jPanel1.add(honorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 180, 20));

        btn_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pagar.png"))); // NOI18N
        btn_pago.setText("PAGO");
        jPanel1.add(btn_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 70, 40));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 100, 40));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 90, 40));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 90, 30));

        btn_cargar.setText("CARGAR");
        jPanel1.add(btn_cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
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
    private javax.swing.JComboBox<String> cb_numper;
    private javax.swing.JLabel honorarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox req_1;
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
