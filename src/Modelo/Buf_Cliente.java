
package Modelo;

import java.sql.Date;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Cliente extends Buf_Persona {
    
    private int id_cliente;
    private String ocupacion;
    private int id_abg;

    public Buf_Cliente(String cedula, String nombre, String apellido, String correo, String direccion, String num_celular, String estado_civil, Date fecha_Nacimiento, int id_cliente, String ocupacion, int id_abg) {
        super(cedula, nombre, apellido, correo, direccion, num_celular, estado_civil, fecha_Nacimiento);
        this.id_cliente = id_cliente;
        this.ocupacion = ocupacion;
        this.id_abg = id_abg;
    }

    public Buf_Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getId_abg() {
        return id_abg;
    }

    public void setId_abg(int id_abg) {
        this.id_abg = id_abg;
    }
    
}
