package InterfaceDAO;

import Modelo.Buf_Caso_Visa_Mexico;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Visa_MexicoDAO {

    public boolean Register(Buf_Caso_Visa_Mexico casvisamex);

    public List<Buf_Caso_Visa_Mexico> Getter();

    public boolean Update(Buf_Caso_Visa_Mexico casvisamex);

    public boolean Delete(Buf_Caso_Visa_Mexico casvisamex);
}
