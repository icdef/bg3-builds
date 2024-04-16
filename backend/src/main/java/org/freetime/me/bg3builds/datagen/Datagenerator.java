package org.freetime.me.bg3builds.datagen;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Datagenerator {

    private final LootItemGenerator lootItemGenerator;
    private final WikiDataGenerator wikiDataGenerator;

    @SneakyThrows
    @PostConstruct
    public void addData() {
        wikiDataGenerator.addWeaponData();
        wikiDataGenerator.addEquipmentData();
        lootItemGenerator.createLootItems();
    }
}
