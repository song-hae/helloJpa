package jpa.practice.helloJpa.practice;

import jpa.practice.helloJpa.domain.member.Member;
import jpa.practice.helloJpa.service.MemberServiceImpl;
import jpa.practice.helloJpa.domain.member.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberServiceImpl memberService;

    @Test
    void memberBuildTest(){
        Member member = Member.builder().name("songhae").age(25).role(Role.USER).description("I'm songhae").build();
        memberService.save(member);
        Long findId = member.getId();
        Member findMember = memberService.findMember(findId);
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void roleTimeTest(){
        Member member = Member.builder().name("songhae").age(25).role(Role.USER).description("I'm songhae").build();
        memberService.save(member);
        Long findId = member.getId();
        Member findMember = memberService.findMember(findId);
        System.out.println("member.getDescription() = " + findMember.getDescription());
        System.out.println("member.getRole() = " + findMember.getRole());
        System.out.println("member.getCreatedDate() = " + findMember.getCreatedDate());
    }
}
