package org.freetime.me.bg3builds.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.GearTableDto;
import org.freetime.me.bg3builds.service.GearService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gear")
@RequiredArgsConstructor
@Slf4j
public class GearController {

    private final GearService gearService;


    @GetMapping
    @CrossOrigin
    public GearTableDto getGear(@RequestParam Integer act, String typeKind, @RequestParam Integer pageSize,
                                @RequestParam Integer pageNumber) {
        if (typeKind.isBlank())
            return gearService.getGearByAct(act, pageSize, pageNumber);

        return gearService.getGearByActByTypeKind(act, typeKind, pageSize, pageNumber);
    }

}
