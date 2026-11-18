package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportmanPgDAO implements DAO<Sportman> {
    private Connection conn;

    public SportmanPgDAO(Connection conn){
        this.conn = conn;
    }

    @Override 
    public void add(Sportman s){
        if (conn == null) return;

        String sql = "INSERT INTO deportistas (nombre, cod_deporte) VALUES (?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, s.name);
            pstmt.setInt(2, s.cod_sport);
            int rst = pstmt.executeUpdate();
            System.out.println("Update: " + rst);
        } catch (SQLException e) {
            System.err.println("Error al buscar usuaris: " + e.getMessage());
        }
    }

    @Override
    public List<Sportman> getAll() {
        List<Sportman> sportmans = new ArrayList<>();

        String sql = "SELECT * FROM deportistas";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                sportmans.add(new Sportman(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar deportistes: " + e.getMessage());
        }

        return sportmans;
    }

    public List<Sportman> getBySport(int sport){
        List<Sportman> sportmans = new ArrayList<>();

        String sql = "SELECT * FROM deportistas WHERE cod_deporte = " + sport;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                sportmans.add(new Sportman(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar deportistes: " + e.getMessage());
        }

        return sportmans;
    }
}

