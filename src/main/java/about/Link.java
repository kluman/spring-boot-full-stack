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

    private String body;

    private String href;

    private Target target;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
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
