<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Author</title>
</head>
<body>
<div align="center">
    <h1>Author List</h1>
    <h3><a href="/newAuthor">New Author</a></h3>
    <table border="1">
        <th>Id</th>
        <th>Birth</th>
        <th>First name</th>
        <th>Last name</th>

        <c:forEach var="author" items="${listAuthor}" varStatus="status">
            <tr>
                <td>${author.id}</td>
                <td>${author.birth}</td>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td>
                    <a href="/editAuthor?id=${author.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deleteAuthor?id=${author.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>