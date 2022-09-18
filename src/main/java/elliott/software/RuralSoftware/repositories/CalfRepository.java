package elliott.software.RuralSoftware.repositories;

import elliott.software.RuralSoftware.models.Calf;
import elliott.software.RuralSoftware.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalfRepository extends JpaRepository<Calf,Long> {

    List<Calf> findByUser(User user);
}
