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
    public List<GearDto> findWeaponsByAct(Integer act){
        return entityManager.createQuery("""
               SELECT NEW org.freetime.me.bg3builds.dto.GearDto(li.itemEffect, li.itemSource,li.itemLocation,
               wd.name,wd.type,wd.subtype,wd.price)
               from LootItem li join WeaponDetail wd on li.itemName = wd.name
               where li.act = :act
               """
        ,GearDto.class).setParameter("act",act).getResultList();

    }
}
