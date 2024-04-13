package org.freetime.me.bg3builds.persistence;


import org.freetime.me.bg3builds.entity.WeaponDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeaponDetailRepository extends JpaRepository<WeaponDetail, Long> {

    Optional<WeaponDetail> findByName(String name);


}
