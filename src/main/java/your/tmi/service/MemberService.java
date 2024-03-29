package your.tmi.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import your.tmi.dto.MemberDto;
import your.tmi.dto.search.SearchCondition;
import your.tmi.entity.Member;

public interface MemberService {
    //회원가입
    //Long save(String username, String password, String nickName, String month, String day);
    Long save(Member member);

    //디테일에 정보 불러오기
    MemberDto getInfo(Long id);
    //닉네임 중복확인
    Integer countByNickName(String nickName);
    //검색
    Slice<MemberDto> searchDay(Pageable pageable, SearchCondition condition);


    //테스트 회원가입
    Long testSave(Member member);

    }
