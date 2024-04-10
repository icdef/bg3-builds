package org.freetime.me.bg3builds.persistence;


import org.freetime.me.bg3builds.entity.WeaponDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeaponDetailRepository extends JpaRepository<WeaponDetail, Long> {

    Optional<WeaponDetail> findByName(String name);


}
