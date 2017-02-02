<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Data</title>
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
<h1 align="center">Book Detail</h1>
<a href="/books">Back to book's list</a>
<div id="centerlayer">
    <table style="align-items: center" border="2">
        <caption align="center">Book Detail</caption>
        <tr>
            <th>id</th>
            <th>Books Title</th>
            <th>Books Author</th>
            <th>Books price</th>
        </tr>

        <tr>
            <td>${book.id}</td>
            <td>${book.bookTitle}</td>
            <td>${book.bookAuthor}</td>
            <td>${book.bookPrice}</td>
        </tr>
    </table>
</div>