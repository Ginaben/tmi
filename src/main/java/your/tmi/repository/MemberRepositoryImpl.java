package your.tmi.repository;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.util.StringUtils;
import your.tmi.dto.MemberDto;
import your.tmi.dto.search.SearchCondition;
import your.tmi.dto.search.SearchType;
import your.tmi.entity.Member;
import your.tmi.entity.QTmi;

import javax.persistence.EntityManager;
import java.util.List;

import static com.querydsl.core.types.ExpressionUtils.count;
import static your.tmi.entity.QMember.member;

public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Slice<MemberDto> searchDay(Pageable pageable, SearchCondition condition) {
        QTmi subTmi = new QTmi("subTmi");

        List<MemberDto> content = queryFactory
                .select(Projections.constructor(MemberDto.class,
                        member.id,
                        member.nickName,
                        member.month,
                        member.day,
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(count(subTmi.id))
                                        .from(subTmi, subTmi)
                                        .where(subTmi.member.id.eq(member.id)),"tmiCount")
                        ))
                .from(member, member)
                .where(isSearch(condition.getSearchType(), condition.getContent()))
                .orderBy(member.nickName.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<Member> countQuery = queryFactory
                .selectFrom(member)
                .fetch();

        return new PageImpl<>(content, pageable, countQuery.size());

    }

    //검색조건
    private BooleanExpression eqName(String nickName) {
        return StringUtils.hasText(nickName) ? member.nickName.containsIgnoreCase(nickName) : null;
    }

    private BooleanExpression eqMonth(String month) {
        return StringUtils.hasText(month) ? member.month.eq(month) : null;
    }

    private BooleanExpression isSearch(SearchType searchType, String searchText) {
        if (searchType.equals(SearchType.NICKNAME)) {
            return eqName(searchText);
        } else if (searchType.equals(SearchType.MONTH)) {
            return eqMonth(searchText);
        } else {
            return eqName(searchText).or(eqMonth(searchText));
        }
    }

}
