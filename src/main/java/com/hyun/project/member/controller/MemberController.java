package com.hyun.project.member.controller;

import com.hyun.project.member.domain.MemberDto;
import com.hyun.project.member.service.MemberService;
import com.hyun.project.model.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    @GetMapping("/member")
    @ResponseBody
    public ResponseEntity findAllMember() {

        List<MemberDto> memberDtoList = memberService.findAllMember();

        return ResponseEntity.ok(memberDtoList);
    }

    @GetMapping("/member/{id}")
    @ResponseBody
    public ResponseEntity findMember(@PathVariable("id") int id) {
        logger.debug("id: " + id);
        MemberDto memberDto = memberService.findMemberById(id);

        return ResponseEntity.ok(memberDto);
    }

    @PostMapping("/member")
    @ResponseBody
    public ResponseEntity<?> saveMember(@RequestBody @Valid MemberDto memberDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        int result = memberService.saveMember(memberDto);

            return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PatchMapping("/member")
    @ResponseBody
    public ResponseEntity updateMember(@RequestBody MemberDto memberDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        /*
         * update logic
         */
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/member/{id}")
    @ResponseBody
    public ResponseEntity deleteMember(@PathVariable("id") int id) {

        /*
         * delete logic
         */

        return ResponseEntity.ok(true);
    }

}
