package InterfaceDAO;

import Modelo.Buf_Secretaria;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_SecretariaDAO {

    public boolean Register(Buf_Secretaria secre);

    public List<Buf_Secretaria> Getter();

    public boolean Update(Buf_Secretaria secre);

    public boolean Delete(Buf_Secretaria secre);
}
