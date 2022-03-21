package InterfaceDAO;

import Modelo.Buf_Pagos;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_PagosDAO {

    public boolean Register(Buf_Pagos pagos);

    public List<Buf_Pagos> Getter();

    public boolean Update(Buf_Pagos pagos);

    public boolean Delete(Buf_Pagos pagos);
}
