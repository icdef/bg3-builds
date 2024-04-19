package org.freetime.me.bg3builds.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LootItemToggleDto extends LootItemDto {

    @NotNull
    private Boolean isLooted;
}
