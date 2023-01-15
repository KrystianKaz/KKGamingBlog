<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../dynamic/css.jspf" %>

<html lang="pl-PL">
<!-- Page Preloder -->
<div id="preloder">
  <div class="loader"></div>
</div>
<!-- Page Preloder end -->
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
              <h2 class="fw-bold mb-2 text-uppercase">Witaj</h2>
              <p class="text-white-50 mb-5">Wprowadź dane, aby się zalogować</p>
              <c:if test="${param.error != null}">
                <h5 class="mb-4 pb-3" style="color: red"><c:out
                        value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></h5>
              </c:if>
              <form class="user" method="post" action='<c:url value="/login"/>'>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user"
                         id="exampleInputEmail"
                         name="username" aria-describedby="emailHelp"
                         placeholder="Wprowadź swój login...">
                </div>
                <div class="form-group">
                  <input type="password" class="form-control form-control-user"
                         id="exampleInputPassword" name="password" placeholder="Hasło">
                </div>
                <button class="btn btn-outline-light btn-lg px-5" type="submit">Zaloguj</button>
              </form>
            </div>

            <div>
              <p class="mb-0">Nie jesteś jeszcze zarejestrowany?<br><a href="/register" class="text-white-50 fw-bold">Utwórz konto!</a>
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