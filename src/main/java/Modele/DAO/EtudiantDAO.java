package Modele.DAO;
import Modele.Bean.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class EtudiantDAO implements IEtudiantDAO {
    private Connection connection;

    public EtudiantDAO(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public boolean AddEtudiant(Etudiant etd)
    {
        String sql = "insert into Etudiant(code, nom, prenom) values(?, ?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, String.valueOf(etd.getCode()));
            preparedStatement.setString(2, etd.getNom());
            preparedStatement.setString(3, etd.getPrenom());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteEtudiant(Etudiant etd)
    {
        String sql = "delete from Etudiant where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(etd.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateEtudiantByCode(Etudiant etd, Long code)
    {
        String sql = "update Etudiant set code = ?, nom = ?, prenom = ? where code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(etd.getCode()));
            preparedStatement.setString(2, etd.getNom());
            preparedStatement.setString(3, etd.getPrenom());
            preparedStatement.setString(4, String.valueOf(code));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Etudiant GetEtudiantByCode(Long code)
    {
        String sql = "select * from Etudiant where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(code));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new EtudiantBuilder(resultSet.getLong("code"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom")).build();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Etudiant> GetAllEtudiant()
    {
        List<Etudiant> etudiants = new ArrayList();
        String sql = "select * from Etudiant;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
                etudiants.add(new EtudiantBuilder(resultSet.getLong("code"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom")).build());
        } catch (SQLException e){
            e.printStackTrace();
        }
        return etudiants;
    }
}