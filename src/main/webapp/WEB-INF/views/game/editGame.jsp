<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <title>KKGames - News, Reviews, GAMES!</title>
    <meta charset="UTF-8">
    <meta name="description" content="KKGames - News, Reviews, GAMES!">
    <meta name="keywords" content="gaming, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link href="../../../resources/assets/img/favicon.ico" rel="shortcut icon"/>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i&display=swap"
          rel="stylesheet">

    <!-- Stylesheets -->
    <%@include file="../dynamic/css.jspf" %>


    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>
<!-- Page Preloder end -->


<!-- Content Row -->
<section class="vh-100 gradient-custom">
    <div class="row" style="margin-right: 0px">
        <div class="col-xl-8 col-md-8 mb-8">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <form method="post" action='<c:url value="/editGame/${id}"/>'>
                        <div class="form-group row">
                            <label class="col-2 col-form-label">Tytuł</label>
                            <div class="col-10">
                                <input class="form-control" type="text" name="gameTitle"
                                       placeholder="Tytuł" value="${editGamePost.gameTitle}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-2 col-form-label">Opis</label>
                            <div class="col-10">
                            <textarea class="textarea-adding" placeholder="Opis" name="description"
                                      rows="20"
                                      cols="80">${editGamePost.description}</textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-2 col-form-label">Ocena</label>
                            <div class="col-10">
                                <input class="form-control" type="text" name="rating"
                                       placeholder="Ocena gry z przedziału 1-100" value="${editGamePost.rating}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <input class="form-control" type="hidden" name="reviewAuthor"
                                   value="${editGamePost.reviewAuthor}">
                        </div>
                        <div class="form-group row">
                            <label class="col-2 col-form-label">Nazwa obrazka</label>
                            <div class="col-10">
                                <select name="file">
                                    <option selected="${editGamePost.file}">${editGamePost.file}</option>
                                    <c:forEach items="${allFiles}" var="imageTitle">
                                        <option>${imageTitle}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <input class="btn btn-success pull-right" type="submit" value="Wyślij" id="searchButton">
                    </form>
                    <input class="btn btn-cancel pull-right" type="submit" value="Anuluj"
                           onclick="window.location.href='/account'">
                </div>
            </div>
        </div>
    </div>
</section>


<!--====== Javascripts & Jquery ======-->
<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>