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

    public static JMenuItem getMod_abogado() {
        return Mod_abogado;
    }

    public static void setMod_abogado(JMenuItem Mod_abogado) {
        V_Menu_Inicio.Mod_abogado = Mod_abogado;
    }

    public static JMenuItem getMod_cliente() {
        return Mod_cliente;
    }

    public static void setMod_cliente(JMenuItem Mod_cliente) {
        V_Menu_Inicio.Mod_cliente = Mod_cliente;
    }

    public static JMenuItem getMod_secretaria() {
        return Mod_secretaria;
    }

    public static void setMod_secretaria(JMenuItem Mod_secretaria) {
        V_Menu_Inicio.Mod_secretaria = Mod_secretaria;
    }

    public static JMenu getModifcar() {
        return Modifcar;
    }

    public static void setModifcar(JMenu Modifcar) {
        V_Menu_Inicio.Modifcar = Modifcar;
    }

    public static JMenuItem getReg_abogado() {
        return Reg_abogado;
    }

    public static void setReg_abogado(JMenuItem Reg_abogado) {
        V_Menu_Inicio.Reg_abogado = Reg_abogado;
    }

    public static JMenuItem getReg_cliente() {
        return Reg_cliente;
    }

    public static void setReg_cliente(JMenuItem Reg_cliente) {
        V_Menu_Inicio.Reg_cliente = Reg_cliente;
    }

    public static JMenuItem getReg_secretaria() {
        return Reg_secretaria;
    }

    public static void setReg_secretaria(JMenuItem Reg_secretaria) {
        V_Menu_Inicio.Reg_secretaria = Reg_secretaria;
    }

    public static JMenuItem getReg_usuario() {
        return Reg_usuario;
    }

    public static void setReg_usuario(JMenuItem Reg_usuario) {
        V_Menu_Inicio.Reg_usuario = Reg_usuario;
    }

    public static JMenu getRegistro() {
        return Registro;
    }

    public static void setRegistro(JMenu Registro) {
        V_Menu_Inicio.Registro = Registro;
    }

    public JMenuItem getReq_Perdon() {
        return Req_Perdon;
    }

    public void setReq_Perdon(JMenuItem Req_Perdon) {
        this.Req_Perdon = Req_Perdon;
    }

    public JMenuItem getReq_Renovacion_Pasaporte() {
        return Req_Renovacion_Pasaporte;
    }

    public void setReq_Renovacion_Pasaporte(JMenuItem Req_Renovacion_Pasaporte) {
        this.Req_Renovacion_Pasaporte = Req_Renovacion_Pasaporte;
    }

    public JMenuItem getReq_Reporte_Consular() {
        return Req_Reporte_Consular;
    }

    public void setReq_Reporte_Consular(JMenuItem Req_Reporte_Consular) {
        this.Req_Reporte_Consular = Req_Reporte_Consular;
    }

    public JMenuItem getReq_RetornanteInmigrante() {
        return Req_RetornanteInmigrante;
    }

    public void setReq_RetornanteInmigrante(JMenuItem Req_RetornanteInmigrante) {
        this.Req_RetornanteInmigrante = Req_RetornanteInmigrante;
    }

    public JMenuItem getReq_Visa_Eeuu() {
        return Req_Visa_Eeuu;
    }

    public void setReq_Visa_Eeuu(JMenuItem Req_Visa_Eeuu) {
        this.Req_Visa_Eeuu = Req_Visa_Eeuu;
    }

    public JMenuItem getReq_divorcio() {
        return Req_divorcio;
    }

    public void setReq_divorcio(JMenuItem Req_divorcio) {
        this.Req_divorcio = Req_divorcio;
    }

    public JMenuItem getReq_pensionesali() {
        return Req_pensionesali;
    }

    public void setReq_pensionesali(JMenuItem Req_pensionesali) {
        this.Req_pensionesali = Req_pensionesali;
    }

    public JMenuItem getReq_peticionfamiliar() {
        return Req_peticionfamiliar;
    }

    public void setReq_peticionfamiliar(JMenuItem Req_peticionfamiliar) {
        this.Req_peticionfamiliar = Req_peticionfamiliar;
    }

    public JMenuItem getReq_visa_europa() {
        return Req_visa_europa;
    }

    public void setReq_visa_europa(JMenuItem Req_visa_europa) {
        this.Req_visa_europa = Req_visa_europa;
    }

    public JMenuItem getReq_visa_loteria() {
        return Req_visa_loteria;
    }

    public void setReq_visa_loteria(JMenuItem Req_visa_loteria) {
        this.Req_visa_loteria = Req_visa_loteria;
    }

    public JMenuItem getReq_visa_mexico() {
        return Req_visa_mexico;
    }

    public void setReq_visa_mexico(JMenuItem Req_visa_mexico) {
        this.Req_visa_mexico = Req_visa_mexico;
    }

    public static JMenu getRequisit() {
        return Requisit;
    }

    public static void setRequisit(JMenu Requisit) {
        V_Menu_Inicio.Requisit = Requisit;
    }

    public static JButton getBtn_Inicio() {
        return btn_Inicio;
    }

    public static void setBtn_Inicio(JButton btn_Inicio) {
        V_Menu_Inicio.btn_Inicio = btn_Inicio;
    }

    public static JButton getBtn_RegistroClienteCaso() {
        return btn_RegistroClienteCaso;
    }

    public static void setBtn_RegistroClienteCaso(JButton btn_RegistroClienteCaso) {
        V_Menu_Inicio.btn_RegistroClienteCaso = btn_RegistroClienteCaso;
    }

    public static JButton getBtn_VisualizarCaso() {
        return btn_VisualizarCaso;
    }

    public static void setBtn_VisualizarCaso(JButton btn_VisualizarCaso) {
        V_Menu_Inicio.btn_VisualizarCaso = btn_VisualizarCaso;
    }

    public static JButton getBtn_citas() {
        return btn_citas;
    }

    public static void setBtn_citas(JButton btn_citas) {
        V_Menu_Inicio.btn_citas = btn_citas;
    }

    public static JButton getBtn_horario() {
        return btn_horario;
    }

    public static void setBtn_horario(JButton btn_horario) {
        V_Menu_Inicio.btn_horario = btn_horario;
    }

    public static JButton getBtn_visualizacion() {
        return btn_visualizacion;
    }

    public static void setBtn_visualizacion(JButton btn_visualizacion) {
        V_Menu_Inicio.btn_visualizacion = btn_visualizacion;
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
        Reg_abogado = new javax.swing.JMenuItem();
        Reg_secretaria = new javax.swing.JMenuItem();
        Reg_cliente = new javax.swing.JMenuItem();
        Reg_usuario = new javax.swing.JMenuItem();
        Modifcar = new javax.swing.JMenu();
        Mod_abogado = new javax.swing.JMenuItem();
        Mod_secretaria = new javax.swing.JMenuItem();
        Mod_cliente = new javax.swing.JMenuItem();
        Requisit = new javax.swing.JMenu();
        casosJudiciales = new javax.swing.JMenu();
        Req_divorcio = new javax.swing.JMenuItem();
        Req_pensionesali = new javax.swing.JMenuItem();
        tramitesVisa = new javax.swing.JMenu();
        Req_Visa_Eeuu = new javax.swing.JMenuItem();
        Req_visa_europa = new javax.swing.JMenuItem();
        Req_visa_loteria = new javax.swing.JMenuItem();
        Req_visa_mexico = new javax.swing.JMenuItem();
        waiver = new javax.swing.JMenu();
        Req_Perdon = new javax.swing.JMenuItem();
        peticionFamiliar = new javax.swing.JMenu();
        Req_peticionfamiliar = new javax.swing.JMenuItem();
        procesosMigratorios = new javax.swing.JMenu();
        Req_Renovacion_Pasaporte = new javax.swing.JMenuItem();
        Req_RetornanteInmigrante = new javax.swing.JMenuItem();
        Req_Reporte_Consular = new javax.swing.JMenuItem();
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

        Reg_abogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Reg_abogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Abogada.png"))); // NOI18N
        Reg_abogado.setText("Abogado");
        Registro.add(Reg_abogado);

        Reg_secretaria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Reg_secretaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Secretaria.png"))); // NOI18N
        Reg_secretaria.setText("Secretaria");
        Registro.add(Reg_secretaria);

        Reg_cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Reg_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cliente.png"))); // NOI18N
        Reg_cliente.setText("Cliente");
        Registro.add(Reg_cliente);

        Reg_usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        Reg_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario.png"))); // NOI18N
        Reg_usuario.setText("Usuario");
        Registro.add(Reg_usuario);

        jMenuBar1.add(Registro);

        Modifcar.setText("Modificar");

        Mod_abogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Mod_abogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Abogada.png"))); // NOI18N
        Mod_abogado.setText("Abogado");
        Modifcar.add(Mod_abogado);

        Mod_secretaria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Mod_secretaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Secretaria.png"))); // NOI18N
        Mod_secretaria.setText("Secretaria");
        Modifcar.add(Mod_secretaria);

        Mod_cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Mod_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cliente.png"))); // NOI18N
        Mod_cliente.setText("Cliente");
        Modifcar.add(Mod_cliente);

        jMenuBar1.add(Modifcar);

        Requisit.setText("Requisitos");

        casosJudiciales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Casos Judiciales.png"))); // NOI18N
        casosJudiciales.setText("Casos Judiciales");

        Req_divorcio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        Req_divorcio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Divorcio.png"))); // NOI18N
        Req_divorcio.setText("Divorcio");
        casosJudiciales.add(Req_divorcio);

        Req_pensionesali.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        Req_pensionesali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pensiones Alimenticias.png"))); // NOI18N
        Req_pensionesali.setText("Pensiones Alimenticias");
        casosJudiciales.add(Req_pensionesali);

        Requisit.add(casosJudiciales);

        tramitesVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Visa.png"))); // NOI18N
        tramitesVisa.setText("Tramites de Visa");

        Req_Visa_Eeuu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        Req_Visa_Eeuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B EEUU.png"))); // NOI18N
        Req_Visa_Eeuu.setText("EEUU");
        tramitesVisa.add(Req_Visa_Eeuu);

        Req_visa_europa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        Req_visa_europa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B Europa.png"))); // NOI18N
        Req_visa_europa.setText("Europa");
        tramitesVisa.add(Req_visa_europa);

        Req_visa_loteria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        Req_visa_loteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B EEUU.png"))); // NOI18N
        Req_visa_loteria.setText("Loteria-EEUU");
        tramitesVisa.add(Req_visa_loteria);

        Req_visa_mexico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        Req_visa_mexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/B Mexico.png"))); // NOI18N
        Req_visa_mexico.setText("Mexico");
        tramitesVisa.add(Req_visa_mexico);

        Requisit.add(tramitesVisa);

        waiver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Waiver.png"))); // NOI18N
        waiver.setText("Waiver");

        Req_Perdon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.CTRL_MASK));
        Req_Perdon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Perdon.png"))); // NOI18N
        Req_Perdon.setText("Perdon");
        waiver.add(Req_Perdon);

        Requisit.add(waiver);

        peticionFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peticion.png"))); // NOI18N
        peticionFamiliar.setText("Peticion Familiar");

        Req_peticionfamiliar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.CTRL_MASK));
        Req_peticionfamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Familiar.png"))); // NOI18N
        Req_peticionfamiliar.setText("Peticion Familiar");
        peticionFamiliar.add(Req_peticionfamiliar);

        Requisit.add(peticionFamiliar);

        procesosMigratorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Procesos migratorios.png"))); // NOI18N
        procesosMigratorios.setText("Procesos Migratorios");

        Req_Renovacion_Pasaporte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.CTRL_MASK));
        Req_Renovacion_Pasaporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Renovacion.png"))); // NOI18N
        Req_Renovacion_Pasaporte.setText("Renovacion Pasaporte EEUU");
        procesosMigratorios.add(Req_Renovacion_Pasaporte);

        Req_RetornanteInmigrante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        Req_RetornanteInmigrante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Retornante Inmigrante.png"))); // NOI18N
        Req_RetornanteInmigrante.setText("Retornante Inmigrante");
        procesosMigratorios.add(Req_RetornanteInmigrante);

        Req_Reporte_Consular.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        Req_Reporte_Consular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reporte Consular.png"))); // NOI18N
        Req_Reporte_Consular.setText("Reporte Consular");
        procesosMigratorios.add(Req_Reporte_Consular);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem Citas;
    public static javax.swing.JMenuItem Consultas;
    public static javax.swing.JMenuItem Mod_abogado;
    public static javax.swing.JMenuItem Mod_cliente;
    public static javax.swing.JMenuItem Mod_secretaria;
    public static javax.swing.JMenu Modifcar;
    public static javax.swing.JMenuItem Reg_abogado;
    public static javax.swing.JMenuItem Reg_cliente;
    public static javax.swing.JMenuItem Reg_secretaria;
    public static javax.swing.JMenuItem Reg_usuario;
    public static javax.swing.JMenu Registro;
    public javax.swing.JMenuItem Req_Perdon;
    public javax.swing.JMenuItem Req_Renovacion_Pasaporte;
    public javax.swing.JMenuItem Req_Reporte_Consular;
    public javax.swing.JMenuItem Req_RetornanteInmigrante;
    public javax.swing.JMenuItem Req_Visa_Eeuu;
    public javax.swing.JMenuItem Req_divorcio;
    public javax.swing.JMenuItem Req_pensionesali;
    public javax.swing.JMenuItem Req_peticionfamiliar;
    public javax.swing.JMenuItem Req_visa_europa;
    public javax.swing.JMenuItem Req_visa_loteria;
    public javax.swing.JMenuItem Req_visa_mexico;
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
    public static javax.swing.JMenu procesosMigratorios;
    public static javax.swing.JMenu tramitesVisa;
    public static javax.swing.JMenu waiver;
    // End of variables declaration//GEN-END:variables
}
