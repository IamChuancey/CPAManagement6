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
    <div class="logout right"><a href="LogOut" title="注销">注销</a></div>
  </div>
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${sessionScope.auction.auctionname}</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${sessionScope.auction.auctiondesc}</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno">${sessionScope.auction.auctionstarttime}</li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno">${sessionScope.auction.auctionendtime}</li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li class="borderno">${sessionScope.auction.auctionstartprice}</li>
      </ul>
  </div>
  <div class="rg borders"><img src="${sessionScope.auction.auctionpic}" width="250" height="200" alt="" /></div>
  <div class="cl"></div>
  <div class="top10 salebd">
       <p>
       <label for="sale">出价：</label>
       <input type="text"  class="inputwd" id="sale" value="${sessionScope.maxprice}"/>
       <input name="" type="submit" value="竞 拍" class="spbg buttombg f14  sale-buttom"  onclick="Auction()"/>
       </p>
       <p class="f14 red">不能低于最高竞拍价</p>
  </div>
  <div class="top10">
   <form action="AuctionRecord?acutionid=${sessionScope.acutionid}" method="post">
    <input name="" type="submit" value="刷 新" class="spbg buttombg f14" />
    <input name="" type="submit" value="返回列表" class="spbg buttombg f14"  onclick="window.location.href='list.jsp';return false;"/>
  </form>
  </div>
  <div class="offer">
    <h3>出价记录</h3>
    <div class="items sg-font">
      <ul class="rows even strong">
        <li>竞拍时间</li>
        <li>竞拍价格</li>
        <li class="borderno">竞拍人</li>
      </ul>
      <c:forEach items="${sessionScope.record}" var="item" >
      <ul class="rows">
        <li>${item.auctiontime}</li>
        <li>${item.auctionprice }</li>
        <li class="borderno">${item. username}</li>
      </ul>
      </c:forEach>
  </div>
  </div>
<!-- main end-->
</div>
<script type="text/javascript">
function  Auction(){
	var username="<%=session.getAttribute("username")%>"; 
	var acutionid="<%=session.getAttribute("acutionid")%>";
	var acutionprice=document.getElementById("sale").value;
	/* alert(username);
	alert(acutionid);
	alert(acutionprice); */
	sendRequest("AuctionRecordUpdate?username="+username+"&acutionid="+acutionid+"&acutionprice="+acutionprice);
}
var xmlHttpRequest;
function createXMLHttpRequest() {
	if(window.XMLHttpRequest){
		//非IE浏览器
		xmlHttpRequest=new XMLHttpRequest();
	}else if(window.ActiveObject){
		//IE6及以上浏览器
		xmlHttpRequest=new ActiveObject("Msxml12.XMLHTTP");
	}else{
		//IE6以下浏览器
		xmlHttpRequest=new ActiveObject("Microsoft.XMLHTTP");
	}
}
function sendRequest(url){
	createXMLHttpRequest();
	xmlHttpRequest.open("GET",url,true);
	xmlHttpRequest.onreadystatechange=processResponse;
	xmlHttpRequest.send();
}
function processResponse() {
	  if(xmlHttpRequest.readyState==4){
		  if(xmlHttpRequest.status==200){
			  var msn=xmlHttpRequest.responseXML.getElementsByTagName("msn")[0].firstChild.data;
			  alert(msn);
			  }
		  }
		  }
</script>
</body>
</html>
