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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "vending_machine_item")
@NamedQueries({
    @NamedQuery(name = "VendingMachineItemEntity.findAll", query = "SELECT v FROM VendingMachineItemEntity v"),
    @NamedQuery(name = "VendingMachineItemEntity.findByVendingMachineItemId", query = "SELECT v FROM VendingMachineItemEntity v WHERE v.vendingMachineItemId = :vendingMachineItemId"),
    @NamedQuery(name = "VendingMachineItemEntity.findByItemPrice", query = "SELECT v FROM VendingMachineItemEntity v WHERE v.itemPrice = :itemPrice"),
    @NamedQuery(name = "VendingMachineItemEntity.findByItemQuantity", query = "SELECT v FROM VendingMachineItemEntity v WHERE v.itemQuantity = :itemQuantity"),
    @NamedQuery(name = "VendingMachineItemEntity.findByItemMinimumQuantity", query = "SELECT v FROM VendingMachineItemEntity v WHERE v.itemMinimumQuantity = :itemMinimumQuantity")})
public class VendingMachineItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vending_machine_item_id")
    private Integer vendingMachineItemId;
    @Basic(optional = false)
    @Column(name = "item_price")
    private int itemPrice;
    @Basic(optional = false)
    @Column(name = "item_quantity")
    private int itemQuantity;
    @Basic(optional = false)
    @Column(name = "item_minimum_quantity")
    private int itemMinimumQuantity;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne(optional = false)
    private ItemEntity itemId;
    @JoinColumn(name = "vending_machine_id", referencedColumnName = "vending_machine_id")
    @ManyToOne(optional = false)
    private VendingMachineEntity vendingMachineId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendingMachineItemId")
    private List<OrderDetailsEntity> orderDetailsEntityList;

    public VendingMachineItemEntity() {
    }

    public VendingMachineItemEntity(Integer vendingMachineItemId) {
        this.vendingMachineItemId = vendingMachineItemId;
    }

    public VendingMachineItemEntity(Integer vendingMachineItemId, int itemPrice, int itemQuantity, int itemMinimumQuantity) {
        this.vendingMachineItemId = vendingMachineItemId;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemMinimumQuantity = itemMinimumQuantity;
    }

    public Integer getVendingMachineItemId() {
        return vendingMachineItemId;
    }

    public void setVendingMachineItemId(Integer vendingMachineItemId) {
        this.vendingMachineItemId = vendingMachineItemId;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getItemMinimumQuantity() {
        return itemMinimumQuantity;
    }

    public void setItemMinimumQuantity(int itemMinimumQuantity) {
        this.itemMinimumQuantity = itemMinimumQuantity;
    }

    public ItemEntity getItemId() {
        return itemId;
    }

    public void setItemId(ItemEntity itemId) {
        this.itemId = itemId;
    }

    public VendingMachineEntity getVendingMachineId() {
        return vendingMachineId;
    }

    public void setVendingMachineId(VendingMachineEntity vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    public List<OrderDetailsEntity> getOrderDetailsEntityList() {
        return orderDetailsEntityList;
    }

    public void setOrderDetailsEntityList(List<OrderDetailsEntity> orderDetailsEntityList) {
        this.orderDetailsEntityList = orderDetailsEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendingMachineItemId != null ? vendingMachineItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendingMachineItemEntity)) {
            return false;
        }
        VendingMachineItemEntity other = (VendingMachineItemEntity) object;
        if ((this.vendingMachineItemId == null && other.vendingMachineItemId != null) || (this.vendingMachineItemId != null && !this.vendingMachineItemId.equals(other.vendingMachineItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soft.savm.entity.VendingMachineItemEntity[ vendingMachineItemId=" + vendingMachineItemId + " ]";
    }
    
}
