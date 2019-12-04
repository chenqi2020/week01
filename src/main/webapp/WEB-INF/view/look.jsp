<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/index3.css" rel="stylesheet">
</head>
<body>
	<fm:form action="add" method="post" modelAttribute="users">
	名称:<fm:input path="uname"/>
	</br>
	时间:<fm:input path="dates"/>
	</br>
	商品:<c:forEach items="${shop}" var="get">
	<input type="checkbox" name="sid" value="${get.sid}">${get.sname}
	</c:forEach>
	</br>

	</fm:form>

</body>
<script type="text/javascript">
	$.post(
	"getsc",
	{sid:$[name='sid'].val()},
	function(json) {
		var getsc=json.getsc;
		for(var i in getsc){
			$("[name='sid'][value='"+getsc[i].sid+"']").attr("checked",true);
		}
	},"json"
	)
</script>
</html>