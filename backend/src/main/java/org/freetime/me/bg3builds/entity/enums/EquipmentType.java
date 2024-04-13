package org.freetime.me.bg3builds.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EquipmentType implements TestInterface {
    AMULETS("Amulets"),
    BOOTS("Boots"),
    CAMP_CLOTHING("Camp Clothing"),
    CAMP_SHOES("Camp Shoes"),
    CLOAKS("Cloaks"),
    CLOTHING("Clothing"),
    GLOVES("Gloves"),
    HEAVY_ARMOUR("Heavy Armour"),
    HELMETS("Helmets"),
    LIGHT_ARMOUR("Light Armour"),
    MEDIUM_ARMOUR("Medium Armour"),
    RINGS("Rings"),
    SHIELDS("Shields"),
    UNDERWEAR("Underwear");

    private final String typeName;
}
