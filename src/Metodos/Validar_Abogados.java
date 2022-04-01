package Metodos;

import Modelo.Buf_Abogado;
import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Cliente;
import Modelo.Buf_ClienteDB;
import Modelo.Buf_Persona;
import Modelo.Buf_PersonaDB;
import Modelo.Buf_Secretaria;
import Modelo.Buf_SecretariaDB;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vista.V_Registro_Abogado;

/*
 * @author BRYAN_CABRERA
 */
public class Validar_Abogados {

    V_Registro_Abogado registro;
    Buf_AbogadoDB A_DB;
    Buf_PersonaDB P_DB;
    Buf_SecretariaDB S_DB;
    Buf_ClienteDB C_DB;

    public void Nuevo() {
        registro.getBtn_guardar().setEnabled(false);
        registro.getBtn_imagen().setEnabled(false);
        registro.getBtn_cancelar().setEnabled(false);
        registro.getTxt_nombre().setEditable(false);
        registro.getTxt_cedula().setEditable(false);
        registro.getTxt_apellido().setEditable(false);
        registro.getCb_estado().setEnabled(false);
        registro.getTxt_celular().setEditable(false);
        registro.getTxt_cuenta().setEditable(false);
        registro.getTxt_direccion().setEditable(false);
        registro.getTxt_matricula().setEditable(false);
        registro.getTxt_correo().setEditable(false);
        registro.getCb_1().setEnabled(false);
        registro.getCb_2().setEnabled(false);
        registro.getCb_3().setEnabled(false);
        registro.getCb_4().setEnabled(false);
        registro.getCalendar().setEnabled(false);
        registro.getTxt_cedula().setText("");
        registro.getTxt_nombre().setText("");
        registro.getCb_estado().setSelectedIndex(0);
        registro.getTxt_apellido().setText("");
        registro.getTxt_celular().setText("");
        registro.getTxt_cuenta().setText("");
        registro.getTxt_direccion().setText("");
        registro.getTxt_matricula().setText("");
        registro.getTxt_correo().setText("");
        registro.getCb_1().setSelected(false);
        registro.getCb_2().setSelected(false);
        registro.getCb_3().setSelected(false);
        registro.getCb_4().setSelected(false);
        registro.getCalendar().setCalendar(null);
        registro.getLb_foto().setIcon(null);
    }

    public void Activar_Campos() {

        registro.getBtn_imagen().setEnabled(true);
        registro.getTxt_nombre().setEditable(true);
        registro.getTxt_cedula().setEditable(true);
        registro.getTxt_apellido().setEditable(true);
        registro.getCb_estado().setEnabled(true);
        registro.getTxt_celular().setEditable(true);
        registro.getTxt_cuenta().setEditable(true);
        registro.getTxt_direccion().setEditable(true);
        registro.getTxt_matricula().setEditable(true);
        registro.getTxt_correo().setEditable(true);
        registro.getCb_1().setEnabled(true);
        registro.getCb_2().setEnabled(true);
        registro.getCb_3().setEnabled(true);
        registro.getCb_4().setEnabled(true);
        registro.getCalendar().setEnabled(true);
        registro.getBtn_nuevo().setEnabled(false);
    }

    public void Cancelar() {

        registro.getTxt_cedula().setText("");
        registro.getTxt_nombre().setText("");
        registro.getCb_estado().setSelectedIndex(0);
        registro.getTxt_apellido().setText("");
        registro.getTxt_celular().setText("");
        registro.getTxt_cuenta().setText("");
        registro.getTxt_direccion().setText("");
        registro.getTxt_matricula().setText("");
        registro.getTxt_correo().setText("");
        registro.getCb_1().setSelected(false);
        registro.getCb_2().setSelected(false);
        registro.getCb_3().setSelected(false);
        registro.getCb_4().setSelected(false);
        registro.getCalendar().setCalendar(null);
        registro.getLb_foto().setIcon(null);
    }

    public void Campo_Vacio() {
        String estado = (String) registro.getCb_estado().getSelectedItem();

        if (registro.getTxt_nombre().getText().isEmpty()) {
            registro.getLb_nombre().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_apellido().getText().isEmpty()) {
            registro.getLb_apellido().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_cedula().getText().isEmpty()) {
            registro.getLb_cedula().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_celular().getText().isEmpty()) {
            registro.getLb_celular().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_correo().getText().isEmpty()) {
            registro.getLb_correo().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_cuenta().getText().isEmpty()) {
            registro.getLb_cuenta().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_direccion().getText().isEmpty()) {
            registro.getLb_direccion().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getTxt_matricula().getText().isEmpty()) {
            registro.getLb_matricula().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (estado.equals("Seleccionar")) {
            registro.getLb_estado().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (!(registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
            registro.getLb_horario().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (!(registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
            registro.foto.setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        if (registro.getCalendar().getDate() == null) {
            registro.getLb_fecha().setVisible(true);
            registro.getBtn_cancelar().setEnabled(false);
        }

        //CUANDO EL CAMPO ESTA LLENO
        if (!registro.getTxt_nombre().getText().isEmpty()) {
            registro.getLb_nombre().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_apellido().getText().isEmpty()) {
            registro.getLb_apellido().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_cedula().getText().isEmpty()) {
            registro.getLb_cedula().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_celular().getText().isEmpty()) {
            registro.getLb_celular().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_correo().getText().isEmpty()) {
            registro.getLb_correo().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_cuenta().getText().isEmpty()) {
            registro.getLb_cuenta().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_direccion().getText().isEmpty()) {
            registro.getLb_direccion().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!registro.getTxt_matricula().getText().isEmpty()) {
            registro.getLb_matricula().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!estado.equals("Seleccionar")) {
            registro.getLb_estado().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!(registro.getLb_foto().getIcon() == null)) {
            registro.foto.setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if ((registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {
            registro.getLb_horario().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (!(registro.getCalendar().getDate() == null)) {
            registro.getLb_fecha().setVisible(false);
            registro.getBtn_cancelar().setEnabled(true);
        }

        if (registro.getLb_cedula().isShowing() == true) {
            registro.cedula.setVisible(false);
        } else if (!Verificar_Cedula(registro.getTxt_cedula().getText())) {
            registro.cedula.setVisible(true);
        } else if (Verificar_Cedula(registro.getTxt_cedula().getText())) {
            registro.cedula.setVisible(false);
        }

        if (registro.getLb_celular().isShowing() == true) {
            registro.celular.setVisible(false);
        } else if (registro.getTxt_celular().getText().length() < 10) {
            registro.celular.setVisible(true);
        } else if (registro.getTxt_celular().getText().length() == 10) {
            registro.celular.setVisible(false);
        }

        if (!registro.getTxt_nombre().getText().isEmpty() && !registro.getTxt_apellido().getText().isEmpty() && !registro.getTxt_cedula().getText().isEmpty() && !registro.getTxt_celular().getText().isEmpty() && !registro.getTxt_correo().getText().isEmpty() && !registro.getTxt_cuenta().getText().isEmpty() && !registro.getTxt_direccion().getText().isEmpty() && !registro.getTxt_matricula().getText().isEmpty() && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected()) && !estado.equals("Seleccionar") && !(registro.getCalendar().getDate() == null)) {
            registro.getBtn_guardar().setEnabled(true);
        } else {
            registro.getBtn_guardar().setEnabled(false);
        }
    }

    public boolean Validar_Datos() {

        String estado = (String) registro.getCb_estado().getSelectedItem();

        if (!registro.getTxt_cedula().getText().equals("") && !registro.getTxt_nombre().getText().equals("") && !registro.getTxt_apellido().getText().equals("") && !(registro.getLb_foto().getIcon() == null) && !(registro.getCalendar().getDate() == null) && !registro.getTxt_celular().getText().equals("") && !registro.getTxt_cuenta().getText().equals("") && !registro.getTxt_correo().getText().equals("") && !registro.getTxt_direccion().getText().equals("") && !estado.equals("Seleccionar") && !registro.getTxt_matricula().getText().equals("") && (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {

            return true;
        } else {

            return false;
        }
    }

    public boolean Validar_Cancelar() {

        String estado = (String) registro.getCb_estado().getSelectedItem();

        if (!registro.getTxt_cedula().getText().equals("") || !registro.getTxt_nombre().getText().equals("") || !registro.getTxt_apellido().getText().equals("") || !(registro.getCalendar().getDate() == null) || !registro.getTxt_celular().getText().equals("") || !registro.getTxt_cuenta().getText().equals("") || !registro.getTxt_correo().getText().equals("") || !registro.getTxt_direccion().getText().equals("") || !estado.equals("Seleccionar") || !registro.getTxt_matricula().getText().equals("") || (registro.getCb_1().isSelected() || registro.getCb_2().isSelected() || registro.getCb_3().isSelected() || registro.getCb_4().isSelected())) {

            return true;
        } else {

            return false;
        }
    }

    public void Estado_Civil() {

        registro.getCb_estado().addItem("Seleccionar");
        registro.getCb_estado().addItem("Soltero");
        registro.getCb_estado().addItem("Casado");
        registro.getCb_estado().addItem("Divorciado");
    }
    
    public void Campos() {

        registro.cedula.setVisible(false);
        registro.celular.setVisible(false);
        registro.getLb_apellido().setVisible(false);
        registro.getLb_nombre().setVisible(false);
        registro.getLb_cedula().setVisible(false);
        registro.getLb_correo().setVisible(false);
        registro.getLb_celular().setVisible(false);
        registro.getLb_cuenta().setVisible(false);
        registro.getLb_fecha().setVisible(false);
        registro.getLb_horario().setVisible(false);
        registro.getLb_matricula().setVisible(false);
        registro.getLb_estado().setVisible(false);
        registro.getLb_direccion().setVisible(false);
        registro.correo.setVisible(false);
        registro.getBtn_guardar().setEnabled(false);
        registro.datocedula.setVisible(false);
        registro.datocorreo.setVisible(false);
        registro.datomatricula.setVisible(false);
        registro.foto.setVisible(false);
    }

    public boolean Validar_Cedula() {

        List<Buf_Persona> List_pers = P_DB.Getter();

        for (int i = 0; i < List_pers.size(); i++) {
            if (List_pers.get(i).getCedula().equals(registro.getTxt_cedula().getText())) {
                return true;
            }
        }
        return true;
    }

    public boolean Validar_Correo() {

        List<Buf_Abogado> List_abg = A_DB.Getter();
        List<Buf_Secretaria> List_secre = S_DB.Getter();
        List<Buf_Cliente> List_cliente = C_DB.Getter();

        for (int i = 0; i < List_abg.size(); i++) {
            if (List_abg.get(i).getCorreo().equalsIgnoreCase(registro.getTxt_correo().getText())) {
                return false;
            }
        }

        for (int i = 0; i < List_secre.size(); i++) {
            if (List_secre.get(i).getCorreo().equalsIgnoreCase(registro.getTxt_correo().getText())) {
                return false;
            }
        }

        for (int i = 0; i < List_cliente.size(); i++) {
            if (List_cliente.get(i).getCorreo().equalsIgnoreCase(registro.getTxt_correo().getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean Validar_Matricula() {

        List<Buf_Abogado> List_abg = A_DB.Getter();

        int matricula = Integer.parseInt(registro.getTxt_matricula().getText());

        for (int i = 0; i < List_abg.size(); i++) {
            if (List_abg.get(i).getNum_matricula() == matricula) {
                return false;
            }
        }
        return true;
    }

    public boolean Verificar_Cedula(String cedula) {

        int total = 0;
        int tamanoLongitudCedula = 10;
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int numeroProviancias = 24;
        int tercerdigito = 6;

        if (cedula.matches("[0-9]*") && cedula.length() == tamanoLongitudCedula) {
            int provincia = Integer.parseInt(cedula.charAt(0) + "" + cedula.charAt(1));
            int digitoTres = Integer.parseInt(cedula.charAt(2) + "");

            if ((provincia > 0 && provincia <= numeroProviancias) && digitoTres < tercerdigito) {
                int digitoVerificadorRecibido = Integer.parseInt(cedula.charAt(9) + "");

                for (int i = 0; i < coeficientes.length; i++) {
                    int valor = Integer.parseInt(coeficientes[i] + "") * Integer.parseInt(cedula.charAt(i) + "");
                    total = valor >= 10 ? total + (valor - 9) : total + valor;
                }

                int digitoVerificadorObtenido = total >= 10 ? (total % 10) != 0 ? 10 - (total % 10) : (total % 10) : total;

                if (digitoVerificadorObtenido == digitoVerificadorRecibido) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean Validar_Correo(String correo) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher valida = patron.matcher(correo);

        return valida.find();
    }
}
