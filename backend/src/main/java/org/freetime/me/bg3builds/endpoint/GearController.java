package org.freetime.me.bg3builds.endpoint;

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
    public List<GearDto> getGear(@RequestParam Integer act, @RequestParam Integer pageSize,
                                 @RequestParam Integer pageNumber) {
        return gearService.getWeaponsByAct(act, pageSize, pageNumber);
    }

}
