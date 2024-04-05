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
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "ItemEntity.findAll", query = "SELECT i FROM ItemEntity i"),
    @NamedQuery(name = "ItemEntity.findByItemId", query = "SELECT i FROM ItemEntity i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "ItemEntity.findByItemName", query = "SELECT i FROM ItemEntity i WHERE i.itemName = :itemName")})
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "item_name")
    private String itemName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private List<VendingMachineItemEntity> vendingMachineItemEntityList;

    public ItemEntity() {
    }

    public ItemEntity(Integer itemId) {
        this.itemId = itemId;
    }

    public ItemEntity(Integer itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntity)) {
            return false;
        }
        ItemEntity other = (ItemEntity) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soft.savm.entity.ItemEntity[ itemId=" + itemId + " ]";
    }

    public void setIsDeleted(Boolean FALSE) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setItemDeleted(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
