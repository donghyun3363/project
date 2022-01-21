package com.hyun.project.member.service.impl;

import com.hyun.project.member.domain.MemberDto;
import com.hyun.project.member.mapper.MemberMapper;
import com.hyun.project.model.Member;
import com.hyun.project.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memeberMapper;

    @Override
    public MemberDto findMemberById(int id) {

        Member member = memeberMapper.findMemberById(id);

        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setName(member.getName());
        memberDto.setEmail(member.getEmail());

        return memberDto;
    }

    @Override
    public List<MemberDto> findAllMember() {

        List<MemberDto> memberDtoList = new ArrayList<>();
        List<Member> memberList = memeberMapper.findMemberAll();

        for(Member member: memberList) {
            MemberDto memberDto = new MemberDto();
            memberDto.setId(member.getId());
            memberDto.setName(member.getName());
            memberDto.setEmail(member.getEmail());
            memberDtoList.add(memberDto);
        }

        return memberDtoList;
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
