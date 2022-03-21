package InterfaceDAO;

import Modelo.Buf_Caso;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_CasoDAO {

    public boolean Register(Buf_Caso caso);

    public List<Buf_Caso> Getter();

    public boolean Update(Buf_Caso caso);

    public boolean Delete(Buf_Caso caso);
}
