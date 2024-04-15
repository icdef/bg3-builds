package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.LootItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LootItemDetailRepository extends JpaRepository<LootItemDetail, Long> {

    Optional<LootItemDetail> findByName(String name);
}
