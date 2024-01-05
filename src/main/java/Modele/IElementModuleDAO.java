package Modele;

import java.util.List;

public interface IElementModuleDAO {
    //
    public boolean AddElementModule(ElementModule elmod, Integer code_modal);
    public boolean DeleteElementModule(ElementModule elmod);
    public boolean UpdateElementModuleByCode(ElementModule elmod, Integer code_modal);
    public ElementModule GetElementModuleByCode(int code);
    public List<ElementModule> GetAllElementModule();
}
