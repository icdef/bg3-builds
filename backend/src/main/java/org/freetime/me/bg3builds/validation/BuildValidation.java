package org.freetime.me.bg3builds.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freetime.me.bg3builds.entity.Build;
import org.freetime.me.bg3builds.exception.BuildNotFoundException;
import org.freetime.me.bg3builds.exception.NameUniqueConstraintException;
import org.freetime.me.bg3builds.persistence.BuildRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class BuildValidation {

    private final BuildRepository buildRepository;


    public void isNameUnique(String buildName) {
        Optional<Build> possibleBuild = buildRepository.findByName(buildName);
        if (possibleBuild.isPresent())
            throw new NameUniqueConstraintException(String.format("Build with name %s already exists", buildName));
    }

    /**
     * Checks if build with id exists.
     *
     * @param id
     * @return Build with id from param
     * @throws BuildNotFoundException if build not found.
     */
    public Build doesBuildExist(Long id) {
        Optional<Build> possibleBuild = buildRepository.findById(id);
        if (possibleBuild.isEmpty()) {
            throw new BuildNotFoundException("Build not found");
        }
        return possibleBuild.get();
    }
}
