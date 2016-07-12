<%@ include file="include/begin-html.jsp" %>

<div class="container">

    <form class="form-horizontal" action=do?command=Accounts>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
                <form class="form-horizontal" action=do?command=Registration>
                <button type="submit" class="btn btn-default">Registration</button>
                </form>
            </div>
        </div>
    </form>

</div>

<p>Cmd GetAccounts: ${message}</p>

<%@ include file="include/end-html.jsp" %>