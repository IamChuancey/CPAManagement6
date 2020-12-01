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
  <form action="Register" method="post">
      <div class="zclf login logns">
        <h1  class="blue">用户注册</h1>
          <dl>
            <dd>
              <label> <small>*</small>用户名</label>
              <input type="text"  name="username" class="inputh lf" id="name" onfocus="ValueIsEmpty();" onblur="SearchUsername(); "/>
              <p id="message"></p>
            </dd>
            <dd>
              <label> <small>*</small>密码</label>
              <input type="text" name="userpassword" class="inputh lf" value="" />
           
            </dd>
           
            <dd>
              <label> <small>*</small>确认密码</label>
              <input type="text" class="inputh lf" value="" />
           
            </dd>
         
            <dd class="hegas">
              <label>&nbsp;</label>
              <input name="" type="submit" value="立即注册" class="spbg buttombg buttombgs f14 lf" />
            
            </dd>
          </dl>
    </div>
    </form>
<!-- main end-->
<!-- footer begin-->
</div>
 <!--footer end-->
<script type="text/javascript">
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

function SearchUsername() {
	var username=document.getElementById("name").value;
    //alert("nihao!");
	sendRequest("RegisterForm?username="+username);
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
			  var msg=xmlHttpRequest.responseXML.getElementsByTagName("msg")[0].firstChild.data;
			  if(msg=="existed")
				  {
				  var p=document.getElementById("message");
				  p.innerHTML="用户名已存在！";
				  var name=document.getElementById("name");
				  name.value="";
				  }
			  }
		  }
		  }
		  
function ValueIsEmpty() {
		 var p=document.getElementById("message");
		  p.innerHTML=" ";
		 }

</script>
</body>
</html>
