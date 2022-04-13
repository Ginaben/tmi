package your.tmi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import your.tmi.dto.MemberDto;
import your.tmi.dto.search.SearchCondition;

public interface MemberRepositoryCustom {

    //검색
    Slice<MemberDto> searchDay(Pageable pageable, SearchCondition condition);

    }
