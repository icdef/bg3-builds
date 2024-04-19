package org.freetime.me.bg3builds.service;


import org.freetime.me.bg3builds.dto.BuildDto;
import org.freetime.me.bg3builds.dto.LootItemToggleDto;

import java.util.List;

public interface BuildService {

    List<BuildDto> getBuilds();

    LootItemToggleDto updateToggleForLootItemInBuild(Long lootItemId, Long buildId, Boolean isLootedNew);
}
