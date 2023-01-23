package Spring_study.Spring_study.service;

import Spring_study.Spring_study.domain.Member;
import Spring_study.Spring_study.repository.MemberRepository;
import Spring_study.Spring_study.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Spring에 등록!
public class MemberService {
    //커맨드 시프트 t 하면 테스트 만들기 단축키
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    public Long join(Member member){
        //중복 회원 방지
         validateDuplicateMember(member);
         //컨트롤 t로 리팩토링 메서드 불러오는거 가능하다, 이렇게 해줄 수 있었음, extract method
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
           .ifPresent(m->{
           //result가 null이 아니면 동작
           throw new IllegalStateException("이미 존재하는 회원입니다.");
       });
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
