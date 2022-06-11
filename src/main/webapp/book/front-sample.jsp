<%--
  Created by IntelliJ IDEA.
  User: u8360
  Date: 2022/6/11
  Time: 下午 08:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>商城首頁</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/front_layout.css">
</head>

<body>
<%@include file="/template/front_layout_header.jsp" %>
<img class="god" src="${pageContext.request.contextPath}/images/Godbless.png" height="500px;" width="500px;"><br>
<img class="cs" src="${pageContext.request.contextPath}/images/cs.png" height="90px;" width="90px;" href="#">
<%@include file="/template/front_layout_footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/front_layout.js"></script>
</body>
</html>
