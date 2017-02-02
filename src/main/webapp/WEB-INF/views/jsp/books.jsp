<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #centerlayer {
            position: absolute;
            width: 400px;
            height: 200px;
            left: 50%;
            top: 50%;
            margin-left: -150px;
            margin-top: -100px;
            padding: 10px;
            overflow: auto;
            background: #fc0;
            border: solid 1px;
        }
    </style>
</head>
<body>
<h1 align="center">List Book</h1>
<a href="/">Back to main menu</a>
<div id="centerlayer">
    <c:if test="${!empty bookList}">
        <table style="align-items: center" border="2">
            <caption align="center">Book List</caption>
            <tr>
                <th>id</th>
                <th>Books Title</th>
                <th>Books Author</th>
                <th>Books price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="/bookData/${book.id}" target="_blank">${book.bookTitle}</a></td>
                    <td>${book.bookAuthor}</td>
                    <td>${book.bookPrice}</td>
                    <td><a href="<c:url value="/edit/${book.id}"/>">Edit</a></td>
                    <td><a href="<c:url value="/remove/${book.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<h1>Add a Book</h1>

<c:url var="addAction" value="/addBook"/>
<form:form action="${addAction}" commandName="book">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="id" readonly="true"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="bookTitle">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="bookTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="bookAuthor">
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <form:input path="bookAuthor"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="bookPrice">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="bookPrice"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty book.bookTitle}">
                    <input type="submit" value="<spring:message text="Edit Book"/>"/>
                </c:if>

                <c:if test="${empty book.bookTitle}">
                    <input type="submit" value="<spring:message text="Add Book"/>"/>
                </c:if>

            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
