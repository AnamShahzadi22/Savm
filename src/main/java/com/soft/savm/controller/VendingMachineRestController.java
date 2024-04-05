/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package com.soft.savm.controller;

import com.soft.savm.dao.VendingMachine.VendingMachineDAO;
import com.soft.savm.dao.user.InvalidArguemntsException;
import com.soft.savm.entity.VendingMachineEntity;
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
@RequestMapping("/machine")
public class VendingMachineRestController {

    private final VendingMachineDAO vendingmachineDao;

    public VendingMachineRestController(VendingMachineDAO vendingmachineDao) {
        this.vendingmachineDao = vendingmachineDao;
    }

    @PostMapping("/addMachine")
    public VendingMachineEntity addmachine(@RequestBody VendingMachineEntity machine) throws InvalidArguemntsException {
//        if(user.getUserName() ==  null || user.getUserName() == ""){
//            throw new RuntimeException("Name cannot be null");
//        }
        VendingMachineEntity vendingmachineEntity = vendingmachineDao.addmachine(machine);
        return vendingmachineEntity;
    }

    @GetMapping("getVendingMachineById/{vendingmachineId}")
    public VendingMachineEntity getMachineById(@PathVariable int vendingmachineId) {
       return vendingmachineDao.getVendingMachineById(vendingmachineId);
    }

     @DeleteMapping("/deletemachine/{vendingMachineId}")
    public VendingMachineEntity deletemachine(@PathVariable int vendingMachineId) {
    VendingMachineEntity machine = null;
    return machine;
        
    }
   

  
}
