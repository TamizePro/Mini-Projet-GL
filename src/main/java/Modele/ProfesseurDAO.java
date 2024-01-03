package Modele;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProfesseurDAO implements IProfesseurDAO {
    private Connection connection;

    public ProfesseurDAO(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public boolean AddProfesseur(Professeur professeur)
    {
        String sql = "insert into Professeur values(?, ?, ?, ?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, String.valueOf(professeur.getCode()));
            preparedStatement.setString(2, professeur.getNom());
            preparedStatement.setString(3, professeur.getPrenom());
            preparedStatement.setString(4, professeur.getSpecialite());
            preparedStatement.setString(5, professeur.getCompte().getLogin());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteProfesseur(Professeur professeur)
    {
        String sql = "delete from Professeur where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(professeur.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateProfesseurByCode(Professeur professeur, Long code)
    {
        String sql = "update Professeur set code = ?, nom = ?, prenom = ?, specialite = ?, compte_login = ? where code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(professeur.getCode()));
            preparedStatement.setString(2, professeur.getNom());
            preparedStatement.setString(3, professeur.getPrenom());
            preparedStatement.setString(4, professeur.getSpecialite());
            preparedStatement.setString(5, professeur.getCompte().getLogin());
            preparedStatement.setString(6, String.valueOf(code));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Professeur GetProfesseurByCode(Long code, Compte compte)
    {
        String sql = "select * from Professeur where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(code));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new ProfesseurBuilder(resultSet.getString("nom"),
                    resultSet.getString("prenom"), resultSet.getString("specialite"),
                    resultSet.getLong("code")).compte(compte).build();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Professeur> GetAllProfesseur()
    {
        List<Professeur> professeurs = new ArrayList();
        String sql = "select * from Professeur;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
            {
                professeurs.add(new ProfesseurBuilder(resultSet.getString("nom"),
                resultSet.getString("prenom"), resultSet.getString("specialite"),
                resultSet.getLong("code"))
                .build());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return professeurs;
    }
}