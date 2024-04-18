package org.freetime.me.bg3builds.mapper;

import org.freetime.me.bg3builds.dto.LootItemToggleDto;
import org.freetime.me.bg3builds.entity.BuildLootItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = DefaultMapperConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BuildLootItemMapper {

    @Mapping(source = "lootItem.lootItemDetail", target = "lootItemDetail")
    @Mapping(source = "lootItem.itemSource", target = "itemSource")
    @Mapping(source = "lootItem.itemEffect", target = "itemEffect")
    @Mapping(source = "lootItem.itemLocation", target = "itemLocation")
    @Mapping(source = "lootItem.id", target = "id")
    @Mapping(source = "lootItem.act", target = "act")
    @Mapping(source = "lootItem.itemName", target = "itemName")
    LootItemToggleDto toLootItem(BuildLootItem buildLootItem);
}
