package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.EquipmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentDetailRepository extends JpaRepository<EquipmentDetail, Long> {

    Optional<EquipmentDetail> findByName(String name);
}
