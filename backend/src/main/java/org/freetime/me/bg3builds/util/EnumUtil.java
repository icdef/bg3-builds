package org.freetime.me.bg3builds.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.freetime.me.bg3builds.entity.enums.LootItemType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumUtil {

    public static LootItemType stringToEnum(String enumString) {
        return Enum.valueOf(LootItemType.class, enumString.trim().toUpperCase().replace(' ', '_'));
    }
}
