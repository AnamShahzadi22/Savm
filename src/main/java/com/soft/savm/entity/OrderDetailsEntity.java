/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soft.savm.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;


/**
 *
 * @author PMYLS
 */
@Entity
@Table(name = "order_details")
@NamedQueries({
    @NamedQuery(name = "OrderDetailsEntity.findAll", query = "SELECT o FROM OrderDetailsEntity o"),
    @NamedQuery(name = "OrderDetailsEntity.findByOrderDetailsId", query = "SELECT o FROM OrderDetailsEntity o WHERE o.orderDetailsId = :orderDetailsId"),
    @NamedQuery(name = "OrderDetailsEntity.findByOrderDetailsItemPrice", query = "SELECT o FROM OrderDetailsEntity o WHERE o.orderDetailsItemPrice = :orderDetailsItemPrice"),
    @NamedQuery(name = "OrderDetailsEntity.findByOrderDetailsItemQuantity", query = "SELECT o FROM OrderDetailsEntity o WHERE o.orderDetailsItemQuantity = :orderDetailsItemQuantity")})
public class OrderDetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_details_id")
    private Integer orderDetailsId;
    @Basic(optional = false)
    @Column(name = "order_details_item_price")
    private String orderDetailsItemPrice;
    @Basic(optional = false)
    @Column(name = "order_details_item_quantity")
    private String orderDetailsItemQuantity;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private OrderEntity orderId;
    @JoinColumn(name = "vending_machine_item_id", referencedColumnName = "vending_machine_item_id")
    @ManyToOne(optional = false)
    private VendingMachineItemEntity vendingMachineItemId;

    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public OrderDetailsEntity(Integer orderDetailsId, String orderDetailsItemPrice, String orderDetailsItemQuantity) {
        this.orderDetailsId = orderDetailsId;
        this.orderDetailsItemPrice = orderDetailsItemPrice;
        this.orderDetailsItemQuantity = orderDetailsItemQuantity;
    }

    public Integer getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public String getOrderDetailsItemPrice() {
        return orderDetailsItemPrice;
    }

    public void setOrderDetailsItemPrice(String orderDetailsItemPrice) {
        this.orderDetailsItemPrice = orderDetailsItemPrice;
    }

    public String getOrderDetailsItemQuantity() {
        return orderDetailsItemQuantity;
    }

    public void setOrderDetailsItemQuantity(String orderDetailsItemQuantity) {
        this.orderDetailsItemQuantity = orderDetailsItemQuantity;
    }

    public OrderEntity getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderEntity orderId) {
        this.orderId = orderId;
    }

    public VendingMachineItemEntity getVendingMachineItemId() {
        return vendingMachineItemId;
    }

    public void setVendingMachineItemId(VendingMachineItemEntity vendingMachineItemId) {
        this.vendingMachineItemId = vendingMachineItemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailsId != null ? orderDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetailsEntity)) {
            return false;
        }
        OrderDetailsEntity other = (OrderDetailsEntity) object;
        if ((this.orderDetailsId == null && other.orderDetailsId != null) || (this.orderDetailsId != null && !this.orderDetailsId.equals(other.orderDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soft.savm.entity.OrderDetailsEntity[ orderDetailsId=" + orderDetailsId + " ]";
    }
    
}
