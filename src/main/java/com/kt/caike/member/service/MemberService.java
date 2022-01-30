package com.kt.caike.member.service;

import com.kt.caike.common.request.KtRequest;
import com.kt.caike.common.response.KtResponse;
import com.kt.caike.common.service.CRUDService;
import com.kt.caike.member.db.repository.MemberRepository;
import com.kt.caike.member.dto.MemberDto;
import com.kt.caike.member.db.mapper.MemberMapper;
import com.kt.caike.member.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public MemberDto findMemberById(int id) {

        var member = memberMapper.findMemberById(id);
/*
        MemberDto findMember =  new MemberDto()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword()).build();*/

        return null;
    }

    public List<MemberDto> findAllMember() {

      /*  List<Member> memberList = memberMapper.findMemberAll();

        List<MemberDto> findMemberList = new ArrayList<>();

        for(Member member: memberList) {
            MemberDto findMember = MemberDto.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .email(member.getEmail())
                    .password(member.getPassword()).build();

            findMemberList.add(findMember);
        }*/

        return null;
    }

}
