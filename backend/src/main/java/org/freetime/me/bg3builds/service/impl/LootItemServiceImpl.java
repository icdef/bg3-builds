package org.freetime.me.bg3builds.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.LootTableDto;
import org.freetime.me.bg3builds.mapper.LootItemMapper;
import org.freetime.me.bg3builds.persistence.LootItemRepository;
import org.freetime.me.bg3builds.service.LootItemService;
import org.freetime.me.bg3builds.util.EnumUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LootItemServiceImpl implements LootItemService {

    private final LootItemRepository lootItemRepository;
    private final LootItemMapper lootItemMapper;

    @Override
    public LootTableDto getLootItemByAct(Integer act, Integer pageSize, Integer pageNumber) {
        Long count = lootItemRepository.countByAct(act);
        return lootItemMapper.dtoToTableDto(lootItemRepository.findByAct(act, PageRequest.of(pageNumber, pageSize)), count);
    }

    @Override
    public LootTableDto getLootItemByActAndType(Integer act, String type, Integer pageSize, Integer pageNumber) {
        Long count = lootItemRepository.countByActAndLootItemDetailType(act, type);
        return lootItemMapper.dtoToTableDto(lootItemRepository.findByActAndType(act, type, PageRequest.of(pageNumber, pageSize)), count);
    }

    @Override
    public LootTableDto getLootItemByActAndSubtype(Integer act, String subtype, Integer pageSize, Integer pageNumber) {
        Long count = lootItemRepository.countByActAndLootItemDetailSubtype(act, EnumUtil.stringToEnum(subtype));
        return lootItemMapper.dtoToTableDto(lootItemRepository.findByActAndSubtype(act, EnumUtil.stringToEnum(subtype),
                PageRequest.of(pageNumber, pageSize)), count);
    }
}
