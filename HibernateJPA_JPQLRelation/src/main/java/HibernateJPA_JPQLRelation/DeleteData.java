package HibernateJPA_JPQLRelation;

import javax.persistence.*;  
public class DeleteData {  
      
     public static void main( String args[]) {  
             
          EntityManagerFactory emf = Persistence.createEntityManagerFactory( "su" );  
          EntityManager em = emf.createEntityManager();  
          em.getTransaction().begin( );  
            
            
          Query query = em.createQuery( "delete from StudentEntity where s_id=102");  
            
          query.executeUpdate();  
  
          em.getTransaction().commit();  
          em.close();  
          emf.close();    
     }  
}  