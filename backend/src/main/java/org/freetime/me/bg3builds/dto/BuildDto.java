package org.freetime.me.bg3builds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildDto {

    private Long id;
    private String name;
    private List<LootItemToggleDto> items;
}
