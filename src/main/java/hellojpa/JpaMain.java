package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        try {
            Member member = new Member();
            member.setId(2L);
            member.setName("helloB");

            em.persist(member);
        } catch (Exception e) {
            tx.commit();
        } finally {
            em.close();
        }
        emf.close();
    }
}
