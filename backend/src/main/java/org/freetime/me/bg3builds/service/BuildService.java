package org.freetime.me.bg3builds.service;


import org.freetime.me.bg3builds.dto.*;

import java.util.List;

public interface BuildService {

    List<BuildDto> getBuilds();

    LootItemToggleDto updateToggleForLootItemInBuild(Long lootItemId, Long buildId, Boolean isLootedNew);

    BuildDto createBuild(CreateBuildDto createBuildDto);

    BuildDto updateBuild(UpdateBuildDto updateBuildDto, Long buildId);

    void deleteBuild(Long buildId);

    BuildDto addItemToBuild(LootItemDto item, Long buildId);

    void removeItemFromBuild(LootItemDto itemDto, Long buildId);
}
