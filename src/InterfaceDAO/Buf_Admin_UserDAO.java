package InterfaceDAO;

import Modelo.Buf_Admin_User;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Admin_UserDAO {

    public boolean Register(Buf_Admin_User useradmin);

    public List<Buf_Admin_User> Getter();

    public boolean Update(Buf_Admin_User useradmin);

    public boolean Delete(Buf_Admin_User useradmin);
}
