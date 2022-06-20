//package com.balansefit.service.impl;
//
//import com.balansefit.dto.DietDTO;
//import com.balansefit.persistance.mapper.IDietMapper;
//import com.balansefit.service.IDietService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Slf4j
//@Service("DietService")
//public class DietService implements IDietService {
//
//    private final IDietMapper dietMapper;
//
//    @Autowired
//    public DietService(IDietMapper dietMapper) {
//        this.dietMapper = dietMapper;
//    }
//
//    @Override
//    public List<DietDTO> getDietList() throws Exception {
//        return dietMapper.getDietList();
//    }
//
//    @Transactional
//    @Override
//    public void insertDietInfo(DietDTO dDTO) throws Exception {
//
//        log.info(this.getClass().getName() + ".insertDietInfo start!");
//        dietMapper.insertDietInfo(dDTO);
//    }
//
//    @Transactional
//    @Override
//    public DietDTO getDietInfo(DietDTO dDTO) throws Exception {
//
//        log.info(this.getClass().getName() + ".getDietInfo start!");
//
//        return dietMapper.getDietInfo(dDTO);
//    }
//
//    @Transactional
//    @Override
//    public void updateDietInfo(DietDTO dDTO) throws Exception {
//
//        log.info(this.getClass().getName() + ".updateDietInfo start!");
//        dietMapper.updateDietInfo(dDTO);
//    }
//
//    @Transactional
//    @Override
//    public void deleteDietInfo(DietDTO dDTO) throws Exception {
//
//        log.info(this.getClass().getName() + ".deleteDietInfo start1");
//        dietMapper.deleteDietInfo(dDTO);
//    }
//}
