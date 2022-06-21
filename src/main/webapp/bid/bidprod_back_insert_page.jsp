<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibani.bookmall.web.bid_prod.entity.*"%>
<%@ page import="com.tibani.bookmall.web.book.dao.*"%>
<%@ page import="com.tibani.bookmall.web.book.entity.*"%>
<%@ page import="java.util.*"%>



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
<!-- <link rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/bid/css/bidprod_back_page.css"> --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bid/css/bidprod_back_insert_page.css">
</head>
<body>
	<%@include file="/template/back_layout_aside.jsp"%>
	<header class="header">
		<h1 class="text-center"
			style="font-size: 32px; font-weight: 600; color: rgb(82, 136, 138)">競標商品管理</h1>
	</header>

	<main class="main">
		<div class="container p-5">
			<div class="row align-items-center">
				<div class="mb-2  p-1 col-1"
					style="background-color: steelblue; width: 60px; border-radius: 5px;">
					<a class="text-light text-center" style="text-decoration: none;"
						href="bidprod_back_page.jsp"> &lt; 上一頁</a>	
				</div>
				<div class="col-6 text-success font-weight-bold" style="font-size: 1.3rem">${passMsgs.success} ${passMsgs.state}</div>
			</div>
			<hr>
			
			
				<form method="post" action="bid.do" name="form1">
					<div class="mb-2" style="font-size: 22px; font-weight:600;">新增競標商品</div>
					
					<div class="row mb-3 align-items-center">
						<div class="col-2">書籍名稱:</div>
						<div class="col-4">
							<jsp:useBean id="bookSc" scope="page" class="com.tibani.bookmall.web.book.dao.BookService" />
							<select size=1 name="bookID" class="form-control">
								<c:forEach var="book" items="${bookSc.all}">
									<option value="${book.bookID}" ${(param.bookID==book.bookID)? 'selected':'' }>${book.title}								
								</c:forEach>
							</select>
<%-- 							<input class="bid-input form-control" type="text" name="bookID" value="${param.bookID}"> --%>
						</div>
						<div class="col-4 err">${errorMsgs.bookID}</div>
					</div>

					<div class="row mb-3 align-items-center">
						<div class="col-2">競標底價: (必填)</div>
						<div class="col-4">
							<input class="bid-input form-control" type="text" name="startPrice" value="${param.startPrice}">
						</div>
						<div class="col-4 err">${errorMsgs.startPrice}</div>
					</div>

					<div class="row mb-3 align-items-center">
						<div class="col-2">直購價: (必填)</div>
						<div class="col-4">
							<input class="bid-input form-control" type="text" name="bidDirectPrice" value="${param.bidDirectPrice}">
						</div>
						<div class="col-4 err">${errorMsgs.bidDirectPrice}</div>	
					</div>




<!-- 					<div class="row mb-3"> -->
<!-- 						<div class="col-2">商品狀態:</div> -->
<!-- 						<div class="col-4"> -->
<!-- 							<select class="bid-input form-control" size="1" name="bid_prod_stat"> -->
<!-- 								<option selected>選擇商品狀態</option> -->
<!-- 								<option>0-安排競標</option> -->
<!-- 								<option>1-待上架</option> -->
<!-- 								<option>2-標案進行中</option> -->
<!-- 								<option>3-結標售出</option> -->
<!-- 								<option>4-流標</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<div class="row mb-3 align-items-center">
						<div class="col-2">起標時間:</div>
						<div class="col-4">
							<input class="bid-input form-control" type="text" name="bidStart"
							 id="date1">
						</div>
						<div class="col-4 err">${errorMsgs.bidStart}</div>
					</div>
					<div class="row mb-3 align-items-center">
						<div class="col-2">結標時間:</div>
						<div class="col-4">
							<input class="bid-input form-control" type="text" name="bidEnd" 
								id="date2">
						</div>
						<div class="col-4 err">${errorMsgs.bidEnd}</div>
					</div>
					<br>
					<input type="hidden" name="action" value="insert">
					<input class="bid-input form-control" type="submit" value="送出新增" style="margin-left: 300px; width: 120px; background-color: wheat;">
					<br>
				</form>
		</div>
		
		<br>
		<br>
		<br>
		<br>
		<br>
		
	</main>
</body>
<% 
  java.sql.Timestamp bidStart = null;
  try {
	    bidStart = java.sql.Timestamp.valueOf(request.getParameter("bidStart").trim());
	    System.out.println(bidStart);
	    
   } catch (Exception e) {
	   bidStart = new java.sql.Timestamp(System.currentTimeMillis());
   }
  java.sql.Timestamp bidEnd = null;
  try {
	    bidEnd = java.sql.Timestamp.valueOf(request.getParameter("bidEnd").trim());
	    System.out.println(bidEnd);
   } catch (Exception e) {
	   bidEnd = new java.sql.Timestamp(System.currentTimeMillis());
   }

%>



<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>



<script>
$.datetimepicker.setLocale('zh'); // kr ko ja en
$(function(){
	 $('#date1').datetimepicker({
	 closeOnWithoutClick :false,
	  format:'Y-m-d H:00:00',
	  allowTimes: [
		  '12:00'
	  ],
	  defaultTime: '12:00',
	  onShow:function(){
	   this.setOptions({
	    maxDate:$('#date2').val()?$('#date2').val():false
	   })
	  },
	  timepicker: true,
      values:'<%=bidStart%> ' 
	 });
	 
	 $('#date2').datetimepicker({
	 closeOnWithoutClick :false,
	  format:'Y-m-d H:00:00',
	  allowTimes: [
		  '22:00'
	  ],
	  defaultTime: '22:00',
	  onShow:function(){
	   this.setOptions({
	    minDate:$('#date1').val()?$('#date1').val():false
	   })
	  },
	  timepicker:true,
	  values:'<%=bidEnd%> ' 
	 });
});

		//1.以下為某一天之前的日期無法選擇
		let somedate1 = new Date();
		$('#date1').datetimepicker({
		    beforeShowDay: function(date) {
		  	  if (  date.getYear() <  somedate1.getYear() || 
			           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
			           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate() + 1)
		        ) {
		             return [false, ""]
		        }
		        return [true, ""];
		}});


</script>
</html>