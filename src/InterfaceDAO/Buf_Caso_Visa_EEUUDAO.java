package InterfaceDAO;

import Modelo.Buf_Caso_Visa_EEUU;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Visa_EEUUDAO {

    public boolean Register(Buf_Caso_Visa_EEUU casviseeuu);

    public List<Buf_Caso_Visa_EEUU> Getter();

    public boolean Update(Buf_Caso_Visa_EEUU casviseeuu);

    public boolean Delete(Buf_Caso_Visa_EEUU casviseeuu);
}
