package Modele.Bean;

import java.util.List;
import java.util.Set;

public interface IFiliereBuilder {
    //
    public FiliereBuilder Fil_elementmoduls(Set<Filiere_elementmodul> fil_elementmoduls);
    public FiliereBuilder modules(List<Module> listmodules);
}
