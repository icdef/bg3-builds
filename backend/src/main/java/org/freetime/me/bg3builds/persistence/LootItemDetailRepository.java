package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.LootItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LootItemDetailRepository extends JpaRepository<LootItemDetail, Long> {

    Optional<LootItemDetail> findByName(String name);

    @Query("select l from LootItemDetail l where :name like (l.name || '%')")
    List<LootItemDetail> findByNameLike(@Param("name") String name);
}
