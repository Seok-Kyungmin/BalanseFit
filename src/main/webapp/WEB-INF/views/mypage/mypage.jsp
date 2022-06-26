<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.balansefit.util.CmmUtil" %>
<%@ page import="com.balansefit.dto.UserInfoDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.balansefit.dto.UserWeightDTO" %>
<%@ page import="com.balansefit.dto.FoodDTO" %>
<%
    List<UserInfoDTO> mList = (List<UserInfoDTO>) request.getAttribute("mList");

    //조회 결과 보여주기
    if (mList == null) {
        mList = new ArrayList<UserInfoDTO>();

    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="../img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&family=Pacifico&display=swap"
          rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="../lib/animate/animate.min.css" rel="stylesheet">
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="../lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet"/>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="../css/style.css" rel="stylesheet">

    <title>MyPage</title>
</head>
<body>
<div class="container-xxl bg-white p-0">
    <!-- Spinner Start -->
    <div id="spinner"
         class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


    <!-- Navbar & Hero Start -->
    <div class="container-xxl position-relative p-0">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4 px-lg-5 py-3 py-lg-0">
            <a href="" class="navbar-brand p-0">
                <h1 class="text-primary m-0"><i class="fa fa-utensils me-3"></i>Balance fit</h1>
                <!-- <img src="img/logo.png" alt="Logo"> -->
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="fa fa-bars"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto py-0 pe-4">
                    <a href="/index" class="nav-item nav-link">Home</a>
                    <a href="/admin/DietList" class="nav-item nav-link">Diet</a>
                    <a href="/admin/ExerciseList" class="nav-item nav-link">Exercise</a>
                    <a href="/admin/FoodList" class="nav-item nav-link">Food</a>
                    <a href="/myPage" class="nav-item nav-link">MyPage</a>
                    <!--                        <div class="nav-item dropdown">-->
                    <!--                            <a href="#" class="nav-link dropdown-toggle active" data-bs-toggle="dropdown">Pages</a>-->
                    <!--                            <div class="dropdown-menu m-0">-->
                    <!--                                <a href="booking.html" class="dropdown-item">Booking</a>-->
                    <!--                                <a href="food.html" class="dropdown-item active">Our Team</a>-->
                    <!--                                <a href="testimonial.html" class="dropdown-item">Testimonial</a>-->
                    <!--                            </div>-->
                    <!--                        </div>-->
                    <!--                        <a href="contact.html" class="nav-item nav-link">Contact</a>-->
                </div>
                <a href="/adminLoginPage" class="btn btn-primary py-2 px-4">Login</a>
            </div>
        </nav>

        <div class="container-xxl py-5 bg-dark hero-header mb-5">
            <div class="container text-center my-5 pt-5 pb-4">
                <h1 class="display-3 text-white mb-3 animated slideInDown">My Page</h1>
            </div>
        </div>
    </div>
    <!-- Navbar & Hero End -->

        <%
            for (int i = 0; i < mList.size(); i++) {
                UserInfoDTO uDTO = mList.get(i);

                if (uDTO == null) {
                    uDTO = new UserInfoDTO();
                }
        %>

    <!-- Contact Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                <h5 class="section-title ff-secondary text-center text-primary fw-normal">User</h5>
                <h1 class="mb-5"><%=CmmUtil.nvl(uDTO.getUser_name())%>
                </h1>
            </div>

            <div class="con">
                <div class="divTable minimalistBlack">
                    <div class="divTableHeading">
                        <div class="divTableRow">
                            <div class="divTableHead">현재 체중</div>
                            <div class="divTableHead">기초대사량</div>
                            <div class="divTableHead">BMI</div>
                            <div class="divTableHead">1일 적정량</div>
                        </div>
                    </div>

                    <div class="divTableBody">
                        <div class="divTableRow">
                            <div class="divTableCell"><%=CmmUtil.nvl(uDTO.getUser_weight())%>
                            </div>
                            <div class="divTableCell">
                                <a href="javascript:doDetail('<%=CmmUtil.nvl(uDTO.getUser_BM())%>');">
                                    <%=CmmUtil.nvl(uDTO.getUser_BMI())%>
                                </a></div>
                            <div class="divTableCell"><%=CmmUtil.nvl(uDTO.getUser_weight())%>
                            </div>
                        </div>
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
            </div>
        </div>
        <!-- Contact End -->


        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
            <div class="container py-5">
                <div class="row g-5">
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../lib/wow/wow.min.js"></script>
    <script src="../lib/easing/easing.min.js"></script>
    <script src="../lib/waypoints/waypoints.min.js"></script>
    <script src="../lib/counterup/counterup.min.js"></script>
    <script src="../lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="../lib/tempusdominus/js/moment.min.js"></script>
    <script src="../lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="../lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="../js/main.js"></script>
</body>

</html>