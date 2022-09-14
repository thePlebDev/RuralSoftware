package elliott.software.RuralSoftware.repositories;

import elliott.software.RuralSoftware.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {


    Optional<Authority> findByTitle(String  title);
}
