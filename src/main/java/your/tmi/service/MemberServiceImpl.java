package your.tmi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import your.tmi.entity.Member;
import your.tmi.repository.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //회원가입
    @Override
    @Transactional
    public Long save(String username, String password, String nickName, String month, String day) {
        Member member = memberRepository.save(new Member(username, password, nickName, month, day));
        return member.getId();
    }


}
