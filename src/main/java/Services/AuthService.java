package Services;

import Modele.Bean.Compte;
import Modele.DAO.CompteDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class AuthService implements IAuthService {

    private CompteDAO compteDAO;

    public AuthService(Connection connection)
    {
        this.compteDAO = new CompteDAO(connection);
    }

    @Override
    public String hashPassword(String password)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byteData = md.digest();

            // Convert the byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Compte authenticate(String username, String password) {
        
        return compteDAO.GetCompte(username, password);
    }
}
