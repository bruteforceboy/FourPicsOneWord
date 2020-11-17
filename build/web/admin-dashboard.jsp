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
        <title>Admin</title>
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
                        <li>
                        <form action="logout" method="post">
                            <button type="submit" class="btn">LOGOUT</button>
                        </form>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>
        <div class="table-view">
            <c:choose>
                <c:when test="${notInserted eq true}">
                    <script>
                        alert("ERROR: Not Inserted Successfully")
                    </script>
                </c:when>    
                <c:when test="${notInserted eq false}">
                    <script>
                        alert("SUCESS: Inserted Successfully")
                    </script>
                </c:when>    
            </c:choose>
            <c:remove var="notInserted"/>
            <a href="add-puzzle.jsp">
                <button class="btn"><i class="fa fa-plus"></i>ADD PUZZLE</button>
            </a>
            <br/>
            <br/>
            <table id="t01">
                <tr>
                    <th>ID</th>
                    <th>PUZZLE ANSWER</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${puzzleList}" var="puzzle">
                    <tr>
                        <td>${puzzle.id}</td>
                        <td>${puzzle.answer}</td>
                        <td>
                            <form action="edit">
                                <input type="hidden" name="id" value=${puzzle.id}>
                                <button type="submit" class="btn"><i class="fa fa-edit"></i>EDIT</button>
                            </form>
                        </td>
                        <td>
                            <form action="delete" method="post" onsubmit="return confirmation();">
                                <input type="hidden" name="id" value=${puzzle.id}>
                                <button class="btn"><i class="fa fa-trash"></i>DELETE</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <script type="text/javascript">
            function confirmation() {
                if (confirm('Are you sure you want to delete?')) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </body>
</html>
