package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.dto.GearDto;

import java.util.List;


public interface GearRepository {
    List<GearDto> findWeaponsByAct(Integer act, Integer pageSize, Integer pageNumber);
}
