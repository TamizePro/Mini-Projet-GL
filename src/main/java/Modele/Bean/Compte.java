package Modele.Bean;

public class Compte {
    private String login;
    private String password;

    public Compte(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (!(o instanceof Compte))
            return false;
        Compte oo = (Compte) o;
        return oo.login.equals(login) && oo.password.equals(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
