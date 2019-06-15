package HIbernateRelation;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class AppMain {
 
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
 
 
    	public static void main(String[] args) {
        System.out.println(".......Hibernate One To One Mapping Example.......\n");
        try {
       
        	  //Create session factory object
        	  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        	  //getting session object from session factory
        	  Session session = sessionFactory.openSession();
        	  //getting transaction object from session object
        	  session.beginTransaction();
        	  
        	  
            // Creating A Book Entity
            Book bookObj = new Book();
            bookObj.setTitle("Hibernate Made Easy");
            bookObj.setDescription("Simplified Data Persistence with Hibernate and JPA");
            bookObj.setPublishedDate(new Date());
 
            bookObj.setAuthor(new Author("Cameron Wallace McKenzie", "cameron.bckenzie@gmail.com"));
 
            // Persisting (Or Saving) The Book Entity To The Database
      	  session.save(bookObj);
            // Committing The Transactions To The Database
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
 
            System.out.println("\n.......Records Saved Successfully To The Database.......");
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}