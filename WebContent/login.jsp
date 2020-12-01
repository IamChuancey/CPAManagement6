<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 <div class="main">
   <div class="sidebarg fnone">
     <form action="Login" method="post" >
    <div class="login">
      <dl>
        <dt>用户登陆</dt>
        <dd><label for="name">用户名：</label><input type="text" class="inputh" name="username" id="name" /></dd>
        <dd><label for="password">密 码：</label><input type="text" class="inputh" name="userpassword" id="password"/></dd>
       <dd><p id="message">${requestScope.msg}</p></dd>
       
         <dd class="buttom">
           <input name="" type="submit" value="登 录" class="spbg buttombg buttomb f14 lf" />
           <input name="" type="submit" value="注 册" class="spbg buttombg buttomb f14 lf"  onclick="window.location.href='reg.jsp' ; return false;" />
  
           <div class="cl"></div>
        </dd>
       
      </dl>
    </div>
    </form>
   </div>
  <div class="cl"></div>
 </div>
<!-- main end-->
 
<!-- footer begin-->
</div>
 <!--footer end-->

</body>
</html>
