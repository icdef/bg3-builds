package org.freetime.me.bg3builds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LootTableDto {
    List<LootItemDto> data;
    Integer total;
}
