package org.freetime.me.bg3builds.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.GearDto;
import org.freetime.me.bg3builds.dto.GearTableDto;
import org.freetime.me.bg3builds.mapper.GearMapper;
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
    private final GearMapper gearMapper;


    @Override
    public GearTableDto getGearByAct(Integer act, Integer pageSize, Integer pageNumber) {
        List<GearDto> gearByAct = gearRepository.findGearByAct(act, pageSize, pageNumber);
        Long countGearRowsByAct = gearRepository.countGearRowsByAct(act);
        return gearMapper.dtoToTableDto(gearByAct, countGearRowsByAct);
    }

    public GearTableDto getGearByActByTypeKind(Integer act, String type, Integer pageSize, Integer pageNumber) {
        List<GearDto> gearByActByType = gearRepository.findGearByActByTypeKind(act, type, pageSize, pageNumber);
        Long countGearRowsByActByType = gearRepository.countGearRowsByActByTypeKind(act, type);
        return gearMapper.dtoToTableDto(gearByActByType, countGearRowsByActByType);
    }
}
