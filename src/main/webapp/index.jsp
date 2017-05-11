<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保鲜箱服务器</title>
</head>
<body>
<a href="user/list.do">查询注册用户</a>
<br>
<a href="box/list.do">查询所有箱子信息</a>
<br>
<a href="user/register.do?userName=lis&password=1">注册</a>

<br>
<a href="user/login.do?userName=admin&password=">登陆</a>

<br>
<a href="box/openbox.do?id=1&cmd=0">开/关锁</a>

<br>
<a href="box/searchbox.do?sn=11">查询箱子</a>

<br>
<a href="box/create.do?sn=11&address=2&time=2&temperature=5&humidity=8&open=1">插入箱子</a>
</body>
</html>