package Spring_study.Spring_study.repository;

import Spring_study.Spring_study.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository=new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member= new Member();
        member.setName("hayoun");

        repository.save(member);
        Member result=repository.findById(member.getId()).get();
//        System.out.println("result="+(result==member));
        Assertions.assertThat(member).isEqualTo(result);

    }
    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("ss");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("ss2");
        repository.save(member2);

        Member result=repository.findByName("ss").get();
        Assertions.assertThat(result).isEqualTo(member1);

    }
    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("findall");
        repository.save(member1);
        Member member2=new Member();
        member1.setName("findall2");
        repository.save(member2);

        List<Member> all=repository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(2);
    }


}
