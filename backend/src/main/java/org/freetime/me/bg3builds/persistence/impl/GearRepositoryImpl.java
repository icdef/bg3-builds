package org.freetime.me.bg3builds.persistence.impl;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.freetime.me.bg3builds.dto.GearDto;
import org.freetime.me.bg3builds.persistence.GearRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GearRepositoryImpl implements GearRepository {

    private final EntityManager entityManager;

    @Override
    public List<GearDto> findGearByActByTypeKind(Integer act, String type, Integer pageSize, Integer pageNumber) {
        return entityManager.createQuery("""
                                SELECT NEW org.freetime.me.bg3builds.dto.GearDto(li.itemEffect, li.itemSource,li.itemLocation,
                                 lid.name,lid.type,lid.subtype,lid.price)
                                 FROM LootItem li JOIN LootItemDetail lid ON li.itemName LIKE (lid.name || '%')
                                 WHERE li.act = :act AND lid.type = :type
                                """
                        , GearDto.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageNumber * pageSize)
                .setParameter("act", act)
                .setParameter("type", type)
                .getResultList();

    }


    @Override
    public List<GearDto> findGearByAct(Integer act, Integer pageSize, Integer pageNumber) {
        return entityManager.createQuery("""
                                        SELECT NEW org.freetime.me.bg3builds.dto.GearDto(li.itemEffect, li.itemSource,li.itemLocation,
                                        lid.name,lid.type,lid.subtype,lid.price)
                                        FROM LootItem li JOIN LootItemDetail lid ON li.itemName LIKE (lid.name || '%')
                                WHERE li.act = :act
                        """
                        , GearDto.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageNumber * pageSize)
                .setParameter("act", act)
                .getResultList();
    }

    @Override
    public Long countGearRowsByAct(Integer act) {
        return entityManager.createQuery("""
                                SELECT COUNT(*)
                                        FROM LootItem li JOIN LootItemDetail lid ON li.itemName LIKE (lid.name || '%')
                                        WHERE li.act = :act
                                """
                        , Long.class)
                .setParameter("act", act)
                .getSingleResult();
    }

    @Override
    public Long countGearRowsByActByTypeKind(Integer act, String type) {
        return entityManager.createQuery("""
                                SELECT COUNT(*)
                                        FROM LootItem li JOIN LootItemDetail lid ON li.itemName LIKE (lid.name || '%')
                                        WHERE li.act = :act AND lid.type = :type
                                """
                        , Long.class)
                .setParameter("act", act)
                .setParameter("type", type)
                .getSingleResult();
    }
}
