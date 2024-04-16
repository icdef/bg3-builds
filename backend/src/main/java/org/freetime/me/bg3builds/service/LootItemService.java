package org.freetime.me.bg3builds.service;

import org.freetime.me.bg3builds.dto.LootTableDto;

public interface LootItemService {

    LootTableDto getLootItemByAct(Integer act, Integer pageSize, Integer pageNumber);

    LootTableDto getLootItemByActAndType(Integer act, String type, Integer pageSize, Integer pageNumber);
}
