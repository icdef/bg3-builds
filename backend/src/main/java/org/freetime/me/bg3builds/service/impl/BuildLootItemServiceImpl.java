package org.freetime.me.bg3builds.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.LootItemToggleDto;
import org.freetime.me.bg3builds.entity.BuildLootItem;
import org.freetime.me.bg3builds.exception.BuildItemNotFoundException;
import org.freetime.me.bg3builds.mapper.BuildLootItemMapper;
import org.freetime.me.bg3builds.persistence.BuildLootItemRepository;
import org.freetime.me.bg3builds.service.BuildLootItemService;
import org.freetime.me.bg3builds.validation.BuildLootItemValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BuildLootItemServiceImpl implements BuildLootItemService {
    private final BuildLootItemRepository buildLootItemRepository;
    private final BuildLootItemMapper buildLootItemMapper;
    private final BuildLootItemValidation buildLootItemValidation;

    @Override
    public LootItemToggleDto updateToggleForLootItemInBuild(Long lootItemId, Long buildId, Boolean isLootedNew) {
        Optional<BuildLootItem> buildLootItem = buildLootItemRepository.findByBuildIdAndLootItemId(buildId, lootItemId);
        if (buildLootItem.isEmpty())
            throw new BuildItemNotFoundException("Item not associated with this Build");

        BuildLootItem toUpdate = buildLootItem.get();
        toUpdate.setIsLooted(isLootedNew);

        return buildLootItemMapper.toLootItem(buildLootItemRepository.save(toUpdate));
    }


    @Override
    public BuildLootItem save(BuildLootItem item) {
        return buildLootItemRepository.save(item);
    }

    @Override
    public void delete(BuildLootItem item) {
        buildLootItemRepository.delete(item);
    }

    @Override
    public void deleteAll(List<BuildLootItem> items) {
        buildLootItemRepository.deleteAll(items);
    }

    @Override
    public List<BuildLootItem> getBuildLootItemsById(Long buildId) {
        return buildLootItemRepository.findByBuildId(buildId);
    }

}
