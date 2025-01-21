package jpa.practice.helloJpa;

import java.util.List;

public interface MemberService {
    void save(Member member);
    Member findMember(String id);
    List<Member> findMembers();
}
