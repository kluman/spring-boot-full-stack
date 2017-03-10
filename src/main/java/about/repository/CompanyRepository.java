package about.repository;

import org.springframework.data.repository.CrudRepository;
import about.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
