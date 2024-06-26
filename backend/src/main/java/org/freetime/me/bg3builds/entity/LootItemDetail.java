package org.freetime.me.bg3builds.entity;

import jakarta.persistence.*;
import lombok.*;
import org.freetime.me.bg3builds.entity.enums.LootItemType;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LootItemDetail extends BaseEntity<Long> {

    @Column(unique = true)
    private String name;

    private String type;

    @Enumerated(EnumType.STRING)
    private LootItemType subtype;

    @PrePersist
    private void setLootItemDetailType() {
        this.type = LootItemType.valueOf(String.valueOf(this.subtype)).getTypeKind();
    }

    @PreUpdate
    private void setLootItemDetailTypeUpdate() {
        this.type = LootItemType.valueOf(String.valueOf(this.subtype)).getTypeKind();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        if (!super.equals(o)) return false;
        LootItemDetail that = (LootItemDetail) o;
        return Objects.equals(name, that.name) && Objects.equals(type, that.type) && subtype == that.subtype;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
