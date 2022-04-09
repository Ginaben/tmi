package your.tmi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import your.tmi.dto.MemberDto;
import your.tmi.entity.Member;
import your.tmi.repository.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    @Lazy
    private final PasswordEncoder passwordEncoder;


    //회원가입
    @Override
    @Transactional
    public Long save(Member member) {
        String encPassword = passwordEncoder.encode(member.getPassword());

        return memberRepository.save(Member.builder()
                        .username(member.getUsername())
                        .password(encPassword)
                        .nickName(member.getNickName())
                        .month(member.getMonth())
                        .day(member.getDay())
                        .build())
                .getId();
    }

    /*    @Override
    @Transactional
    public Long save(String username, String password, String nickName, String month, String day) {
        Member member = memberRepository.save(new Member(username, password, nickName, month, day));
        return member.getId();
    }*/

    //디테일에 정보 불러오기
    @Override
    public MemberDto getInfo(Long id) {
        Member member = memberRepository.getById(id);
        return new MemberDto(member);
    }

    //닉네임 중복확인
    @Override
    public Integer countByNickName(String nickName) {
        return memberRepository.countByNickName(nickName);
    }



    //테스트 회원가입
    @Override
    @Transactional
    public Long testSave(Member member) {
        String encPassword = passwordEncoder.encode(member.getPassword());

        return memberRepository.save(new Member(member.getUsername(), encPassword, member.getNickName(),
                member.getMonth(), member.getDay())).getId();
    }

}
