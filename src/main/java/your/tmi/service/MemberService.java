package your.tmi.service;

import your.tmi.dto.MemberDto;
import your.tmi.entity.Member;

public interface MemberService {
    //회원가입
    Long save(String username, String password, String rePassword, String nickName, String month, String day);
    //디테일에 정보 불러오기
    MemberDto getInfo(Long id);


    //테스트 회원가입
    Long testSave(Member member);

    }
