<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	 <div class="logout right"><a href="LogOut" title="注销">注销</a></div>
	 <div class="logout right"><a href="ExportExcel" title="导出excel" >导出excel</a></div>
	  <div class="logout right"><a href="add.jsp" title="发布">发布</a></div>
  </div>

  <div class="items" >
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
        <c:forEach items="${sessionScope.auctionlist }" var="item" varStatus="vs">
       <ul class="rows">
          <li><a href="AuctionU?acutionid=${item.auctionid}" title="">${item.auctiondesc}</a></li>
        <li class="list-wd">${item.auctionname}</li>
        <li>${item.auctionstarttime}</li>
        <li>${item.auctionendtime} </li>
        <li>${item.auctionstartprice}</li>
        <li class="borderno red"><a href="DeleteAuction?acutionid=${item.auctionid}" onclick="abc();">删除</a></li>
      </ul>
      </c:forEach>

      
      <div class="page">
        <a href="#" title="">首页</a>
        <a href="#" title="">上一页</a>
    
        <a href="#" title="">下一页</a>
        <a href="#" title="">尾页</a> 
      </div>
  </div>
  <script>
   function abc(){
	   
	   if(confirm("你真的确认要删除吗？请确认")){
	    
		   return true;
		 }
		 else{
			 return false;
			 }
			 
	   };
	   function dele(){
		   if(confirm("你真的确认要修改吗？请确认")){
			   return true;
			   }
			   else{
				   return false;
				   }
		   }
  </script>
<!-- main end-->
</div>
</body>
</html>
