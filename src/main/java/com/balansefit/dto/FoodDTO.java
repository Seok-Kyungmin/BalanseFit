package com.balansefit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class FoodDTO {

    String food_seq;    //음식 번호
    String food_name;   //음식명
    String food_calories;  //음식 칼로리
    String food_carbohydrate;  // 음식 탄수화물
    String food_protein;   //단백질
    String food_fat;   // 지방
    String food_sugar;     //당
    String food_natrium;   //나트륨
    String food_weight;    //총내용량

}
