<%@ page import="com.balansefit.dto.UserInfoDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.balansefit.util.CmmUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Info Setting</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
          rel="stylesheet">
    <style>
        h3 {
            color: #424242;
            text-align: center;
            margin: 0px;
            font-size: 45px;
            font-family: 'Noto Sans KR', sans-serif;
        }

        h4 {
            font-size: 40px;
            font-family: 'Noto Sans KR', sans-serif;
            color: rgba(73, 73, 73, 0.5);
            position: absolute;
            top: -15%;
        }

        p {
            font-size: 40px;
            font-family: 'Noto Sans KR', sans-serif;
            color: rgba(73, 73, 73, 0.5);
            position: absolute;
            top: -7%;
            left: 30%
        }

        .box-1{
            margin: 95px 20px 20px 20px;
            padding: 35px;
            border-radius: 20px;
            background-color:#fff;
            height: 50px;
            position: relative;
        }

        .box-2{
            margin: 30px 20px 20px 20px;
            padding: 40px;
            border-radius: 20px;
            background-color:#fff;
            height: 50px;
            position: relative;
        }

        .btn {

            width: 130px;
            height: 80px;

            /* 위치 */
            position: relative;
            left: 85%;
            top: -15px;

            /* 상자 디자인 큰틀*/
            margin-bottom: 30px;
            border: 0px;
            background-color: #E9E9FF;

            /* 그림자 */
            border-radius: 10px;
            /*box-shadow:.3rem .1rem 1.4rem  rgb(105, 108, 255, 30%), 0rem -.1rem .8rem rgb(105, 108, 255, 12%);*/

            /* 글씨 */
            color: #696CFF;
            font-size: 1.7em;
            font-weight: bold;

            animation-name: keybtn-language;
            animation-duration: .2s;


        }

        /*버튼 눌리는 효과*/
        .btn:active {

            box-shadow: inset -.3rem -.1rem 1.4rem rgb(105, 108, 255, 10%), inset .3rem .4rem .8rem rgb(105, 108, 255, 20%);
            cursor: pointer;

        }
    </style>
    <%
        List<UserInfoDTO> uList= (List<UserInfoDTO>) request.getAttribute("usList");

        //조회 결과 보여주기
        if (uList==null){
            uList = new ArrayList<UserInfoDTO>();

        }

        UserInfoDTO uDTO = null;

        for (int i = 0; i < uList.size(); i++) {
            uDTO = uList.get(i);

            if (uDTO == null) {
                uDTO = new UserInfoDTO();
            }
        }
    %>
</head>
<body style="background-color: #EAEAF9; margin: 0px">

<div style="background-color: #fff; padding: 30px; margin: 0; box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.16); box-shadow: 5px 5px 5px#bec8cb">
    <h3>회원 정보 수정</h3>
</div>
<div class="box-1">
    <h4>닉네임</h4>
    <p><%=CmmUtil.nvl(uDTO.getUser_name())%></p>
    <input type="button" class="btn" name="btn" value="수정">
</div>
<div class="box-2">
    <h4>키</h4>
    <p><%=CmmUtil.nvl(uDTO.getUser_height())%></p>
    <input type="button" class="btn" name="btn" value="수정">
</div>
<div class="box-2">
    <h4>성별</h4>
    <p><%=CmmUtil.nvl(uDTO.getUser_gender())%></p>
    <input type="button" class="btn" name="btn" value="수정">
</div>
<div class="box-2">
    <h4>나이</h4>
    <p><%=CmmUtil.nvl(uDTO.getUser_age())%></p>
    <input type="button" class="btn" name="btn" value="수정">
</div>
<div class="box-2">
    <h4>기초대사량</h4>
    <p><%=CmmUtil.nvl(uDTO.getUser_BM())%></p>
</div>
<div class="box-2">
    <h4>1일 적정량</h4>
    <p><%=CmmUtil.nvl(uDTO.getUser_RC())%></p>
</div>
<div class="box-2">
    <h4>목표 체중</h4>
    <p><%=CmmUtil.nvl(uDTO.getTarget_weight())%></p>
    <input type="button" class="btn" name="btn" value="수정">
</div>

<div class="box-2">
    <h4>현재 체중</h4>
    <p><%=CmmUtil.nvl(uDTO.getUser_weight())%></p>
    <hr style="position: absolute; top: 0%;">
</div>
<div class="box-2">
    <h4>BMI</h4>
    <p><%=CmmUtil.nvl(uDTO.getUser_BMI())%></p>
    <hr style="position: absolute; top: 0%;">
</div>
</body>
</html>
