<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Список номерів</title>
        <link rel="stylesheet" href="css.css">
    </head>

    <body>
        <form action="<c:url value="/main"/>" method="POST">
            <b>Список номерів:</b>
            <br/>
            <table>
                <tr>
                    <th>&nbsp;</th>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Номер</th>
                </tr>
                <c:forEach var="user" items="${form.users}">
                <tr>
                    <td><input type="radio" name="userId" value="${user.userId}"></td>
                    <td><c:out value="${user.surName}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.number}"/></td>
                </tr>
                </c:forEach>
            </table>
                    <input type="submit" value="Add" name="Add"/>
                    <input type="submit" value="Edit" name="Edit"/>
                    <input type="submit" value="Delete" name="Delete"/>
        </form>
    </body>

</html>