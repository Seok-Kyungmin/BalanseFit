package com.balansefit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDTO {

    private String exercise_seq;    //운동 번호
    private String exercise_name;   //운동명
    private String exercise_met;   //소모 칼로리
}
