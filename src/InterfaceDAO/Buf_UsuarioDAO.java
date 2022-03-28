package InterfaceDAO;

import Modelo.Buf_Usuarios;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_UsuarioDAO {

    public boolean Register(Buf_Usuarios user);

    public List<Buf_Usuarios> Getter();

    public boolean Update(Buf_Usuarios user);

    public boolean Delete(Buf_Usuarios user);
}
