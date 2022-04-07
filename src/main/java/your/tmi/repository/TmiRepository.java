package your.tmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import your.tmi.entity.Tmi;

public interface TmiRepository extends JpaRepository<Tmi, Long>, TmiRepositoryCustom {

}
