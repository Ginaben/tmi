package your.tmi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import your.tmi.dto.TmiDto;
import your.tmi.entity.Member;
import your.tmi.entity.Tmi;
import your.tmi.repository.MemberRepository;
import your.tmi.repository.TmiRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class TmiServiceImpl implements TmiService{

    private final MemberRepository memberRepository;
    private final TmiRepository tmiRepository;

    //TMI 저장
    @Override
    public Long addTmi(String text, Long id) {
        Member member = memberRepository.getById(id);
        return tmiRepository.save(new Tmi(text, member)).getId();
    }

    //tmi 페이징
    @Override
    public Slice<TmiDto> getTmi(Pageable pageable, Long id) {
        return tmiRepository.getTmi(pageable, id);
    }

    //tmi 삭제
    @Override
    public void removeTmi(Long tno) {
        tmiRepository.deleteById(tno);
    }


    //테스트 TMI 저장
    @Override
    @Transactional
    public Long addTestTmi(Tmi tmi) {
        Member member = memberRepository.getById(tmi.getMember().getId());
        return tmiRepository.save(new Tmi(tmi.getText(), member)).getId();
    }


}
