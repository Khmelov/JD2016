<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/header-html.jsp" %>

<div class="main container">
    <div class="row">
        <div class="col-sm-offset-3">
            <h2>Refill the account</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-4 control-label"># of account</label>
                    <div class="col-sm-8">
                        <p class="form-control-static">12345678</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="amount" class="col-sm-4 control-label">Amount</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <input type="text" class="form-control" id="amount">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Refill</button>
                            </span>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<p>Cmd Refilling: ${message}</p>

<%@ include file="include/end-html.jsp" %>