package about;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Position {

    private String title;

    private Date start;

    private Date end;

    private String responsibilities;

    private List<Project> projects;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public List<Project> getProjects() {
        if (projects == null) {
            return new ArrayList<>();
        }
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
