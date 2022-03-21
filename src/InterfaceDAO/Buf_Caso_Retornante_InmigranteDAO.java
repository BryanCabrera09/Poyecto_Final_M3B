package InterfaceDAO;

import Modelo.Buf_Caso_Retornante_Inmigrante;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_Caso_Retornante_InmigranteDAO {

    public boolean Register(Buf_Caso_Retornante_Inmigrante casretinmi);

    public List<Buf_Caso_Retornante_Inmigrante> Getter();

    public boolean Update(Buf_Caso_Retornante_Inmigrante casretinmi);

    public boolean Delete(Buf_Caso_Retornante_Inmigrante casretinmi);
}
