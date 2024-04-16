package org.freetime.me.bg3builds.mapper;

import org.freetime.me.bg3builds.dto.LootItemDto;
import org.freetime.me.bg3builds.dto.LootTableDto;
import org.freetime.me.bg3builds.entity.LootItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = LootItemDetailMapper.class)
public interface LootItemMapper {

    LootItem updateLootItem(LootItem newItem, @MappingTarget LootItem oldItem);

    LootItemDto entityToDto(LootItem lootItem);

    LootTableDto dtoToTableDto(List<LootItem> data, Long total);

}
