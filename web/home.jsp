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
        <title>FourPicsOneWord</title>
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
        <main>

            <c:if test="${incorrect eq true}">
                <script>
                    alert("Incorrect");
                </script>
                <c:remove var="incorrect"/>
            </c:if>
            <button class="btn" id="myBtn"><i class="fa fa-question"></i>HELP</button>
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <div class="modal-header">
                        <span class="close">&times;</span>
                        <h2>Four Pics One Word</h2>
                    </div>
                    <div class="modal-body">
                        <p>4 Pics 1 Word's gameplay is very simple: each level displays four pictures linked by one word - 
                            the player's aim is to work out what the word is, from a set of letters given below the pictures.
                        </p>
                    </div>
                </div>
            </div>
            <span style="float:right; color: white;">
                <h2> SCORE: ${score} </h2>
            </span>
            <table>
                <tr>
                    <td><img src="dbimages/${currentPuzzle.image1}" width="250px" height="250px" style="border-radius: 20px"/></td>
                    <td><img src="dbimages/${currentPuzzle.image2}" width="250px" height="250px" style="border-radius: 20px"/></td>
                </tr>
                <tr>
                    <td><img src="dbimages/${currentPuzzle.image3}" width="250px" height="250px" style="border-radius: 20px"/></td>
                    <td><img src="dbimages/${currentPuzzle.image4}" width="250px" height="250px" style="border-radius: 20px"/></td>
                </tr>
            </table>
            <br/>
            <center>
                <form action="index.jsp" method="post" onsubmit="return validate()">
                    <input type="text" name="user-answer" id="user-answer" placeholder="answer">
                    <button type="button" class="btn" onClick="window.location.reload()">SKIP</button>
                    <button type="submit" class="btn"><i class="fa fa-play"></i>PLAY</button>
                </form>
            </center>
        </main>
        <br/>
        <footer class="site-footer">
            <div class="social-wrapper">
                <ul>
                    <li>
                        <a href="#" target="_blank">
                            <img src="./images/twitter-128.png" alt="Twitter Logo" class="twitter-icon">
                        </a>
                    </li>
                    <li>
                        <a href="#" target="_blank">
                            <img src="./images/instagram-icon.png" alt="Instagram Logo" class="instagram-icon">
                        </a>
                    </li>
                    <li>
                        <a href="#" target="_blank">
                            <img src="./images/facebook.ico" alt="Facebook Logo" class="facebook-icon">
                        </a>
                    </li>
                    <li>
                        <a href="#" target="_blank">
                            <img src="./images/Google-plus-icon.png" alt="Googleplus Logo" class="googleplus-icon">
                        </a>
                    </li>
                    <li>
                        <a href="#" target="_blank">
                            <img src="./images/youtube.png" alt="Youtube Logo" class="youtube-icon">
                        </a>
                    </li>
                    <li>
                        <a href="#" target="_blank">
                            <img src="./images/Foursquare-2.ico" alt="Foursquare Logo" class="foursquare-icon">
                        </a>
                    </li>
                </ul>
            </div>
            <nav class="footer-nav" role="navigation">
                <p>Copyright &copy; 2020-2021 FourPicsOneWord. All rights reserved.</p>
            </nav>
        </footer>
        <script>
            if (window.history.replaceState) {
                window.history.replaceState(null, null, window.location.href);
            }

            var modal = document.getElementById("myModal");
            var btn = document.getElementById("myBtn");
            var span = document.getElementsByClassName("close")[0];
            btn.onclick = function () {
                modal.style.display = "block";
            }
            span.onclick = function () {
                modal.style.display = "none";
            }
            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }

            function validate() {
                var answer = document.getElementById('user-answer').value;
                if (answer == "") {
                    alert("Enter you answer!");
                    return false;
                }
                return true;
            }
        </script>
    </body>
</html>