package io.pivotal.cnde.cups;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Tag")
public class Tag {
    private Integer id;
    private String label;

    public Tag() {
    }

    public Tag(Integer id, String label) {

        this.id = id;
        this.label = label;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Tag setId(Integer id) {
        this.id = id;
        return this;
    }

    public Tag setLabel(String label) {
        this.label = label;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) &&
                Objects.equals(label, tag.label);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, label);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}

