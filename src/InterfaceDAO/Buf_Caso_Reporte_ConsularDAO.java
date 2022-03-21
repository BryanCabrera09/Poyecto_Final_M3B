package InterfaceDAO;

import Modelo.Buf_Caso_Reporte_Consular;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Reporte_ConsularDAO {

    public boolean Register(Buf_Caso_Reporte_Consular casrepcons);

    public List<Buf_Caso_Reporte_Consular> Getter();

    public boolean Update(Buf_Caso_Reporte_Consular casrepcons);

    public boolean Delete(Buf_Caso_Reporte_Consular casrepcons);
}
