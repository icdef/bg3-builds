package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.BuildItemKey;
import org.freetime.me.bg3builds.entity.BuildLootItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuildLootItemRepository extends JpaRepository<BuildLootItem, BuildItemKey> {
    Optional<BuildLootItem> findByBuildIdAndLootItemId(Long buildId, Long lootItemId);

    List<BuildLootItem> findByBuildId(Long id);
}
