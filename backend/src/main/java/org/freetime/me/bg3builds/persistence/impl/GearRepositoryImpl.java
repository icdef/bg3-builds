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
    public List<GearDto> findWeaponsByAct(Integer act, Integer pageSize, Integer pageNumber) {
        return entityManager.createQuery("""
                        SELECT NEW org.freetime.me.bg3builds.dto.GearDto(li.itemEffect, li.itemSource,li.itemLocation,
                        wd.name,wd.type,wd.subtype,wd.price)
                                FROM LootItem li JOIN WeaponDetail wd ON li.itemName = wd.name
                                WHERE li.act = :act
                        """
                        , GearDto.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageNumber * pageSize)
                .setParameter("act", act)
                .getResultList();

    }
}
