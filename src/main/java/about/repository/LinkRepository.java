package about.repository;

import org.springframework.data.repository.CrudRepository;
import about.Link;

public interface LinkRepository extends CrudRepository<Link, Long> {
}
