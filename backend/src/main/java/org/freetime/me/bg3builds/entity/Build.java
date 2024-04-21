package org.freetime.me.bg3builds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Build extends BaseEntity<Long> {

    @NotNull
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "build")
    @ToString.Exclude
    private List<BuildLootItem> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Build build = (Build) o;
        return Objects.equals(name, build.name) && Objects.equals(items, build.items);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
