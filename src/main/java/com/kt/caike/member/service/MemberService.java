package com.kt.caike.member.service;

import com.kt.caike.common.request.KtRequest;
import com.kt.caike.common.request.Pagination;
import com.kt.caike.common.response.KtResponse;
import com.kt.caike.common.service.CRUDService;
import com.kt.caike.member.db.repository.MemberRepository;
import com.kt.caike.member.dto.MemberDto;
import com.kt.caike.member.db.mapper.MemberMapper;
import com.kt.caike.member.db.entity.Member;
import com.kt.caike.member.dto.MemberSearchDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService extends CRUDService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MemberMapper memberMapper;

    private final MemberConverterService memberConverterService;

    private final MemberRepository memberRepository;

    public KtResponse<MemberDto> createMember(KtRequest<MemberDto> req) {


        Member newEntity = memberConverterService.toEntity(req.getBody());
        Member saveEntity = memberRepository.saveAndFlush(newEntity);

        MemberDto responseDto = memberConverterService.toDto(saveEntity);

        return new KtResponse<MemberDto>().responseOk(responseDto);
    }

    public KtResponse<MemberDto> findMember(long id) {

        Member findEntity = memberRepository.findByIdOrderByIdDesc(id);

        MemberDto responseDto = memberConverterService.toDto(findEntity);

        return new KtResponse<MemberDto>().responseOk(responseDto);
    }

    public KtResponse<List<MemberDto>> searchMember(MemberSearchDto memberSearchDto, Pagination pagination) {

        var map = new HashMap<String,Object>();
        map.put("memberSearchDto",memberSearchDto);
        map.put("pagination",pagination);

        var memberDtoList = memberMapper.searchMember(map);
        var countAll = memberMapper.getAllCntMember(map);
        var count = memberDtoList.size();

        pagination.setCurrentElements(count);
        pagination.setTotalElements(countAll);

        pagination.complete();

        return new KtResponse<List<MemberDto>>().responseOk(memberDtoList, pagination);
    }

}
