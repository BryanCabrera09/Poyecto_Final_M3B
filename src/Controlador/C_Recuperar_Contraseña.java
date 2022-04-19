package Controlador;

import Modelo.Buf_Usuarios;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import Modelo.Buf_UsuariosDB;
import Vista.V_RecuperarContraseña;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import vista.V_Inicio_Sesion;

/*
 * @author BRYAN_CABRERA
 */
public class C_Recuperar_Contraseña {

    private V_RecuperarContraseña recuperar;

    Buf_Usuarios User = new Buf_Usuarios();
    Buf_UsuariosDB UserDB = new Buf_UsuariosDB();

    public C_Recuperar_Contraseña(V_RecuperarContraseña recuperar) {

        this.recuperar = recuperar;

        Campos();

        recuperar.setVisible(true);
        recuperar.setLocationRelativeTo(null);
    }

    public void Iniciar_Control() {

        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (e.getSource() == recuperar.getTxt_correo()) {

                    char presionar = e.getKeyChar();

                    if (presionar == KeyEvent.VK_ENTER) {

                        recuperar.getBtn_enviar().doClick();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                if (e.getSource() == recuperar.getTxt_correo()) {
                    Campo_Vacio();
                }
                if (e.getSource() == recuperar.getTxt_usuario()) {

                    Campo_Vacio();
                }
            }
        };
        recuperar.getTxt_usuario().addKeyListener(K);
        recuperar.getTxt_correo().addKeyListener(K);

        //ACTIVAR BOTONES
        recuperar.getBtn_cancelar().addActionListener(l -> {

            V_Inicio_Sesion inicio_Sesion = new V_Inicio_Sesion();
            controlador.C_Inicio_Sesion ctrlI = new controlador.C_Inicio_Sesion(inicio_Sesion);
            ctrlI.Iniciar_Control();
            recuperar.dispose();
        });
        recuperar.getBtn_enviar().addActionListener(l -> {
            Subir_Datos();
        });
    }

    public void Subir_Datos() {

        if (Validar_Campos() == true) {

            if ((Validar_Usuario() == true) && (Validar_Correo() == true)) {

                SendMail();
                Campos();

            } else {

                JOptionPane.showMessageDialog(null, "Usuario o Correo Incorrectos", "Error Datos", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos", "Compos Vacios", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void SendMail() {

        String correo_Envia = "bcsebastian99@gmail.com";
        String contra = "pcqucofvpsgbocxg";
        String correodest = recuperar.getTxt_correo().getText();

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(props);

        String asunto = "RECUPERACION DE CONTRASEÑA";
        String mensaje = "";

        List<Buf_Usuarios> List_Usuarios = UserDB.Getter();

        for (int i = 0; i < List_Usuarios.size(); i++) {
            if (List_Usuarios.get(i).getUsuario().equals(recuperar.getTxt_usuario().getText())) {
                mensaje = "ESTIMADO USUARIO LA CONTRASEÑA DE SU CUENTA ES " + List_Usuarios.get(i).getContrasenia() + " POR FAVOR NO OLVIDE SUS DATOS DE USUARIO";
            }
        }

        MimeMessage mail = new MimeMessage(s);

        try {
            mail.setFrom(new InternetAddress(correo_Envia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correodest));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport t = s.getTransport("smtp");
            t.connect(correo_Envia, contra);
            t.sendMessage(mail, mail.getAllRecipients());
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Enviado Exitosamente");
            V_Inicio_Sesion inicio_Sesion = new V_Inicio_Sesion();
            controlador.C_Inicio_Sesion ctrlI = new controlador.C_Inicio_Sesion(inicio_Sesion);
            ctrlI.Iniciar_Control();
            recuperar.dispose();

        } catch (AddressException e) {
        } catch (MessagingException e) {

            e.printStackTrace();
        }
    }

    public void Campos() {

        recuperar.getTxt_usuario().setText("");
        recuperar.getTxt_correo().setText("");
        recuperar.getLb_correo().setVisible(false);
        recuperar.getLb_usuario().setVisible(false);
    }

    public void Cancelar() {

        recuperar.getTxt_usuario().setText("");
        recuperar.getTxt_correo().setText("");
    }

    public void Campo_Vacio() {

        if (recuperar.getTxt_usuario().getText().isEmpty()) {

            recuperar.getLb_usuario().setVisible(true);
        }
        if (recuperar.getTxt_correo().getText().isEmpty()) {

            recuperar.getLb_correo().setVisible(true);
        }

        if (!(recuperar.getTxt_usuario().getText().isEmpty())) {

            recuperar.getLb_usuario().setVisible(false);
        }
        if (!(recuperar.getTxt_correo().getText().isEmpty())) {

            recuperar.getLb_correo().setVisible(false);
        }
    }

    public boolean Validar_Usuario() {

        Buf_UsuariosDB userDB = new Buf_UsuariosDB();

        List<Buf_Usuarios> List_usr = userDB.Getter();

        for (int i = 0; i < List_usr.size(); i++) {
            if (List_usr.get(i).getUsuario().equals(recuperar.getTxt_usuario().getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean Validar_Correo() {

        Buf_PersonaDB A_DB = new Buf_PersonaDB();

        List<Buf_Persona> List_per = A_DB.Getter();

        for (int i = 0; i < List_per.size(); i++) {
            if (List_per.get(i).getCorreo().equals(recuperar.getTxt_correo().getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean Validar_Campos() {

        if (!(recuperar.getTxt_usuario().getText().isEmpty()) && !(recuperar.getTxt_correo().getText().isEmpty())) {

            return true;
        } else {

            return false;
        }
    }
}
