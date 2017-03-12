package com.example.about.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String title;

    private final Date start;

    private final Date end;

    private final String responsibilities;

    @OneToMany
    private final List<Project> projects;

    public Position(Builder builder) {
        this.title = builder.title;
        this.start = builder.start;
        this.end = builder.end;
        this.responsibilities = builder.responsibilities;
        this.projects = builder.projects;
    }

    // Spring Boot JPA needs the default constructor so stub out with null values.
    public Position() {
        this.title = null;
        this.start = null;
        this.end = null;
        this.responsibilities = null;
        this.projects = null;
    }

    public String getTitle() {
        return title;
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

    public List<Project> getProjects() {
        if (projects == null) {
            return new ArrayList<>();
        }
        return projects;
    }

    public static class Builder {

        private String title;

        private Date start;

        private Date end;

        private String responsibilities;

        private List<Project> projects;

        public Position build(PositionRepository repository) {
            Position position = new Position(this);

            if (repository != null) {
                repository.save(position);
            }

            return position;
        }

        public Builder title(String title) {
            this.title = title;
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

        public Builder projects(List<Project> projects) {
            this.projects = projects;
            return this;
        }
    }
}
