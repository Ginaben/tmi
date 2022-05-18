package your.tmi.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;
import your.tmi.dto.TmiDto;
import your.tmi.entity.Tmi;

public interface TmiService {
    //TMI 저장
    Long addTmi(String text, Long id);

    //tmi 페이징
    Slice<TmiDto> getTmi(Pageable pageable, Long id);

    //tmi 삭제
    void removeTmi(Long tno);


    //테스트 TMI 저장
    Long addTestTmi(Tmi tmi);

}
