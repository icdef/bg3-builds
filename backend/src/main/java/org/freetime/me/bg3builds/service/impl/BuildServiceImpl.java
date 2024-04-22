package org.freetime.me.bg3builds.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.*;
import org.freetime.me.bg3builds.entity.Build;
import org.freetime.me.bg3builds.entity.BuildItemKey;
import org.freetime.me.bg3builds.entity.BuildLootItem;
import org.freetime.me.bg3builds.entity.LootItem;
import org.freetime.me.bg3builds.mapper.BuildMapper;
import org.freetime.me.bg3builds.persistence.BuildRepository;
import org.freetime.me.bg3builds.service.BuildLootItemService;
import org.freetime.me.bg3builds.service.BuildService;
import org.freetime.me.bg3builds.validation.BuildLootItemValidation;
import org.freetime.me.bg3builds.validation.BuildValidation;
import org.freetime.me.bg3builds.validation.LootItemValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BuildServiceImpl implements BuildService {

    private final BuildRepository buildRepository;
    private final BuildMapper buildMapper;
    private final BuildValidation buildValidation;
    private final LootItemValidation lootItemValidation;
    private final BuildLootItemService buildLootItemService;
    private final BuildLootItemValidation buildLootItemValidation;

    @Override
    public List<BuildDto> getBuilds() {
        return buildMapper.entityToDto(buildRepository.findAll());
    }

    @Override
    public LootItemToggleDto updateToggleForLootItemInBuild(Long lootItemId, Long buildId, Boolean isLootedNew) {
        return buildLootItemService.updateToggleForLootItemInBuild(lootItemId, buildId, isLootedNew);
    }

    @Override
    public BuildDto createBuild(CreateBuildDto createBuildDto) {
        Build build = new Build();
        build.setName(createBuildDto.getName());
        buildValidation.checkNameUnique(createBuildDto.getName());
        return buildMapper.entityToDto(buildRepository.save(build));
    }

    @Override
    public BuildDto updateBuild(UpdateBuildDto updateBuildDto, Long buildId) {
        Build build = buildValidation.getBuildExistById(buildId);
        buildValidation.checkNameUnique(updateBuildDto.getName());
        build.setName(updateBuildDto.getName());
        return buildMapper.entityToDto(buildRepository.save(build));
    }

    @Override
    public void deleteBuild(Long buildId) {
        Build build = buildValidation.getBuildExistById(buildId);
        buildRepository.delete(build);
    }

    @Override
    public BuildDto addItemToBuild(LootItemDto item, Long buildId) {
        Build build = buildValidation.getBuildExistById(buildId);
        LootItem lootItem = lootItemValidation.getLootItemExistById(item.getId());
        buildLootItemValidation.checkBuildLootItemUnique(buildId, lootItem.getId());
        List<BuildLootItem> buildLootItems = new ArrayList<>();

        BuildLootItem buildLootItem = new BuildLootItem();
        buildLootItem.setBuildItemKey(new BuildItemKey(buildId, lootItem.getId()));
        buildLootItem.setBuild(build);
        buildLootItem.setLootItem(lootItem);
        buildLootItems.add(buildLootItem);

        build.setItems(buildLootItems);
        Build updated = buildRepository.save(build);
        return buildMapper.entityToDto(updated);
    }

    @Override
    public void removeItemFromBuild(LootItemDto itemDto, Long buildId) {
        BuildLootItem buildLootItem = buildLootItemValidation.getBuildLootItemExistById(buildId, itemDto.getId());
        buildLootItemService.delete(buildLootItem);
    }
}
