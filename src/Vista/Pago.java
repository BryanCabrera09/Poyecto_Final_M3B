/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Pago extends javax.swing.JInternalFrame {

    /**
     * Creates new form Modificar_Consulta
     */
    
    public static String x;
    
    public Pago() {
        initComponents();
        table_pago.getTableHeader().setResizingAllowed(false);
        table_pago.getTableHeader().setReorderingAllowed(false);
        x = "x";
        int a = MenuInicio.escritorio.getWidth() - this.getWidth();
        int b = MenuInicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public static JButton getBtn_abono() {
        return btn_abono;
    }

    public static void setBtn_abono(JButton btn_abono) {
        Pago.btn_abono = btn_abono;
    }

    public static JButton getBtn_guardar() {
        return btn_guardar;
    }

    public static void setBtn_guardar(JButton btn_guardar) {
        Pago.btn_guardar = btn_guardar;
    }

    public static JDateChooser getjDateChooser1() {
        return calendar;
    }

    public static void setjDateChooser1(JDateChooser jDateChooser1) {
        Pago.calendar = jDateChooser1;
    }

    public static JLabel getjLabel1() {
        return jLabel1;
    }

    public static void setjLabel1(JLabel jLabel1) {
        Pago.jLabel1 = jLabel1;
    }

    public static JLabel getjLabel2() {
        return jLabel2;
    }

    public static void setjLabel2(JLabel jLabel2) {
        Pago.jLabel2 = jLabel2;
    }

    public static JLabel getjLabel3() {
        return jLabel3;
    }

    public static void setjLabel3(JLabel jLabel3) {
        Pago.jLabel3 = jLabel3;
    }

    public static JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public static void setjScrollPane2(JScrollPane jScrollPane2) {
        Pago.jScrollPane2 = jScrollPane2;
    }

    public static JTable getTable_Pago() {
        return table_pago;
    }

    public static void setTable_Pago(JTable table_Pago) {
        Pago.table_pago = table_Pago;
    }

    public static JTextField getTxtCantidad() {
        return txt_cantidad;
    }

    public static void setTxtCantidad(JTextField txtCantidad) {
        Pago.txt_cantidad = txtCantidad;
    }

    public static JTextField getTxt_valorInicial() {
        return txt_valorInicial;
    }

    public static void setTxt_valorInicial(JTextField txt_valorInicial) {
        Pago.txt_valorInicial = txt_valorInicial;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_pago = new javax.swing.JTable();
        btn_abono = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JDateChooser();
        btn_guardar = new javax.swing.JButton();
        txt_valorInicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btn_abono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pagar.png"))); // NOI18N
        btn_abono.setText("ABONO");
        jPanel1.add(btn_abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel1.setText("Cantidad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));
        jPanel1.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 80, -1));

        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 30));
        jPanel1.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 200, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));
        jPanel1.add(txt_valorInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 100, 30));

        jLabel3.setText("Cuota Inicial:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 550, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_abono;
    public static javax.swing.JButton btn_guardar;
    public static com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JDialog jDialog1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable table_pago;
    public static javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_valorInicial;
    // End of variables declaration//GEN-END:variables
}
