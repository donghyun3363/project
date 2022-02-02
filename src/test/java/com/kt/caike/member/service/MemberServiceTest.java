package com.kt.caike.member.service;

import com.kt.caike.common.request.Pagination;
import com.kt.caike.common.response.KtResponse;
import com.kt.caike.member.dto.MemberDto;
import com.kt.caike.member.dto.MemberSearchDto;
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

        KtResponse<List<MemberDto>> memberDtoList = memberService.searchMember(new MemberSearchDto(), new Pagination());
        logger.debug("body: " + memberDtoList.getBody());
    }
}
