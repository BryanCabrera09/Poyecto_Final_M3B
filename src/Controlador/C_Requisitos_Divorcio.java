/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso_Divorcio;
import Modelo.Buf_Caso_DivorcioDB;
import Modelo.Buf_Pagos;
import Modelo.Buf_PagosDB;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.V_Menu_Inicio;
import vista.V_Pago;
import vista.V_Requisitos_Divorcio;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Divorcio {

    V_Requisitos_Divorcio divorcio;
    Buf_Caso_DivorcioDB D_DB = new Buf_Caso_DivorcioDB();
    Buf_Caso_Divorcio D = new Buf_Caso_Divorcio();
    Buf_PagosDB P_DB = new Buf_PagosDB();

    public File ruta;
    public File ruta_2;
    public File ruta_3;
    public File ruta_4;
    public File ruta_5;
    public File ruta_6;

    public String rutas;
    public String rutas_2;
    public String rutas_3;
    public String rutas_4;
    public String rutas_5;
    public String rutas_6;

    public C_Requisitos_Divorcio(V_Requisitos_Divorcio divorcio) {

        this.divorcio = divorcio;

        Campo_Bloqueado();
        Validar_Guardar_Modificar();
        Cargar_Check();
    }

    public void Iniciar_Control() {

        divorcio.getBtn_guardar().addActionListener(l -> {
            Subir_Documento();
        });
        divorcio.getBtn_modificar().addActionListener(l -> {
            Modificar_Requisitos();
        });
        divorcio.getBtn_pago().addActionListener(l -> {
            Abrir_Pago();

        });
        divorcio.getReq_1().addActionListener(l -> {
            Cargar_Imagen();
        });
        divorcio.getReq_2().addActionListener(l -> {
            Cargar_Imagen_2();
        });
        divorcio.getReq_3().addActionListener(l -> {
            Cargar_Imagen_3();
        });
        divorcio.getReq_4().addActionListener(l -> {
            Cargar_Imagen_4();
        });
        divorcio.getReq_5().addActionListener(l -> {
            Cargar_Imagen_5();
        });
        divorcio.getReq_6().addActionListener(l -> {
            Cargar_Imagen_6();
        });
    }

    public void Cargar_Imagen() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
        }
    }

    public void Cargar_Imagen_2() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_2 = j.getSelectedFile();
            rutas_2 = String.valueOf(ruta_2);
        }
    }

    public void Cargar_Imagen_3() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_3 = j.getSelectedFile();
            rutas_3 = String.valueOf(ruta_3);
        }
    }

    public void Cargar_Imagen_4() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_4 = j.getSelectedFile();
            rutas_4 = String.valueOf(ruta_4);
        }
    }

    public void Cargar_Imagen_5() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_5 = j.getSelectedFile();
            rutas_5 = String.valueOf(ruta_5);
        }
    }

    public void Cargar_Imagen_6() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_6 = j.getSelectedFile();
            rutas_6 = String.valueOf(ruta_6);
        }
    }

    public void Campo_Bloqueado() {

        divorcio.getTxt_id().setEditable(false);
        divorcio.getTxt_cedula().setEditable(false);
    }

    public void Subir_Documento() {

        D.setId_caso(Integer.parseInt(divorcio.getTxt_id().getText()));
        D.setCedula(divorcio.getTxt_cedula().getText());

        //REQUISITO #1
        File ruta = new File(rutas);

        try {
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            D.setReq_1(icono);
        } catch (Exception ex) {
            D.setReq_1(null);
        }

        //REQUISITO #2
        File ruta_2 = new File(rutas_2);

        try {
            byte[] icono = new byte[(int) ruta_2.length()];
            InputStream input = new FileInputStream(ruta_2);
            input.read(icono);
            D.setReq_2(icono);
        } catch (Exception ex) {
            D.setReq_2(null);
        }

        //REQUISITO #3
        File ruta_3 = new File(rutas_3);

        try {
            byte[] icono = new byte[(int) ruta_3.length()];
            InputStream input = new FileInputStream(ruta_3);
            input.read(icono);
            D.setReq_3(icono);
        } catch (Exception ex) {
            D.setReq_3(null);
        }

        //REQUISITO #4
        File ruta_4 = new File(rutas_4);

        try {
            byte[] icono = new byte[(int) ruta_4.length()];
            InputStream input = new FileInputStream(ruta_4);
            input.read(icono);
            D.setReq_4(icono);
        } catch (Exception ex) {
            D.setReq_4(null);
        }

        //REQUISITO #5
        File ruta_5 = new File(rutas_5);

        try {
            byte[] icono = new byte[(int) ruta_5.length()];
            InputStream input = new FileInputStream(ruta_5);
            input.read(icono);
            D.setReq_5(icono);
        } catch (Exception ex) {
            D.setReq_5(null);
        }

        //REQUISITO #6
        File ruta_6 = new File(rutas_6);

        try {
            byte[] icono = new byte[(int) ruta_6.length()];
            InputStream input = new FileInputStream(ruta_6);
            input.read(icono);
            D.setReq_6(icono);
        } catch (Exception ex) {
            D.setReq_6(null);
        }

        int honorarios = 250;
        D.setHonorarios(honorarios);
        D.setObservacion(divorcio.getTxa_observ().getText());
        if (D_DB.Register(D)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void Cargar_Check() {

        List<Buf_Caso_Divorcio> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(divorcio.getTxt_cedula().getText())) {
                if (List_caso.get(i).getReq_1() != null) {
                    divorcio.getReq_1().setSelected(true);
                } else {
                    divorcio.getReq_1().setSelected(false);
                }
                if (List_caso.get(i).getReq_2() != null) {
                    divorcio.getReq_2().setSelected(true);
                } else {
                    divorcio.getReq_2().setSelected(false);
                }
                if (List_caso.get(i).getReq_3() != null) {
                    divorcio.getReq_3().setSelected(true);
                } else {
                    divorcio.getReq_3().setSelected(false);
                }
                if (List_caso.get(i).getReq_4() != null) {
                    divorcio.getReq_4().setSelected(true);
                } else {
                    divorcio.getReq_4().setSelected(false);
                }
                if (List_caso.get(i).getReq_5() != null) {
                    divorcio.getReq_5().setSelected(true);
                } else {
                    divorcio.getReq_5().setSelected(false);
                }
                if (List_caso.get(i).getReq_6() != null) {
                    divorcio.getReq_6().setSelected(true);
                } else {
                    divorcio.getReq_6().setSelected(false);
                }
                divorcio.getTxa_observ().setText(List_caso.get(i).getObservacion());
            }
        }
    }

    public void Validar_Guardar_Modificar() {

        List<Buf_Caso_Divorcio> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(divorcio.getTxt_cedula().getText())) {
                divorcio.getBtn_guardar().setEnabled(true);
                divorcio.getBtn_modificar().setEnabled(false);
            } else if (!List_caso.get(i).getCedula().equals(divorcio.getTxt_cedula().getText())) {
                divorcio.getBtn_guardar().setEnabled(false);
                divorcio.getBtn_modificar().setEnabled(true);
            }
        }

        if (List_caso.isEmpty()) {
            divorcio.getBtn_guardar().setEnabled(true);
            divorcio.getBtn_modificar().setEnabled(false);
        }
    }

    public void Modificar_Requisitos() {

        //REQUISITO #1
        File ruta = new File(rutas);

        try {
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            D.setReq_1(icono);
        } catch (Exception ex) {
            D.setReq_1(null);
        }

        //REQUISITO #2
        File ruta_2 = new File(rutas_2);

        try {
            byte[] icono = new byte[(int) ruta_2.length()];
            InputStream input = new FileInputStream(ruta_2);
            input.read(icono);
            D.setReq_2(icono);
        } catch (Exception ex) {
            D.setReq_2(null);
        }

        //REQUISITO #3
        File ruta_3 = new File(rutas_3);

        try {
            byte[] icono = new byte[(int) ruta_3.length()];
            InputStream input = new FileInputStream(ruta_3);
            input.read(icono);
            D.setReq_3(icono);
        } catch (Exception ex) {
            D.setReq_3(null);
        }

        //REQUISITO #4
        File ruta_4 = new File(rutas_4);

        try {
            byte[] icono = new byte[(int) ruta_4.length()];
            InputStream input = new FileInputStream(ruta_4);
            input.read(icono);
            D.setReq_4(icono);
        } catch (Exception ex) {
            D.setReq_4(null);
        }

        //REQUISITO #5
        File ruta_5 = new File(rutas_5);

        try {
            byte[] icono = new byte[(int) ruta_5.length()];
            InputStream input = new FileInputStream(ruta_5);
            input.read(icono);
            D.setReq_5(icono);
        } catch (Exception ex) {
            D.setReq_5(null);
        }

        //REQUISITO #6
        File ruta_6 = new File(rutas_6);

        try {
            byte[] icono = new byte[(int) ruta_6.length()];
            InputStream input = new FileInputStream(ruta_6);
            input.read(icono);
            D.setReq_6(icono);
        } catch (Exception ex) {
            D.setReq_6(null);
        }

        int honorarios = 200;

        D.setHonorarios(honorarios);
        D.setObservacion(divorcio.getTxa_observ().getText());
        D.setId_caso(Integer.parseInt(divorcio.getTxt_id().getText()));
        if (D_DB.Update(D)) {

            JOptionPane.showMessageDialog(null, "Registro Actualizado");
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void Abrir_Pago() {

        V_Pago pa = new V_Pago();
        C_Pago p = new C_Pago(pa);
        V_Menu_Inicio.escritorio.add(pa);
        pa.show();
        List<Buf_Caso_Divorcio> List_caso = D_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(divorcio.getTxt_cedula().getText())) {
                pa.getTxt_cedula().setText(divorcio.getTxt_cedula().getText());
                pa.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                for (int j = 0; j < List_caso.size(); j++) {
                    if (List_caso.get(j).getId_caso() != Integer.parseInt(divorcio.getTxt_id().getText())) {
                        pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                    }
                }
            }
        }
        p.Iniciar_Control();
        divorcio.setVisible(false);
    }
}
