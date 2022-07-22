<%-- 
    Document   : index
    Created on : 4 Jul, 2022, 3:38:49 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="./MineServlet">
            Name<input type="text" name="txtName">
            </input>
            Id<input type="text" name="txtCode">
            </input>
            <br>
            <input type="submit" name="add" value="add">
            </input>
            <input type="submit" name="search" value="search">
            </input>
            <input type="submit" name="delete" value="delete">
            </input>
        </form>
    </body>
</html>
