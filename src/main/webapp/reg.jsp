<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Форма регистрации пользователей</title>
    <script>
        function validate() {
            if (($('#User').val()) === "") {
                alert($('#User').attr('title'));
                return false;
            }
            if (($('#Password').val()) === "") {
                alert($('#Password').attr('title'));
                return false;
            }
            if (($('#Email').val()) === "") {
                alert($('#Email').attr('title'));
                return false;
            }
        }
    </script>
</head>
<body>

<h1>Регистрация посетителей</h1>

<form action="<%=request.getContextPath()%>/reg.do" method="post">
    <div class="form-group">
        <label>
            Пользователь:
        </label>
        <input type="text" class="form-control" name="User" id="User" title="Заполните поле Пользователь">
    </div>
    <div class="form-group">
        <label>
            Пароль:
        </label>
        <input type="text" class="form-control" name="Password" id="Password" title="Заполните поле Пароль">
    </div>
    <div class="form-group">
        <label>
            Email:
        </label>
        <input type="text" class="form-control" name="Email" id="Email" title="Заполните поле Email">
    </div>

    <button type="submit" class="btn btn-primary" onclick="return validate();">Зарегистрироваться</button>


</form>
<c:if test="${not empty error}">
    <div style="color:red; font-weight: bold; margin: 30px 0;">
        <c:out value="${error}"/>
    </div>
</c:if>
</body>
</html>