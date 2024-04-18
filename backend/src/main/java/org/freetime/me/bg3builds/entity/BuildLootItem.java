package org.freetime.me.bg3builds.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BuildLootItem {

    @EmbeddedId
    private BuildItemKey buildItemKey;

    private Boolean isLooted = false;

    @ManyToOne
    @MapsId("buildId")
    @JoinColumn(name = "build_id")
    private Build build;

    @ManyToOne
    @MapsId("lootItemId")
    @JoinColumn(name = "loot_item_id")
    private LootItem lootItem;

    @Version
    private Long version;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @Setter(AccessLevel.NONE)
    private LocalDateTime updatedAt;

    @PrePersist
    private void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
