package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.Build;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildRepository extends JpaRepository<Build, Long> {
    Optional<Build> findByName(String name);

}
