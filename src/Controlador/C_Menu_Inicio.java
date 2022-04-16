package controlador;

import Modelo.Buf_Usuarios;
import Modelo.Buf_UsuariosDB;
import javax.swing.JOptionPane;
import vista.V_Caso;
import vista.V_Citas;
import vista.V_Consultas;
import vista.V_Consulta_Citas;
import vista.V_Consulta_Consultas;
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
public class C_Menu_Inicio {

    private V_Menu_Inicio Inicio;

    public C_Menu_Inicio(V_Menu_Inicio Inicio) {

        this.Inicio = Inicio;

        Inicio.setVisible(true);
    }

    public void Iniciar_Control() {

        Inicio.getBtn_citas().addActionListener(l -> {
            Button_Citas();
        });
        Inicio.getBtn_consultas().addActionListener(l -> {
            Button_Consultas();
        });
        Inicio.getBtn_horario().addActionListener(l -> {
            Button_Horario();
        });
        Inicio.getBtn_Inicio().addActionListener(l -> {
            Button_Inicio();
        });
        Inicio.getBtn_RegistroClienteCaso().addActionListener(l -> {
            Button_Registro_CasoCliente();
        });
        Inicio.getBtn_VisualizarCaso().addActionListener(l -> {
            Button_Visualizar_Caso();
        });
        Inicio.getCitas().addActionListener(l -> {
            Consultar_Citas();
        });
        Inicio.getConsultas().addActionListener(l -> {
            Consultar_Consultas();
        });
        Inicio.getMod_cliente().addActionListener(l -> {
            Modificar_Cliente();
        });
        Inicio.getMod_secretaria().addActionListener(l -> {
            Modificar_Secretaria();
        });
        Inicio.getMod_abogado().addActionListener(l -> {
            Modificar_Abogado();
        });
        Inicio.getReg_abogado().addActionListener(l -> {
            Registrar_Abogado();
        });
        Inicio.getReg_cliente().addActionListener(l -> {
            Registrar_Cliente();
        });
        Inicio.getReg_secretaria().addActionListener(l -> {
            Registrar_Secretaria();
        });
        Inicio.getReg_usuario().addActionListener(l -> {
            Registrar_Usuario();
        });
        Inicio.getReq_divorcio().addActionListener(l -> {
            Requisitos_Divorcio();
        });
        Inicio.getReq_Visa_Eeuu().addActionListener(l -> {
            Requisitos_Visa_EEUU();
        });
        Inicio.getReq_visa_loteria().addActionListener(l -> {
            Requisitos_Visa_Loteria();
        });
        Inicio.getReq_visa_mexico().addActionListener(l -> {
            Requisitos_Visa_Mexico();
        });
        Inicio.getReq_visa_europa().addActionListener(l -> {
            Requisitos_Visa_Europa();
        });
        Inicio.getReq_pensionesali().addActionListener(l -> {
            Requisitos_Pension_Alimenticia();
        });
        Inicio.getReq_Renovacion_Pasaporte().addActionListener(l -> {
            Requisitos_Renovacion_Pasaporte();
        });
        Inicio.getReq_Perdon().addActionListener(l -> {
            Requisitos_Perdon();
        });
        Inicio.getReq_Reporte_Consular().addActionListener(l -> {
            Requisitos_Reporte_Consular();
        });
        Inicio.getReq_RetornanteInmigrante().addActionListener(l -> {
            Requisitos_Retornante_Inmigrante();
        });
        Inicio.getReq_peticionfamiliar().addActionListener(l -> {
            Requisitos_Peticion_Familiar();
        });

    }

    public void Button_Citas() {

        String x = V_Citas.x;
        try {
            if (x == null) {
                V_Citas citas = new V_Citas();
                C_Citas cita = new C_Citas(citas);
                Inicio.getEscritorio().add(citas);
                citas.show();
                cita.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Button_Consultas() {

        String x = V_Consultas.x;
        try {
            if (x == null) {
                V_Consultas consultas = new V_Consultas();
                C_Consultas consulta = new C_Consultas(consultas);
                Inicio.getEscritorio().add(consultas);
                consultas.show();
                consulta.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Button_Horario() {

        String x = V_Horario.x;
        try {
            if (x == null) {
                V_Horario h1 = new V_Horario();
                C_Horario horario = new C_Horario(h1);
                Inicio.getEscritorio().add(h1);
                h1.show();
                horario.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Button_Inicio() {

        V_Inicio_Sesion inicio_Sesion = new V_Inicio_Sesion();
        C_Inicio_Sesion ctrlI = new C_Inicio_Sesion(inicio_Sesion);
        ctrlI.Iniciar_Control();
        Inicio.dispose();
    }

    public void Button_Registro_CasoCliente() {

        String x = V_Registro_Caso.x;
        try {
            if (x == null) {
                V_Registro_Caso rca = new V_Registro_Caso();
                C_Registro_Caso registroCaso = new C_Registro_Caso(rca);
                Inicio.getEscritorio().add(rca);
                rca.show();
                registroCaso.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Button_Visualizar_Caso() {

        String x = V_Caso.x;
        try {
            if (x == null) {
                V_Caso c1 = new V_Caso();
                C_Caso caso = new C_Caso(c1);
                Inicio.getEscritorio().add(c1);
                c1.show();
                caso.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Consultar_Citas() {

        String x = V_Consulta_Citas.x;
        try {
            if (x == null) {
                V_Consulta_Citas CI = new V_Consulta_Citas();
                C_Consulta_Citas consulta_Citas = new C_Consulta_Citas(CI);
                Inicio.getEscritorio().add(CI);
                CI.show();
                consulta_Citas.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Consultar_Consultas() {

        String x = V_Consulta_Consultas.x;
        try {
            if (x == null) {
                V_Consulta_Consultas C = new V_Consulta_Consultas();
                C_Consultas_Consultas consultas_Consultas = new C_Consultas_Consultas(C);
                Inicio.getEscritorio().add(C);
                C.show();
                consultas_Consultas.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Modificar_Cliente() {

        String x = V_Modificar_Cliente.x;
        try {
            if (x == null) {
                V_Modificar_Cliente C = new V_Modificar_Cliente();
                C_Modificar_Cliente modificarCliente = new C_Modificar_Cliente(C);
                Inicio.getEscritorio().add(C);
                C.show();
                modificarCliente.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Modificar_Secretaria() {

        String x = V_Modificar_Secretaria.x;
        try {
            if (x == null) {
                V_Modificar_Secretaria S = new V_Modificar_Secretaria();
                C_Modificar_Secretaria modificarSecretaria = new C_Modificar_Secretaria(S);
                Inicio.getEscritorio().add(S);
                S.show();
                modificarSecretaria.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Modificar_Abogado() {

        String x = V_Modificar_Abogado.x;
        try {
            if (x == null) {
                V_Modificar_Abogado RA = new V_Modificar_Abogado();
                C_Modificar_Abogado modificarAbogado = new C_Modificar_Abogado(RA);
                Inicio.getEscritorio().add(RA);
                RA.show();
                modificarAbogado.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Registrar_Abogado() {

        String x = V_Registro_Abogado.x;
        try {
            if (x == null) {
                V_Registro_Abogado ra = new V_Registro_Abogado();
                C_Registro_Abogado registroAbogado = new C_Registro_Abogado(ra);
                Inicio.getEscritorio().add(ra);
                ra.show();
                registroAbogado.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Registrar_Cliente() {

        String x = V_Registro_Cliente.x;
        try {
            if (x == null) {
                V_Registro_Cliente rc = new V_Registro_Cliente();
                C_Registro_Cliente registroCliente = new C_Registro_Cliente(rc);
                Inicio.getEscritorio().add(rc);
                rc.show();
                registroCliente.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Registrar_Secretaria() {

        String x = V_Registro_Secretaria.x;
        try {
            if (x == null) {
                V_Registro_Secretaria rs = new V_Registro_Secretaria();
                C_Registro_Secretaria secretaria = new C_Registro_Secretaria(rs);
                Inicio.getEscritorio().add(rs);
                rs.show();
                secretaria.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Registrar_Usuario() {

        String x = V_Registro_Usuario.x;
        try {
            if (x == null) {
                V_Registro_Usuario ru = new V_Registro_Usuario();
                C_Registro_Usuario registroUsuario = new C_Registro_Usuario(ru);
                Inicio.getEscritorio().add(ru);
                ru.show();
                registroUsuario.Iniciar_Control();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Divorcio() {

        String x = V_Info_Req_Divorcio.x;
        try {
            if (x == null) {
                V_Info_Req_Divorcio rq = new V_Info_Req_Divorcio();
                Inicio.getEscritorio().add(rq);
                rq.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Visa_EEUU() {

        String x = V_Info_Req_Visa_EEUU.x;
        try {
            if (x == null) {
                V_Info_Req_Visa_EEUU rqe = new V_Info_Req_Visa_EEUU();
                Inicio.getEscritorio().add(rqe);
                rqe.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Visa_Loteria() {

        String x = V_Info_Req_Visa_Loteria.x;
        try {
            if (x == null) {
                V_Info_Req_Visa_Loteria rql = new V_Info_Req_Visa_Loteria();
                Inicio.getEscritorio().add(rql);
                rql.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Visa_Mexico() {

        String x = V_Info_Req_Visa_Mexico.x;
        try {
            if (x == null) {
                V_Info_Req_Visa_Mexico rqm = new V_Info_Req_Visa_Mexico();
                Inicio.getEscritorio().add(rqm);
                rqm.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Visa_Europa() {

        String x = V_Info_Req_Visa_Europa.x;
        try {
            if (x == null) {
                V_Info_Req_Visa_Europa rqeu = new V_Info_Req_Visa_Europa();
                Inicio.getEscritorio().add(rqeu);
                rqeu.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Pension_Alimenticia() {

        String x = V_Info_Req_PensionesAlimenticias.x;
        try {
            if (x == null) {
                V_Info_Req_PensionesAlimenticias rqp = new V_Info_Req_PensionesAlimenticias();
                Inicio.getEscritorio().add(rqp);
                rqp.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Renovacion_Pasaporte() {

        String x = V_Info_Req_RenovacionPasaporte.x;
        try {
            if (x == null) {
                V_Info_Req_RenovacionPasaporte rqrp = new V_Info_Req_RenovacionPasaporte();
                Inicio.getEscritorio().add(rqrp);
                rqrp.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Perdon() {

        String x = V_Info_Req_Perdon.x;
        try {
            if (x == null) {
                V_Info_Req_Perdon rqpe = new V_Info_Req_Perdon();
                Inicio.getEscritorio().add(rqpe);
                rqpe.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Reporte_Consular() {

        String x = V_Info_Req_ReporteConsular.x;
        try {
            if (x == null) {
                V_Info_Req_ReporteConsular rqrc = new V_Info_Req_ReporteConsular();
                Inicio.getEscritorio().add(rqrc);
                rqrc.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Retornante_Inmigrante() {

        String x = V_Info_Req_RetornanteInmigrante.x;
        try {
            if (x == null) {
                V_Info_Req_RetornanteInmigrante rqri = new V_Info_Req_RetornanteInmigrante();
                Inicio.getEscritorio().add(rqri);
                rqri.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Requisitos_Peticion_Familiar() {

        String x = V_Info_Req_Peticion.x;
        try {
            if (x == null) {
                V_Info_Req_Peticion rqp = new V_Info_Req_Peticion();
                Inicio.getEscritorio().add(rqp);
                rqp.show();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA VENTANA YA ESTA ABIERTA", "", 3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
