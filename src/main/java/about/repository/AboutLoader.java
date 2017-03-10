package about.repository;

import java.time.Instant;
import java.util.Date;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import about.Company;
import about.Person;
import about.Position;
import about.University;

/**
 * Preload database with information.
 */
@Component
public class AboutLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UniversityRepository universityRepository;
    private CompanyRepository companyRepository;
    private PersonRepository personRepository;
    private ProjectRepository projectRepository;
    private PositionRepository positionRepository;

    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Person me = new Person();
        me.setFirst("Kevin");
        me.setLast("Luman");
        me.setMiddle("L");
        me.setEmail("kevinleeluman@gmail.com");
        me.setAddress("20046 Muirfield Village Ct. Ashuburn, VA 20147");
        me.setHomePhone("703-468-1398");

        University university = new University();
        university.setDegree("Government & Politics");
        university.setName("George Mason University");
        university.setNotes("Graduated with High Honors.");
        university.setGraduation(Date.from(Instant.ofEpochSecond(833635669)));
        universityRepository.save(university);

        Company ps = new Company();
        ps.setName("Pefect Sense");
        ps.setAddress("Reston, VA");

        Position developer = new Position();
        developer.setTitle("Principle Software Engineer");
        positionRepository.save(developer);

        ps.setPositions(new ImmutableList.Builder<Position>()
                .add(developer)
                .build());
        companyRepository.save(ps);

        // Add past companies and education

        me.setJobs(new ImmutableList.Builder<Company>()
                .add(ps)
                .build());

        me.setEducation(new ImmutableList.Builder<University>()
                .add(university)
                .build());

        personRepository.save(me);

    }
}
