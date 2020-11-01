<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Author</title>
</head>
<body>
<div align="center">
    <h1>New/Edit Author</h1>
    <form:form action="saveAuthor" method="post" modelAttribute="author">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Birth:</td>
                <td><form:input path="birth" /></td>
            </tr>
            <tr>
                <td>First name:</td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>