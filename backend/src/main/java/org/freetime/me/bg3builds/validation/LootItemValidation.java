package org.freetime.me.bg3builds.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.entity.LootItem;
import org.freetime.me.bg3builds.exception.BuildNotFoundException;
import org.freetime.me.bg3builds.persistence.LootItemRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class LootItemValidation {
    private final LootItemRepository lootItemRepository;

    public LootItem getLootItemExistById(Long lootItemId) {
        Optional<LootItem> possibleLootItem = lootItemRepository.findById(lootItemId);
        if (possibleLootItem.isEmpty()) {
            throw new BuildNotFoundException("LootItem not found");
        }
        return possibleLootItem.get();
    }
}
