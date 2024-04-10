package org.freetime.me.bg3builds.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EquipmentType {
    AMULETS("Amulets"),
    BOOTS("Boots"),
    CAMPCLOTHING("Camp Clothing"),
    CAMPSHOES("Camp Shoes"),
    CLOAKS("Cloaks"),
    CLOTHING("Clothing"),
    GLOVES("Gloves"),
    HEAVYARMOUR("Heavy Armour"),
    HELMETS("Helmets"),
    LIGHTARMOUR("Light Armour"),
    MEDIUMARMOUR("Medium Armour"),
    RINGS("Rings"),
    SHIELDS("Shields"),
    UNDERWEAR("Underwear");

    private final String typeName;
}
