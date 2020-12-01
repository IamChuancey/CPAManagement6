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
  <form  action="AddAuction"  method="post">
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
          <dl>
            <dd >
              <label>名称：</label>
              <input type="text" class="inputh lf" value=""  name="auctionname"/>
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input type="text" class="inputh lf" value=""  name="auctionstartprice"/>
   
            </dd>
         
            <dd>
              <label>开始时间：</label>
              <input type="text" class="inputh lf" value="" name="auctionstarttime"/>
              
            </dd>
            <dd>
              <label>结束时间：</label>
              <input type="text" class="inputh lf" value=""  name="auctionendtime"/>
            
            </dd>
            <dd class="dds">
              <label>拍卖品图片：</label>
               <div class="lf salebd">  <input id="imgupload" type="file" class="offset10 lf"  name="auctionpic"/></div>
               
            </dd>
             <dd class="dds">
              <label>描述：</label>
              <textarea cols="" rows="" class="textarea" name="auctiondesc"></textarea>
            </dd>
            <dd class="hegas">
                <input name="" type="submit" value="保 存" class="spbg buttombg buttombgs buttomb f14 lf" />
                <input name="" type="submit" value="取 消" class="spbg buttombg buttombgs buttomb f14 lf"  onclick="return false;"/>
            </dd>
          </dl>
    </div>
   </form>
<!-- main end-->
<!-- footer begin-->
</div>
 <!--footer end-->

</body>
</html>
