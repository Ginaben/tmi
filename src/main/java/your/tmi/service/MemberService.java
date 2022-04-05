package your.tmi.service;

public interface MemberService {
    //회원가입
    Long save(String username, String password, String nickName, String month, String day);

    }
