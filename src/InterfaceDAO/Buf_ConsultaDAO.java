package InterfaceDAO;

import Modelo.Buf_Consulta;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_ConsultaDAO {

    public boolean Register(Buf_Consulta consulta);

    public List<Buf_Consulta> Getter();

    public boolean Update(Buf_Consulta consulta);

    public boolean Delete(Buf_Consulta consulta);
}
