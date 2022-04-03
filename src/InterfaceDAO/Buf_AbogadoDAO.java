package InterfaceDAO;

import Modelo.Buf_Abogado;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_AbogadoDAO {

    public boolean Register(Buf_Abogado abg);

    public List<Buf_Abogado> Getter();

    public boolean Update(Buf_Abogado abg);

    public boolean Delete(Buf_Abogado abg);

    public List<Buf_Abogado> Search(String abg);
}
