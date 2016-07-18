<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for=" ID пользователя">ID пользователя</label>
  <div class="col-md-4">
  <input id=" ID пользователя" name=" ID пользователя" type="text" placeholder="0" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Логин">Логин</label>
  <div class="col-md-4">
  <input id="Логин" name="Логин" type="text" placeholder="Введите логин" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Пароль">Пароль</label>
  <div class="col-md-4">
    <input id="Пароль" name="Пароль" type="password" placeholder="Введите пароль" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="E-mail">E-mail</label>
  <div class="col-md-4">
  <input id="E-mail" name="E-mail" type="text" placeholder="Введите e-mail" class="form-control input-md" required="">

  </div>
</div>

<!-- Button Drop Down -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Роль пользователя">Роль пользователя</label>
  <div class="col-md-4">
    <div class="input-group">
      <input id="Роль пользователя" name="Роль пользователя" class="form-control" placeholder="Выберите роль пользователя" type="text" required="">
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">

          <span class="caret"></span>
        </button>
        <ul class="dropdown-menu pull-right">
          <li><a href="#">Admin</a></li>
          <li><a href="#">Moder</a></li>
          <li><a href="#">User</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-success">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>