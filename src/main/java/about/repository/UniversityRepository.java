package about.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import about.University;

@RepositoryRestResource
public interface UniversityRepository extends CrudRepository<University, Long> {
}
