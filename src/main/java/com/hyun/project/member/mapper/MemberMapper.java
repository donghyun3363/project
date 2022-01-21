package com.hyun.project.member.mapper;

import com.hyun.project.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public Member findMemberById(int id);

    public List<Member> findMemberAll();

    public int saveMember(Member member);

}
