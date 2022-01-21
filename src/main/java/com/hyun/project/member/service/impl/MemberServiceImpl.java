package com.hyun.project.member.service.impl;

import com.hyun.project.member.dto.MemberDto;
import com.hyun.project.member.mapper.MemberMapper;
import com.hyun.project.model.Member;
import com.hyun.project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memeberMapper;

    @Override
    public MemberDto findMemberById(int id) {

        Member member = memeberMapper.findMemberById(id);

        MemberDto findMember = MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword()).build();

        return findMember;
    }

    @Override
    public List<MemberDto> findAllMember() {

        List<Member> memberList = memeberMapper.findMemberAll();

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

    @Override
    public int saveMember(MemberDto memberDto) {

        Member member = new Member();
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getEmail());
        int result = memeberMapper.saveMember(member);

        return result;
    }
}
