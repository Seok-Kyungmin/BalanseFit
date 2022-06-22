package com.balansefit.service.impl;

import com.balansefit.dto.ExerciseDTO;
import com.balansefit.persistance.mapper.IExerciseMapper;
import com.balansefit.service.IExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("ExerciseService")
public class ExerciseService implements IExerciseService {

    private final IExerciseMapper exerciseMapper;

    @Autowired
    public ExerciseService(IExerciseMapper exerciseMapper) {
        this.exerciseMapper = exerciseMapper;
    }

    @Override
    public List<ExerciseDTO> getExerciseList() throws Exception {
        return exerciseMapper.getExerciseList();
    }

    @Transactional
    @Override
    public void insertExerciseInfo(ExerciseDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".insertExerciseInfo start!");

        exerciseMapper.insertExerciseInfo(pDTO);
    }

    @Transactional
    @Override
    public ExerciseDTO getExerciseInfo(ExerciseDTO pDTO) throws Exception{

        log.info(this.getClass().getName() + ".getExerciseInfo start!");

        return exerciseMapper.getExerciseInfo(pDTO);
    }

    @Transactional
    @Override
    public void updateExerciseInfo(ExerciseDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".updateExerciseInfo start!");

        exerciseMapper.updateExerciseInfo(pDTO);
    }

    @Transactional
    @Override
    public void deleteExerciseInfo(ExerciseDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".deleteExerciseInfo start!");

        exerciseMapper.deleteExerciseInfo(pDTO);
    }
}
