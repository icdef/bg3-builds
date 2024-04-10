package org.freetime.me.bg3builds.mapper;

import org.apache.commons.lang3.StringUtils;
import org.freetime.me.bg3builds.dto.cargoquery.CargoQueryObjectDetailDto;
import org.freetime.me.bg3builds.entity.EquipmentDetail;
import org.freetime.me.bg3builds.entity.enums.EquipmentType;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EquipmentDetailMapper {

    @Mapping(source = "type", target = "subtype", qualifiedByName = "apiEquipmentTypeToEnum")
    EquipmentDetail cargoQueryObjectDetailDtoToEntity(CargoQueryObjectDetailDto cargoQueryObjectDetailDto);

    List<EquipmentDetail> cargoQueryObjectDetailDtoToEntity(List<CargoQueryObjectDetailDto> cargoQueryObjectDetailDto);

    EquipmentDetail updateEquipmentDetail(EquipmentDetail newItem, @MappingTarget EquipmentDetail toUpdate);

    @Named("apiEquipmentTypeToEnum")
    public static EquipmentType apiWeaponTypeToEnum(String type) {
        return Enum.valueOf(EquipmentType.class, StringUtils.deleteWhitespace(type.toUpperCase()));
    }
}

