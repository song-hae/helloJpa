package jpa.practice.helloJpa.practice;

import jpa.practice.helloJpa.Member;
import jpa.practice.helloJpa.MemberRepository;
import jpa.practice.helloJpa.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberServiceImpl memberService;

    @Test
    void test(){
        String memberId = "1";
        Member member = Member.builder().id(memberId).userName("hi").age(25).build();
        memberService.save(member);
        Member findMember = memberService.findMember(memberId);
        Assertions.assertThat(member.getUserName()).isEqualTo(findMember.getUserName());
    }
}
