package your.tmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import your.tmi.entity.Member;

public interface MemberRepository extends JpaRepository <Member, Long>{

}
