/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

    }

    public JMenuItem getCitas() {
        return Citas;
    }

    public void setCitas(JMenuItem Citas) {
        this.Citas = Citas;
    }

    public JMenuItem getConsultas() {
        return Consultas;
    }

    public void setConsultas(JMenuItem Consultas) {
        this.Consultas = Consultas;
    }

    public JMenuItem getMod_abogado() {
        return Mod_abogado;
    }

    public void setMod_abogado(JMenuItem Mod_abogado) {
        this.Mod_abogado = Mod_abogado;
    }

    public JMenuItem getMod_cliente() {
        return Mod_cliente;
    }

    public void setMod_cliente(JMenuItem Mod_cliente) {
        this.Mod_cliente = Mod_cliente;
    }

    public JMenuItem getMod_secretaria() {
        return Mod_secretaria;
    }

    public void setMod_secretaria(JMenuItem Mod_secretaria) {
        this.Mod_secretaria = Mod_secretaria;
    }

    public JMenu getModifcar() {
        return Modifcar;
    }

    public void setModifcar(JMenu Modifcar) {
        this.Modifcar = Modifcar;
    }

    public JMenuItem getReg_abogado() {
        return Reg_abogado;
    }

    public void setReg_abogado(JMenuItem Reg_abogado) {
        this.Reg_abogado = Reg_abogado;
    }

    public JMenuItem getReg_cliente() {
        return Reg_cliente;
    }

    public void setReg_cliente(JMenuItem Reg_cliente) {
        this.Reg_cliente = Reg_cliente;
    }

    public JMenuItem getReg_secretaria() {
        return Reg_secretaria;
    }

    public void setReg_secretaria(JMenuItem Reg_secretaria) {
        this.Reg_secretaria = Reg_secretaria;
    }

    public JMenuItem getReg_usuario() {
        return Reg_usuario;
    }

    public void setReg_usuario(JMenuItem Reg_usuario) {
        this.Reg_usuario = Reg_usuario;
    }

    public JMenu getRegistro() {
        return Registro;
    }

    public void setRegistro(JMenu Registro) {
        this.Registro = Registro;
    }

    public JMenu getRequisit() {
        return Requisitos;
    }

    public void setRequisit(JMenu Requisit) {
        this.Requisitos = Requisit;
    }

    public JButton getBtn_Inicio() {
        return btn_Inicio;
    }

    public void setBtn_Inicio(JButton btn_Inicio) {
        this.btn_Inicio = btn_Inicio;
    }

    public JButton getBtn_RegistroClienteCaso() {
        return btn_RegistroClienteCaso;
    }

    public void setBtn_RegistroClienteCaso(JButton btn_RegistroClienteCaso) {
        this.btn_RegistroClienteCaso = btn_RegistroClienteCaso;
    }

    public JButton getBtn_VisualizarCaso() {
        return btn_VisualizarCaso;
    }

    public void setBtn_VisualizarCaso(JButton btn_VisualizarCaso) {
        this.btn_VisualizarCaso = btn_VisualizarCaso;
    }

    public JButton getBtn_citas() {
        return btn_citas;
    }

    public void setBtn_citas(JButton btn_citas) {
        this.btn_citas = btn_citas;
    }

    public JButton getBtn_horario() {
        return btn_horario;
    }

    public void setBtn_horario(JButton btn_horario) {
        this.btn_horario = btn_horario;
    }

    public JMenu getCasosJudiciales() {
        return casosJudiciales;
    }

    public void setCasosJudiciales(JMenu casosJudiciales) {
        this.casosJudiciales = casosJudiciales;
    }

    public JMenu getCitasConsultas() {
        return citasConsultas;
    }

    public void setCitasConsultas(JMenu citasConsultas) {
        this.citasConsultas = citasConsultas;
    }

    public static JDesktopPane getEscritorio() {
        return escritorio;
    }

    public static void setEscritorio(JDesktopPane escritorio) {
        V_Menu_Inicio.escritorio = escritorio;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JMenu getPeticionFamiliar() {
        return peticionFamiliar;
    }

    public void setPeticionFamiliar(JMenu peticionFamiliar) {
        this.peticionFamiliar = peticionFamiliar;
    }

    public JMenu getProcesosMigratorios() {
        return procesosMigratorios;
    }

    public void setProcesosMigratorios(JMenu procesosMigratorios) {
        this.procesosMigratorios = procesosMigratorios;
    }

    public JMenu getTramitesVisa() {
        return tramitesVisa;
    }

    public void setTramitesVisa(JMenu tramitesVisa) {
        this.tramitesVisa = tramitesVisa;
    }

    public JMenu getWaiver() {
        return waiver;
    }

    public void setWaiver(JMenu waiver) {
        this.waiver = waiver;
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

    public JButton getBtn_consultas() {
        return btn_consultas;
    }

    public void setBtn_consultas(JButton btn_consultas) {
        this.btn_consultas = btn_consultas;
    }

    public JLabel getLb_matricula() {
        return lb_matricula;
    }

    public void setLb_matricula(JLabel lb_matricula) {
        this.lb_matricula = lb_matricula;
    }

    public JLabel getLb_usuario() {
        return lb_usuario;
    }

    public void setLb_usuario(JLabel lb_usuario) {
        this.lb_usuario = lb_usuario;
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
        btn_VisualizarCaso = new javax.swing.JButton();
        btn_RegistroClienteCaso = new javax.swing.JButton();
        btn_Inicio = new javax.swing.JButton();
        btn_consultas = new javax.swing.JButton();
        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lb_usuario = new javax.swing.JLabel();
        lb_matricula = new javax.swing.JLabel();
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
        Requisitos = new javax.swing.JMenu();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_horario.setBackground(new java.awt.Color(0, 0, 0));
        btn_horario.setForeground(new java.awt.Color(153, 153, 153));
        btn_horario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calendario_1.png"))); // NOI18N
        btn_horario.setToolTipText("Horario");
        btn_horario.setAutoscrolls(true);
        btn_horario.setContentAreaFilled(false);
        jPanel1.add(btn_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 60));

        btn_citas.setBackground(new java.awt.Color(0, 0, 0));
        btn_citas.setForeground(new java.awt.Color(153, 153, 153));
        btn_citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/citas.png"))); // NOI18N
        btn_citas.setToolTipText("Cita");
        btn_citas.setAutoscrolls(true);
        btn_citas.setContentAreaFilled(false);
        jPanel1.add(btn_citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 80, 60));

        btn_VisualizarCaso.setBackground(new java.awt.Color(0, 0, 0));
        btn_VisualizarCaso.setForeground(new java.awt.Color(153, 153, 153));
        btn_VisualizarCaso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vizualizar.png"))); // NOI18N
        btn_VisualizarCaso.setToolTipText("Ver Caso");
        btn_VisualizarCaso.setAutoscrolls(true);
        btn_VisualizarCaso.setContentAreaFilled(false);
        jPanel1.add(btn_VisualizarCaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 80, 60));

        btn_RegistroClienteCaso.setBackground(new java.awt.Color(0, 0, 0));
        btn_RegistroClienteCaso.setForeground(new java.awt.Color(153, 153, 153));
        btn_RegistroClienteCaso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/registro_caso.png"))); // NOI18N
        btn_RegistroClienteCaso.setToolTipText("Registro Cliente-Caso");
        btn_RegistroClienteCaso.setAutoscrolls(true);
        btn_RegistroClienteCaso.setContentAreaFilled(false);
        jPanel1.add(btn_RegistroClienteCaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 80, 60));

        btn_Inicio.setBackground(new java.awt.Color(0, 0, 0));
        btn_Inicio.setForeground(new java.awt.Color(0, 0, 0));
        btn_Inicio.setText("INICIO");
        btn_Inicio.setAutoscrolls(true);
        btn_Inicio.setContentAreaFilled(false);
        btn_Inicio.setMaximumSize(new java.awt.Dimension(30, 16));
        btn_Inicio.setMinimumSize(new java.awt.Dimension(30, 16));
        btn_Inicio.setPreferredSize(new java.awt.Dimension(60, 16));
        jPanel1.add(btn_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 90, 60));

        btn_consultas.setBackground(new java.awt.Color(0, 0, 0));
        btn_consultas.setForeground(new java.awt.Color(153, 153, 153));
        btn_consultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/consultas.png"))); // NOI18N
        btn_consultas.setToolTipText("Cita");
        btn_consultas.setAutoscrolls(true);
        btn_consultas.setContentAreaFilled(false);
        jPanel1.add(btn_consultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 80, 60));

        escritorio.setBackground(new java.awt.Color(233, 189, 138));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logo proyecto_ccexpress (1).png"))); // NOI18N

        lb_usuario.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 14)); // NOI18N
        lb_usuario.setText("jLabel2");

        lb_matricula.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 14)); // NOI18N
        lb_matricula.setText("jLabel2");

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lb_usuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lb_matricula, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addComponent(lb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lb_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        Registro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Registro.setText("Registro");
        Registro.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        Reg_abogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Reg_abogado.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Reg_abogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Abogada.png"))); // NOI18N
        Reg_abogado.setText("Abogado");
        Registro.add(Reg_abogado);

        Reg_secretaria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Reg_secretaria.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Reg_secretaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Secretaria.png"))); // NOI18N
        Reg_secretaria.setText("Secretaria");
        Registro.add(Reg_secretaria);

        Reg_cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Reg_cliente.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Reg_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cliente.png"))); // NOI18N
        Reg_cliente.setText("Cliente");
        Registro.add(Reg_cliente);

        Reg_usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        Reg_usuario.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Reg_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Usuario.png"))); // NOI18N
        Reg_usuario.setText("Usuario");
        Registro.add(Reg_usuario);

        jMenuBar1.add(Registro);

        Modifcar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Modifcar.setText("Modificar");
        Modifcar.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        Mod_abogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Mod_abogado.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Mod_abogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Abogada.png"))); // NOI18N
        Mod_abogado.setText("Abogado");
        Modifcar.add(Mod_abogado);

        Mod_secretaria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Mod_secretaria.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Mod_secretaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Secretaria.png"))); // NOI18N
        Mod_secretaria.setText("Secretaria");
        Modifcar.add(Mod_secretaria);

        Mod_cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Mod_cliente.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Mod_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cliente.png"))); // NOI18N
        Mod_cliente.setText("Cliente");
        Modifcar.add(Mod_cliente);

        jMenuBar1.add(Modifcar);

        Requisitos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Requisitos.setText("Requisitos");
        Requisitos.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        casosJudiciales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Casos Judiciales.png"))); // NOI18N
        casosJudiciales.setText("Casos Judiciales");
        casosJudiciales.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        Req_divorcio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        Req_divorcio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Divorcio.png"))); // NOI18N
        Req_divorcio.setText("Divorcio");
        casosJudiciales.add(Req_divorcio);

        Req_pensionesali.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        Req_pensionesali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pensiones Alimenticias.png"))); // NOI18N
        Req_pensionesali.setText("Pensiones Alimenticias");
        casosJudiciales.add(Req_pensionesali);

        Requisitos.add(casosJudiciales);

        tramitesVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Visa.png"))); // NOI18N
        tramitesVisa.setText("Tramites de Visa");
        tramitesVisa.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        Req_Visa_Eeuu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        Req_Visa_Eeuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/B EEUU.png"))); // NOI18N
        Req_Visa_Eeuu.setText("EEUU");
        tramitesVisa.add(Req_Visa_Eeuu);

        Req_visa_europa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        Req_visa_europa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/B Europa.png"))); // NOI18N
        Req_visa_europa.setText("Europa");
        tramitesVisa.add(Req_visa_europa);

        Req_visa_loteria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        Req_visa_loteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/B EEUU.png"))); // NOI18N
        Req_visa_loteria.setText("Loteria-EEUU");
        tramitesVisa.add(Req_visa_loteria);

        Req_visa_mexico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        Req_visa_mexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/B Mexico.png"))); // NOI18N
        Req_visa_mexico.setText("Mexico");
        tramitesVisa.add(Req_visa_mexico);

        Requisitos.add(tramitesVisa);

        waiver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Waiver.png"))); // NOI18N
        waiver.setText("Waiver");
        waiver.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        Req_Perdon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.CTRL_MASK));
        Req_Perdon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Perdon.png"))); // NOI18N
        Req_Perdon.setText("Perdon");
        waiver.add(Req_Perdon);

        Requisitos.add(waiver);

        peticionFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Peticion.png"))); // NOI18N
        peticionFamiliar.setText("Peticion Familiar");
        peticionFamiliar.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        Req_peticionfamiliar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.CTRL_MASK));
        Req_peticionfamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Familiar.png"))); // NOI18N
        Req_peticionfamiliar.setText("Peticion Familiar");
        peticionFamiliar.add(Req_peticionfamiliar);

        Requisitos.add(peticionFamiliar);

        procesosMigratorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Procesos migratorios.png"))); // NOI18N
        procesosMigratorios.setText("Procesos Migratorios");
        procesosMigratorios.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        Req_Renovacion_Pasaporte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.CTRL_MASK));
        Req_Renovacion_Pasaporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Renovacion.png"))); // NOI18N
        Req_Renovacion_Pasaporte.setText("Renovacion Pasaporte EEUU");
        procesosMigratorios.add(Req_Renovacion_Pasaporte);

        Req_RetornanteInmigrante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        Req_RetornanteInmigrante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Retornante Inmigrante.png"))); // NOI18N
        Req_RetornanteInmigrante.setText("Retornante Inmigrante");
        procesosMigratorios.add(Req_RetornanteInmigrante);

        Req_Reporte_Consular.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        Req_Reporte_Consular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reporte Consular.png"))); // NOI18N
        Req_Reporte_Consular.setText("Reporte Consular");
        procesosMigratorios.add(Req_Reporte_Consular);

        Requisitos.add(procesosMigratorios);

        jMenuBar1.add(Requisitos);

        citasConsultas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        citasConsultas.setText("Citas_Consutas");
        citasConsultas.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        Citas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        Citas.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cita 2.png"))); // NOI18N
        Citas.setText("Citas");
        citasConsultas.add(Citas);

        Consultas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        Consultas.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        Consultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Consulta 2.png"))); // NOI18N
        Consultas.setText("Consultas");
        citasConsultas.add(Consultas);

        jMenuBar1.add(citasConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1318, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Citas;
    private javax.swing.JMenuItem Consultas;
    private javax.swing.JMenuItem Mod_abogado;
    private javax.swing.JMenuItem Mod_cliente;
    private javax.swing.JMenuItem Mod_secretaria;
    private javax.swing.JMenu Modifcar;
    private javax.swing.JMenuItem Reg_abogado;
    private javax.swing.JMenuItem Reg_cliente;
    private javax.swing.JMenuItem Reg_secretaria;
    private javax.swing.JMenuItem Reg_usuario;
    private javax.swing.JMenu Registro;
    private javax.swing.JMenuItem Req_Perdon;
    private javax.swing.JMenuItem Req_Renovacion_Pasaporte;
    private javax.swing.JMenuItem Req_Reporte_Consular;
    private javax.swing.JMenuItem Req_RetornanteInmigrante;
    private javax.swing.JMenuItem Req_Visa_Eeuu;
    private javax.swing.JMenuItem Req_divorcio;
    private javax.swing.JMenuItem Req_pensionesali;
    private javax.swing.JMenuItem Req_peticionfamiliar;
    private javax.swing.JMenuItem Req_visa_europa;
    private javax.swing.JMenuItem Req_visa_loteria;
    private javax.swing.JMenuItem Req_visa_mexico;
    private javax.swing.JMenu Requisitos;
    private javax.swing.JButton btn_Inicio;
    private javax.swing.JButton btn_RegistroClienteCaso;
    private javax.swing.JButton btn_VisualizarCaso;
    private javax.swing.JButton btn_citas;
    private javax.swing.JButton btn_consultas;
    private javax.swing.JButton btn_horario;
    private javax.swing.JMenu casosJudiciales;
    private javax.swing.JMenu citasConsultas;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_matricula;
    private javax.swing.JLabel lb_usuario;
    private javax.swing.JMenu peticionFamiliar;
    private javax.swing.JMenu procesosMigratorios;
    private javax.swing.JMenu tramitesVisa;
    private javax.swing.JMenu waiver;
    // End of variables declaration//GEN-END:variables
}
