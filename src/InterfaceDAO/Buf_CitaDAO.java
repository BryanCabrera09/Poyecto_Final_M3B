package InterfaceDAO;

import Modelo.Buf_Cita;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_CitaDAO {

    public boolean Register(Buf_Cita cita);

    public List<Buf_Cita> Getter();

    public boolean Update(Buf_Cita cita);

    public boolean Delete(Buf_Cita cita);
}
