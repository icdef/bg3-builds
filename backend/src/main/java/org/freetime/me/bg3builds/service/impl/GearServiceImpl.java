package org.freetime.me.bg3builds.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.GearDto;
import org.freetime.me.bg3builds.persistence.GearRepository;
import org.freetime.me.bg3builds.service.GearService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class GearServiceImpl implements GearService {

    private final GearRepository gearRepository;

    @Override
    public List<GearDto> getWeaponsByAct(Integer act, Integer pageSize, Integer pageNumber) {
        return gearRepository.findWeaponsByAct(act, pageSize, pageNumber);
    }
}
