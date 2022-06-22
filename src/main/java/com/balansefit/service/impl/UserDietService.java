package com.balansefit.service.impl;


import com.balansefit.dto.FoodDTO;
import com.balansefit.dto.UserDietDTO;
import com.balansefit.persistance.mapper.IUserDietMapper;
import com.balansefit.service.IUserDietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("UserDietService")
public class UserDietService implements IUserDietService {

    private final IUserDietMapper userDietMapper;

    @Autowired
    public UserDietService(IUserDietMapper userDietMapper) {
        this.userDietMapper = userDietMapper;
    }

    @Override
    public List<UserDietDTO> getUserDietList() throws Exception {
        return userDietMapper.getUserDietList();
    }

    @Transactional
    @Override
    public void insertUserDietInfo(UserDietDTO dDTO) throws Exception {

        log.info(this.getClass().getName() + "insertUserDietInfo 시작!");

        userDietMapper.insertUserDietInfo(dDTO);
    }

    @Transactional
    @Override
    public UserDietDTO getUserDietInfo(UserDietDTO dDTO) throws Exception {

        log.info(this.getClass().getName() + "getUserDietInfo 시작!");

        return userDietMapper.getUserDietInfo(dDTO);
    }

//    @Transactional
//    @Override
//    public void updateUserDietInfo(UserDietDTO dDTO) throws Exception {
//
//        log.info(this.getClass().getName() + "updateUserDietInfo 시작!");
//
//        userDietMapper.updateUserDietInfo(dDTO);
//    }

    @Transactional
    @Override
    public void deleteUserDietInfo(UserDietDTO dDTO) throws Exception {

        log.info(this.getClass().getName() + "deleteUserDietInfo 시작!");

        userDietMapper.deleteUserDietInfo(dDTO);
    }

    @Override
    public List<FoodDTO> findFood(String keyword) {
        return null;
    }

    @Override
    public List<FoodDTO> getUserFoodList() throws Exception {
        return userDietMapper.getUserFoodList();
    }

    @Transactional
    public List<FoodDTO> search(String keyword) {

        List<FoodDTO> foodList = userDietMapper.findFood(keyword);

        return foodList;
    }

//    @Override
//    public
}
