package org.freetime.me.bg3builds.mapper;

import org.freetime.me.bg3builds.entity.LootItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = DefaultMapperConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LootItemMapper {

    LootItem updateLootItem(LootItem newItem, @MappingTarget LootItem oldItem);
}
