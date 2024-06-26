package org.freetime.me.bg3builds.persistence;

import org.freetime.me.bg3builds.entity.LootItem;
import org.freetime.me.bg3builds.entity.enums.LootItemType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LootItemRepository extends JpaRepository<LootItem, Long> {
    Optional<LootItem> findByItemNameAndAct(String itemName, Integer act);

    List<LootItem> findByAct(Integer act, Pageable pageable);

    Long countByAct(Integer act);

    Long countByActAndLootItemDetailType(Integer act, String type);

    Long countByActAndLootItemDetailSubtype(Integer act, LootItemType subtype);


    @Query("SELECT li FROM LootItem li JOIN li.lootItemDetail lid WHERE li.act = :act AND lid.type = :type")
    List<LootItem> findByActAndType(@Param("act") Integer act, @Param("type") String type, Pageable pageable);

    @Query("SELECT li FROM LootItem li JOIN li.lootItemDetail lid WHERE li.act = :act AND lid.subtype = :subtype")
    List<LootItem> findByActAndSubtype(@Param("act") Integer act, @Param("subtype") LootItemType subtype, Pageable pageable);

}
