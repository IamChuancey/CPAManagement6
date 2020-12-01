<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
  <form  action="UpdateAuction?auctionid=${sessionScope.auction.auctionid}"  method="post">
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
          <dl>
            <dd >
              <label>名称：</label>
              <input type="text" class="inputh lf" value="${sessionScope.auction.auctionname}"  name="auctionname"/>
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input type="text" class="inputh lf" value="${sessionScope.auction.auctionstartprice}"  name="auctionstartprice"/>
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input type="text" class="inputh lf" value="${sessionScope.auction.auctionstarttime}" name="auctionstarttime"/>
              <div class="lf red laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input type="text" class="inputh lf" value="${sessionScope.auction.auctionendtime}" name="auctionendtime"/>
              <div class="lf red laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd class="dds">
              <label>描述：</label>
              <textarea cols="" rows="" class="textarea" name="auctiondesc"></textarea>
            </dd>
            <dd>
              <label>修改图片：</label>
              <div class="lf salebd"><a href="#"><img src="${sessionScope.auction.auctionpic}" width="100" height="100"  /></a></div>
               <input id="imgupload" type="file" class="offset10 lf"  name="auctionpic"/>
            </dd>
            <dd class="hegas">
                <input name="" type="submit" value="保 存" class="spbg buttombg buttombgs f14 lf buttomb" />
                <input name="" type="submit" value="取 消" class="spbg buttombg buttombgs f14 lf buttomb"  onclick="return false;"/>          
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
