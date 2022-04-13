/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Buf_AbogadoDB;
import Modelo.Buf_Persona;
import Modelo.Buf_Abogado;
import Modelo.Buf_PersonaDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.V_Horario;

/*
 * @author BRYAN_CABRERA
 */
public class C_Horario {

    V_Horario horario;
    DefaultTableModel modelo;

    Buf_PersonaDB P_DB = new Buf_PersonaDB();
    Buf_AbogadoDB A_DB = new Buf_AbogadoDB();

    public C_Horario(V_Horario horario) {

        this.horario = horario;

        Cargar_Datos();
    }

    public void Iniciar_Control() {

        KeyListener K = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getSource() == horario.getTxt_buscar()) {
                    Buscar();
                }
            }
        };
        horario.getTxt_buscar().addKeyListener(K);
    }

    public void Cargar_Datos() {

        horario.getTableabogados().getTableHeader().setResizingAllowed(false);
        horario.getTableabogados().getTableHeader().setReorderingAllowed(false);

        modelo = new DefaultTableModel() {
            public boolean isceleditable(int fila, int columnas) {
                if (columnas == 4) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("HORARIO");

        List<Buf_Persona> List_per = P_DB.Getter_Abg();
        List<Buf_Abogado> List_abg = A_DB.Getter();

        for (Buf_Abogado abogado : List_abg) {
            for (Buf_Persona persona : List_per) {
                Object[] fila = new Object[4];
                fila[0] = persona.getCedula();
                fila[1] = persona.getNombre();
                fila[2] = persona.getApellido();
                fila[3] = abogado.getHorario();
                modelo.addRow(fila);
            }
        }
        horario.getTableabogados().setModel(modelo);
    }

    public void Actualizar_Tabla() {

        List<Buf_Persona> List_per = P_DB.Getter_Abg();
        List<Buf_Abogado> List_abg = A_DB.Getter();

        for (Buf_Abogado abogado : List_abg) {
            for (Buf_Persona persona : List_per) {
                Object[] fila = new Object[4];
                fila[0] = persona.getCedula();
                fila[1] = persona.getNombre();
                fila[2] = persona.getApellido();
                fila[3] = abogado.getHorario();
                modelo.addRow(fila);
            }
        }
        horario.getTableabogados().setModel(modelo);
    }

    public void Buscar() {

        if (horario.getTxt_buscar().getText().isEmpty()) {

            Actualizar_Tabla();
        }

        modelo.setRowCount(0);
        List<Buf_Persona> List_per = P_DB.Search_Abg(horario.getTxt_buscar().getText());
        List<Buf_Abogado> List_abg = A_DB.Search(horario.getTxt_buscar().getText());

        for (Buf_Abogado abogado : List_abg) {
            for (Buf_Persona persona : List_per) {
                Object[] fila = new Object[4];
                fila[0] = persona.getCedula();
                fila[1] = persona.getNombre();
                fila[2] = persona.getApellido();
                fila[3] = abogado.getHorario();
                modelo.addRow(fila);
            }
        }
        horario.getTableabogados().setModel(modelo);
    }
}
