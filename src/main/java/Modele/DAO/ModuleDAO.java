package Modele.DAO;
import Modele.Bean.Module;
import Modele.Bean.*;
import Modele.MySQLConnection;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ModuleDAO implements IModuleDAO {
    private Connection connection;

    public ModuleDAO(Connection connection)
    {
        this.connection = connection;
    }
    
    private String get_isvalid(boolean val)
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
    public boolean AddModule(Module mod, Integer code_elmodul)
    {
        String sql = "insert into Module(nom, semestre, validation, code_elmodul) values(?, ?, ?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, mod.getNom());
            preparedStatement.setString(2, mod.getSemestre());
            preparedStatement.setString(3, get_isvalid(mod.isValidation()));
            if (code_elmodul == null)
                preparedStatement.setNull(4, Types.INTEGER);
            else
                preparedStatement.setString(4, String.valueOf(code_elmodul));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteModule(Module mod)
    {
        String sql = "delete from Module where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(mod.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateModuleByCode(Module mod, Integer code_elmodul)
    {
        String sql = "update Module set nom = ?, semestre = ?, validation = ?, code_elmodul = ? where code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mod.getNom());
            preparedStatement.setString(2, mod.getSemestre());
            preparedStatement.setString(3, get_isvalid(mod.isValidation()));
            if (code_elmodul == null)
                preparedStatement.setNull(4, Types.INTEGER);
            else
                preparedStatement.setString(4, String.valueOf(code_elmodul));
            preparedStatement.setString(5, String.valueOf(mod.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Module GetModuleByCode(int code)
    {
        String sql = "select * from Module where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(code));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new ModuleBuilder(resultSet.getString("nom"), resultSet.getString("semestre"))
                    .code(code)
                    .Vald(getbool(resultSet.getString("validation")))
                    .build();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Module> GetAllModule()
    {
        List<Module> mods = new ArrayList();
        String sql = "select * from Module;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
            {
                mods.add(new ModuleBuilder(resultSet.getString("nom"), resultSet.getString("semestre"))
                .code(resultSet.getInt("code"))
                .Vald(getbool(resultSet.getString("validation")))
                .build());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return mods;
    }
}