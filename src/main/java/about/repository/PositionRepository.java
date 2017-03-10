package about.repository;

import org.springframework.data.repository.CrudRepository;
import about.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {
}
