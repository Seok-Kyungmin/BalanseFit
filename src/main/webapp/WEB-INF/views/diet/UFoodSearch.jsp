<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>foodSerch</title>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <style>
        input.form-text {
            border: 1px solid #bcbcbc;
            height: 28px;
        }

        input.arrow-button {
            background: url("../img/leftarrow_87483.png") no-repeat;
            border: none;
            background-size: 60px;
            width: 60px;
            height: 60px;
            margin-top: 33px;
            margin-left: 33px;
            opacity: 60%;
            cursor: pointer;
        }
    </style>
</head>
<body>
<form>
    <div style="display: flex">
        <input type="button" class="arrow-button">
        <form>
            <div class="position-relative mx-auto" style="width: 80%;">
                <input class="form-control border-primary w-100 py-3 ps-4 pe-5" type="text" placeholder="Food name" style="font-size: 40px;font-weight: 500;margin-top: 20px;">
                <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 me-2" style="padding: 1rem;font-size: 40px;font-weight: 500;color: #fff;margin-top: 28px;">Search
                </button>
            </div>
        </form>
    </div>
</form>
</body>
</html>