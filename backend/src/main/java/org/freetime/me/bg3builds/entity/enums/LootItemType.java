package org.freetime.me.bg3builds.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LootItemType {
    BATTLEAXES("Battleaxes", LootItemTypeKind.WEAPON.getTypeName()),
    CLUBS("Clubs", LootItemTypeKind.WEAPON.getTypeName()),
    DARTS("Darts", LootItemTypeKind.WEAPON.getTypeName()),
    DAGGERS("Daggers", LootItemTypeKind.WEAPON.getTypeName()),
    FLAILS("Flails", LootItemTypeKind.WEAPON.getTypeName()),
    GLAIVES("Glaives", LootItemTypeKind.WEAPON.getTypeName()),
    GREATAXES("Greataxes", LootItemTypeKind.WEAPON.getTypeName()),
    GREATCLUBS("Greatclubs", LootItemTypeKind.WEAPON.getTypeName()),
    GREATSWORDS("Greatswords", LootItemTypeKind.WEAPON.getTypeName()),
    HALBERDS("Halberds", LootItemTypeKind.WEAPON.getTypeName()),
    HAND_CROSSBOWS("Hand Crossbows", LootItemTypeKind.WEAPON.getTypeName()),
    HANDAXES("Handaxes", LootItemTypeKind.WEAPON.getTypeName()),
    HEAVY_CROSSBOWS("Heavy Crossbows", LootItemTypeKind.WEAPON.getTypeName()),
    JAVELINS("Javelins", LootItemTypeKind.WEAPON.getTypeName()),
    LIGHT_CROSSBOWS("Light Crossbows", LootItemTypeKind.WEAPON.getTypeName()),
    LIGHT_HAMMERS("Light Hammers", LootItemTypeKind.WEAPON.getTypeName()),
    LONGBOWS("Longbows", LootItemTypeKind.WEAPON.getTypeName()),
    LONGSWORDS("Longswords", LootItemTypeKind.WEAPON.getTypeName()),
    MACES("Maces", LootItemTypeKind.WEAPON.getTypeName()),
    MAULS("Mauls", LootItemTypeKind.WEAPON.getTypeName()),
    MORNINGSTARS("Morningstars", LootItemTypeKind.WEAPON.getTypeName()),
    PIKES("Pikes", LootItemTypeKind.WEAPON.getTypeName()),
    QUARTERSTAVES("Quarterstaves", LootItemTypeKind.WEAPON.getTypeName()),
    RAPIERS("Rapiers", LootItemTypeKind.WEAPON.getTypeName()),
    SCIMITARS("Scimitars", LootItemTypeKind.WEAPON.getTypeName()),
    SHORTBOWS("Shortbows", LootItemTypeKind.WEAPON.getTypeName()),
    SHORTSWORDS("Shortswords", LootItemTypeKind.WEAPON.getTypeName()),
    SICKLES("Sickles", LootItemTypeKind.WEAPON.getTypeName()),
    SLINGS("Slings", LootItemTypeKind.WEAPON.getTypeName()),
    SPEARS("Spears", LootItemTypeKind.WEAPON.getTypeName()),
    TRIDENTS("Tridents", LootItemTypeKind.WEAPON.getTypeName()),
    WAR_PICKS("War Picks", LootItemTypeKind.WEAPON.getTypeName()),
    WARHAMMERS("Warhammers", LootItemTypeKind.WEAPON.getTypeName()),
    AMULETS("Amulets", LootItemTypeKind.EQUIPMENT.getTypeName()),
    BOOTS("Boots", LootItemTypeKind.EQUIPMENT.getTypeName()),
    CAMP_CLOTHING("Camp Clothing", LootItemTypeKind.EQUIPMENT.getTypeName()),
    CAMP_SHOES("Camp Shoes", LootItemTypeKind.EQUIPMENT.getTypeName()),
    CLOAKS("Cloaks", LootItemTypeKind.EQUIPMENT.getTypeName()),
    CLOTHING("Clothing", LootItemTypeKind.EQUIPMENT.getTypeName()),
    GLOVES("Gloves", LootItemTypeKind.EQUIPMENT.getTypeName()),
    HEAVY_ARMOUR("Heavy Armour", LootItemTypeKind.EQUIPMENT.getTypeName()),
    HELMETS("Helmets", LootItemTypeKind.EQUIPMENT.getTypeName()),
    LIGHT_ARMOUR("Light Armour", LootItemTypeKind.EQUIPMENT.getTypeName()),
    MEDIUM_ARMOUR("Medium Armour", LootItemTypeKind.EQUIPMENT.getTypeName()),
    RINGS("Rings", LootItemTypeKind.EQUIPMENT.getTypeName()),
    SHIELDS("Shields", LootItemTypeKind.EQUIPMENT.getTypeName()),
    UNDERWEAR("Underwear", LootItemTypeKind.EQUIPMENT.getTypeName()),
    MUSICAL_INSTRUMENTS("Musical Instruments", LootItemTypeKind.EQUIPMENT.getTypeName());

    private final String typeName;
    private final String typeKind;
}
