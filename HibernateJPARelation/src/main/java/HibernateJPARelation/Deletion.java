package HibernateJPARelation;

import javax.persistence.*;  
 
  
public class Deletion {  
  
    public static void main(String args[])  
    {  
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("su");  
    EntityManager em=emf.createEntityManager();  
em.getTransaction().begin();  
  
    StudentEntity s=em.find(StudentEntity.class,102);  
em.remove(s);  
em.getTransaction().commit();  
emf.close();  
em.close();  
  
    }  
}  