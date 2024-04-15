package org.freetime.me.bg3builds.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.freetime.me.bg3builds.entity.enums.GearType;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class GearDto {

    @NotNull
    private String itemEffect;
    @NotNull
    private String itemSource;
    @NotNull
    private String itemLocation;
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private String subtype;
    @NotNull
    private Integer price;

    public GearDto(String itemEffect, String itemSource, String itemLocation, String name, String type,
                   GearType subtype, Integer price) {
        this.itemEffect = itemEffect;
        this.itemSource = itemSource;
        this.itemLocation = itemLocation;
        this.name = name;
        this.type = type;
        this.subtype = subtype.getTypeName();
        this.price = price;
    }
}
