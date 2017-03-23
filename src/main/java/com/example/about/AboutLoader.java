package com.example.about;

import java.time.Instant;
import java.util.Date;

import com.example.about.domain.Address;
import com.example.about.domain.AddressRepository;
import com.example.about.domain.Company;
import com.example.about.domain.CompanyRepository;
import com.example.about.domain.Person;
import com.example.about.domain.PersonRepository;
import com.example.about.domain.Position.Builder;
import com.example.about.domain.PositionRepository;
import com.example.about.domain.Project;
import com.example.about.domain.ProjectRepository;
import com.example.about.domain.University;
import com.example.about.domain.UniversityRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
    private AddressRepository addressRepository;

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

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        new Person.Builder()
                .first("Kevin")
                .last("Luman")
                .middle("L.")
                .email("kevinleeluman@gmail.com")
                .address(new Address.Builder()
                        .setAddress("1234 Main St.")
                        .setCity("Ashburn")
                        .setRegion("VA")
                        .setPostalCode("20147")
                        .setPhone("(703) 555-0000")
                        .build(addressRepository))
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
                                .address(new Address.Builder()
                                        .setAddress("12120 Sunset Hills Rd")
                                        .setCity("Reston")
                                        .setRegion("VA")
                                        .setPostalCode("20190")
                                        .setPhone("(703) 956-5850")
                                        .build(addressRepository))
                                .positions(new ImmutableList.Builder()
                                        .add(new Builder()
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
