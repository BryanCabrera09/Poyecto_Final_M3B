package InterfaceDAO;

import Modelo.Buf_Persona;
import java.util.List;

/*
 * @author BRYAN_CABRERA
 */
public interface Buf_PersonaDAO {

    public boolean Register(Buf_Persona persona);

    public List<Buf_Persona> Getter();
    
    public List<Buf_Persona> Getter_Secre();
    
    public List<Buf_Persona> Getter_Abg();

    public boolean Update(Buf_Persona persona);

    public boolean Delete(Buf_Persona persona);
    
    public List<Buf_Persona> Search_Abg(String per);
    
    public List<Buf_Persona> Search_Secre(String per);
}
