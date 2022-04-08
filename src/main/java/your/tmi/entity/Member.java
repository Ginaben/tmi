package your.tmi.entity;

import lombok.AccessLevel;
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
    private String rePassword;
    private String nickName;

    private String month;
    private String day;

    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    public List<Tmi> infoList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    public List<Group> groupList = new ArrayList<>();


    public Member(String username, String password, String rePassword ,String nickName, String month, String day) {
        this.username = username;
        this.password = password;
        this.rePassword = rePassword;
        this.nickName = nickName;
        this.month = month;
        this.day = day;
    }

}
