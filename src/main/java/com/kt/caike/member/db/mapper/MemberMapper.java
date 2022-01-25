package com.kt.caike.member.db.mapper;

import com.kt.caike.member.db.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public Member findMemberById(int id);

    public List<Member> findMemberAll();

    public int saveMember(Member member);

}
