package org.freetime.me.bg3builds.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.BuildDto;
import org.freetime.me.bg3builds.mapper.BuildMapper;
import org.freetime.me.bg3builds.persistence.BuildRepository;
import org.freetime.me.bg3builds.service.BuildService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BuildServiceImpl implements BuildService {

    private final BuildRepository buildRepository;
    private final BuildMapper buildMapper;

    @Override
    public List<BuildDto> getBuilds() {
        return buildMapper.entityToDto(buildRepository.findAll());
    }
}
