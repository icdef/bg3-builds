package org.freetime.me.bg3builds.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LootItemToggleDto extends LootItemDto {

    private Boolean isLooted;
}
