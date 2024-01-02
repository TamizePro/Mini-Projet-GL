package Modele;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CompteDAO implements ICompteDAO{
    private Connection connection;

    public CompteDAO(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public boolean AddCompte(Compte compte)
    {
        String sql = "insert into Compte values(?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, compte.getLogin());
            preparedStatement.setString(2, compte.getPassword());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean DeleteCompte(Compte compte)
    {
        String sql = "delete from Compte where login = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, compte.getLogin());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    // Pas de valeurs nulles pour les attributs de compte
    public boolean UpdateCompteByLogin(Compte compte, String login)
    {
        String sql = "update Compte set login = ?, password = ? where login = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, compte.getLogin());
            preparedStatement.setString(2, compte.getPassword());
            preparedStatement.setString(3, login);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public Compte GetCompte(String login, String password)
    {
        String sql = "select from Compte where login = ? and password = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                return new Compte(resultSet.getString("login"), resultSet.getString("password"));
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public List<Compte> GetAllCompte()
    {
        List<Compte> comptes = new ArrayList();
        String sql = "select * from Compte;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
                comptes.add(new Compte(resultSet.getString("login"), resultSet.getString("password")));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return comptes;
    }
}