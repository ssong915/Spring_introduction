package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //0123... 키값 생성해주는 넘

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //member id 값 생성
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() { //얘는 왜 리스트?
        return new ArrayList<>(store.values()); //store에 있는 member들이 반환
    }

    public void clearStore(){
        store.clear();
    }
}
