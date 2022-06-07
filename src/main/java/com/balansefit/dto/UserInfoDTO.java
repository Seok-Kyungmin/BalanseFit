package com.balansefit.dto;

import lombok.Data;

@Data
public class UserInfoDTO {

    private Integer user_seq;       // 회원번호
    private Integer user_auth;      // 회웍권한
    private String user_id;         // 아이디
    private String user_pw;         // 회원비밀번호
    private String user_name;       // 회원닉네임
    private String user_email;      // 회원 이메일
    private Integer user_age;       // 회원 연령
    private String user_gender;     // 회원 성별
    private Integer user_height;    // 회원 키
    private Integer user_weight;    // 회원 몸무게
    private Integer user_RC;        // 회원 권장식사량
    private Integer user_BM;        // 기초대사량
    private Integer user_BMI;       // 회원 BMI
    private Integer user_RE;        // 회원 권장운동량
    private Integer target_weight;  // 회원 목표몸무게
    private Integer target_period;  // 회원 목표기간

    // 회원가입시, 중복가입을 방지 위해 사용할 변수
    // DB를 조회해서 회원이 존재하면 Y값을 반환함
    // DB테이블에 존재하지 않는 가상의 컬럼(ALIAS)
    private String exists_yn;

}
