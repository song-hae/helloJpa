package jpa.practice.helloJpa.service;

import jpa.practice.helloJpa.domain.member.Member;

import java.util.List;

public interface MemberService {
    void save(Member member);
    Member findMember(Long id);
    List<Member> findMembers();
}
