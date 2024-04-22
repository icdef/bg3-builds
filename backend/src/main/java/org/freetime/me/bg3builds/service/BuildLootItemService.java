package org.freetime.me.bg3builds.service;

import org.freetime.me.bg3builds.dto.LootItemToggleDto;
import org.freetime.me.bg3builds.entity.BuildLootItem;

import java.util.List;

public interface BuildLootItemService {

    LootItemToggleDto updateToggleForLootItemInBuild(Long lootItemId, Long buildId, Boolean isLootedNew);

    BuildLootItem save(BuildLootItem item);

    void delete(BuildLootItem item);

    void deleteAll(List<BuildLootItem> items);

    List<BuildLootItem> getBuildLootItemsById(Long buildId);
}
