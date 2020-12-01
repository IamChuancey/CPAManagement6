<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"> <a href="LogOut" title="注销">注销</a></div>
  </div>

  <div class="items">
      <ul class="rows even strong">
        <li>序号</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
      <c:forEach items="${sessionScope.auctionlist }" var="item" varStatus="vs">
       <ul class="rows">
        <li><a href="auction.jsp" title="">${item.auctiondesc}</a></li>
        <li class="list-wd">${item.auctionname}</li>
        <li>${item.auctionstarttime}</li>
        <li>${item.auctionendtime} </li>
        <li>${item.auctionstartprice}</li>
        <li class="borderno red"><a href="AuctionRecord?acutionid=${item.auctionid}">竞拍</a></li>
      </ul>
      </c:forEach>
      
        <!-- <ul class="rows even">
        <li><a href="auction.jsp" title="">国书</a></li>
        <li class="list-wd">明国藏书</li>
        <li>2010-01-20 12:30:30</li>
        <li>2010-09-08 12:30:30</li>
        <li>2,000</li>
        <li class="borderno red"><a href="auction.jsp">竞拍</a></li>
      </ul> -->
    <div class="page">
        <a href="#" title="">首页</a>
        <a href="#" title="">上一页</a>
      
        <a href="#" title="">下一页</a>
        <a href="#" title="">尾页</a> 
      </div>
  </div>
<!-- main end-->
</div>
</body>
</html>
