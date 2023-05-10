import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // UNCOMMENT BELOW CODE (UNTIL session.save(tutor)) TO INSERT
        // var tutor = new Tutor("abc1337", "Nahid", 45000);
        // var students = List.of(new Student("Emil"), new Student("David"), new Student("Rasmus"));
        
        // for (var student : students) { 
        //     tutor.addStudentToTeachingGroup(student);
        //     session.save(student);
        // }
        // session.save(tutor);

        // UNCOMMENT BELOW CODE FOR QUERIES
        // tutorID has to match the id:s in your databse
        // int tutorId = 30;
        // Tutor queryTutor = (Tutor) session.get(Tutor.class, tutorId);
        // var queryStudents = queryTutor.getTeachingGroup();
        // for (var student : queryStudents) {
        //     System.out.println(student);
        // }
        
        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
