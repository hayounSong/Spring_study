package Spring_study.Spring_study.service;

import Spring_study.Spring_study.domain.Member;
import Spring_study.Spring_study.repository.MemberRepository;
import Spring_study.Spring_study.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Transactional
// test를 반복하게 해주는 친구
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;



    @Test
    void join() {
        //given
        Member member=new Member();
        member.setName("springs");
        //when
        Long saveId= memberService.join(member);
        //then
        Member findMember= memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복(){
        //given
        Member member1=new Member();
        member1.setName("spring");

        Member member2=new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}