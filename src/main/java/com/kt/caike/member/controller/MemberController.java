package com.kt.caike.member.controller;

import com.kt.caike.common.request.KtRequest;
import com.kt.caike.common.request.Pagination;
import com.kt.caike.common.response.KtResponse;
import com.kt.caike.member.dto.MemberDto;
import com.kt.caike.member.dto.MemberSearchDto;
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
    public KtResponse<MemberDto> updateMember(@Valid @RequestBody KtRequest<MemberDto> req, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            logger.error("createMember validationError");
            return new KtResponse<MemberDto>().validationError(bindingResult);
        }

        return memberService.update(req);
    }


    @ApiOperation(value = "Member create", notes = "3. 사용자 삭제")
    @DeleteMapping("/{id}")
    public KtResponse<MemberDto> deleteMember(@PathVariable("id") long id) {

        return memberService.delete(id);
    }

    @ApiOperation(value = "Member find all", notes = "4. 사용자 전체 조회")
    @GetMapping("/search")
    public KtResponse<List<MemberDto>> findAllMember(MemberSearchDto memberSearchDto, Pagination pagination) {

        logger.debug("memberSearchDto: " + memberSearchDto);
        logger.debug("pagination: " + pagination);

        return memberService.searchMember(memberSearchDto, pagination);
    }

    @ApiOperation(value = "Member find", notes = "5. 사용자 지정 조회")
    @GetMapping("/{id}")
    public KtResponse<MemberDto> findMember(@PathVariable("id") long id) {

        return memberService.findMember(id);
    }

}
