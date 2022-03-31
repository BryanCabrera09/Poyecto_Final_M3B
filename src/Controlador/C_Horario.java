/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Abogado;
import vista.Horario;
import static vista.RegistroAbogado.Lista_abogado;

/*
 * @author BRYAN_CABRERA
 */
public class C_Horario implements ActionListener {

    Horario horario;
    DefaultTableModel modelo;

    public C_Horario(Horario horario) {
        this.horario = horario;
        this.horario.btnbuscar.addActionListener(this);
        cargarDatos();
    }

    public void cargarDatos() {
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
        for (Abogado horarioabo : Lista_abogado) {
            Object[] fila = new Object[4];
            fila[0] = horarioabo.getCedula();
            fila[1] = horarioabo.getNombre();
            fila[2] = horarioabo.getApellidos();
            fila[3] = horarioabo.getRegistro_horario();
            modelo.addRow(fila);
        }
        horario.tablaabogados.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==horario.btnbuscar) {
            System.out.println("Entroa buscar la cedula");
            for (int i = 0; i < Lista_abogado.size(); i++) {
            if (horario.txtbuscar.getText().equals(Lista_abogado.get(i).getCedula())) {
                horario.tablaabogados.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "CEDULA NO EXISTE");
            }
        }
        }
    }
}
