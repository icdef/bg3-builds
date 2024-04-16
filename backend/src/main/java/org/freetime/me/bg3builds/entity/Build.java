package org.freetime.me.bg3builds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Build extends BaseEntity<Long> {

    @NotNull
    private String name;

    @ManyToMany
    @ToString.Exclude
    private Set<LootItem> items;

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
