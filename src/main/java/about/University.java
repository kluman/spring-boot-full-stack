package about;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import about.repository.UniversityRepository;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String name;

    private final Date graduation;

    private final String degree;

    private final String notes;

    public University(Builder builder) {
        this.name = builder.name;
        this.graduation = builder.graduation;
        this.degree = builder.degree;
        this.notes = builder.notes;
    }

    // Spring Boot JPA needs the default constructor so stub out with null values.
    public University() {
        this.name = null;
        this.graduation = null;
        this.degree = null;
        this.notes = null;
    }

    public String getName() {
        return name;
    }

    public Date getGraduation() {
        return graduation;
    }

    public String getDegree() {
        return degree;
    }

    public String getNotes() {
        return notes;
    }

    public static class Builder {

        private String name;

        private Date graduation;

        private String degree;

        private String notes;

        public University build(UniversityRepository repository) {
            University university = new University(this);

            if (repository != null) {
                repository.save(university);
            }

            return university;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder graduation(Date graduation) {
            this.graduation = graduation;
            return this;
        }

        public Builder degree(String degree) {
            this.degree = degree;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }
    }
}
