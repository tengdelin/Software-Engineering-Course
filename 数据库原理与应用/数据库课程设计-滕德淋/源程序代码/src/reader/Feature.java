package reader;

import java.util.ArrayList;
import java.util.List;

public class Feature {

    public List<AttributeValue> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeValue> attributes) {
        this.attributes = attributes;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    private List<AttributeValue> attributes;
    private String geometry;

    public Feature() {
        attributes = new ArrayList<AttributeValue>();
    }
}   