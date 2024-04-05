/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.soft.savm.dao.VendingMachine;

import com.soft.savm.entity.VendingMachineEntity;

/**
 *
 * @author anab
 */
public interface VendingMachineDAO {
     public VendingMachineEntity addmachine(VendingMachineEntity machine); 
     public VendingMachineEntity deletemachine(int vendingMachineId);
      public VendingMachineEntity getVendingMachineById(int vendingmachineId);
}
