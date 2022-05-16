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
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "mno")
//    private Member member;

    @OneToMany(mappedBy = "group", cascade = ALL, orphanRemoval = true)
    public List<Member> memberList = new ArrayList<>();


    //group 생성
//    public Group (String groupName, Member member) {
//        this.groupName = groupName;
//        this.member = member;
//    }

}

