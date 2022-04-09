package your.tmi.security.dto;

import lombok.Getter;
import your.tmi.entity.Member;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String nickName;
    private String username;

    public SessionUser(Member member) {
        this.nickName = member.getNickName();
        this.username = member.getUsername();
    }
}
