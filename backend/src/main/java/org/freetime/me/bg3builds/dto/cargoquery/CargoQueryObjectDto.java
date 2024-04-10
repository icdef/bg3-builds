package org.freetime.me.bg3builds.dto.cargoquery;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoQueryObjectDto implements Serializable {
    @JsonProperty("title")
    private CargoQueryObjectDetailDto title;
}
