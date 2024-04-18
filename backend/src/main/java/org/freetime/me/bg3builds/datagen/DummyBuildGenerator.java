package org.freetime.me.bg3builds.datagen;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.entity.Build;
import org.freetime.me.bg3builds.entity.BuildItemKey;
import org.freetime.me.bg3builds.entity.BuildLootItem;
import org.freetime.me.bg3builds.entity.LootItem;
import org.freetime.me.bg3builds.mapper.BuildMapper;
import org.freetime.me.bg3builds.persistence.BuildLootItemRepository;
import org.freetime.me.bg3builds.persistence.BuildRepository;
import org.freetime.me.bg3builds.persistence.LootItemRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class DummyBuildGenerator {

    private final BuildRepository buildRepository;
    private final BuildMapper buildMapper;
    private final LootItemRepository lootItemRepository;
    private final BuildLootItemRepository buildLootItemRepository;

    public void generateDummyBuild() {
        Build build = new Build();
        build.setName("Build 1");
        List<LootItem> lootItems = lootItemRepository.findAll();
        Collections.shuffle(lootItems);
        List<BuildLootItem> buildLootItems = new ArrayList<>();
        for (int i = 0; i < Math.min(10, lootItems.size()); i++) {
            buildLootItems.add(createBuildLootItem(build, lootItems, i));
        }

        build.setItems(buildLootItems);
        Optional<Build> optionalBuild = buildRepository.findByName(build.getName());
        if (optionalBuild.isPresent())
            buildRepository.save(buildMapper.updateBuild(build, optionalBuild.get()));
        else
            buildRepository.save(build);
        buildLootItemRepository.saveAll(buildLootItems);

    }

    private static BuildLootItem createBuildLootItem(Build build, List<LootItem> lootItems, int index) {
        BuildLootItem buildLootItem = new BuildLootItem();
        buildLootItem.setIsLooted(Math.random() <= 0.5);
        buildLootItem.setBuildItemKey(new BuildItemKey(build.getId(), lootItems.get(index).getId()));
        buildLootItem.setBuild(build);
        buildLootItem.setLootItem(lootItems.get(index));
        return buildLootItem;
    }
}
