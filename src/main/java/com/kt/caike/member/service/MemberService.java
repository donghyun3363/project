package com.kt.caike.member.service;

import com.kt.caike.member.dto.MemberDto;
import com.kt.caike.member.db.mapper.MemberMapper;
import com.kt.caike.member.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberDto findMemberById(int id) {

        var member = memberMapper.findMemberById(id);

        MemberDto findMember = MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword()).build();

        return findMember;
    }

    public List<MemberDto> findAllMember() {

        List<Member> memberList = memberMapper.findMemberAll();

        List<MemberDto> findMemberList = new ArrayList<>();

        for(Member member: memberList) {
            MemberDto findMember = MemberDto.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .email(member.getEmail())
                    .password(member.getPassword()).build();

            findMemberList.add(findMember);
        }

        return findMemberList;
    }

    public int saveMember(MemberDto memberDto) {

        Member member = new Member();
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getEmail());
        int result = memberMapper.saveMember(member);

        return result;
    }
}
