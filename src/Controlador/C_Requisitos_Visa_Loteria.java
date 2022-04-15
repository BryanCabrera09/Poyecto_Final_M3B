/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso_Visa_Loteria;
import Modelo.Buf_Caso_Visa_LoteriaDB;
import javax.swing.JOptionPane;
import vista.V_Requisitos_Visa_Loteria;
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
public class C_Requisitos_Visa_Loteria {

    V_Requisitos_Visa_Loteria loteria;

    Buf_Caso_Visa_LoteriaDB D_DB = new Buf_Caso_Visa_LoteriaDB();
    Buf_Caso_Visa_Loteria D = new Buf_Caso_Visa_Loteria();
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

    public String rutas;
    public String rutas_2;
    public String rutas_3;
    public String rutas_4;
    public String rutas_5;
    public String rutas_6;
    public String rutas_7;
    public String rutas_8;
    public String rutas_9;

    public C_Requisitos_Visa_Loteria(V_Requisitos_Visa_Loteria loteria) {

        this.loteria = loteria;

        Num_Beneficiario();
        Campos();
    }
    
    public void Iniciar_Control() {

        loteria.getBtn_guardar().addActionListener(l -> {
            Subir_Documento();
        });
        loteria.getBtn_modificar().addActionListener(l -> {
            Modificar_Requisitos();
        });
        loteria.getBtn_pago().addActionListener(l -> {
            Abrir_Pago();
        });
        loteria.getBtn_cargar().addActionListener(l -> {
            Campo_Bloqueado();
            Validar_Guardar_Modificar();
            Cargar_Check();
        });
        loteria.getReq_1().addActionListener(l -> {
            Cargar_Imagen();
        });
        loteria.getReq_2().addActionListener(l -> {
            Cargar_Imagen_2();
        });
        loteria.getReq_3().addActionListener(l -> {
            Cargar_Imagen_3();
        });
        loteria.getReq_4().addActionListener(l -> {
            Cargar_Imagen_4();
        });
        loteria.getReq_5().addActionListener(l -> {
            Cargar_Imagen_5();
        });
        loteria.getReq_6().addActionListener(l -> {
            Cargar_Imagen_6();
        });
        loteria.getReq_7().addActionListener(l -> {
            Cargar_Imagen_7();
        });
        loteria.getReq_8().addActionListener(l -> {
            Cargar_Imagen_8();
        });
        loteria.getReq_9().addActionListener(l -> {
            Cargar_Imagen_9();
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
            loteria.getReq_1().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
            loteria.getReq_1().setSelected(true);
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
            loteria.getReq_2().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_2 = j.getSelectedFile();
            rutas_2 = String.valueOf(ruta_2);
            loteria.getReq_2().setSelected(true);
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
            loteria.getReq_3().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_3 = j.getSelectedFile();
            rutas_3 = String.valueOf(ruta_3);
            loteria.getReq_3().setSelected(true);
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
            loteria.getReq_4().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_4 = j.getSelectedFile();
            rutas_4 = String.valueOf(ruta_4);
            loteria.getReq_4().setSelected(true);
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
            loteria.getReq_5().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_5 = j.getSelectedFile();
            rutas_5 = String.valueOf(ruta_5);
            loteria.getReq_5().setSelected(true);
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
            loteria.getReq_6().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_6 = j.getSelectedFile();
            rutas_6 = String.valueOf(ruta_6);
            loteria.getReq_6().setSelected(true);
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
            loteria.getReq_7().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_7 = j.getSelectedFile();
            rutas_7 = String.valueOf(ruta_7);
            loteria.getReq_7().setSelected(true);
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
            loteria.getReq_8().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_8 = j.getSelectedFile();
            rutas_8 = String.valueOf(ruta_8);
            loteria.getReq_8().setSelected(true);
        }
    }

    public void Cargar_Imagen_9() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        j.setFileFilter(fil);

        File ruta_carpeta = new File("");
        j.setCurrentDirectory(ruta_carpeta);

        int s = j.showOpenDialog(j);

        if (!ruta_carpeta.exists()) {
            loteria.getReq_9().setSelected(false);
        }

        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_9 = j.getSelectedFile();
            rutas_9 = String.valueOf(ruta_9);
            loteria.getReq_9().setSelected(true);
        }
    }
    
    public void Num_Beneficiario() {

        loteria.getCb_numper().addItem("Seleccionar");
        loteria.getCb_numper().addItem("1");
        loteria.getCb_numper().addItem("2");
        loteria.getCb_numper().addItem("3");
        loteria.getCb_numper().addItem("4");
    }

    public void Campo_Bloqueado() {

        loteria.getTxt_id().setEditable(false);
        loteria.getTxt_cedula().setEditable(false);
        loteria.getBtn_guardar().setEnabled(true);
        loteria.getBtn_modificar().setEnabled(true);
        loteria.getBtn_pago().setEnabled(true);
        loteria.getBtn_cargar().setEnabled(false);
        loteria.getReq_1().setEnabled(true);
        loteria.getReq_2().setEnabled(true);
        loteria.getReq_3().setEnabled(true);
        loteria.getReq_4().setEnabled(true);
        loteria.getReq_5().setEnabled(true);
        loteria.getReq_6().setEnabled(true);
        loteria.getReq_7().setEnabled(true);
        loteria.getReq_8().setEnabled(true);
        loteria.getReq_9().setEnabled(true);
        loteria.getCb_numper().setEnabled(true);
        loteria.getTxa_observ().setEnabled(true);
    }

    public void Campos() {

        loteria.getTxt_id().setEditable(false);
        loteria.getTxt_cedula().setEditable(false);
        loteria.getBtn_guardar().setEnabled(false);
        loteria.getBtn_modificar().setEnabled(false);
        loteria.getBtn_pago().setEnabled(false);
        loteria.getBtn_cargar().setEnabled(true);
        loteria.getReq_1().setEnabled(false);
        loteria.getReq_2().setEnabled(false);
        loteria.getReq_3().setEnabled(false);
        loteria.getReq_4().setEnabled(false);
        loteria.getReq_5().setEnabled(false);
        loteria.getReq_6().setEnabled(false);
        loteria.getReq_7().setEnabled(false);
        loteria.getReq_8().setEnabled(false);
        loteria.getReq_9().setEnabled(false);
        loteria.getCb_numper().setEnabled(false);
        loteria.getTxa_observ().setEnabled(false);
    }

    public void Subir_Documento() {

        String num_beneficiarios = (String) loteria.getCb_numper().getSelectedItem();

        if (!num_beneficiarios.equals("Seleccionar")) {
            D.setId_caso(Integer.parseInt(loteria.getTxt_id().getText()));
            D.setCedula(loteria.getTxt_cedula().getText());

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

            int honorarios = 250 * Integer.parseInt(num_beneficiarios);
            D.setHonorarios(honorarios);

            D.setNum_beneficiarios(Integer.parseInt(num_beneficiarios));

            D.setObservacion(loteria.getTxa_observ().getText());
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

        List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                try {
                    byte[] bi = List_caso.get(i).getReq_1();
                    if (bi != null) {
                        loteria.getReq_1().setSelected(true);
                        D.setReq_1(bi);
                    } else if (bi == null) {
                        loteria.getReq_1().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_2();
                    if (bi != null) {
                        loteria.getReq_2().setSelected(true);
                        D.setReq_2(bi);
                    } else if (bi == null) {
                        loteria.getReq_2().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_3();
                    if (bi != null) {
                        loteria.getReq_3().setSelected(true);
                        D.setReq_3(bi);
                    } else if (bi == null) {
                        loteria.getReq_3().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_4();
                    if (bi != null) {
                        loteria.getReq_4().setSelected(true);
                        D.setReq_4(bi);
                    } else if (bi == null) {
                        loteria.getReq_4().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_5();
                    if (bi != null) {
                        loteria.getReq_5().setSelected(true);
                        D.setReq_5(bi);
                    } else if (bi == null) {
                        loteria.getReq_5().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_6();
                    if (bi != null) {
                        loteria.getReq_6().setSelected(true);
                        D.setReq_6(bi);
                    } else if (bi == null) {
                        loteria.getReq_6().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_7();
                    if (bi != null) {
                        loteria.getReq_7().setSelected(true);
                        D.setReq_7(bi);
                    } else if (bi == null) {
                        loteria.getReq_7().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_8();
                    if (bi != null) {
                        loteria.getReq_8().setSelected(true);
                        D.setReq_8(bi);
                    } else if (bi == null) {
                        loteria.getReq_8().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_9();
                    if (bi != null) {
                        loteria.getReq_9().setSelected(true);
                        D.setReq_9(bi);
                    } else if (bi == null) {
                        loteria.getReq_9().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                loteria.getCb_numper().setSelectedItem(String.valueOf(List_caso.get(i).getNum_beneficiarios()));
                loteria.getTxa_observ().setText(List_caso.get(i).getObservacion());
            }
        }
    }

    public void Validar_Guardar_Modificar() {

        List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

        for (int i = 0; i < List_caso.size(); i++) {
            if (!List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                loteria.getBtn_guardar().setEnabled(true);
                loteria.getBtn_modificar().setEnabled(false);
            } else if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                loteria.getBtn_guardar().setEnabled(false);
                loteria.getBtn_modificar().setEnabled(true);
                loteria.getCb_numper().setEnabled(false);
            }
        }

        if (List_caso.isEmpty()) {
            loteria.getBtn_guardar().setEnabled(true);
            loteria.getBtn_modificar().setEnabled(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_1();
                        if (bi != null) {
                            loteria.getReq_1().setSelected(true);
                            D.setReq_1(bi);
                        } else if (bi == null) {
                            loteria.getReq_1().setSelected(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        if (bi != null) {
                            loteria.getReq_2().setSelected(true);
                            D.setReq_2(bi);
                        } else if (bi == null) {
                            loteria.getReq_2().setSelected(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        if (bi != null) {
                            loteria.getReq_3().setSelected(true);
                            D.setReq_3(bi);
                        } else if (bi == null) {
                            loteria.getReq_3().setSelected(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        if (bi != null) {
                            loteria.getReq_4().setSelected(true);
                            D.setReq_4(bi);
                        } else if (bi == null) {
                            loteria.getReq_4().setSelected(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        if (bi != null) {
                            loteria.getReq_5().setSelected(true);
                            D.setReq_5(bi);
                        } else if (bi == null) {
                            loteria.getReq_5().setSelected(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_6();
                        if (bi != null) {
                            loteria.getReq_6().setSelected(true);
                            D.setReq_6(bi);
                        } else if (bi == null) {
                            loteria.getReq_6().setSelected(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_7();
                        if (bi != null) {
                            loteria.getReq_7().setSelected(true);
                            D.setReq_7(bi);
                        } else if (bi == null) {
                            loteria.getReq_7().setSelected(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_8();
                        if (bi != null) {
                            loteria.getReq_8().setSelected(true);
                            D.setReq_8(bi);
                        } else if (bi == null) {
                            loteria.getReq_8().setSelected(false);
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

            List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();

            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_9();
                        if (bi != null) {
                            loteria.getReq_9().setSelected(true);
                            D.setReq_9(bi);
                        } else if (bi == null) {
                            loteria.getReq_9().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        
        D.setObservacion(loteria.getTxa_observ().getText());
        D.setId_caso(Integer.parseInt(loteria.getTxt_id().getText()));
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
        List<Buf_Caso_Visa_Loteria> List_caso = D_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(loteria.getTxt_cedula().getText())) {
                pa.getTxt_cedula().setText(loteria.getTxt_cedula().getText());
                pa.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                if (!List_pago.isEmpty()) {
                    for (int j = 0; j < List_pago.size(); j++) {
                        if (List_pago.get(j).getId_caso() != Integer.parseInt(loteria.getTxt_id().getText())) {
                            pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                        }
                    }
                } else {
                    pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                }
            }
        }
        p.Iniciar_Control();
        loteria.setVisible(false);
    }
}
