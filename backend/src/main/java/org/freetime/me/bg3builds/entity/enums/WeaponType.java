package org.freetime.me.bg3builds.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum WeaponType {
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
    HANDCROSSBOWS("Hand Crossbows"),
    HANDAXES("Handaxes"),
    HEAVYCROSSBOWS("Heavy Crossbows"),
    JAVELINS("Javelins"),
    LIGHTCROSSBOWS("Light Crossbows"),
    LIGHTHAMMERS("Light Hammers"),
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
    WARPICKS("Warpicks"),
    WARHAMMERS("Warhammers");

    private final String typeName;
}
