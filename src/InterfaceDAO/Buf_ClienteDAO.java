package InterfaceDAO;

import Modelo.Buf_Cliente;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_ClienteDAO {

    public boolean Register(Buf_Cliente cliente);

    public List<Buf_Cliente> Getter();

    public boolean Update(Buf_Cliente cliente);

    public boolean Delete(Buf_Cliente cliente);
}
