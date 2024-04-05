/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soft.savm.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "role")
@NamedQueries({
    @NamedQuery(name = "RoleEntity.findAll", query = "SELECT r FROM RoleEntity r"),
    @NamedQuery(name = "RoleEntity.findByRoleId", query = "SELECT r FROM RoleEntity r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "RoleEntity.findByRoleName", query = "SELECT r FROM RoleEntity r WHERE r.roleName = :roleName")})
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private List<UserRoleEntity> userRoleEntityList;

    public RoleEntity() {
    }

    public RoleEntity(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserRoleEntity> getUserRoleEntityList() {
        return userRoleEntityList;
    }

    public void setUserRoleEntityList(List<UserRoleEntity> userRoleEntityList) {
        this.userRoleEntityList = userRoleEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleEntity)) {
            return false;
        }
        RoleEntity other = (RoleEntity) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soft.savm.entity.RoleEntity[ roleId=" + roleId + " ]";
    }
    
}
