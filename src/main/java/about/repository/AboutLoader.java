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
import about.Project;
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

        new Person.Builder()
                .first("Kevin")
                .last("Luman")
                .middle("L")
                .email("kevinleeluman@gmail.com")
                .address("20046 Muirfield Village Ct. Ashuburn, VA 20147")
                .homePhone("703-468-1398")
                .education(new ImmutableList.Builder()
                        .add(new University.Builder()
                                .degree("Government & Politics")
                                .name("George Mason University")
                                .notes("Graduated with High Honors.")
                                .graduation(Date.from(Instant.ofEpochSecond(833635669)))
                                .build(universityRepository))
                        .build())
                .jobs(new ImmutableList.Builder<Company>()
                        .add(new Company.Builder()
                                .name("Pefect Sense")
                                .address("12120 Sunset Hills Rd, Reston, VA 20190")
                                .phone("(703) 956-5850")
                                .positions(new ImmutableList.Builder()
                                        .add(new Position.Builder()
                                                .title("Principle Software Engineer")
                                                .start(Date.from(Instant.ofEpochSecond(1271725446)))
                                                .projects(new ImmutableList.Builder()
                                                        .add(new Project.Builder()
                                                                .title("Politico")
                                                                .responsibilities("Backend Java & JSP development. Custom Adobe InDesign plugin to allow bi-directional updating between Brightspot CMS and Adobe InDesign.")
                                                                .website("www.politico.com")
                                                                .build(projectRepository))
                                                        .add(new Project.Builder()
                                                                .title("Univision")
                                                                .responsibilities("Backend Java (+Freemarker) and Frontend (CSS, Javascript, HTML) development.")
                                                                .website("www.univision.com")
                                                                .build(projectRepository))
                                                        .build())
                                                .build(positionRepository))
                                        .build())
                                .build(companyRepository))
                        .build())
                .build(personRepository);
    }
}
