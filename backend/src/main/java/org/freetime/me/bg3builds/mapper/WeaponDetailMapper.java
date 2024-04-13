package org.freetime.me.bg3builds.mapper;

import org.freetime.me.bg3builds.dto.cargoquery.CargoQueryObjectDetailDto;
import org.freetime.me.bg3builds.entity.WeaponDetail;
import org.freetime.me.bg3builds.entity.enums.WeaponType;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WeaponDetailMapper {

    @Mapping(source = "type", target = "subtype", qualifiedByName = "apiWeaponTypeToEnum")
    WeaponDetail cargoQueryObjectDetailDtoToEntity(CargoQueryObjectDetailDto cargoQueryObjectDetailDto);

    List<WeaponDetail> cargoQueryObjectDetailDtoToEntity(List<CargoQueryObjectDetailDto> cargoQueryObjectDetailDtoList);

    WeaponDetail updateWeaponDetail(WeaponDetail newItem, @MappingTarget WeaponDetail toUpdate);

    @Named("apiWeaponTypeToEnum")
    static WeaponType apiWeaponTypeToEnum(String type) {
        return Enum.valueOf(WeaponType.class, type.trim().toUpperCase().replace(' ', '_'));
    }
}
