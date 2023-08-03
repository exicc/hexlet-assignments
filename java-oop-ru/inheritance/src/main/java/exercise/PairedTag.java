package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public class PairedTag extends Tag {
    protected String body;
    protected List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder tagBuilder = new StringBuilder();
        tagBuilder.append(super.toString());

        if (!body.isEmpty() || !children.isEmpty()) {
            tagBuilder.append(body);
            for (Tag child : children) {
                tagBuilder.append(child.toString());
            }
        }

        tagBuilder.append("</").append(name).append(">");
        return tagBuilder.toString();
    }
}
// END
