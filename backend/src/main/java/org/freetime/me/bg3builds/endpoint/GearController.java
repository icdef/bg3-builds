package org.freetime.me.bg3builds.endpoint;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.GearDto;
import org.freetime.me.bg3builds.service.GearService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gear")
@RequiredArgsConstructor
@Slf4j
public class GearController {

    private final GearService gearService;


    @GetMapping
    @CrossOrigin
    public List<GearDto> getGear(@Valid @RequestParam Integer act){
        return gearService.getWeaponsByAct(act);
    }

}
