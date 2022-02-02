package com.kt.caike.member.service;

import com.kt.caike.common.service.ConverterService;
import com.kt.caike.member.db.entity.Member;
import com.kt.caike.member.dto.MemberDto;
import org.springframework.stereotype.Service;

@Service
public class MemberConverterService implements ConverterService<MemberDto, Member> {

    @Override
    public MemberDto toDto(Member member) {
        return new MemberDto()
                .setId(member.getId())
                .setName(member.getName())
                .setPassword(member.getPassword())
                .setEmail(member.getEmail())
                .setStatus(member.getStatus())
                ;
    }

    @Override
    public Member toEntity(MemberDto memberDto) {
        return new Member()
                .setId(memberDto.getId())
                .setName(memberDto.getName())
                .setPassword(memberDto.getPassword())
                .setEmail(memberDto.getEmail())
                .setStatus(memberDto.getStatus())
                ;
    }
}
