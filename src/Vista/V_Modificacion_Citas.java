/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * @author BRYAN_CABRERA
 */
public class V_Modificacion_Citas extends javax.swing.JInternalFrame {

    /**
     * Creates new form V_Modificacion_Citas
     */
    public static String x;

    public V_Modificacion_Citas() {
        initComponents();
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);

        lb_celular.setVisible(false);
    }

    public static JButton getBtnguardar() {
        return btn_guardar;
    }

    public static void setBtnguardar(JButton btnguardar) {
        V_Modificacion_Citas.btn_guardar = btnguardar;
    }

    public static JButton getBtnmodificar() {
        return btn_modificar;
    }

    public static void setBtnmodificar(JButton btnmodificar) {
        V_Modificacion_Citas.btn_modificar = btnmodificar;
    }

    public static JButton getBtnregresar() {
        return btn_regresar;
    }

    public static void setBtnregresar(JButton btnregresar) {
        V_Modificacion_Citas.btn_regresar = btnregresar;
    }

    public static JComboBox<String> getCbcaso() {
        return cb_caso;
    }

    public static void setCbcaso(JComboBox<String> cbcaso) {
        V_Modificacion_Citas.cb_caso = cbcaso;
    }

    public static JLabel getCelular() {
        return celular;
    }

    public static void setCelular(JLabel celular) {
        V_Modificacion_Citas.celular = celular;
    }

    public static JLabel getjLabel1() {
        return jLabel1;
    }

    public static void setjLabel1(JLabel jLabel1) {
        V_Modificacion_Citas.jLabel1 = jLabel1;
    }

    public static JLabel getjLabel2() {
        return jLabel2;
    }

    public static void setjLabel2(JLabel jLabel2) {
        V_Modificacion_Citas.jLabel2 = jLabel2;
    }

    public static JLabel getjLabel3() {
        return jLabel3;
    }

    public static void setjLabel3(JLabel jLabel3) {
        V_Modificacion_Citas.jLabel3 = jLabel3;
    }

    public static JLabel getjLabel4() {
        return jLabel4;
    }

    public static void setjLabel4(JLabel jLabel4) {
        V_Modificacion_Citas.jLabel4 = jLabel4;
    }

    public static JLabel getjLabel5() {
        return jLabel5;
    }

    public static void setjLabel5(JLabel jLabel5) {
        V_Modificacion_Citas.jLabel5 = jLabel5;
    }

    public static JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public static void setjScrollPane1(JScrollPane jScrollPane1) {
        V_Modificacion_Citas.jScrollPane1 = jScrollPane1;
    }

    public static JSpinner getJhora() {
        return js_hora;
    }

    public static void setJhora(JSpinner jhora) {
        V_Modificacion_Citas.js_hora = jhora;
    }

    public static JLabel getLacelular() {
        return lb_celular;
    }

    public static void setLacelular(JLabel lacelular) {
        V_Modificacion_Citas.lb_celular = lacelular;
    }

    public static JTextArea getTxdescripcion() {
        return txa_descripcion;
    }

    public static void setTxdescripcion(JTextArea txdescripcion) {
        V_Modificacion_Citas.txa_descripcion = txdescripcion;
    }

    public static JTextField getTxtcedula() {
        return txt_cedula;
    }

    public static void setTxtcedula(JTextField txtcedula) {
        V_Modificacion_Citas.txt_cedula = txtcedula;
    }

    public static JTextField getTxtcelular() {
        return txt_celular;
    }

    public static void setTxtcelular(JTextField txtcelular) {
        V_Modificacion_Citas.txt_celular = txtcelular;
    }

    public static JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public static void setBtn_cancelar(JButton btn_cancelar) {
        V_Modificacion_Citas.btn_cancelar = btn_cancelar;
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
        txt_celular = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_caso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_descripcion = new javax.swing.JTextArea();
        btn_modificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        js_hora = new javax.swing.JSpinner();
        lb_celular = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        celular = new javax.swing.JLabel();
        btn_regresar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("MODIFICAR CITAS");
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
        jPanel2.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 239, -1));

        jLabel1.setText("Cedula:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 50, 20));

        jLabel2.setText("Celular:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 50, 20));

        jLabel3.setText("Caso:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 40, 20));

        jPanel2.add(cb_caso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 239, -1));

        jLabel4.setText("Descripcion:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        txa_descripcion.setColumns(20);
        txa_descripcion.setLineWrap(true);
        txa_descripcion.setRows(5);
        jScrollPane1.setViewportView(txa_descripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 320, 120));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel2.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 60));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 120, 60));

        jLabel5.setText("Hora:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 40, 20));

        js_hora.setModel(new javax.swing.SpinnerDateModel());
        js_hora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        js_hora.setEditor(new javax.swing.JSpinner.DateEditor(js_hora, "dd/MM/yyyy HH:mm"));
        jPanel2.add(js_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel2.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 17));
        jPanel2.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel2.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 110, -1));

        btn_regresar.setText("REGRESAR");
        jPanel2.add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 110, 60));

        btn_cancelar.setText("CANCELAR CITA");
        jPanel2.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 150, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_guardar;
    public static javax.swing.JButton btn_modificar;
    public static javax.swing.JButton btn_regresar;
    public static javax.swing.JComboBox<String> cb_caso;
    public static javax.swing.JLabel celular;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JSpinner js_hora;
    public static javax.swing.JLabel lb_celular;
    public static javax.swing.JTextArea txa_descripcion;
    public static javax.swing.JTextField txt_cedula;
    public static javax.swing.JTextField txt_celular;
    // End of variables declaration//GEN-END:variables
}