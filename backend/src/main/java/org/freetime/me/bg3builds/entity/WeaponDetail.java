package org.freetime.me.bg3builds.entity;

import jakarta.persistence.*;
import lombok.*;
import org.freetime.me.bg3builds.entity.enums.WeaponType;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
public class WeaponDetail extends BaseEntity<Long> {

    @Column(unique = true)
    private String name;
    @ColumnDefault("0")
    private Integer price;
    private String type;

    @Enumerated(EnumType.STRING)
    private WeaponType subtype;

    @PrePersist
    private void setAsWeapon() {
        this.type = "Weapon";
    }

    @PreUpdate
    private void setAsWeaponUpdate() {
        this.type = "Weapon";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        if (!super.equals(o)) return false;
        WeaponDetail that = (WeaponDetail) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(type, that.type) && Objects.equals(subtype, that.subtype);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
