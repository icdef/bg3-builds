package org.freetime.me.bg3builds.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GearType {
    BATTLEAXES("Battleaxes", GearTypeKind.WEAPON.getTypeName()),
    CLUBS("Clubs", GearTypeKind.WEAPON.getTypeName()),
    DARTS("Darts", GearTypeKind.WEAPON.getTypeName()),
    DAGGERS("Daggers", GearTypeKind.WEAPON.getTypeName()),
    FLAILS("Flails", GearTypeKind.WEAPON.getTypeName()),
    GLAIVES("Glaives", GearTypeKind.WEAPON.getTypeName()),
    GREATAXES("Greataxes", GearTypeKind.WEAPON.getTypeName()),
    GREATCLUBS("Greatclubs", GearTypeKind.WEAPON.getTypeName()),
    GREATSWORDS("Greatswords", GearTypeKind.WEAPON.getTypeName()),
    HALBERDS("Halberds", GearTypeKind.WEAPON.getTypeName()),
    HAND_CROSSBOWS("Hand Crossbows", GearTypeKind.WEAPON.getTypeName()),
    HANDAXES("Handaxes", GearTypeKind.WEAPON.getTypeName()),
    HEAVY_CROSSBOWS("Heavy Crossbows", GearTypeKind.WEAPON.getTypeName()),
    JAVELINS("Javelins", GearTypeKind.WEAPON.getTypeName()),
    LIGHT_CROSSBOWS("Light Crossbows", GearTypeKind.WEAPON.getTypeName()),
    LIGHT_HAMMERS("Light Hammers", GearTypeKind.WEAPON.getTypeName()),
    LONGBOWS("Longbows", GearTypeKind.WEAPON.getTypeName()),
    LONGSWORDS("Longswords", GearTypeKind.WEAPON.getTypeName()),
    MACES("Maces", GearTypeKind.WEAPON.getTypeName()),
    MAULS("Mauls", GearTypeKind.WEAPON.getTypeName()),
    MORNINGSTARS("Morningstars", GearTypeKind.WEAPON.getTypeName()),
    PIKES("Pikes", GearTypeKind.WEAPON.getTypeName()),
    QUARTERSTAVES("Quarterstaves", GearTypeKind.WEAPON.getTypeName()),
    RAPIERS("Rapiers", GearTypeKind.WEAPON.getTypeName()),
    SCIMITARS("Scimitars", GearTypeKind.WEAPON.getTypeName()),
    SHORTBOWS("Shortbows", GearTypeKind.WEAPON.getTypeName()),
    SHORTSWORDS("Shortswords", GearTypeKind.WEAPON.getTypeName()),
    SICKLES("Sickles", GearTypeKind.WEAPON.getTypeName()),
    SLINGS("Slings", GearTypeKind.WEAPON.getTypeName()),
    SPEARS("Spears", GearTypeKind.WEAPON.getTypeName()),
    TRIDENTS("Tridents", GearTypeKind.WEAPON.getTypeName()),
    WAR_PICKS("War Picks", GearTypeKind.WEAPON.getTypeName()),
    WARHAMMERS("Warhammers", GearTypeKind.WEAPON.getTypeName()),
    AMULETS("Amulets", GearTypeKind.EQUIPMENT.getTypeName()),
    BOOTS("Boots", GearTypeKind.EQUIPMENT.getTypeName()),
    CAMP_CLOTHING("Camp Clothing", GearTypeKind.EQUIPMENT.getTypeName()),
    CAMP_SHOES("Camp Shoes", GearTypeKind.EQUIPMENT.getTypeName()),
    CLOAKS("Cloaks", GearTypeKind.EQUIPMENT.getTypeName()),
    CLOTHING("Clothing", GearTypeKind.EQUIPMENT.getTypeName()),
    GLOVES("Gloves", GearTypeKind.EQUIPMENT.getTypeName()),
    HEAVY_ARMOUR("Heavy Armour", GearTypeKind.EQUIPMENT.getTypeName()),
    HELMETS("Helmets", GearTypeKind.EQUIPMENT.getTypeName()),
    LIGHT_ARMOUR("Light Armour", GearTypeKind.EQUIPMENT.getTypeName()),
    MEDIUM_ARMOUR("Medium Armour", GearTypeKind.EQUIPMENT.getTypeName()),
    RINGS("Rings", GearTypeKind.EQUIPMENT.getTypeName()),
    SHIELDS("Shields", GearTypeKind.EQUIPMENT.getTypeName()),
    UNDERWEAR("Underwear", GearTypeKind.EQUIPMENT.getTypeName());

    private final String typeName;
    private final String typeKind;
}
