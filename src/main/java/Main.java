import com.example.demo1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main{
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("src/main/java/hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Zaur", "Tregulov", "IT", 500);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
        }
    }

}