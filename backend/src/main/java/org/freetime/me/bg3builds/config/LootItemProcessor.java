package org.freetime.me.bg3builds.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.entity.LootItem;
import org.freetime.me.bg3builds.entity.LootItemDetail;
import org.freetime.me.bg3builds.mapper.LootItemMapper;
import org.freetime.me.bg3builds.persistence.LootItemDetailRepository;
import org.freetime.me.bg3builds.persistence.LootItemRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@Slf4j
@RequiredArgsConstructor
public class LootItemProcessor implements ItemProcessor<LootItem, LootItem> {

    private final LootItemRepository lootItemRepository;
    private final LootItemMapper lootItemMapper;
    private final LootItemDetailRepository lootItemDetailRepository;

    @Override
    public LootItem process(LootItem item) {
        Optional<LootItem> lootItem = lootItemRepository.findByItemNameAndAct(item.getItemName(), item.getAct());
        if (lootItem.isEmpty()) {
            List<LootItemDetail> lootItemDetailList = lootItemDetailRepository.findByNameLike(item.getItemName());
            // contains needed due to items existing as (common) and (rare)
            lootItemDetailList.stream().filter(x -> item.getItemName().contains(x.getName())).findAny().ifPresent(item::setLootItemDetail);
            return item;
        }
        return lootItemMapper.updateLootItem(item, lootItem.get());
    }
}
