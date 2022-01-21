package com.hyun.project.member.service;

import com.hyun.project.member.dto.MemberDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("전체 조회")
    public void test1() {
        List<MemberDto> memberDtoList = memberService.findAllMember();
        for(MemberDto memberDto : memberDtoList) {
            logger.debug(memberDtoList.toString());
        }
    }
}
