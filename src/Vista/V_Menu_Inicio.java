/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/*
 * @author BRYAN_CABRERA
 */
public class V_Menu_Inicio extends javax.swing.JFrame {

    /**
     * Creates new form MenuInicio
     */
    public V_Menu_Inicio() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("KarYaN");
    }

    public static JMenuItem getCitas() {
        return Citas;
    }

    public static void setCitas(JMenuItem Citas) {
        V_Menu_Inicio.Citas = Citas;
    }

    public static JMenuItem getConsultas() {
        return Consultas;
    }

    public static void setConsultas(JMenuItem Consultas) {
        V_Menu_Inicio.Consultas = Consultas;
    }

    public static JMenu getMAbogado() {
        return MAbogado;
    }

    public static void setMAbogado(JMenu MAbogado) {
        V_Menu_Inicio.MAbogado = MAbogado;
    }

    public static JMenuItem getMCliente() {
        return MCliente;
    }

    public static void setMCliente(JMenuItem MCliente) {
        V_Menu_Inicio.MCliente = MCliente;
    }

    public static JMenuItem getMSecretaria() {
        return MSecretaria;
    }

    public static void setMSecretaria(JMenuItem MSecretaria) {
        V_Menu_Inicio.MSecretaria = MSecretaria;
    }

    public static JMenuItem getMabogado() {
        return Mabogado;
    }

    public static void setMabogado(JMenuItem Mabogado) {
        V_Menu_Inicio.Mabogado = Mabogado;
    }

    public static JMenuItem getRAbogado() {
        return RAbogado;
    }

    public static void setRAbogado(JMenuItem RAbogado) {
        V_Menu_Inicio.RAbogado = RAbogado;
    }

    public static JMenuItem getRCliente() {
        return RCliente;
    }

    public static void setRCliente(JMenuItem RCliente) {
        V_Menu_Inicio.RCliente = RCliente;
    }

    public JMenuItem getRD() {
        return RD;
    }

    public void setRD(JMenuItem RD) {
        this.RD = RD;
    }

    public JMenuItem getREeuu() {
        return REeuu;
    }

    public void setREeuu(JMenuItem REeuu) {
        this.REeuu = REeuu;
    }

    public JMenuItem getRLoteriaE() {
        return RLoteriaE;
    }

    public void setRLoteriaE(JMenuItem RLoteriaE) {
        this.RLoteriaE = RLoteriaE;
    }

    public JMenuItem getRMexico() {
        return RMexico;
    }

    public void setRMexico(JMenuItem RMexico) {
        this.RMexico = RMexico;
    }

    public JMenuItem getRPA() {
        return RPA;
    }

    public void setRPA(JMenuItem RPA) {
        this.RPA = RPA;
    }

    public JMenuItem getRPasaporte() {
        return RPasaporte;
    }

    public void setRPasaporte(JMenuItem RPasaporte) {
        this.RPasaporte = RPasaporte;
    }

    public JMenuItem getRPerdon1() {
        return RPerdon1;
    }

    public void setRPerdon1(JMenuItem RPerdon1) {
        this.RPerdon1 = RPerdon1;
    }

    public JMenuItem getRReporte() {
        return RReporte;
    }

    public void setRReporte(JMenuItem RReporte) {
        this.RReporte = RReporte;
    }

    public JMenuItem getRRetornante() {
        return RRetornante;
    }

    public void setRRetornante(JMenuItem RRetornante) {
        this.RRetornante = RRetornante;
    }

    public static JMenuItem getRSecretaria() {
        return RSecretaria;
    }

    public static void setRSecretaria(JMenuItem RSecretaria) {
        V_Menu_Inicio.RSecretaria = RSecretaria;
    }

    public static JMenuItem getRUsuario() {
        return RUsuario;
    }

    public static void setRUsuario(JMenuItem RUsuario) {
        V_Menu_Inicio.RUsuario = RUsuario;
    }

    public JMenuItem getRVEuropa() {
        return RVEuropa;
    }

    public void setRVEuropa(JMenuItem RVEuropa) {
        this.RVEuropa = RVEuropa;
    }

    public static JMenu getRegistro() {
        return Registro;
    }

    public static void setRegistro(JMenu Registro) {
        V_Menu_Inicio.Registro = Registro;
    }

    public static JMenu getRequisit() {
        return Requisit;
    }

    public static void setRequisit(JMenu Requisit) {
        V_Menu_Inicio.Requisit = Requisit;
    }

    public static JButton getBtnCitas() {
        return btn_citas;
    }

    public static void setBtnCitas(JButton btnCitas) {
        V_Menu_Inicio.btn_citas = btnCitas;
    }

    public static JButton getBtnHorario() {
        return btn_horario;
    }

    public static void setBtnHorario(JButton btnHorario) {
        V_Menu_Inicio.btn_horario = btnHorario;
    }

    public static JButton getBtnInicio() {
        return btn_Inicio;
    }

    public static void setBtnInicio(JButton btnInicio) {
        V_Menu_Inicio.btn_Inicio = btnInicio;
    }

    public static JButton getBtnRegistroClienteCaso() {
        return btn_RegistroClienteCaso;
    }

    public static void setBtnRegistroClienteCaso(JButton btnRegistroClienteCaso) {
        V_Menu_Inicio.btn_RegistroClienteCaso = btnRegistroClienteCaso;
    }

    public static JButton getBtnVisualizacion() {
        return btn_visualizacion;
    }

    public static void setBtnVisualizacion(JButton btnVisualizacion) {
        V_Menu_Inicio.btn_visualizacion = btnVisualizacion;
    }

    public static JButton getBtnVisualizarCaso() {
        return btn_VisualizarCaso;
    }

    public static void setBtnVisualizarCaso(JButton btnVisualizarCaso) {
        V_Menu_Inicio.btn_VisualizarCaso = btnVisualizarCaso;
    }

    public static JMenu getCasosJudiciales() {
        return casosJudiciales;
    }

    public static void setCasosJudiciales(JMenu casosJudiciales) {
        V_Menu_Inicio.casosJudiciales = casosJudiciales;
    }

    public static JMenu getCitasConsultas() {
        return citasConsultas;
    }

    public static void setCitasConsultas(JMenu citasConsultas) {
        V_Menu_Inicio.citasConsultas = citasConsultas;
    }

    public static JDesktopPane getEscritorio() {
        return escritorio;
    }

    public static void setEscritorio(JDesktopPane escritorio) {
        V_Menu_Inicio.escritorio = escritorio;
    }

    public static JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public static void setjMenuBar1(JMenuBar jMenuBar1) {
        V_Menu_Inicio.jMenuBar1 = jMenuBar1;
    }

    public static JPanel getjPanel1() {
        return jPanel1;
    }

    public static void setjPanel1(JPanel jPanel1) {
        V_Menu_Inicio.jPanel1 = jPanel1;
    }

    public static JMenu getPeticionFamiliar() {
        return peticionFamiliar;
    }

    public static void setPeticionFamiliar(JMenu peticionFamiliar) {
        V_Menu_Inicio.peticionFamiliar = peticionFamiliar;
    }

    public JMenuItem getPeticionFamily() {
        return peticionFamily;
    }

    public void setPeticionFamily(JMenuItem peticionFamily) {
        this.peticionFamily = peticionFamily;
    }

    public static JMenu getProcesosMigratorios() {
        return procesosMigratorios;
    }

    public static void setProcesosMigratorios(JMenu procesosMigratorios) {
        V_Menu_Inicio.procesosMigratorios = procesosMigratorios;
    }

    public static JMenu getTramitesVisa() {
        return tramitesVisa;
    }

    public static void setTramitesVisa(JMenu tramitesVisa) {
        V_Menu_Inicio.tramitesVisa = tramitesVisa;
    }

    public static JMenu getWaiver() {
        return waiver;
    }

    public static void setWaiver(JMenu waiver) {
        V_Menu_Inicio.waiver = waiver;
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
        btn_horario = new javax.swing.JButton();
        btn_citas = new javax.swing.JButton();
        btn_visualizacion = new javax.swing.JButton();
        btn_VisualizarCaso = new javax.swing.JButton();
        btn_RegistroClienteCaso = new javax.swing.JButton();
        btn_Inicio = new javax.swing.JButton();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Registro = new javax.swing.JMenu();
        RAbogado = new javax.swing.JMenuItem();
        RSecretaria = new javax.swing.JMenuItem();
        RCliente = new javax.swing.JMenuItem();
        RUsuario = new javax.swing.JMenuItem();
        MAbogado = new javax.swing.JMenu();
        Mabogado = new javax.swing.JMenuItem();
        MSecretaria = new javax.swing.JMenuItem();
        MCliente = new javax.swing.JMenuItem();
        Requisit = new javax.swing.JMenu();
        casosJudiciales = new javax.swing.JMenu();
        RD = new javax.swing.JMenuItem();
        RPA = new javax.swing.JMenuItem();
        tramitesVisa = new javax.swing.JMenu();
        REeuu = new javax.swing.JMenuItem();
        RVEuropa = new javax.swing.JMenuItem();
        RLoteriaE = new javax.swing.JMenuItem();
        RMexico = new javax.swing.JMenuItem();
        waiver = new javax.swing.JMenu();
        RPerdon1 = new javax.swing.JMenuItem();
        peticionFamiliar = new javax.swing.JMenu();
        peticionFamily = new javax.swing.JMenuItem();
        procesosMigratorios = new javax.swing.JMenu();
        RPasaporte = new javax.swing.JMenuItem();
        RRetornante = new javax.swing.JMenuItem();
        RReporte = new javax.swing.JMenuItem();
        citasConsultas = new javax.swing.JMenu();
        Citas = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_horario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Calendario.png"))); // NOI18N
        btn_horario.setToolTipText("Horario");
        jPanel1.add(btn_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 60));

        btn_citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cita.png"))); // NOI18N
        btn_citas.setToolTipText("Cita");
        jPanel1.add(btn_citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 60));

        btn_visualizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consulta.png"))); // NOI18N
        btn_visualizacion.setToolTipText("Consulta");
        jPanel1.add(btn_visualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 80, 60));

        btn_VisualizarCaso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ver Caso.png"))); // NOI18N
        btn_VisualizarCaso.setToolTipText("Ver Caso");
        jPanel1.add(btn_VisualizarCaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 80, 60));

        btn_RegistroClienteCaso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registro Casos.png"))); // NOI18N
        btn_RegistroClienteCaso.setToolTipText("Registro Cliente-Caso");
        jPanel1.add(btn_RegistroClienteCaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 80, 60));

        btn_Inicio.setText("INICIO");
        btn_Inicio.setMaximumSize(new java.awt.Dimension(30, 16));
        btn_Inicio.setMinimumSize(new java.awt.Dimension(30, 16));
        btn_Inicio.setPreferredSize(new java.awt.Dimension(60, 16));
        jPanel1.add(btn_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 90, 60));

        escritorio.setBackground(new java.awt.Color(153, 0, 51));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        Registro.setText("Registro");

        RAbogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        RAbogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Abogada.png"))); // NOI18N
        RAbogado.setText("Abogado");
        Registro.add(RAbogado);

        RSecretaria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        RSecretaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Secretaria.png"))); // NOI18N
        RSecretaria.setText("Secretaria");
        Registro.add(RSecretaria);

        RCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        RCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cliente.png"))); // NOI18N
        RCliente.setText("Cliente");
        Registro.add(RCliente);

        RUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        RUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario.png"))); // NOI18N
        RUsuario.setText("Usuario");
        Registro.add(RUsuario);

        jMenuBar1.add(Registro);

        MAbogado.setText("Modificar");

        Mabogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Mabogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Abogada.png"))); // NOI18N
        Mabogado.setText("Abogado");
        MAbogado.add(Mabogado);

        MSecretaria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MSecretaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Secretaria.png"))); // NOI18N
        MSecretaria.setText("Secretaria");
        MAbogado.add(MSecretaria);

        MCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        MCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cliente.png"))); // NOI18N
        MCliente.setText("Cliente");
        MAbogado.add(MCliente);

        jMenuBar1.add(MAbogado);

        Requisit.setText("Requisitos");

        casosJudiciales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Casos Judiciales.png"))); // NOI18N
        casosJudiciales.setText("Casos Judiciales");

        RD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        RD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Divorcio.png"))); // NOI18N
        RD.setText("Divorcio");
        casosJudiciales.add(RD);

        RPA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        RPA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pensiones Alimenticias.png"))); // NOI18N
        RPA.setText("Pensiones Alimenticias");
        casosJudiciales.add(RPA);

        Requisit.add(casosJudiciales);

        tramitesVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Visa.png"))); // NOI18N
        tramitesVisa.setText("Tramites de Visa");

        REeuu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        REeuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B EEUU.png"))); // NOI18N
        REeuu.setText("EEUU");
        tramitesVisa.add(REeuu);

        RVEuropa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        RVEuropa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B Europa.png"))); // NOI18N
        RVEuropa.setText("Europa");
        tramitesVisa.add(RVEuropa);

        RLoteriaE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        RLoteriaE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B EEUU.png"))); // NOI18N
        RLoteriaE.setText("Loteria-EEUU");
        tramitesVisa.add(RLoteriaE);

        RMexico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        RMexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B Mexico.png"))); // NOI18N
        RMexico.setText("Mexico");
        tramitesVisa.add(RMexico);

        Requisit.add(tramitesVisa);

        waiver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Waiver.png"))); // NOI18N
        waiver.setText("Waiver");

        RPerdon1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.CTRL_MASK));
        RPerdon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Perdon.png"))); // NOI18N
        RPerdon1.setText("Perdon");
        waiver.add(RPerdon1);

        Requisit.add(waiver);

        peticionFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peticion.png"))); // NOI18N
        peticionFamiliar.setText("Peticion Familiar");

        peticionFamily.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.CTRL_MASK));
        peticionFamily.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Familiar.png"))); // NOI18N
        peticionFamily.setText("Peticion Familiar");
        peticionFamiliar.add(peticionFamily);

        Requisit.add(peticionFamiliar);

        procesosMigratorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Procesos migratorios.png"))); // NOI18N
        procesosMigratorios.setText("Procesos Migratorios");

        RPasaporte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.CTRL_MASK));
        RPasaporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Renovacion.png"))); // NOI18N
        RPasaporte.setText("Renovacion Pasaporte EEUU");
        procesosMigratorios.add(RPasaporte);

        RRetornante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        RRetornante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Retornante Inmigrante.png"))); // NOI18N
        RRetornante.setText("Retornante Inmigrante");
        procesosMigratorios.add(RRetornante);

        RReporte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        RReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reporte Consular.png"))); // NOI18N
        RReporte.setText("Reporte Consular");
        procesosMigratorios.add(RReporte);

        Requisit.add(procesosMigratorios);

        jMenuBar1.add(Requisit);

        citasConsultas.setText("Citas_Consutas");

        Citas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        Citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cita 2.png"))); // NOI18N
        Citas.setText("Citas");
        citasConsultas.add(Citas);

        Consultas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        Consultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consulta 2.png"))); // NOI18N
        Consultas.setText("Consultas");
        citasConsultas.add(Consultas);

        jMenuBar1.add(citasConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1318, Short.MAX_VALUE)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(V_Menu_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(V_Menu_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(V_Menu_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(V_Menu_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_Menu_Inicio().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem Citas;
    public static javax.swing.JMenuItem Consultas;
    public static javax.swing.JMenu MAbogado;
    public static javax.swing.JMenuItem MCliente;
    public static javax.swing.JMenuItem MSecretaria;
    public static javax.swing.JMenuItem Mabogado;
    public static javax.swing.JMenuItem RAbogado;
    public static javax.swing.JMenuItem RCliente;
    public javax.swing.JMenuItem RD;
    public javax.swing.JMenuItem REeuu;
    public javax.swing.JMenuItem RLoteriaE;
    public javax.swing.JMenuItem RMexico;
    public javax.swing.JMenuItem RPA;
    public javax.swing.JMenuItem RPasaporte;
    public javax.swing.JMenuItem RPerdon1;
    public javax.swing.JMenuItem RReporte;
    public javax.swing.JMenuItem RRetornante;
    public static javax.swing.JMenuItem RSecretaria;
    public static javax.swing.JMenuItem RUsuario;
    public javax.swing.JMenuItem RVEuropa;
    public static javax.swing.JMenu Registro;
    public static javax.swing.JMenu Requisit;
    public static javax.swing.JButton btn_Inicio;
    public static javax.swing.JButton btn_RegistroClienteCaso;
    public static javax.swing.JButton btn_VisualizarCaso;
    public static javax.swing.JButton btn_citas;
    public static javax.swing.JButton btn_horario;
    public static javax.swing.JButton btn_visualizacion;
    public static javax.swing.JMenu casosJudiciales;
    public static javax.swing.JMenu citasConsultas;
    public static javax.swing.JDesktopPane escritorio;
    public static javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JMenu peticionFamiliar;
    public javax.swing.JMenuItem peticionFamily;
    public static javax.swing.JMenu procesosMigratorios;
    public static javax.swing.JMenu tramitesVisa;
    public static javax.swing.JMenu waiver;
    // End of variables declaration//GEN-END:variables
}
