package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //의존관계!! Service를 주입!
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new") //같은 url- GET 방식
    public String createForm() {
        return "members/createMemberForm";
        //아무 것도 없이 일단 html 로 감
    }

    @PostMapping(value = "/members/new") //같은 url- POST 방식
    public String create(MemberForm form) { //MemberForm 으로 이동!

        Member member = new Member();
        member.setName(form.getName()); //form 에서 getName()

        memberService.join(member);

        return "redirect:/";
    }

}
