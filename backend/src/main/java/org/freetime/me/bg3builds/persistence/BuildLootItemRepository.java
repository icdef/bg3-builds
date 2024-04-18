package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.BuildItemKey;
import org.freetime.me.bg3builds.entity.BuildLootItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildLootItemRepository extends JpaRepository<BuildLootItem, BuildItemKey> {
}
