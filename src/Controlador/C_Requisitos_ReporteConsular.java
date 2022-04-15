/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso_Reporte_Consular;
import Modelo.Buf_Caso_Reporte_ConsularDB;
import javax.swing.JOptionPane;
import vista.V_Requisitos_ReporteConsular;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Modelo.Buf_Pagos;
import Modelo.Buf_PagosDB;
import vista.V_Pago;
import vista.V_Menu_Inicio;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_ReporteConsular {

    V_Requisitos_ReporteConsular consular;
    
    Buf_Caso_Reporte_ConsularDB D_DB = new Buf_Caso_Reporte_ConsularDB();
    Buf_Caso_Reporte_Consular D = new Buf_Caso_Reporte_Consular();
    Buf_PagosDB P_DB = new Buf_PagosDB();

    public File ruta;
    public File ruta_2;
    public File ruta_3;
    public File ruta_4;
    public File ruta_5;
    public File ruta_6;
    public File ruta_7;
    public File ruta_8;

    public String rutas;
    public String rutas_2;
    public String rutas_3;
    public String rutas_4;
    public String rutas_5;
    public String rutas_6;
    public String rutas_7;
    public String rutas_8;

    public C_Requisitos_ReporteConsular(V_Requisitos_ReporteConsular consular) {
        
        this.consular = consular;
        
        Num_Beneficiario();
        Campos();
    }
    
    public void Iniciar_Control() {

        consular.getBtn_guardar().addActionListener(l -> {
            Subir_Documento();
        });
        consular.getBtn_modificar().addActionListener(l -> {
            Modificar_Requisitos();
        });
        consular.getBtn_pago().addActionListener(l -> {
            Abrir_Pago();
        });
        consular.getBtn_cargar().addActionListener(l -> {
            Campo_Bloqueado();
            Validar_Guardar_Modificar();
            Cargar_Check();
        });
        consular.getReq_1().addActionListener(l -> {
            Cargar_Imagen();
        });
        consular.getReq_2().addActionListener(l -> {
            Cargar_Imagen_2();
        });
        consular.getReq_3().addActionListener(l -> {
            Cargar_Imagen_3();
        });
        consular.getReq_4().addActionListener(l -> {
            Cargar_Imagen_4();
        });
        consular.getReq_5().addActionListener(l -> {
            Cargar_Imagen_5();
        });
        consular.getReq_6().addActionListener(l -> {
            Cargar_Imagen_6();
        });
        consular.getReq_7().addActionListener(l -> {
            Cargar_Imagen_7();
        });
        consular.getReq_8().addActionListener(l -> {
            Cargar_Imagen_8();
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
            consular.getReq_1().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
            consular.getReq_1().setSelected(true);
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
            consular.getReq_2().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_2 = j.getSelectedFile();
            rutas_2 = String.valueOf(ruta_2);
            consular.getReq_2().setSelected(true);
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
            consular.getReq_3().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_3 = j.getSelectedFile();
            rutas_3 = String.valueOf(ruta_3);
            consular.getReq_3().setSelected(true);
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
            consular.getReq_4().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_4 = j.getSelectedFile();
            rutas_4 = String.valueOf(ruta_4);
            consular.getReq_4().setSelected(true);
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
            consular.getReq_5().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_5 = j.getSelectedFile();
            rutas_5 = String.valueOf(ruta_5);
            consular.getReq_5().setSelected(true);
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
            consular.getReq_6().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_6 = j.getSelectedFile();
            rutas_6 = String.valueOf(ruta_6);
            consular.getReq_6().setSelected(true);
        }
    }

    public void Cargar_Imagen_7() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            consular.getReq_7().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_7 = j.getSelectedFile();
            rutas_7 = String.valueOf(ruta_7);
            consular.getReq_7().setSelected(true);
        }
    }

    public void Cargar_Imagen_8() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            consular.getReq_8().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_8 = j.getSelectedFile();
            rutas_8 = String.valueOf(ruta_8);
            consular.getReq_8().setSelected(true);
        }
    }
    
    public void Num_Beneficiario() {

        consular.getCb_numper().addItem("Seleccionar");
        consular.getCb_numper().addItem("1");
        consular.getCb_numper().addItem("2");
        consular.getCb_numper().addItem("3");
        consular.getCb_numper().addItem("4");
    }

    public void Campo_Bloqueado() {

        consular.getTxt_id().setEditable(false);
        consular.getTxt_cedula().setEditable(false);
        consular.getBtn_guardar().setEnabled(true);
        consular.getBtn_modificar().setEnabled(true);
        consular.getBtn_pago().setEnabled(true);
        consular.getBtn_cargar().setEnabled(false);
        consular.getReq_1().setEnabled(true);
        consular.getReq_2().setEnabled(true);
        consular.getReq_3().setEnabled(true);
        consular.getReq_4().setEnabled(true);
        consular.getReq_5().setEnabled(true);
        consular.getReq_6().setEnabled(true);
        consular.getReq_7().setEnabled(true);
        consular.getReq_8().setEnabled(true);
        consular.getCb_numper().setEnabled(true);
        consular.getTxa_observ().setEnabled(true);
    }

    public void Campos() {

        consular.getTxt_id().setEditable(false);
        consular.getTxt_cedula().setEditable(false);
        consular.getBtn_guardar().setEnabled(false);
        consular.getBtn_modificar().setEnabled(false);
        consular.getBtn_pago().setEnabled(false);
        consular.getBtn_cargar().setEnabled(true);
        consular.getReq_1().setEnabled(false);
        consular.getReq_2().setEnabled(false);
        consular.getReq_3().setEnabled(false);
        consular.getReq_4().setEnabled(false);
        consular.getReq_5().setEnabled(false);
        consular.getReq_6().setEnabled(false);
        consular.getReq_7().setEnabled(false);
        consular.getReq_8().setEnabled(false);
        consular.getCb_numper().setEnabled(false);
        consular.getTxa_observ().setEnabled(false);
    }

    public void Subir_Documento() {

        String num_beneficiarios = (String) consular.getCb_numper().getSelectedItem();

        if (!num_beneficiarios.equals("Seleccionar")) {
            D.setId_caso(Integer.parseInt(consular.getTxt_id().getText()));
            D.setCedula(consular.getTxt_cedula().getText());

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

            int honorarios = 250 * Integer.parseInt(num_beneficiarios);
            D.setHonorarios(honorarios);

            D.setNum_beneficiarios(Integer.parseInt(num_beneficiarios));

            D.setObservacion(consular.getTxa_observ().getText());
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

        List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                try {
                    byte[] bi = List_caso.get(i).getReq_1();
                    if (bi != null) {
                        consular.getReq_1().setSelected(true);
                        D.setReq_1(bi);
                    } else if (bi == null) {
                        consular.getReq_1().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_2();
                    if (bi != null) {
                        consular.getReq_2().setSelected(true);
                        D.setReq_2(bi);
                    } else if (bi == null) {
                        consular.getReq_2().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_3();
                    if (bi != null) {
                        consular.getReq_3().setSelected(true);
                        D.setReq_3(bi);
                    } else if (bi == null) {
                        consular.getReq_3().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_4();
                    if (bi != null) {
                        consular.getReq_4().setSelected(true);
                        D.setReq_4(bi);
                    } else if (bi == null) {
                        consular.getReq_4().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_5();
                    if (bi != null) {
                        consular.getReq_5().setSelected(true);
                        D.setReq_5(bi);
                    } else if (bi == null) {
                        consular.getReq_5().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_6();
                    if (bi != null) {
                        consular.getReq_6().setSelected(true);
                        D.setReq_6(bi);
                    } else if (bi == null) {
                        consular.getReq_6().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_7();
                    if (bi != null) {
                        consular.getReq_7().setSelected(true);
                        D.setReq_7(bi);
                    } else if (bi == null) {
                        consular.getReq_7().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_8();
                    if (bi != null) {
                        consular.getReq_8().setSelected(true);
                        D.setReq_8(bi);
                    } else if (bi == null) {
                        consular.getReq_8().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                consular.getCb_numper().setSelectedItem(String.valueOf(List_caso.get(i).getNum_beneficiarios()));
                consular.getTxa_observ().setText(List_caso.get(i).getObservacion());
            }
        }
    }

    public void Validar_Guardar_Modificar() {

        List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (!List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                consular.getBtn_guardar().setEnabled(true);
                consular.getBtn_modificar().setEnabled(false);
            } else if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                consular.getBtn_guardar().setEnabled(false);
                consular.getBtn_modificar().setEnabled(true);
                consular.getCb_numper().setEnabled(false);
            }
        }

        if (List_caso.isEmpty()) {
            consular.getBtn_guardar().setEnabled(true);
            consular.getBtn_modificar().setEnabled(false);
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

            List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_1();
                        if (bi != null) {
                            consular.getReq_1().setSelected(true);
                            D.setReq_1(bi);
                        } else if (bi == null) {
                            consular.getReq_1().setSelected(false);
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

            List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        if (bi != null) {
                            consular.getReq_2().setSelected(true);
                            D.setReq_2(bi);
                        } else if (bi == null) {
                            consular.getReq_2().setSelected(false);
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

            List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        if (bi != null) {
                            consular.getReq_3().setSelected(true);
                            D.setReq_3(bi);
                        } else if (bi == null) {
                            consular.getReq_3().setSelected(false);
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

            List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        if (bi != null) {
                            consular.getReq_4().setSelected(true);
                            D.setReq_4(bi);
                        } else if (bi == null) {
                            consular.getReq_4().setSelected(false);
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

            List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        if (bi != null) {
                            consular.getReq_5().setSelected(true);
                            D.setReq_5(bi);
                        } else if (bi == null) {
                            consular.getReq_5().setSelected(false);
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

            List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_6();
                        if (bi != null) {
                            consular.getReq_6().setSelected(true);
                            D.setReq_6(bi);
                        } else if (bi == null) {
                            consular.getReq_6().setSelected(false);
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

            List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_7();
                        if (bi != null) {
                            consular.getReq_7().setSelected(true);
                            D.setReq_7(bi);
                        } else if (bi == null) {
                            consular.getReq_7().setSelected(false);
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

            List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_8();
                        if (bi != null) {
                            consular.getReq_8().setSelected(true);
                            D.setReq_8(bi);
                        } else if (bi == null) {
                            consular.getReq_8().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        
        D.setObservacion(consular.getTxa_observ().getText());
        D.setId_caso(Integer.parseInt(consular.getTxt_id().getText()));
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
        List<Buf_Caso_Reporte_Consular> List_caso = D_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(consular.getTxt_cedula().getText())) {
                pa.getTxt_cedula().setText(consular.getTxt_cedula().getText());
                pa.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                if (!List_pago.isEmpty()) {
                    for (int j = 0; j < List_pago.size(); j++) {
                        if (List_pago.get(j).getId_caso() != Integer.parseInt(consular.getTxt_id().getText())) {
                            pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                        }
                    }
                } else {
                    pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                }
            }
        }
        p.Iniciar_Control();
        consular.setVisible(false);
    }
}
