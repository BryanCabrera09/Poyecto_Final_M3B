package controlador;

import Metodos.Validar_Abogados;
import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_ClienteDB;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import Modelo.Buf_SecretariaDB;
import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.V_Caso;
import vista.V_Citas;
import vista.V_Consultas;
import vista.V_Consuta_Citas;
import vista.V_Consuta_Consultas;
import vista.V_Horario;
import vista.V_Inicio_Sesion;
import vista.V_Menu_Inicio;
import vista.V_Modificar_Abogado;
import vista.V_Modificar_Cliente;
import vista.V_Modificar_Secretaria;
import vista.V_Info_Req_Divorcio;
import vista.V_Info_Req_Visa_EEUU;
import vista.V_Info_Req_Visa_Europa;
import vista.V_Info_Req_Visa_Loteria;
import vista.V_Info_Req_PensionesAlimenticias;
import vista.V_Info_Req_Perdon;
import vista.V_Info_Req_Peticion;
import vista.V_Info_Req_RenovacionPasaporte;
import vista.V_Info_Req_ReporteConsular;
import vista.V_Info_Req_RetornanteInmigrante;
import vista.V_Info_Req_Visa_Mexico;
import vista.V_Registro_Abogado;
import vista.V_Registro_Caso;
import vista.V_Registro_Cliente;
import vista.V_Registro_Secretaria;
import vista.V_Registro_Usuario;

/*
 * @author BRYAN_CABRERA
 */
public class C_Menu_Inicio implements ActionListener {
    
    //******************************************************
    Buf_Abogado A = new Buf_Abogado();
    Buf_Persona P = new Buf_Persona();
    V_Registro_Abogado registro = new V_Registro_Abogado();
    Buf_AbogadoDB A_DB = new Buf_AbogadoDB();
    Buf_PersonaDB P_DB = new Buf_PersonaDB();
    Buf_SecretariaDB S_DB = new Buf_SecretariaDB();
    Buf_ClienteDB C_DB = new Buf_ClienteDB();
    Validar_Abogados V = new Validar_Abogados();
    
    V_Modificar_Abogado modificar = new V_Modificar_Abogado();
    Buf_Usuarios U = new Buf_Usuarios();
    Buf_UsuariosDB U_DB = new Buf_UsuariosDB();

    private V_Menu_Inicio Inicio;

    public C_Menu_Inicio(V_Menu_Inicio Inicio) {
        this.Inicio = Inicio;
        this.Inicio.getBtn_citas().addActionListener(this);
        this.Inicio.getBtn_horario().addActionListener(this);
        this.Inicio.getBtn_Inicio().addActionListener(this);
        this.Inicio.getBtn_RegistroClienteCaso().addActionListener(this);
        this.Inicio.getBtn_visualizacion().addActionListener(this);
        this.Inicio.getBtn_VisualizarCaso().addActionListener(this);
        this.Inicio.getCitas().addActionListener(this);
        this.Inicio.getConsultas().addActionListener(this);
        this.Inicio.getMod_cliente().addActionListener(this);
        this.Inicio.getMod_secretaria().addActionListener(this);
        this.Inicio.getMod_abogado().addActionListener(this);
        this.Inicio.getReg_abogado().addActionListener(this);
        this.Inicio.getReg_cliente().addActionListener(this);
        this.Inicio.getReq_divorcio().addActionListener(this);
        this.Inicio.getReq_Visa_Eeuu().addActionListener(this);
        this.Inicio.getReq_visa_loteria().addActionListener(this);
        this.Inicio.getReq_visa_mexico().addActionListener(this);
        this.Inicio.getReq_pensionesali().addActionListener(this);
        this.Inicio.getReq_Renovacion_Pasaporte().addActionListener(this);
        this.Inicio.getReq_Perdon().addActionListener(this);
        this.Inicio.getReq_Reporte_Consular().addActionListener(this);
        this.Inicio.getReq_RetornanteInmigrante().addActionListener(this);
        this.Inicio.getReg_secretaria().addActionListener(this);
        this.Inicio.getReg_usuario().addActionListener(this);
        this.Inicio.getReq_visa_europa().addActionListener(this);
        this.Inicio.getReq_peticionfamiliar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Inicio.getBtn_citas()) {
            String x = V_Citas.x;
            try {
                if (x == null) {
                    V_Citas citas = new V_Citas();
                    C_Citas citas1 = new C_Citas(citas);
                    Inicio.escritorio.add(citas);
                    citas.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getBtn_horario()) {
            String x = V_Horario.x;
            try {
                if (x == null) {
                    V_Horario h1 = new V_Horario();
                    C_Horario horario = new C_Horario(h1);
                    Inicio.escritorio.add(h1);
                    h1.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getBtn_Inicio()) {
            V_Inicio_Sesion cs = new V_Inicio_Sesion();
            cs.setVisible(true);
            Inicio.dispose();
        }
        if (e.getSource() == Inicio.getBtn_RegistroClienteCaso()) {
            String x = V_Registro_Caso.x;
            try {
                if (x == null) {
                    V_Registro_Caso rca = new V_Registro_Caso();
                    C_Registro_Caso registroCaso = new C_Registro_Caso(rca);
                    Inicio.escritorio.add(rca);
                    rca.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getBtn_visualizacion()) {
            String x = V_Consultas.x;
            try {
                if (x == null) {
                    V_Consultas con1 = new V_Consultas();
                    C_Consultas consultas = new C_Consultas(con1);
                    Inicio.escritorio.add(con1);
                    con1.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getBtn_VisualizarCaso()) {
            String x = V_Caso.x;
            try {
                if (x == null) {
                    V_Caso c1 = new V_Caso();
                    C_Caso caso = new C_Caso(c1);
                    Inicio.escritorio.add(c1);
                    c1.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        //ABRIR OPCIONES PRESENTADAS EN EL MENU
        if (e.getSource() == Inicio.getCitas()) {
            String x = V_Consuta_Citas.x;
            try {
                if (x == null) {
                    V_Consuta_Citas CI = new V_Consuta_Citas();
                    C_Consulta_Citas consulta_Citas = new C_Consulta_Citas(CI);
                    Inicio.escritorio.add(CI);
                    CI.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getConsultas()) {
            String x = V_Consuta_Consultas.x;
            try {
                if (x == null) {
                    V_Consuta_Consultas C = new V_Consuta_Consultas();
                    C_Consultas_Consultas consultas_Consultas = new C_Consultas_Consultas(C);
                    Inicio.escritorio.add(C);
                    C.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getMod_cliente()) {
            String x = V_Modificar_Cliente.x;
            try {
                if (x == null) {
                    V_Modificar_Cliente C = new V_Modificar_Cliente();
                    C_Modificar_Cliente modificarCliente = new C_Modificar_Cliente(C);
                    Inicio.escritorio.add(C);
                    C.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getMod_secretaria()) {
            String x = V_Modificar_Secretaria.x;
            try {
                if (x == null) {
                    V_Modificar_Secretaria S = new V_Modificar_Secretaria();
                    C_Modificar_Secretaria modificarSecretaria = new C_Modificar_Secretaria(S);
                    Inicio.escritorio.add(S);
                    S.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getMod_abogado()) {
            String x = V_Modificar_Abogado.x;
            try {
                if (x != null) {
                    V_Modificar_Abogado RA = new V_Modificar_Abogado();
                    C_Modificar_Abogado modificarAbogado = new C_Modificar_Abogado(modificar,A,P,U,A_DB,P_DB,S_DB,C_DB,U_DB,V);
                    Inicio.escritorio.add(RA);
                    RA.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReg_abogado()) {
            String x = V_Registro_Abogado.x;
            try {
                if (x != null) {
                    V_Registro_Abogado ra = new V_Registro_Abogado();
                    C_Registro_Abogado registroAbogado = new C_Registro_Abogado(registro,A,P,A_DB,P_DB,S_DB,C_DB,V);
                    Inicio.escritorio.add(ra);
                    ra.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReg_cliente()) {
            String x = V_Registro_Cliente.x;
            try {
                if (x == null) {
                    V_Registro_Cliente rc = new V_Registro_Cliente();
                    C_Registro_Cliente registroCliente = new C_Registro_Cliente(rc);
                    Inicio.escritorio.add(rc);
                    rc.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReg_secretaria()) {
            String x = V_Registro_Secretaria.x;
            try {
                if (x == null) {
                    V_Registro_Secretaria rs = new V_Registro_Secretaria();
                    C_Registro_Secretaria secretaria = new C_Registro_Secretaria(rs);
                    Inicio.escritorio.add(rs);
                    rs.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReg_usuario()) {
            String x = V_Registro_Usuario.x;
            try {
                if (x == null) {
                    V_Registro_Usuario ru = new V_Registro_Usuario();
                    C_Registro_Usuario registroUsuario = new C_Registro_Usuario(ru);
                    Inicio.escritorio.add(ru);
                    ru.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_divorcio()) {
            String x = V_Info_Req_Divorcio.x;
            try {
                if (x == null) {
                    V_Info_Req_Divorcio rq = new V_Info_Req_Divorcio();
                    Inicio.escritorio.add(rq);
                    rq.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_Visa_Eeuu()) {
            String x = V_Info_Req_Visa_EEUU.x;
            try {
                if (x == null) {
                    V_Info_Req_Visa_EEUU rqe = new V_Info_Req_Visa_EEUU();
                    Inicio.escritorio.add(rqe);
                    rqe.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_visa_loteria()) {
            String x = V_Info_Req_Visa_Loteria.x;
            try {
                if (x == null) {
                    V_Info_Req_Visa_Loteria rql = new V_Info_Req_Visa_Loteria();
                    Inicio.escritorio.add(rql);
                    rql.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_visa_mexico()) {
            String x = V_Info_Req_Visa_Mexico.x;
            try {
                if (x == null) {
                    V_Info_Req_Visa_Mexico rqm = new V_Info_Req_Visa_Mexico();
                    Inicio.escritorio.add(rqm);
                    rqm.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_pensionesali()) {
            String x = V_Info_Req_PensionesAlimenticias.x;
            try {
                if (x == null) {
                    V_Info_Req_PensionesAlimenticias rqp = new V_Info_Req_PensionesAlimenticias();
                    Inicio.escritorio.add(rqp);
                    rqp.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_Renovacion_Pasaporte()) {
            String x = V_Info_Req_RenovacionPasaporte.x;
            try {
                if (x == null) {
                    V_Info_Req_RenovacionPasaporte rqrp = new V_Info_Req_RenovacionPasaporte();
                    Inicio.escritorio.add(rqrp);
                    rqrp.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_Perdon()) {
            String x = V_Info_Req_Perdon.x;
            try {
                if (x == null) {
                    V_Info_Req_Perdon rqpe = new V_Info_Req_Perdon();
                    Inicio.escritorio.add(rqpe);
                    rqpe.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_Reporte_Consular()) {
            String x = V_Info_Req_ReporteConsular.x;
            try {
                if (x == null) {
                    V_Info_Req_ReporteConsular rqrc = new V_Info_Req_ReporteConsular();
                    Inicio.escritorio.add(rqrc);
                    rqrc.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_RetornanteInmigrante()) {
            String x = V_Info_Req_RetornanteInmigrante.x;
            try {
                if (x == null) {
                    V_Info_Req_RetornanteInmigrante rqri = new V_Info_Req_RetornanteInmigrante();
                    Inicio.escritorio.add(rqri);
                    rqri.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.getReq_visa_europa()) {
            String x = V_Info_Req_Visa_Europa.x;
            try {
                if (x == null) {
                    V_Info_Req_Visa_Europa rqeu = new V_Info_Req_Visa_Europa();
                    Inicio.escritorio.add(rqeu);
                    rqeu.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == Inicio.getReq_peticionfamiliar()) {
            String x = V_Info_Req_Peticion.x;
            try {
                if (x == null) {
                    V_Info_Req_Peticion rqp = new V_Info_Req_Peticion();
                    Inicio.escritorio.add(rqp);
                    rqp.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public void Iniciar() {
        Inicio.setVisible(true);
        Inicio.setLocationRelativeTo(null);
    }

}
