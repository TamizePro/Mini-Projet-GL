package Modele.DAO;
import Modele.Bean.*;

import java.util.List;

public interface IEtudiantDAO {
    //
    public boolean AddEtudiant(Etudiant etd);
    public boolean DeleteEtudiant(Etudiant etd);
    public boolean UpdateEtudiantByCode(Etudiant etd, Long code);
    public Etudiant GetEtudiantByCode(Long code);
    public List<Etudiant> GetAllEtudiant();
}
