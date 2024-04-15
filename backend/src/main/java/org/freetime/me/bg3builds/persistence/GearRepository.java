package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.dto.GearDto;

import java.util.List;


public interface GearRepository {
    List<GearDto> findGearByActByTypeKind(Integer act, String type, Integer pageSize, Integer pageNumber);

    List<GearDto> findGearByAct(Integer act, Integer pageSize, Integer pageNumber);

    Long countGearRowsByAct(Integer act);
}
