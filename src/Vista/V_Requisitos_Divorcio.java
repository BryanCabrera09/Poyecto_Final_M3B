/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Usuario
 */
public class V_Requisitos_Divorcio extends javax.swing.JInternalFrame {

    public static String x;

    /**
     * Creates new form RequisitoDivorcio
     */
    public V_Requisitos_Divorcio() {
        initComponents();
        setTitle("DIVORCIO");
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
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

    public JTextArea getTxa_observ() {
        return txa_observ;
    }

    public void setTxa_observ(JTextArea txa_observ) {
        this.txa_observ = txa_observ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        req_1 = new javax.swing.JCheckBox();
        req_4 = new javax.swing.JCheckBox();
        req_5 = new javax.swing.JCheckBox();
        req_3 = new javax.swing.JCheckBox();
        req_2 = new javax.swing.JCheckBox();
        req_6 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_observ = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        honorarios = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_pago = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("DIVORCIO");
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
        jLabel1.setText("REQUISITOS DIVORCIO ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        req_1.setText("CEDULA Y PAPEL DE VOTACION");
        jPanel2.add(req_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        req_4.setText("CERTIFICADO DE BIENES DENTRO DEL MATRIMONIO");
        jPanel2.add(req_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        req_5.setText("UBICACIONES ");
        jPanel2.add(req_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        req_3.setText("PARTIDAS DE NACIMIENTOS DE HIJOS");
        jPanel2.add(req_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        req_2.setText("PARTIDA DE MATRIMONIO");
        jPanel2.add(req_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        req_6.setText("<html>TESTIGOS- PARTIDA DE NACIMIENTO DE HIJOS<p>CONCEBIDOS FUERA DEL MATRIMONIO<html>");
        jPanel2.add(req_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        txa_observ.setColumns(20);
        txa_observ.setLineWrap(true);
        txa_observ.setRows(5);
        jScrollPane1.setViewportView(txa_observ);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 360, 143));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("OBSERVACIONES:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 100, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 0));
        jLabel4.setText("CONTENCIOSO -500");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 120, 20));

        honorarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        honorarios.setForeground(new java.awt.Color(51, 0, 0));
        honorarios.setText("HONORARIOS: CONSENSUAL - 250  ");
        jPanel2.add(honorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 200, 20));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 90, 40));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel2.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 100, 40));

        btn_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pagar.png"))); // NOI18N
        btn_pago.setText("PAGO");
        jPanel2.add(btn_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_pago;
    private javax.swing.JLabel honorarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox req_1;
    private javax.swing.JCheckBox req_2;
    private javax.swing.JCheckBox req_3;
    private javax.swing.JCheckBox req_4;
    private javax.swing.JCheckBox req_5;
    private javax.swing.JCheckBox req_6;
    private javax.swing.JTextArea txa_observ;
    // End of variables declaration//GEN-END:variables
}
