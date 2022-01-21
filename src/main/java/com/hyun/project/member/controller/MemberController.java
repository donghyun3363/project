package com.hyun.project.member.controller;

import com.hyun.project.member.dto.MemberDto;
import com.hyun.project.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity findAllMember() {

        List<MemberDto> memberDtoList = memberService.findAllMember();

        return ResponseEntity.ok(memberDtoList);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity findMember(@PathVariable("id") int id) {
        logger.debug("id: " + id);
        MemberDto memberDto = memberService.findMemberById(id);

        return ResponseEntity.ok(memberDto);
    }

    @PostMapping("/member")
    public ResponseEntity<?> createMember(@Valid MemberDto memberDto, BindingResult bindingResult) {

        // validation
        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        int result = memberService.saveMember(memberDto);

            return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PatchMapping("/member")
    public ResponseEntity updateMember(MemberDto memberDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        /*
         * update logic
         */
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity deleteMember(@PathVariable("id") int id) {

        /*
         * delete logic
         */

        return ResponseEntity.ok(true);
    }

}
