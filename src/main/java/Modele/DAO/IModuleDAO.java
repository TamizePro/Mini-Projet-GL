package Modele.DAO;
import Modele.Bean.Module;

import java.util.List;

public interface IModuleDAO {
    //
    public boolean AddModule(Module mod, Integer code_elmodul);
    public boolean DeleteModule(Module mod);
    public boolean UpdateModuleByCode(Module mod, Integer code_elmodul);
    public Module GetModuleByCode(int code);
    public List<Module> GetAllModule();
}
