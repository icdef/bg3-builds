package org.freetime.me.bg3builds.mapper;

import org.freetime.me.bg3builds.dto.LootItemDetailDto;
import org.freetime.me.bg3builds.dto.cargoquery.CargoQueryObjectDetailDto;
import org.freetime.me.bg3builds.entity.LootItemDetail;
import org.freetime.me.bg3builds.entity.enums.GearType;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LootItemDetailMapper {

    @Mapping(source = "type", target = "subtype", qualifiedByName = "apiGearTypeToEnum")
    LootItemDetail cargoQueryObjectDetailDtoToEntity(CargoQueryObjectDetailDto cargoQueryObjectDetailDto);

    List<LootItemDetail> cargoQueryObjectDetailDtoToEntity(List<CargoQueryObjectDetailDto> cargoQueryObjectDetailDto);

    LootItemDetail updateLootItemDetail(LootItemDetail newItem, @MappingTarget LootItemDetail toUpdate);

    @Mapping(source = "subtype", target = "subtype", qualifiedByName = "apiGearTypeToString")
    LootItemDetailDto entityToDto(LootItemDetail lootItemDetail);

    @Named("apiGearTypeToEnum")
    static GearType apiGearTypeToEnum(String type) {
        return Enum.valueOf(GearType.class, type.trim().toUpperCase().replace(' ', '_'));
    }

    @Named("apiGearTypeToString")
    static String apiGearTypeToString(GearType type) {
        return type.getTypeName();
    }

}

