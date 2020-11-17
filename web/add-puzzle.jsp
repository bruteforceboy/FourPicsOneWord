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
        <title>Add Puzzle</title>
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
            <table id="t01" style="border: 0px">
                <form action="add-puzzle" method="post" enctype="multipart/form-data">
                <tr>
                    <td>
                        <img id="image1" alt="Puzzle Image 1" width="100" height="100" src="images/default.jpg"/>
                        <input type="file" name="image1" id="image1"
                               onchange="document.getElementById('image1').src = window.URL.createObjectURL(this.files[0])" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img id="image2" alt="Puzzle Image 2" width="100" height="100" src="images/default.jpg"/>
                        <input type="file" name="image2" id="image2"
                               onchange="document.getElementById('image2').src = window.URL.createObjectURL(this.files[0])" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img id="image3" alt="Puzzle Image 3" width="100" height="100" src="images/default.jpg"/>
                        <input type="file" name="image3" id="image3"
                               onchange="document.getElementById('image3').src = window.URL.createObjectURL(this.files[0])" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img id="image4" alt="Puzzle Image 4" width="100" height="100" src="images/default.jpg"/>
                        <input type="file" name="image4" id="image4"
                               onchange="document.getElementById('image4').src = window.URL.createObjectURL(this.files[0])" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="answer" id="answer" placeholder="answer" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                <center>
                    <input type="submit" value="ADD"/>
                </center>
                </td>
                </tr>
                </form>
            </table>
        </div>
    </body>
</html>
