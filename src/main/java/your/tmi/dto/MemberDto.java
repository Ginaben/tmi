package your.tmi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import your.tmi.entity.Member;

@Getter
@Setter
@ToString
public class MemberDto {

    private Long id;
    private String username;
    private String password;
    private String rePassword;
    private String nickName;
    private String month;
    private String day;

    private Long tmiCnt;


    //join 컨트롤러에서..필요..
    public MemberDto() {}

    //datail에 정보 불러오기
    public MemberDto(Member member) {
        this.id = member.getId();
        this.nickName = member.getNickName();
        this.month = member.getMonth();
        this.day = member.getDay();
    }

    //회원가입.. 어떻게 쓰는건지 모르겠음
    public Member toMember(MemberDto memberDto) {
        return new Member(memberDto.username, memberDto.password, memberDto.nickName,
                memberDto.month, memberDto.day);
    }

    //검색하기
    public MemberDto(Long id, String nickName, String month, String day, Long tmiCnt) {
        this.id = id;
        this.nickName = nickName;
        this.month = month;
        this.day = day;
        this.tmiCnt = tmiCnt;
    }


/*

    public MemberDto(String username, String password, String nickName, String month, String day) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.month = month;
        this.day = day;
    }
    */


}
