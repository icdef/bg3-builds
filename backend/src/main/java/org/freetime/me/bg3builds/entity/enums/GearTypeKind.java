package org.freetime.me.bg3builds.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GearTypeKind {
    WEAPON("Weapon"),
    EQUIPMENT("Equipment");

    private final String typeName;
}
