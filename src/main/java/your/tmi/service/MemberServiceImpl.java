package your.tmi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    //회원가입
    @Override
    @Transactional
    public Long save(String username, String password, String rePassword ,String nickName, String month, String day) {
        Member member = memberRepository.save(new Member(username, password, rePassword, nickName, month, day));
        return member.getId();
    }

    //디테일에 정보 불러오기
    @Override
    public MemberDto getInfo(Long id) {
        Member member = memberRepository.getById(id);
        return new MemberDto(member);
    }



    //테스트 회원가입
    @Override
    @Transactional
    public Long testSave(Member member) {
        return memberRepository.save(new Member(member.getUsername(), member.getPassword(), member.getRePassword(), member.getNickName(),
                member.getMonth(), member.getDay())).getId();
    }

}
