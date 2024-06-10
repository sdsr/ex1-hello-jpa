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
            member.setId(1L);
            member.setName("helloA");

//            member.setId(2L);
//            member.setName("helloB");

            em.persist(member);
            Member findMember = em.find(Member.class, 1L);
//            em.remove(member);//삭제
            findMember.setName("HelloJPA");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
