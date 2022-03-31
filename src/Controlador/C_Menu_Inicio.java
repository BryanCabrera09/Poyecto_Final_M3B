
package controlador;

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
        if (e.getSource() == Inicio.btnInicio) {
            Inicio_Sesion cs = new Inicio_Sesion();
            cs.setVisible(true);
            Inicio.dispose();
        }
        if (e.getSource() == Inicio.btnRegistroClienteCaso) {
            String x = RegistroCaso.x;
            try {
                if (x == null) {
                    RegistroCaso rca = new RegistroCaso();
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
        if (e.getSource() == Inicio.btnVisualizacion) {
            String x = Consultas.x;
            try {
                if (x == null) {
                    Consultas con1 = new Consultas();
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
        if (e.getSource() == Inicio.btnVisualizarCaso) {
            String x = Caso.x;
            try {
                if (x == null) {
                    Caso c1 = new Caso();
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

        //subs
        if (e.getSource() == Inicio.Citas) {
            String x = Consuta_Citas.x;
            try {
                if (x == null) {
                    Consuta_Citas CI = new Consuta_Citas();
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
        if (e.getSource() == Inicio.Consultas) {
            String x = Consuta_Consultas.x;
            try {
                if (x == null) {
                    Consuta_Consultas C = new Consuta_Consultas();
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
        if (e.getSource() == Inicio.Mod_cliente) {
            String x = ModificarCliente.x;
            try {
                if (x == null) {
                    ModificarCliente C = new ModificarCliente();
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
        if (e.getSource() == Inicio.Mod_secretaria) {
            String x = ModificarSecretaria.x;
            try {
                if (x == null) {
                    ModificarSecretaria S = new ModificarSecretaria();
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
        if (e.getSource() == Inicio.Mod_abogado) {
            String x = ModificarAbogado.x;
            try {
                if (x == null) {
                    ModificarAbogado A = new ModificarAbogado();
                    C_Modificar_Abogado modificarAbogado = new C_Modificar_Abogado(A);
                    Inicio.escritorio.add(A);
                    A.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Reg_abogado) {
            String x = RegistroAbogado.x;
            try {
                if (x == null) {
                    RegistroAbogado ra = new RegistroAbogado();
                    C_Registro_Abogado registroAbogado = new C_Registro_Abogado(ra);
                    Inicio.escritorio.add(ra);
                    ra.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Reg_cliente) {
            String x = RegistroCliente.x;
            try {
                if (x == null) {
                    RegistroCliente rc = new RegistroCliente();
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
        if (e.getSource() == Inicio.Req_divorcio) {
            String x = RDivorcio.x;
            try {
                if (x == null) {
                    RDivorcio rq = new RDivorcio();
                    Inicio.escritorio.add(rq);
                    rq.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Req_Visa_Eeuu) {
            String x = REstadosUnidos.x;
            try {
                if (x == null) {
                    REstadosUnidos rqe = new REstadosUnidos();
                    Inicio.escritorio.add(rqe);
                    rqe.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Req_visa_loteria) {
            String x = RLoteria.x;
            try {
                if (x == null) {
                    RLoteria rql = new RLoteria();
                    Inicio.escritorio.add(rql);
                    rql.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Req_visa_mexico) {
            String x = RVisaMexico.x;
            try {
                if (x == null) {
                    RVisaMexico rqm = new RVisaMexico();
                    Inicio.escritorio.add(rqm);
                    rqm.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Req_pensionesali) {
            String x = RPensionesAlimenticias.x;
            try {
                if (x == null) {
                    RPensionesAlimenticias rqp = new RPensionesAlimenticias();
                    Inicio.escritorio.add(rqp);
                    rqp.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Req_Renovacion_Pasaporte) {
            String x = RRenovacionPasaporte.x;
            try {
                if (x == null) {
                    RRenovacionPasaporte rqrp = new RRenovacionPasaporte();
                    Inicio.escritorio.add(rqrp);
                    rqrp.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Req_Perdon) {
            String x = RPerdon.x;
            try {
                if (x == null) {
                    RPerdon rqpe = new RPerdon();
                    Inicio.escritorio.add(rqpe);
                    rqpe.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Req_Reporte_Consular) {
            String x = RReporteConsular.x;
            try {
                if (x == null) {
                    RReporteConsular rqrc = new RReporteConsular();
                    Inicio.escritorio.add(rqrc);
                    rqrc.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Req_RetornanteInmigrante) {
            String x = RRetornanteInmigrante.x;
            try {
                if (x == null) {
                    RRetornanteInmigrante rqri = new RRetornanteInmigrante();
                    Inicio.escritorio.add(rqri);
                    rqri.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == Inicio.Reg_secretaria) {
            String x = RegistroSecretaria.x;
            try {
                if (x == null) {
                    RegistroSecretaria rs = new RegistroSecretaria();
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
        if (e.getSource() == Inicio.Reg_usuario) {
            String x = RegistroUsuario.x;
            try {
                if (x == null) {
                    RegistroUsuario ru = new RegistroUsuario();
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
        if (e.getSource() == Inicio.Req_visa_europa) {
            String x = REuropa.x;
            try {
                if (x == null) {
                    REuropa rqeu = new REuropa();
                    Inicio.escritorio.add(rqeu);
                    rqeu.show();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == Inicio.Req_peticionfamiliar) {
            String x = RPeticion.x;
            try {
                if (x == null) {
                    RPeticion rqp = new RPeticion();
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

    public void iniciar() {
        Inicio.setVisible(true);
        Inicio.setLocationRelativeTo(null);
    }

}
