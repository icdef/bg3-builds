package org.freetime.me.bg3builds.entity;

import jakarta.persistence.*;
import lombok.*;
import org.freetime.me.bg3builds.entity.enums.EquipmentType;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EquipmentDetail extends BaseEntity<Long> {

    @Column(unique = true)
    private String name;
    @ColumnDefault("0")
    private Integer price;
    private String type;

    @Enumerated(EnumType.STRING)
    private EquipmentType subtype;

    @PrePersist
    private void setAsEquipment() {
        this.type = "Equipment";
    }

    @PreUpdate
    private void setAsEquipmentUpdate() {
        this.type = "Equipment";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        if (!super.equals(o)) return false;
        EquipmentDetail that = (EquipmentDetail) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(type, that.type) && subtype == that.subtype;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
