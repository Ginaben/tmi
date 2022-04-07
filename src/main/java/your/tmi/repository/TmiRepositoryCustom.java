package your.tmi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import your.tmi.dto.TmiDto;

public interface TmiRepositoryCustom {
    //Tmi 리스트
    Slice<TmiDto> getTmi(Pageable pageable, Long id);

    }
