<%@ include file="include/begin-html.jsp" %>

<div class="main container">
    <div class="row">
        <div class="col-sm-offset-3">
            <h2>Registration form</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="name" class="col-sm-4 control-label">First name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" placeholder="First name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="middle" class="col-sm-4 control-label">Middle name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="middle" placeholder="Middle name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="second" class="col-sm-4 control-label">Second name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="second" placeholder="Second name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="mobile" class="col-sm-4 control-label">Phone</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="mobile" placeholder="Phone">
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-4 control-label">Address</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="address" placeholder="Address">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-4 control-label">Email</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="email" placeholder="E-mail">
                    </div>
                </div>
                <div class="form-group">
                    <label for="passport" class="col-sm-4 control-label">Passport</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="passport" placeholder="Passport">
                    </div>
                </div>
                <div class="form-group">
                    <label for="login" class="col-sm-4 control-label">Login</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="login" placeholder="Login">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-4 control-label">Password</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="password" placeholder="Password">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Registration</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<p>Cmd Registration: ${message}</p>

<%@ include file="include/end-html.jsp" %>