package InterfaceDAO;

import Modelo.Buf_Caso_Perdon;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_PerdonDAO {

    public boolean Register(Buf_Caso_Perdon casper);

    public List<Buf_Caso_Perdon> Getter();

    public boolean Update(Buf_Caso_Perdon casper);

    public boolean Delete(Buf_Caso_Perdon casper);
}
