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
        <title>Edit Puzzle</title>
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
                <form action="edit" method="post" enctype="multipart/form-data">
                    <tr>
                        <td>
                            <img alt="Puzzle Image 1" width="100" height="100" src="dbimages/${selectedPuzzle.image1}"/>
                            <input type="file" id="image1" name="image1" 
                                   onchange="document.getElementById('image1').src = window.URL.createObjectURL(this.files[0])">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img alt="Puzzle Image 2" width="100" height="100" src="dbimages/${selectedPuzzle.image2}"/>
                            <input type="file" id="image2" name="image2"
                                   onchange="document.getElementById('image2').src = window.URL.createObjectURL(this.files[0])">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img alt="Puzzle Image 3" width="100" height="100" src="dbimages/${selectedPuzzle.image3}"/>
                            <input type="file" id="image3" name="image3" 
                                   onchange="document.getElementById('image3').src = window.URL.createObjectURL(this.files[0])">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img alt="Puzzle Image 4" width="100" height="100" src="dbimages/${selectedPuzzle.image4}"/>
                            <input type="file" id="image4" name="image4" 
                                   onchange="document.getElementById('image4').src = window.URL.createObjectURL(this.files[0])">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" id="answer" name="answer" placeholder="${selectedPuzzle.answer}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                    <center>
                        <input type="hidden" name="id" id="id" value="${selectedPuzzle.id}"/>
                        <input type="submit" value="EDIT"/>
                    </center>
                    </td>
                    </tr>
                </form>
            </table>
        </div>
    </body>
</html>
