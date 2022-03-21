package InterfaceDAO;

import Modelo.Buf_Caso_Divorcio;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_DivorcioDAO {

    public boolean Register(Buf_Caso_Divorcio casdivor);

    public List<Buf_Caso_Divorcio> Getter();

    public boolean Update(Buf_Caso_Divorcio casdivor);

    public boolean Delete(Buf_Caso_Divorcio casdivor);
}
