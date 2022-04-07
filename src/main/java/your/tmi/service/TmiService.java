package your.tmi.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import your.tmi.dto.TmiDto;

public interface TmiService {
    //TMI 저장
    Long addTmi(String text, Long id);

    //tmi 페이징
    Slice<TmiDto> getTmi(Pageable pageable, Long id);


    }
