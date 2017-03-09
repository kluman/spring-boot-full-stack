package about.repository;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import about.University;

/**
 * Preload database with information.
 */
@Component
public class AboutLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UniversityRepository universityRepository;

    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        University university = new University();
        university.setDegree("Government & Politics");
        university.setName("George Mason University");
        university.setNotes("Graduated with High Honors.");
        university.setGraduation(Date.from(Instant.ofEpochSecond(833635669)));

        universityRepository.save(university);

        // TODO: Finish with rest of data loading
    }
}
