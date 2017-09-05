package com.algernoon.turkeysecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algernoon.turkeysecurity.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findOneByUsername(String username);
	
}
