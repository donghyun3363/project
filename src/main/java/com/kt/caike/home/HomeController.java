package com.kt.caike.home;

import com.kt.caike.common.request.KtRequest;
import com.kt.caike.member.dto.MemberDto;
import com.kt.caike.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public ModelAndView homeView() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "caike");
        mv.setViewName( "thymeleaf/home");
        return mv;
    }

    @GetMapping("/login")
    public String loginView() {
        return "thymeleaf/login";
    }

    @GetMapping("/signup")
    public String signupView() {
        return "thymeleaf/signup";
    }

    @PostMapping("/signup")
    public String signup(MemberDto memberDto) {
        memberService.createMember(new KtRequest<MemberDto>().setBody(memberDto));
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "thymeleaf/user_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "thymeleaf/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "thymeleaf/denied";
    }
}
