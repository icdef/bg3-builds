package org.freetime.me.bg3builds.mapper;

import org.freetime.me.bg3builds.dto.GearDto;
import org.freetime.me.bg3builds.dto.GearTableDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class)
public interface GearMapper {

    GearTableDto dtoToTableDto(List<GearDto> data, Long total);
}
