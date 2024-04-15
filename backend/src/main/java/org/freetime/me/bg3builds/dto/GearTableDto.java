package org.freetime.me.bg3builds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GearTableDto {
    List<GearDto> data;
    Integer total;
}
