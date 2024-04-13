package org.freetime.me.bg3builds.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum WeaponType implements GearEnumInterface {
    BATTLEAXES("Battleaxes"),
    CLUBS("Clubs"),
    DARTS("Darts"),
    DAGGERS("Daggers"),
    FLAILS("Flails"),
    GLAIVES("Glaives"),
    GREATAXES("Greataxes"),
    GREATCLUBS("Greatclubs"),
    GREATSWORDS("Greatswords"),
    HALBERDS("Halberds"),
    HAND_CROSSBOWS("Hand Crossbows"),
    HANDAXES("Handaxes"),
    HEAVY_CROSSBOWS("Heavy Crossbows"),
    JAVELINS("Javelins"),
    LIGHT_CROSSBOWS("Light Crossbows"),
    LIGHT_HAMMERS("Light Hammers"),
    LONGBOWS("Longbows"),
    LONGSWORDS("Longswords"),
    MACES("Maces"),
    MAULS("Mauls"),
    MORNINGSTARS("Morningstars"),
    PIKES("Pikes"),
    QUARTERSTAVES("Quarterstaves"),
    RAPIERS("Rapiers"),
    SCIMITARS("Scimitars"),
    SHORTBOWS("Shortbows"),
    SHORTSWORDS("Shortswords"),
    SICKLES("Sickles"),
    SLINGS("Slings"),
    SPEARS("Spears"),
    TRIDENTS("Tridents"),
    WAR_PICKS("War Picks"),
    WARHAMMERS("Warhammers");

    private final String typeName;
}
