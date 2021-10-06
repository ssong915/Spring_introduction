package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;
    //JPA는 EntityManager로 모든게 동작됨

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public Member save(Member member) {
        em.persist(member); //영구저장한다는 뜼!
        return member;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); // find(조회할타입,pk)
        return Optional.ofNullable(member); // 없을 수도 있으니 ofNullable
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        // 객체로 쿼리 날리면 sql로 번역된다 ( select 'm' !!)
    }

    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}