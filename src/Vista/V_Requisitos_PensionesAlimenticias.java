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
public class V_Requisitos_PensionesAlimenticias extends javax.swing.JInternalFrame {

    public static String x;
    
    /**
     * Creates new form RequisitosPensionesAlimenticias
     */
    public V_Requisitos_PensionesAlimenticias() {
        initComponents();
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public static JButton getBtn_guardar() {
        return btn_guardar;
    }

    public static void setBtn_guardar(JButton btn_guardar) {
        V_Requisitos_PensionesAlimenticias.btn_guardar = btn_guardar;
    }

    public static JButton getBtn_modificar() {
        return btn_modificar;
    }

    public static void setBtn_modificar(JButton btn_modificar) {
        V_Requisitos_PensionesAlimenticias.btn_modificar = btn_modificar;
    }

    public static JButton getBtn_pago() {
        return btn_pago;
    }

    public static void setBtn_pago(JButton btn_pago) {
        V_Requisitos_PensionesAlimenticias.btn_pago = btn_pago;
    }

    public static JLabel getHonorarios() {
        return honorarios;
    }

    public static void setHonorarios(JLabel honorarios) {
        V_Requisitos_PensionesAlimenticias.honorarios = honorarios;
    }

    public static JLabel getjLabel1() {
        return jLabel1;
    }

    public static void setjLabel1(JLabel jLabel1) {
        V_Requisitos_PensionesAlimenticias.jLabel1 = jLabel1;
    }

    public static JLabel getjLabel3() {
        return jLabel3;
    }

    public static void setjLabel3(JLabel jLabel3) {
        V_Requisitos_PensionesAlimenticias.jLabel3 = jLabel3;
    }

    public static JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public static void setjScrollPane1(JScrollPane jScrollPane1) {
        V_Requisitos_PensionesAlimenticias.jScrollPane1 = jScrollPane1;
    }

    public static JCheckBox getReq_1() {
        return req_1;
    }

    public static void setReq_1(JCheckBox req_1) {
        V_Requisitos_PensionesAlimenticias.req_1 = req_1;
    }

    public static JCheckBox getReq_2() {
        return req_2;
    }

    public static void setReq_2(JCheckBox req_2) {
        V_Requisitos_PensionesAlimenticias.req_2 = req_2;
    }

    public static JCheckBox getReq_3() {
        return req_3;
    }

    public static void setReq_3(JCheckBox req_3) {
        V_Requisitos_PensionesAlimenticias.req_3 = req_3;
    }

    public static JCheckBox getReq_4() {
        return req_4;
    }

    public static void setReq_4(JCheckBox req_4) {
        V_Requisitos_PensionesAlimenticias.req_4 = req_4;
    }

    public static JCheckBox getReq_5() {
        return req_5;
    }

    public static void setReq_5(JCheckBox req_5) {
        V_Requisitos_PensionesAlimenticias.req_5 = req_5;
    }

    public static JCheckBox getReq_6() {
        return req_6;
    }

    public static void setReq_6(JCheckBox req_6) {
        V_Requisitos_PensionesAlimenticias.req_6 = req_6;
    }

    public static JTextArea getTxa_observ() {
        return txa_observ;
    }

    public static void setTxa_observ(JTextArea txa_observ) {
        V_Requisitos_PensionesAlimenticias.txa_observ = txa_observ;
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
        honorarios = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_pago = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("PENSIONES ALIMENTICIAS");
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
        jLabel1.setText("REQUISITOS PENSIONES ALIMENTICIAS ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        req_1.setText("COPIA DE CEDULA");
        jPanel2.add(req_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 140, -1));

        req_4.setText("DIRECCION DEL TRABAJO Y CASA DEL DEMANDADO");
        jPanel2.add(req_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 330, -1));

        req_5.setText("RECIBOS Y FACTURAS DE GASTOS");
        jPanel2.add(req_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 230, -1));

        req_3.setText("PARTIDAS DE NACIMIENTO DEL NIÑO");
        jPanel2.add(req_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 240, -1));

        req_2.setText("COPIA DE PAPEL DE VOTACION");
        jPanel2.add(req_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 210, -1));

        req_6.setText("CERTIFICADO DE CONADIS SI TIENE DISCAPACIDAD");
        jPanel2.add(req_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 320, -1));

        txa_observ.setColumns(20);
        txa_observ.setLineWrap(true);
        txa_observ.setRows(5);
        jScrollPane1.setViewportView(txa_observ);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 330, 143));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("OBSERVACIONES:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 100, 20));

        honorarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        honorarios.setForeground(new java.awt.Color(51, 0, 0));
        honorarios.setText("HONORARIOS:  200  ");
        jPanel2.add(honorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 120, 20));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 90, 40));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel2.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 100, 40));

        btn_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pagar.png"))); // NOI18N
        btn_pago.setText("PAGO");
        jPanel2.add(btn_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    public static javax.swing.JLabel honorarios;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JCheckBox req_1;
    public static javax.swing.JCheckBox req_2;
    public static javax.swing.JCheckBox req_3;
    public static javax.swing.JCheckBox req_4;
    public static javax.swing.JCheckBox req_5;
    public static javax.swing.JCheckBox req_6;
    public static javax.swing.JTextArea txa_observ;
    // End of variables declaration//GEN-END:variables
}