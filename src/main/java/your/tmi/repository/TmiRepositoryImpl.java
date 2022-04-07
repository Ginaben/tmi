package your.tmi.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import your.tmi.dto.TmiDto;
import your.tmi.entity.QMember;
import your.tmi.entity.Tmi;

import javax.persistence.EntityManager;
import java.util.List;

import static your.tmi.entity.QMember.member;
import static your.tmi.entity.QTmi.tmi;

public class TmiRepositoryImpl implements TmiRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public TmiRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    //Tmi 리스트
    @Override
    public Slice<TmiDto> getTmi(Pageable pageable, Long id) {
        List<TmiDto> content = queryFactory
                .select(Projections.constructor(TmiDto.class,
                        tmi.id,
                        tmi.text,
                        member,
                        tmi.createdDate
                ))
                .from(tmi, tmi)
                .innerJoin(tmi.member, member).on(member.id.eq(tmi.member.id))
                .where(tmi.member.id.eq(id))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<Tmi> countQuery = queryFactory
                .selectFrom(tmi)
                .where(tmi.member.id.eq(id))
                .fetch();

        return new PageImpl<>(content, pageable, countQuery.size());

    }


}
