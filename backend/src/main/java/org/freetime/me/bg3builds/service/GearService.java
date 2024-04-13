package org.freetime.me.bg3builds.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.GearDto;
import org.freetime.me.bg3builds.persistence.GearRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class GearService {

    private final GearRepository gearRepository;

    public List<GearDto> getWeaponsByAct(Integer act) {
        return gearRepository.findWeaponsByAct(act);
    }
}
