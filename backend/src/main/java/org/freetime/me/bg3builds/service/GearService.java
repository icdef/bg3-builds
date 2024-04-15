package org.freetime.me.bg3builds.service;

import org.freetime.me.bg3builds.dto.GearTableDto;

public interface GearService {

    public GearTableDto getGearByAct(Integer act, Integer pageSize, Integer pageNumber);

    public GearTableDto getGearByActByTypeKind(Integer act, String type, Integer pageSize, Integer pageNumber);
}
