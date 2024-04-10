package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.LootItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LootItemRepository extends JpaRepository<LootItem, Long> {
    Optional<LootItem> findByItemNameAndAct(String itemName, Integer act);
}
