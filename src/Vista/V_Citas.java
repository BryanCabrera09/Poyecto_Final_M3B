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

/**
 *
 * @author Usuario
 */
public class V_Citas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cita
     */
    public static String x;

    public V_Citas() {

        initComponents();

        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
    }

    public JButton getBtn_buscar() {
        return btn_buscar;
    }

    public void setBtn_buscar(JButton btn_buscar) {
        this.btn_buscar = btn_buscar;
    }

    public JButton getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(JButton btn_guardar) {
        this.btn_guardar = btn_guardar;
    }

    public JLabel getCaso() {
        return caso;
    }

    public void setCaso(JLabel caso) {
        this.caso = caso;
    }

    public JComboBox<String> getCb_caso() {
        return cb_caso;
    }

    public void setCb_caso(JComboBox<String> cb_caso) {
        this.cb_caso = cb_caso;
    }

    public JLabel getCedula() {
        return cedula;
    }

    public void setCedula(JLabel cedula) {
        this.cedula = cedula;
    }

    public JLabel getCelular() {
        return celular;
    }

    public void setCelular(JLabel celular) {
        this.celular = celular;
    }

    public JLabel getCeiu() {
        return ceiu;
    }

    public void setCeiu(JLabel ceiu) {
        this.ceiu = ceiu;
    }

    public JLabel getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(JLabel descripcion) {
        this.descripcion = descripcion;
    }

    public JLabel getHora() {
        return hora;
    }

    public void setHora(JLabel hora) {
        this.hora = hora;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JSpinner getJs_hora() {
        return js_hora;
    }

    public void setJs_hora(JSpinner js_hora) {
        this.js_hora = js_hora;
    }

    public JLabel getLb_caso() {
        return lb_caso;
    }

    public void setLb_caso(JLabel lb_caso) {
        this.lb_caso = lb_caso;
    }

    public JLabel getLb_cedula() {
        return lb_cedula;
    }

    public void setLb_cedula(JLabel lb_cedula) {
        this.lb_cedula = lb_cedula;
    }

    public JLabel getLb_celular() {
        return lb_celular;
    }

    public void setLb_celular(JLabel lb_celular) {
        this.lb_celular = lb_celular;
    }

    public JTextArea getTxa_descripcion() {
        return txa_descripcion;
    }

    public void setTxa_descripcion(JTextArea txa_descripcion) {
        this.txa_descripcion = txa_descripcion;
    }

    public JTextField getTxt_cedula() {
        return txt_cedula;
    }

    public void setTxt_cedula(JTextField txt_cedula) {
        this.txt_cedula = txt_cedula;
    }

    public JTextField getTxt_celular() {
        return txt_celular;
    }

    public void setTxt_celular(JTextField txt_celular) {
        this.txt_celular = txt_celular;
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public JTextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(JTextField txt_id) {
        this.txt_id = txt_id;
    }

    public JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public void setBtn_nuevo(JButton btn_nuevo) {
        this.btn_nuevo = btn_nuevo;
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
        ceiu = new javax.swing.JLabel();
        caso = new javax.swing.JLabel();
        cb_caso = new javax.swing.JComboBox<>();
        descripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_descripcion = new javax.swing.JTextArea();
        btn_guardar = new javax.swing.JButton();
        hora = new javax.swing.JLabel();
        js_hora = new javax.swing.JSpinner();
        lb_cedula = new javax.swing.JLabel();
        lb_celular = new javax.swing.JLabel();
        lb_caso = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        cedula = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("CITAS");
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

        jPanel2.setBackground(new java.awt.Color(176, 131, 87));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_celular.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel2.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 239, -1));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CITAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 70, 20));

        ceiu.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        ceiu.setForeground(new java.awt.Color(255, 255, 255));
        ceiu.setText("Celular:");
        jPanel2.add(ceiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 60, 20));

        caso.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        caso.setForeground(new java.awt.Color(255, 255, 255));
        caso.setText("Caso:");
        jPanel2.add(caso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 40, 20));

        cb_caso.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        cb_caso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        jPanel2.add(cb_caso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 239, -1));

        descripcion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        descripcion.setForeground(new java.awt.Color(255, 255, 255));
        descripcion.setText("Descripcion:");
        jPanel2.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        txa_descripcion.setColumns(20);
        txa_descripcion.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txa_descripcion.setLineWrap(true);
        txa_descripcion.setRows(5);
        jScrollPane1.setViewportView(txa_descripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 320, 120));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 130, 50));

        hora.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setText("Hora:");
        jPanel2.add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 40, 20));

        js_hora.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        js_hora.setModel(new javax.swing.SpinnerDateModel());
        js_hora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        js_hora.setEditor(new javax.swing.JSpinner.DateEditor(js_hora, "dd/MM/yyyy HH:mm"));
        jPanel2.add(js_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 160, -1));

        lb_cedula.setBackground(new java.awt.Color(255, 255, 255));
        lb_cedula.setForeground(new java.awt.Color(255, 0, 0));
        lb_cedula.setText("*Campo Obligatorio");
        jPanel2.add(lb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        lb_celular.setBackground(new java.awt.Color(255, 255, 255));
        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel2.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 17));

        lb_caso.setBackground(new java.awt.Color(255, 255, 255));
        lb_caso.setForeground(new java.awt.Color(255, 0, 0));
        lb_caso.setText("*Campo Obligatorio");
        jPanel2.add(lb_caso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        txt_cedula.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel2.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Buscar.png"))); // NOI18N
        btn_buscar.setText("BUSCAR");
        jPanel2.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 120, 50));

        cedula.setForeground(new java.awt.Color(255, 0, 0));
        cedula.setText("*Cedula Erronea");
        jPanel2.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 100, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel2.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 120, -1));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR");
        jPanel2.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 140, 50));

        txt_id.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 140, -1));

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Nuevo.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        jPanel2.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 50));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cedula:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JLabel caso;
    private javax.swing.JComboBox<String> cb_caso;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel ceiu;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner js_hora;
    private javax.swing.JLabel lb_caso;
    private javax.swing.JLabel lb_cedula;
    private javax.swing.JLabel lb_celular;
    private javax.swing.JTextArea txa_descripcion;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
