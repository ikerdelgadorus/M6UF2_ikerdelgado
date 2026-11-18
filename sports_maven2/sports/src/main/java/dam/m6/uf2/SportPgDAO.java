package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportPgDAO implements DAO<Sport> {
    private Connection conn;

    public SportPgDAO(Connection conn){
        this.conn = conn;
    }

    @Override 
    public void add(Sport s){
        if (conn == null) return;

        String sql = "INSERT INTO deportes (nombre) VALUES (?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, s.name);
            int rst = pstmt.executeUpdate();
            System.out.println("Update: " + rst);
        } catch (SQLException e) {
            System.err.println("Error al crear esport: " + e.getMessage());
        }
    }

    @Override 
    public List<Sport> getAll() {
        List<Sport> sports = new ArrayList<>();

        String sql = "SELECT * FROM deportes";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                sports.add(new Sport(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar esports: " + e.getMessage());
        }

        return sports;
    }
}

