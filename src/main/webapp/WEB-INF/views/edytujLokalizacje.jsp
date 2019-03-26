<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stwórz Lokalizacje</title>
</head>

<body>

<form action="aktualizujLok" method="post">
    <pre>
    Id:           <input type="text" name="id" value="${lokalizacja.id}" readonly="true"/><br>
    Kod Pocztowy: <input type="text" name="kod"value="${lokalizacja.kod}"/><br>
    Nazwa:        <input type="text" name="nazwa"value="${lokalizacja.nazwa}"/><br>
    Rodzaj: Miasto<input type="radio" name="rodzaj" value = "MIASTO" ${lokalizacja.rodzaj=='MIASTO'?'checked':''}/>
            Wieś  <input type="radio" name="rodzaj" value = "WIES"${lokalizacja.rodzaj=='WIES'?'checked':''}/><br>
    <input type="submit" value="Zapisz">
    </pre>
</form>
</body>
</html>