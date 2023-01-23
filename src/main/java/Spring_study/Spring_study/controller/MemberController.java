package Spring_study.Spring_study.controller;

import Spring_study.Spring_study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired
    // AutoWired가 있으면, 이렇게 생성되는 memberSevice를 Spring의 memberService와 연결시켜준다.,의존 관계 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
