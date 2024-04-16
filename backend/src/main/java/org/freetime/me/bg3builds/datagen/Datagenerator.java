package org.freetime.me.bg3builds.datagen;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
@Profile("fetch-data")
public class Datagenerator {
    private final DummyBuildGenerator dummyBuildGenerator;
    private final LootItemGenerator lootItemGenerator;
    private final WikiDataGenerator wikiDataGenerator;

    @SneakyThrows
    @PostConstruct
    public void addData() {
        wikiDataGenerator.addWeaponData();
        wikiDataGenerator.addEquipmentData();
        lootItemGenerator.createLootItems();
        dummyBuildGenerator.generateDummyBuild();
    }
}
