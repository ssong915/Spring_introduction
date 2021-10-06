package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //Controller 은 어차피 스프링에서 관리하니까 필요없엉

    @Bean // 이 부분은 스프링빈에 등록하라는 뜻이군!
    public MemberService memberService(){
        return new MemberService(memberRepository);
        // autowired 랑 비슷한 넘
    }

//    @Bean
//    public MemberRepository memberRepository()
//    {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

}
