<%--
  Created by IntelliJ IDEA.
  User: u8360
  Date: 2022/6/11
  Time: 下午 07:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <!-- Bootstrap4.6 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap4/css/bootstrap.css">
    <!--    基礎版面樣式  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/back_layout.css">
    <!--    後台書籍管理添加樣式  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/book/css/back_book_add.css">
    <style>
        header.header{
            z-index: 10;
        }
    </style>
    <title>管理後臺</title>
</head>
<body>
<header class="header">
    <h1>這邊再麻煩大家寫自己的項目名稱</h1>
</header>
<%@include file="/template/back_layout_aside.jsp"%>
<main class="main">
    <div id="table_container" class="">
        <form class="align-items-start form-row">
            <div class="form-group col-6">
                <label for="title">書名</label>
                <input type="text" id="title" class="form-control is-valid" placeholder="請輸入書名" required>
                <div class="valid-feedback">success!</div>
                <div class="invalid-feedback">fail!</div>
            </div>
            <div class="form-group col-6">
                <label for="ISBN">ISBN-13</label>
                <input type="text" id="ISBN" class="form-control" placeholder="ISBN-13" required>
            </div>
            <div class="form-group col-4">
                <label for="book_category">書籍種類</label>
                <select id="book_category" class="form-control" required>
                    <option selected>C</option>
                    <option>C++</option>
                    <option>JAVA</option>
                    <option>PYTHON</option>
                    <option>kotlin</option>
                </select>
            </div>
            <div class="form-group col-4">
                <label for="edition">版次</label>
                <input type="text" id="edition" class="form-control" placeholder="請輸入版次" value="1">
            </div>
            <div class="form-group col-4">
                <label for="pages">頁數</label>
                <input type="text" id="pages" class="form-control" placeholder="請輸入頁數">
            </div>
            <div class="orm-group w-100"></div>

            <div class="form-group col-6">
                <label for="author">書籍作者</label>
                <input type="text" class="form-control" id="author" placeholder="請輸入作者">
            </div>
            <div class="form-group col-6">
                <label for="translator">譯者</label>
                <input type="text" class="form-control" id="translator" placeholder="請輸入譯者">
            </div>
            <div class="form-group col-6">
                <label for="publisher">出版商</label>
                <input type="text" class="form-control" id="publisher" placeholder="請輸出版商">
            </div>
            <div class="form-group col-6">
                <label class="control-label" for="pubDate">出版日期</label>
                <input class="form-control" id="pubDate" name="date" placeholder="MM/DD/YYY" type="date"/>
            </div>

            <div class="form-group col-12">
                <label for="summary">簡介</label>
                <textarea class="form-control" id="summary" rows="8"></textarea>
            </div>

            <div class="form-group col-12">
                <label for="table_content">章節目錄</label>
                <textarea class="form-control" id="table_content" rows="8"></textarea>
            </div>
            <button class="btn btn-primary ml-auto" type="submit" id="submit_btn" disabled>Submit form</button>
        </form>
    </div>

</main>

<!-- sweetalert -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- Jquery -->
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- bootstrap JS-->
<script src="${pageContext.request.contextPath}/bootstrap4/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/back_layout.js"></script>
<script src="${pageContext.request.contextPath}/book/js/back_book_add.js"></script>
</body>
</html>
