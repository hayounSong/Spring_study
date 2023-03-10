package Spring_study.Spring_study.controller;

import Spring_study.Spring_study.domain.Member;
import Spring_study.Spring_study.repository.MemoryMemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello;
        //객체를 반환하면 json 형식으로 된다
    }
    @GetMapping("practice")
    @ResponseBody
    public Member memberApi(){
        MemoryMemberRepository memberRepository=new MemoryMemberRepository();
        Member member=new Member();
        member.setName("ss");
        memberRepository.save(member);
        Member member2=new Member();
        member.setName("sss");
        memberRepository.save(member2);
        return memberRepository.findAll().get(1);

    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
