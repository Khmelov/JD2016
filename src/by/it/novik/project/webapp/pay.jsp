<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/header-html.jsp" %>

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
                    <label for="dest" class="col-sm-4 control-label">Destination</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="dest" placeholder="First name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-4 control-label">Description</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="description" placeholder="Second name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="amount" class="col-sm-4 control-label">Amount</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="amount" placeholder="Phone">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-9 col-sm-3">
                        <button type="submit" class="btn btn-default">Pay</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<p>Cmd PAY: ${message}</p>

<%@ include file="include/end-html.jsp" %>