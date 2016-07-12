<%@ include file="include/begin-html.jsp" %>

<p>Cmd SIGN-UP: ${message}</p>
<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Sign Up</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="logininput">Login</label>
            <div class="col-md-4">
                <input id="logininput" name="logininput" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="emailinput">Email</label>
            <div class="col-md-4">
                <input id="emailinput" name="emailinput" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput">Password</label>
            <div class="col-md-4">
                <input id="passwordinput" name="passwordinput" type="password" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="registrationbutton"></label>
            <div class="col-md-4">
                <button id="registrationbutton" name="registrationbutton" class="btn btn-primary">Sign Up</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>


