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
 * @author BRYAN_CABRERA
 */
public class V_Modificar_Consulta extends javax.swing.JInternalFrame {

    /**
     * Creates new form V_Modificar_Consulta
     */
    public static String x;

    public V_Modificar_Consulta() {
        initComponents();
        x = "x";
        int a = V_Menu_Inicio.escritorio.getWidth() - this.getWidth();
        int b = V_Menu_Inicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);

        lb_nombre.setVisible(false);
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
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

    public JButton getBtn_regresar() {
        return btn_regresar;
    }

    public void setBtn_regresar(JButton btn_regresar) {
        this.btn_regresar = btn_regresar;
    }

    public JComboBox<String> getCb_caso() {
        return cb_caso;
    }

    public void setCb_caso(JComboBox<String> cb_caso) {
        this.cb_caso = cb_caso;
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

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
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

    public JLabel getLb_nombre() {
        return lb_nombre;
    }

    public void setLb_nombre(JLabel lb_nombre) {
        this.lb_nombre = lb_nombre;
    }

    public JTextArea getTxa_descripcion() {
        return txa_descripcion;
    }

    public void setTxa_descripcion(JTextArea txa_descripcion) {
        this.txa_descripcion = txa_descripcion;
    }

    public JTextField getTxt_apellidos() {
        return txt_apellidos;
    }

    public void setTxt_apellidos(JTextField txt_apellidos) {
        this.txt_apellidos = txt_apellidos;
    }

    public JTextField getTxt_nombres() {
        return txt_nombres;
    }

    public void setTxt_nombres(JTextField txt_nombres) {
        this.txt_nombres = txt_nombres;
    }

    public JLabel getCelular() {
        return celular;
    }

    public void setCelular(JLabel celular) {
        this.celular = celular;
    }

    public JLabel getLb_celular() {
        return lb_celular;
    }

    public void setLb_celular(JLabel lb_celular) {
        this.lb_celular = lb_celular;
    }

    public JTextField getTxt_celular() {
        return txt_celular;
    }

    public void setTxt_celular(JTextField txt_celular) {
        this.txt_celular = txt_celular;
    }

    public JLabel getLb_apellido() {
        return lb_apellido;
    }

    public void setLb_apellido(JLabel lb_apellido) {
        this.lb_apellido = lb_apellido;
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

        jPanel2 = new javax.swing.JPanel();
        txt_apellidos = new javax.swing.JTextField();
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
        txt_nombres = new javax.swing.JTextField();
        lb_nombre = new javax.swing.JLabel();
        btn_regresar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        lb_celular = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        celular = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_apellido = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();

        setIconifiable(true);
        setTitle("MODIFICAR CONSULTAS");
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

        jPanel2.setBackground(new java.awt.Color(176, 131, 87));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_apellidos.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel2.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 239, -1));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombres:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 20));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellidos:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, 20));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Caso:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 80, 20));

        cb_caso.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        cb_caso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Casos Judiciales", "Petición Familiar", "Trámites de Visa", "Waiver", "Procesos Migratorios" }));
        jPanel2.add(cb_caso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 239, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripcion:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        txa_descripcion.setColumns(20);
        txa_descripcion.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        txa_descripcion.setLineWrap(true);
        txa_descripcion.setRows(5);
        jScrollPane1.setViewportView(txa_descripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 320, 120));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modificar.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        jPanel2.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 11, 140, 60));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 130, 60));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hora:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 70, 20));

        js_hora.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        js_hora.setModel(new javax.swing.SpinnerDateModel());
        js_hora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        js_hora.setEditor(new javax.swing.JSpinner.DateEditor(js_hora, "dd/MM/yyyy HH:mm"));
        jPanel2.add(js_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        txt_nombres.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel2.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, -1));

        lb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        lb_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lb_nombre.setText("*Campo Obligatorio");
        jPanel2.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 17));

        btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/3643764-back-backward-left-reply-turn_113415.png"))); // NOI18N
        btn_regresar.setText("REGRESAR");
        jPanel2.add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 140, 60));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR CONSULTA");
        jPanel2.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 190, 60));

        lb_celular.setForeground(new java.awt.Color(255, 0, 0));
        lb_celular.setText("*Campo Obligatorio");
        jPanel2.add(lb_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 130, -1));

        txt_celular.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel2.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 240, -1));

        celular.setForeground(new java.awt.Color(255, 0, 0));
        celular.setText("*Telefono Erroneo");
        jPanel2.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 120, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Celular:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 90, 20));

        lb_apellido.setForeground(new java.awt.Color(255, 0, 0));
        lb_apellido.setText("*Campo Obligatorio");
        jPanel2.add(lb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 130, -1));

        txt_id.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jPanel2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JComboBox<String> cb_caso;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner js_hora;
    private javax.swing.JLabel lb_apellido;
    private javax.swing.JLabel lb_celular;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JTextArea txa_descripcion;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}
