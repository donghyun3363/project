package com.hyun.project.member.service;

import com.hyun.project.member.dto.MemberDto;

import java.util.List;

public interface MemberService {

    MemberDto findMemberById(int id);

    List<MemberDto> findAllMember();

    int saveMember(MemberDto memberDto);
}
