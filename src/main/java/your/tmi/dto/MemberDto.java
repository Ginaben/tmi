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


    //datail에 정보 불러오기
    public MemberDto(Member member) {
        this.id = member.getId();
        this.nickName = member.getNickName();
        this.month = member.getMonth();
        this.day = member.getDay();
    }

/*
    public MemberDto() {}

    public MemberDto(String username, String password, String nickName, String month, String day) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.month = month;
        this.day = day;
    }
    */

}
