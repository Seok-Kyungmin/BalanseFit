package com.balansefit.service.impl;

import com.balansefit.dto.DietDTO;
import com.balansefit.dto.UserDietDTO;
import com.balansefit.persistance.mapper.IUserDietMapper;
import com.balansefit.service.IUserDietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("UserDietService")
public class UserDietService implements IUserDietService {

    public final IUserDietMapper userDietMapper;

    @Autowired
    public UserDietService(IUserDietMapper userDietMapper) {
        this.userDietMapper = userDietMapper;
    }

    @Override
    public List<DietDTO> getUserDietList() throws Exception {
        return userDietMapper.getUserDietList();
    }

    @Override
    public void insertUserDietInfo(UserDietDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + "insertUserDietInfo 시작!");

        userDietMapper.insertUserDietInfo(pDTO);
    }

    @Override
    public UserDietDTO getUserDietInfo(UserDietDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + "getUserDietInfo 시작!");

        return userDietMapper.getUserDietInfo(pDTO);
    }

    @Override
    public void deleteUserDietInfo(UserDietDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + "deleteUserDietInfo 시작!");

        userDietMapper.deleteUserDietInfo(pDTO);
    }

}
