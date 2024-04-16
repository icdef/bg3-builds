package org.freetime.me.bg3builds.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"item_name", "act"}),
        })
public class LootItem extends BaseEntity<Long> {

    @NonNull
    private String itemName;

    @NonNull
    @Column(columnDefinition = "TEXT")
    private String itemEffect;

    @NonNull
    @Column(columnDefinition = "TEXT")
    private String itemSource;

    @NonNull
    private String itemLocation;

    @NonNull
    private Integer act;

    @ManyToOne(optional = false)
    private LootItemDetail lootItemDetail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        if (!super.equals(o)) return false;
        LootItem item = (LootItem) o;
        return Objects.equals(itemName, item.itemName) && Objects.equals(itemEffect, item.itemEffect) && Objects.equals(itemSource, item.itemSource) && Objects.equals(itemLocation, item.itemLocation);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
