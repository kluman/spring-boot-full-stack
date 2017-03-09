package about;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String first;

    private String middle;

    private String last;

    private String address;

    private String homePhone;

    private String mobilePhone;

    private String email;

    private List<Link> links;

    private List<Company> jobs;

    private List<University> education;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Link> getLinks() {
        if (links == null) {
            return new ArrayList<>();
        }
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Company> getJobs() {
        if (jobs == null) {
            return new ArrayList<>();
        }
        return jobs;
    }

    public void setJobs(List<Company> jobs) {
        this.jobs = jobs;
    }

    public List<University> getEducation() {
        if (education == null) {
            new ArrayList<>();
        }
        return education;
    }

    public void setEducation(List<University> education) {
        this.education = education;
    }
}
