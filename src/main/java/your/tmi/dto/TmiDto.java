package your.tmi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import your.tmi.entity.Member;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TmiDto {

    private Long tno;
    private String text;
    private Member member;
    private LocalDateTime createdTime;


    public TmiDto(Long tno, String text, Member member, LocalDateTime createdTime) {
        this.tno = tno;
        this.text = text;
        this.member = member;
        this.createdTime = createdTime;
    }
}
