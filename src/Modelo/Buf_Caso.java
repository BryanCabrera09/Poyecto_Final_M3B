
package Modelo;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_Caso {
    
    private int id_caso;
    private String cedula;
    private String caso;

    public Buf_Caso(int id_caso, String cedula, String caso) {
        this.id_caso = id_caso;
        this.cedula = cedula;
        this.caso = caso;
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

    public String getCaso() {
        return caso;
    }

    public void setCaso(String caso) {
        this.caso = caso;
    }
    
}
