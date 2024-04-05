/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.soft.savm.dao.item;

import com.soft.savm.entity.ItemEntity;

/**
 *
 * @author PMYLS
 */

public interface ItemDAO {
  
 public ItemEntity addItem(ItemEntity item);
    public ItemEntity getItemById(int itemId) ;
     public ItemEntity deleteItem(int ItemId);
    
}  

