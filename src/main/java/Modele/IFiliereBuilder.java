package Modele;

import java.util.List;
import java.util.Set;

public interface IFiliereBuilder {
    //
    public FiliereBuilder etd_elementmoduls(Set<Etd_elementmodul> etd_elementmoduls);
    public FiliereBuilder modules(List<Module> listmodules);
}
