package Spring_study.Spring_study.controller;

import Spring_study.Spring_study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;


    @Autowired
//     AutoWired가 있으면, 이렇게 생성되는 memberSevice를 Spring의 memberService와 연결시켜준다.,의존 관계 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //setter, 필드는 사용을 비추한다! 위 방법처럼 생성자 방식 쓰는거 좋다.
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService=memberService;
//    }
}
