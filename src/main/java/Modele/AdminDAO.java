package Modele;

import java.sql.*;

public class AdminDAO implements IAdminDAO {
    private Connection connection;
    public static Admin admin = null;

    public AdminDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public Admin getAdmin(Compte compte){
        String sql = "select * from Admin where compte_login = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, compte.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                admin = Admin.getInstance(compte, resultSet.getString("nom"),
                resultSet.getString("prenom"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return admin;
    }
}