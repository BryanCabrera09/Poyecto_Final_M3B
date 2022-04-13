
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Pagos {
    
    private int id_pago;
    private int id_caso;
    private String cedula;
    private String Fecha_Pago;
    private double abono;
    private double saldo;

    public Buf_Pagos(int id_pago, int id_caso, String cedula, String Fecha_Pago, double abono, double saldo) {
        this.id_pago = id_pago;
        this.id_caso = id_caso;
        this.cedula = cedula;
        this.Fecha_Pago = Fecha_Pago;
        this.abono = abono;
        this.saldo = saldo;
    }

    public Buf_Pagos() {
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_caso() {
        return id_caso;
    }

    public void setId_caso(int id_caso) {
        this.id_caso = id_caso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFecha_Pago() {
        return Fecha_Pago;
    }

    public void setFecha_Pago(String Fecha_Pago) {
        this.Fecha_Pago = Fecha_Pago;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
