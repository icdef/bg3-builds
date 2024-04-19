package org.freetime.me.bg3builds.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.BuildDto;
import org.freetime.me.bg3builds.dto.LootItemToggleDto;
import org.freetime.me.bg3builds.mapper.BuildMapper;
import org.freetime.me.bg3builds.persistence.BuildRepository;
import org.freetime.me.bg3builds.service.BuildLootItemService;
import org.freetime.me.bg3builds.service.BuildService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BuildServiceImpl implements BuildService {

    private final BuildRepository buildRepository;
    private final BuildMapper buildMapper;
    private final BuildLootItemService buildLootItemService;

    @Override
    public List<BuildDto> getBuilds() {
        return buildMapper.entityToDto(buildRepository.findAll());
    }

    @Override
    public LootItemToggleDto updateToggleForLootItemInBuild(Long lootItemId, Long buildId, Boolean isLootedNew) {
        return buildLootItemService.updateToggleForLootItemInBuild(lootItemId, buildId, isLootedNew);
    }
}
