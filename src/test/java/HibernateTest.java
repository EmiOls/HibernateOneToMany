import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Tutor tutor = new Tutor("ABC123", "Edward", 30000);
        // Student student = new Student("Sara Hedborn");
        // student.allocateTutor(tutor);
        // System.out.println(student.getTutorName());

        // session.save(student);
        // session.save(tutor);
        Student student = (Student) session.get(Student.class, 12);
        System.out.println(student);
        System.out.println(student.getTutorName());
        Tutor tutor = student.getTutor();
        System.out.println(tutor.getName());

        tx.commit();
        if (tx.getStatus() == TransactionStatus.COMMITTED) {
            System.out.println("COMMITTEEEEDDDD!!!!!!!!!!");
        }

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
