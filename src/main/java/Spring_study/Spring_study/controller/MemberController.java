package Spring_study.Spring_study.controller;

import Spring_study.Spring_study.domain.Member;
import Spring_study.Spring_study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;


    @Autowired
//     AutoWired가 있으면, 이렇게 생성되는 memberSevice를 Spring의 memberService와 연결시켜준다.,의존 관계 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @GetMapping("/members")
    @ResponseBody
    public List<Member> list(Model model){
        List<Member> members=memberService.findMembers();
        model.addAttribute("members",members);
        return members;
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member=new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }
    //setter, 필드는 사용을 비추한다! 위 방법처럼 생성자 방식 쓰는거 좋다.
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService=memberService;
//    }
}
