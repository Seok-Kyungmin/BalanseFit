package com.balansefit.dto;

import lombok.Data;

@Data
public class UserDietDTO {

    String diet_seq;        // 식단 번호
    String diet_name;       // 식단 이름
    String food_name;       // 식단 음식 이름
    String food_number;     // 음식 개수
    String diet_calories;   // 총칼로리
    String user_id;        // 아이디
    String reg_id;         // 최초 등록자아이디
    String reg_dt;         // 최초 등록시간
    String chg_id;         // 마지막 수정자아이디
    String chg_dt;         // 마지막 수정시간
}
