package org.freetime.me.bg3builds.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildDto {

    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private List<LootItemToggleDto> items;
}
