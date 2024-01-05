package Modele;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ModaliteEvaluationDAO implements IModaliteEvaluationDAO {
    private Connection connection;

    public ModaliteEvaluationDAO(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public boolean AddModaliteEvaluation(ModaliteEvaluation modal, int code_note)
    {
        String sql = "insert into Modalite_Evaluation(nom, coef, code_note) values(?, ?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, modal.getNom());
            preparedStatement.setString(2, String.valueOf(modal.getCoefficient()));
            preparedStatement.setString(3, String.valueOf(code_note));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteModaliteEvaluation(ModaliteEvaluation modal)
    {
        String sql = "delete from Modalite_Evaluation where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(modal.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateModaliteEvaluationByCode(ModaliteEvaluation modal, int code_note)
    {
        String sql = "update Modalite_Evaluation set nom = ?, coef = ?, code_note = ? where code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, modal.getNom());
            preparedStatement.setString(2, String.valueOf(modal.getCoefficient()));
            preparedStatement.setString(3, String.valueOf(code_note));
            preparedStatement.setString(4, String.valueOf(modal.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ModaliteEvaluation GetModaliteEvaluationByCode(int code)
    {
        String sql = "select * from Modalite_Evaluation where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(code));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new ModaliteEvaluationBuilder(resultSet.getString("nom"),
                    resultSet.getFloat("coef"))
                    .code(code)
                    .build();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ModaliteEvaluation> GetAllModaliteEvaluation()
    {
        List<ModaliteEvaluation> modals = new ArrayList();
        String sql = "select * from Modalite_Evaluation;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
            {
                modals.add(new ModaliteEvaluationBuilder(resultSet.getString("nom"),
                resultSet.getFloat("coef"))
                .code(resultSet.getInt("code"))
                .build());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return modals;
    }
}