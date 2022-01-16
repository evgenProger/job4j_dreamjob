<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Форма регистрации пользователей</title>
</head>
<body>

<h1>Регистрация посетителей</h1>

<form action="<%=request.getContextPath()%>/reg.do" method="post">
    Пользователь: <input type="text" name="user" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    Email: <input type="text" name="email"><br>
    <c:if test="${not empty error}">
        <div style="color:red; font-weight: bold; margin: 30px 0;">
            <c:out value="${error}"/>
        </div>
    </c:if>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="save" value="Сохранить">
            </small>
    </table>
</form>
</body>
</html>