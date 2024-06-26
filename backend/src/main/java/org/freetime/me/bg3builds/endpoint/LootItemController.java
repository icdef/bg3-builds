package org.freetime.me.bg3builds.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.LootTableDto;
import org.freetime.me.bg3builds.service.LootItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loot")
@RequiredArgsConstructor
@Slf4j
public class LootItemController {

    private final LootItemService lootItemService;

    @GetMapping
    @CrossOrigin
    public LootTableDto getLootItems(@RequestParam Integer act, @RequestParam String queryFilter,
                                     @RequestParam String typeKind, @RequestParam Integer pageSize,
                                     @RequestParam Integer pageNumber) {
        if (typeKind.equals("type") && !queryFilter.isBlank())
            return lootItemService.getLootItemByActAndType(act, queryFilter, pageSize, pageNumber);
        else if (typeKind.equals("subtype") && !queryFilter.isBlank())
            return lootItemService.getLootItemByActAndSubtype(act, queryFilter, pageSize, pageNumber);
        else
            return lootItemService.getLootItemByAct(act, pageSize, pageNumber);
    }

}
