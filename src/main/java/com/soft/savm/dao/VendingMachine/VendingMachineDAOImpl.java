package com.soft.savm.dao.VendingMachine;



import com.soft.savm.entity.VendingMachineEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author anab
 */
@Repository
public class VendingMachineDAOImpl implements VendingMachineDAO {
    EntityManager em;
    
    public VendingMachineDAOImpl(EntityManager em){
        
        this.em=em;
        
        
    }
    
     
    @Transactional
    public VendingMachineEntity addmachine(VendingMachineEntity machine){
        VendingMachineEntity vendingmachineEntity = new VendingMachineEntity();
        vendingmachineEntity.setVendingMachineId(machine.getVendingMachineId());
        vendingmachineEntity.setVendingMachineName(machine.getVendingMachineName());
        vendingmachineEntity.setIsActive((short)1); // Set default value to true
        
        em.merge(vendingmachineEntity);
        return vendingmachineEntity;
    }
    
    
    @Transactional
    
    
    @Override
    public VendingMachineEntity deletemachine(int vendingMachineId) {
        VendingMachineEntity machine = em.find(VendingMachineEntity.class, vendingMachineId);
        if (machine != null) {
            machine.setIsActive((short)1);
            em.merge(machine);
        }
        return machine;
    }
    
    
    @Override
    public VendingMachineEntity getVendingMachineById(int vendingmachineId) {
        return em.find(VendingMachineEntity.class, vendingmachineId);
    }
    
    
    
    
    
}
