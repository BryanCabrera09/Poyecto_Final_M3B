package InterfaceDAO;

import Modelo.Buf_Caso_Pension_Aliment;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Pension_AlimentDAO {

    public boolean Register(Buf_Caso_Pension_Aliment caspenali);

    public List<Buf_Caso_Pension_Aliment> Getter();

    public boolean Update(Buf_Caso_Pension_Aliment caspenali);

    public boolean Delete(Buf_Caso_Pension_Aliment caspenali);
}
