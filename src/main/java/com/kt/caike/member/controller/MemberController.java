package com.kt.caike.member.controller;

import com.kt.caike.common.request.KtRequest;
import com.kt.caike.common.response.KtResponse;
import com.kt.caike.member.dto.MemberDto;
import com.kt.caike.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"회원(Member) 정보 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member/v1")
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MemberService memberService;

    @ApiOperation(value = "Member create", notes = "1. 사용자 생성")
    @PostMapping
    public KtResponse<MemberDto> createMember(@Valid @RequestBody KtRequest<MemberDto> req, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {     /* @Valid validation */
            logger.error("createMember validationError");
            return new KtResponse<MemberDto>().validationError(bindingResult);
        }
        return memberService.createMember(req);
    }

    @ApiOperation(value = "Member update", notes = "2. 사용자 수정")
    @PutMapping
    public ResponseEntity updateMember(@Valid @RequestBody KtRequest<MemberDto> memberDto, BindingResult bindingResult) {

        logger.debug("memberDto: " + memberDto);
        logger.debug("bindingResult: " + bindingResult);


        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        /*
         * update logic
         */
        return ResponseEntity.ok(true);
    }


    @ApiOperation(value = "Member create", notes = "3. 사용자 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable("id") int id) {

        /*
         * delete logic
         */

        return ResponseEntity.ok(true);
    }

    @ApiOperation(value = "Member find all", notes = "4. 사용자 전체 조회")
    @GetMapping
    public ResponseEntity findAllMember() {

        List<MemberDto> memberDtoList = memberService.findAllMember();

        return ResponseEntity.ok(memberDtoList);
    }

    @ApiOperation(value = "Member find", notes = "5. 사용자 지정 조회")
    @GetMapping("/{id}")
    public ResponseEntity findMember(@PathVariable("id") int id) {
        logger.debug("id: " + id);
        MemberDto memberDto = memberService.findMemberById(id);

        return ResponseEntity.ok(memberDto);
    }

}
