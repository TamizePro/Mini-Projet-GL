package Modele.DAO;
import Modele.Bean.*;

import java.util.List;

public interface IFiliereDAO {
    //
    public boolean AddFiliere(Filiere filiere);
    public boolean DeleteFiliere(Filiere filiere);
    public boolean UpdateFiliereByCode(Filiere filiere, int code);
    public Filiere GetFiliereByCode(int code);
    public List<Filiere> GetAllFiliere();
}
