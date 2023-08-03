package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    protected String name;
    protected Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder tagBuilder = new StringBuilder();
        tagBuilder.append("<").append(name);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            tagBuilder.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        tagBuilder.append(">");
        return tagBuilder.toString();
    }
}
// END
