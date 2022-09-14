package elliott.software.RuralSoftware.repositories;

import elliott.software.RuralSoftware.models.Authority;
import elliott.software.RuralSoftware.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByAuthorities(Authority authority);
}
