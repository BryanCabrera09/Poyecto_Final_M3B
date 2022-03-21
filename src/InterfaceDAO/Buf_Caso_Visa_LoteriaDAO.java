package InterfaceDAO;

import Modelo.Buf_Caso_Visa_Loteria;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Visa_LoteriaDAO {

    public boolean Register(Buf_Caso_Visa_Loteria casvislote);

    public List<Buf_Caso_Visa_Loteria> Getter();

    public boolean Update(Buf_Caso_Visa_Loteria casvislote);

    public boolean Delete(Buf_Caso_Visa_Loteria casvislote);
}
