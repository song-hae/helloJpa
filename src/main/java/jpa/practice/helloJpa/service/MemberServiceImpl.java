package jpa.practice.helloJpa.service;

import jakarta.transaction.Transactional;
import jpa.practice.helloJpa.domain.member.MemberRepository;
import jpa.practice.helloJpa.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Id"));
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

}
