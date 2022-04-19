/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso_Visa_Mexico;
import Modelo.Buf_Caso_Visa_MexicoDB;
import javax.swing.JOptionPane;
import vista.V_Requisitos_Visa_Mexico;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import Modelo.Buf_Pagos;
import Modelo.Buf_PagosDB;
import vista.V_Pago;
import vista.V_Menu_Inicio;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Visa_Mexico {

    V_Requisitos_Visa_Mexico mexico;

    Buf_Caso_Visa_MexicoDB D_DB = new Buf_Caso_Visa_MexicoDB();
    Buf_Caso_Visa_Mexico D = new Buf_Caso_Visa_Mexico();
    Buf_PagosDB P_DB = new Buf_PagosDB();

    public File ruta;
    public File ruta_2;
    public File ruta_3;
    public File ruta_4;
    public File ruta_5;

    public String rutas;
    public String rutas_2;
    public String rutas_3;
    public String rutas_4;
    public String rutas_5;

    public C_Requisitos_Visa_Mexico(V_Requisitos_Visa_Mexico mexico) {

        this.mexico = mexico;

        Num_Beneficiario();
        Campos();

    }

    public void Iniciar_Control() {

        mexico.getBtn_guardar().addActionListener(l -> {
            Subir_Documento();
        });
        mexico.getBtn_modificar().addActionListener(l -> {
            Modificar_Requisitos();
        });
        mexico.getBtn_pago().addActionListener(l -> {
            Abrir_Pago();
        });
        mexico.getBtn_cargar().addActionListener(l -> {
            Campo_Bloqueado();
            Validar_Guardar_Modificar();
            Cargar_Check();
        });
        mexico.getReq_1().addActionListener(l -> {
            PDF_Req_1();
        });
        mexico.getReq_2().addActionListener(l -> {
            PDF_Req_2();
        });
        mexico.getReq_3().addActionListener(l -> {
            PDF_Req_3();
        });
        mexico.getReq_4().addActionListener(l -> {
            PDF_Req_4();
        });
        mexico.getReq_5().addActionListener(l -> {
            PDF_Req_5();
        });
    }

    public void PDF_Req_1() {

        List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_1();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #1.pdf");
                                out.write(datosPDF);
                                out.close();

                                mexico.getReq_1().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #1.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else {
                            if (!mexico.getReq_1().isSelected()) {
                                mexico.getReq_1().setSelected(true);
                                Cargar_Imagen();
                                mexico.getReq_1().setSelected(true);
                            } else if (mexico.getReq_1().isSelected()) {
                                Cargar_Imagen();
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen();
                }
            }
        } else {
            Cargar_Imagen();
        }
    }

    public void PDF_Req_2() {

        List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #2.pdf");
                                out.write(datosPDF);
                                out.close();

                                mexico.getReq_2().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #2.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Ningun Requisito");
                            }
                        } else {
                            if (!mexico.getReq_2().isSelected()) {
                                mexico.getReq_2().setSelected(true);
                                Cargar_Imagen_2();
                                mexico.getReq_2().setSelected(true);
                            } else if (mexico.getReq_2().isSelected()) {
                                Cargar_Imagen_2();
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_2();
                }
            }
        } else {
            Cargar_Imagen_2();
        }
    }

    public void PDF_Req_3() {

        List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #3.pdf");
                                out.write(datosPDF);
                                out.close();

                                mexico.getReq_3().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #3.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else {
                            if (!mexico.getReq_3().isSelected()) {
                                mexico.getReq_3().setSelected(true);
                                Cargar_Imagen_3();
                                mexico.getReq_3().setSelected(true);
                            } else if (mexico.getReq_3().isSelected()) {
                                Cargar_Imagen_3();
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_3();
                }
            }
        } else {
            Cargar_Imagen_3();
        }
    }

    public void PDF_Req_4() {

        List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #4.pdf");
                                out.write(datosPDF);
                                out.close();

                                mexico.getReq_4().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #4.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else {
                            if (!mexico.getReq_4().isSelected()) {
                                mexico.getReq_4().setSelected(true);
                                Cargar_Imagen_4();
                                mexico.getReq_4().setSelected(true);
                            } else if (mexico.getReq_4().isSelected()) {
                                Cargar_Imagen_4();
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_4();
                }
            }
        } else {
            Cargar_Imagen_4();
        }
    }

    public void PDF_Req_5() {

        List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #5.pdf");
                                out.write(datosPDF);
                                out.close();

                                mexico.getReq_5().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #5.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else {
                            if (!mexico.getReq_5().isSelected()) {
                                mexico.getReq_5().setSelected(true);
                                Cargar_Imagen_5();
                                mexico.getReq_5().setSelected(true);
                            } else if (mexico.getReq_5().isSelected()) {
                                Cargar_Imagen_5();
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_5();
                }
            }
        } else {
            Cargar_Imagen_5();
        }
    }

    public void Cargar_Imagen() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            mexico.getReq_1().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
            mexico.getReq_1().setSelected(true);
        }
    }

    public void Cargar_Imagen_2() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            mexico.getReq_2().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_2 = j.getSelectedFile();
            rutas_2 = String.valueOf(ruta_2);
            mexico.getReq_2().setSelected(true);
        }
    }

    public void Cargar_Imagen_3() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            mexico.getReq_3().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_3 = j.getSelectedFile();
            rutas_3 = String.valueOf(ruta_3);
            mexico.getReq_3().setSelected(true);
        }
    }

    public void Cargar_Imagen_4() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            mexico.getReq_4().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_4 = j.getSelectedFile();
            rutas_4 = String.valueOf(ruta_4);
            mexico.getReq_4().setSelected(true);
        }
    }

    public void Cargar_Imagen_5() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            mexico.getReq_5().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_5 = j.getSelectedFile();
            rutas_5 = String.valueOf(ruta_5);
            mexico.getReq_5().setSelected(true);
        }
    }

    public void Num_Beneficiario() {

        mexico.getCb_numper().addItem("Seleccionar");
        mexico.getCb_numper().addItem("1");
        mexico.getCb_numper().addItem("2");
        mexico.getCb_numper().addItem("3");
        mexico.getCb_numper().addItem("4");
    }

    public void Campo_Bloqueado() {

        mexico.getTxt_id().setEditable(false);
        mexico.getTxt_cedula().setEditable(false);
        mexico.getBtn_guardar().setEnabled(true);
        mexico.getBtn_modificar().setEnabled(true);
        mexico.getBtn_pago().setEnabled(true);
        mexico.getBtn_cargar().setEnabled(false);
        mexico.getReq_1().setEnabled(true);
        mexico.getReq_2().setEnabled(true);
        mexico.getReq_3().setEnabled(true);
        mexico.getReq_4().setEnabled(true);
        mexico.getReq_5().setEnabled(true);
        mexico.getCb_numper().setEnabled(true);
        mexico.getTxa_observ().setEnabled(true);
    }

    public void Campos() {

        mexico.getTxt_id().setEditable(false);
        mexico.getTxt_cedula().setEditable(false);
        mexico.getBtn_guardar().setEnabled(false);
        mexico.getBtn_modificar().setEnabled(false);
        mexico.getBtn_pago().setEnabled(false);
        mexico.getBtn_cargar().setEnabled(true);
        mexico.getReq_1().setEnabled(false);
        mexico.getReq_2().setEnabled(false);
        mexico.getReq_3().setEnabled(false);
        mexico.getReq_4().setEnabled(false);
        mexico.getReq_5().setEnabled(false);
        mexico.getCb_numper().setEnabled(false);
        mexico.getTxa_observ().setEnabled(false);
    }

    public void Subir_Documento() {

        String num_beneficiarios = (String) mexico.getCb_numper().getSelectedItem();

        if (!num_beneficiarios.equals("Seleccionar")) {
            D.setId_caso(Integer.parseInt(mexico.getTxt_id().getText()));
            D.setCedula(mexico.getTxt_cedula().getText());

            //REQUISITO #1
            if (ruta != null) {
                File ruta = new File(rutas);

                try {
                    byte[] icono = new byte[(int) ruta.length()];
                    InputStream input = new FileInputStream(ruta);
                    input.read(icono);
                    D.setReq_1(icono);
                } catch (Exception ex) {
                    D.setReq_1(null);
                }
            }

            //REQUISITO #2
            if (ruta_2 != null) {
                File ruta_2 = new File(rutas_2);

                try {
                    byte[] icono = new byte[(int) ruta_2.length()];
                    InputStream input = new FileInputStream(ruta_2);
                    input.read(icono);
                    D.setReq_2(icono);
                } catch (Exception ex) {
                    D.setReq_2(null);
                }
            }

            //REQUISITO #3
            if (ruta_3 != null) {
                File ruta_3 = new File(rutas_3);

                try {
                    byte[] icono = new byte[(int) ruta_3.length()];
                    InputStream input = new FileInputStream(ruta_3);
                    input.read(icono);
                    D.setReq_3(icono);
                } catch (Exception ex) {
                    D.setReq_3(null);
                }
            }

            //REQUISITO #4
            if (ruta_4 != null) {
                File ruta_4 = new File(rutas_4);

                try {
                    byte[] icono = new byte[(int) ruta_4.length()];
                    InputStream input = new FileInputStream(ruta_4);
                    input.read(icono);
                    D.setReq_4(icono);
                } catch (Exception ex) {
                    D.setReq_4(null);
                }
            }

            //REQUISITO #5
            if (ruta_5 != null) {
                File ruta_5 = new File(rutas_5);

                try {
                    byte[] icono = new byte[(int) ruta_5.length()];
                    InputStream input = new FileInputStream(ruta_5);
                    input.read(icono);
                    D.setReq_5(icono);
                } catch (Exception ex) {
                    D.setReq_5(null);
                }
            }

            int honorarios = 250 * Integer.parseInt(num_beneficiarios);
            D.setHonorarios(honorarios);

            D.setNum_beneficiarios(Integer.parseInt(num_beneficiarios));

            D.setObservacion(mexico.getTxa_observ().getText());
            if (D_DB.Register(D)) {

                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {

                JOptionPane.showMessageDialog(null, "Error al Guardar Los Datos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Elija en Numero de Beneficiarios", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void Cargar_Check() {

        List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                try {
                    byte[] bi = List_caso.get(i).getReq_1();
                    if (bi != null) {
                        mexico.getReq_1().setSelected(true);
                        D.setReq_1(bi);
                    } else if (bi == null) {
                        mexico.getReq_1().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_2();
                    if (bi != null) {
                        mexico.getReq_2().setSelected(true);
                        D.setReq_2(bi);
                    } else if (bi == null) {
                        mexico.getReq_2().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_3();
                    if (bi != null) {
                        mexico.getReq_3().setSelected(true);
                        D.setReq_3(bi);
                    } else if (bi == null) {
                        mexico.getReq_3().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_4();
                    if (bi != null) {
                        mexico.getReq_4().setSelected(true);
                        D.setReq_4(bi);
                    } else if (bi == null) {
                        mexico.getReq_4().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_5();
                    if (bi != null) {
                        mexico.getReq_5().setSelected(true);
                        D.setReq_5(bi);
                    } else if (bi == null) {
                        mexico.getReq_5().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                mexico.getCb_numper().setSelectedItem(String.valueOf(List_caso.get(i).getNum_beneficiarios()));
                mexico.getTxa_observ().setText(List_caso.get(i).getObservacion());
            }
        }
    }

    public void Validar_Guardar_Modificar() {

        List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (!List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                mexico.getBtn_guardar().setEnabled(true);
                mexico.getBtn_modificar().setEnabled(false);
            } else if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                mexico.getBtn_guardar().setEnabled(false);
                mexico.getBtn_modificar().setEnabled(true);
                mexico.getCb_numper().setEnabled(false);
            }
        }

        if (List_caso.isEmpty()) {
            mexico.getBtn_guardar().setEnabled(true);
            mexico.getBtn_modificar().setEnabled(false);
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
                D.setReq_1(icono);
            } catch (Exception ex) {
                D.setReq_1(null);
            }
        } else {

            List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_1();
                        if (bi != null) {
                            mexico.getReq_1().setSelected(true);
                            D.setReq_1(bi);
                        } else if (bi == null) {
                            mexico.getReq_1().setSelected(false);
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
                D.setReq_2(icono);
            } catch (Exception ex) {
                D.setReq_2(null);
            }
        } else {

            List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        if (bi != null) {
                            mexico.getReq_2().setSelected(true);
                            D.setReq_2(bi);
                        } else if (bi == null) {
                            mexico.getReq_2().setSelected(false);
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
                D.setReq_3(icono);
            } catch (Exception ex) {
                D.setReq_3(null);
            }
        } else {

            List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        if (bi != null) {
                            mexico.getReq_3().setSelected(true);
                            D.setReq_3(bi);
                        } else if (bi == null) {
                            mexico.getReq_3().setSelected(false);
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
                D.setReq_4(icono);
            } catch (Exception ex) {
                D.setReq_4(null);
            }
        } else {

            List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        if (bi != null) {
                            mexico.getReq_4().setSelected(true);
                            D.setReq_4(bi);
                        } else if (bi == null) {
                            mexico.getReq_4().setSelected(false);
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
                D.setReq_5(icono);
            } catch (Exception ex) {
                D.setReq_5(null);
            }
        } else {

            List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        if (bi != null) {
                            mexico.getReq_5().setSelected(true);
                            D.setReq_5(bi);
                        } else if (bi == null) {
                            mexico.getReq_5().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        D.setObservacion(mexico.getTxa_observ().getText());
        D.setId_caso(Integer.parseInt(mexico.getTxt_id().getText()));
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
        List<Buf_Caso_Visa_Mexico> List_caso = D_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(mexico.getTxt_cedula().getText())) {
                pa.getTxt_cedula().setText(mexico.getTxt_cedula().getText());
                pa.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                if (!List_pago.isEmpty()) {
                    for (int j = 0; j < List_pago.size(); j++) {
                        if (List_pago.get(j).getId_caso() != Integer.parseInt(mexico.getTxt_id().getText())) {
                            pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                        }
                    }
                } else {
                    pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                }
            }
        }
        p.Iniciar_Control();
        mexico.setVisible(false);
    }
}
