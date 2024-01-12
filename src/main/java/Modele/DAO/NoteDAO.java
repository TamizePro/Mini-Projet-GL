package Modele.DAO;
import Modele.Bean.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class NoteDAO implements INoteDAO {
    private Connection connection;

    public NoteDAO(Connection connection)
    {
        this.connection = connection;
    }

    private String get_isEtudiant_absent(boolean val)
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
    public boolean AddNote(Note note)
    {
        String sql = "insert into Note(note_value, etd_absent) values(?, ?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, String.valueOf(note.getNote()));
            preparedStatement.setString(2, get_isEtudiant_absent(note.isEtudiant_absent()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteNote(Note note)
    {
        String sql = "delete from Note where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(note.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateNoteByCode(Note note)
    {
        String sql = "update Note set note_value = ?, etd_absent = ? where code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(note.getNote()));
            preparedStatement.setString(2, get_isEtudiant_absent(note.isEtudiant_absent()));
            preparedStatement.setString(3, String.valueOf(note.getCode()));
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0)
                return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Note GetNoteByCode(int code)
    {
        String sql = "select * from Note where code = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(code));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Note(resultSet.getInt("code"), resultSet.getFloat("note_value"),
                    getbool(resultSet.getString("etd_absent")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Note> GetAllNote()
    {
        List<Note> notes = new ArrayList();
        String sql = "select * from Note;";
        try{
            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);
            while (resultSet.next())
            {
                notes.add(new Note(resultSet.getInt("code"), resultSet.getFloat("note_value"),
                    getbool(resultSet.getString("etd_absent"))));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return notes;
    }
}