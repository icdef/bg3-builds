package org.freetime.me.bg3builds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BuildItemKey implements Serializable {

    @Column(name = "build_id")
    private Long buildId;
    @Column(name = "loot_item_id")
    private Long lootItemId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BuildItemKey that = (BuildItemKey) o;
        return Objects.equals(buildId, that.buildId) && Objects.equals(lootItemId, that.lootItemId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
