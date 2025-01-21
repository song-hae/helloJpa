package jpa.practice.helloJpa;

import jakarta.transaction.Transactional;
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
    public Member findMember(String id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Id"));
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

}
