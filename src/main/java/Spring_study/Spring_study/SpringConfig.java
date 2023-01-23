package Spring_study.Spring_study;

import Spring_study.Spring_study.domain.Member;
import Spring_study.Spring_study.repository.MemberRepository;
import Spring_study.Spring_study.repository.MemoryMemberRepository;
import Spring_study.Spring_study.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean

    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
