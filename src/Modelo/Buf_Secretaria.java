
package Modelo;

import java.util.Date;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Secretaria extends Buf_Persona{
   
    private int id_secretaria;
    private int id_abg;
    private String horario;
    private byte[] foto;

    public Buf_Secretaria(String cedula, String nombre, String apellido, String correo, String direccion, String num_celular, String estado_civil, Date fecha_Nacimiento, int id_secretaria, int id_abg, String horario, byte[] foto) {
        super(cedula, nombre, apellido, correo, direccion, num_celular, estado_civil, fecha_Nacimiento);
        this.id_secretaria = id_secretaria;
        this.id_abg = id_abg;
        this.horario = horario;
        this.foto = foto;
    }

    public int getId_secretaria() {
        return id_secretaria;
    }

    public void setId_secretaria(int id_secretaria) {
        this.id_secretaria = id_secretaria;
    }

    public int getId_abg() {
        return id_abg;
    }

    public void setId_abg(int id_abg) {
        this.id_abg = id_abg;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
