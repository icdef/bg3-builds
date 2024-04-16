package org.freetime.me.bg3builds.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class LootItemDto {

    private Long id;
    @NotNull
    private String itemName;
    @NotNull
    private String itemEffect;
    @NotNull
    private String itemSource;
    @NotNull
    private String itemLocation;
    @NotNull
    private LootItemDetailDto lootItemDetail;

}
