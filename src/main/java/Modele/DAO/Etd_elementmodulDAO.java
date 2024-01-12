package Modele.DAO;
import Modele.Bean.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Etd_elementmodulDAO implements IEtd_elementmodulDAO {
    private Connection connection;

    public Etd_elementmodulDAO(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public boolean AddEtd_elementmodul(Etd_elementmodul etdel)
    {
        String sql = "insert into Etd_elementmodul(code_etd, code_elementmodul) values(?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, String.valueOf(etdel.getCode_etd()));
            preparedStatement.setString(2, String.valueOf(etdel.getCode_elementmodul()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteEtd_elementmodul(Etd_elementmodul etdel)
    {
        String sql = "delete from Etd_elementmodul where id = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(etdel.getId()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateEtd_elementmodulByCode(Etd_elementmodul etdel)
    {
        String sql = "update Etd_elementmodul set code_etd = ?, code_elementmodul = ? where id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(etdel.getCode_etd()));
            preparedStatement.setString(2, String.valueOf(etdel.getCode_elementmodul()));
            preparedStatement.setString(3, String.valueOf(etdel.getId()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Etd_elementmodul GetEtd_elementmodulByCode(int code)
    {
        String sql = "select * from Etd_elementmodul where id = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(code));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Etd_elementmodul(resultSet.getInt("id"), resultSet.getLong("code_etd"),
                    resultSet.getInt("code_elementmodul"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Etd_elementmodul> GetAllEtd_elementmodul()
    {
        List<Etd_elementmodul> listes = new ArrayList();
        String sql = "select * from Etd_elementmodul;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
            {
                listes.add(new Etd_elementmodul(resultSet.getInt("id"), resultSet.getLong("code_etd"),
                resultSet.getInt("code_elementmodul")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listes;
    }
}