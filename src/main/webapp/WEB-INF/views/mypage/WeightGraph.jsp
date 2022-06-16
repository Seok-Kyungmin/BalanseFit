<%@ page import="com.balansefit.dto.UserInfoDTO" %>
<%@ page import="com.balansefit.dto.UserWeightDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WeightGraph</title>

    <!-- Font css -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
          rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>


    <style>
        .tit {
            color: #424242;
            text-align: center;
            margin: 0px;
            font-size: 45px;
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 700;
        }
        .box {
            margin: 120px 40px 20px 40px;
            height: 100%;
            border-radius: 20px;
            background-color: #fff;
            flex: 1 1 auto;
            padding: 64px;
        }
    </style>
    <%
        List<UserWeightDTO> wList= (List<UserWeightDTO>) request.getAttribute("wList");

        //조회 결과 보여주기
        if (wList==null){
            wList = new ArrayList<UserWeightDTO>();

        }

        UserWeightDTO wDTO = null;

        for (int i = 0; i < wList.size(); i++) {
            wDTO = wList.get(i);

            if (wDTO == null) {
                wDTO = new UserWeightDTO();
            }
        }
    %>
</head>
<body style="background-color: #EAEAF9; margin: 0px">

<div style="background-color: #fff; padding: 30px; margin: 0; box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.16); box-shadow: 5px 5px 5px#bec8cb">
    <h3 class="tit">체중 그래프</h3>
</div>
<div class="box">
    <canvas id="line-chart" width="800" height="750"></canvas>
    <script type="text/javascript">

        $(document).ready(function() {

            let chartLabels = []; // 받아올 데이터를 저장할 배열 선언
            let chartData = [];
            let month="";

            let cooContract

            function createChart() {

                var ctx = document.getElementById("canvas").getContext("2d");
                LineChartDemo = Chart.Line(ctx, {
                    data : lineChartData,
                    options : {
                        scales : {
                            yAxes : [ {
                                ticks : {
                                    beginAtZero : true
                                }
                            } ]
                        }
                    }
                });
            }

        <%--    $.ajax({--%>
        <%--        type: "get",--%>
        <%--        data: {user_id:"${wDTO.user_id}"},--%>
        <%--        dataType:"json",--%>
        <%--        success:function (data){--%>
        <%--            // 그래프로 나타낼 자료 리스트에 담기--%>
        <%--            for (let i = 0; i<data.length; i++){--%>
        <%--                dateList.push(data[i].weight_dt);--%>
        <%--                weightList.push(data[i].current_w);--%>
        <%--            }--%>
        <%--            //그래프--%>
        <%--            new Chart(document.getElementById("line-chart"), {--%>
        <%--                type:"line",--%>
        <%--                data: {--%>
        <%--                    labels: dateList, // x축--%>
        <%--                    datasets: [{--%>
        <%--                        data: wDTO.current_w, //값--%>
        <%--                        label: "몸무게",--%>
        <%--                        borderColor:"#8BC7FE",--%>
        <%--                        fill: false--%>
        <%--                    }]--%>
        <%--                },--%>
        <%--                options:{--%>
        <%--                    title: {--%>
        <%--                        display:true,--%>
        <%--                        text: '주간 몸무게'--%>
        <%--                    }--%>
        <%--                }--%>
        <%--            }); // 그래프--%>
        <%--        },--%>
        <%--        error:function(){--%>
        <%--            alert("실패");--%>
        <%--        }--%>
        <%--    }) // ajax--%>
        <%--}   //getGraph--%>

    </script>

</div>
</body>
</html>