<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Login</title>
    </head> 
    <body>
        <header>
            <div class="nav-container">
                <div class="logo-box">
                    <a href="index.jsp">
                        <img src="images/FourChooseOne.png" height="75px">
                    </a>
                </div>
                <nav>
                    <ul>
                        <li><a href="index.jsp"> HOME </a></li>
                        <li><a href="login.jsp"> LOGIN </a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div class="login-page">
            <div class="form">
                <form action="login" method="post" class="login-form">
                    <c:if test="${loginError eq true}">
                        <p style="color:red; font-size: 13px">Invalid Username/Password</p>
                        <c:remove var="loginError"/>
                    </c:if>
                    <i class="fa fa-user"></i><input type="text" name="username" id="username" placeholder="username" required/>
                    <br/>
                    <i class="fa fa-key"></i><input type="password" name="password" id="password" placeholder="password" required/>
                    <button type="submit" class="btn">login</button>
                </form>
            </div>
        </div>
    </body>
</html>
