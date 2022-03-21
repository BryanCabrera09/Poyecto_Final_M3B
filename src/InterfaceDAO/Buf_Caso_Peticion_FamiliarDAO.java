package InterfaceDAO;

import Modelo.Buf_Caso_Peticion_Familiar;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Peticion_FamiliarDAO {

    public boolean Register(Buf_Caso_Peticion_Familiar caspetfami);

    public List<Buf_Caso_Peticion_Familiar> Getter();

    public boolean Update(Buf_Caso_Peticion_Familiar caspetfami);

    public boolean Delete(Buf_Caso_Peticion_Familiar caspetfami);
}
