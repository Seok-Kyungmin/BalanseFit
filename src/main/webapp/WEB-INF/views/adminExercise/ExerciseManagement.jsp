<%@ page import="com.balansefit.dto.ExerciseDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.balansefit.util.CmmUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<ExerciseDTO> eList = (List<ExerciseDTO>) request.getAttribute("eList");

    //운동 정보 조회 결과 보여주기
    if (eList == null) {
        eList = new ArrayList<ExerciseDTO>();

    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise management</title>

    <link rel="stylesheet" href="../assets/css/header.css">
    <link rel="stylesheet" href="../assets/css/exerciseInfo.css">
    <script src="../assets/js/header.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous">
    </script>
</head>
<body style="background: #EAEAF9;">
<header class="header">
    <nav class="nb">
        <img src="../img/logo.PNG" style="display: inline-block;">
        <ul class="nav-menu" style="margin-bottom: 0;">
            <li class="nav-item">
                <a href="#" class="nav-link" style="padding: 0; color: #475569;margin: 0">식단 정보 관리</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link" style="padding: 0; color: #475569;">운동 정보 관리</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link" style="padding: 0; color: #475569;">음식 정보 관리</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link" style="padding: 0; color: #475569;">로그아웃</a>
            </li>
        </ul>
        <div class="hamburger">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </div>
    </nav>
</header>

<div class="container">
    <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 22px;">
        <h2 class="title">운동 정보</h2>
        <div style="display: flex;justify-content: center; align-items: center;">
            <button type="button" class="btn btn-primary" style="
                width: 90px;height: 35px;background-color: #696CFF; box-shadow: 0px 2px 6px #696CFF; border-radius: 7px;
                color: #ffffff;font-size: 14px;font-weight: 500;font-family: 'Noto Sans KR', sans-serif;"
                    data-toggle="modal" data-target=".bd-example-modal-lg">운동 추가
            </button>
            <button type="button" class="btn-open-popup" style="
                margin-left: 5px; width: 90px;height: 35px;background-color: #696CFF; box-shadow: 0px 2px 6px #696CFF; border-radius: 7px;
                color: #ffffff;font-size: 14px;font-weight: 500;font-family: 'Noto Sans KR', sans-serif; border: 0"
                    data-toggle="modal" data-target=".bd-example-modal-lg">운동 수정
            </button>
        </div>
    </div>
    <div class="divTable minimalistBlack">
        <div class="divTableHeading">
            <div class="divTableRow">
                <div class="divTableHead">운동코드</div>
                <div class="divTableHead">운동명</div>
                <div class="divTableHead">MET</div>
            </div>
        </div>
        <%
            ExerciseDTO eDTO = null;

            for (int i = 0; i < eList.size(); i++) {
                eDTO = eList.get(i);

                if (eDTO == null) {
                    eDTO = new ExerciseDTO();
                }

        %>
        <div class="divTableBody">
            <div class="divTableRow">
                <div class="divTableCell"><%=CmmUtil.nvl(eDTO.getExercise_seq())%></div>
                <div class="divTableCell"><%=CmmUtil.nvl(eDTO.getExercise_name())%></div>
                <div class="divTableCell"><%=CmmUtil.nvl(eDTO.getExercise_met())%></div>
            </div>
        </div>

        <%

            }
        %>
    </div>

</div>

<!--<form id="formAuthentication" class="mb-3" action="exerciseManagement.html" method="POST">-->
<div class="exerciseModal">
    <div class="exerciseModal_body" style="border-radius: 10px;">
        <h2 class="modal_title" style="margin-left: 10%;">운동정보를 수정해 주세요</h2>
        <div style="display: flex;">
            <div style="margin: 0 auto;">
                <h3 style=" margin-top: 35px;font-family: 'Noto Sans KR';font-style: normal;font-weight: 700;font-size: 15px;line-height: 22px;color: #76838F;">
                    운동명</h3>
                <input type="text"
                       style=" margin-top: 5px; width: 395px; height: 39px;background: #EDEDED; border-radius: 10px;border: 0; font-size: 17px; padding: 10px;">
            </div>
        </div>
        <div style="display: flex;">
            <div style="margin: 0 auto;">
                <h3 style=" margin-top: 35px;font-family: 'Noto Sans KR';font-style: normal;font-weight: 700;font-size: 15px;line-height: 22px;color: #76838F;">
                    MET</h3>
                <input type="text"
                       style=" margin-top: 5px; width: 395px; height: 39px;background: #EDEDED; border-radius: 10px;border: 0; font-size: 17px; padding: 10px;">
            </div>
        </div>
        <div style="text-align: center;">
            <a href="exerciseManagement.html">
                <button type="button" style="border: 0; width: 30%;height: 35px; margin-top: 70px; margin-bottom: 35px;background-color: #696CFF; box-shadow: 0px 2px 6px #696CFF;
                        border-radius: 7px; color: #ffffff;font-size: 14px;font-weight: 500; font-family: 'Noto Sans KR', sans-serif;">
                    추가하기
                </button>
            </a>
        </div>
    </div>
</div>
<!--</form>-->
<!-- Modal -->
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" style="border-radius: 10px;">
            <h2 class="modal_title" style="margin-left: 10%;">운동정보를 추가해 주세요</h2>
            <div style="display: flex;">
                <div style="margin: 0 auto;">
                    <h3 style=" margin-top: 35px;font-family: 'Noto Sans KR';font-style: normal;font-weight: 700;font-size: 15px;line-height: 22px;color: #76838F;">
                        운동명</h3>
                    <input type="text"
                           style=" margin-top: 5px; width: 395px; height: 39px;background: #EDEDED; border-radius: 10px;border: 0; font-size: 17px; padding: 10px;">
                </div>
            </div>
            <div style="display: flex;">
                <div style="margin: 0 auto;">
                    <h3 style=" margin-top: 35px;font-family: 'Noto Sans KR';font-style: normal;font-weight: 700;font-size: 15px;line-height: 22px;color: #76838F;">
                        MET</h3>
                    <input type="text"
                           style=" margin-top: 5px; width: 395px; height: 39px;background: #EDEDED; border-radius: 10px;border: 0; font-size: 17px; padding: 10px;">
                </div>
            </div>
            <div style="display: flex; justify-content: center; align-items: center;">
                <button type="button" class="btn btn-primary" style="width: 40%;height: 35px; margin-top: 70px; margin-bottom: 35px;background-color: #696CFF; box-shadow: 0px 2px 6px #696CFF;
                        border-radius: 7px; color: #ffffff;font-size: 14px;font-weight: 500; font-family: 'Noto Sans KR', sans-serif;"
                        data-toggle="modal" data-target=".bd-example-modal-lg">추가하기
                </button>
            </div>
        </div>
    </div>
</div>
<script>
    const body = document.querySelector('body');
    const modal = document.querySelector('.exerciseModal');
    const btnOpenPopup = document.querySelector('.btn-open-popup');

    btnOpenPopup.addEventListener('click', () => {
        modal.classList.toggle('show');

        if (modal.classList.contains('show')) {
            body.style.overflow = 'hidden';
        }
    });

    modal.addEventListener('click', (event) => {
        if (event.target === modal) {
            modal.classList.toggle('show');

            if (!modal.classList.contains('show')) {
                body.style.overflow = 'auto';
            }
        }
    });
</script>
</body>
</html>