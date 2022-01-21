package com.hyun.project.member.service;

import com.hyun.project.member.domain.MemberDto;
import com.hyun.project.model.Member;

import java.util.List;

public interface MemberService {

    MemberDto findMemberById(int id);

    List<MemberDto> findAllMember();

    int saveMember(MemberDto memberDto);
}
