package com.kt.caike.member.controller;

import com.kt.caike.member.service.MemberService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/jsp-test")
    public ModelAndView memberView() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "이동현");
        mv.setViewName("hello");

        return mv;
    }

    @RequestMapping("/thymeleaf-test")
    public ModelAndView memberThymeleafView() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "이동현");
        mv.setViewName("thymeleaf/hello");

        return mv;
    }

}
