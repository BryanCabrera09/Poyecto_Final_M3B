/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class Consultas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Consulta
     */
    public static String x;

    public Consultas() {
        
        initComponents();
        x = "x";
        int a = MenuInicio.escritorio.getWidth() - this.getWidth();
        int b = MenuInicio.escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 5);
       
    }

    public static JLabel getApellidos() {
        return apellidos;
    }

    public static void setApellidos(JLabel apellidos) {
        Consultas.apellidos = apellidos;
    }

    public static JButton getBtncancelar() {
        return btn_cancelar;
    }

    public static void setBtncancelar(JButton btncancelar) {
        Consultas.btn_cancelar = btncancelar;
    }

    public static JButton getBtnguardar() {
        return btn_guardar;
    }

    public static void setBtnguardar(JButton btnguardar) {
        Consultas.btn_guardar = btnguardar;
    }

    public static JButton getBtnnuevo() {
        return btn_nuevo;
    }

    public static void setBtnnuevo(JButton btnnuevo) {
        Consultas.btn_nuevo = btnnuevo;
    }

    public static JComboBox<String> getCbcaso() {
        return cb_caso;
    }

    public static void setCbcaso(JComboBox<String> cbcaso) {
        Consultas.cb_caso = cbcaso;
    }

    public static JLabel getjLabel1() {
        return jLabel1;
    }

    public static void setjLabel1(JLabel jLabel1) {
        Consultas.jLabel1 = jLabel1;
    }

    public static JLabel getjLabel2() {
        return jLabel2;
    }

    public static void setjLabel2(JLabel jLabel2) {
        Consultas.jLabel2 = jLabel2;
    }

    public static JLabel getjLabel3() {
        return jLabel3;
    }

    public static void setjLabel3(JLabel jLabel3) {
        Consultas.jLabel3 = jLabel3;
    }

    public static JLabel getjLabel4() {
        return jLabel4;
    }

    public static void setjLabel4(JLabel jLabel4) {
        Consultas.jLabel4 = jLabel4;
    }

    public static JLabel getjLabel5() {
        return jLabel5;
    }

    public static void setjLabel5(JLabel jLabel5) {
        Consultas.jLabel5 = jLabel5;
    }

    public static JPanel getjPanel1() {
        return jPanel1;
    }

    public static void setjPanel1(JPanel jPanel1) {
        Consultas.jPanel1 = jPanel1;
    }

    public static JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public static void setjScrollPane1(JScrollPane jScrollPane1) {
        Consultas.jScrollPane1 = jScrollPane1;
    }

    public static JSpinner getjSpinner1() {
        return js_hora;
    }

    public static void setjSpinner1(JSpinner jSpinner1) {
        Consultas.js_hora = jSpinner1;
    }

    public static JLabel getLacaso1() {
        return lacaso1;
    }

    public static void setLacaso1(JLabel lacaso1) {
        Consultas.lacaso1 = lacaso1;
    }

    public static JLabel getNombres() {
        return nombres;
    }

    public static void setNombres(JLabel nombres) {
        Consultas.nombres = nombres;
    }

    public JTextArea getTxdescripcion() {
        return txa_descripcion;
    }

    public void setTxdescripcion(JTextArea txdescripcion) {
        this.txa_descripcion = txdescripcion;
    }

    public static JTextField getTxtapellidos() {
        return txt_apellidos;
    }

    public static void setTxtapellidos(JTextField txtapellidos) {
        Consultas.txt_apellidos = txtapellidos;
    }

    public static JTextField getTxtnombres() {
        return txt_nombres;
    }

    public static void setTxtnombres(JTextField txtnombres) {
        Consultas.txt_nombres = txtnombres;
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
        btn_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cb_caso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_descripcion = new javax.swing.JTextArea();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        js_hora = new javax.swing.JSpinner();
        nombres = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_apellidos = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        lacaso1 = new javax.swing.JLabel();
        apellidos = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSULTAS");
        setToolTipText("");
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

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btn_cancelar.setText("CANCELAR");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 100, 50));

        jLabel3.setText("Caso:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 40, 20));

        cb_caso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Casos Judiciales", "Petición Familiar", "Trámites de Visa", "Waiver", "Procesos Migratorios" }));
        jPanel1.add(cb_caso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 174, -1));

        jLabel4.setText("Descripcion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, -1));

        txa_descripcion.setColumns(20);
        txa_descripcion.setLineWrap(true);
        txa_descripcion.setRows(5);
        jScrollPane1.setViewportView(txa_descripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 290, 153));

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 50));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 90, 50));

        jLabel5.setText("Hora:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 40, 20));

        js_hora.setModel(new javax.swing.SpinnerDateModel());
        js_hora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        js_hora.setEditor(new javax.swing.JSpinner.DateEditor(js_hora, "dd/MM/yyyy HH:mm"));
        jPanel1.add(js_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        nombres.setForeground(new java.awt.Color(255, 0, 0));
        nombres.setText("*Campo Obligatorio");
        jPanel1.add(nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 130, -1));

        jLabel1.setText("Nombres:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 60, 20));

        jLabel2.setText("Apellidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 60, 20));
        jPanel1.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 170, -1));
        jPanel1.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, -1));

        lacaso1.setForeground(new java.awt.Color(255, 0, 0));
        lacaso1.setText("*Campo Obligatorio");
        jPanel1.add(lacaso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 130, -1));

        apellidos.setForeground(new java.awt.Color(255, 0, 0));
        apellidos.setText("*Campo Obligatorio");
        jPanel1.add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel apellidos;
    public static javax.swing.JButton btn_cancelar;
    public static javax.swing.JButton btn_guardar;
    public static javax.swing.JButton btn_nuevo;
    public static javax.swing.JComboBox<String> cb_caso;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JSpinner js_hora;
    public static javax.swing.JLabel lacaso1;
    public static javax.swing.JLabel nombres;
    public javax.swing.JTextArea txa_descripcion;
    public static javax.swing.JTextField txt_apellidos;
    public static javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}
