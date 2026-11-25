package dam.m6.uf2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SportmanPgDAO implements DAO<Sportman> {
    //private Connection conn;
    private SessionFactory sessionFactory;

    /*public SportmanPgDAO(Connection conn){
        this.conn = conn;
    }*/

    public SportmanPgDAO(SessionFactory session){
        this.sessionFactory = session;
    }

    @Override 
    public void add(Sportman s){
        /*if (conn == null) return;

        String sql = "INSERT INTO deportistas (nombre, cod_deporte) VALUES (?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, s.name);
            pstmt.setInt(2, s.cod_sport);
            int rst = pstmt.executeUpdate();
            System.out.println("Update: " + rst);
        } catch (SQLException e) {
            System.err.println("Error al buscar usuaris: " + e.getMessage());
        }*/

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(s);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Sportman> getAll() {
        /*List<Sportman> sportmans = new ArrayList<>();

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

        return sportmans;*/

        try (Session session = sessionFactory.openSession()) {
            Query<Sportman> query = session.createQuery("FROM Sportman", Sportman.class);
            return query.getResultList();
        }
    }

    public List<Sportman> getBySport(int sport){
        /*List<Sportman> sportmans = new ArrayList<>();

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

        return sportmans;*/

        try (Session session = sessionFactory.openSession()) {
            Query<Sportman> query = session.createQuery("FROM Sportman WHERE cod_sport = :sport_cod", Sportman.class);
            query.setParameter("sport_cod", sport);
            return query.getResultList();
        }
    }
}