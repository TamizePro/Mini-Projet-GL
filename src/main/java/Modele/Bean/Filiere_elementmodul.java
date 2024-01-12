package Modele.Bean;

public class Filiere_elementmodul {
    private int code_filiere;
    private int code_elementmodul;

    public Filiere_elementmodul(int code_filiere, int code_elementmodul){
        this.code_filiere = code_filiere;
        this.code_elementmodul = code_elementmodul;
    }
    public int getCode_filiere(){
        return code_filiere;
    }
    public void setCode_filiere(int code_filiere){
        this.code_filiere = code_filiere;
    }
    public int getCode_elementmodul(){
        return code_elementmodul;
    }
    public void setCode_elementmodul(int code_elementmodul){
        this.code_elementmodul = code_elementmodul;
    }
}
