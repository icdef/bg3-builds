package org.freetime.me.bg3builds.service;

import org.freetime.me.bg3builds.dto.GearDto;

import java.util.List;

public interface GearService {

    public List<GearDto> getWeaponsByAct(Integer act, Integer pageSize, Integer pageNumber);
}
