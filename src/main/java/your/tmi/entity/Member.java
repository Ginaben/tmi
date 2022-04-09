package your.tmi.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String nickName;

    private String month;
    private String day;

    private String socialType;


    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    public List<Tmi> infoList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    public List<Group> groupList = new ArrayList<>();


    //회원가입
    @Builder
    public Member(String username, String password, String nickName, String month, String day) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.month = month;
        this.day = day;
    }

    // OAUTH 회원가입
    @Builder(builderMethodName = "OauthRegister", buildMethodName = "oauthRegister")
    public Member(String username, String password, String nickName, String month, String day,
                  Boolean authState, String socialType) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.month = month;
        this.day = day;
        this.socialType = socialType;
    }

    // oauth update
    public Member update(String nickName) {
        this.nickName = nickName;
        return this;
    }


}
