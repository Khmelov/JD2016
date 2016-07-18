<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <p>Login:<b>          ${user.login}</b></p>
    <br />
    <p>Email:<b>          ${user.email}</b></p>
    <br />

    <p><b>Мои объявления</b></p>
      <div class="row">
        <div class="col-md-1">№</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-3">Адрес</div>
        <div class="col-md-3">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>
      </div>
   <% Integer i=0; %>
   <c:forEach items="${ads}" var="ad">
      <br />
      <div class="row">
        <div class="col-md-1"><% out.print(++i); %></div>
        <div class="col-md-1">${ad.price} </div>
        <div class="col-md-3">${ad.address}</div>
        <div class="col-md-3">${ad.description}</div>
        <div class="col-md-1">${ad.roomCount}</div>
        <div class="col-md-1">${ad.area}</div>
        <div class="col-md-1">${ad.floor}</div>
        <div class="col-md-1">${ad.floors}</div>
      </div>
   </c:forEach>

<br />
<form class="form-horizontal" action="do?command=PROFILE" method="POST">
   <fieldset>
        <!-- Form Name -->
        <legend>Вы хотите завершенить сеанс?</legend>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Да, завершить.</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
