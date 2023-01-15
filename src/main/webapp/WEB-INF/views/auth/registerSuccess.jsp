<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../dynamic/css.jspf" %>

<html lang="pl-PL">
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <div class="mb-md-5 mt-md-4 pb-5">
                            <a href="/">
                                <img src="/resources/assets/img/logo.png" class="login-register-logo" alt="KKGAMES Logo">
                            </a>
                            <p class="text-white-50 mb-5">Konto zarejestrowano pomyślnie!</p>
                            <form class="user" method="post" action='<c:url value="/login"/>'>
                            </form>
                        </div>
                        <div>
                            <p class="mb-0"><a href="/login">Przejdź do strony logowania<br></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="../dynamic/javaScript.jspf" %>

</section>
</html>