package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.EquipmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipmentDetailRepository extends JpaRepository<EquipmentDetail, Long> {

    Optional<EquipmentDetail> findByName(String name);
}
