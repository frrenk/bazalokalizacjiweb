<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pokaż Lokalizacje</title>
</head>

<body>

<h2>Lokalizacje:</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Kod</th>
        <th>Nazwa</th>
        <th>Rodzaj</th>
    </tr>


        <c:forEach items="${lokalizacje}" var="lokalizacja">
    <tr>
        <td>${lokalizacja.id}</td>
        <td>${lokalizacja.kod}</td>
        <td>${lokalizacja.nazwa}</td>
        <td>${lokalizacja.rodzaj}</td>
        <td><a href="usunLokalizacje?id=${lokalizacja.id}">Usuń Lokalizację</a> </td>
        <td><a href="aktualizujLokalizacje?id=${lokalizacja.id}">Aktualizuj Lokalizację</a> </td>
    </tr>
        </c:forEach>
</table>
<br><br>
<a href="pokazStworz">Dodaj Lokalizację</a>

</body>

</html>
