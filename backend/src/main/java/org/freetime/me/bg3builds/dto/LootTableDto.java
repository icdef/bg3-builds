package org.freetime.me.bg3builds.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LootTableDto {

    @NotNull
    List<LootItemDto> data;
    @NotNull
    Integer total;
}
