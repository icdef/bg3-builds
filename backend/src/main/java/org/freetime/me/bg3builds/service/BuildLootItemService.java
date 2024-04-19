package org.freetime.me.bg3builds.service;

import org.freetime.me.bg3builds.dto.LootItemToggleDto;

public interface BuildLootItemService {

    LootItemToggleDto updateToggleForLootItemInBuild(Long lootItemId, Long buildId, Boolean isLootedNew);
}
