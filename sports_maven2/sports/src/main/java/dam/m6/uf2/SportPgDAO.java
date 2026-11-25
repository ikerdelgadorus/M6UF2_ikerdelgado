package dam.m6.uf2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SportPgDAO implements DAO<Sport> {
    //private Connection conn;
    private SessionFactory sessionFactory;

    /*public SportPgDAO(Connection conn){
        this.conn = conn;
    }*/

    public SportPgDAO(SessionFactory session){
        this.sessionFactory = session;
    }

    @Override 
    public void add(Sport s){
        /*if (conn == null) return;

        String sql = "INSERT INTO deportes (nombre) VALUES (?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, s.name);
            int rst = pstmt.executeUpdate();
            System.out.println("Update: " + rst);
        } catch (SQLException e) {
            System.err.println("Error al crear esport: " + e.getMessage());
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
    public List<Sport> getAll() {
        /*List<Sport> sports = new ArrayList<>();

        String sql = "SELECT * FROM deportes";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                sports.add(new Sport(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar esports: " + e.getMessage());
        }*/

        try (Session session = sessionFactory.openSession()) {
            Query<Sport> query = session.createQuery("FROM Sport", Sport.class);
            return query.getResultList();
        }

        //return sports;
    }
}

