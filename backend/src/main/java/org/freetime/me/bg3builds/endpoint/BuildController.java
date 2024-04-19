package org.freetime.me.bg3builds.endpoint;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.BuildDto;
import org.freetime.me.bg3builds.dto.LootItemDto;
import org.freetime.me.bg3builds.dto.LootItemToggleDto;
import org.freetime.me.bg3builds.service.BuildService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/builds")
@RequiredArgsConstructor
@Slf4j
public class BuildController {

    private final BuildService buildService;

    @GetMapping
    @CrossOrigin
    public List<BuildDto> getBuilds() {
        return buildService.getBuilds();
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public LootItemDto updateLootItemLootStateForBuild(@RequestBody @Valid LootItemToggleDto lootItemToggleDto, @PathVariable Long id) {
        return buildService.updateToggleForLootItemInBuild(lootItemToggleDto.getId(), id, lootItemToggleDto.getIsLooted());
    }
}
