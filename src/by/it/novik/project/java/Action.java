package by.it.novik.project.java;


enum Action {
    REGISTRATION {
        {
            this.command = new CommandRegistration();
            this.inPage="/reg.jsp";
            //this.okPage ="/index.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.inPage="/index.jsp";
            //this.okPage ="/main.jsp";
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.inPage="/index.jsp";
            //this.okPage ="/index.jsp";
        }
    },
    ACCOUNTS {
        {
            this.command = new CommandGetAccounts();
            this.inPage="/accounts.jsp";
            //this.okPage ="/index.jsp";
        }
    },
    PAYMENTS {
        {
            this.command = new CommandGetPayments();
            this.inPage="/payments.jsp";
            //this.okPage ="/index.jsp";
        }
    },
    PAY {
        {
            this.command = new CommandPay();
            this.inPage="/pay.jsp";
            //this.okPage ="/index.jsp";
        }
    },
    REFILL {
        {
            this.command = new CommandRefilling();
            this.inPage="/refill.jsp";
            //this.okPage ="/index.jsp";
        }
    },
    BLOCK {
        {
            this.command = new CommandBlocking();
            this.inPage="/block.jsp";
            //this.okPage ="/index.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandLogout();
        }
    };
    public String inPage="/error.jsp";
    //public String okPage ="/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

    public static final String msgError="msg_error";
    public static final String msgMessage="message";

}