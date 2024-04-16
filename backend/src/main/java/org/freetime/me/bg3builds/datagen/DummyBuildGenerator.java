package org.freetime.me.bg3builds.datagen;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.entity.Build;
import org.freetime.me.bg3builds.persistence.BuildRepository;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DummyBuildGenerator {

    private final BuildRepository buildRepository;

    public void generateDummyBuild() {
        Build build = new Build();
        Build build2 = new Build();
        build.setName("Build 1");
        build2.setName("Build 2");
        buildRepository.findByName(build.getName()).ifPresent(buildRepository::save);
        buildRepository.findByName(build2.getName()).ifPresent(buildRepository::save);
    }
}
