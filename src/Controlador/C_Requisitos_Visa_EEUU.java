/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso_Visa_EEUU;
import Modelo.Buf_Caso_Visa_EEUUDB;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.V_Requisitos_Visa_EEUU;
import Modelo.Buf_Pagos;
import Modelo.Buf_PagosDB;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import vista.V_Pago;
import vista.V_Menu_Inicio;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Visa_EEUU {

    V_Requisitos_Visa_EEUU reu;

    Buf_Caso_Visa_EEUUDB D_DB = new Buf_Caso_Visa_EEUUDB();
    Buf_Caso_Visa_EEUU D = new Buf_Caso_Visa_EEUU();
    Buf_PagosDB P_DB = new Buf_PagosDB();

    public File ruta;
    public File ruta_2;
    public File ruta_3;
    public File ruta_4;
    public File ruta_5;
    public File ruta_6;
    public File ruta_7;
    public File ruta_8;
    public File ruta_9;
    public File ruta_10;
    public File ruta_11;

    public String rutas;
    public String rutas_2;
    public String rutas_3;
    public String rutas_4;
    public String rutas_5;
    public String rutas_6;
    public String rutas_7;
    public String rutas_8;
    public String rutas_9;
    public String rutas_10;
    public String rutas_11;

    public C_Requisitos_Visa_EEUU(V_Requisitos_Visa_EEUU reu) {

        this.reu = reu;

        Num_Beneficiario();
        Campos();
    }

    public void Iniciar_Control() {

        reu.getBtn_guardar().addActionListener(l -> {
            Subir_Documento();
        });
        reu.getBtn_modificar().addActionListener(l -> {
            Modificar_Requisitos();
        });
        reu.getBtn_pago().addActionListener(l -> {
            Abrir_Pago();
        });
        reu.getBtn_cargar().addActionListener(l -> {
            Campo_Bloqueado();
            Validar_Guardar_Modificar();
            Cargar_Check();
        });
        reu.getReq_1().addActionListener(l -> {
            PDF_Req_1();
        });
        reu.getReq_2().addActionListener(l -> {
            PDF_Req_2();
        });
        reu.getReq_3().addActionListener(l -> {
            PDF_Req_3();
        });
        reu.getReq_4().addActionListener(l -> {
            PDF_Req_4();
        });
        reu.getReq_5().addActionListener(l -> {
            PDF_Req_5();
        });
        reu.getReq_6().addActionListener(l -> {
            PDF_Req_6();
        });
        reu.getReq_7().addActionListener(l -> {
            PDF_Req_7();
        });
        reu.getReq_8().addActionListener(l -> {
            PDF_Req_8();
        });
        reu.getReq_9().addActionListener(l -> {
            PDF_Req_9();
        });
        reu.getReq_10().addActionListener(l -> {
            PDF_Req_10();
        });
        reu.getReq_11().addActionListener(l -> {
            PDF_Req_11();
        });
    }

    public void PDF_Req_1() {

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
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

                                reu.getReq_1().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #1.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_1().isSelected()) {
                                reu.getReq_1().setSelected(true);
                                Cargar_Imagen();
                                reu.getReq_1().setSelected(true);
                            } else if (reu.getReq_1().isSelected()) {
                                Cargar_Imagen();
                            }
                        } else {
                            if (!reu.getReq_1().isSelected()) {
                                reu.getReq_1().setSelected(true);
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

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                reu.getReq_2().setSelected(true);
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #2.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_2().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #2.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Ningun Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_2().isSelected()) {
                                reu.getReq_2().setSelected(true);
                                Cargar_Imagen_2();
                                reu.getReq_2().setSelected(true);
                            } else if (reu.getReq_2().isSelected()) {
                                Cargar_Imagen_2();
                            }
                        } else {
                            if (!reu.getReq_2().isSelected()) {
                                reu.getReq_2().setSelected(true);
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

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                reu.getReq_3().setSelected(true);
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #3.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_3().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #3.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_3().isSelected()) {
                                reu.getReq_3().setSelected(true);
                                Cargar_Imagen_3();
                                reu.getReq_3().setSelected(true);
                            } else if (reu.getReq_3().isSelected()) {
                                Cargar_Imagen_3();
                            }
                        } else {
                            if (!reu.getReq_3().isSelected()) {
                                reu.getReq_3().setSelected(true);
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

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                reu.getReq_4().setSelected(true);
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #4.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_4().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #4.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_4().isSelected()) {
                                reu.getReq_4().setSelected(true);
                                Cargar_Imagen_4();
                                reu.getReq_4().setSelected(true);
                            } else if (reu.getReq_4().isSelected()) {
                                Cargar_Imagen_4();
                            }
                        } else {
                            if (!reu.getReq_4().isSelected()) {
                                reu.getReq_4().setSelected(true);
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

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                reu.getReq_5().setSelected(true);
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #5.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_5().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #5.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_5().isSelected()) {
                                reu.getReq_5().setSelected(true);
                                Cargar_Imagen_5();
                                reu.getReq_5().setSelected(true);
                            } else if (reu.getReq_5().isSelected()) {
                                Cargar_Imagen_5();
                            }
                        } else {
                            if (!reu.getReq_5().isSelected()) {
                                reu.getReq_5().setSelected(true);
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

    public void PDF_Req_6() {

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_6();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                reu.getReq_6().setSelected(true);
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #6.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_6().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #6.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_6().isSelected()) {
                                reu.getReq_6().setSelected(true);
                                Cargar_Imagen_6();
                                reu.getReq_6().setSelected(true);
                            } else if (reu.getReq_6().isSelected()) {
                                Cargar_Imagen_6();
                            }
                        } else {
                            if (!reu.getReq_6().isSelected()) {
                                reu.getReq_6().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_6();
                }
            }
        } else {
            Cargar_Imagen_6();
        }
    }

    public void PDF_Req_7() {

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_7();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #7.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_7().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #7.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_7().isSelected()) {
                                reu.getReq_7().setSelected(true);
                                Cargar_Imagen_7();
                                reu.getReq_7().setSelected(true);
                            } else if (reu.getReq_7().isSelected()) {
                                Cargar_Imagen_7();
                            }
                        } else {
                            if (!reu.getReq_7().isSelected()) {
                                reu.getReq_7().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_7();
                }
            }
        } else {
            Cargar_Imagen_7();
        }
    }

    public void PDF_Req_8() {

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_8();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #8.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_8().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #8.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_8().isSelected()) {
                                reu.getReq_8().setSelected(true);
                                Cargar_Imagen_8();
                                reu.getReq_8().setSelected(true);
                            } else if (reu.getReq_8().isSelected()) {
                                Cargar_Imagen_8();
                            }
                        } else {
                            if (!reu.getReq_8().isSelected()) {
                                reu.getReq_8().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_8();
                }
            }
        } else {
            Cargar_Imagen_8();
        }
    }

    public void PDF_Req_9() {

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_9();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #9.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_9().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #9.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_9().isSelected()) {
                                reu.getReq_9().setSelected(true);
                                Cargar_Imagen_9();
                                reu.getReq_9().setSelected(true);
                            } else if (reu.getReq_9().isSelected()) {
                                Cargar_Imagen_9();
                            }
                        } else {
                            if (!reu.getReq_9().isSelected()) {
                                reu.getReq_9().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_9();
                }
            }
        } else {
            Cargar_Imagen_9();
        }
    }

    public void PDF_Req_10() {

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_10();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #10.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_10().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #10.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_10().isSelected()) {
                                reu.getReq_10().setSelected(true);
                                Cargar_Imagen_10();
                                reu.getReq_10().setSelected(true);
                            } else if (reu.getReq_10().isSelected()) {
                                Cargar_Imagen_10();
                            }
                        } else {
                            if (!reu.getReq_10().isSelected()) {
                                reu.getReq_10().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_10();
                }
            }
        } else {
            Cargar_Imagen_10();
        }
    }

    public void PDF_Req_11() {

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_11();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("REQUISITO #11.pdf");
                                out.write(datosPDF);
                                out.close();

                                reu.getReq_11().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("REQUISITO #11.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!reu.getReq_11().isSelected()) {
                                reu.getReq_11().setSelected(true);
                                Cargar_Imagen_11();
                                reu.getReq_11().setSelected(true);
                            } else if (reu.getReq_11().isSelected()) {
                                Cargar_Imagen_11();
                            }
                        } else {
                            if (!reu.getReq_11().isSelected()) {
                                reu.getReq_11().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_11();
                }
            }
        } else {
            Cargar_Imagen_11();
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
            reu.getReq_1().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
            reu.getReq_1().setSelected(true);
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
            reu.getReq_2().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_2 = j.getSelectedFile();
            rutas_2 = String.valueOf(ruta_2);
            reu.getReq_2().setSelected(true);
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
            reu.getReq_3().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_3 = j.getSelectedFile();
            rutas_3 = String.valueOf(ruta_3);
            reu.getReq_3().setSelected(true);
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
            reu.getReq_4().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_4 = j.getSelectedFile();
            rutas_4 = String.valueOf(ruta_4);
            reu.getReq_4().setSelected(true);
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
            reu.getReq_5().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_5 = j.getSelectedFile();
            rutas_5 = String.valueOf(ruta_5);
            reu.getReq_5().setSelected(true);
        }
    }

    public void Cargar_Imagen_6() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            reu.getReq_6().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_6 = j.getSelectedFile();
            rutas_6 = String.valueOf(ruta_6);
            reu.getReq_6().setSelected(true);
        }
    }

    public void Cargar_Imagen_7() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            reu.getReq_7().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_7 = j.getSelectedFile();
            rutas_7 = String.valueOf(ruta_7);
            reu.getReq_7().setSelected(true);
        }
    }

    public void Cargar_Imagen_8() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            reu.getReq_8().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_8 = j.getSelectedFile();
            rutas_8 = String.valueOf(ruta_8);
            reu.getReq_8().setSelected(true);
        }
    }

    public void Cargar_Imagen_9() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            reu.getReq_9().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_9 = j.getSelectedFile();
            rutas_9 = String.valueOf(ruta_9);
            reu.getReq_9().setSelected(true);
        }
    }

    public void Cargar_Imagen_10() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            reu.getReq_10().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_10 = j.getSelectedFile();
            rutas_10 = String.valueOf(ruta_10);
            reu.getReq_10().setSelected(true);
        }
    }

    public void Cargar_Imagen_11() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            reu.getReq_11().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_11 = j.getSelectedFile();
            rutas_11 = String.valueOf(ruta_11);
            reu.getReq_11().setSelected(true);
        }
    }

    public void Num_Beneficiario() {

        reu.getCb_numper().addItem("Seleccionar");
        reu.getCb_numper().addItem("1");
        reu.getCb_numper().addItem("2");
        reu.getCb_numper().addItem("3");
        reu.getCb_numper().addItem("4");
    }

    public void Campo_Bloqueado() {

        reu.getTxt_id().setEditable(false);
        reu.getTxt_cedula().setEditable(false);
        reu.getBtn_guardar().setEnabled(true);
        reu.getBtn_modificar().setEnabled(true);
        reu.getBtn_pago().setEnabled(true);
        reu.getBtn_cargar().setEnabled(false);
        reu.getReq_1().setEnabled(true);
        reu.getReq_2().setEnabled(true);
        reu.getReq_3().setEnabled(true);
        reu.getReq_4().setEnabled(true);
        reu.getReq_5().setEnabled(true);
        reu.getReq_6().setEnabled(true);
        reu.getReq_7().setEnabled(true);
        reu.getReq_8().setEnabled(true);
        reu.getReq_9().setEnabled(true);
        reu.getReq_10().setEnabled(true);
        reu.getReq_11().setEnabled(true);
        reu.getCb_numper().setEnabled(true);
        reu.getTxa_observ().setEnabled(true);
    }

    public void Campos() {

        reu.getTxt_id().setEditable(false);
        reu.getTxt_cedula().setEditable(false);
        reu.getBtn_guardar().setEnabled(false);
        reu.getBtn_modificar().setEnabled(false);
        reu.getBtn_pago().setEnabled(false);
        reu.getBtn_cargar().setEnabled(true);
        reu.getReq_1().setEnabled(false);
        reu.getReq_2().setEnabled(false);
        reu.getReq_3().setEnabled(false);
        reu.getReq_4().setEnabled(false);
        reu.getReq_5().setEnabled(false);
        reu.getReq_6().setEnabled(false);
        reu.getReq_7().setEnabled(false);
        reu.getReq_8().setEnabled(false);
        reu.getReq_9().setEnabled(false);
        reu.getReq_10().setEnabled(false);
        reu.getReq_11().setEnabled(false);
        reu.getCb_numper().setEnabled(false);
        reu.getTxa_observ().setEnabled(false);
    }

    public void Subir_Documento() {

        String num_beneficiarios = (String) reu.getCb_numper().getSelectedItem();

        if (!num_beneficiarios.equals("Seleccionar")) {
            D.setId_caso(Integer.parseInt(reu.getTxt_id().getText()));
            D.setCedula(reu.getTxt_cedula().getText());

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

            //REQUISITO #6
            if (ruta_6 != null) {
                File ruta_6 = new File(rutas_6);

                try {
                    byte[] icono = new byte[(int) ruta_6.length()];
                    InputStream input = new FileInputStream(ruta_6);
                    input.read(icono);
                    D.setReq_6(icono);
                } catch (Exception ex) {
                    D.setReq_6(null);
                }
            }

            //REQUISITO #7
            if (ruta_7 != null) {
                File ruta_7 = new File(rutas_7);

                try {
                    byte[] icono = new byte[(int) ruta_7.length()];
                    InputStream input = new FileInputStream(ruta_7);
                    input.read(icono);
                    D.setReq_7(icono);
                } catch (Exception ex) {
                    D.setReq_7(null);
                }
            }

            //REQUISITO #8
            if (ruta_8 != null) {
                File ruta_8 = new File(rutas_8);

                try {
                    byte[] icono = new byte[(int) ruta_8.length()];
                    InputStream input = new FileInputStream(ruta_8);
                    input.read(icono);
                    D.setReq_8(icono);
                } catch (Exception ex) {
                    D.setReq_8(null);
                }
            }

            //REQUISITO #9
            if (ruta_9 != null) {
                File ruta_9 = new File(rutas_9);

                try {
                    byte[] icono = new byte[(int) ruta_9.length()];
                    InputStream input = new FileInputStream(ruta_9);
                    input.read(icono);
                    D.setReq_9(icono);
                } catch (Exception ex) {
                    D.setReq_9(null);
                }
            }

            //REQUISITO #10
            if (ruta_10 != null) {
                File ruta_10 = new File(rutas_10);

                try {
                    byte[] icono = new byte[(int) ruta_10.length()];
                    InputStream input = new FileInputStream(ruta_10);
                    input.read(icono);
                    D.setReq_10(icono);
                } catch (Exception ex) {
                    D.setReq_10(null);
                }
            }

            //REQUISITO #11
            if (ruta_11 != null) {
                File ruta_11 = new File(rutas_11);

                try {
                    byte[] icono = new byte[(int) ruta_11.length()];
                    InputStream input = new FileInputStream(ruta_11);
                    input.read(icono);
                    D.setReq_11(icono);
                } catch (Exception ex) {
                    D.setReq_11(null);
                }
            }

            int honorarios = 250 * Integer.parseInt(num_beneficiarios);
            D.setHonorarios(honorarios);

            D.setNum_beneficiarios(Integer.parseInt(num_beneficiarios));

            D.setObservacion(reu.getTxa_observ().getText());
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

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                try {
                    byte[] bi = List_caso.get(i).getReq_1();
                    if (bi != null) {
                        reu.getReq_1().setSelected(true);
                        D.setReq_1(bi);
                    } else if (bi == null) {
                        reu.getReq_1().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_2();
                    if (bi != null) {
                        reu.getReq_2().setSelected(true);
                        D.setReq_2(bi);
                    } else if (bi == null) {
                        reu.getReq_2().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_3();
                    if (bi != null) {
                        reu.getReq_3().setSelected(true);
                        D.setReq_3(bi);
                    } else if (bi == null) {
                        reu.getReq_3().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_4();
                    if (bi != null) {
                        reu.getReq_4().setSelected(true);
                        D.setReq_4(bi);
                    } else if (bi == null) {
                        reu.getReq_4().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_5();
                    if (bi != null) {
                        reu.getReq_5().setSelected(true);
                        D.setReq_5(bi);
                    } else if (bi == null) {
                        reu.getReq_5().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_6();
                    if (bi != null) {
                        reu.getReq_6().setSelected(true);
                        D.setReq_6(bi);
                    } else if (bi == null) {
                        reu.getReq_6().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_7();
                    if (bi != null) {
                        reu.getReq_7().setSelected(true);
                        D.setReq_7(bi);
                    } else if (bi == null) {
                        reu.getReq_7().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_8();
                    if (bi != null) {
                        reu.getReq_8().setSelected(true);
                        D.setReq_8(bi);
                    } else if (bi == null) {
                        reu.getReq_8().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_9();
                    if (bi != null) {
                        reu.getReq_9().setSelected(true);
                        D.setReq_9(bi);
                    } else if (bi == null) {
                        reu.getReq_9().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_10();
                    if (bi != null) {
                        reu.getReq_10().setSelected(true);
                        D.setReq_10(bi);
                    } else if (bi == null) {
                        reu.getReq_10().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_11();
                    if (bi != null) {
                        reu.getReq_11().setSelected(true);
                        D.setReq_11(bi);
                    } else if (bi == null) {
                        reu.getReq_11().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                reu.getCb_numper().setSelectedItem(String.valueOf(List_caso.get(i).getNum_beneficiarios()));
                reu.getTxa_observ().setText(List_caso.get(i).getObservacion());
            }
        }
    }

    public void Validar_Guardar_Modificar() {

        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (!List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                reu.getBtn_guardar().setEnabled(true);
                reu.getBtn_modificar().setEnabled(false);
            } else if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                reu.getBtn_guardar().setEnabled(false);
                reu.getBtn_modificar().setEnabled(true);
                reu.getCb_numper().setEnabled(false);
            }
        }

        if (List_caso.isEmpty()) {
            reu.getBtn_guardar().setEnabled(true);
            reu.getBtn_modificar().setEnabled(false);
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

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_1();
                        if (bi != null) {
                            reu.getReq_1().setSelected(true);
                            D.setReq_1(bi);
                        } else if (bi == null) {
                            reu.getReq_1().setSelected(false);
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

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        if (bi != null) {
                            reu.getReq_2().setSelected(true);
                            D.setReq_2(bi);
                        } else if (bi == null) {
                            reu.getReq_2().setSelected(false);
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

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        if (bi != null) {
                            reu.getReq_3().setSelected(true);
                            D.setReq_3(bi);
                        } else if (bi == null) {
                            reu.getReq_3().setSelected(false);
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

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        if (bi != null) {
                            reu.getReq_4().setSelected(true);
                            D.setReq_4(bi);
                        } else if (bi == null) {
                            reu.getReq_4().setSelected(false);
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

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        if (bi != null) {
                            reu.getReq_5().setSelected(true);
                            D.setReq_5(bi);
                        } else if (bi == null) {
                            reu.getReq_5().setSelected(false);
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
                D.setReq_6(icono);
            } catch (Exception ex) {
                D.setReq_6(null);
            }
        } else {

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_6();
                        if (bi != null) {
                            reu.getReq_6().setSelected(true);
                            D.setReq_6(bi);
                        } else if (bi == null) {
                            reu.getReq_6().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #7
        if (ruta_7 != null) {
            File ruta_7 = new File(rutas_7);

            try {
                byte[] icono = new byte[(int) ruta_7.length()];
                InputStream input = new FileInputStream(ruta_7);
                input.read(icono);
                D.setReq_7(icono);
            } catch (Exception ex) {
                D.setReq_7(null);
            }
        } else {

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_7();
                        if (bi != null) {
                            reu.getReq_7().setSelected(true);
                            D.setReq_7(bi);
                        } else if (bi == null) {
                            reu.getReq_7().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #8
        if (ruta_8 != null) {
            File ruta_8 = new File(rutas_8);

            try {
                byte[] icono = new byte[(int) ruta_8.length()];
                InputStream input = new FileInputStream(ruta_8);
                input.read(icono);
                D.setReq_8(icono);
            } catch (Exception ex) {
                D.setReq_8(null);
            }
        } else {

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_8();
                        if (bi != null) {
                            reu.getReq_8().setSelected(true);
                            D.setReq_8(bi);
                        } else if (bi == null) {
                            reu.getReq_8().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #9
        if (ruta_9 != null) {
            File ruta_9 = new File(rutas_9);

            try {
                byte[] icono = new byte[(int) ruta_9.length()];
                InputStream input = new FileInputStream(ruta_9);
                input.read(icono);
                D.setReq_9(icono);
            } catch (Exception ex) {
                D.setReq_9(null);
            }
        } else {

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_9();
                        if (bi != null) {
                            reu.getReq_9().setSelected(true);
                            D.setReq_9(bi);
                        } else if (bi == null) {
                            reu.getReq_9().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #10
        if (ruta_10 != null) {
            File ruta_10 = new File(rutas_10);

            try {
                byte[] icono = new byte[(int) ruta_10.length()];
                InputStream input = new FileInputStream(ruta_10);
                input.read(icono);
                D.setReq_10(icono);
            } catch (Exception ex) {
                D.setReq_10(null);
            }
        } else {

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_10();
                        if (bi != null) {
                            reu.getReq_10().setSelected(true);
                            D.setReq_10(bi);
                        } else if (bi == null) {
                            reu.getReq_10().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //REQUISITO #11
        if (ruta_11 != null) {
            File ruta_11 = new File(rutas_11);

            try {
                byte[] icono = new byte[(int) ruta_11.length()];
                InputStream input = new FileInputStream(ruta_11);
                input.read(icono);
                D.setReq_11(icono);
            } catch (Exception ex) {
                D.setReq_11(null);
            }
        } else {

            List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_11();
                        if (bi != null) {
                            reu.getReq_11().setSelected(true);
                            D.setReq_11(bi);
                        } else if (bi == null) {
                            reu.getReq_11().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        D.setObservacion(reu.getTxa_observ().getText());
        D.setId_caso(Integer.parseInt(reu.getTxt_id().getText()));
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
        List<Buf_Caso_Visa_EEUU> List_caso = D_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(reu.getTxt_cedula().getText())) {
                pa.getTxt_cedula().setText(reu.getTxt_cedula().getText());
                pa.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                if (!List_pago.isEmpty()) {
                    for (int j = 0; j < List_pago.size(); j++) {
                        if (List_pago.get(j).getId_caso() != Integer.parseInt(reu.getTxt_id().getText())) {
                            pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                        }
                    }
                } else {
                    pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                }
            }
        }
        p.Iniciar_Control();
        reu.setVisible(false);
    }
}
