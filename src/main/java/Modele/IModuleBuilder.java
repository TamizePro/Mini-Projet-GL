package Modele;

import java.util.List;

public interface IModuleBuilder {
    //
    public ModuleBuilder code(int code);
    public ModuleBuilder Vald(boolean val);
    public ModuleBuilder elmods(List<ElementModule> elmods);
}
