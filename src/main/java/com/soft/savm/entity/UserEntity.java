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
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u"),
    @NamedQuery(name = "UserEntity.findByUserId", query = "SELECT u FROM UserEntity u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserEntity.findByUserName", query = "SELECT u FROM UserEntity u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserEntity.findByUserPhone", query = "SELECT u FROM UserEntity u WHERE u.userPhone = :userPhone"),
    @NamedQuery(name = "UserEntity.findByUserAddress", query = "SELECT u FROM UserEntity u WHERE u.userAddress = :userAddress"),
    @NamedQuery(name = "UserEntity.findByUserEmail", query = "SELECT u FROM UserEntity u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "UserEntity.findByUserPassword", query = "SELECT u FROM UserEntity u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "UserEntity.findByUserDeleted", query = "SELECT u FROM UserEntity u WHERE u.userDeleted = :userDeleted")})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Column(name = "user_phone")
    private String userPhone;
    @Basic(optional = false)
    @Column(name = "user_address")
    private String userAddress;
    @Basic(optional = false)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_deleted")
    private Boolean userDeleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<UserRoleEntity> userRoleEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<OrderEntity> orderEntityList;

    public UserEntity() {
    }

    public UserEntity(Integer userId) {
        this.userId = userId;
    }

    public UserEntity(Integer userId, String userName, String userPhone, String userAddress, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getUserDeleted() {
        return userDeleted;
    }

    public void setUserDeleted(Boolean userDeleted) {
        this.userDeleted = userDeleted;
    }

    public List<UserRoleEntity> getUserRoleEntityList() {
        return userRoleEntityList;
    }

    public void setUserRoleEntityList(List<UserRoleEntity> userRoleEntityList) {
        this.userRoleEntityList = userRoleEntityList;
    }

    public List<OrderEntity> getOrderEntityList() {
        return orderEntityList;
    }

    public void setOrderEntityList(List<OrderEntity> orderEntityList) {
        this.orderEntityList = orderEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soft.savm.entity.UserEntity[ userId=" + userId + " ]";
    }

    
    
}
