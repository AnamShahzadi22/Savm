/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.soft.savm.dao.user;

import com.soft.savm.entity.UserEntity;
import com.soft.savm.exception.EntityNotFoundException;
import java.util.List;

/**
 *
 * @author PMYLS
 */
public interface UserDAO {

    public UserEntity addUser(UserEntity userEntity) throws InvalidArguemntsException;
    //new

         // public UserEntity deleteUser(UserEntity userEntity);

    public UserEntity deleteUser(int userId) throws EntityNotFoundException;

    public UserEntity getUserById(int userId) throws EntityNotFoundException;
    
        public List<UserEntity> getAllUsers() throws EntityNotFoundException;


}
