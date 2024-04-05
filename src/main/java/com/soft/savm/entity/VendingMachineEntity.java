/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soft.savm.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author PMYLS
 */
@Entity
@Table(name = "vending_machine")
@NamedQueries({
    @NamedQuery(name = "VendingMachineEntity.findAll", query = "SELECT v FROM VendingMachineEntity v"),
    @NamedQuery(name = "VendingMachineEntity.findByVendingMachineId", query = "SELECT v FROM VendingMachineEntity v WHERE v.vendingMachineId = :vendingMachineId"),
    @NamedQuery(name = "VendingMachineEntity.findByVendingMachineName", query = "SELECT v FROM VendingMachineEntity v WHERE v.vendingMachineName = :vendingMachineName"),
    @NamedQuery(name = "VendingMachineEntity.findByIsActive", query = "SELECT v FROM VendingMachineEntity v WHERE v.isActive = :isActive")})
public class VendingMachineEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vending_machine_id")
    private Integer vendingMachineId;
    @Basic(optional = false)
    @Column(name = "vending_machine_name")
    private String vendingMachineName;
    @Column(name = "is_active")
    private Short isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendingMachineId")
    private List<VendingMachineItemEntity> vendingMachineItemEntityList;

    public VendingMachineEntity() {
    }

    public VendingMachineEntity(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    public VendingMachineEntity(Integer vendingMachineId, String vendingMachineName) {
        this.vendingMachineId = vendingMachineId;
        this.vendingMachineName = vendingMachineName;
    }

    public Integer getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(Integer vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    public String getVendingMachineName() {
        return vendingMachineName;
    }

    public void setVendingMachineName(String vendingMachineName) {
        this.vendingMachineName = vendingMachineName;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public List<VendingMachineItemEntity> getVendingMachineItemEntityList() {
        return vendingMachineItemEntityList;
    }

    public void setVendingMachineItemEntityList(List<VendingMachineItemEntity> vendingMachineItemEntityList) {
        this.vendingMachineItemEntityList = vendingMachineItemEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendingMachineId != null ? vendingMachineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendingMachineEntity)) {
            return false;
        }
        VendingMachineEntity other = (VendingMachineEntity) object;
        if ((this.vendingMachineId == null && other.vendingMachineId != null) || (this.vendingMachineId != null && !this.vendingMachineId.equals(other.vendingMachineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soft.savm.entity.VendingMachineEntity[ vendingMachineId=" + vendingMachineId + " ]";
    }
    
}
