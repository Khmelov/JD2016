<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<main>
    <div class="container">
        <form class="form-horizontal" action="do?command=SignIn" method="POST">
            <fieldset>

                <!-- Form Name -->
                <legend>Авторизация пользователя</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Login">Логин</label>
                    <div class="col-md-4">
                        <input id="Login" name="Login" type="text" placeholder=""
                               class="form-control input-md">
                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Password">Пароль</label>
                    <div class="col-md-4">
                        <input id="Password" name="Password" type="password" placeholder=""
                               class="form-control input-md">
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton"></label>
                    <div class="col-md-4">
                        <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
                        <a class="btn btn-primary" href="do?command=SignUp">Регистрация</a>
                    </div>
                </div>


            </fieldset>
        </form>
    </div>
</main>

<%@ include file="include/end-html.jsp" %>