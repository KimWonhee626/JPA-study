package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        // 어플리케이션 로딩시점에 한번만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랙잭션 단위마다 생성
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("wonhe2");

//            em.persist(member); // 멤버 저장(insert)

            Member findMember = em.find(Member.class, 1L); // 멤버 찾기(select)
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            em.remove(findMember); // 멤버 삭제
            findMember.setName("wonhee1"); // 멤버 수정(update) => commit 새로 안해도됨!!

            tx.commit();
        } catch (Exception e) {
            tx.rollback(); // 문제생기면 롤백
        } finally {
            em.close(); // 작업 끝나면 EntityManager 닫음 꼭!!!
        }

        emf.close();
    }

}
