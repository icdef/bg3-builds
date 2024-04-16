package org.freetime.me.bg3builds.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.LootTableDto;
import org.freetime.me.bg3builds.service.LootItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gear")
@RequiredArgsConstructor
@Slf4j
public class LootItemController {

    private final LootItemService lootItemService;

    @GetMapping
    @CrossOrigin
    public LootTableDto getLootItems(@RequestParam Integer act, String typeKind, @RequestParam Integer pageSize,
                                     @RequestParam Integer pageNumber) {
        if (typeKind == null || typeKind.isBlank())
            return lootItemService.getLootItemByAct(act, pageSize, pageNumber);

        return lootItemService.getLootItemByActAndType(act, typeKind, pageSize, pageNumber);
    }

}
