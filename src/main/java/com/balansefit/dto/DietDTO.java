package com.balansefit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class DietDTO {

    String diet_seq;        // 식단 번호
    String diet_name;       // 식단 이름
    String food_name;       // 식단 음식 이름
    String food_number;     // 음식 개수
    String diet_calories;   // 총칼로리
}
