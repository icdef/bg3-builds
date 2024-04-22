package org.freetime.me.bg3builds.endpoint;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.*;
import org.freetime.me.bg3builds.service.BuildService;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{id}/lootItemToggle")
    @CrossOrigin
    public LootItemDto updateLootItemLootStateForBuild(@RequestBody @Valid LootItemToggleDto lootItemToggleDto, @PathVariable Long id) {
        return buildService.updateToggleForLootItemInBuild(lootItemToggleDto.getId(), id, lootItemToggleDto.getIsLooted());
    }

    @PutMapping("/{id}/rename")
    @CrossOrigin
    public BuildDto renameBuild(@RequestBody @Valid UpdateBuildDto updateBuildDto, @PathVariable Long id) {
        return buildService.updateBuild(updateBuildDto, id);
    }

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public BuildDto createBuild(@RequestBody @Valid CreateBuildDto createBuildDto) {
        return buildService.createBuild(createBuildDto);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBuild(@PathVariable Long id) {
        this.buildService.deleteBuild(id);
    }


}
