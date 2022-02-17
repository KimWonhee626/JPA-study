package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        // 어플리케이션 로딩시점에 한번만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랙잭션 단위마다 생성 -> 스레드간에 공유x
        EntityManager em = emf.createEntityManager();

        // jpa에서 데이터 변경은 트랜잭션 안에서 일어남
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* JPA CRUD 실습
            Member member = new Member();
            member.setId(2L);
            member.setName("wonhe2");

            em.persist(member); // 멤버 저장(insert)

            Member findMember = em.find(Member.class, 1L); // 멤버 찾기(select)
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            em.remove(findMember); // 멤버 삭제
            */

            /* JPQL 실습
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList(); // JPQL : Member '객체'를 대상으로 쿼리 수행(객체지향 sql)

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            */

            tx.commit();
        } catch (Exception e) {
            tx.rollback(); // 문제생기면 롤백
        } finally {
            em.close(); // 작업 끝나면 EntityManager 닫음 꼭!!!
        }

        emf.close();
    }

}

