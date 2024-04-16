package org.freetime.me.bg3builds.mapper;

import org.freetime.me.bg3builds.dto.LootItemDetailDto;
import org.freetime.me.bg3builds.dto.cargoquery.CargoQueryObjectDetailDto;
import org.freetime.me.bg3builds.entity.LootItemDetail;
import org.freetime.me.bg3builds.entity.enums.LootItemType;
import org.freetime.me.bg3builds.util.EnumUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LootItemDetailMapper {

    @Mapping(source = "type", target = "subtype", qualifiedByName = "apiLootItemTypeToEnum")
    LootItemDetail cargoQueryObjectDetailDtoToEntity(CargoQueryObjectDetailDto cargoQueryObjectDetailDto);

    List<LootItemDetail> cargoQueryObjectDetailDtoToEntity(List<CargoQueryObjectDetailDto> cargoQueryObjectDetailDto);

    LootItemDetail updateLootItemDetail(LootItemDetail newItem, @MappingTarget LootItemDetail toUpdate);

    @Mapping(source = "subtype", target = "subtype", qualifiedByName = "apiLootItemTypeToString")
    LootItemDetailDto entityToDto(LootItemDetail lootItemDetail);

    @Named("apiLootItemTypeToEnum")
    static LootItemType apiLootItemTypeToEnum(String type) {
        return EnumUtil.stringToEnum(type);
    }

    @Named("apiLootItemTypeToString")
    static String apiLootItemTypeToString(LootItemType type) {
        return type.getTypeName();
    }

}

