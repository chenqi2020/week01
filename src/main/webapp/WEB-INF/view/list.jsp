<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/score/js/jquery-1.8.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/score/css/index3.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function add() {
		location="toAdd";
	}
	function qx() {
		$("[name='ck']").attr("checked",true);
	}
	function qbx() {
		$("[name='ck']").attr("checked",false);
	}
	function fx() {
		$("[name='ck']").each(function() {
			this.checked=!this.checked;
		})
	}
	function ps() {
		var uid=[];
		$("[name='ck']:checked").each(function() {
			uid.push($(this).val());
		})
		alert(uid);
		if(uid.length>0){
				if(confirm("确定删除!")){
					alert("成功");
					location="dele?uid="+uid;
				}		
		}else{
			alert("至少删除一个");
		}
	}
</script>
<body>
	<center>
	<form action="list" method="post">
	模糊:<input type="text" name="uname">
	<input type="submit" value="查询">
	</form>
	
	<input type="button" value="添加" onclick="add()">
	<table border="1">
	<tr>
		<td>
		<input type="button" value="全选" onclick="qx()">
		<input type="button" value="全不选" onclick="qbx()">
		<input type="button" value="反全选" onclick="fx()">
		<input type="button" value="批删" onclick="ps()">
		</td>
		<td>编号</td>
		<td>店铺名</td>
		<td>创建时间</td>
		<td>销售商品</td>
		<td>操作</td>
	</tr>
		<c:forEach items="${list}" var="ll">
		<tr>
		<td>
		<input type="checkbox" value="${ll.uid}" name="ck">
		</td>
		<td>${ll.uid}</td>
		<td>${ll.uname}</td>
		<td>${ll.dates}</td>
		<td>
		<c:forEach items="${ll.shop}" var="s">
		${s.sname}
		</c:forEach>
		</td>
		<td>
		<a href="get?uid=${ll.uid}">详情</a>
		</td>
	</tr>
		</c:forEach>
		
		<tr>
		<td colspan="11">
		<a href="list?pageNum=1">首页</a>
		<a href="list?pageNum=${info.prePage}">上一页</a>
		<a href="list?pageNum=${info.nextPage}">下一页</a>
		<a href="list?pageNum=${info.pages}">尾页</a>
		</td>
		</tr>
	</table>
 </center>
</body>
</html>