
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Abogado extends Buf_Persona {

    private int id_abg;
    private int num_matricula;
    private int num_cuenta;
    private String horario;
    private byte[] foto;
    
    public Buf_Abogado(String cedula, String nombre, String apellido, String correo, String direccion, String num_celular, String estado_civil, String fecha_Nacimiento, int id_abg, int num_matricula, int num_cuenta, String horario, byte[] foto) {
        
        super(cedula, nombre, apellido, correo, direccion, num_celular, estado_civil, fecha_Nacimiento);
        this.id_abg = id_abg;
        this.num_matricula = num_matricula;
        this.num_cuenta = num_cuenta;
        this.horario = horario;
        this.foto = foto;
    }

    public Buf_Abogado() {
    }

    public int getId_abg() {
        return id_abg;
    }

    public void setId_abg(int id_abg) {
        this.id_abg = id_abg;
    }

    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public int getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
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
