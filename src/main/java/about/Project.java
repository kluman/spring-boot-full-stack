package about;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import about.repository.ProjectRepository;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String title;

    private final String website;

    private final Date start;

    private final Date end;

    private final String responsibilities;

    @ElementCollection
    private final List<String> code;

    public Project(Builder builder) {
         this.title = builder.title;
         this.website = builder.website;
         this.start = builder.start;
         this.end = builder.end;
         this.responsibilities = builder.responsibilities;
         this.code = builder.code;
    }

    // Spring Boot JPA needs the default constructor so stub out with null values.
    public Project() {
        this.title = null;
        this.website = null;
        this.start = null;
        this.end = null;
        this.responsibilities = null;
        this.code = null;
    }

    public String getTitle() {
        return title;
    }

    public String getWebsite() {
        return website;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public List<String> getCode() {
        if (code == null) {
            return new ArrayList<>();
        }
        return code;
    }

    public static class Builder {

        private String title;

        private String website;

        private Date start;

        private Date end;

        private String responsibilities;

        private List<String> code;

        public Project build(ProjectRepository repository) {
            Project project = new Project(this);

            if (repository != null) {
                repository.save(project);
            }

            return project;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder website(String website) {
            this.website = website;
            return this;
        }

        public Builder start(Date start) {
            this.start = start;
            return this;
        }

        public Builder end(Date end) {
            this.end = end;
            return this;
        }

        public Builder responsibilities(String responsibilities) {
            this.responsibilities = responsibilities;
            return this;
        }

        public Builder code(List<String> code) {
            this.code = code;
            return this;
        }
    }
}
