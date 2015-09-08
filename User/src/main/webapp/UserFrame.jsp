<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Список номерів</title>
        <link rel="stylesheet" href="css.css">
    </head>

    <body>
        <style>
             table {
                width: 14%;
                border-collapse: collapse;
             }
        </style>
        <form action="<c:url value="/edit"/>" method="POST">
            <input type="hidden" name="userId" value="${user.userId}"/>
            <table>
                <tr>
                    <td>Фамилия:</td><td><input type="text" name="surName" value="${user.surName}"/></td>
                </tr>
                <tr>
                    <td>Имя:</td><td><input type="text" name="firstName" value="${user.firstName}"/></td>
                </tr>
                <tr>
                    <td>Номер:</td><td><input type="text" name="number" value="${user.number}"/></td>
                </tr> 
            </table>
                    <input type="submit" value="OK" name="OK"/>
                    <input type="submit" value="Cancel" name="Cancel"/>
        </form>
    </body>
</html>