package org.freetime.me.bg3builds.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProbeController {

    @GetMapping("/health")
    @CrossOrigin
    public void healthCheck() {
        log.info("Health check sucessful");
    }
}
