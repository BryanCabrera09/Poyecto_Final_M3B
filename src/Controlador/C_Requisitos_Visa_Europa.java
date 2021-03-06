/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso_Visa_Europa;
import Modelo.Buf_Caso_Visa_EuropaDB;
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
import javax.swing.JOptionPane;
import vista.V_Requisitos_Visa_Europa;
import Modelo.Buf_Pagos;
import Modelo.Buf_PagosDB;
import vista.V_Pago;
import vista.V_Menu_Inicio;

/*
 * @author BRYAN_CABreRA
 */
public class C_Requisitos_Visa_Europa {

    V_Requisitos_Visa_Europa re;

    Buf_Caso_Visa_EuropaDB D_DB = new Buf_Caso_Visa_EuropaDB();
    Buf_Caso_Visa_Europa D = new Buf_Caso_Visa_Europa();
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
    public File ruta_12;
    public File ruta_13;
    public File ruta_14;
    public File ruta_15;
    public File ruta_16;
    public File ruta_17;

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
    public String rutas_12;
    public String rutas_13;
    public String rutas_14;
    public String rutas_15;
    public String rutas_16;
    public String rutas_17;

    public C_Requisitos_Visa_Europa(V_Requisitos_Visa_Europa re) {

        this.re = re;

        Num_Beneficiario();
        Campos();
    }

    public void Iniciar_Control() {

        re.getBtn_guardar().addActionListener(l -> {
            Subir_Documento();
        });
        re.getBtn_modificar().addActionListener(l -> {
            Modificar_Requisitos();
        });
        re.getBtn_pago().addActionListener(l -> {
            Abrir_Pago();
        });
        re.getBtn_cargar().addActionListener(l -> {
            Campo_Bloqueado();
            Validar_Guardar_Modificar();
            Cargar_Check();
        });
        re.getReq_1().addActionListener(l -> {
            PDF_Req_1();
        });
        re.getReq_2().addActionListener(l -> {
            PDF_Req_2();
        });
        re.getReq_3().addActionListener(l -> {
            PDF_Req_3();
        });
        re.getReq_4().addActionListener(l -> {
            PDF_Req_4();
        });
        re.getReq_5().addActionListener(l -> {
            PDF_Req_5();
        });
        re.getReq_6().addActionListener(l -> {
            PDF_Req_6();
        });
        re.getReq_7().addActionListener(l -> {
            PDF_Req_7();
        });
        re.getReq_8().addActionListener(l -> {
            PDF_Req_8();
        });
        re.getReq_9().addActionListener(l -> {
            PDF_Req_9();
        });
        re.getReq_10().addActionListener(l -> {
            PDF_Req_10();
        });
        re.getReq_11().addActionListener(l -> {
            PDF_Req_11();
        });
        re.getReq_12().addActionListener(l -> {
            PDF_Req_12();
        });
        re.getReq_13().addActionListener(l -> {
            PDF_Req_13();
        });
        re.getReq_14().addActionListener(l -> {
            PDF_Req_14();
        });
        re.getReq_15().addActionListener(l -> {
            PDF_Req_15();
        });
        re.getReq_16().addActionListener(l -> {
            PDF_Req_16();
        });
        re.getReq_17().addActionListener(l -> {
            PDF_Req_17();
        });
    }

    public void PDF_Req_1() {

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #1.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_1().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #1.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_1().isSelected()) {
                                re.getReq_1().setSelected(true);
                                Cargar_Imagen();
                                re.getReq_1().setSelected(true);
                            } else if (re.getReq_1().isSelected()) {
                                Cargar_Imagen();
                            }
                        } else {
                            if (!re.getReq_1().isSelected()) {
                                re.getReq_1().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #2.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_2().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #2.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Ningun Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_2().isSelected()) {
                                re.getReq_2().setSelected(true);
                                Cargar_Imagen_2();
                                re.getReq_2().setSelected(true);
                            } else if (re.getReq_2().isSelected()) {
                                Cargar_Imagen_2();
                            }
                        } else {
                            if (!re.getReq_2().isSelected()) {
                                re.getReq_2().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #3.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_3().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #3.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_3().isSelected()) {
                                re.getReq_3().setSelected(true);
                                Cargar_Imagen_3();
                                re.getReq_3().setSelected(true);
                            } else if (re.getReq_3().isSelected()) {
                                Cargar_Imagen_3();
                            }
                        } else {
                            if (!re.getReq_3().isSelected()) {
                                re.getReq_3().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #4.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_4().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #4.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_4().isSelected()) {
                                re.getReq_4().setSelected(true);
                                Cargar_Imagen_4();
                                re.getReq_4().setSelected(true);
                            } else if (re.getReq_4().isSelected()) {
                                Cargar_Imagen_4();
                            }
                        } else {
                            if (!re.getReq_4().isSelected()) {
                                re.getReq_4().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #5.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_5().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #5.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_5().isSelected()) {
                                re.getReq_5().setSelected(true);
                                Cargar_Imagen_5();
                                re.getReq_5().setSelected(true);
                            } else if (re.getReq_5().isSelected()) {
                                Cargar_Imagen_5();
                            }
                        } else {
                            if (!re.getReq_5().isSelected()) {
                                re.getReq_5().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_6();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("reQUISITO #6.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_6().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #6.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_6().isSelected()) {
                                re.getReq_6().setSelected(true);
                                Cargar_Imagen_6();
                                re.getReq_6().setSelected(true);
                            } else if (re.getReq_6().isSelected()) {
                                Cargar_Imagen_6();
                            }
                        } else {
                            if (!re.getReq_6().isSelected()) {
                                re.getReq_6().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #7.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_7().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #7.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_7().isSelected()) {
                                re.getReq_7().setSelected(true);
                                Cargar_Imagen_7();
                                re.getReq_7().setSelected(true);
                            } else if (re.getReq_7().isSelected()) {
                                Cargar_Imagen_7();
                            }
                        } else {
                            if (!re.getReq_7().isSelected()) {
                                re.getReq_7().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #8.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_8().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #8.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_8().isSelected()) {
                                re.getReq_8().setSelected(true);
                                Cargar_Imagen_8();
                                re.getReq_8().setSelected(true);
                            } else if (re.getReq_8().isSelected()) {
                                Cargar_Imagen_8();
                            }
                        } else {
                            if (!re.getReq_8().isSelected()) {
                                re.getReq_8().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #9.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_9().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #9.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_9().isSelected()) {
                                re.getReq_9().setSelected(true);
                                Cargar_Imagen_9();
                                re.getReq_9().setSelected(true);
                            } else if (re.getReq_9().isSelected()) {
                                Cargar_Imagen_9();
                            }
                        } else {
                            if (!re.getReq_9().isSelected()) {
                                re.getReq_9().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #10.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_10().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #10.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_10().isSelected()) {
                                re.getReq_10().setSelected(true);
                                Cargar_Imagen_10();
                                re.getReq_10().setSelected(true);
                            } else if (re.getReq_10().isSelected()) {
                                Cargar_Imagen_10();
                            }
                        } else {
                            if (!re.getReq_10().isSelected()) {
                                re.getReq_10().setSelected(true);
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
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

                                OutputStream out = new FileOutputStream("reQUISITO #11.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_11().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #11.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_11().isSelected()) {
                                re.getReq_11().setSelected(true);
                                Cargar_Imagen_11();
                                re.getReq_11().setSelected(true);
                            } else if (re.getReq_11().isSelected()) {
                                Cargar_Imagen_11();
                            }
                        } else {
                            if (!re.getReq_11().isSelected()) {
                                re.getReq_11().setSelected(true);
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

    public void PDF_Req_12() {

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_12();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("reQUISITO #12.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_12().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #12.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_12().isSelected()) {
                                re.getReq_12().setSelected(true);
                                Cargar_Imagen_12();
                                re.getReq_12().setSelected(true);
                            } else if (re.getReq_12().isSelected()) {
                                Cargar_Imagen_12();
                            }
                        } else {
                            if (!re.getReq_12().isSelected()) {
                                re.getReq_12().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_12();
                }
            }
        } else {
            Cargar_Imagen_12();
        }
    }

    public void PDF_Req_13() {

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_13();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("reQUISITO #13.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_13().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #13.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_13().isSelected()) {
                                re.getReq_13().setSelected(true);
                                Cargar_Imagen_13();
                                re.getReq_13().setSelected(true);
                            } else if (re.getReq_13().isSelected()) {
                                Cargar_Imagen_13();
                            }
                        } else {
                            if (!re.getReq_13().isSelected()) {
                                re.getReq_13().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_13();
                }
            }
        } else {
            Cargar_Imagen_13();
        }
    }

    public void PDF_Req_14() {

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_14();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("reQUISITO #14.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_14().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #14.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_14().isSelected()) {
                                re.getReq_14().setSelected(true);
                                Cargar_Imagen_14();
                                re.getReq_14().setSelected(true);
                            } else if (re.getReq_14().isSelected()) {
                                Cargar_Imagen_14();
                            }
                        } else {
                            if (!re.getReq_14().isSelected()) {
                                re.getReq_14().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_14();
                }
            }
        } else {
            Cargar_Imagen_14();
        }
    }

    public void PDF_Req_15() {

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_15();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("reQUISITO #15.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_15().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #15.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_15().isSelected()) {
                                re.getReq_15().setSelected(true);
                                Cargar_Imagen_15();
                                re.getReq_15().setSelected(true);
                            } else if (re.getReq_15().isSelected()) {
                                Cargar_Imagen_15();
                            }
                        } else {
                            if (!re.getReq_15().isSelected()) {
                                re.getReq_15().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_15();
                }
            }
        } else {
            Cargar_Imagen_15();
        }
    }

    public void PDF_Req_16() {

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_16();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("reQUISITO #16.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_16().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #16.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_16().isSelected()) {
                                re.getReq_16().setSelected(true);
                                Cargar_Imagen_16();
                                re.getReq_16().setSelected(true);
                            } else if (re.getReq_16().isSelected()) {
                                Cargar_Imagen_16();
                            }
                        } else {
                            if (!re.getReq_16().isSelected()) {
                                re.getReq_16().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_16();
                }
            }
        } else {
            Cargar_Imagen_16();
        }
    }

    public void PDF_Req_17() {

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        if (!List_caso.isEmpty()) {
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_17();
                        Object[] options = {"Actualizar/Registrar", "Ver Requisito"};
                        int opcion = JOptionPane.showOptionDialog(null, "Elija Una Accion A Realzar", "Actualizar - Vizualizar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if (opcion == 1) {
                            if (bi != null) {
                                InputStream bos = new ByteArrayInputStream(bi);

                                int tamanoInput = bos.available();
                                byte[] datosPDF = new byte[tamanoInput];
                                bos.read(datosPDF, 0, tamanoInput);

                                OutputStream out = new FileOutputStream("reQUISITO #17.pdf");
                                out.write(datosPDF);
                                out.close();

                                re.getReq_17().setSelected(true);
                                try {
                                    Desktop.getDesktop().open(new File("reQUISITO #17.pdf"));
                                } catch (Exception ex) {
                                }
                            } else if (bi == null) {
                                JOptionPane.showMessageDialog(null, "No Se Ha Cargado Un Requisito");
                            }
                        } else if (opcion == 0) {
                            if (!re.getReq_17().isSelected()) {
                                re.getReq_17().setSelected(true);
                                Cargar_Imagen_17();
                                re.getReq_17().setSelected(true);
                            } else if (re.getReq_17().isSelected()) {
                                Cargar_Imagen_17();
                            }
                        } else {
                            if (!re.getReq_17().isSelected()) {
                                re.getReq_17().setSelected(true);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cargar_Imagen_17();
                }
            }
        } else {
            Cargar_Imagen_17();
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
            re.getReq_1().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
            re.getReq_1().setSelected(true);
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
            re.getReq_2().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_2 = j.getSelectedFile();
            rutas_2 = String.valueOf(ruta_2);
            re.getReq_2().setSelected(true);
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
            re.getReq_3().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_3 = j.getSelectedFile();
            rutas_3 = String.valueOf(ruta_3);
            re.getReq_3().setSelected(true);
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
            re.getReq_4().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_4 = j.getSelectedFile();
            rutas_4 = String.valueOf(ruta_4);
            re.getReq_4().setSelected(true);
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
            re.getReq_5().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_5 = j.getSelectedFile();
            rutas_5 = String.valueOf(ruta_5);
            re.getReq_5().setSelected(true);
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
            re.getReq_6().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_6 = j.getSelectedFile();
            rutas_6 = String.valueOf(ruta_6);
            re.getReq_6().setSelected(true);
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
            re.getReq_7().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_7 = j.getSelectedFile();
            rutas_7 = String.valueOf(ruta_7);
            re.getReq_7().setSelected(true);
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
            re.getReq_8().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_8 = j.getSelectedFile();
            rutas_8 = String.valueOf(ruta_8);
            re.getReq_8().setSelected(true);
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
            re.getReq_9().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_9 = j.getSelectedFile();
            rutas_9 = String.valueOf(ruta_9);
            re.getReq_9().setSelected(true);
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
            re.getReq_10().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_10 = j.getSelectedFile();
            rutas_10 = String.valueOf(ruta_10);
            re.getReq_10().setSelected(true);
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
            re.getReq_11().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_11 = j.getSelectedFile();
            rutas_11 = String.valueOf(ruta_11);
            re.getReq_11().setSelected(true);
        }
    }

    public void Cargar_Imagen_12() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            re.getReq_12().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_12 = j.getSelectedFile();
            rutas_12 = String.valueOf(ruta_12);
            re.getReq_12().setSelected(true);
        }
    }

    public void Cargar_Imagen_13() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            re.getReq_13().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_13 = j.getSelectedFile();
            rutas_13 = String.valueOf(ruta_13);
            re.getReq_13().setSelected(true);
        }
    }

    public void Cargar_Imagen_14() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            re.getReq_14().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_14 = j.getSelectedFile();
            rutas_14 = String.valueOf(ruta_14);
            re.getReq_14().setSelected(true);
        }
    }

    public void Cargar_Imagen_15() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            re.getReq_15().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_15 = j.getSelectedFile();
            rutas_15 = String.valueOf(ruta_15);
            re.getReq_15().setSelected(true);
        }
    }

    public void Cargar_Imagen_16() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            re.getReq_16().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_16 = j.getSelectedFile();
            rutas_16 = String.valueOf(ruta_16);
            re.getReq_16().setSelected(true);
        }
    }

    public void Cargar_Imagen_17() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("PDF", "pdf");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            re.getReq_17().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_17 = j.getSelectedFile();
            rutas_17 = String.valueOf(ruta_17);
            re.getReq_17().setSelected(true);
        }
    }

    public void Num_Beneficiario() {

        re.getCb_numpers().addItem("Seleccionar");
        re.getCb_numpers().addItem("1");
        re.getCb_numpers().addItem("2");
        re.getCb_numpers().addItem("3");
        re.getCb_numpers().addItem("4");
    }

    public void Campo_Bloqueado() {

        re.getTxt_id().setEditable(false);
        re.getTxt_cedula().setEditable(false);
        re.getBtn_guardar().setEnabled(true);
        re.getBtn_modificar().setEnabled(true);
        re.getBtn_pago().setEnabled(true);
        re.getBtn_cargar().setEnabled(false);
        re.getReq_1().setEnabled(true);
        re.getReq_2().setEnabled(true);
        re.getReq_3().setEnabled(true);
        re.getReq_4().setEnabled(true);
        re.getReq_5().setEnabled(true);
        re.getReq_6().setEnabled(true);
        re.getReq_7().setEnabled(true);
        re.getReq_8().setEnabled(true);
        re.getReq_9().setEnabled(true);
        re.getReq_10().setEnabled(true);
        re.getReq_11().setEnabled(true);
        re.getReq_12().setEnabled(true);
        re.getReq_13().setEnabled(true);
        re.getReq_14().setEnabled(true);
        re.getReq_15().setEnabled(true);
        re.getReq_16().setEnabled(true);
        re.getReq_17().setEnabled(true);
        re.getCb_numpers().setEnabled(true);
        re.getTxa_observ().setEnabled(true);
    }

    public void Campos() {

        re.getTxt_id().setEditable(false);
        re.getTxt_cedula().setEditable(false);
        re.getBtn_guardar().setEnabled(false);
        re.getBtn_modificar().setEnabled(false);
        re.getBtn_pago().setEnabled(false);
        re.getBtn_cargar().setEnabled(true);
        re.getReq_1().setEnabled(false);
        re.getReq_2().setEnabled(false);
        re.getReq_3().setEnabled(false);
        re.getReq_4().setEnabled(false);
        re.getReq_5().setEnabled(false);
        re.getReq_6().setEnabled(false);
        re.getReq_7().setEnabled(false);
        re.getReq_8().setEnabled(false);
        re.getReq_9().setEnabled(false);
        re.getReq_10().setEnabled(false);
        re.getReq_11().setEnabled(false);
        re.getReq_12().setEnabled(false);
        re.getReq_13().setEnabled(false);
        re.getReq_14().setEnabled(false);
        re.getReq_15().setEnabled(false);
        re.getReq_16().setEnabled(false);
        re.getReq_17().setEnabled(false);
        re.getCb_numpers().setEnabled(false);
        re.getTxa_observ().setEnabled(false);
    }

    public void Subir_Documento() {

        String num_beneficiarios = (String) re.getCb_numpers().getSelectedItem();

        if (!num_beneficiarios.equals("Seleccionar")) {
            D.setId_caso(Integer.parseInt(re.getTxt_id().getText()));
            D.setCedula(re.getTxt_cedula().getText());

            //reQUISITO #1
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

            //reQUISITO #2
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

            //reQUISITO #3
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

            //reQUISITO #4
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

            //reQUISITO #5
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

            //reQUISITO #6
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

            //reQUISITO #7
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

            //reQUISITO #8
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

            //reQUISITO #9
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

            //reQUISITO #10
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

            //reQUISITO #11
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

            //reQUISITO #12
            if (ruta_12 != null) {
                File ruta_12 = new File(rutas_12);

                try {
                    byte[] icono = new byte[(int) ruta_12.length()];
                    InputStream input = new FileInputStream(ruta_12);
                    input.read(icono);
                    D.setReq_12(icono);
                } catch (Exception ex) {
                    D.setReq_12(null);
                }
            }

            //reQUISITO #13
            if (ruta_13 != null) {
                File ruta_13 = new File(rutas_13);

                try {
                    byte[] icono = new byte[(int) ruta_13.length()];
                    InputStream input = new FileInputStream(ruta_13);
                    input.read(icono);
                    D.setReq_13(icono);
                } catch (Exception ex) {
                    D.setReq_13(null);
                }
            }

            //reQUISITO #14
            if (ruta_14 != null) {
                File ruta_14 = new File(rutas_14);

                try {
                    byte[] icono = new byte[(int) ruta_14.length()];
                    InputStream input = new FileInputStream(ruta_14);
                    input.read(icono);
                    D.setReq_14(icono);
                } catch (Exception ex) {
                    D.setReq_14(null);
                }
            }

            //reQUISITO #15
            if (ruta_15 != null) {
                File ruta_15 = new File(rutas_15);

                try {
                    byte[] icono = new byte[(int) ruta_15.length()];
                    InputStream input = new FileInputStream(ruta_15);
                    input.read(icono);
                    D.setReq_15(icono);
                } catch (Exception ex) {
                    D.setReq_15(null);
                }
            }

            //reQUISITO #16
            if (ruta_16 != null) {
                File ruta_16 = new File(rutas_16);

                try {
                    byte[] icono = new byte[(int) ruta_16.length()];
                    InputStream input = new FileInputStream(ruta_16);
                    input.read(icono);
                    D.setReq_16(icono);
                } catch (Exception ex) {
                    D.setReq_16(null);
                }
            }

            //reQUISITO #17
            if (ruta_17 != null) {
                File ruta_17 = new File(rutas_17);

                try {
                    byte[] icono = new byte[(int) ruta_17.length()];
                    InputStream input = new FileInputStream(ruta_17);
                    input.read(icono);
                    D.setReq_17(icono);
                } catch (Exception ex) {
                    D.setReq_17(null);
                }
            }

            int honorarios = 250 * Integer.parseInt(num_beneficiarios);
            D.setHonorarios(honorarios);

            D.setNum_beneficiarios(Integer.parseInt(num_beneficiarios));

            D.setObservacion(re.getTxa_observ().getText());
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

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                try {
                    byte[] bi = List_caso.get(i).getReq_1();
                    if (bi != null) {
                        re.getReq_1().setSelected(true);
                        D.setReq_1(bi);
                    } else if (bi == null) {
                        re.getReq_1().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_2();
                    if (bi != null) {
                        re.getReq_2().setSelected(true);
                        D.setReq_2(bi);
                    } else if (bi == null) {
                        re.getReq_2().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_3();
                    if (bi != null) {
                        re.getReq_3().setSelected(true);
                        D.setReq_3(bi);
                    } else if (bi == null) {
                        re.getReq_3().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_4();
                    if (bi != null) {
                        re.getReq_4().setSelected(true);
                        D.setReq_4(bi);
                    } else if (bi == null) {
                        re.getReq_4().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_5();
                    if (bi != null) {
                        re.getReq_5().setSelected(true);
                        D.setReq_5(bi);
                    } else if (bi == null) {
                        re.getReq_5().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_6();
                    if (bi != null) {
                        re.getReq_6().setSelected(true);
                        D.setReq_6(bi);
                    } else if (bi == null) {
                        re.getReq_6().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_7();
                    if (bi != null) {
                        re.getReq_7().setSelected(true);
                        D.setReq_7(bi);
                    } else if (bi == null) {
                        re.getReq_7().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_8();
                    if (bi != null) {
                        re.getReq_8().setSelected(true);
                        D.setReq_8(bi);
                    } else if (bi == null) {
                        re.getReq_8().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_9();
                    if (bi != null) {
                        re.getReq_9().setSelected(true);
                        D.setReq_9(bi);
                    } else if (bi == null) {
                        re.getReq_9().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_10();
                    if (bi != null) {
                        re.getReq_10().setSelected(true);
                        D.setReq_10(bi);
                    } else if (bi == null) {
                        re.getReq_10().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_11();
                    if (bi != null) {
                        re.getReq_11().setSelected(true);
                        D.setReq_11(bi);
                    } else if (bi == null) {
                        re.getReq_11().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_12();
                    if (bi != null) {
                        re.getReq_12().setSelected(true);
                        D.setReq_12(bi);
                    } else if (bi == null) {
                        re.getReq_12().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_13();
                    if (bi != null) {
                        re.getReq_13().setSelected(true);
                        D.setReq_13(bi);
                    } else if (bi == null) {
                        re.getReq_13().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_14();
                    if (bi != null) {
                        re.getReq_14().setSelected(true);
                        D.setReq_14(bi);
                    } else if (bi == null) {
                        re.getReq_14().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_15();
                    if (bi != null) {
                        re.getReq_15().setSelected(true);
                        D.setReq_15(bi);
                    } else if (bi == null) {
                        re.getReq_15().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_16();
                    if (bi != null) {
                        re.getReq_16().setSelected(true);
                        D.setReq_16(bi);
                    } else if (bi == null) {
                        re.getReq_16().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_17();
                    if (bi != null) {
                        re.getReq_17().setSelected(true);
                        D.setReq_17(bi);
                    } else if (bi == null) {
                        re.getReq_17().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                re.getCb_numpers().setSelectedItem(String.valueOf(List_caso.get(i).getNum_beneficiarios()));
                re.getTxa_observ().setText(List_caso.get(i).getObservacion());
            }
        }
    }

    public void Validar_Guardar_Modificar() {

        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (!List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                re.getBtn_guardar().setEnabled(true);
                re.getBtn_modificar().setEnabled(false);
            } else if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                re.getBtn_guardar().setEnabled(false);
                re.getBtn_modificar().setEnabled(true);
                re.getCb_numpers().setEnabled(false);
            }
        }

        if (List_caso.isEmpty()) {
            re.getBtn_guardar().setEnabled(true);
            re.getBtn_modificar().setEnabled(false);
        }
    }

    public void Modificar_Requisitos() {

        //reQUISITO #1
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_1();
                        if (bi != null) {
                            re.getReq_1().setSelected(true);
                            D.setReq_1(bi);
                        } else if (bi == null) {
                            re.getReq_1().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #2
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        if (bi != null) {
                            re.getReq_2().setSelected(true);
                            D.setReq_2(bi);
                        } else if (bi == null) {
                            re.getReq_2().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #3
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        if (bi != null) {
                            re.getReq_3().setSelected(true);
                            D.setReq_3(bi);
                        } else if (bi == null) {
                            re.getReq_3().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #4
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        if (bi != null) {
                            re.getReq_4().setSelected(true);
                            D.setReq_4(bi);
                        } else if (bi == null) {
                            re.getReq_4().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #5
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        if (bi != null) {
                            re.getReq_5().setSelected(true);
                            D.setReq_5(bi);
                        } else if (bi == null) {
                            re.getReq_5().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #6
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_6();
                        if (bi != null) {
                            re.getReq_6().setSelected(true);
                            D.setReq_6(bi);
                        } else if (bi == null) {
                            re.getReq_6().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #7
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_7();
                        if (bi != null) {
                            re.getReq_7().setSelected(true);
                            D.setReq_7(bi);
                        } else if (bi == null) {
                            re.getReq_7().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #8
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_8();
                        if (bi != null) {
                            re.getReq_8().setSelected(true);
                            D.setReq_8(bi);
                        } else if (bi == null) {
                            re.getReq_8().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #9
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_9();
                        if (bi != null) {
                            re.getReq_9().setSelected(true);
                            D.setReq_9(bi);
                        } else if (bi == null) {
                            re.getReq_9().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #10
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_10();
                        if (bi != null) {
                            re.getReq_10().setSelected(true);
                            D.setReq_10(bi);
                        } else if (bi == null) {
                            re.getReq_10().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #11
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

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_11();
                        if (bi != null) {
                            re.getReq_11().setSelected(true);
                            D.setReq_11(bi);
                        } else if (bi == null) {
                            re.getReq_11().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #12
        if (ruta_12 != null) {
            File ruta_12 = new File(rutas_12);

            try {
                byte[] icono = new byte[(int) ruta_12.length()];
                InputStream input = new FileInputStream(ruta_12);
                input.read(icono);
                D.setReq_12(icono);
            } catch (Exception ex) {
                D.setReq_12(null);
            }
        } else {

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_12();
                        if (bi != null) {
                            re.getReq_12().setSelected(true);
                            D.setReq_12(bi);
                        } else if (bi == null) {
                            re.getReq_12().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #13
        if (ruta_13 != null) {
            File ruta_13 = new File(rutas_13);

            try {
                byte[] icono = new byte[(int) ruta_13.length()];
                InputStream input = new FileInputStream(ruta_13);
                input.read(icono);
                D.setReq_13(icono);
            } catch (Exception ex) {
                D.setReq_13(null);
            }
        } else {

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_13();
                        if (bi != null) {
                            re.getReq_13().setSelected(true);
                            D.setReq_13(bi);
                        } else if (bi == null) {
                            re.getReq_13().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #14
        if (ruta_14 != null) {
            File ruta_14 = new File(rutas_14);

            try {
                byte[] icono = new byte[(int) ruta_14.length()];
                InputStream input = new FileInputStream(ruta_14);
                input.read(icono);
                D.setReq_14(icono);
            } catch (Exception ex) {
                D.setReq_14(null);
            }
        } else {

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_14();
                        if (bi != null) {
                            re.getReq_14().setSelected(true);
                            D.setReq_14(bi);
                        } else if (bi == null) {
                            re.getReq_14().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #15
        if (ruta_15 != null) {
            File ruta_15 = new File(rutas_15);

            try {
                byte[] icono = new byte[(int) ruta_15.length()];
                InputStream input = new FileInputStream(ruta_15);
                input.read(icono);
                D.setReq_15(icono);
            } catch (Exception ex) {
                D.setReq_15(null);
            }
        } else {

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_15();
                        if (bi != null) {
                            re.getReq_15().setSelected(true);
                            D.setReq_15(bi);
                        } else if (bi == null) {
                            re.getReq_15().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #16
        if (ruta_16 != null) {
            File ruta_16 = new File(rutas_16);

            try {
                byte[] icono = new byte[(int) ruta_16.length()];
                InputStream input = new FileInputStream(ruta_16);
                input.read(icono);
                D.setReq_16(icono);
            } catch (Exception ex) {
                D.setReq_16(null);
            }
        } else {

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_16();
                        if (bi != null) {
                            re.getReq_16().setSelected(true);
                            D.setReq_16(bi);
                        } else if (bi == null) {
                            re.getReq_16().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        //reQUISITO #17
        if (ruta_17 != null) {
            File ruta_17 = new File(rutas_17);

            try {
                byte[] icono = new byte[(int) ruta_17.length()];
                InputStream input = new FileInputStream(ruta_17);
                input.read(icono);
                D.setReq_17(icono);
            } catch (Exception ex) {
                D.setReq_17(null);
            }
        } else {

            List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_17();
                        if (bi != null) {
                            re.getReq_17().setSelected(true);
                            D.setReq_17(bi);
                        } else if (bi == null) {
                            re.getReq_17().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        D.setObservacion(re.getTxa_observ().getText());
        D.setId_caso(Integer.parseInt(re.getTxt_id().getText()));
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
        List<Buf_Caso_Visa_Europa> List_caso = D_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(re.getTxt_cedula().getText())) {
                pa.getTxt_cedula().setText(re.getTxt_cedula().getText());
                pa.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                if (!List_pago.isEmpty()) {
                    for (int j = 0; j < List_pago.size(); j++) {
                        if (List_pago.get(j).getId_caso() != Integer.parseInt(re.getTxt_id().getText())) {
                            pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                        }
                    }
                } else {
                    pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                }
            }
        }
        p.Iniciar_Control();
        re.setVisible(false);
    }
}
