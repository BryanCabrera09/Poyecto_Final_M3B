
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Caso_Perdon {
    
    private int id_caso;
    private String cedula;
    private byte[] req_1;
    private byte[] req_2;
    private byte[] req_3;
    private byte[] req_4;
    private byte[] req_5;
    private byte[] req_6;
    private double honorarios;
    private int num_beneficiarios;
    private String observacion;

    public Buf_Caso_Perdon(int id_caso, String cedula, byte[] req_1, byte[] req_2, byte[] req_3, byte[] req_4, byte[] req_5, byte[] req_6, double honorarios, int num_beneficiarios, String observacion) {
        this.id_caso = id_caso;
        this.cedula = cedula;
        this.req_1 = req_1;
        this.req_2 = req_2;
        this.req_3 = req_3;
        this.req_4 = req_4;
        this.req_5 = req_5;
        this.req_6 = req_6;
        this.honorarios = honorarios;
        this.num_beneficiarios = num_beneficiarios;
        this.observacion = observacion;
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

    public byte[] getReq_1() {
        return req_1;
    }

    public void setReq_1(byte[] req_1) {
        this.req_1 = req_1;
    }

    public byte[] getReq_2() {
        return req_2;
    }

    public void setReq_2(byte[] req_2) {
        this.req_2 = req_2;
    }

    public byte[] getReq_3() {
        return req_3;
    }

    public void setReq_3(byte[] req_3) {
        this.req_3 = req_3;
    }

    public byte[] getReq_4() {
        return req_4;
    }

    public void setReq_4(byte[] req_4) {
        this.req_4 = req_4;
    }

    public byte[] getReq_5() {
        return req_5;
    }

    public void setReq_5(byte[] req_5) {
        this.req_5 = req_5;
    }

    public byte[] getReq_6() {
        return req_6;
    }

    public void setReq_6(byte[] req_6) {
        this.req_6 = req_6;
    }

    public double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(double honorarios) {
        this.honorarios = honorarios;
    }

    public int getNum_beneficiarios() {
        return num_beneficiarios;
    }

    public void setNum_beneficiarios(int num_beneficiarios) {
        this.num_beneficiarios = num_beneficiarios;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
