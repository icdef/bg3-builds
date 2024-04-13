package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.LootItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LootItemRepository extends JpaRepository<LootItem, Long> {
    Optional<LootItem> findByItemNameAndAct(String itemName, Integer act);
}
