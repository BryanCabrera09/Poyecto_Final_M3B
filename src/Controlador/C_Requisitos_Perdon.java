/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_Caso_Perdon;
import Modelo.Buf_Caso_PerdonDB;
import Modelo.Buf_PagosDB;
import Modelo.Buf_Pagos;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import vista.V_Requisitos_Perdon;
import vista.V_Menu_Inicio;
import vista.V_Pago;

/*
 * @author BRYAN_CABRERA
 */
public class C_Requisitos_Perdon {
    
    V_Requisitos_Perdon perdon;
    Buf_Caso_PerdonDB D_DB = new Buf_Caso_PerdonDB();
    Buf_Caso_Perdon D = new Buf_Caso_Perdon();
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
    
    public C_Requisitos_Perdon(V_Requisitos_Perdon perdon) {
        
        this.perdon = perdon;
        
        Campos();
        Num_Beneficiario();
    }
    
    public void Iniciar_Control() {
        
        perdon.getBtn_guardar().addActionListener(l -> {
            Subir_Documento();
        });
        perdon.getBtn_modificar().addActionListener(l -> {
            Modificar_Requisitos();
        });
        perdon.getBtn_pago().addActionListener(l -> {
            Abrir_Pago();
        });
        perdon.getBtn_cargar().addActionListener(l -> {
            Campo_Bloqueado();
            Validar_Guardar_Modificar();
            Cargar_Check();
        });
        perdon.getReq_1().addActionListener(l -> {
            Cargar_Imagen();
        });
        perdon.getReq_2().addActionListener(l -> {
            Cargar_Imagen_2();
        });
        perdon.getReq_3().addActionListener(l -> {
            Cargar_Imagen_3();
        });
        perdon.getReq_4().addActionListener(l -> {
            Cargar_Imagen_4();
        });
        perdon.getReq_5().addActionListener(l -> {
            Cargar_Imagen_5();
        });
        perdon.getReq_6().addActionListener(l -> {
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
            perdon.getReq_1().setSelected(false);
        }
        
        if (s == JFileChooser.APPROVE_OPTION) {
            ruta = j.getSelectedFile();
            rutas = String.valueOf(ruta);
            perdon.getReq_1().setSelected(true);
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
            perdon.getReq_2().setSelected(false);
        }
        
        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_2 = j.getSelectedFile();
            rutas_2 = String.valueOf(ruta_2);
            perdon.getReq_2().setSelected(true);
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
            perdon.getReq_3().setSelected(false);
        }
        
        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_3 = j.getSelectedFile();
            rutas_3 = String.valueOf(ruta_3);
            perdon.getReq_3().setSelected(true);
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
            perdon.getReq_4().setSelected(false);
        }
        
        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_4 = j.getSelectedFile();
            rutas_4 = String.valueOf(ruta_4);
            perdon.getReq_4().setSelected(true);
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
            perdon.getReq_5().setSelected(false);
        }
        
        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_5 = j.getSelectedFile();
            rutas_5 = String.valueOf(ruta_5);
            perdon.getReq_5().setSelected(true);
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
            perdon.getReq_6().setSelected(false);
        }
        
        if (s == JFileChooser.APPROVE_OPTION) {
            ruta_6 = j.getSelectedFile();
            rutas_6 = String.valueOf(ruta_6);
            perdon.getReq_6().setSelected(true);
        }
    }
    
    public void Num_Beneficiario() {
        
        perdon.getCb_numper().addItem("Seleccionar");
        perdon.getCb_numper().addItem("1");
        perdon.getCb_numper().addItem("2");
        perdon.getCb_numper().addItem("3");
        perdon.getCb_numper().addItem("4");
    }
    
    public void Campo_Bloqueado() {
        
        perdon.getTxt_id().setEditable(false);
        perdon.getTxt_cedula().setEditable(false);
        perdon.getBtn_guardar().setEnabled(true);
        perdon.getBtn_modificar().setEnabled(true);
        perdon.getBtn_pago().setEnabled(true);
        perdon.getBtn_cargar().setEnabled(false);
        perdon.getReq_1().setEnabled(true);
        perdon.getReq_2().setEnabled(true);
        perdon.getReq_3().setEnabled(true);
        perdon.getReq_4().setEnabled(true);
        perdon.getReq_5().setEnabled(true);
        perdon.getReq_6().setEnabled(true);
        perdon.getCb_numper().setEnabled(true);
        perdon.getTxa_oberv().setEnabled(true);
    }
    
    public void Campos() {
        
        perdon.getTxt_id().setEditable(false);
        perdon.getTxt_cedula().setEditable(false);
        perdon.getBtn_guardar().setEnabled(false);
        perdon.getBtn_modificar().setEnabled(false);
        perdon.getBtn_pago().setEnabled(false);
        perdon.getBtn_cargar().setEnabled(true);
        perdon.getReq_1().setEnabled(false);
        perdon.getReq_2().setEnabled(false);
        perdon.getReq_3().setEnabled(false);
        perdon.getReq_4().setEnabled(false);
        perdon.getReq_5().setEnabled(false);
        perdon.getReq_6().setEnabled(false);
        perdon.getCb_numper().setEnabled(false);
        perdon.getTxa_oberv().setEnabled(false);
    }
    
    public void Subir_Documento() {
        
        String num_beneficiarios = (String) perdon.getCb_numper().getSelectedItem();
        
        if (!num_beneficiarios.equals("Seleccionar")) {
            D.setId_caso(Integer.parseInt(perdon.getTxt_id().getText()));
            D.setCedula(perdon.getTxt_cedula().getText());

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
            
            int honorarios = 250 * Integer.parseInt(num_beneficiarios);
            D.setHonorarios(honorarios);
            
            D.setNum_beneficiarios(Integer.parseInt(num_beneficiarios));
            
            D.setObservacion(perdon.getTxa_oberv().getText());
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
        
        List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
        
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                try {
                    byte[] bi = List_caso.get(i).getReq_1();
                    if (bi != null) {
                        perdon.getReq_1().setSelected(true);
                        D.setReq_1(bi);
                    } else if (bi == null) {
                        perdon.getReq_1().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_2();
                    if (bi != null) {
                        perdon.getReq_2().setSelected(true);
                        D.setReq_2(bi);
                    } else if (bi == null) {
                        perdon.getReq_2().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_3();
                    if (bi != null) {
                        perdon.getReq_3().setSelected(true);
                        D.setReq_3(bi);
                    } else if (bi == null) {
                        perdon.getReq_3().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_4();
                    if (bi != null) {
                        perdon.getReq_4().setSelected(true);
                        D.setReq_4(bi);
                    } else if (bi == null) {
                        perdon.getReq_4().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_5();
                    if (bi != null) {
                        perdon.getReq_5().setSelected(true);
                        D.setReq_5(bi);
                    } else if (bi == null) {
                        perdon.getReq_5().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] bi = List_caso.get(i).getReq_6();
                    if (bi != null) {
                        perdon.getReq_6().setSelected(true);
                        D.setReq_6(bi);
                    } else if (bi == null) {
                        perdon.getReq_6().setSelected(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                perdon.getCb_numper().setSelectedItem(String.valueOf(List_caso.get(i).getNum_beneficiarios()));
                perdon.getTxa_oberv().setText(List_caso.get(i).getObservacion());
            }
        }
    }
    
    public void Validar_Guardar_Modificar() {
        
        List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
        
        for (int i = 0; i < List_caso.size(); i++) {
            if (!List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                perdon.getBtn_guardar().setEnabled(true);
                perdon.getBtn_modificar().setEnabled(false);
            } else if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                perdon.getBtn_guardar().setEnabled(false);
                perdon.getBtn_modificar().setEnabled(true);
                perdon.getCb_numper().setEnabled(false);
            }
        }
        
        if (List_caso.isEmpty()) {
            perdon.getBtn_guardar().setEnabled(true);
            perdon.getBtn_modificar().setEnabled(false);
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
            
            List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
            
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_1();
                        if (bi != null) {
                            perdon.getReq_1().setSelected(true);
                            D.setReq_1(bi);
                        } else if (bi == null) {
                            perdon.getReq_1().setSelected(false);
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
            
            List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
            
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_2();
                        if (bi != null) {
                            perdon.getReq_2().setSelected(true);
                            D.setReq_2(bi);
                        } else if (bi == null) {
                            perdon.getReq_2().setSelected(false);
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
            
            List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
            
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_3();
                        if (bi != null) {
                            perdon.getReq_3().setSelected(true);
                            D.setReq_3(bi);
                        } else if (bi == null) {
                            perdon.getReq_3().setSelected(false);
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
            
            List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
            
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_4();
                        if (bi != null) {
                            perdon.getReq_4().setSelected(true);
                            D.setReq_4(bi);
                        } else if (bi == null) {
                            perdon.getReq_4().setSelected(false);
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
            
            List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
            
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_5();
                        if (bi != null) {
                            perdon.getReq_5().setSelected(true);
                            D.setReq_5(bi);
                        } else if (bi == null) {
                            perdon.getReq_5().setSelected(false);
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
            
            List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
            
            for (int i = 0; i < List_caso.size(); i++) {
                if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                    try {
                        byte[] bi = List_caso.get(i).getReq_6();
                        if (bi != null) {
                            perdon.getReq_6().setSelected(true);
                            D.setReq_6(bi);
                        } else if (bi == null) {
                            perdon.getReq_6().setSelected(false);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        
        D.setObservacion(perdon.getTxa_oberv().getText());
        D.setId_caso(Integer.parseInt(perdon.getTxt_id().getText()));
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
        List<Buf_Caso_Perdon> List_caso = D_DB.Getter();
        List<Buf_Pagos> List_pago = P_DB.Getter();
        for (int i = 0; i < List_caso.size(); i++) {
            if (List_caso.get(i).getCedula().equals(perdon.getTxt_cedula().getText())) {
                pa.getTxt_cedula().setText(perdon.getTxt_cedula().getText());
                pa.getTxt_id().setText(String.valueOf(List_caso.get(i).getId_caso()));
                if (!List_pago.isEmpty()) {
                    for (int j = 0; j < List_pago.size(); j++) {
                        if (List_pago.get(j).getId_caso() != Integer.parseInt(perdon.getTxt_id().getText())) {
                            pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                        }
                    }
                } else {
                    pa.getTxt_a_pagar().setText(String.valueOf(List_caso.get(i).getHonorarios()));
                }
            }
        }
        p.Iniciar_Control();
        perdon.setVisible(false);
    }
}
