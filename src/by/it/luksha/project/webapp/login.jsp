<%@ include file="include/begin-html.jsp" %>

<p>Cmd Login: ${message}</p>
<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Sign In</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="logininput">Login</label>
            <div class="col-md-4">
                <input id="logininput" name="logininput" type="text" placeholder="Your login" class="form-control input-md">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput">Password</label>
            <div class="col-md-4">
                <input id="passwordinput" name="passwordinput" type="password" placeholder="Your pass" class="form-control input-md">

            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="button1id"></label>
            <div class="col-md-8">
                <button id="button1id" name="button1id" class="btn btn-success">Sign In</button>
                <button id="button2id" name="button2id" class="btn btn-info">Registry</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>