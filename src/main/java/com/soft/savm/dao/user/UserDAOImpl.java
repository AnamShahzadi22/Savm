/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soft.savm.dao.user;

import com.soft.savm.entity.UserEntity;
import com.soft.savm.exception.EntityNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PMYLS
 */
@Repository
public class UserDAOImpl implements UserDAO {

    EntityManager em;

    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    /**
     *
     * @param userEntity
     * @return
     */
    @Transactional
    @Override
    public UserEntity addUser(UserEntity userEntity) throws InvalidArguemntsException {
        UserEntity user = new UserEntity();
        if (userEntity.getUserName() == "" || userEntity.getUserAddress() == "" || userEntity.getUserPhone() == "" || userEntity.getUserEmail() == "" || "" == userEntity.getUserPassword()) {
            throw new InvalidArguemntsException("Fields Cannot Be null");
        }
        user.setUserId(userEntity.getUserId());
        user.setUserName(userEntity.getUserName());
        user.setUserAddress(userEntity.getUserAddress());
        user.setUserPhone(userEntity.getUserPhone());
        user.setUserEmail(userEntity.getUserEmail());
        user.setUserPassword(userEntity.getUserPassword());
        user.setUserDeleted(false);
        //user.setUserDeleted(userEntity.getUserDeleted());

        em.merge(user);
        return user;
    }

    @Transactional
    @Override
    public UserEntity deleteUser(int userId) throws EntityNotFoundException {
        UserEntity user = em.find(UserEntity.class, userId);
        if (user == null) {
            throw new EntityNotFoundException("User Not Found with Id : " + userId);
        }
        user.setUserDeleted(true);
        em.merge(user);

        return user;
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public UserEntity getUserById(int userId) throws EntityNotFoundException {
        UserEntity user = null;

        user = em.find(UserEntity.class, userId);
        if (user == null) {

            throw new EntityNotFoundException("User Not found with id : " + userId);
        }

        return user;
    }

    public List<UserEntity> getAllUsers() throws EntityNotFoundException{
        List<UserEntity> users = null;
        Query qry = em.createQuery("SELECT c FROM UserEntity c");
        users = qry.getResultList();
        if (users == null) {
        throw new EntityNotFoundException("No Result Found");
        }
        return users;
    }

}
