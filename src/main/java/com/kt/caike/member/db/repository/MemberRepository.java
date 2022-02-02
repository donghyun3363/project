package com.kt.caike.member.db.repository;

import com.kt.caike.member.db.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByIdOrderByIdDesc(Long Id);
}


