package org.freetime.me.bg3builds.dto.cargoquery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CargoQueryResponseDto implements Serializable {

    @JsonProperty(value = "cargoquery", required = true)
    private List<CargoQueryObjectDto> cargoquery;

}
