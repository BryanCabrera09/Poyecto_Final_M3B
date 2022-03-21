package InterfaceDAO;

import Modelo.Buf_Usuario;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_UsuarioDAO {

    public boolean Register(Buf_Usuario user);

    public List<Buf_Usuario> Getter();

    public boolean Update(Buf_Usuario user);

    public boolean Delete(Buf_Usuario user);
}
