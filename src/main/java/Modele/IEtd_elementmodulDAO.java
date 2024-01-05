package Modele;

import java.util.List;

public interface IEtd_elementmodulDAO {
    //
    public boolean AddEtd_elementmodul(Etd_elementmodul etdel);
    public boolean DeleteEtd_elementmodul(Etd_elementmodul etdel);
    public boolean UpdateEtd_elementmodulByCode(Etd_elementmodul etdel);
    public Etd_elementmodul GetEtd_elementmodulByCode(int code);
    public List<Etd_elementmodul> GetAllEtd_elementmodul();
}
