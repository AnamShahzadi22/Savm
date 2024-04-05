/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soft.savm.dao.item;


import com.soft.savm.entity.ItemEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anab
 */
@Repository

public class ItemDAOImpl implements ItemDAO {
    
    EntityManager em;
   
    public ItemDAOImpl(EntityManager em) {
        this.em = em;
    }

    
    @Override
    @Transactional
    public ItemEntity addItem(ItemEntity item){
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemName(item.getItemName());
        itemEntity.setIsDeleted(Boolean.FALSE);
        
        em.merge(itemEntity);
        return itemEntity;
    }
    
    @Transactional
    
    @Override
    public ItemEntity deleteItem(int ItemId) {
        ItemEntity item = em.find(ItemEntity.class, ItemId);
        if (item != null) {
            item.setItemDeleted(true);
            em.merge(item);
        }
        return item;
    }
    
    /**
     *
     * @param itemId
     * @return
     */
    @Override
    public ItemEntity getItemById(int itemId) {
        return em.find(ItemEntity.class, itemId);
    }


}
