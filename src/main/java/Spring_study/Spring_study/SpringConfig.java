package Spring_study.Spring_study;

import Spring_study.Spring_study.repository.JdbcMemberRepository;
import Spring_study.Spring_study.repository.MemberRepository;
import Spring_study.Spring_study.repository.MemoryMemberRepository;
import Spring_study.Spring_study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean

    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
