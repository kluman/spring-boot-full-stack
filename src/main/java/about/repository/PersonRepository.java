package about.repository;

import org.springframework.data.repository.CrudRepository;
import about.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
