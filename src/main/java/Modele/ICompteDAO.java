package Modele;

import java.util.List;

public interface ICompteDAO {
    //
    public boolean AddCompte(Compte compte);
    public boolean DeleteCompte(Compte compte);
    public boolean UpdateCompteByLogin(Compte compte, String login);
    public Compte GetCompte(String login, String password);
    public List<Compte> GetAllCompte();
}
