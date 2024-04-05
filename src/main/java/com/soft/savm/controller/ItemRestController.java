/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package com.soft.savm.controller;

import com.soft.savm.dao.item.ItemDAO;
import com.soft.savm.dao.user.InvalidArguemntsException;
import com.soft.savm.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author anab
 */
@RestController
@RequestMapping("/item")
public class ItemRestController {

    @Autowired
    private  ItemDAO itemDao;

    public ItemDAO getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDAO itemDao) {
        this.itemDao = itemDao;
    }

    public ItemRestController(ItemDAO itemDao) {
        this.itemDao = itemDao;
    }

    @PostMapping("/addItem")
    public ItemEntity addItem(@RequestBody ItemEntity item) throws InvalidArguemntsException {
//        if(user.getUserName() ==  null || user.getUserName() == ""){
//            throw new RuntimeException("Name cannot be null");
//        }
        ItemEntity itemEntity = itemDao.addItem(item);
        return itemEntity;
    }

    @GetMapping("getItemById/{itemId}")
    public ItemEntity getUserById(@PathVariable int itemId) {
        return itemDao.getItemById(itemId);
    }

     @DeleteMapping("/deleteItem/{itemId}")
    public ItemEntity deleteItem(@PathVariable int itemId) {
        ItemEntity item = null;
       // return userDao.deleteUser(userId);
        return item;
        
    }
   

  
}
