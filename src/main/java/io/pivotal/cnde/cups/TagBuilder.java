package io.pivotal.cnde.cups;

public class TagBuilder {
    public static TagBuilder tagBuilder() {
        return new TagBuilder();
    }

    private Integer id;
    private String label;

    private TagBuilder() {

    }

    public TagBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public TagBuilder label(String label) {
        this.label = label;
        return this;
    }

    public Tag build() {
        return new Tag(id, label);
    }
}