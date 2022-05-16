<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ChenHao
  Date: 2022/5/16
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<td><input type="button" value="新增" id="add"><br>
<table border="1" cellspacing="0" width="80%">
    <tr>
                <th>序号</th>
                <th>品牌名称</th>
                <th>企业名称</th>
                <th>排序</th>
                <th>品牌介绍</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
    <c:forEach items="${brands}" var="brand" varStatus="count">

    <tr>
            <td>${count.index}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status ==1}">
                <td>启用</td>
            </c:if>

            <c:if test="${brand.status !=1}">
                <td>禁用</td>
            </c:if>

        <td><a href="/brandDemo/SelectByIdServlet?id=${brand.id}">修改</a>
            <a href="/brandDemo//DeleteServlet?id=${brand.id}">删除</a></td>

    </tr>
       </c:forEach>

    <script >
        document.getElementById("add").onclick = function () {
            location.href = "/brandDemo/add.html";
        }
    </script>

</body>
</html>
