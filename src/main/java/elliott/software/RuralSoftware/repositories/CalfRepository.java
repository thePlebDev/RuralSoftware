package elliott.software.RuralSoftware.repositories;

import elliott.software.RuralSoftware.models.Calf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalfRepository extends JpaRepository<Calf,Long> {
}
