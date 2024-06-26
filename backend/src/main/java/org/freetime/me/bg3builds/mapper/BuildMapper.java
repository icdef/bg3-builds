package org.freetime.me.bg3builds.mapper;

import org.freetime.me.bg3builds.dto.BuildDto;
import org.freetime.me.bg3builds.entity.Build;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {LootItemMapper.class, BuildLootItemMapper.class})
public interface BuildMapper {

    void updateBuild(Build newBuild, @MappingTarget Build toUpdateBuild);

    BuildDto entityToDto(Build build);

    List<BuildDto> entityToDto(List<Build> build);

}
