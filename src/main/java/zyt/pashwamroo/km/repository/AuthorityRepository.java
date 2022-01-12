package zyt.pashwamroo.km.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zyt.pashwamroo.km.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
