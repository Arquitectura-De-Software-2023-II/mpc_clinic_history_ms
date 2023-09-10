package model;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

public class Disease {
    @Indexed
    private String name;
    private Date discoveryDate;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(Date discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "name='" + name + '\'' +
                ", discoveryDate=" + discoveryDate +
                ", description='" + description + '\'' +
                '}';
    }
}
