package about.repository;

import org.springframework.data.repository.CrudRepository;
import about.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
