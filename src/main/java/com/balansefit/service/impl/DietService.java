package com.balansefit.service.impl;

import com.balansefit.dto.DietDTO;
import com.balansefit.persistance.mapper.IDietMapper;
import com.balansefit.service.IDietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("DietService")
public class DietService implements IDietService {

    private final IDietMapper dietMapper;

    @Autowired
    public DietService(IDietMapper dietMapper) {
        this.dietMapper = dietMapper;
    }

    @Override
    public List<DietDTO> getDietList() throws Exception {
        return dietMapper.getDietList();
    }

    @Transactional
    @Override
    public void InsertDietInfo(DietDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".InsertDietInfo start!");
        dietMapper.InsertDietInfo(pDTO);
    }

    @Transactional
    @Override
    public DietDTO getDietInfo(DietDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".getDietInfo start!");

        return dietMapper.getDietInfo(pDTO);
    }

    @Transactional
    @Override
    public void updateDietInfo(DietDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".updateDietInfo start!");
        dietMapper.updateDietInfo(pDTO);
    }

    @Transactional
    @Override
    public void deleteDietInfo(DietDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".deleteDietInfo start1");
        dietMapper.deleteDietInfo(pDTO);
    }


}
