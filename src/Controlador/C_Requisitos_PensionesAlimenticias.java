/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso_Pension_Aliment;
import Modelo.Buf_Caso_Pension_AlimentDB;
import Modelo.Buf_Pagos;
import Modelo.Buf_PagosDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.V_Menu_Inicio;
import vista.V_Pago;
import vista.V_Requisitos_PensionesAlimenticias;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_PensionesAlimenticias implements ActionListener {

    V_Requisitos_PensionesAlimenticias rpa;

    Buf_Caso_Pension_AlimentDB PA_DB = new Buf_Caso_Pension_AlimentDB();
    Buf_Caso_Pension_Aliment PA = new Buf_Caso_Pension_Aliment();
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

    public C_Requisitos_PensionesAlimenticias(V_Requisitos_PensionesAlimenticias rpa) {
        this.rpa = rpa;

        Campos();
    }

    public void Iniciar_Control() {

        rpa.getBtn_guardar().addActionListener(l -> {
            Subir_Documento();
        });
        rpa.getBtn_modificar().addActionListener(l -> {
            Modificar_Requisitos();
        });
        rpa.getBtn_pago().addActionListener(l -> {
            Abrir_Pago();
        });
        rpa.getBtn_cargar().addActionListener(l -> {
            Campo_Bloqueado();
            Validar_Guardar_Modificar();
            Cargar_Check();
        });
        rpa.getReq_1().addActionListener(l -> {
            Cargar_Imagen();
        });
        rpa.getReq_2().addActionListener(l -> {
            Cargar_Imagen_2();
        });
        rpa.getReq_3().addActionListener(l -> {
            Cargar_Imagen_3();
        });
        rpa.getReq_4().addActionListener(l -> {
            Cargar_Imagen_4();
        });
        rpa.getReq_5().addActionListener(l -> {
            Cargar_Imagen_5();
        });
        rpa.getReq_6().addActionListener(l -> {
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

        if (!ruta_carpeta.exists()) {
            rpa.getReq_1().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
            rpa.getReq_1().setSelected(true);
        }
    }

    public void Cargar_Imagen_2() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            rpa.getReq_2().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_2 = j.getSelectedFile();
            rutas_2 = String.valueOf(ruta_2);
            rpa.getReq_2().setSelected(true);
        }
    }

    public void Cargar_Imagen_3() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            rpa.getReq_3().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_3 = j.getSelectedFile();
            rutas_3 = String.valueOf(ruta_3);
            rpa.getReq_3().setSelected(true);
        }
    }

    public void Cargar_Imagen_4() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            rpa.getReq_4().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_4 = j.getSelectedFile();
            rutas_4 = String.valueOf(ruta_4);
            rpa.getReq_4().setSelected(true);
        }
    }

    public void Cargar_Imagen_5() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            rpa.getReq_5().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_5 = j.getSelectedFile();
            rutas_5 = String.valueOf(ruta_5);
            rpa.getReq_5().setSelected(true);
        }
    }

    public void Cargar_Imagen_6() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            rpa.getReq_6().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_6 = j.getSelectedFile();
            rutas_6 = String.valueOf(ruta_6);
            rpa.getReq_6().setSelected(true);
        }
    }

    public void Campo_Bloqueado() {

        rpa.getTxt_id().setEditable(false);
        rpa.getTxt_cedula().setEditable(false);
        rpa.getBtn_guardar().setEnabled(true);
        rpa.getBtn_modificar().setEnabled(true);
        rpa.getBtn_pago().setEnabled(true);
        rpa.getBtn_cargar().setEnabled(false);
        rpa.getReq_1().setEnabled(true);
        rpa.getReq_2().setEnabled(true);
        rpa.getReq_3().setEnabled(true);
        rpa.getReq_4().setEnabled(true);
        rpa.getReq_5().setEnabled(true);
        rpa.getReq_6().setEnabled(true);
        rpa.getTxa_observ().setEnabled(true);
    }

    public void Campos() {

        rpa.getTxt_id().setEditable(false);
        rpa.getTxt_cedula().setEditable(false);
        rpa.getBtn_guardar().setEnabled(false);
        rpa.getBtn_modificar().setEnabled(false);
        rpa.getBtn_pago().setEnabled(false);
        rpa.getBtn_cargar().setEnabled(true);
        rpa.getReq_1().setEnabled(false);
        rpa.getReq_2().setEnabled(false);
        rpa.getReq_3().setEnabled(false);
        rpa.getReq_4().setEnabled(false);
        rpa.getReq_5().setEnabled(false);
        rpa.getReq_6().setEnabled(false);
        rpa.getTxa_observ().setEnabled(false);
    }

    public void Subir_Documento() {

        PA.setId_caso(Integer.parseInt(rpa.getTxt_id().getText()));
        PA.setCedula(rpa.getTxt_cedula().getText());

        //REQUISITO #1
        if (ruta != null) {
            File ruta = new File(rutas);

            try {
                byte[] icono = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(icono);
                PA.setReq_1(icono);
            } catch (Exception ex) {
                PA.setReq_1(null);
            }
        }

        //REQUISITO #2
        if (ruta_2 != null) {
            File ruta_2 = new File(rutas_2);

            try {
                byte[] icono = new byte[(int) ruta_2.length()];
                InputStream input = new FileInputStream(ruta_2);
                input.read(icono);
                PA.setReq_2(icono);
            } catch (Exception ex) {
                PA.setReq_2(null);
            }
        }

        //REQUISITO #3
        if (ruta_3 != null) {
            File ruta_3 = new File(rutas_3);

            try {
                byte[] icono = new byte[(int) ruta_3.length()];
                InputStream input = new FileInputStream(ruta_3);
                input.read(icono);
                PA.setReq_3(icono);
            } catch (Exception ex) {
                PA.setReq_3(null);
            }
        }

        //REQUISITO #4
        if (ruta_4 != null) {
            File ruta_4 = new File(rutas_4);

            try {
                byte[] icono = new byte[(int) ruta_4.length()];
                InputStream input = new FileInputStream(ruta_4);
                input.read(icono);
                PA.setReq_4(icono);
            } catch (Exception ex) {
                PA.setReq_4(null);
            }
        }

        //REQUISITO #5
        if (ruta_5 != null) {
            File ruta_5 = new File(rutas_5);

            try {
                byte[] icono = new byte[(int) ruta_5.length()];
                InputStream input = new FileInputStream(ruta_5);
                input.read(icono);
                PA.setReq_5(icono);
            } catch (Exception ex) {
                PA.setReq_5(null);
            }
        }

        //REQUISITO #6
        if (ruta_6 != null) {
            File ruta_6 = new File(rutas_6);

            try {
                byte[] icono = new byte[(int) ruta_6.length()];
                InputStream input = new FileInputStream(ruta_6);
                input.read(icono);
                PA.setReq_6(icono);
            } catch (Exception ex) {
                PA.setReq_6(null);
            }
        }

        int honorarios = 250;
        PA.setHonorarios(honorarios);
        PA.setObservacion(rpa.getTxa_observ().getText());
        if (PA_DB.Register(PA)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } else {

            JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void Cargar_Check() {

        List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                try {
                    byte[] bi = List_caso.get(i).getReq_1();
                    if (bi != null) {
                        rpa.getReq_1().setSelected(true);
                        PA.setReq_1(bi);
                    } else if (bi == null) {
                        rpa.getReq_1().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_2();
                    if (bi != null) {
                        rpa.getReq_2().setSelected(true);
                        PA.setReq_2(bi);
                    } else if (bi == null) {
                        rpa.getReq_2().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_3();
                    if (bi != null) {
                        rpa.getReq_3().setSelected(true);
                        PA.setReq_3(bi);
                    } else if (bi == null) {
                        rpa.getReq_3().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_4();
                    if (bi != null) {
                        rpa.getReq_4().setSelected(true);
                        PA.setReq_4(bi);
                    } else if (bi == null) {
                        rpa.getReq_4().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_5();
                    if (bi != null) {
                        rpa.getReq_5().setSelected(true);
                        PA.setReq_5(bi);
                    } else if (bi == null) {
                        rpa.getReq_5().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_6();
                    if (bi != null) {
                        rpa.getReq_6().setSelected(true);
                        PA.setReq_6(bi);
                    } else if (bi == null) {
                        rpa.getReq_6().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                rpa.getTxa_observ().setText(List_caso.get(i).getObservacion());
            }
        }
    }

    public void Validar_Guardar_Modificar() {

        List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (!List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                rpa.getBtn_guardar().setEnabled(true);
                rpa.getBtn_modificar().setEnabled(false);
            } else if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                rpa.getBtn_guardar().setEnabled(false);
                rpa.getBtn_modificar().setEnabled(true);
            }
        }

        if (List_caso.isEmpty()) {
            rpa.getBtn_guardar().setEnabled(true);
            rpa.getBtn_modificar().setEnabled(false);
        }
    }

    public void Modificar_Requisitos() {

        //REQUISITO #1
        if (ruta != null) {
            File ruta = new File(rutas);
            try {
                byte[] icono = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(icono);
                PA.setReq_1(icono);
            } catch (Exception ex) {
                PA.setReq_1(null);
            }
        } else {

            List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_1();
                        if (bi != null) {
                            rpa.getReq_1().setSelected(true);
                            PA.setReq_1(bi);
                        } else if (bi == null) {
                            rpa.getReq_1().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #2
        if (ruta_2 != null) {
            File ruta_2 = new File(rutas_2);

            try {
                byte[] icono = new byte[(int) ruta_2.length()];
                InputStream input = new FileInputStream(ruta_2);
                input.read(icono);
                PA.setReq_2(icono);
            } catch (Exception ex) {
                PA.setReq_2(null);
            }
        } else {

            List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        if (bi != null) {
                            rpa.getReq_2().setSelected(true);
                            PA.setReq_2(bi);
                        } else if (bi == null) {
                            rpa.getReq_2().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #3
        if (ruta_3 != null) {
            File ruta_3 = new File(rutas_3);

            try {
                byte[] icono = new byte[(int) ruta_3.length()];
                InputStream input = new FileInputStream(ruta_3);
                input.read(icono);
                PA.setReq_3(icono);
            } catch (Exception ex) {
                PA.setReq_3(null);
            }
        } else {

            List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        if (bi != null) {
                            rpa.getReq_3().setSelected(true);
                            PA.setReq_3(bi);
                        } else if (bi == null) {
                            rpa.getReq_3().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #4
        if (ruta_4 != null) {
            File ruta_4 = new File(rutas_4);

            try {
                byte[] icono = new byte[(int) ruta_4.length()];
                InputStream input = new FileInputStream(ruta_4);
                input.read(icono);
                PA.setReq_4(icono);
            } catch (Exception ex) {
                PA.setReq_4(null);
            }
        } else {

            List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        if (bi != null) {
                            rpa.getReq_4().setSelected(true);
                            PA.setReq_4(bi);
                        } else if (bi == null) {
                            rpa.getReq_4().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #5
        if (ruta_5 != null) {
            File ruta_5 = new File(rutas_5);

            try {
                byte[] icono = new byte[(int) ruta_5.length()];
                InputStream input = new FileInputStream(ruta_5);
                input.read(icono);
                PA.setReq_5(icono);
            } catch (Exception ex) {
                PA.setReq_5(null);
            }
        } else {

            List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        if (bi != null) {
                            rpa.getReq_5().setSelected(true);
                            PA.setReq_5(bi);
                        } else if (bi == null) {
                            rpa.getReq_5().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #6
        if (ruta_6 != null) {
            File ruta_6 = new File(rutas_6);

            try {
                byte[] icono = new byte[(int) ruta_6.length()];
                InputStream input = new FileInputStream(ruta_6);
                input.read(icono);
                PA.setReq_6(icono);
            } catch (Exception ex) {
                PA.setReq_6(null);
            }
        } else {

            List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_6();
                        if (bi != null) {
                            rpa.getReq_6().setSelected(true);
                            PA.setReq_6(bi);
                        } else if (bi == null) {
                            rpa.getReq_6().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        int honorarios = 200;

        PA.setHonorarios(honorarios);
        PA.setObservacion(rpa.getTxa_observ().getText());
        PA.setId_caso(Integer.parseInt(rpa.getTxt_id().getText()));
        if (PA_DB.Update(PA)) {

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
        List<Buf_Caso_Pension_Aliment> List_caso = PA_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(rpa.getTxt_cedula().getText())) {
                pa.getTxt_cedula().setText(rpa.getTxt_cedula().getText());
                pa.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                for (int j = 0; j < List_caso.size(); j++) {
                    if (List_caso.get(j).getId_caso() != Integer.parseInt(rpa.getTxt_id().getText())) {
                        pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                    }
                }
            }
        }
        p.Iniciar_Control();
        rpa.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == rpa.getBtn_guardar()) {
            JOptionPane.showMessageDialog(null, "Requisitos Guardados");
            agregar();
            cargarcheck();
        }
        if (evt.getSource() == rpa.getBtn_modificar()) {
            modificarreq();
            cargarcheck();
        }
        if (evt.getSource() == rpa.getBtn_pago()) {
            Pago pa = new Pago(ced, ca);
            C_Pago pago = new C_Pago(pa);
            MenuInicio.escritorio.add(pa);
            pa.toFront();
            pa.setVisible(true);
            rpa.setVisible(false);
        }
        if (evt.getSource() == rpa.getReq_1()) {

        }
        if (evt.getSource() == rpa.getReq_2()) {

        }
        if (evt.getSource() == rpa.getReq_3()) {

        }
        if (evt.getSource() == rpa.getReq_4()) {

        }
        if (evt.getSource() == rpa.getReq_5()) {

        }
        if (evt.getSource() == rpa.getReq_6()) {

        }
    }

    public void cargarcheck() {
        for (int i = 0; i < listapensiones.size(); i++) {
            if (listapensiones.get(i).getCedula().equals(ced)) {
                if (listapensiones.get(i).getRq1() == null) {
                } else {
                    if (listapensiones.get(i).getRq1().equals("COPIA DE CEDULA")) {
                        rpa.getReq_1().setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq2() == null) {
                } else {
                    if (listapensiones.get(i).getRq2().equals("COPIA DE PAPEL DE VOTACION")) {
                        rpa.getReq_2().setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq3() == null) {
                } else {
                    if (listapensiones.get(i).getRq3().equals("PARTIDAS DE NACIMIENTO DEL NIÑO")) {
                        rpa.getReq_3().setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq4() == null) {
                } else {
                    if (listapensiones.get(i).getRq4().equals("DIRECCION DEL TRABAJO Y CASA DEL DEMANDADO")) {
                        rpa.getReq_4().setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq5() == null) {
                } else {
                    if (listapensiones.get(i).getRq5().equals("RECIBOS Y FACTURAS DE GASTOS")) {
                        rpa.getReq_5().setSelected(true);
                    }
                }
                if (listapensiones.get(i).getRq6() == null) {
                } else {
                    if (listapensiones.get(i).getRq6().equals("CERTIFICADO DE CONADIS SI TIENE DISCAPACIDAD")) {
                        rpa.getReq_6().setSelected(true);
                    }
                }
                obser = listapensiones.get(i).getObservaciones();
                rpa.observaciones.setText(obser);
            }
        }

    }

    public void modificarreq() {
        rpa.observaciones.setEditable(true);
        if (rpa.getReq_1().isSelected() == true) {
            r1 = rpa.getReq_1().getText();
        }
        if (rpa.getReq_2().isSelected() == true) {
            r2 = rpa.getReq_2().getText();
        }
        if (rpa.getReq_3().isSelected() == true) {
            r3 = rpa.getReq_3().getText();
        }
        if (rpa.getReq_4().isSelected() == true) {
            r4 = rpa.getReq_4().getText();
        }
        if (rpa.getReq_5().isSelected() == true) {
            r5 = rpa.getReq_5().getText();
        }
        if (rpa.getReq_6().isSelected() == true) {
            r6 = rpa.getReq_6().getText();
        }

        for (int i = 0; i < listapensiones.size(); i++) {
            if (listapensiones.get(i).getCedula().equals(ced)) {
                listapensiones.get(i).setRq1(r1);
                listapensiones.get(i).setRq2(r2);
                listapensiones.get(i).setRq3(r3);
                listapensiones.get(i).setRq4(r4);
                listapensiones.get(i).setRq5(r5);
                listapensiones.get(i).setRq6(r6);
                listapensiones.get(i).setObservaciones(rpa.observaciones.getText());
            }
        }

    }

}
