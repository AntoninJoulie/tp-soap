<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book</title>
</head>
<body>
<div align="center">
    <h1>Book List</h1>
    <h3><a href="/newBook">New Book</a></h3>
    <table border="1">
        <th>Id</th>
        <th>Title</th>
        <th>ISBN</th>
        <th>Publish year</th>

        <c:forEach var="book" items="${listBook}" varStatus="status">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.publishYear}</td>
                <td>
                    <a href="/editBook?id=${book.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deleteBook?id=${book.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>