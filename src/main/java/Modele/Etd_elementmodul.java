package Modele;

public class Etd_elementmodul {
    private int id;
    private long code_etd;
    private int code_elementmodul;

    public Etd_elementmodul(long code_etd, int code_elementmodul){
        this.code_etd = code_etd;
        this.code_elementmodul = code_elementmodul;
    }

    public Etd_elementmodul(int id, long code_etd, int code_elementmodul){
        this.id = id;
        this.code_etd = code_etd;
        this.code_elementmodul = code_elementmodul;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public long getCode_etd(){
        return code_etd;
    }
    public void setCode_etd(long code_etd){
        this.code_etd = code_etd;
    }
    public int getCode_elementmodul(){
        return code_elementmodul;
    }
    public void setCode_elementmodul(int code_elementmodul){
        this.code_elementmodul = code_elementmodul;
    }
}
