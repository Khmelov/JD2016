<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Прокат автомобилей</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="padding:1%">

<header>
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/luksha">Главная</a></li>
                        <li><a href="do?command=SignIn">Войти</a></li>
                        <li><a href="#">Контакты</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Админка<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="do?command=AddUser">Добавить пользователя</a></li>
                                <li><a href="do?command=AddCar">Добавить автомобиль</a></li>
                                <li><a href="do?command=AddOrder">Добавить заказ</a></li>
                                <li class="divider"></li>
                                <li><a href="do?command=ShowAllUsers">Просмотреть всех пользователей</a></li>
                                <li><a href="do?command=ShowAllOrders">Просмотреть все заказы</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>