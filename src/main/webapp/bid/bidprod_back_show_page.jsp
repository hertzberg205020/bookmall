<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibani.bookmall.web.bid_prod.entity.*"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<title>管理後臺 | 競標商品管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/back_layout.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bid/css/bidprod_back_page.css">
</head>
<body>
	<header class="header">
		<h1 class="text-center"
			style="font-size: 32px; font-weight: 600; color: rgb(82, 136, 138)">競標商品管理</h1>
	</header>

	<%@include file="/template/back_layout_aside.jsp"%>

	<main class="main">
		<div class="container">
		<br>
<!-- 			<div class="d-flex mt-4"> -->
				<div class="m-2 p-1" style="background-color:steelblue; width:60px; border-radius: 5px;">
					<a class="text-light" style="text-decoration: none;" href="bidprod_back_page.jsp">上一頁</a>
				</div>
				<div style="font-size: 22px;">查詢結果</div>
<!-- 				<div class="ml-auto"> -->
<!-- 					<ul class="pagination pagination-sm justify-content-end"> -->
<!-- 						<li class="page-item"><a class="page-link text-secondary" -->
<!-- 							href="#">上一頁</a></li> -->
<!-- 						<li class="page-item"><a class="page-link text-secondary" -->
<!-- 							href="#">1</a></li> -->
<!-- 						<li class="page-item"><a class="page-link text-secondary" -->
<!-- 							href="#">2</a></li> -->
<!-- 						<li class="page-item"><a class="page-link text-secondary" -->
<!-- 							href="#">3</a></li> -->
<!-- 						<li class="page-item"><a class="page-link text-secondary" -->
<!-- 							href="#">下一頁</a></li> -->
<!-- 					</ul> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<table class="table table-sm table-hover" style="font-size: 14px;">
				<thead>
					<tr>
						<th style="border-radius: 8px 0 0 0; height: 20px;">競標商品編號</th>
						<th>書目編號</th>
						<th>競標底價</th>
						<th>直購價</th>
						<th>最高出價</th>
						<th>商品狀態</th>
						<th>起標時間</th>
						<th>結標時間</th>
						<th style="border-radius: 0 8px 0 0;">修改</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th class="header-row" scope="row">${bidProd.bidID} <a
							href="${pageContext.request.contextPath}/template/bid_front_layout.html"
							target="_blank" data-toggle="tooltip" data-placement="right"
							title="查看商品詳情"><i class="bi bi-book"></i></a></th>
						<td>${bidProd.bookID}-${bidProd.book.title}</td>
						<td>${bidProd.startPrice}</td>
						<td>${bidProd.bidDirectPrice}</td>
						<td>${bidProd.bidCurPrice}</td>
						<td>
						 <%
								BidProd bidProd1 = new BidProd();
								switch (bidProd1.getBidProdStat()) {
								case 0:
									out.println("安排競標");
									break;
								case 1:
									out.println("待上架");
									break;
								case 2:
									out.println("標案進行中");
									break;
								case 3:
									out.println("結標售出");
									break;
								case 4:
									out.println("流標");
									break;
								case 5:
									out.println("撤銷");
									break;
								}
							%>
						</td>
						<td>${bidProd.bidStart}</td>
						<td>${bidProd.bidEnd}</td>
						<td class="last-col"><a class="text-light"
							href="${pageContext.request.contextPath}/bid/bidprod_back_update_page.jsp"
							target="_blank"> <i class="bi bi-pencil-fill"></i></a></td>
					</tr>
			</table>
			
		</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/js/back_layout.js"></script>
	<script
		src="${pageContext.request.contextPath}/bid/js/bidprod_back_page.js"></script>
</body>
</html>