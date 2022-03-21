package InterfaceDAO;

import Modelo.Buf_Caso_Visa_Europa;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Visa_EuropaDAO {

    public boolean Register(Buf_Caso_Visa_Europa casviseuro);

    public List< Buf_Caso_Visa_Europa> Getter();

    public boolean Update(Buf_Caso_Visa_Europa casviseuro);

    public boolean Delete(Buf_Caso_Visa_Europa casviseuro);
}
