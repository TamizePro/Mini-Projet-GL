package Modele;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ElementModuleDAO implements IElementModuleDAO {
    private Connection connection;

    public ElementModuleDAO(Connection connection)
    {
        this.connection = connection;
    }

    private String get_isValidation(boolean val)
    {
        if (val)
            return "T";
        return "F";
    }

    private boolean getbool(String v)
    {
        if (v.equals("T"))
            return true;
        return false;
    }

    @Override
    public boolean AddElementModule(ElementModule elmod, Integer code_modal)
    {
        String sql = "insert into Element_Module(nom, coef, validation, code_modal) values(?, ?, ?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, elmod.getNom());
            preparedStatement.setString(2, String.valueOf(elmod.getCoefficient()));
            preparedStatement.setString(3, get_isValidation(elmod.isValidation()));
            if (code_modal == null)
                preparedStatement.setNull(4, Types.INTEGER);
            else
                preparedStatement.setString(4, String.valueOf(code_modal));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteElementModule(ElementModule elmod)
    {
        String sql = "delete from Element_Module where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(elmod.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateElementModuleByCode(ElementModule elmod, Integer code_modal)
    {
        String sql = "update Element_Module set nom = ?, coef = ?, validation = ?, code_modal = ? where code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, elmod.getNom());
            preparedStatement.setString(2, String.valueOf(elmod.getCoefficient()));
            preparedStatement.setString(3, get_isValidation(elmod.isValidation()));
            if (code_modal == null)
                preparedStatement.setNull(4, Types.INTEGER);
            else
                preparedStatement.setString(4, String.valueOf(code_modal));
            preparedStatement.setString(5, String.valueOf(elmod.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ElementModule GetElementModuleByCode(int code)
    {
        String sql = "select * from Element_Module where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(code));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new ElementModuleBuilder(resultSet.getString("nom"),
                    resultSet.getFloat("coef"))
                    .code(code)
                    .validation(getbool(resultSet.getString("validation")))
                    .build();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ElementModule> GetAllElementModule()
    {
        List<ElementModule> elmods = new ArrayList();
        String sql = "select * from Element_Module;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
            {
                elmods.add(new ElementModuleBuilder(resultSet.getString("nom"), resultSet.getFloat("coef"))
                .code(resultSet.getInt("code"))
                .validation(getbool(resultSet.getString("validation")))
                .build());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return elmods;
    }
}