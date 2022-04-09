package your.tmi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import your.tmi.entity.Member;
import your.tmi.service.MemberService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class TestData {

    private final InitService initService;

    @PostConstruct
    public void initService() {
        initService.init();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    @Slf4j
    static class InitService {

        private final EntityManager em;

        private final MemberService memberService;

        public void init() {
            Member member1 = new Member("1","1", "벤잠","12","3");
            memberService.testSave(member1);
            Member member2 = new Member("2","2", "Judy","1","5");
            memberService.testSave(member2);
            Member member3 = new Member("3","3", "Byeol","5","20");
            memberService.testSave(member3);
            Member member4 = new Member("4","4", "제니","8","7");
            memberService.testSave(member4);
            Member member5 = new Member("5","5", "Kate","2","7");
            memberService.testSave(member5);
            Member member6 = new Member("6","6", "홍레","11","13");
            memberService.testSave(member6);

            em.flush();
            em.clear();

        }
    }

}
