package about;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;

    private String address;

    private String phone;

    private String website;

    private List<Position> positions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Position> getPositions() {
        if (positions == null) {
            return new ArrayList<>();
        }
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
