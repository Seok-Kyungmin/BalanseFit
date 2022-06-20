<%@ page import="com.balansefit.util.CmmUtil" %>
<%@ page import="com.balansefit.dto.UserInfoDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<UserInfoDTO> mList= (List<UserInfoDTO>) request.getAttribute("mList");

    //조회 결과 보여주기
    if (mList==null){
        mList = new ArrayList<UserInfoDTO>();

    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>MyPage</title>
    <!-- Font css -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
          rel="stylesheet">

    <style>
        .tit {
            color: #424242;
            text-align: center;
            margin: 0px;
            font-size: 45px;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 700;
        }

        .name {
            color: #424242;
            margin: 5px;
            font-size: 48px;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 700;
        }

        .cate {
            font-size: 40px;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 700;
            color: rgba(0, 0, 0, 0.7);
            position: absolute;
            top: -10%;
        }

        .cat {
            position: absolute;
            left: 50px;
            top: 0px;

            font-family: 'Noto Sans KR';
            font-style: normal;
            font-weight: 500;
            font-size: 35px;
            line-height: 17px;

            color: rgba(0, 0, 0, 0.7);
        }

        .cat-2 {
            position: absolute;
            left: 50%;
            top: 0px;

            font-family: 'Noto Sans KR';
            font-style: normal;
            font-weight: 500;
            font-size: 35px;
            line-height: 17px;

            color: rgba(0, 0, 0, 0.7);
        }

        .cat-3 {
            position: absolute;
            left: 50px;
            top: 100px;

            font-family: 'Noto Sans KR';
            font-style: normal;
            font-weight: 500;
            font-size: 35px;
            line-height: 17px;

            color: rgba(0, 0, 0, 0.7);
        }

        .cat-4 {
            position: absolute;
            left: 50%;
            top: 100px;

            font-family: 'Noto Sans KR';
            font-style: normal;
            font-weight: 500;
            font-size: 35px;
            line-height: 17px;

            color: rgba(0, 0, 0, 0.7);
        }

        .value-1 {
            font-size: 50px;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 500;
            color: rgba(0, 0, 0, 0.7);
            position: absolute;
            top: -20px;
            left: 30%
        }

        .value-2 {
            font-size: 50px;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 500;
            color: rgba(0, 0, 0, 0.7);
            position: absolute;
            top: -20px;
            left: 77%
        }

        .value-3 {
            font-size: 50px;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 500;
            color: rgba(0, 0, 0, 0.7);
            position: absolute;
            top: 75px;
            left: 30%
        }

        .value-4 {
            font-size: 50px;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 500;
            color: rgba(0, 0, 0, 0.7);
            position: absolute;
            top: 75px;
            left: 77%
        }

        .box-2 {
            margin: 30px 20px 20px 20px;
            padding: 50px;
            border-radius: 20px;
            background-color: #fff;
            position: relative;
            width: 92%;
            height: 350px;
        }

        .box-3 {
            position: absolute;
            width: 86%;
            height: 165px;
            left: 28px;
            top: 175px;
            margin: 10px;
            padding: 30px;

            background: #F3F3FE;
            border-radius: 10px;
        }

        .footer{
            background-color: #fff;
            padding: 30px;
            margin: 0;
            width: 100%;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.16);
            box-shadow: 5px 5px 5px#bec8cb;
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 110px;
        }
        .btn {

            width: 130px;
            height: 80px;

            /* 위치 */
            position: relative;
            left: 85%;
            top: -75px;

            /* 상자 디자인 큰틀*/
            margin-bottom: 30px;
            border: 0px;
            background-color: #E9E9FF;

            /* 그림자 */
            border-radius: 10px;
            /*box-shadow:.3rem .1rem 1.4rem  rgb(105, 108, 255, 30%), 0rem -.1rem .8rem rgb(105, 108, 255, 12%);*/

            /* 글씨 */
            color: #696CFF;
            font-size: 2em;
            font-weight: 700;

            animation-name: keybtn-language;
            animation-duration: .2s;


        }

        /*버튼 눌리는 효과*/
        .btn:active {

            box-shadow: inset -.3rem -.1rem 1.4rem rgb(105, 108, 255, 10%), inset .3rem .4rem .8rem rgb(105, 108, 255, 20%);
            cursor: pointer;

        }

        .myBtn {
            border: none;
            cursor: pointer;
            width: 70px;
            height: 70px;
            display: inline;
            margin-left: 55px;
        }

        .foodBtn {
            border: none;
            cursor: pointer;
            width: 70px;
            height: 70px;
            display: inline;
            position: absolute;
            top: 0%;
            left: 30%;
        }

        .exerciseBtn {
            border: none;
            cursor: pointer;
            width: 70px;
            height: 70px;
            display: inline;
            position: absolute;
            top: 0%;
            left: 56%;
        }

        .calorieBtn {
            border: none;
            cursor: pointer;
            width: 90px;
            height: 90px;
            display: inline;
            position: absolute;
            top: -19%;
            left: 80%;
        }

        .arr {
            border: none;
            cursor: pointer;
            width: 50px;
            height: 100%;
            position: absolute;
            left: 880px;
            top: 45px;
            opacity: 40%;
            display: inline;
        }

        .bar {
            font-family: 'Noto Sans KR';
            font-style: normal;
            font-weight: 700;
            font-size: 30px;
            line-height: 14px;
            display: flex;
            position: absolute;
            top: 52%;
            padding-top: 15px;
            padding-bottom: 20px;
            color: rgba(0, 0, 0, 0.7);
        }

    </style>
</head>
<body style="background-color: #EAEAF9; margin: 0px; width: 100%;">

<div style="background-color: #fff; padding: 30px; margin: 0; width: 100%; box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.16); box-shadow: 5px 5px 5px#bec8cb">
    <h3 class="tit">마이페이지</h3>

</div>
<div class="box-2">
    <h4 class="name">발란스 핏님</h4>
    <a href="/setting">
        <input type="button" class="btn" name="btn" value="수정">
    </a>
    <%
        for (int i = 0; i < mList.size(); i++) {
            UserInfoDTO uDTO = mList.get(i);

            if (uDTO == null) {
                uDTO = new UserInfoDTO();
            }
    %>
    <div class="box-3">
        <h5 class="cat">현재 체중</h5>
        <p class="value-1"><%=CmmUtil.nvl(uDTO.getUser_weight())%></p>
        <h5 class="cat-2">기초대사량</h5>
        <p class="value-2"><%=CmmUtil.nvl(uDTO.getUser_BM())%></p>
        <h5 class="cat-3">BMI</h5>
        <p class="value-3"><%=CmmUtil.nvl(uDTO.getUser_BMI())%></p>
        <h5 class="cat-4">1일 적정량</h5>
        <p class="value-4"><%=CmmUtil.nvl(uDTO.getUser_RC())%></p>
    </div>
    <%
        }
    %>
</div>
<%--<div class="box-2" style="height: 180px">--%>
<%--    <h4 class="name">D - 0</h4>--%>
<%--    <input type="button" class="btn" name="btn" style="width: 255px; left: 70%" value="처방 다시 받기">--%>
<%--    <h5 class="cat" style="top: 150px">현재 섭취량</h5>--%>
<%--    <p class="value-1" style="top: 125px; font-size: 50px; color: rgba(0, 0, 0, 0.8)">0</p>--%>
<%--    <p class="value-1" style="top: 155px; left: 34%; font-size: 35px">kcal/</p>--%>
<%--    <p class="value-1" style="top: 155px; left: 43%; font-size: 35px">1200</p>--%>
<%--    <h5 class="cat-2" style="top: 150px; left: 58%">현재 운동량</h5>--%>
<%--    <p class="value-2" style="top: 125px; left: 83%">200</p>--%>
<%--</div>--%>
<form id="nutrient" class="mb-3" action="index.html" method="POST">
    <div class="box-2" style="height: 50px;">
        <h4 class="cate">영양소 그래프</h4>
        <a href="auth-login-basic.html">
            <input type="button" class="arr" name="btn">
        </a>
    </div>
</form>
<form id="weight" class="mb-3" action="index.html" method="POST">
    <div class="box-2" style="height: 50px;">
        <h4 class="cate">체중 그래프</h4>
        <a href="auth-login-basic.html">
            <input type="button" class="arr" name="btn">
        </a>
    </div>
</form>
<form id="calorie" class="mb-3" action="index.html" method="POST">
    <div class="box-2" style="height: 50px;">
        <h4 class="cate">칼로리 그래프</h4>
        <a href="auth-login-basic.html">
            <input type="button" class="arr" name="btn">
        </a>
    </div>
</form>
<form id="food" class="mb-3" action="index.html" method="POST">
    <div class="box-2" style="height: 50px;">
        <h4 class="cate">오늘 식단 기록</h4>
        <a href="auth-login-basic.html">
            <input type="button" class="arr" name="btn">
        </a>
    </div>
</form>

<div class="footer">
    <div style="position: relative;">
        <form id="myPage" class="mb-3" action="index.html" method="POST">
            <div>
                <a href="auth-login-basic.html">
                    <input type="button" class="myBtn" name="btn">
                </a>
                <h4 class="bar" style="left: 6%;">MY</h4>
            </div>
        </form>
        <form id="foodPage" class="mb-3" action="index.html" method="POST">
            <div>
                <a href="auth-login-basic.html">
                    <input type="button" class="foodBtn" name="btn">
                </a>
                <h4 class="bar" style="left: 31%;">식단</h4>
            </div>
        </form>
        <form id="exercisePage" class="mb-3" action="index.html" method="POST">
            <div>
                <a href="auth-login-basic.html">
                    <input type="button" class="exerciseBtn" name="btn">
                </a>
                <h4 class="bar" style="left: 57%;">운동</h4>
            </div>
        </form>
        <form id="caloriePage" class="mb-3" action="index.html" method="POST">
            <div>
                <a href="auth-login-basic.html">
                    <input type="button" class="calorieBtn" name="btn">
                </a>
                <h4 class="bar" style="left: 78%;">칼로리사전</h4>
            </div>
        </form>
    </div>
</div>
<script>

</script>
</body>
</html>