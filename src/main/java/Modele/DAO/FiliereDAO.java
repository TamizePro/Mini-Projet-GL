package Modele.DAO;
import Modele.Bean.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class FiliereDAO implements IFiliereDAO {
    private Connection connection;

    public FiliereDAO(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public boolean AddFiliere(Filiere filiere)
    {
        String sql = "insert into Filiere(code, nom) values(?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, String.valueOf(filiere.getCode()));
            preparedStatement.setString(2, filiere.getNom());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteFiliere(Filiere filiere)
    {
        String sql = "delete from Filiere where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(filiere.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateFiliereByCode(Filiere filiere, int code)
    {
        String sql = "update Filiere set code = ?, nom = ? where code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(filiere.getCode()));
            preparedStatement.setString(2, filiere.getNom());
            preparedStatement.setString(3, String.valueOf(code));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Filiere GetFiliereByCode(int code)
    {
        String sql = "select * from Filiere where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(code));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new FiliereBuilder(resultSet.getInt("code"),
                    resultSet.getString("nom")).build();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Filiere> GetAllFiliere()
    {
        List<Filiere> filieres = new ArrayList();
        String sql = "select * from Filiere;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
                filieres.add(new FiliereBuilder(resultSet.getInt("code"),
                    resultSet.getString("nom")).build());
        } catch (SQLException e){
            e.printStackTrace();
        }
        return filieres;
    }
}