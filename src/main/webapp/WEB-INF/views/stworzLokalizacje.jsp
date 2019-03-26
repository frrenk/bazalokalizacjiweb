<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stwórz Lokalizacje</title>
</head>

<body>

<form action="zapiszLok" method="post">
    <pre>
    Id:           <input type="text" name="id"/><br>
    Kod Pocztowy: <input type="text" name="kod"/><br>
    Nazwa:        <input type="text" name="nazwa"/><br>
    Rodzaj: Miasto<input type="radio" name="rodzaj" value = "MIASTO"/>
            Wieś  <input type="radio" name="rodzaj" value = "WIES"/><br>
    <input type="submit" value="Zapisz">
    </pre>
</form>
${msg}

<a href="pokazLokalizacje">Pokaż wszystkie</a>
</body>
</html>