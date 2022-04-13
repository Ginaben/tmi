package your.tmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import your.tmi.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository <Member, Long>, MemberRepositoryCustom{

    Optional<Member> findByUsername(String username);

    //닉네임 중복확인
    Integer countByNickName(@Param("nickName") String nickName);

}
