/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class V_Pago extends javax.swing.JInternalFrame {

    /**
     * Creates new form Modificar_Consulta
     */
    public static String x;

    public V_Pago() {
        initComponents();
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public JButton getBtn_abono() {
        return btn_abono;
    }

    public void setBtn_abono(JButton btn_abono) {
        this.btn_abono = btn_abono;
    }

    public JButton getBtn_cargar() {
        return btn_cargar;
    }

    public void setBtn_cargar(JButton btn_cargar) {
        this.btn_cargar = btn_cargar;
    }

    public JButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public JDateChooser getCalendar() {
        return calendar;
    }

    public void setCalendar(JDateChooser calendar) {
        this.calendar = calendar;
    }

    public JDialog getjDialog1() {
        return jDialog1;
    }

    public void setjDialog1(JDialog jDialog1) {
        this.jDialog1 = jDialog1;
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

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getTable_pago() {
        return table_pago;
    }

    public void setTable_pago(JTable table_pago) {
        this.table_pago = table_pago;
    }

    public JTextField getTxt_a_pagar() {
        return txt_a_pagar;
    }

    public void setTxt_a_pagar(JTextField txt_a_pagar) {
        this.txt_a_pagar = txt_a_pagar;
    }

    public JTextField getTxt_abona() {
        return txt_abona;
    }

    public void setTxt_abona(JTextField txt_abona) {
        this.txt_abona = txt_abona;
    }

    public JTextField getTxt_valorInicial() {
        return txt_valorInicial;
    }

    public void setTxt_valorInicial(JTextField txt_valorInicial) {
        this.txt_valorInicial = txt_valorInicial;
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

    public JButton getBtn_imprimir() {
        return btn_imprimir;
    }

    public void setBtn_imprimir(JButton btn_imprimir) {
        this.btn_imprimir = btn_imprimir;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_pago = new javax.swing.JTable();
        btn_abono = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_abona = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JDateChooser();
        btn_guardar = new javax.swing.JButton();
        txt_valorInicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        btn_cargar = new javax.swing.JButton();
        txt_a_pagar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_imprimir = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad:");

        setClosable(true);
        setIconifiable(true);
        setTitle("PAGO");
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(176, 131, 87));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_pago.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        table_pago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table_pago);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 460, 204));

        btn_abono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pagar.png"))); // NOI18N
        btn_abono.setText("ABONO");
        jPanel1.add(btn_abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cedula:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 20));

        txt_abona.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_abona, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 90, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 60, 30));
        jPanel1.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 200, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        txt_valorInicial.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_valorInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 100, 30));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cuota Inicial:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 100, 30));

        txt_id.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 90, -1));

        txt_cedula.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, -1));

        btn_cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/businessapplication_database_database_accepteitheracceptthedatabase_connect_connectdatabase_negocios_aplicacion_basededato_2310.png"))); // NOI18N
        btn_cargar.setText("CARGAR");
        jPanel1.add(btn_cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 120, 40));

        txt_a_pagar.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel1.add(txt_a_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 100, 30));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Id:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 80, 20));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 20));

        btn_imprimir.setText("IMPRIMIR");
        jPanel1.add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abono;
    private javax.swing.JButton btn_cargar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_pago;
    private javax.swing.JTextField txt_a_pagar;
    private javax.swing.JTextField txt_abona;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_valorInicial;
    // End of variables declaration//GEN-END:variables
}
