package your.tmi.service;

import your.tmi.entity.Member;

public interface MemberService {
    //회원가입
    Long save(String username, String password, String rePassword, String nickName, String month, String day);

    //테스트 회원가입
    Long testSave(Member member);

    }
