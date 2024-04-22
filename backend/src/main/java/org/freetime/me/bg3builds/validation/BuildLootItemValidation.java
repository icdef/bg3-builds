package org.freetime.me.bg3builds.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.entity.BuildItemKey;
import org.freetime.me.bg3builds.entity.BuildLootItem;
import org.freetime.me.bg3builds.exception.BuildLootItemNotFoundException;
import org.freetime.me.bg3builds.exception.BuildLootItemUniqueConstraintException;
import org.freetime.me.bg3builds.persistence.BuildLootItemRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class BuildLootItemValidation {

    private final BuildLootItemRepository buildLootItemRepository;


    public void checkBuildLootItemUnique(Long buildId, Long lootItemId) {
        Optional<BuildLootItem> buildLootItem = buildLootItemRepository.findByBuildIdAndLootItemId(buildId, lootItemId);
        if (buildLootItem.isPresent())
            throw new BuildLootItemUniqueConstraintException("Item is already added to this build");
    }

    public BuildLootItem getBuildLootItemExistById(Long buildId, Long lootItemId) {
        Optional<BuildLootItem> possibleBuildLootItem = buildLootItemRepository.findById(new BuildItemKey(buildId, lootItemId));
        if (possibleBuildLootItem.isEmpty()) {
            throw new BuildLootItemNotFoundException("Item is not associated with this build");
        }
        return possibleBuildLootItem.get();
    }
}
