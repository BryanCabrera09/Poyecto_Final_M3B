package InterfaceDAO;

import Modelo.Buf_Caso_Renovacion_Pasaporte;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Renovacion_PasaporteDAO {

    public boolean Register(Buf_Caso_Renovacion_Pasaporte casrenopass);

    public List<Buf_Caso_Renovacion_Pasaporte> Getter();

    public boolean Update(Buf_Caso_Renovacion_Pasaporte casrenopass);

    public boolean Delete(Buf_Caso_Renovacion_Pasaporte casrenopass);
}
