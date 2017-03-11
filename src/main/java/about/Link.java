package about;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String body;

    private final String href;

    private final Target target;

    public Link(Builder builder) {
        this.body = builder.body;
        this.href = builder.href;
        this.target = builder.target;
    }

    // Spring Boot JPA needs the default constructor so stub out with null values.
    public Link() {
        this.body = null;
        this.href = null;
        this.target = null;
    }

    public String getBody() {
        return body;
    }

    public String getHref() {
        return href;
    }

    public Target getTarget() {
        return target;
    }

    public static class Builder {

        private String body;

        private String href;

        private Target target;

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder href(String href) {
            this.href = href;
            return this;
        }

        public Builder target(Target target) {
            this.target = target;
            return this;
        }
    }

    public enum Target {
        TOP("_top"),
        BLANK("_blank"),
        SELF("_self");

        private String attribute;

        Target(String attribute) {
            this.attribute = attribute;
        }

        public String attribute() {
            return attribute;
        }
    }
}
