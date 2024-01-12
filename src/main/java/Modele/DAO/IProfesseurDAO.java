package Modele.DAO;
import Modele.Bean.*;

import java.util.List;

public interface IProfesseurDAO {
    //
    public boolean AddProfesseur(Professeur professeur);
    public boolean DeleteProfesseur(Professeur professeur);
    public boolean UpdateProfesseurByCode(Professeur professeur, Long code);
    public Professeur GetProfesseurByCode(Long code, Compte compte);
    public List<Professeur> GetAllProfesseur();
}
