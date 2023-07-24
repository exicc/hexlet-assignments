package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String labelText;
    private TagInterface childTag;


    public LabelTag(String labelText, TagInterface childTag) {
        this.labelText = labelText;
        this.childTag = childTag;
    }

    @Override
    public String render() {

        return "<label>" + labelText + childTag.render() + "</label>";
    }
}
// END
