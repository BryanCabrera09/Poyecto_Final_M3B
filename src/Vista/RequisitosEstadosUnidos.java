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

/**
 *
 * @author Usuario
 */
public class RequisitosEstadosUnidos extends javax.swing.JInternalFrame {
   
    public static String x;

    /**
     * Creates new form RequisitosEstadosUnidos
     */

    public RequisitosEstadosUnidos() {
        initComponents();
        
        setTitle("TRAMITES DE VISA");
        x = "x";
        int a = MenuInicio.escritorio.getWidth() - this.getWidth();
        int b = MenuInicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);

    }

    public static JButton getBtn_guardar() {
        return btn_guardar;
    }

    public static void setBtn_guardar(JButton btn_guardar) {
        RequisitosEstadosUnidos.btn_guardar = btn_guardar;
    }

    public static JButton getBtn_modificar() {
        return btn_modificar;
    }

    public static void setBtn_modificar(JButton btn_modificar) {
        RequisitosEstadosUnidos.btn_modificar = btn_modificar;
    }

    public static JButton getBtn_pago() {
        return btn_pago;
    }

    public static void setBtn_pago(JButton btn_pago) {
        RequisitosEstadosUnidos.btn_pago = btn_pago;
    }

    public static JComboBox<String> getCb_numper() {
        return cb_numper;
    }

    public static void setCb_numper(JComboBox<String> cb_numper) {
        RequisitosEstadosUnidos.cb_numper = cb_numper;
    }

    public static JLabel getHonorarios() {
        return honorarios;
    }

    public static void setHonorarios(JLabel honorarios) {
        RequisitosEstadosUnidos.honorarios = honorarios;
    }

    public static JLabel getjLabel1() {
        return jLabel1;
    }

    public static void setjLabel1(JLabel jLabel1) {
        RequisitosEstadosUnidos.jLabel1 = jLabel1;
    }

    public static JLabel getjLabel2() {
        return jLabel2;
    }

    public static void setjLabel2(JLabel jLabel2) {
        RequisitosEstadosUnidos.jLabel2 = jLabel2;
    }

    public static JLabel getjLabel3() {
        return jLabel3;
    }

    public static void setjLabel3(JLabel jLabel3) {
        RequisitosEstadosUnidos.jLabel3 = jLabel3;
    }

    public static JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public static void setjScrollPane1(JScrollPane jScrollPane1) {
        RequisitosEstadosUnidos.jScrollPane1 = jScrollPane1;
    }

    public static JCheckBox getReq_1() {
        return req_1;
    }

    public static void setReq_1(JCheckBox req_1) {
        RequisitosEstadosUnidos.req_1 = req_1;
    }

    public static JCheckBox getReq_10() {
        return req_10;
    }

    public static void setReq_10(JCheckBox req_10) {
        RequisitosEstadosUnidos.req_10 = req_10;
    }

    public static JCheckBox getReq_11() {
        return req_11;
    }

    public static void setReq_11(JCheckBox req_11) {
        RequisitosEstadosUnidos.req_11 = req_11;
    }

    public static JCheckBox getReq_2() {
        return req_2;
    }

    public static void setReq_2(JCheckBox req_2) {
        RequisitosEstadosUnidos.req_2 = req_2;
    }

    public static JCheckBox getReq_3() {
        return req_3;
    }

    public static void setReq_3(JCheckBox req_3) {
        RequisitosEstadosUnidos.req_3 = req_3;
    }

    public static JCheckBox getReq_4() {
        return req_4;
    }

    public static void setReq_4(JCheckBox req_4) {
        RequisitosEstadosUnidos.req_4 = req_4;
    }

    public static JCheckBox getReq_5() {
        return req_5;
    }

    public static void setReq_5(JCheckBox req_5) {
        RequisitosEstadosUnidos.req_5 = req_5;
    }

    public static JCheckBox getReq_6() {
        return req_6;
    }

    public static void setReq_6(JCheckBox req_6) {
        RequisitosEstadosUnidos.req_6 = req_6;
    }

    public static JCheckBox getReq_7() {
        return req_7;
    }

    public static void setReq_7(JCheckBox req_7) {
        RequisitosEstadosUnidos.req_7 = req_7;
    }

    public static JCheckBox getReq_8() {
        return req_8;
    }

    public static void setReq_8(JCheckBox req_8) {
        RequisitosEstadosUnidos.req_8 = req_8;
    }

    public static JCheckBox getReq_9() {
        return req_9;
    }

    public static void setReq_9(JCheckBox req_9) {
        RequisitosEstadosUnidos.req_9 = req_9;
    }

    public static JTextArea getTxa_observ() {
        return txa_observ;
    }

    public static void setTxa_observ(JTextArea txa_observ) {
        RequisitosEstadosUnidos.txa_observ = txa_observ;
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
        req_1 = new javax.swing.JCheckBox();
        req_2 = new javax.swing.JCheckBox();
        req_4 = new javax.swing.JCheckBox();
        req_6 = new javax.swing.JCheckBox();
        req_3 = new javax.swing.JCheckBox();
        req_11 = new javax.swing.JCheckBox();
        req_5 = new javax.swing.JCheckBox();
        req_8 = new javax.swing.JCheckBox();
        req_10 = new javax.swing.JCheckBox();
        cb_numper = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_observ = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        honorarios = new javax.swing.JLabel();
        req_9 = new javax.swing.JCheckBox();
        req_7 = new javax.swing.JCheckBox();
        btn_modificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_pago = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("VISA ESTADOS UNIDOS");
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
        jLabel1.setText("REQUISITOS VISA EEUU ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        req_1.setText("PASAPORTE");
        jPanel1.add(req_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 110, 30));

        req_2.setText("COPIA DE CEDULA");
        jPanel1.add(req_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 140, 30));

        req_4.setText("PARTIDA DE MATRIMONIO");
        jPanel1.add(req_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 180, 30));

        req_6.setText("FOTOS 5x5 ");
        jPanel1.add(req_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 110, 30));

        req_3.setText("PARTIDAS DE NACIMIENTOS ");
        jPanel1.add(req_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 200, 30));

        req_11.setText("PREDIOS");
        jPanel1.add(req_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 90, 30));

        req_5.setText("DIRECCION DE LOS EEUU");
        jPanel1.add(req_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 180, 30));

        req_8.setText("CERTIFICADOS BANCARIOS");
        jPanel1.add(req_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 190, 30));

        req_10.setText("CERTIFICADO DE ESTUDIO");
        jPanel1.add(req_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 180, 30));

        jPanel1.add(cb_numper, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NUMERO DE BENEFICIARIOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 160, 30));

        txa_observ.setColumns(20);
        txa_observ.setLineWrap(true);
        txa_observ.setRows(5);
        jScrollPane1.setViewportView(txa_observ);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 467, 110));

        jLabel3.setText("OBSERVACIONES:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 110, 20));

        honorarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        honorarios.setForeground(new java.awt.Color(51, 0, 0));
        honorarios.setText("HONORARIOS: 90 POR PERSONA");
        jPanel1.add(honorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 180, 20));

        req_9.setText("CERTIFICADO DE TRABAJO");
        jPanel1.add(req_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 190, 30));

        req_7.setText("MATRICULA DE VEHICULO");
        jPanel1.add(req_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 180, 30));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, 100, 40));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 570, 90, 40));

        btn_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pagar.png"))); // NOI18N
        btn_pago.setText("PAGO");
        jPanel1.add(btn_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_guardar;
    public static javax.swing.JButton btn_modificar;
    public static javax.swing.JButton btn_pago;
    public static javax.swing.JComboBox<String> cb_numper;
    public static javax.swing.JLabel honorarios;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JCheckBox req_1;
    public static javax.swing.JCheckBox req_10;
    public static javax.swing.JCheckBox req_11;
    public static javax.swing.JCheckBox req_2;
    public static javax.swing.JCheckBox req_3;
    public static javax.swing.JCheckBox req_4;
    public static javax.swing.JCheckBox req_5;
    public static javax.swing.JCheckBox req_6;
    public static javax.swing.JCheckBox req_7;
    public static javax.swing.JCheckBox req_8;
    public static javax.swing.JCheckBox req_9;
    public static javax.swing.JTextArea txa_observ;
    // End of variables declaration//GEN-END:variables
}
