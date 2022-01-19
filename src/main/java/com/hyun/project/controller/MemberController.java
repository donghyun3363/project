package com.hyun.project.controller;

import com.hyun.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member")
    @ResponseBody
    public String homeView() {
        Map<String, Object> member = memberService.selectMember();

        return member.toString();
    }
}
