package org.freetime.me.bg3builds.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.dto.BuildDto;
import org.freetime.me.bg3builds.service.BuildService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/builds")
@RequiredArgsConstructor
@Slf4j
public class BuildController {

    private final BuildService buildService;

    @GetMapping
    @CrossOrigin
    public List<BuildDto> getBuilds() {
        return buildService.getBuilds();
    }
}
